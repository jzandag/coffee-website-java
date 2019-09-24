package com.coffee.model;

import java.util.Date;

public class CoffeeRequestDTO {
	
	private Long id;
	private Date applicationDate;
	private Date brewDate;
	private Integer coffeeLevel;
	private Integer creamerLevel;
	private Integer sugarLevel;
	private Integer status;
	private Integer queue;
	private Integer configStatus;
	private Long userId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}
	public Date getBrewDate() {
		return brewDate;
	}
	public void setBrewDate(Date brewDate) {
		this.brewDate = brewDate;
	}
	public Integer getCoffeeLevel() {
		return coffeeLevel;
	}
	public void setCoffeeLevel(Integer coffeeLevel) {
		this.coffeeLevel = coffeeLevel;
	}
	public Integer getCreamerLevel() {
		return creamerLevel;
	}
	public void setCreamerLevel(Integer creamerLevel) {
		this.creamerLevel = creamerLevel;
	}
	public Integer getSugarLevel() {
		return sugarLevel;
	}
	public void setSugarLevel(Integer sugarLevel) {
		this.sugarLevel = sugarLevel;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getQueue() {
		return queue;
	}
	public void setQueue(Integer queue) {
		this.queue = queue;
	}
	public Integer getConfigStatus() {
		return configStatus;
	}
	public void setConfigStatus(Integer configStatus) {
		this.configStatus = configStatus;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
