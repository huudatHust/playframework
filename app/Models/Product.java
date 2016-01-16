package Models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;


public class Product extends Model{
	public String ean;
	public String name;
	public String description;
	public byte[] picture;
	public Product(){
		
	}
	public Product(String ean, String name, String description, byte[] picture) {
		super();
		this.ean = ean;
		this.name = name;
		this.description = description;
		this.picture = picture;
	}
	public String toString(){
		return String.format("$s - $s", ean, name);
	}
	

}
