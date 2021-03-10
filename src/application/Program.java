package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		
		Scanner tc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = tc.nextInt();
		
		for(int i = 0; i < n; i++) {
			
			System.out.println("Product #" + (i+1) + " data: ");
			System.out.print("Common, used or imported (c/u/i)? ");
			char tipo = tc.next().charAt(0);
			System.out.print("Name: ");
			tc.nextLine();
			String name = tc.nextLine();
			System.out.print("Price: ");
			Double price = tc.nextDouble();
			if(tipo == 'i') {
				
				System.out.print("Customs fee: ");
				Double customFee = tc.nextDouble();
				list.add(new ImportedProduct(name, price, customFee));
				
			}else if(tipo == 'c') {
				
				list.add(new Product(name, price));
				
			}else {
				
				
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date date = sdf.parse(tc.next());
				list.add(new UsedProduct(name, price, date));
			}
			
			System.out.println();
			System.out.println("Price tags: ");
			for(Product prod: list) {
				System.out.println(prod.priceTag());
			}
		}
	
		tc.close();
	}

}
