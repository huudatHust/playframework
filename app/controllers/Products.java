package controllers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.avaje.ebean.Ebean;

import models.Product;
import models.Tag;
import play.data.Form;
import play.db.ebean.EbeanPlugin;
import play.mvc.Controller;
import play.mvc.Result;

public class Products extends Controller {
	private static  Form<Product> productForm = Form.form(Product.class);

	public static Result list() {
		List<Product> products = Product.findAll();
		return ok(views.html.products.list.render(products));
	}

	public static Result newProduct() {
		return ok(views.html.products.details.render(productForm));
	}

	public static Result details(Product product) {
		if(product == null){
			return notFound(String.format("product %s is not exists", product.ean));
		}
		productForm = productForm.fill(product);
		return ok(views.html.products.details.render(productForm));
	}

	public static Result save() {
		Form<Product> boundForm = productForm.bindFromRequest();
		if (boundForm.hasErrors()) {
			flash("error", "Please correct the form below.");
			return badRequest(views.html.products.details.render(boundForm));
		}
		Product product = boundForm.get();
		List<Tag> tags = new ArrayList<Tag>();
		for(Tag tag : product.tags){
			if(tag.id != null)
				tags.add(Tag.findById(tag.id));
		}
		product.tags = tags;
		Ebean.save(product);
		
		flash("success", String.format("Successfully added product %s", product));
		return redirect(routes.Products.list());
	}
	public static Result delete(String ean){
		Product product = Product.findByEan(ean);
		if(product == null)
			return notFound(String.format("product %s is not exists." , ean) );
		Product.remove(product);
		return redirect(routes.Products.list());
	}

}
