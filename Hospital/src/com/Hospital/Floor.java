/**
 * @author Christopher O'Connor
 * @date 21/12/2018
 * @version 0.3.1
 */

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
