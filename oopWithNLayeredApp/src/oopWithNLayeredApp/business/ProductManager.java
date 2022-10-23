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

	public void add(Product product) throws Exception { // response request pattern adl� yap�ya g�re yeniden ele
														// al�nacak
		// i� kurallar�n� buraya yaz�yoruz
		if (product.getUnitPrice() < 10) {
			throw new Exception("�r�n fiyat� 10'dan k���k olamaz"); // Buraya k�t� kod ile basit bir sorgulama yazd�k.
																	// Normalde validation ile besleyerek ilerleyece�iz.
		}

		productDao.add(product);
		
		for (Logger logger: loggers) { //[db, file]
			logger.log(product.getName());
		}
	}

}
