package models;

public class StockItem {
	public Warehouse warehouse; // trường quan hệ nối với Warehouse
	public Product product; // trường quan hệ nối với Product
	public Long quantity;
	public String toString() {
		return String.format("$d %s", quantity, product);
	}

}
