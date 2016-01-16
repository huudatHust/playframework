package models;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import play.data.validation.Constraints;
import play.db.ebean.Model;

@Entity
public class Tag extends Model {

	/**
		 * 
		 */
	private static final long serialVersionUID = -4732417444052925306L;
	@Id
	public Long id;
	@Constraints.Required
	public String name;
	@ManyToMany(mappedBy = "tags")
	public List<Product> products;

	public Tag() {

	}

	public Tag(Long id, String name, List<Product> products) {
		this.id = id;
		this.name = name;
		this.products = products;
	}

}
