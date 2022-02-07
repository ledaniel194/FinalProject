package coding.mentor.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import coding.mentor.db.DBUtil;
import coding.mentor.entity.Order;

public class OrderDAO {

	public int  addOrder(Order order) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			conn = DBUtil.makeConnection();

			String sql = "INSERT INTO order_list (student_id, submit_date, approve) VALUE (?, ?, ?)";
			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			// set parameter
			ps.setInt(1, order.getStudentId());
			ps.setDate(2, new Date(System.currentTimeMillis()));
			ps.setBoolean(3, order.isApprove());

			ps.execute();
			rs = ps.getGeneratedKeys();
//			System.out.println(rs.next());
			if (rs.next()) {
				int insertedId = rs.getInt(1);
				System.out.println(insertedId);
				return insertedId;
			}
			return 0;

		} finally {// after make connection, we have to close the connection using FINALLY (close
					// from bottom to top)
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}

	}
}
