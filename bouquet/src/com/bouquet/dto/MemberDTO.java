package com.bouquet.dto;

import java.util.Date;

public class MemberDTO {
	private String bid;
	private String bpw;
	private String bname;
	private String bphone;
	private String bemail;
	private String bzipcode;
	private String baddr1;
	private String baddr2;
	private Date regdate;
	
	public MemberDTO() {
	}

	public MemberDTO(String bid, String bpw, String bname, String bphone, String bemail, String bzipcode, String baddr1,
			String baddr2, Date regdate) {
		super();
		this.bid = bid;
		this.bpw = bpw;
		this.bname = bname;
		this.bphone = bphone;
		this.bemail = bemail;
		this.bzipcode = bzipcode;
		this.baddr1 = baddr1;
		this.baddr2 = baddr2;
		this.regdate = regdate;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getBpw() {
		return bpw;
	}

	public void setBpw(String bpw) {
		this.bpw = bpw;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBphone() {
		return bphone;
	}

	public void setBphone(String bphone) {
		this.bphone = bphone;
	}

	public String getBemail() {
		return bemail;
	}

	public void setBemail(String bemail) {
		this.bemail = bemail;
	}

	public String getBzipcode() {
		return bzipcode;
	}

	public void setBzipcode(String bzipcode) {
		this.bzipcode = bzipcode;
	}

	public String getBaddr1() {
		return baddr1;
	}

	public void setBaddr1(String baddr1) {
		this.baddr1 = baddr1;
	}

	public String getBaddr2() {
		return baddr2;
	}

	public void setBaddr2(String baddr2) {
		this.baddr2 = baddr2;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "MemberDTO [bid=" + bid + ", bpw=" + bpw + ", bname=" + bname + ", bphone=" + bphone + ", bemail="
				+ bemail + ", bzipcode=" + bzipcode + ", baddr1=" + baddr1 + ", baddr2=" + baddr2 + ", regdate="
				+ regdate + "]";
	}
	
	
}
