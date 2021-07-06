package webmypham.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

//@Embeddable
@Entity
@Table(name="product_skintype")
public class Product_Skintype  {
//	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;


	@ManyToOne
	@JoinColumn(name = "idproduct")
	private Products product;
	
	@ManyToOne
	@JoinColumn(name = "idskintype")
	private Skintype skintype;
	
	
	
	public Product_Skintype() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Product_Skintype(int id, Products product, Skintype skintype) {
		super();
		this.id = id;

		this.product = product;
		this.skintype = skintype;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}


	public Products getProduct() {
		return product;
	}



	public void setProduct(Products product) {
		this.product = product;
	}



	public Skintype getSkintype() {
		return skintype;
	}



	public void setSkintype(Skintype skintype) {
		this.skintype = skintype;
	}


	
	
}
