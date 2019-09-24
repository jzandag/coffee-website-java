package com.coffee.enums;

public enum Roles {
	ADMIN("admin","Admin"),
	USER("user","User"),
	MACHINE("machine", "Machine");
	
	private String value;
	private String description;
	


	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private Roles(String value, String description) {
		this.value=value;
		this.description=description;
	}
	
	public static Roles getInstance(Integer id) {
		for (Roles value: Roles.values()) {
			if(value.getValue().equals(id)) {
				return value;
			}
		}
		return null;
	}
}