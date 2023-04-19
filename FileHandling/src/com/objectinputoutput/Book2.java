package com.objectinputoutput;

import java.io.Serializable;

public class Book2 implements Serializable{
	
	int bid;
	String name;
	 transient  float price;
	public Book2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book2(int bid, String name, float price) {
		super();
		this.bid = bid;
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", name=" + name + ", price=" + price + "]";
	}
	
	
	

}
