package com.electronicsstore;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		 ProductDAO dao = new ProductDAO();
		 
		 Scanner sc = new Scanner(System.in);
		 
		 int choice;
		 
		 do {
			 
			 System.out.println("\n===== PRODUCT CRUD MENU =====");
			 System.out.println("1. Insert Product");
			 System.out.println("2. View All Product");
			 System.out.println("3. View Product By Id");
			 System.out.println("4. Update Product");
			 System.out.println("5. Delete Product");
			 System.out.println("6. Exit");
			 
			 System.out.println("Enter your choice : ");
			 choice = sc.nextInt();
			 
			 switch(choice) {
			 
			    // INSERT
			 
			 case 1:
				 
				 sc.nextLine();
				 
				   System.out.println("Enter Product Name : ");
				   String newname = sc.nextLine();
				   
				   System.out.println("Enter price : ");
				   double price = sc.nextDouble();
				   sc.nextLine();
				   
				   System.out.println("Enter ExpiryDate (YYYY-MM-DD) :  ");
				   String date = sc.nextLine();
				   
				   Product newProduct = new Product(newname, price , LocalDate.parse(date));
				   
				   dao.saveProduct(newProduct);
				   System.out.println("Product inserted successfully!");
				   break;
				   
				 // VIEW ALL
				   
			 case 2:
				 
				 List<Product> products = dao.getProducts();
				 
				 System.out.println("\nAll Products : ");
				 
				 for(Product p: products) {
					 System.out.println(p);
				 }
				 
				 break;
				 
			  // VIEW BY ID
				 
		   case 3:
			   
			   System.out.println("Enter Product ID : " );
			   int searchId = sc.nextInt();
			   
			   Product foundProduct = dao.getProductById(searchId);
			   
			   if(foundProduct != null) {
				   System.out.println(foundProduct);
			   }else {
				   System.out.println("Product Not Found");
			   }
		   
			   break;
			   
			  // UPDATE
			   
		   case 4:
			   
			   System.out.println("Enter Product ID to Update : ");
			   int updateId = sc.nextInt();
			   
			   sc.nextLine();
			   
			   System.out.println("Enter Product Name : ");
			   String name = sc.nextLine();
			   
			   System.out.println("Enter New Price : ");
			   double newPrice = sc.nextDouble();
			   sc.nextLine();
			   
			   System.out.println("Enter a new expiryDate");
			   String newexpiryDate = sc.nextLine();
		
			   dao.updateProduct(updateId , name , newPrice , LocalDate.parse (newexpiryDate));
			   
			   break;
			   
			 // DELETE
			   
		   case 5:
			   System.out.println("Enter Product ID to Delete : ");
			   int deletedId = sc.nextInt();
			   
			   dao.deleteProduct(deletedId);
			   
			   break;
			   
			// EXIT
			   
		   case 6:
			   
			   System.out.println("Application Closed");
			   
			   break;
			   
			 default:
			 
			   System.out.println("Invalid Choice");
			   
		 }
			 
	   } while (choice != 6);
		 
		sc.close();
		
		HibernateUtil.getSessionFactory().close();
		
	}
}
