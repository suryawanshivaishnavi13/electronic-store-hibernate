package com.electronicsstore;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductDAO {

	  // CREATE
	
	public void saveProduct(Product product) {
		  
		Transaction transaction = null;
		
		try(Session session = HibernateUtil
				.getSessionFactory()
				.openSession()){
			
			transaction = session.beginTransaction();
			
			session.persist(product);
			
			transaction.commit();
			
			System.out.println("Product Saved");
			
		} catch (Exception e) {
			
			if(transaction != null) {
				transaction.rollback();
			}
			
			e.printStackTrace();
		}
		
	}
	
	 // READ ALL
	
	public List<Product> getProducts(){
		
		try(Session session = HibernateUtil
				.getSessionFactory()
				.openSession()){
			
			return session
					.createQuery("from Product" , Product.class)
					       .list();
		}
	}
	
	// READ BY ID
	
	public Product getProductById(int id) {
		
		try(Session session = HibernateUtil
				.getSessionFactory()
				.openSession()){
			
			return session.get(Product.class, id);	
		}
	}
	
	// UPDATE
	public void updateProduct(int id ,String newName, double newPrice ,LocalDate newExpiryDate) {
		 
		Transaction transaction = null;
		
		try(Session session  = HibernateUtil
				.getSessionFactory()
				.openSession()){
			
			transaction = session .beginTransaction();
			
			Product product = session.get(Product.class, id);
			
			if(product != null) {
				
				product.setProductName(newName);
				product.setPrice(newPrice);
				product.setExpiryDate(newExpiryDate);
				
				System.out.println("Product Updated");
			}
			
			transaction.commit();
			
		} catch(Exception e) {
		 
		if(transaction != null) {
			transaction.rollback();
		}
		
		  e.printStackTrace();	
	}
}

   // DELETE
   
public void deleteProduct(int id) {
	
	Transaction transaction = null;
	
	try(Session session = HibernateUtil
			.getSessionFactory()
			.openSession()){
		
		transaction = session.beginTransaction();
		
		Product product = session.get(Product.class, id);
		
		if(product != null) {
			
			session.remove(product);
			
			System.out.println("Product Deleted");
		}
		transaction.commit();
		
	} catch(Exception e) {
		
		if(transaction != null) {
			 transaction.rollback();	
		}
		e.printStackTrace();
	}
  }
}