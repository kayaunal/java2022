package oopWithNLayeredApp.dataAccess;

import oopWithNLayeredApp.entities.Product;

public class HibernateProductDao implements ProductDao{
		public void add(Product product) {
			//sadece ve sadece DB eri�im kodlar� buraya yaz�l�r. (SQL)
			System.out.println("Hibernate ile veritaban�na eklendi");
		}

}
