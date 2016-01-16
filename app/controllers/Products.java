package controllers;

import java.util.List;

import models.Product;
import play.mvc.Controller;
import play.mvc.Result;

public class Products extends Controller{
	public static Result list(){
		List<Product> products = Product.findAll();
		return ok(views.html.products.list.render(products));
	}
	public static Result newProduct(){
		return TODO;
	}
	public static Result details(String ean){
		return TODO;
	}
	public static Result save(){
		return TODO;
	}
}
