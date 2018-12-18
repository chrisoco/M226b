package com.Hospital;

public class Floor {

	private String stockwerkName;
	private int zimmerAnz;

	public Floor(String stockwerkName, int zimmerAnz) {
		this.stockwerkName = stockwerkName;
		this.zimmerAnz     = zimmerAnz;
	}

	public String getStockwerkName() {
		return stockwerkName;
	}

}
