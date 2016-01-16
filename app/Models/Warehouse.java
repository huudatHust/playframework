package Models;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
	public String name;
	public List<StockItem> stock = new ArrayList(); // trường quan hệ
	public String toString() {
		return name;
	}
}
