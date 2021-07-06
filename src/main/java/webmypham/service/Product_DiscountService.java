package webmypham.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import webmypham.repository.Product_DiscountRepository;

@Service
public class Product_DiscountService {

	@Autowired
	Product_DiscountRepository product_discountRepository;
	
	public Integer discount(int id) {
//		LocalDate now = LocalDate.now();
		return product_discountRepository.finddiscount(id, LocalDate.now().toString());
	}
	
	
}
