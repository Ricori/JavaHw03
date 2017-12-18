package app.db;

import java.sql.SQLException;
import app.entity.UserInfo;

public class UserInfoDAO extends DBHelperDAO{

	@Override
	protected Object rsobj() throws SQLException{	
		return new UserInfo(
			rs.getInt("id"),
			rs.getString("phone"),
			rs.getString("pwd"),
			rs.getInt("type"),
			rs.getInt("sex"),
			rs.getString("signature"),
			rs.getInt("tripid"),
			rs.getInt("orderid"),
			rs.getInt("payid"));
	}


}
