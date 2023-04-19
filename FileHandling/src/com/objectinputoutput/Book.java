package com.objectinputoutput;

import java.io.Serializable;

public class Book implements Serializable{
	
	int bid;
	String name;
	float price;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int bid, String name, float price) {
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
