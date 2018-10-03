package com.disc.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.disc.example.model.Slab;
import com.disc.example.service.DiscountService;

@RestController
public class DiscountController {
	
	@Autowired
	private DiscountService discountService;

	@GetMapping(value = "/discount")
	public Long getUserData(@RequestParam("userType") String userType, @RequestParam("amount") Long userAmount) {

		return discountService.getBillAmount(userAmount, userType);
	}
	@GetMapping(value = "/discount1/{userType}/{amount}")
	public Long getUserData1(@PathVariable("userType") String userType, @PathVariable("amount") Long userAmount) {

		return discountService.getBillAmount(userAmount, userType);
		
	}
	
	@GetMapping("/getData")
	public List<Slab> getAllData() {
		return discountService.getData();
	}
	public DiscountService getDiscountService() {
		return discountService;
	}
	public void setDiscountService(DiscountService discountService) {
		this.discountService = discountService;
	}

	
}
