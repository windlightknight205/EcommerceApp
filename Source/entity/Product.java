package entity;

public class Product {
	private String id;
	private String name;
	private String image;
	private double price;
	private String title;
	private String description;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String id, String name, String image, double price, String title, String description) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.price = price;
		this.title = title;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", image=" + image + ", price=" + price + ", title=" + title
				+ ", description=" + description + "]";
	}
	
}
