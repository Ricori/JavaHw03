package app.db;

import java.sql.SQLException;
import app.entity.TripOrderInfo;

public class TripOrderInfoDAO extends DBHelperDAO{

	@Override
	protected Object rsobj() throws SQLException {
		return new TripOrderInfo(
				rs.getInt("id"),
				rs.getInt("passenger"),
				rs.getInt("driver"),
				rs.getString("startplace"),
				rs.getString("endplace"),
				rs.getInt("peoplenum"),
				rs.getDouble("price"),
				rs.getInt("pstartstate"),
				rs.getInt("dstartstate"),
				rs.getInt("pendstate"),
				rs.getInt("dendstate"),
				rs.getInt("payid")
				);
		
	}
}