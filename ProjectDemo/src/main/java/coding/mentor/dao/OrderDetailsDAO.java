package coding.mentor.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import coding.mentor.db.DBUtil;
import coding.mentor.entity.Order;
import coding.mentor.entity.OrderDetails;

public class OrderDetailsDAO {
	public void addOrderDetails(OrderDetails orderDetails) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			conn = DBUtil.makeConnection();

			String sql = "INSERT INTO order_details (order_id, product_id) VALUE (?, ?)";
			ps = conn.prepareStatement(sql);

			// set parameter
			ps.setInt(1, orderDetails.getOrderId());
			ps.setInt(2, orderDetails.getProductId());
			ps.execute();

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
