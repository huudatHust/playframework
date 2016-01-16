package Models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;


public class Product extends Model{

	public Long id;
	public String ean;
	public String name;
	public String description;
	public byte[] picture;
	public List<Tag> tags;

}
