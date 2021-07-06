package webmypham.convert;

import org.springframework.stereotype.Component;

import webmypham.DTO.ImageproductDTO;
import webmypham.model.ImageProduct;
@Component
public class ImageproductConvert {

	public ImageproductDTO mapImageproductEntityToDto( ImageProduct imageProduct) {
		ImageproductDTO image= new ImageproductDTO();
//		image.setId(imageProduct.getId());
		image.setImage(imageProduct.getImage());
		return image;
	}
	
	public ImageProduct mapImageproductDtoToEntity( ImageproductDTO imageProduct) {
		ImageProduct image= new ImageProduct();
//		image.setId(imageProduct.getId());
		image.setImage(imageProduct.getImage());
		return image;
	}
	
}
