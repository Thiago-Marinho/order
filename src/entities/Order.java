package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private Date moment;
	private OrderStatus status;
	SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyy");
	
	private List<OrderItem> Itens = new ArrayList<>();
	private Client client;
	
	public Order(){}	

	public Order(Date moment, OrderStatus status,Client client) throws ParseException {		
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public List<OrderItem> getOrderItem() {
		return Itens;
	}

	public void addItem(OrderItem Item) {
		Itens.add(Item);
	}
	public void removeItem(OrderItem Item) {
		Itens.remove(Item);
	}
	public Double total() {
		double sum = 0 ;
		for(OrderItem c : Itens) {
			sum += c.subTotal();
		}
		return sum;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY:\n");
		sb.append("Order moment:");
		sb.append(sdf1.format(moment)+ "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		
		sb.append("Client: ");
		sb.append(client.getName() );
		sb.append(" ("+ sdf2.format(client.getBirthDate()) +")");
		sb.append(" - ");
		sb.append(client.getEmail());
		sb.append("\nOrder items:\n");
		for (OrderItem i : Itens) {
		
		sb.append(i.getProduct().getName() + ", ");
		sb.append("$"+i.getProduct().getPrice() + ", ");
		sb.append("Quantity: ");
		sb.append(i.getQuantity() + ", ");
		sb.append("Subtotal: $");
		sb.append(i.subTotal());
		sb.append("\n");
		}
		sb.append("\nTotal price: $");
		sb.append(total());
		
		return sb.toString();
	}
}

