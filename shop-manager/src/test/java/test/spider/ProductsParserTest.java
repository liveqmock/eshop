package test.spider;

import net.shangtech.eshop.manager.spider.CategoryProcessor;
import net.shangtech.eshop.product.service.BrandService;
import net.shangtech.eshop.product.service.CategoryService;
import net.shangtech.eshop.product.service.InventoryService;
import net.shangtech.eshop.product.service.SkuService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class ProductsParserTest {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductsParserTest.class);
	
	@Autowired private CategoryService categoryService;
	@Autowired private SkuService productService;
	@Autowired private InventoryService inventoryService;
	@Autowired private BrandService brandService;
	
	@Test
	public void parseProduct(){
		try{
			new CategoryProcessor(categoryService, productService, inventoryService, brandService).exec();
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
	}
}
