package webmypham.convert;

import org.springframework.stereotype.Component;

import webmypham.DTO.CompositionDTO;
import webmypham.model.Composition;
@Component
public class CompositionConvert {

	public CompositionDTO mapCompositionEntityToDto(Composition composition) {
		CompositionDTO compositionDTO = new CompositionDTO();
		compositionDTO.setId(composition.getId());
		compositionDTO.setNameComposition(composition.getNameComposition());
		return compositionDTO;
	}
	public Composition mapCompositionDtoToEntity(CompositionDTO compositiondto) {
		Composition composition = new Composition();
		composition.setId(compositiondto.getId());
		composition.setNameComposition(compositiondto.getNameComposition());
		return composition;
	}
}
