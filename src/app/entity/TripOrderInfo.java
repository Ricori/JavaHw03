package app.entity;

public class TripOrderInfo {

	private Integer id;			//行程订单id
	private Integer passenger;	//乘客id编号
	private Integer driver;		//司机id编号
	private Integer passengerphone;	//乘客手机号
	private Integer driverphone;	//司机手机号
	private String startplace;	//出发地点
	private String endplace;	//目的地点
	private Integer peoplenum;	//人数
	private Double price;		//多少钱
	private Integer pstartstate;//乘客是否到达出发地(0表示未到达,1表示到达)
	private Integer dstartstate;//司机是否确认出发(0表示未确认，1表示确认)
	private Integer pendstate;	//乘客是否确认到达目的地(司机确认到达后将生成支付订单，并发送给乘客)
	private Integer dendstate;	//司机是否确认到达目的地(0表示未确认，1表示确认)
	private Integer payid;		//对应支付订单id

	public TripOrderInfo() {}

	public TripOrderInfo(Integer id, Integer passenger, Integer driver, Integer passengerphone,
			Integer driverphone,String startplace, String endplace,Integer peoplenum, Double price, 
			Integer pstartstate, Integer dstartstate, Integer pendstate,Integer dendstate, Integer payid) {
		this.id = id;
		this.passenger = passenger;
		this.driver = driver;
		this.passengerphone = passengerphone;
		this.driverphone = driverphone;
		this.startplace = startplace;
		this.endplace = endplace;
		this.peoplenum = peoplenum;
		this.price = price;
		this.pstartstate = pstartstate;
		this.dstartstate = dstartstate;
		this.pendstate = pendstate;
		this.dendstate = dendstate;
		this.payid = payid;
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
	
	public Integer getDriver() {
		return driver;
	}
	
	public void setDriver(Integer driver) {
		this.driver = driver;
	}
	
	public Integer getPassengerphone() {
		return passengerphone;
	}

	public void setPassengerphone(Integer passengerphone) {
		this.passengerphone = passengerphone;
	}

	public Integer getDriverphone() {
		return driverphone;
	}

	public void setDriverphone(Integer driverphone) {
		this.driverphone = driverphone;
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
	
	public Integer getPstartstate() {
		return pstartstate;
	}
	
	public void setPstartstate(Integer pstartstate) {
		this.pstartstate = pstartstate;
	}
	
	public Integer getDstartstate() {
		return dstartstate;
	}
	
	public void setDstartstate(Integer dstartstate) {
		this.dstartstate = dstartstate;
	}
	
	public Integer getPendstate() {
		return pendstate;
	}
	
	public void setPendstate(Integer pendstate) {
		this.pendstate = pendstate;
	}
	
	public Integer getDendstate() {
		return dendstate;
	}
	
	public void setDendstate(Integer dendstate) {
		this.dendstate = dendstate;
	}
	
	public Integer getPayid() {
		return payid;
	}
	
	public void setPayid(Integer payid) {
		this.payid = payid;
	}
	

}


