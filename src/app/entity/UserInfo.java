package app.entity;

public class UserInfo {

	private Integer id;			//用户id编号
	private String phone;		//手机号
	private String pwd;			//用户密码
	private Integer type;		//类型(0表示乘客,1表示司机)
	private Integer sex;		//性别(0表示男,1表示女)
	private String signature;	//用户个性签名
	private Integer tripid;		//当前发布的行程信息id编号
	private Integer orderid;	//处于行程中的订单id编号
	private Integer payid;		//需要处理的支付订单id编号

	public UserInfo() {}

	public UserInfo(Integer id, String phone, String pwd, Integer type, Integer sex, 
			String signature, Integer tripid,Integer orderid, Integer payid) {
		this.id = id;
		this.phone = phone;
		this.pwd = pwd;
		this.type = type;
		this.sex = sex;
		this.signature = signature;
		this.tripid = tripid;
		this.orderid = orderid;
		this.payid = payid;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getPwd() {
		return pwd;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public Integer getType() {
		return type;
	}
	
	public void setType(Integer type) {
		this.type = type;
	}
	
	public Integer getSex() {
		return sex;
	}
	
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	
	public String getSignature() {
		return signature;
	}
	
	public void setSignature(String signature) {
		this.signature = signature;
	}
	
	public Integer getTripid() {
		return tripid;
	}
	
	public void setTripid(Integer tripid) {
		this.tripid = tripid;
	}
	
	public Integer getOrderid() {
		return orderid;
	}
	
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	
	public Integer getPayid() {
		return payid;
	}
	
	public void setPayid(Integer payid) {
		this.payid = payid;
	}
	

}


