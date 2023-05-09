// Product Management Application in java 
// by Sanjai M
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

class Product{
	int id;
	String name;
	int price;
	String category;
	
	public Product(int id, String name, int price, String category) {
		this.id = id;
		this.name= name;
		this.price = price;
		this.category = category;
	}
	
	public String toString() {
		return "[" + id + "," + name + "," + price + "," + category + "]";  
	}
}

class Inventory{
	List<Product> list;
	HashSet<Integer> id_set;
	Scanner sc = new Scanner(System.in);
	
	public Inventory() {
		list = new ArrayList<>();
		id_set = new HashSet<Integer>();
	}
	
	public Product addProduct(Product product) {
		if(id_set.contains(product.id)) {
			System.out.println("product with same id already exists! enter unique id");
			return product;
		}
		list.add(product);
		id_set.add(product.id);
		System.out.println("product added successfully!");
		return product;
	}
	
	public int updateProduct(int id) {
		for(Product product: list) {
			if(product.id == id) {
				System.out.println("Enter product name:");
				product.name = sc.nextLine();
				System.out.println("Enter product price:");
				product.price = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter product category:");
				product.category = sc.nextLine();
				System.out.println("product updated successfully!");
				return id;
			}
		}
		System.out.println("product does not exist!");
		return 0;
	}
	
	public int deleteProduct(int id) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).id == id) {
				list.remove(i);
				System.out.println("product deleted successfully!");
				return id;
			}
		}
		System.out.println("product does not exist!");
		return 0;
	}
	
	public String getProduct(int id) {
		for(Product product: list) {
			if(product.id == id) {
				return product.toString();
			}
		}
		return "product does not exist!";
	}
	
	public String getAllProducts() {
		String res = "";
		for(Product product: list) {
			res = res + product.toString() + "\n";
		}
		return res;
	}
	
	public String getAllNames() {
		List<String> names = new ArrayList<>();
		for(Product product: list) {
			names.add(product.name);
		}
		return names.toString();
	}
	
	public String getAllPrices() {
		List<Integer> prices = new ArrayList<>();
		for(Product product: list) {
			prices.add(product.price);
		}
		return prices.toString();
	}
	
	public String getAllCategories() {
		List<String> categories = new ArrayList<>();
		for(Product product: list) {
			categories.add(product.category);
		}
		return categories.toString();
	}
}

public class ProductManagementApplication {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Inventory inventory = new Inventory();
		
		while(true) {
			System.out.println("Product Management Application");
			System.out.println("===============================");
			System.out.println("1. add product");
			System.out.println("2. update product");
			System.out.println("3. delete product");
			System.out.println("4. get product");
			System.out.println("5. get all products");
			System.out.println("6. get all product prices");
			System.out.println("7. get all product names");
			System.out.println("8. get all product categories");
			System.out.println("9. exit");
			
			int op = sc.nextInt();
			int id_temp;
			switch(op) {
			case 1:
				System.out.println("Enter product id:");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter product name:");
				String name = sc.nextLine();
				System.out.println("Enter product price:");
				int price = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter product category:");
				String category = sc.nextLine();
				inventory.addProduct(new Product(id, name, price, category));
				break;
			case 2:
				System.out.println("Enter the product id:");
				id_temp = sc.nextInt();
				inventory.updateProduct(id_temp);
				break;
			case 3:
				System.out.println("Enter the product id:");
				id_temp = sc.nextInt();
				inventory.deleteProduct(id_temp);
				break;
			case 4:
				System.out.println("Enter the product id:");
				id_temp = sc.nextInt();
				System.out.println(inventory.getProduct(id_temp)); 
				break;
			case 5:
				System.out.println(inventory.getAllProducts());
				break;
			case 6:
				System.out.println(inventory.getAllPrices()); 
				break;
			case 7:
				System.out.println(inventory.getAllNames()); 
				break;
			case 8:
				System.out.println(inventory.getAllCategories()); 
				break;
			case 9:
				sc.close();
				System.out.println("Application closed");
				System.exit(0);
			default:
				System.out.println("enter valid option");
				break;
			}
			System.out.println("\n");
		}
	}
}
