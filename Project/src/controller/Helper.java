package controller;

import java.util.List;

import beans.OderPriceBeans;

public class Helper {


	static final String BUY_PAGE = "/WEB-INF/jsp/order.jsp";

	public static Helper getInstance() {
		return new Helper();
	}
	/**
	 * 測定値のバリデーション
	 *
	 * @param inputSize サイズ
	 * @return 引数が数字の場合 ; true
	 *
	 */
	public static boolean inputSizValidasion(String inputSize) {
		if(inputSize.matches("[0-9０-９.．]+")) {
			return true;
		}
		return false;
	}

	/**
	 * 郵便番号のバリデーション
	 *
	 * @param inputZip
	 * @return 引数が半角数字7桁の場合 ; true
	 *
	 */
	public static boolean inputZipValidasion(String inputZip) {
		if(inputZip.matches("^[0-9]{3}-?[0-9]{4}$")) {
			return true;
		}
		return false;
	}

	/**
	 * ひらがなのバリデーション
	 *
	 * @param inputKana
	 * @return 引数がひらがなの場合 ; true
	 *
	 */
	public static boolean inputKanaValidasion(String inputKana) {
		if(inputKana.matches("^[ぁ-んー 　]*$")) {
			return true;
		}
		return false;
	}

	/**
	 * 電話番号のバリデーション
	 *
	 * @param inputKana
	 * @return 引数が半角数字で10桁以上の場合 ; true
	 *
	 */
	public static boolean inputTelValidasion(String inputTel) {
		if(inputTel.matches("^[0-9]+$") && inputTel.length() > 10){
			return true;
		}
		return false;
	}

	/**
	 * 合計金額の算出
	 *
	 * @param priceList [List<Integer>]
	 * @return oderPrice [OderPriceBeans] : 料金情報を持つBeans
	 */
	public static OderPriceBeans getTotalPrice(List<Integer> priceList) {
		OderPriceBeans oderPrice = new OderPriceBeans();
		//配送料
		int delivary = 500;
		//小計
		int subtotal = priceList.stream().mapToInt(price -> price).sum();
		oderPrice.setSubtotal(subtotal + delivary);;

		//税込み価格
		oderPrice.setTotal((int) (subtotal * 1.10));
		return oderPrice;
	}
}
