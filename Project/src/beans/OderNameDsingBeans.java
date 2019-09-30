package beans;

import java.io.Serializable;

public class OderNameDsingBeans implements Serializable{
	private int desingId;
	private String desingType;
	private int desingPrice;
	private String desingFile;






	public int getDesingId() {
		return desingId;
	}
	public void setDesingId(int desingId) {
		this.desingId = desingId;
	}


	public String getDesingType() {
		return desingType;
	}
	public void setDesingType(String desingType) {
		this.desingType = desingType;
	}


	public int getDesingPrice() {
		return desingPrice;
	}
	public void setDesingPrice(int desingPrice) {
		this.desingPrice = desingPrice;
	}


	public String getDesingFile() {
		return desingFile;
	}
	public void setDesingFile(String desingFile) {
		this.desingFile = desingFile;
	}

}