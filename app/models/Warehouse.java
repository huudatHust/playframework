package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.db.ebean.Model;
@Entity
public class Warehouse extends Model{
	@Id
	public Long id;
	public String name;
	@OneToMany(mappedBy = "warehouse")
	public List<StockItem> stock ;
	 @OneToOne
	public Address address;
	public String toString() {
		return name;
	}
}
