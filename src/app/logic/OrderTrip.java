package app.logic;

import java.util.ArrayList;
import java.util.List;
import app.db.TripOrderInfoDAO;
import app.entity.TripOrderInfo;

public class OrderTrip {
	
	public TripOrderInfoDAO dao = new TripOrderInfoDAO();
	public final int pageSize = 5; //一页最多显示的已完成的行程数目
	
	/**查询乘客用户进行中的行程
	 * @param id 用户id
	 */
	public ArrayList<TripOrderInfo> searchTripingOrder(Integer userid) {
		ArrayList<TripOrderInfo> allOrders = new ArrayList<TripOrderInfo>();
		String sqlTxt = "select * from trip_order_info where passenger=" + userid;
		sqlTxt += " and pendstate=0";
		System.out.println("sql-->" + sqlTxt);
		List<Object> result = dao.queryAll(sqlTxt);
		for(int i = 0;i < result.size();i++){
			allOrders.add((TripOrderInfo)result.get(i));
		}
		return allOrders;
	}
	
	
	/**查询乘客用户已经完成的行程
	 * @param userid 用户ID
	 * @param fy 第几页
	 */
	public ArrayList<TripOrderInfo> serachEndTripOrder(Integer userid,Integer fy){
		String sqlTxt = "select * from trip_order_info where passenger=" + userid;
		sqlTxt += " and pendstate=1";
		sqlTxt += " limit " + (fy-1)*pageSize +","+ pageSize;
		
		ArrayList<TripOrderInfo> allOrders = new ArrayList<TripOrderInfo>();
		System.out.println("sql-->" + sqlTxt);
		List<Object> result = dao.queryAll(sqlTxt);
		for(int i = 0;i < result.size();i++){
			allOrders.add((TripOrderInfo)result.get(i));
		}
		return allOrders;
	}
	
	
	
}