package Models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;


public class Product extends Model{
	public String ean;
	public String name;
	public String description;
	public Product(){
		
	}
	public Product(String ean, String name, String description) {
		super();
		this.ean = ean;
		this.name = name;
		this.description = description;
	}
	public String toString(){
		return String.format("$s - $s", ean, name);
	}
	public static List<Product> findAll(){
		return new ArrayList<Product>(products);
	}
	public static Product findByEan(String ean){
		for(Product pro : products){
			if(pro.ean.equals(ean))
				return pro;
		}
		return null;
	}
	public static List<Product> findByName(String name){
		List<Product> results = new ArrayList<>();
		for(Product pro : products){
			if(pro.name.toLowerCase().contains(name.toLowerCase())){
				results.add(pro);
			}
		}
		return results;
	}
	public static boolean remove(Product product){
		return	products.remove(product);
	}
	public void save(){
		products.remove(findByEan(this.ean));
		products.add(this);
	}
	
	
	
	
	
	
	//data moking
	 private static List<Product> products;

	  static {

	    products = new ArrayList<Product>();

	    products.add(new Product("1111111111111", "Paperclips 1", "Paperclips description 1"));

	    products.add(new Product("2222222222222", "Paperclips 2",

	        "Paperclips description 2"));

	    products.add(new Product("3333333333333", "Paperclips 3",

	        "Paperclips description 3"));

	    products.add(new Product("4444444444444", "Paperclips 4",

	        "Paperclips description 4"));

	    products.add(new Product("5555555555555", "Paperclips 5",

	        "Paperclips description 5"));

	  }
	

}
