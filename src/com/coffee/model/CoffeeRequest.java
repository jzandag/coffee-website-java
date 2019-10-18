package com.coffee.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.directwebremoting.annotations.DataTransferObject;
import org.springframework.format.annotation.DateTimeFormat;

import com.coffee.base.BaseModel;
import com.google.gson.annotations.Expose;

@Entity
@Table(name = "coffee_request")
@DataTransferObject
public class CoffeeRequest extends BaseModel implements Serializable {

	private static final long serialVersionUID = -3907539899166748695L;
	
	@Expose
	private Long id;
	@Expose
	private Date applicationDate;
	@Expose private Date brewDate;
	@Expose private Integer coffeeLevel;
	@Expose private Integer creamerLevel;
	@Expose private Integer sugarLevel;
	@Expose private Integer status;
	@Expose private Integer queue;
	
	@Expose private Users user;
	@Expose private Configuration config;
	
	private String brewDatee;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "coffeereq_id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss") // This is for bind Date with @ModelAttribute
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "app_date")
	public Date getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}
	
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss") // This is for bind Date with @ModelAttribute
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "brew_date")
	public Date getBrewDate() {
		return brewDate;
	}
	public void setBrewDate(Date brewDate) {
		this.brewDate = brewDate;
	}
	
	@Column(name = "coffee_level")
	public Integer getCoffeeLevel() {
		return coffeeLevel;
	}
	public void setCoffeeLevel(Integer coffeeLevel) {
		this.coffeeLevel = coffeeLevel;
	}
	
	@Column(name = "creamer_level")
	public Integer getCreamerLevel() {
		return creamerLevel;
	}
	public void setCreamerLevel(Integer creamerLevel) {
		this.creamerLevel = creamerLevel;
	}
	
	@Column(name = "sugar_level")
	public Integer getSugarLevel() {
		return sugarLevel;
	}
	public void setSugarLevel(Integer sugarLevel) {
		this.sugarLevel = sugarLevel;
	}
	
	@Column(name = "status")
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	@Column(name = "queue")
	public Integer getQueue() {
		return queue;
	}
	public void setQueue(Integer queue) {
		this.queue = queue;
	}
	
	@OneToOne(fetch = FetchType.EAGER, targetEntity = Users.class)
	@JoinColumn(name = "userID")
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	
	@OneToOne(fetch = FetchType.EAGER, targetEntity = Configuration.class)
	@JoinColumn(name = "config")
	public Configuration getConfig() {
		return config;
	}
	public void setConfig(Configuration config) {
		this.config = config;
	}
	
	@Transient
	public String getBrewDatee() {
		return brewDatee;
	}
	public void setBrewDatee(String brewDatee) {
		this.brewDatee = brewDatee;
	}
	
}
