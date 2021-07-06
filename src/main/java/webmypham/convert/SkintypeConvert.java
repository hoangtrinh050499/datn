package webmypham.convert;

import org.springframework.stereotype.Component;

import webmypham.DTO.SkintypeDTO;
import webmypham.model.Skintype;
@Component
public class SkintypeConvert {
	
	public SkintypeDTO mapSkintypeEntityToDto( Skintype skintype) {
		SkintypeDTO skintypeDTO = new SkintypeDTO();
		skintypeDTO.setId(skintype.getId());
		skintypeDTO.setTitle(skintype.getTitle());
		return skintypeDTO;
	}

	public Skintype mapSkintypeDtoToEntity( SkintypeDTO skintypedto) {
		Skintype skintype = new Skintype();
		skintype.setId(skintypedto.getId());
		skintype.setTitle(skintypedto.getTitle());
		return skintype;
	}
}
