package coding.mentor.entity;

import java.util.Date;

public class Order {
	private int id;
	private int studentId;
	private Date submitDate;
	private boolean approve;
	
	
	public Order() {
		
	}
	public Order(int id, int studentId, Date submitDate, boolean approve) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.submitDate = submitDate;
		this.approve = approve;
	}
	
	public Order(int studentId, boolean approve) {
		super();
		this.studentId = studentId;
		this.approve = approve;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public Date getSubmitDate() {
		return submitDate;
	}
	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}
	public boolean isApprove() {
		return approve;
	}
	public void setApprove(boolean approve) {
		this.approve = approve;
	}
	
	
	
}
