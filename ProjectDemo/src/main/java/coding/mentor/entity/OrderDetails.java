package coding.mentor.entity;

public class OrderDetails {
	private int id;
	private int orderId;
	private int productId;
	
	
	public OrderDetails() {
		
	}
	
	
	public OrderDetails(int id, int orderId, int productId) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.productId = productId;
	}
	
	public OrderDetails(int orderId, int productId) {
		super();
		this.orderId = orderId;
		this.productId = productId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	
}
