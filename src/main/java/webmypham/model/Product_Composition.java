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
//@Embeddable
@Table(name="product_composition")
public class Product_Composition{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	

	@ManyToOne
	@JoinColumn(name = "idproduct")
	private Products products;
	
	@ManyToOne
	@JoinColumn(name = "idcomposition")
	private Composition compositions;
	
	
	
	public Product_Composition() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Product_Composition(int id,  Products products, Composition composition) {
		super();
		this.id = id;
	
		this.products = products;
		this.compositions = composition;
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



	public Composition getComposition() {
		return compositions;
	}



	public void setComposition(Composition composition) {
		this.compositions = composition;
	}
	
	
	
	

}
