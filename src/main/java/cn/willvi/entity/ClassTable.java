package cn.willvi.entity;

import java.util.Date;

public class ClassTable {
	private String c_name;
	private String c_address;
	private Date time;
	private String t_name;
	
	public ClassTable(String c_name, String c_address, Date time, String t_name) {
		super();
		this.c_name = c_name;
		this.c_address = c_address;
		this.time = time;
		this.t_name = t_name;
	}
	
	public ClassTable() {
		
	}

	@Override
	public String toString() {
		return "ClassTable [c_name=" + c_name + ", c_address=" + c_address + ", time=" + time + ", t_name=" + t_name
				+ "]";
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_address() {
		return c_address;
	}

	public void setC_address(String c_address) {
		this.c_address = c_address;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	
	
}
