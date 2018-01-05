package app.db;

import java.sql.SQLException;
import app.entity.PayInfo;

public class PayInfoDAO extends DBHelperDAO{
	
	@Override
	protected Object rsobj() throws SQLException {
		return new PayInfo(
				rs.getInt("id"),
				rs.getInt("orderid"),
				rs.getInt("passenger"),
				rs.getInt("driver"),
				rs.getDouble("price"),
				rs.getTimestamp("time"),
				rs.getInt("state")
			);
	}
}
