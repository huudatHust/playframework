package models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import play.db.ebean.Model;
import play.mvc.PathBindable;
import play.data.validation.Constraints;

@Entity
public class Product extends Model implements PathBindable<Product>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1022345032477317811L;
	@Id
	@Constraints.Required
	public String ean;
	@Constraints.Required
	public String name;
	public String description;
	public byte[] picture;
    @OneToMany(mappedBy="product")
    public List<StockItem> stockItems;
    @ManyToMany
    public List<Tag> tags;
    
    
    public static Finder<Long, Product> find = new Finder<>(Long.class, Product.class);
	public Product(){
		
	}
	public Product(String ean, String name, String description) {
		this.ean = ean;
		this.name = name;
		this.description = description;
	}
	public String toString(){
		return String.format("%s - %s", ean, name);
	}
	public static List<Product> findAll(){
		return find.all();
	}
	public static Product findByEan(String ean){
		
		return find.where().eq("ean", ean).findUnique();
	}
	
	
	
	
	
	
	
	
	

	@Override
	public Product bind(String key, String value) {
		return findByEan(value);
	}
	@Override
	public String javascriptUnbind() {
		return ean;
	}
	@Override
	public String unbind(String key) {
		return ean;
	}
	
	

}
