package webmypham.DTO;

import java.util.List;

import webmypham.model.Employee;
import webmypham.model.Supplier;

public class ImportDTO {
	private int id;
	private EmployeeDTO employee;
	private String date;
	private SupplierDTO supplier;
	private int tongtien;
	private List<ImportdetailDTO> importdetaildto;
	
	
	public ImportDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ImportDTO(int id, EmployeeDTO employee, String date, SupplierDTO supplier, int tongtien,
			List<ImportdetailDTO> importdetaildto) {
		super();
		this.id = id;
		this.employee = employee;
		this.date = date;
		this.supplier = supplier;
		this.tongtien = tongtien;
		this.importdetaildto = importdetaildto;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public EmployeeDTO getEmployee() {
		return employee;
	}


	public void setEmployee(EmployeeDTO employee) {
		this.employee = employee;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public SupplierDTO getSupplier() {
		return supplier;
	}


	public void setSupplier(SupplierDTO supplier) {
		this.supplier = supplier;
	}


	public int getTongtien() {
		return tongtien;
	}


	public void setTongtien(int tongtien) {
		this.tongtien = tongtien;
	}


	public List<ImportdetailDTO> getImportdetaildto() {
		return importdetaildto;
	}


	public void setImportdetaildto(List<ImportdetailDTO> importdetaildto) {
		this.importdetaildto = importdetaildto;
	}
	
	
	
	
}
