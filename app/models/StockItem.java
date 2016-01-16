package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

@Entity
public class StockItem extends Model{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5752621662404326842L;
	@Id
	public Long id;
	@ManyToOne
	public Warehouse warehouse; // trường quan hệ nối với Warehouse
	@ManyToOne
	public Product product; // trường quan hệ nối với Product
	public Long quantity;
	public String toString() {
		return String.format("$d %s", quantity, product);
	}

}
