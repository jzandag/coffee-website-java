package com.coffee.enums;

public enum CoffeeStatusEnum {
	ONQUEUE(0,"On-queue"), 
	DONE(1,"Done"), 
	SCHEDULED(2,"Scheduled");
	
	private CoffeeStatusEnum(Integer id, String description) {
		this.id = id;
		this.description = description;
	}
	
	private Integer id;
	private String description;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public static CoffeeStatusEnum getInstance(Integer id) {
		for(CoffeeStatusEnum value :  CoffeeStatusEnum.values())
			if(value.getId().equals(id)) return value;
		return null;
	}
}
