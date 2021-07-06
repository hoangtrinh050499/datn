package webmypham.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orderdetails")
public class Orderdetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name="idorder")
	private Order Order;
	@ManyToOne
	@JoinColumn(name="idproduct")
	private Products Product;
	@Column
	private int quantity;
	@Column
	private int price;
	public Orderdetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Orderdetail(int id, webmypham.model.Order order, Products product, int quantity,int price) {
		super();
		this.id = id;
		Order = order;
		Product = product;
		this.quantity = quantity;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Order getOrder() {
		return Order;
	}
	public void setOrder(Order order) {
		Order = order;
	}
	public Products getProduct() {
		return Product;
	}
	public void setProduct(Products product) {
		Product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
