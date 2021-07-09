package webmypham.DTO;

import Interface.dashboardTopsoluong;

public class SoLuongDTO implements dashboardTopsoluong{

	private String image ; 
	private String name ; 
	private int soluong ;
	public SoLuongDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SoLuongDTO(String image, String name, int soluong) {
		super();
		this.image = image;
		this.name = name;
		this.soluong = soluong;
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
	public int getSoluong() {
		// TODO Auto-generated method stub
		return soluong;
	}
	
	
}
