package webmypham.DTO;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import webmypham.model.Discount;
import webmypham.model.Products;

public class Product_DiscountDTO {
	
	private int id;
	private ProductDTO products;
	private DiscountDTO discount;
	private Date start;
	private Date end;
	public Product_DiscountDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product_DiscountDTO(int id, ProductDTO products, DiscountDTO discount, Date start, Date end) {
		super();
		this.id = id;
		this.products = products;
		this.discount = discount;
		this.start = start;
		this.end = end;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ProductDTO getProducts() {
		return products;
	}
	public void setProducts(ProductDTO products) {
		this.products = products;
	}
	public DiscountDTO getDiscount() {
		return discount;
	}
	public void setDiscount(DiscountDTO discount) {
		this.discount = discount;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}

	

	
	
	

}
