package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner (System.in);
		List<Product> products = new ArrayList<>();
		
		
		System.out.print("Enter the number of products: ");
		int n = scan.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.println("Product #" + (i+ 1) + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char option = scan.next().charAt(0);
			
			scan.nextLine();
			
			System.out.print("Name: ");
			String name = scan.nextLine();
			System.out.print("Price: ");
			Double price = scan.nextDouble();
			
			if(option == 'i') {
				System.out.print("Customs fee: ");
				Double customsFee = scan.nextDouble();
				
				products.add(new ImportedProduct(name, price, customsFee));
			}else if(option == 'u') {
				System.out.print("Manufacture Date (DD/MM/YYYY): ");
				LocalDate manufactureDate = LocalDate.parse(scan.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy")) ;
				
				products.add(new UsedProduct(name, price, manufactureDate));
			}else {
				products.add(new Product(name, price));
			}
			
		}
		System.out.println("Price Tags: ");
		for(Product prod : products) {
			System.out.println(prod.priceTag());
		}
		
		
		
		
		
		
		scan.close();
	}

}
