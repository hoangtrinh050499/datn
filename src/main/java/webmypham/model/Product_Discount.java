package webmypham.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
//import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

//@Embeddable
@Entity
@Table(name="product_discount")
public class Product_Discount {
//	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	

	@ManyToOne
	@JoinColumn(name = "idproduct")
	private Products products;

	@ManyToOne
	@JoinColumn(name = "iddiscount" )
	private Discount discount;
	@Column(name="start")
	private Date start;
	@Column(name="end")
	private Date end;
	
	
	
	
	public Product_Discount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product_Discount(int id, Products products, Discount discount, Date start,
			Date end) {
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

	public Products getProducts() {
		return products;
	}
	public void setProducts(Products products) {
		this.products = products;
	}
	public Discount getDiscount() {
		return discount;
	}
	public void setDiscount(Discount discount) {
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
