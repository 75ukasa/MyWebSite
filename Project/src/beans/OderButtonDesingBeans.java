package beans;

import java.io.Serializable;

public class OderButtonDesingBeans implements Serializable{
	private String buttonTyupe;
	private int buttonPrice;




	public String getButtonTyupe() {
		return buttonTyupe;
	}
	public void setButtonTyupe(String buttonTyupe) {
		this.buttonTyupe = buttonTyupe;
	}


	public int getButtonPrice() {
		return buttonPrice;
	}
	public void setButtonPrice(int buttonPrice) {
		this.buttonPrice = buttonPrice;
	}



}
