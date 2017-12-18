package app.db;

import java.sql.SQLException;
import app.entity.TripInfo;

public class TripInfoDAO extends DBHelperDAO{

	@Override
	protected Object rsobj() throws SQLException{	
		return new TripInfo(
			rs.getInt("id"),
			rs.getInt("passenger"),
			rs.getInt("order"),
			rs.getInt("driver"),
			rs.getTimestamp("starttime"),
			rs.getString("startplace"),
			rs.getString("endplace"),
			rs.getInt("peoplenum"),
			rs.getDouble("price")
		);
	}


}
