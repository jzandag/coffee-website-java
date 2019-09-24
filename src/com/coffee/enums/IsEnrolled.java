package com.coffee.enums;

public enum IsEnrolled {
	ENROLLED(1,"Enrolled"),
	NOT_ENROLLED(2,"Not Enrolled"),
	BANNED(3,"Banned");
	
	
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

	private IsEnrolled(Integer id, String description) {
		this.id=id;
		this.description=description;
	}
	
	public static IsEnrolled getInstance(Integer id) {
		for (IsEnrolled value: IsEnrolled.values()) {
			if(value.getId().equals(id)) {
				return value;
			}
		}
		return null;
	}
}
