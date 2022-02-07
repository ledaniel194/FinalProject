package coding.mentor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;

import coding.mentor.constant.Constant;
import coding.mentor.db.DBUtil;
import coding.mentor.entity.ProductDetail;

public class ProductDetailDAO {
	public List<ProductDetail> getAllProduct () throws SQLException {
		// access to Database to get all category with show = 1 
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ProductDetail productDetail = null;
		
		
		List<ProductDetail> productDetails = new ArrayList<ProductDetail>();
		//use List because we take more than 1 record
		try {
			
			//make connection to MySQL
			conn = DBUtil.makeConnection();
			//System.out.println("conn"  + conn);
			String sql = "SELECT * FROM product";
			
			ps = conn.prepareStatement(sql);
		
			
			//System.out.println("ps"  + ps);

			rs = ps.executeQuery(); //sau khi lay data xong thi phai co 1 noi de chua no
			
			//System.out.println("rs"  + rs);
			//System.out.println("rs.next: "  + rs.next());

			
			//rs -> 1 record or many records
			while(rs.next()) {  // if (rs.next() == true
				// to check if there is a data in here or not (return boolean value)
				
				//wrap data from database into a Entity (ex: student)
				productDetail = new ProductDetail();
				productDetail.setId(rs.getLong("id"));
				productDetail.setName(rs.getString("name"));
				
				productDetail.setSize(rs.getString("size"));
				productDetail.setColor(rs.getString("color"));
				productDetail.setCountry(rs.getString("production_country"));
				productDetail.setMaterial(rs.getString("materials"));
				productDetail.setDescription(rs.getString("description"));
				productDetail.setCategoryId(rs.getLong("category_id"));
				productDetail.setPrice(rs.getString("price"));
				productDetail.setBrand(rs.getString("brand"));
				//byte[] content = rs.getBytes("image");
				productDetail.setImageCode(rs.getString("image"));
//				if (content != null) {
//				String base64Encoded = new String(Base64.encodeBase64(content), "UTF-8");
//				productDetail.setImageCode(base64Encoded);}
				
				//category.setImage(rs.getBytes("image"));
				//System.out.println("this is: " + category.toString() +" \n");
				//put records into a List
				//System.out.println(productDetail.getName() + "/n");
				productDetails.add(productDetail);
			} 
			return productDetails;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		
		finally {//after make connection, we have to close the connection using FINALLY (close from bottom to top)
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
		return null;
	}
	
	public int getTotalProduct() throws SQLException {
		// access to Database to get all category with show = 1 
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ProductDetail productDetail = null;
		
		
		//use List because we take more than 1 record
		try {
			
			//make connection to MySQL
			conn = DBUtil.makeConnection();
			//System.out.println("conn"  + conn);
			String sql = "SELECT COUNT(*) FROM product";
			
			ps = conn.prepareStatement(sql);
		
			
			//System.out.println("ps"  + ps);

			rs = ps.executeQuery(); //sau khi lay data xong thi phai co 1 noi de chua no
			
			//System.out.println("rs"  + rs);
			//System.out.println("rs.next: "  + rs.next());

			
			//rs -> 1 record or many records
			while(rs.next()) {  // if (rs.next() == true
				return rs.getInt(1);
				
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		
		finally {//after make connection, we have to close the connection using FINALLY (close from bottom to top)
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
		return 0;
	}
	
	public int getTotalProductByCategoryId (int roomId) throws SQLException {
		// access to Database to get all category with show = 1 
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ProductDetail productDetail = null;
		
		
		//use List because we take more than 1 record
		try {
			
			//make connection to MySQL
			conn = DBUtil.makeConnection();
			//System.out.println("conn"  + conn);
			String sql = "SELECT COUNT(*) FROM product where category_id=?";
			
			ps = conn.prepareStatement(sql);
			ps.setLong(1, roomId);
		
			
			//System.out.println("ps"  + ps);

			rs = ps.executeQuery(); //sau khi lay data xong thi phai co 1 noi de chua no
			
			//System.out.println("rs"  + rs);
			//System.out.println("rs.next: "  + rs.next());

			
			//rs -> 1 record or many records
			while(rs.next()) {  // if (rs.next() == true
				return rs.getInt(1);
				
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		
		finally {//after make connection, we have to close the connection using FINALLY (close from bottom to top)
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
		return 0;
	}

	public ProductDetail getProductDetailById (long productDetailId) throws SQLException {
		// access to Database to get all category with show = 1 
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ProductDetail productDetail = null;
		
		
		//use List because we take more than 1 record
		try {
			
			//make connection to MySQL
			conn = DBUtil.makeConnection();
			//System.out.println("conn"  + conn);
			String sql = "SELECT * FROM product where id=?";
			
			ps = conn.prepareStatement(sql);
			ps.setLong(1, productDetailId);
		
			
			//System.out.println("ps"  + ps);

			rs = ps.executeQuery(); //sau khi lay data xong thi phai co 1 noi de chua no
			
			//System.out.println("rs"  + rs);
			//System.out.println("rs.next: "  + rs.next());

			
			//rs -> 1 record or many records
			while(rs.next()) {  // if (rs.next() == true
				// to check if there is a data in here or not (return boolean value)
				
				//wrap data from database into a Entity (ex: student)
				productDetail = new ProductDetail();
				productDetail.setId(rs.getLong("id"));
				productDetail.setName(rs.getString("name"));
				
				productDetail.setSize(rs.getString("size"));
				productDetail.setColor(rs.getString("color"));
				productDetail.setCountry(rs.getString("production_country"));
				productDetail.setMaterial(rs.getString("materials"));
				
				productDetail.setDescription(rs.getString("description"));
				productDetail.setBrand(rs.getString("brand"));

				productDetail.setCategoryId(rs.getLong("category_id"));
				productDetail.setPrice(rs.getString("price"));
//				byte[] content = rs.getBytes("image");
				productDetail.setImageCode(rs.getString("image"));
//				if (content != null) {
//				String base64Encoded = new String(Base64.encodeBase64(content), "UTF-8");
//				productDetail.setImageCode(base64Encoded);}
				
				//category.setImage(rs.getBytes("image"));
				//System.out.println("this is: " + category.toString() +" \n");
				//put records into a List
				System.out.println(productDetail.getName() + "/n");
				
			} 
			return productDetail;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		
		finally {//after make connection, we have to close the connection using FINALLY (close from bottom to top)
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
		return null;
	}
	
	public List<ProductDetail> pagingProductByCategory(int index, int categoryId) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ProductDetail product = null;
        List<ProductDetail> products = new ArrayList<ProductDetail>();

        try {
            conn = DBUtil.makeConnection();
            String sql = "select * from product where category_id = ? limit 6 offset ? ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, categoryId);
            ps.setInt(2, (index-1)*Constant.NUMBER_OF_PRODUCT_PER_PAGE);
            rs = ps.executeQuery();

            while (rs.next()) {
                product = new ProductDetail();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setSize(rs.getString("size"));
                product.setColor(rs.getString("color"));
                product.setCountry(rs.getString("production_country"));
                product.setMaterial(rs.getString("materials"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getString("price"));
                product.setImageCode(rs.getString("image"));
                product.setCategoryId(rs.getInt("category_id"));
                product.setBrand(rs.getString("brand"));
                products.add(product);
            } 
            return products;
    } catch (Exception e) {
        e.printStackTrace();
    }  finally {
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
        return null;
    }
	
	public List<ProductDetail> pagingAllProduct(int index) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ProductDetail product = null;
        List<ProductDetail> products = new ArrayList<ProductDetail>();

        try {
            conn = DBUtil.makeConnection();
            String sql = "select * from product limit 6 offset ? ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index-1)*Constant.NUMBER_OF_PRODUCT_PER_PAGE);
            rs = ps.executeQuery();

            while (rs.next()) {
                product = new ProductDetail();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setSize(rs.getString("size"));
                product.setColor(rs.getString("color"));
                product.setCountry(rs.getString("production_country"));
                product.setMaterial(rs.getString("materials"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getString("price"));
                product.setImageCode(rs.getString("image"));
                product.setCategoryId(rs.getInt("category_id"));
                product.setBrand(rs.getString("brand"));
                products.add(product);
            } 
            return products;
    } catch (Exception e) {
        e.printStackTrace();
    }  finally {
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
        return null;
    }

}
