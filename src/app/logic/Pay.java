package app.logic;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import app.db.PayInfoDAO;
import app.entity.PayInfo;

public class Pay {
	
	public PayInfoDAO dao = new PayInfoDAO();
	
	/**乘客付款生成账单
	 * @param tripId 行程id
	 * @param passengerId 乘客id
	 * @param driverId 司机id
	 * @param price 价格
	 * @return 订单编号
	 */
	public int passengerPay(int tripId,int passengerId,int driverId,double price){
		String sqlTxt = "select MAX(id) from pay_info";
		int maxid = (int)dao.find(sqlTxt,"Max(id)");
		maxid++;
		Timestamp time = new Timestamp(System.currentTimeMillis());
		sqlTxt= "insert into pay_info values(" + maxid + ","
				+ tripId + "," + passengerId + "," + driverId + ","
				+ price + ",'" + time.toString() + "',1)";
		System.out.println("sql-->" + sqlTxt);
		if(dao.update(sqlTxt))
			return maxid;
		return 0;
	}
	
	
	/**查询乘客账单列表
	 * @param passengerId 乘客id
	 */
	public ArrayList<PayInfo> searchPassengerPay(Integer passengerId) {
		ArrayList<PayInfo> payInfos = new ArrayList<PayInfo>();
		String sqlTxt = "select * from pay_info where passenger=" + passengerId;
		List<Object> result = dao.queryAll(sqlTxt);
		for(int i = 0;i < result.size();i++){
			payInfos.add((PayInfo)result.get(i));
		}
		return payInfos;
	}
	
	/**查询司机账单列表
	 * @param driverId 司机id
	 */
	public ArrayList<PayInfo> searchDriverPay(Integer driverId) {
		ArrayList<PayInfo> payInfos = new ArrayList<PayInfo>();
		String sqlTxt = "select * from pay_info where driver=" + driverId;
		List<Object> result = dao.queryAll(sqlTxt);
		for(int i = 0;i < result.size();i++){
			payInfos.add((PayInfo)result.get(i));
		}
		return payInfos;
	}
}
