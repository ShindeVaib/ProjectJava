package com.disc.example.model;

public class Slab {
	private String userType;
	private Long start;
	private Long end;
	private int discountPerc;

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Long getStart() {
		return start;
	}

	public void setStart(Long start) {
		this.start = start;
	}

	public Long getEnd() {
		return end;
	}

	public void setEnd(Long end) {
		this.end = end;
	}

	public int getDiscountPerc() {
		return discountPerc;
	}

	public void setDiscountPerc(int discountPerc) {
		this.discountPerc = discountPerc;
	}

	@Override
	public String toString() {
		return "Discount [userType=" + userType + ", start=" + start + ", end=" + end + ", discountPerc=" + discountPerc
				+ "]";
	}

	
}
