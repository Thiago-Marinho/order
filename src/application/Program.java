package application;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;



public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
				
		System.out.println("Enter Clint Data:");
		
		System.out.print("Name: ");
		
		String name = sc.nextLine();
		//sc.next();
		System.out.print("Email: ");
		String email = sc.next();
		
		System.out.print("Birth date: ");
		
		String date =sc.next();
				
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		Date moment = new Date();
		Client client = new Client(name, email, date);
		Order order = new Order(moment, status, client );		
		
		System.out.println();
 		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		for (int i=1; i <= n; i++) {
			System.out.println("Enter #"+ i +" item data:");
			
			System.out.print("Product name: ");
			String nameProduct = sc.next();
			
			System.out.print("Product price: ");
			Double priceProduct = sc.nextDouble();
			
			System.out.print("Quantity: ");		
			int quantity = sc.nextInt();
			System.out.println();
			
			Product product = new Product(nameProduct,priceProduct);			
			OrderItem orderitem = new OrderItem(quantity,priceProduct,product);
			
			order.addItem(orderitem);
		}
		
		System.out.println("\n"+order);
		sc.close();

	}

}
