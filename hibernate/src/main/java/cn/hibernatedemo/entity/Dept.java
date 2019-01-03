package cn.hibernatedemo.entity;

import java.io.Serializable;
/**
 *  部门表对应的实体类
 */
public class Dept implements Serializable {
	private Byte deptNo;
	private String deptName;
	private String location;
	public Dept() {
	}
	public Byte getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(Byte deptNo) {
		this.deptNo = deptNo;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	

}
