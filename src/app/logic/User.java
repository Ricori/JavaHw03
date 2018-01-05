package app.logic;

import app.db.UserInfoDAO;
import app.entity.UserInfo;

public class User {

	public UserInfoDAO dao = new UserInfoDAO();
	
	/**检查用户登陆信息是否正确
	 * @param phone 手机号 
	 * @param pwd 密码
	 */
	public boolean checkUserLogin(String phone,String pwd) {
		String sqlTxt = "select count(*) from user_info "
				+ "where phone='" + phone + "' and pwd='"
				+ pwd + "'";
		//System.out.println("sql-->" + sqlTxt);
		int ts = new Long((Long)dao.find(sqlTxt,"count(*)")).intValue();
		if(ts > 0){
			return true;
		}
		return false;
	}
	
	/**用户登陆,返回用户对象
	 * @param phone 手机号
	 * @param pwd 密码
	 */
	public UserInfo userLogin(String phone,String pwd) {
		String sqlTxt = "select * from user_info "
				+ "where phone='" + phone + "' and pwd='"
				+ pwd + "'";
		System.out.println("sql-->" + sqlTxt);
		UserInfo user = (UserInfo)dao.findById(sqlTxt);
		if(user != null){
			return user;
		}
		
		return new UserInfo();
	}
	
	/**返回用户手机号码
	 * @param userid 用户id
	 */
	public int getPhonenumber(int userid) {
		String sqlTxt = "select * from user_info where id=" + userid;
		UserInfo user = (UserInfo)dao.findById(sqlTxt);
		return Integer.parseInt(user.getPhone());
	}
	
}
