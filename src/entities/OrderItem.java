package entities;

public class OrderItem {

	private Integer quantity;
	private Double price;
	
	private Product product;
	
	public OrderItem() {		
	}

	public OrderItem(Integer quantity, Double price, Product product) {
		
		this.quantity = quantity;	
		this.price = price;
		this.product = product;
		
	}

	

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = product.getPrice();
	}
	
	public Product getProduct() {
		return product;
	}

	
	public Double subTotal() {
		return quantity*product.getPrice();
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order items:\n");
		sb.append(this.product.getName() + ", ");
		sb.append("$"+this.product.getPrice() + ", ");
		sb.append("Quantity: ");
		sb.append(quantity + ", ");
		sb.append("Subtotal: $");
		sb.append(subTotal());
		sb.append("Total price: $");
		
		return sb.toString();
	}

	
}
