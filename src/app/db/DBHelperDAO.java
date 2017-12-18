package app.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class DBHelperDAO {
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/taxiapp";
	public static final String USER = "root";
	public static final String PWD = "root";

	private Connection conn;
	private Statement stat;
	protected ResultSet rs;

	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void setConn() {
		try {
			conn = DriverManager.getConnection(URL, USER, PWD);
			if (!conn.isClosed()) {
				// System.out.println("conn ok");
			} else
				System.out.println("conn error");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected abstract Object rsobj() throws SQLException;
	
	public List<Object> queryAll(String sql) {
		setConn();
		List<Object> list = new ArrayList<Object>();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			while(rs.next()){
				list.add(rsobj());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cls();
		}
		return list;
	}

	/**取指定字段数据
	 * @param sql
	 * @param zd 字段名
	 */
	public Object find(String sql, String zd) {
		Object obj = null;
		setConn();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			rs.next();
			obj = rs.getObject(zd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public Object findById(String sql) {
		Object obj = null;
		setConn();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			if (rs.next()) {
				obj = rsobj();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public boolean update(String sql) {
		int a = 0;
		setConn();
		try {
			stat = conn.createStatement();
			if (stat.executeUpdate(sql) > 0) {
				a = 1;
			} else
				System.out.println("error");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cls();
		}
		if (a == 0)
			return false;
		return true;
	}

	private void cls() {
		if (rs != null) {
			try {
				rs.close();
				rs = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stat != null) {
			try {
				stat.close();
				stat = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


}
