package beans;

import java.io.Serializable;

public class OrderPocketBeans implements Serializable{
	private String pocketType;
	private int poketPrice;




	public String getPocketType() {
		return pocketType;
	}
	public void setPocketType(String pocketType) {
		this.pocketType = pocketType;
	}


	public int getPoketPrice() {
		return poketPrice;
	}
	public void setPoketPrice(int poketPrice) {
		this.poketPrice = poketPrice;
	}
}


