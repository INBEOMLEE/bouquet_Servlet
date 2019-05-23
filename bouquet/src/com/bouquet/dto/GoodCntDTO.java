package com.bouquet.dto;

public class GoodCntDTO {
	private String bid;
	private int bno;
	
	public GoodCntDTO() {
	}

	public GoodCntDTO(String bid, int bno) {
		super();
		this.bid = bid;
		this.bno = bno;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	@Override
	public String toString() {
		return "GoodCntDTO [bid=" + bid + ", bno=" + bno + "]";
	}
	
	
}
