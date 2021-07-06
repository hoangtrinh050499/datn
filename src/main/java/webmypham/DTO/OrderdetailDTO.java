package webmypham.DTO;


import java.util.List;

import webmypham.model.Order;
import webmypham.model.Products;

public class OrderdetailDTO {

	private int id;
	private OrderDTO Order;
	private ProductDTO pro;
	private int sl;
	private int price;
//	private List<cart_productDTO> listpro;
	public OrderdetailDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderdetailDTO(int id, OrderDTO order, ProductDTO pro, int sl,int price) {
		super();
		this.id = id;
		Order = order;
		this.pro = pro;
		this.sl = sl;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public OrderDTO getOrder() {
		return Order;
	}
	public void setOrder(OrderDTO order) {
		Order = order;
	}
	public ProductDTO getPro() {
		return pro;
	}
	public void setPro(ProductDTO pro) {
		this.pro = pro;
	}
	public int getSl() {
		return sl;
	}
	public void setSl(int sl) {
		this.sl = sl;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
