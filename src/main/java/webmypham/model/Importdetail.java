package webmypham.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="importdetail")
public class Importdetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
//	@Column
//	private int idbill;
//	@Column
//	private int idproduct;
	
	@ManyToOne
	@JoinColumn(name = "idbill")
	private Import dtimport;
	
	@ManyToOne
	@JoinColumn(name = "idproduct")
	private Products product;
	
	@Column
	private String nsx;
	@Column
	private String exp;
	@Column
	private int quantityimport;
	@Column
	private int unitpriceimport;
	@Column
	private int quantitysell;
	@Column
	private int unitpricesell;

	public Importdetail() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Importdetail(int id, int idbill, int idproduct, String nsx, String exp, int quantityimport,
			int unitpriceimport, int quantitysell, int unitpricesell, Import dtimport, Products product) {
		super();
		this.id = id;
//		this.idbill = idbill;
//		this.idproduct = idproduct;
		this.nsx = nsx;
		this.exp = exp;
		this.quantityimport = quantityimport;
		this.unitpriceimport = unitpriceimport;
		this.quantitysell = quantitysell;
		this.unitpricesell = unitpricesell;
		this.dtimport = dtimport;
		this.product = product;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
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




	public int getQuantitysell() {
		return quantitysell;
	}




	public void setQuantitysell(int quantitysell) {
		this.quantitysell = quantitysell;
	}




	public int getUnitpricesell() {
		return unitpricesell;
	}




	public void setUnitpricesell(int unitpricesell) {
		this.unitpricesell = unitpricesell;
	}




	public Import getDtimport() {
		return dtimport;
	}




	public void setDtimport(Import dtimport) {
		this.dtimport = dtimport;
	}




	public Products getProduct() {
		return product;
	}




	public void setProduct(Products product) {
		this.product = product;
	}
	
	
	
	
	
}
