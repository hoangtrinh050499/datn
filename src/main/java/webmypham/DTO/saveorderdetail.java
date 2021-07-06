package webmypham.DTO;

import java.util.List;

public class saveorderdetail {

	private OrderDTO order;
	private List<OrderdetailDTO> cart;
	public saveorderdetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public saveorderdetail(OrderDTO order, List<OrderdetailDTO> cart) {
		super();
		this.order = order;
		this.cart = cart;
	}
	public OrderDTO getOrder() {
		return order;
	}
	public void setOrder(OrderDTO order) {
		this.order = order;
	}
	public List<OrderdetailDTO> getCart() {
		return cart;
	}
	public void setCart(List<OrderdetailDTO> cart) {
		this.cart = cart;
	}
	
	
}
