package webmypham.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="imports")
public class Import {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name="idemployee")
	private Employee employee;
//	@Column(name="idemployee")
//	private int idemployee;
	@Column
	private String date;
//	@Column(name="idsupplier")
//	private int idsupplier;
	
	@ManyToOne
	@JoinColumn(name="idsupplier")
	private Supplier supplier;
	
	
	
	public Import() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Import(int id, String date, Supplier supplier, Employee employee) {
		super();
		this.id = id;
//		this.idemployee = idemployee;
		this.date = date;
//		this.idsupplier = idsupplier;
		this.supplier = supplier;
		this.employee = employee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}



	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	
	
	
	
}
