package net.shangtech.eshop.product.service.impl;

import java.util.LinkedList;
import java.util.List;

import net.shangtech.eshop.product.dao.CategoryDao;
import net.shangtech.eshop.product.entity.Category;
import net.shangtech.eshop.product.service.CategoryService;
import net.shangtech.framework.service.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

@Service
@Transactional
public class CategoryServiceImpl extends BaseService<Category> implements CategoryService {
	
	@Autowired private CategoryDao dao;
	
	@Override
	public void update(Category category){
		Assert.notNull(category);
		Assert.notNull(category.getId());
		Category old = dao.find(category.getId());
		if(old != null){
			old.setCode(category.getCode());
			old.setName(category.getName());
			old.setPriority(category.getPriority());
			old.setVersion(category.getVersion());
			dao.update(old);
		}
	}
	
	@Override
	public void save(Category entity) {
		Category old = dao.findOneByProperty("code", entity.getCode());
		if(old != null){
			entity.setId(old.getId());
			return;
		}
		dao.save(entity);
		entity.setPath(entity.getId().toString());
		Category parent = dao.find(entity.getParentId());
		if(parent != null){
			entity.setPath(parent.getPath() + Category.PATH_SEPARATOR + entity.getPath());
		}
		dao.update(entity);
	}
	
	@Override
	public void delete(long id){
		Category category = dao.find(id);
		if(category != null){
			Category parent = dao.find(category.getParentId());
			dao.delete(id);
			if(parent != null){
				List<Category> brothers = dao.findByParentId(parent.getId());
				if(CollectionUtils.isEmpty(brothers)){
					parent.setLeaf(true);
					dao.update(parent);
				}
			}
		}
	}

	@Override
    public Category findAllCategory() {
		Category root = new Category();
		root.setId(Category.ROOT_CATE_ID);
		LinkedList<Category> list = new LinkedList<Category>();
		list.add(root);
		
		Category temp = null;
		while(!list.isEmpty()){
			temp = list.remove();
			List<Category> children = dao.findByParentId(temp.getId());
			if(!CollectionUtils.isEmpty(children)){
				temp.setChildren(children);
				list.addAll(children);
			}
		}
	    return root;
    }
}
