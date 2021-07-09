package webmypham.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import Interface.dashboardTopdoanhthu;
import Interface.dashboardTopsoluong;
import webmypham.DTO.ProductDTO;
import webmypham.service.ImportService;
import webmypham.service.OrderService;
import webmypham.service.OrderdetailService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DashboardController {
	
	@Autowired
	ImportService importservice;
	@Autowired
	OrderService orderservice;
	@Autowired
	OrderdetailService orderdetailService;
	
	@GetMapping(value="/tongtienhang/{month}")
	public int get(@PathVariable("month")int month) {
		return importservice.getTongtienhang(month);
	}
	
	@GetMapping(value="/tongtienban/{month}")
	public int getban(@PathVariable("month")int month) {
		return orderservice.getTongtienban(month);
	}
	@GetMapping(value="/tonghoadon/{month}")
	public int gethoadon(@PathVariable("month")int month) {
		return orderservice.gettonghoadon(month);
	}

	@GetMapping(value="/tongkhachang/{month}")
	public int getkhachhang(@PathVariable("month")int month) {
		return orderservice.gettongkhachhang(month);
	}
	
	@GetMapping(value="/tongdonhanghoanthanh/{month}")
	public int getdonhang(@PathVariable("month")int month) {
		return orderservice.gettongdonhanghoanthanh(month);
	}
	
	@GetMapping(value="/tongdonhanghuy/{month}")
	public int getdonhanghuy(@PathVariable("month")int month) {
		return orderservice.gettongdonhanghuy(month);
	}

	@GetMapping(value="/topsanphamtheosoluong")
	public List<dashboardTopdoanhthu> gettopsoluong() {
		return orderdetailService.topsanphamtheosoluong();
	}
	
	@GetMapping(value="/topsanphamtheodoanhthu")
	public List<dashboardTopdoanhthu> gettopdoangthu() {
		return orderdetailService.topsanphamtheodoangthu();
	}
	
}
