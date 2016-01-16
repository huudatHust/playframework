package controllers;

import java.util.List;

import models.Product;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Products extends Controller {
	private static final Form<Product> productForm = Form.form(Product.class);

	public static Result list() {
		List<Product> products = Product.findAll();
		return ok(views.html.products.list.render(products));
	}

	public static Result newProduct() {
		return ok(views.html.products.details.render(productForm));
	}

	public static Result details(String ean) {
		final Product product = Product.findByEan(ean);
		if(product == null){
			return notFound(String.format("product %s is not exists", ean));
		}
		Form<Product> fillForm = productForm.fill(product);
		return ok(views.html.products.details.render(fillForm));
	}

	public static Result save() {
		Form<Product> boundForm = productForm.bindFromRequest();
		if (boundForm.hasErrors()) {
			flash("error", "Please correct the form below.");
			return badRequest(views.html.products.details.render(boundForm));
		}
		Product product = boundForm.get();
		product.save();
		flash("success", String.format("Successfully added product %s", product));
		return redirect(routes.Products.list());
	}

}
