package app.logic;

import java.sql.SQLException;

import app.db.TripInfoDAO;
import app.entity.TripInfo;

public class PublishTrip {

	public TripInfoDAO dao = new TripInfoDAO();
	
	/**查询用户行程列表
	 * @param Userid 用户ID
	 */
	
	

	/**添加行程
	 * @param TripInfo 行程对象
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
