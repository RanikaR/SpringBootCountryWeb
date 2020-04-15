package com.cognixia.model;

import org.springframework.stereotype.Component;

@Component 
public class CountryWeb {
	
	private String name;
	private String capital;
	private int pop;
	
	// not needed?
//	public CountryWeb() {
//		super();
//		this.name = name;
//		this.capital = capital;
//		this.pop = pop;
//	}
	
	// getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public int getPop() {
		return pop;
	}
	public void setPop(int pop) {
		this.pop = pop;
	}
	
	

}
