package webmypham.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

//@Embeddable
@Entity
@Table(name="product_category")
public class product_category {
//	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
//	private int idproduct;
//	private int idcategory;
	
	@ManyToOne
	@JoinColumn(name = "idproduct")
	private Products product;	

	@ManyToOne
	@JoinColumn(name = "idcategory")
	private Category category;

	
	
	public product_category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public product_category(int id, int idproduct, int idcategory, Products product, Category category) {
		super();
		this.id = id;
//		this.idproduct = idproduct;
//		this.idcategory = idcategory;
		this.product = product;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public int getIdproduct() {
//		return idproduct;
//	}

//	public void setIdproduct(int idproduct) {
//		this.idproduct = idproduct;
//	}
//
//	public int getIdcategory() {
//		return idcategory;
//	}
//
//	public void setIdcategory(int idcategory) {
//		this.idcategory = idcategory;
//	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
	
	
}
