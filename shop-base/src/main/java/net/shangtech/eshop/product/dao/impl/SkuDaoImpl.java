package net.shangtech.eshop.product.dao.impl;

import net.shangtech.eshop.product.dao.SkuDao;
import net.shangtech.eshop.product.entity.Sku;
import net.shangtech.framework.orm.dao.hibernate.BaseDao;
import net.shangtech.framework.orm.dao.support.Pagination;

import org.springframework.stereotype.Repository;

@Repository
public class SkuDaoImpl extends BaseDao<Sku> implements SkuDao {

	@Override
    public Sku findByVid(String vid) {
	    return findOneByProperty("vid", vid);
    }

	@Override
    public Sku findByCode(String code) {
	    return findOneByProperty("code", code);
    }

	@Override
    public Pagination<Sku> findByCategoryId(Long categoryId, Pagination<Sku> pagination) {
	    return findPageByProperties("categoryId", categoryId, pagination);
    }

}
