package webmypham.DTO;

public class cart_productDTO {
	
	private ProductDTO pro;
	private int sl;
	public cart_productDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public cart_productDTO(ProductDTO pro, int sl) {
		super();
		this.pro = pro;
		this.sl = sl;
	}
	public ProductDTO getPro() {
		return pro;
	}
	public void setPro(ProductDTO pro) {
		this.pro = pro;
	}
	public int getSoluong() {
		return sl;
	}
	public void setSoluong(int soluong) {
		this.sl = soluong;
	}
	

}
