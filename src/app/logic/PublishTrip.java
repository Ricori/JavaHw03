package app.logic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.db.TripInfoDAO;
import app.entity.TripInfo;

public class PublishTrip {

	public TripInfoDAO dao = new TripInfoDAO();
	
	/**查询用户发布中的行程列表
	 * @param userid 用户ID
	 */
	public ArrayList<TripInfo> serachPublishTrip(Integer userid){
		ArrayList<TripInfo> allTripInfos = new ArrayList<TripInfo>();
		String sqlTxt = "select * from trip_publish_info where passenger=" + userid;
		sqlTxt += " and `order`=0";  //没有司机接单
		System.out.println("sql-->" + sqlTxt);
		List<Object> result = dao.queryAll(sqlTxt);
		for(int i = 0;i < result.size();i++){
			allTripInfos.add((TripInfo)result.get(i));
		}
		return allTripInfos;
	}
	

	/**查询没有被接单的用户行程
	 * @param fy 第几页
	 */
	public ArrayList<TripInfo> serachNyacTripOrder(Integer fy){
		String sqlTxt = "select * from trip_publish_info where `order`= 0";
		sqlTxt += " limit " + (fy-1)*5 +","+ 5;
		ArrayList<TripInfo> allTripOrders = new ArrayList<TripInfo>();
		System.out.println("sql-->" + sqlTxt);
		List<Object> result = dao.queryAll(sqlTxt);
		for(int i = 0;i < result.size();i++){
			allTripOrders.add((TripInfo)result.get(i));
		}
		return allTripOrders;
	}
	
	
	/**添加行程
	 * @param tripInfo 行程对象
	 */
	public boolean addPublishTrip(TripInfo tripInfo) throws SQLException {
		
		String passenger = tripInfo.getPassenger().toString();
		String starttime = tripInfo.getStarttime().toString();
		String startplace = tripInfo.getStartplace();
		String endplace = tripInfo.getEndplace();
		String peoplenum = tripInfo.getPeoplenum().toString();
		String price = tripInfo.getPrice().toString();
		
		String sqlTxt = "insert into trip_publish_info"
				+ "(passenger,`order`,driver,starttime,startplace,endplace,peoplenum,price)"
				+ " values ('" + 
				 passenger + "','" +
				 0 + "','" +
				 0 + "','" +
				starttime + "','" +
				startplace + "','" +
				endplace + "','" +
				peoplenum + "','" +
				price + "')";
		System.out.println("sql-->" + sqlTxt);
		
		if(dao.update(sqlTxt))
			return true;
		
		return false;
		
	}
	
}
