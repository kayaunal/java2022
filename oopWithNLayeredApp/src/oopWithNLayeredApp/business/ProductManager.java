package oopWithNLayeredApp.business;


import java.util.List;

import oopWithNLayeredApp.core.logging.Logger;
import oopWithNLayeredApp.dataAccess.HibernateProductDao;
import oopWithNLayeredApp.dataAccess.ProductDao;
import oopWithNLayeredApp.entities.Product;

public class ProductManager {

	private ProductDao productDao;
	private Logger[] loggers;

	public ProductManager(ProductDao productDao, Logger[] loggers) {

		this.productDao = productDao;
		this.loggers = loggers;
	}

	public void add(Product product) throws Exception { // response request pattern adlý yapýya göre yeniden ele
														// alýnacak
		// iþ kurallarýný buraya yazýyoruz
		if (product.getUnitPrice() < 10) {
			throw new Exception("Ürün fiyatý 10'dan küçük olamaz"); // Buraya kötü kod ile basit bir sorgulama yazdýk.
																	// Normalde validation ile besleyerek ilerleyeceðiz.
		}

		productDao.add(product);
		
		for (Logger logger: loggers) { //[db, file]
			logger.log(product.getName());
		}
	}

}
