package webmypham.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="imageproducts")
public class ImageProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String image;
	
	@ManyToOne
	@JoinColumn(name="idproduct")
	private Products idproduct;
	
	
	public ImageProduct() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ImageProduct(int id, String image, Products idproduct) {
		super();
		this.id = id;
		this.image = image;
		this.idproduct = idproduct;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public Products getIdproduct() {
		return idproduct;
	}


	public void setIdproduct(Products idproduct) {
		this.idproduct = idproduct;
	}


	
	
	
	
	
}
