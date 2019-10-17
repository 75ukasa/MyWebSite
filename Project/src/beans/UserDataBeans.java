package beans;

import java.io.Serializable;

public class UserDataBeans implements Serializable{
	private int id;
	private String loginId;
	private String password;
	private String userName;
	private String name;
	private String kana;
	private String zip;
	private String pref;
	private String address;
	private String tel;




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}


	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public String getKana() {
		return kana;
	}
	public void setKana(String kana) {
		this.kana = kana;
	}


	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}


	public String getPref() {
		return pref;
	}
	public void setPref(String pref) {
		this.pref = pref;
	}


	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
}
