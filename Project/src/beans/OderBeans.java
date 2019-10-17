package beans;

import java.io.Serializable;

public class OderBeans implements Serializable{
	private String silhouetteType;
	private String collarType;
	private String cuffsDesingType;
	private String cuffsButtonType;
	private String cuffsWatchType;
	private String pocketDesing;
	private String nameMessage;
	private String nameSpelling;
	private String namePosition;
	private String buttonThread1;
	private String buttonThread2;
	//OderSizeBeanseと結合
	private OderSizeBeanse sizeBeanse;
	//OderRequestBeansと結合
	private OderRequestBeans requestBeans;
	// OderPocketBeansと結合
	private OderPocketBeans pocketBeans;
	//OderNameDesingBeansと結合
	private OderNameDsingBeans nameDsingBeans;
	//OderNameColorBeans
	private OderNameColorBeans nameColorBeans1;
	//OderNameColorBeans
	private OderNameColorBeans nameColorBeans2;
	//OderButtonDesingと結合
	private OderButtonDesingBeans buttonDesingBeans;
	//UserDataBeansと結合
	private UserDataBeans userDataBeans;
	//OderPriceBeansと結合
	private OderPriceBeans price;






	public String getSilhouetteType() {
		return silhouetteType;
	}
	public void setSilhouetteType(String silhouetteType) {
		this.silhouetteType = silhouetteType;
	}


	public String getCollarType() {
		return collarType;
	}
	public void setCollarType(String collarType) {
		this.collarType = collarType;
	}


	public String getCuffsDesingType() {
		return cuffsDesingType;
	}
	public void setCuffsDesingType(String cuffsDesingType) {
		this.cuffsDesingType = cuffsDesingType;
	}


	public String getCuffsButtonType() {
		return cuffsButtonType;
	}
	public void setCuffsButtonType(String cuffsButtonType) {
		this.cuffsButtonType = cuffsButtonType;
	}


	public String getCuffsWatchType() {
		return cuffsWatchType;
	}
	public void setCuffsWatchType(String cuffsWatchType) {
		this.cuffsWatchType = cuffsWatchType;
	}


	public String getPocketDesing() {
		return pocketDesing;
	}
	public void setPocketDesing(String pocketDesing) {
		this.pocketDesing = pocketDesing;
	}


	public String getNameMessage() {
		return nameMessage;
	}
	public void setNameMessage(String nameMessage) {
		this.nameMessage = nameMessage;
	}


	public String getNameSpelling() {
		return nameSpelling;
	}
	public void setNameSpelling(String nameSpelling) {
		this.nameSpelling = nameSpelling;
	}


	public String getNamePosition() {
		return namePosition;
	}
	public void setNamePosition(String namePosition) {
		this.namePosition = namePosition;
	}


	public String getButtonThread1() {
		return buttonThread1;
	}
	public void setButtonThread1(String buttonThread1) {
		this.buttonThread1 = buttonThread1;
	}


	public String getButtonThread2() {
		return buttonThread2;
	}
	public void setButtonThread2(String buttonThread2) {
		this.buttonThread2 = buttonThread2;
	}


	public OderSizeBeanse getSizeBeanse() {
		return sizeBeanse;
	}
	public void setSizeBeanse(OderSizeBeanse sizeBeanse) {
		this.sizeBeanse = sizeBeanse;
	}


	public OderRequestBeans getRequestBeans() {
		return requestBeans;
	}
	public void setRequestBeans(OderRequestBeans requestBeans) {
		this.requestBeans = requestBeans;
	}


	public OderPocketBeans getPocketBeans() {
		return pocketBeans;
	}
	public void setPocketBeans(OderPocketBeans pocketBeans) {
		this.pocketBeans = pocketBeans;
	}


	public OderNameDsingBeans getNameDsingBeans() {
		return nameDsingBeans;
	}
	public void setNameDsingBeans(OderNameDsingBeans nameDsingBeans) {
		this.nameDsingBeans = nameDsingBeans;
	}


	public OderNameColorBeans getNameColorBeans1() {
		return nameColorBeans1;
	}
	public void setNameColorBeans1(OderNameColorBeans nameColorBeans1) {
		this.nameColorBeans1 = nameColorBeans1;
	}


	public OderNameColorBeans getNameColorBeans2() {
		return nameColorBeans2;
	}
	public void setNameColorBeans2(OderNameColorBeans nameColorBeans2) {
		this.nameColorBeans2 = nameColorBeans2;
	}


	public OderButtonDesingBeans getButtonDesingBeans() {
		return buttonDesingBeans;
	}
	public void setButtonDesingBeans(OderButtonDesingBeans buttonDesingBeans) {
		this.buttonDesingBeans = buttonDesingBeans;
	}


	public UserDataBeans getUserDataBeans() {
		return userDataBeans;
	}
	public void setUserDataBeans(UserDataBeans userDataBeans) {
		this.userDataBeans = userDataBeans;
	}


	public OderPriceBeans getPrice() {
		return price;
	}
	public void setPrice(OderPriceBeans price) {
		this.price = price;
	}
}
