package webmypham.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webmypham.DTO.OrderDTO;
import webmypham.DTO.OrderdetailDTO;
import webmypham.DTO.ProductDTO;
import webmypham.DTO.cart_productDTO;
import webmypham.convert.OrderConvert;
import webmypham.model.Order;
import webmypham.model.Orderdetail;
import webmypham.repository.OrderRepository;
import webmypham.repository.OrderdetailRepository;

@Service
public class OrderdetailService {

	@Autowired
	OrderdetailRepository ordetailRepository;
	@Autowired
	OrderRepository orRepository;
	@Autowired
	OrderService orderService;
	@Autowired
	OrderConvert orConvert;
	
	public void save(OrderdetailDTO ordetail) {
//		ordetail.setOrder(orConvert.mapOrderEntityToDto(orderService.getlast()));
		
		ordetailRepository.save(orConvert.mapOrderdetailDtoToEntity(ordetail));
	}
	
	public List<OrderdetailDTO> findAlldto(){
		List<OrderdetailDTO> l = new ArrayList<OrderdetailDTO>();
		for (Orderdetail order : ordetailRepository.findAll()) {
			l.add(orConvert.mapOrderdetailEntityToDto(order));
		}
		return l;
	}
	
	public int sumprice(int id) {
		return ordetailRepository.findordersumprice(id);
	}
	
	public List<OrderdetailDTO> findor(int id){
		List<OrderdetailDTO> list = new ArrayList<OrderdetailDTO>();
		for (Orderdetail orderdetail : ordetailRepository.findorder(id)) {
			list.add(orConvert.mapOrderdetailEntityToDto(orderdetail));
		}
		return list;
	}
	
}
