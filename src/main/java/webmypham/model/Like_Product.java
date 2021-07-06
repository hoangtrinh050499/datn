package webmypham.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="like_product")

public class Like_Product {

//	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;

	@ManyToOne
	@JoinColumn(name = "idproduct")
	private Products products;
	
	@ManyToOne
	@JoinColumn(name = "idaccount")
	private Account acount;
	
	
	
	public Like_Product() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Like_Product(int id, Products products, Account acount) {
		super();
		this.id = id;
		this.products = products;
		this.acount = acount;
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



	public Account getAcount() {
		return acount;
	}



	public void setAcount(Account acount) {
		this.acount = acount;
	}
	
	
	

	
	
	
}
