package beans;

import java.io.Serializable;

public class BuyBeans implements Serializable{
	private int userId;
	private String silhouetteType;
	private String collarType;
	private String cuffsDesignType;
	private String cuffsButtonType;
	private String cuffsWatchType;
	private String pocketDesign;
	private String nameMessage;
	private String nameSpelling;
	private String namePosition;
	private String buttonThread1;
	private String buttonThread2;
	//OderSizeBeanseと結合
	private OrderSizeBeanse sizeBeanse;
	//OderRequestBeansと結合
	private OrderRequestBeans requestBeans;
	// OderPocketBeansと結合
	private OrderPocketBeans pocketBeans;
	//OderNameDesingBeansと結合
	private OrderNameDesignBeans nameDesignBeans;
	//OderNameColorBeans
	private OrderNameColorBeans nameColorBeans1;
	//OderNameColorBeans
	private OrderNameColorBeans nameColorBeans2;
	//OderButtonDesingと結合
	private OrderButtonDesignBeans buttonDesingBeans;
	//UserDataBeansと結合
	private UserDataBeans userDataBeans;
	//OderPriceBeansと結合
	private OrderPriceBeans price;





	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}


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


	public String getCuffsDesignType() {
		return cuffsDesignType;
	}
	public void setCuffsDesingType(String cuffsDesignType) {
		this.cuffsDesignType = cuffsDesignType;
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


	public String getPocketDesign() {
		return pocketDesign;
	}
	public void setPocketDesing(String pocketDesign) {
		this.pocketDesign = pocketDesign;
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


	public OrderSizeBeanse getSizeBeanse() {
		return sizeBeanse;
	}
	public void setSizeBeanse(OrderSizeBeanse sizeBeanse) {
		this.sizeBeanse = sizeBeanse;
	}


	public OrderRequestBeans getRequestBeans() {
		return requestBeans;
	}
	public void setRequestBeans(OrderRequestBeans requestBeans) {
		this.requestBeans = requestBeans;
	}


	public OrderPocketBeans getPocketBeans() {
		return pocketBeans;
	}
	public void setPocketBeans(OrderPocketBeans pocketBeans) {
		this.pocketBeans = pocketBeans;
	}


	public OrderNameDesignBeans getNameDesignBeans() {
		return nameDesignBeans;
	}
	public void setNameDesignBeans(OrderNameDesignBeans nameDesignBeans) {
		this.nameDesignBeans = nameDesignBeans;
	}


	public OrderNameColorBeans getNameColorBeans1() {
		return nameColorBeans1;
	}
	public void setNameColorBeans1(OrderNameColorBeans nameColorBeans1) {
		this.nameColorBeans1 = nameColorBeans1;
	}


	public OrderNameColorBeans getNameColorBeans2() {
		return nameColorBeans2;
	}
	public void setNameColorBeans2(OrderNameColorBeans nameColorBeans2) {
		this.nameColorBeans2 = nameColorBeans2;
	}


	public OrderButtonDesignBeans getButtonDesingBeans() {
		return buttonDesingBeans;
	}
	public void setButtonDesingBeans(OrderButtonDesignBeans buttonDesingBeans) {
		this.buttonDesingBeans = buttonDesingBeans;
	}


	public UserDataBeans getUserDataBeans() {
		return userDataBeans;
	}
	public void setUserDataBeans(UserDataBeans userDataBeans) {
		this.userDataBeans = userDataBeans;
	}


	public OrderPriceBeans getPrice() {
		return price;
	}
	public void setPrice(OrderPriceBeans price) {
		this.price = price;
	}
}
