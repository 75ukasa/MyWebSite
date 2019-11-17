package beans;

import java.io.Serializable;

public class CartBeans implements Serializable{
	private int itemId;
	private int brandId;
	private String material;
	private String remark;
	private String cloth;
	private int num;
	private int unitPrice;
	private int subPrice;
	// brandDataBeansと結合
	private brandDataBeans brandDataBeans;





	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}


	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}


	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}


	public String getCloth() {
		return cloth;
	}
	public void setCloth(String cloth) {
		this.cloth = cloth;
	}


	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}


	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}


	public int getSubPrice() {
		return subPrice;
	}
	public void setSubPrice(int subPrice) {
		this.subPrice = subPrice;
	}


	public brandDataBeans getBrandDataBeans() {
		return brandDataBeans;
	}
	public void setBrandDataBeans(brandDataBeans brandDataBeans) {
		this.brandDataBeans = brandDataBeans;
	}
}