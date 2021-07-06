package webmypham.DTO;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import webmypham.model.Trademark;

public class ProductclassDTO {

	private int id;

	private String nameproduct;

	private String image;

	private String introduce;

	private String overview;

	private String detailcomposition;

	private String uses;

	private String barcode;
	
	private CategoryDTO category;
	
	private TrademarkDTO trademark;

	

	public ProductclassDTO(int id, String nameproduct, String image, String introduce, String overview,
			String detailcomposition, String uses, String barcode, CategoryDTO category, TrademarkDTO trademark) {
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
	
	



	public CategoryDTO getCategory() {
		return category;
	}





	public void setCategory(CategoryDTO category) {
		this.category = category;
	}





	public ProductclassDTO() {
		super();
		// TODO Auto-generated constructor stub
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

	public TrademarkDTO getTrademark() {
		return trademark;
	}

	public void setTrademark(TrademarkDTO trademark) {
		this.trademark = trademark;
	}
	
	
}
