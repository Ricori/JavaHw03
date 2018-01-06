package app.logic;

import java.util.ArrayList;
import java.util.List;
import app.db.TripOrderInfoDAO;
import app.entity.TripInfo;
import app.entity.TripOrderInfo;

public class OrderTrip {
	
	public TripOrderInfoDAO dao = new TripOrderInfoDAO();
	public final int pageSize = 5; //一页最多显示的已完成的行程数目
	
	/**查询用户进行中的行程
	 * @param id 用户id
	 * @param type 乘客还是司机
	 */
	public ArrayList<TripOrderInfo> searchTripingOrder(Integer userid,Integer type) {
		ArrayList<TripOrderInfo> allOrders = new ArrayList<TripOrderInfo>();
		String sqlTxt = "select * from trip_order_info where "
				+ (type == 0 ? "passenger=" : "driver=")
				+ userid;
		sqlTxt += " and "+ (type == 0 ? "p" : "d") +"endstate=0";
		//System.out.println("sql-->" + sqlTxt);
		List<Object> result = dao.queryAll(sqlTxt);
		for(int i = 0;i < result.size();i++){
			allOrders.add((TripOrderInfo)result.get(i));
		}
		return allOrders;
	}
	

	/**查询用户已经完成的行程
	 * @param userid 用户ID
	 * @param type 乘客还是司机
	 * @param fy 第几页
	 */
	public ArrayList<TripOrderInfo> serachEndTripOrder(Integer userid,Integer type,Integer fy){
		String sqlTxt = "select * from trip_order_info where "
				+ (type == 0 ? "passenger=" : "driver=")
				+ userid;
		sqlTxt += " and "+ (type == 0 ? "p" : "d") +"endstate=1";
		sqlTxt += " limit " + (fy-1)*pageSize +","+ pageSize;
		
		ArrayList<TripOrderInfo> allOrders = new ArrayList<TripOrderInfo>();
		//System.out.println("sql-->" + sqlTxt);
		List<Object> result = dao.queryAll(sqlTxt);
		for(int i = 0;i < result.size();i++){
			allOrders.add((TripOrderInfo)result.get(i));
		}
		return allOrders;
	}
	
	
	/**司机接单
	 * @param tripInfo 待接单行程对象
	 */
	public boolean confirmPulishTrip(TripInfo tripInfo){
	
		int passenger = tripInfo.getPassenger();
		int driver = tripInfo.getDriver();
		User u = new User();
		String passengerphone = u.getPhonenumber(passenger);
		String driverphone = u.getPhonenumber(driver);
		
		String sqlTxt = "insert into trip_order_info"
				+ "(passenger,driver,passengerphone,driverphone,startplace,endplace,peoplenum,price,"
				+ "pstartstate,dstartstate,pendstate,dendstate,payid)"
				+ "values("
				+ passenger + ","
				+ driver + ","
				+ passengerphone + ","
				+ driverphone + ","
				+ "'" + tripInfo.getStartplace() + "',"
				+ "'" + tripInfo.getEndplace() + "',"
				+ tripInfo.getPeoplenum() + ","
				+ tripInfo.getPrice() + ","
				+ "0,0,0,0,0)";
		
		System.out.println("sql-->" + sqlTxt);
		if(dao.update(sqlTxt))
			return true;
		return false;
		
	}
	
	/**司机确认到达约定地点
	 *  @param tripId 行程id
	 *   @param driverId 司机id
	 */
	public boolean driverConfirmstart(int tripId,int driverId){
		String sqlTxt= "update trip_order_info set dstartstate=1 where id=" + tripId
				+ " and driver=" + driverId;
		if(dao.update(sqlTxt))
			return true;
		return false;
	}
	
	/**司机确认到达目的地
	 * @param tripId 行程id
	 * @param driverId 司机id
	 */
	public boolean driverConfirmend(int tripId,int driverId){
		String sqlTxt= "update trip_order_info set dendstate=1 where id=" + tripId
				+ " and driver=" + driverId;
		if(dao.update(sqlTxt))
			return true;
		return false;
	}
	
	/**乘客确认上车
	 * @param tripId 行程id
	 * @param passengerId 乘客id
	 */
	public boolean passengerConfirmstart(int tripId,int passengerId){
		String sqlTxt= "update trip_order_info set pstartstate=1 where id=" + tripId
				+ " and passenger=" + passengerId;
		if(dao.update(sqlTxt))
			return true;
		return false;
	}
	
	/**乘客确认到达目的地
	 * @param tripId 行程id
	 * @param passengerId 乘客id
	 * @param payid 账单id
	 */
	public boolean passengerConfirmend(int tripId,int passengerId,int payid){
		String sqlTxt= "update trip_order_info set pendstate=1,payid="+ payid 
				+ " where id=" + tripId + " and passenger=" + passengerId;
		if(dao.update(sqlTxt))
			return true;
		return false;
	}
	
	/**返回订单对象
	 * @param tripId 行程id
	 */
	public TripOrderInfo getTripOrder(int tripId) {
		String sqlTxt = "select * from trip_order_info where id=" + tripId;
		return (TripOrderInfo)dao.findById(sqlTxt);
	}
	
}