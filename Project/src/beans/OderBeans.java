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
	//OderSizeBeanseと結合
	private OderSizeBeanse sizeBeanse;
	//OderRequestBeansと結合
	private OderRequestBeans requestBeans;
	// OderPocketBeansと結合
	private OderPocketBeans pocketBeans;
	//OderNameDsingBeansと結合
	private OderNameDsingBeans nameDsingBeans;





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
}

