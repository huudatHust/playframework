package controllers;

import java.util.List;

import models.Product;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Products extends Controller{
	private static final Form<Product> productForm = Form.form(Product.class);
	public static Result list(){
		List<Product> products = Product.findAll();
		return ok(views.html.products.list.render(products));
	}
	public static Result newProduct(){
		return ok(views.html.products.details.render(productForm));
	}
	public static Result details(String ean){
		return TODO;
	}
	public static Result save(){
		Form<Product> boundForm = productForm.bindFromRequest();
		Product product = boundForm.get();
		product.save();
		return  ok(String.format("Saved product %s", product));
	}
	
}
