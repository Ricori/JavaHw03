﻿package app.entity;

import java.sql.Timestamp;

public class PayInfo {

	private Integer id;			//支付订单id
	private Integer orderid;	//对应的行程订单id
	private Integer passenger;	//乘客id编号
	private Integer driver;		//司机id编号
	private Double price;		//多少钱
	private Timestamp time;		//支付订单创建时间
	private Integer state;		//乘客支付状态

	public PayInfo() {}
	
	public PayInfo(Integer id, Integer orderid, Integer passenger, Integer driver, Double price, Timestamp time,
			Integer state) {
		this.id = id;
		this.orderid = orderid;
		this.passenger = passenger;
		this.driver = driver;
		this.price = price;
		this.time = time;
		this.state = state;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getOrderid() {
		return orderid;
	}
	
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	
	public Integer getPassenger() {
		return passenger;
	}

	public void setPassenger(Integer passenger) {
		this.passenger = passenger;
	}

	public Integer getDriver() {
		return driver;
	}

	public void setDriver(Integer driver) {
		this.driver = driver;
	}

	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Timestamp getTime() {
		return time;
	}
	
	public void setTime(Timestamp time) {
		this.time = time;
	}
	
	public Integer getState() {
		return state;
	}
	
	public void setState(Integer state) {
		this.state = state;
	}
	

}


