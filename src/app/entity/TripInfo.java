package app.entity;

import java.sql.Timestamp;

public class TripInfo {

	private Integer id;			//发布信息id编号
	private Integer passenger;	//乘客id编号
	private Integer order;		//是否有司机接单
	private Integer driver;		//接单司机id编号
	private Timestamp starttime;//出发时间
	private String startplace;	//出发地点
	private String endplace;	//目的地点
	private Integer peoplenum;	//人数
	private Double price;		//给多少钱

	public TripInfo() {}
	
	public TripInfo(Integer id, Integer passenger, Integer order, Integer driver, Timestamp starttime,
			String startplace, String endplace, Integer peoplenum, Double price) {
		this.id = id;
		this.passenger = passenger;
		this.order = order;
		this.driver = driver;
		this.starttime = starttime;
		this.startplace = startplace;
		this.endplace = endplace;
		this.peoplenum = peoplenum;
		this.price = price;
	}
	public TripInfo(Integer passenger, Integer order, Integer driver, Timestamp starttime,
			String startplace, String endplace, Integer peoplenum, Double price) {
		this.passenger = passenger;
		this.order = order;
		this.driver = driver;
		this.starttime = starttime;
		this.startplace = startplace;
		this.endplace = endplace;
		this.peoplenum = peoplenum;
		this.price = price;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getPassenger() {
		return passenger;
	}
	
	public void setPassenger(Integer passenger) {
		this.passenger = passenger;
	}
	
	public Integer getOrder() {
		return order;
	}
	
	public void setOrder(Integer order) {
		this.order = order;
	}
	
	public Integer getDriver() {
		return driver;
	}
	
	public void setDriver(Integer driver) {
		this.driver = driver;
	}
	
	public Timestamp getStarttime() {
		return starttime;
	}
	
	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}
	
	public String getStartplace() {
		return startplace;
	}
	
	public void setStartplace(String startplace) {
		this.startplace = startplace;
	}
	
	public String getEndplace() {
		return endplace;
	}
	
	public void setEndplace(String endplace) {
		this.endplace = endplace;
	}
	
	public Integer getPeoplenum() {
		return peoplenum;
	}
	
	public void setPeoplenum(Integer peoplenum) {
		this.peoplenum = peoplenum;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	

}


