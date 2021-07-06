package webmypham.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "products")

public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	@Column
	private String nameproduct;
	@Column
	private String image;
	@Column
	private String introduce;
	@Column
	private String overview;
	@Column
	private String detailcomposition;
	@Column
	private String uses;
	@Column
	private String barcode;
	
	@ManyToOne
	@JoinColumn(name="idcategory")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="idtrademark")
	private Trademark trademark;
	
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Products(int id, String nameproduct,String image, String introduce, String overview,
			String detailcomposition, String uses, String barcode, Category category, Trademark trademark) {
		super();
		this.id = id;
		this.nameproduct = nameproduct;
		this.image = image;
		this.introduce = introduce;
		this.overview = overview;
		this.detailcomposition = detailcomposition;
		this.uses = uses;
		this.barcode = barcode;
		this.category = category;
		this.trademark = trademark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameproduct() {
		return nameproduct;
	}

	public void setNameproduct(String nameproduct) {
		this.nameproduct = nameproduct;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getDetailcomposition() {
		return detailcomposition;
	}

	public void setDetailcomposition(String detailcomposition) {
		this.detailcomposition = detailcomposition;
	}

	public String getUses() {
		return uses;
	}

	public void setUses(String uses) {
		this.uses = uses;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Trademark getTrademark() {
		return trademark;
	}

	public void setTrademark(Trademark trademark) {
		this.trademark = trademark;
	}

	

}
