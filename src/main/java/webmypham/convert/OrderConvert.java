package webmypham.convert;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import webmypham.DTO.OrderDTO;
import webmypham.DTO.OrderdetailDTO;
import webmypham.DTO.ProductDTO;
import webmypham.DTO.cart_productDTO;
import webmypham.model.Order;
import webmypham.model.Orderdetail;
import webmypham.service.OrderdetailService;
import webmypham.service.ProductService;

@Component
public class OrderConvert {

	@Autowired
	CustomerConvert cusconvert;
	@Autowired
	ProductConverter proconvert;
	@Autowired
	ProductService productservice;
	@Autowired
	OrderdetailService ordetailService;
	
	
	public OrderDTO mapOrderEntityToDto(Order or,int tongtien) {
		OrderDTO ordto = new OrderDTO();
		ordto.setId(or.getId());
		ordto.setCusdto(cusconvert.mapCustomerclassEntityToDto(or.getCustomer()));
		ordto.setOrderDate(or.getOrderDate());
		ordto.setAddress(or.getAddress());
		ordto.setStatus(or.getStatus());
		ordto.setFormofpayment(or.getFormofpayment());
		ordto.setTongtien(tongtien);
		return ordto;
	}
	public Order mapOrderDtoToEntity(OrderDTO or) {
		Order ordto = new Order();
		ordto.setId(or.getId());
		ordto.setCustomer(cusconvert.mapCustomerclassDtoToEntity(or.getCusdto()));
		ordto.setOrderDate(or.getOrderDate());
		ordto.setAddress(or.getAddress());
		ordto.setStatus(or.getStatus());
		ordto.setFormofpayment(or.getFormofpayment());
		return ordto;
	}
	
	public OrderdetailDTO mapOrderdetailEntityToDto(Orderdetail ordetail) {
		OrderdetailDTO ordetaildto = new OrderdetailDTO();
		ordetaildto.setId(ordetail.getId());
		ordetaildto.setOrder(mapOrderEntityToDto(ordetail.getOrder(),ordetailService.sumprice(ordetail.getOrder().getId())));
		ordetaildto.setPro(productservice.findOne(ordetail.getProduct().getId()));
		ordetaildto.setSl(ordetail.getQuantity());
		ordetaildto.setPrice(ordetail.getPrice());
		return ordetaildto;
	}
	
	public Orderdetail mapOrderdetailDtoToEntity(OrderdetailDTO ordetaildto) {
		Orderdetail ordetail = new Orderdetail();
		ordetail.setId(ordetaildto.getId());
		ordetail.setOrder(mapOrderDtoToEntity(ordetaildto.getOrder()));
		ordetail.setProduct(proconvert.mapProductDtoToEntity(ordetaildto.getPro()));
		ordetail.setQuantity(ordetaildto.getSl());
		ordetail.setPrice(ordetaildto.getPrice());
		return ordetail;
	}
	
	
}
