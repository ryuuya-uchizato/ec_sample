package com.example.demo.common;

import lombok.Data;

@Data
public class Option {

	private String code;
	
	private String name;
	
	public Option() {
		
		this("","");
	}
	
	public Option(String code, String name) {
		
		this.code = code;
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		Option target = (Option)obj;
		return target.code.equals(code) && target.name.equals(name);
	}
	
	@Override
	public int hashCode() {
		
		return (code + name).hashCode();
	}
}
