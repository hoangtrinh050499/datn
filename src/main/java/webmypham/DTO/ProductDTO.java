package webmypham.DTO;

import java.util.List;

import webmypham.model.Category;
import webmypham.model.Composition;
import webmypham.model.ImageProduct;
import webmypham.model.Product_Skintype;
import webmypham.model.Skintype;
import webmypham.model.Trademark;

public class ProductDTO {

	private int id;
	private String nameproduct;
	private String image ;
	private String introduce;
	private String overview;
	private String detailcomposition;
	private String uses;
	private String barcode;
	private int discount;
	private int price;
	private TrademarkDTO trademark;
	
	private List<CompositionDTO> composition;
	private CategoryDTO category;
	private List<SkintypeDTO> skintype;
	private List<String> imageproduct;
	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	public ProductDTO(int id, String nameproduct,  String introduce, String overview,
			String detailcomposition, String uses, String barcode, int discount, int price, TrademarkDTO trademark,
			List<CompositionDTO> composition, CategoryDTO category, List<SkintypeDTO> skintype,
			List<String> imageproduct) {
		super();
		this.id = id;
		this.nameproduct = nameproduct;
		this.image = image;
		this.introduce = introduce;
		this.overview = overview;
		this.detailcomposition = detailcomposition;
		this.uses = uses;
		this.barcode = barcode;
		this.discount = discount;
		this.price = price;
		this.trademark = trademark;
		this.composition = composition;
		this.category = category;
		this.skintype = skintype;
		this.imageproduct = imageproduct;
	}





	public int getDiscount() {
		return discount;
	}




	public void setDiscount(int discount) {
		this.discount = discount;
	}




	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
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
	public List<CompositionDTO> getComposition() {
		return composition;
	}
	public void setComposition(List<CompositionDTO> composition) {
		this.composition = composition;
	}
	public TrademarkDTO getTrademark() {
		return trademark;
	}
	public void setTrademark(TrademarkDTO trademark) {
		this.trademark = trademark;
	}
	public CategoryDTO getCategory() {
		return category;
	}
	public void setCategory(CategoryDTO category) {
		this.category = category;
	}
	public List<SkintypeDTO> getSkintype() {
		return skintype;
	}
	public void setSkintype(List<SkintypeDTO> skintype) {
		this.skintype = skintype;
	}
	public List<String> getImageproduct() {
		return imageproduct;
	}
	public void setImageproduct(List<String> imageproduct) {
		this.imageproduct = imageproduct;
	}

	
}
