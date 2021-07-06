package webmypham.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import webmypham.DTO.OrderDTO;
import webmypham.DTO.OrderdetailDTO;
import webmypham.DTO.ProductDTO;
import webmypham.DTO.ProductclassDTO;
import webmypham.DTO.cart_productDTO;
import webmypham.DTO.saveorderdetail;
import webmypham.model.Order;
import webmypham.service.OrderService;
import webmypham.service.OrderdetailService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {


	@Autowired
	OrderService orderService;
	@Autowired
	OrderdetailService orderdetailService;
	
	@GetMapping(value="/order")
	public int getAllproduct(){
		return orderService.getlast();
	}
	@GetMapping(value="/orderdto")
	public List<OrderDTO> getAlldto(){
		return (List<OrderDTO>) orderService.findAlldto();
	}
	
	@PostMapping(value="/order/insert")
	public void insert(@RequestBody List<OrderdetailDTO> or) {		
		orderService.save(or.get(0).getOrder());
		
		int id = orderService.getlast();
		for (OrderdetailDTO ordetail : or) {
			ordetail.getOrder().setId(id);
			orderdetailService.save(ordetail);	
		}
		
	}
	
//	@PostMapping(value="/orderdetail/insert")
//	public int insertdetail(@RequestBody OrderdetailDTO ordetail) {
//		int id = orderService.getlast();
//		id +=1;
//		ordetail.getOrder().setId(id++);
//		orderdetailService.save(ordetail);	
//		return id;
//	}
	
	@GetMapping(value="/orderdetaildto")
	public List<OrderdetailDTO> getAlldedto(){
		return (List<OrderdetailDTO>) orderdetailService.findAlldto();
	}
	
	@GetMapping(value="/orderdetaildto/{id}")
	public List<OrderdetailDTO> ordetail_idorder(@PathVariable("id")int id){
		return (List<OrderdetailDTO>) orderdetailService.findor(id);
	}
	
}
