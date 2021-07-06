package webmypham.convert;

import org.springframework.stereotype.Component;

import webmypham.DTO.TrademarkDTO;
import webmypham.model.Trademark;
@Component
public class TrademarkConvert {

	public TrademarkDTO mapTrademarkEntityToDto( Trademark trademark) {
		TrademarkDTO trademarkDTO  = new TrademarkDTO();
		if(trademark !=null) {
			trademarkDTO.setId(trademark.getId());
	
			trademarkDTO.setNametrademark(trademark.getNametrademark());
			
			trademarkDTO.setContent(trademark.getContent());
			return trademarkDTO;
		}
		return trademarkDTO = null;
	}
	
	public Trademark mapTrademarkDtoToEntity(TrademarkDTO trademarkDTO) {
		Trademark trademark = new Trademark();
		
		
		
		
		if(trademarkDTO !=null) {
			trademark.setId(trademarkDTO.getId());
		
			
				trademark.setNametrademark(trademarkDTO.getNametrademark());
			
			
			trademark.setContent(trademarkDTO.getContent());
			return trademark;
		}
		
		
		return trademark;
	}
	
	
	
}
