package webmypham.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webmypham.DTO.OrderDTO;
import webmypham.DTO.cart_productDTO;
import webmypham.convert.OrderConvert;
import webmypham.model.Order;
import webmypham.repository.OrderRepository;
import webmypham.repository.OrderdetailRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orRepository;
	
	@Autowired
	OrderConvert orConvert;
	
	@Autowired
	OrderdetailService ordetailService;
	
	public void save(OrderDTO or) {
		orRepository.save(orConvert.mapOrderDtoToEntity(or));
	}
	
	public List<OrderDTO> findAlldto(){
		List<OrderDTO> l = new ArrayList<OrderDTO>();
		for (Order order : orRepository.findAll()) {
			
			l.add(orConvert.mapOrderEntityToDto(order,ordetailService.sumprice(order.getId())));
		}
		return l;
	}
	public OrderDTO findID(int id) {
		return orConvert.mapOrderEntityToDto(orRepository.findOne(id),ordetailService.sumprice(id));
	}
	
	
	public List<Order> findAll(){
		return orRepository.findAll();
	}
	
	public int getlast() {
		return orRepository.findorderlast();
	}
	
	public int getTongtienban(int month) {
		try {
			return orRepository.tongtienban(month);
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
		
	}
	public int gettonghoadon(int month) {
		try {
			return orRepository.tonghoadon(month);
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}
	public int gettongkhachhang(int month) {
		try {
			return orRepository.tongkhachhang(month);
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}
	
	public int gettongdonhanghoanthanh(int month) {
		try {
			return orRepository.tongdonhanghoanthanh(month);
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}
	
	public int gettongdonhanghuy(int month) {
		try {
			return orRepository.tongdonhanghuy(month);
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}
	
	
}
