package controller;

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
	 * @author tukasa
	 *
	 */
	public static boolean inputSizValidasion(String inputSize) {
		if(inputSize.matches("[0-9０-９.．]+")) {
			return true;
		}
		return false;
	}
}
