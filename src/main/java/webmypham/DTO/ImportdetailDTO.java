package webmypham.DTO;

import webmypham.model.Import;
import webmypham.model.Products;

public class ImportdetailDTO {


	private int id;
//	private String image;
//	private String product;
	
	private ProductclassDTO product;

	private String nsx;

	private String exp;

	private int quantityimport;
	private int unitpriceimport;
	private int unitpricesell;
	private int thanhtien;

	
	public ImportdetailDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}





	public ProductclassDTO getProduct() {
		return product;
	}


	public void setProduct(ProductclassDTO product) {
		this.product = product;
	}


	public String getNsx() {
		return nsx;
	}


	public void setNsx(String nsx) {
		this.nsx = nsx;
	}


	public String getExp() {
		return exp;
	}


	public void setExp(String exp) {
		this.exp = exp;
	}


	public int getQuantityimport() {
		return quantityimport;
	}


	public void setQuantityimport(int quantityimport) {
		this.quantityimport = quantityimport;
	}


	public int getUnitpriceimport() {
		return unitpriceimport;
	}


	public void setUnitpriceimport(int unitpriceimport) {
		this.unitpriceimport = unitpriceimport;
	}


	public int getUnitpricesell() {
		return unitpricesell;
	}


	public void setUnitpricesell(int unitpricesell) {
		this.unitpricesell = unitpricesell;
	}


	public int getThanhtien() {
		return thanhtien;
	}


	public void setThanhtien(int thanhtien) {
		this.thanhtien = thanhtien;
	}


	public ImportdetailDTO(int id,  ProductclassDTO product, String nsx, String exp, int quantityimport,
			int unitpriceimport, int unitpricesell, int thanhtien) {
		super();
		this.id = id;

		this.product = product;
		this.nsx = nsx;
		this.exp = exp;
		this.quantityimport = quantityimport;
		this.unitpriceimport = unitpriceimport;
		this.unitpricesell = unitpricesell;
		this.thanhtien = thanhtien;
	}


	
}
