package com.company.dto;

public class MDto {
	   private int mno;
	   private String mid;
	   private String mname;
	   private String mpass;
	   private String memail;
	   private String mdate;
	   private String mip;
	   private String zonecode;
	   private String address;
	   private String address2;
	public MDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MDto(int mno, String mid, String mname, String mpass, String memail, String mdate, String mip,
			String zonecode, String address, String address2) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.mname = mname;
		this.mpass = mpass;
		this.memail = memail;
		this.mdate = mdate;
		this.mip = mip;
		this.zonecode = zonecode;
		this.address = address;
		this.address2 = address2;
	}
	@Override
	public String toString() {
		return "MDto [mno=" + mno + ", mid=" + mid + ", mname=" + mname + ", mpass=" + mpass + ", memail=" + memail
				+ ", mdate=" + mdate + ", mip=" + mip + ", zonecode=" + zonecode + ", address=" + address
				+ ", address2=" + address2 + "]";
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMpass() {
		return mpass;
	}
	public void setMpass(String mpass) {
		this.mpass = mpass;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public String getMdate() {
		return mdate;
	}
	public void setMdate(String mdate) {
		this.mdate = mdate;
	}
	public String getMip() {
		return mip;
	}
	public void setMip(String mip) {
		this.mip = mip;
	}
	public String getZonecode() {
		return zonecode;
	}
	public void setZonecode(String zonecode) {
		this.zonecode = zonecode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	
	
	
	

}
