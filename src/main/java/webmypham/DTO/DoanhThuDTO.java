package webmypham.DTO;

import Interface.dashboardTopdoanhthu;

public class DoanhThuDTO implements dashboardTopdoanhthu{

	private String image ; 
	private String name ; 
	private int doanhthu ;
	public DoanhThuDTO(String image, String name, int doanhthu) {
		super();
		this.image = image;
		this.name = name;
		this.doanhthu = doanhthu;
	}
	@Override
	public String getImage() {
		// TODO Auto-generated method stub
		return image;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	@Override
	public int getDoangthu() {
		// TODO Auto-generated method stub
		return doanhthu;
	}
	
	 
	
}
