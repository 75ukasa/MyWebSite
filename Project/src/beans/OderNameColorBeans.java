package beans;

import java.io.Serializable;

public class OderNameColorBeans implements Serializable{
	private String colorType;
	private int colorPrice;


	public String getColorType() {
		return colorType;
	}
	public void setColorType(String colorType) {
		this.colorType = colorType;
	}


	public int getColorPrice() {
		return colorPrice;
	}
	public void setColorPrice(int colorPrice) {
		this.colorPrice = colorPrice;
	}

}
