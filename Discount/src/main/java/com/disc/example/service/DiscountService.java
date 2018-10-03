package com.disc.example.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.disc.example.customException.InvalidAmount;
import com.disc.example.model.Slab;
import com.disc.example.utils.CSVReader;

@Service
public class DiscountService {

	private static final Logger LOGGER = Logger.getLogger("DisountService");

	@Autowired
	private CSVReader csvReader;
	@Value("${discount.fileName}")
	private String fileName;
   
	private List<Slab> discountList;

	@PostConstruct
	public void init() {
		System.out.println("service");
		setDiscountList(csvReader.loadObjectList(fileName));
		LOGGER.info("initialize discount coupon data");
	}

	public List<Slab> getData() {
		return discountList;
	}
	
	public Long getBillAmount(Long amount, String userType) {
		
		List<Slab> Slab = getSlab(amount, userType);
		
		Long totalDiscount = 0l;
		
		if(Slab != null) {
			
			totalDiscount = Slab.stream().map(e -> {
				
				if(amount > e.getEnd()) {
					return calculateDiscount(e.getDiscountPerc(), e.getEnd());
				}
				else {
					return calculateDiscount(e.getDiscountPerc(), amount - e.getStart());
				}
				
			}).collect(Collectors.summingLong(e -> e));
			
		}
		
		return amount - totalDiscount;
	}
	
	
	public Long calculateDiscount(int discount, Long amount) {
		
		return (amount * discount)/(100);
	}
	
	public List<Slab> getSlab(Long amount, String userType) {

		List<Slab> Slab = null;

		try {
			Slab = discountList.stream()
					.filter(e -> e.getUserType().equalsIgnoreCase(userType))
					.filter(e -> amount >= e.getStart())
					.collect(Collectors.toList());
		} catch (Exception e) {
			new InvalidAmount("Invalid Amount");
		}
		return Slab;
	}
	
	public CSVReader getCsvReader() {
		return csvReader;
	}

	public void setCsvReader(CSVReader csvReader) {
		this.csvReader = csvReader;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public List<Slab> getDiscountList() {
		return discountList;
	}

	public void setDiscountList(List<Slab> discountList) {
		this.discountList = discountList;
	}
}
