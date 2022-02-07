package coding.mentor.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

	public static Connection makeConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/final_project?serverTimezone=UTC", "new", "123123" );
			//jdbc:mysql://localhost/hive_metastore?serverTimezone=UTC
			return conn;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
