package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import beans.CartBeans;
import beans.OderBeans;
import beans.OderButtonDesingBeans;
import beans.OderNameColorBeans;
import beans.OderNameDsingBeans;
import beans.OderPocketBeans;
import beans.OderRequestBeans;
import beans.OderSizeBeanse;
import beans.UserDataBeans;
import dao.OderDAO;


/**
 * Servlet implementation class OderServlet
 */
@WebServlet("/OderServlet")
public class OderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//文字化け対策
		request.setCharacterEncoding("UTF-8");
		//セッション
		HttpSession session = request.getSession();

		try {
			List<Integer> price = new ArrayList<Integer>();
			//カートアイテムの取得
			List<CartBeans> cart = (ArrayList<CartBeans>) session.getAttribute("cart");
			if(!CollectionUtils.isEmpty(cart)) {
				//カートアイテムの値段を取得
				price = cart.stream().map(item -> item.getSubPrice()).collect(Collectors.toList());

				//各オーダー情報用beans
				OderBeans oderData = new OderBeans();
				//エラーメッセージ用
				List<String> ActionMessage = new ArrayList<String>();
				//その他の要望用
				OderRequestBeans oderRequest = new OderRequestBeans();

				/* == サイズ情報の処理  == */
				//各サイズ用beans
				OderSizeBeanse oderSize = new OderSizeBeanse();
				//サイズの値をまとめて取得
				String[] size = request.getParameterValues("size");
				for(int i = 0 ; i < size.length; i++) {
					//nullチェック
					if(!StringUtils.isBlank(size[i])) {
						//値チェック
						if (Helper.inputSizValidasion(size[i])) {
							//Beansに値をセット
							if(i == 0) {
								oderSize.setNeck(size[i]);
							}else if(i == 1) {
								oderSize.setShoulder(size[i]);
							}else if(i == 2) {
								oderSize.setArm(size[i]);
							}else if(i == 3) {
								oderSize.setSleeveRigt(size[i]);
							}else if(i == 4) {
								oderSize.setSleeveLeft(size[i]);
							}else if(i == 5) {
								oderSize.setBust(size[i]);
							}else if(i == 6) {
								oderSize.setWaist(size[i]);
							}else if(i == 7) {
								oderSize.setHips(size[i]);
							}else if(i == 8) {
								oderSize.setLength(size[i]);
							}else if(i == 9) {
								oderSize.setCuffsRigt(size[i]);
							}else if(i == 10) {
								oderSize.setCuffsLeft(size[i]);
							}else if(i == 11) {
								oderSize.setHeight(size[i]);
							}
						}else {
							//パラメータが数値以外の場合
							ActionMessage.add("サイズは数字で記入してください");
							break;
						}
						//サイズ情報をオーダーbeansにセット
						oderData.setSizeBeanse(oderSize);
					}else {
						//パラメータがnullもしくは空白の場合
						ActionMessage.add("サイズ記入欄を埋めてください");
						break;
					}
				}


				/* == シルエット情報の取得 == */
				int silhouetteId = Integer.parseInt(request.getParameter("style"));
				//シルエット情報をオーダーbeansにセット
				oderData.setSilhouetteType(OderDAO.getOderSilhouette(silhouetteId));


				/* == 襟情報の取得 == */
				CharSequence collarId = request.getParameter("collar");
				oderRequest.setCollarRequest(request.getParameter("collarRequest"));

				if(!StringUtils.isBlank(collarId)) {
					//シルエット情報をオーダーbeansにセット
					oderData.setCollarType(OderDAO.getOderColler(collarId));
				}else {
					ActionMessage.add("襟のデザインを選択してください");
				}


				/* == カフスデザイン情報の取得 == */
				CharSequence cuffsDesingId= request.getParameter("cuffsDesing");
				oderRequest.setCuffsRequest(request.getParameter("cuffsRequest"));

				if(!StringUtils.isBlank(cuffsDesingId)) {
					//カフスデザイン情報をオーダーbeansにセット
					oderData.setCuffsDesingType(OderDAO.getOderCuffsDesing(cuffsDesingId));
				}else {
					ActionMessage.add("カフスのデザインを選択してください");
				}


				/* == カフスボタン情報の取得 == */
				CharSequence cuffsButtonId= request.getParameter("cuffsButton");

				if(!StringUtils.isBlank(cuffsButtonId)) {
					//カフスボタン情報をオーダーbeansにセット
					oderData.setCuffsButtonType(OderDAO.getOderCuffsButton(cuffsButtonId));
				}else {
					ActionMessage.add("カフスのコンバーチブル仕様を選択してください");
				}


				/* == カフス時計情報の取得 == */
				CharSequence cuffWatchId= request.getParameter("cuffsWatch");

				if(!StringUtils.isBlank(cuffWatchId)) {
					//カフス時計情報をオーダーbeansにセット
					oderData.setCuffsWatchType(OderDAO.getOderCuffsWatch(cuffWatchId));
				}else {
					ActionMessage.add("カフスの時計仕様を選択してください");
				}


				/* == ポケットデザイン情報の取得 == */
				CharSequence pocketId = request.getParameter("pocket");
				oderRequest.setPocketRequest(request.getParameter("pocketRequest"));

				if(!StringUtils.isBlank(pocketId)) {
					OderPocketBeans oderPocket = OderDAO.getOderPocket(pocketId);
					//ポケットのオプション料金をpriceListに追加
					price.add(oderPocket.getPoketPrice());
					//ポケットデザイン情報をオーダーbeansにセット
					oderData.setPocketBeans(oderPocket);
				}else {
					ActionMessage.add("ポケット情報を入力してください");
				}


				/* == ネーム情報の取得 == */
				int doName = Integer.parseInt(request.getParameter("nameDo_Not"));
				String nameDesingId = request.getParameter("nameDesing");
				String nameInitial = request.getParameter("nameInitial");
				String nameColorId1 = request.getParameter("nameColor1");
				String nameColorId2 = request.getParameter("nameColor2");
				String namePosition = request.getParameter("namePosition");



				//ネームを入れない場合
				if(doName == 1) {
					if(!nameDesingId.isEmpty() || !nameColorId1.isEmpty() || !nameColorId2.isEmpty() || !namePosition.isEmpty()) {
						ActionMessage.add("ネームを入れる場合は[ネームを入れる]を選択してください");
					}else {
						oderData.setNameMessage("ネームは入れない");
					}

				//ネームを入れる場合
				}else if(doName == 2) {
					oderData.setNameMessage("ネームを入いれる");
					//ネームデザイン情報の取得
					if(!nameDesingId.isEmpty()) {
						OderNameDsingBeans nameDsing = OderDAO.getOderNameDesing(nameDesingId);
						//ネームデザインのオプション料金をpriceListに追加
						price.add(nameDsing.getDesingPrice());
						//ネームデザイン情報をオーダーbeansにセット
						oderData.setNameDsingBeans(nameDsing);
					}else {
						ActionMessage.add("ネームの種類を選択してください");
					}


					//--イニシャル情報処理--
					if(!StringUtils.isBlank(nameInitial)) {
						oderData.setNameSpelling(nameInitial);
					}else {
						ActionMessage.add("ネームのイニシャルを記入してください");
					}


					//--ネームカラー情報処理--
					if(nameDesingId.equals("1") || nameDesingId.equals("2") || nameDesingId.equals("3") || nameDesingId.equals("4") || nameDesingId.equals("5") || nameDesingId.equals("9") || nameDesingId.equals("10")) {
						//ネームカラーが１種類の場合
						if(!nameColorId1.isEmpty()) {
							OderNameColorBeans nameColor1 = OderDAO.getOderNameColor(nameColorId1);
							//ネームカラーのオプション料金をpriceListに追加
							price.add(nameColor1.getColorPrice());
							oderData.setNameColorBeans1(nameColor1);
						}else {
							ActionMessage.add("ネームのカラーを選択してください");
						}


					}else if(nameDesingId.equals("6") || nameDesingId.equals("7") || nameDesingId.equals("8")) {
						//ネームカラーが２種類の場合
						if(!nameColorId1.isEmpty() && !nameColorId2.isEmpty()) {
							OderNameColorBeans nameColor1 = OderDAO.getOderNameColor(nameColorId1);
							//ネームカラーのオプション料金をpriceListに追加
							price.add(nameColor1.getColorPrice());
							oderData.setNameColorBeans1(nameColor1);

							OderNameColorBeans nameColor2 = OderDAO.getOderNameColor(nameColorId2);
							//ネームカラーのオプション料金をpriceListに追加
							price.add(nameColor2.getColorPrice());
							oderData.setNameColorBeans2(nameColor2);
						}else {
							ActionMessage.add("ネームの種類 6) 7) 8)を選択された方はカラーを2種類選択してください");
						}
					}

					//--ネーム場所情報処理--
					if(!StringUtils.isBlank(namePosition)) {
						//ネーム場所情報をオーダーbeansにセット
						oderData.setNamePosition(OderDAO.getOderNamePosition(namePosition));
					}else {
						ActionMessage.add("ネームの場所を選択してください");
					}
				}


				/* == ボタン情報の取得 == */
				//--ボタンデザイン情報処理--
				int buttonDesindId = Integer.parseInt(request.getParameter("button"));
				OderButtonDesingBeans buttonDesing = OderDAO.getOderButtonDesing(buttonDesindId);
				//ボタンデザインのオプション料金をpriceListに追加
				price.add(buttonDesing.getButtonPrice());
				oderData.setButtonDesingBeans(buttonDesing);

				//--ボタン糸情報処理--
				int buttonThreadId1 = Integer.parseInt(request.getParameter("buttonThread"));
				int buttonThreadId2 = Integer.parseInt(request.getParameter("buttonHole"));

				oderData.setButtonThread1(OderDAO.getOderButtonThread(buttonThreadId1));
				oderData.setButtonThread2(OderDAO.getOderButtonThread(buttonThreadId2));

				/* == その他の要望 == */
				oderRequest.setOtherRequest(request.getParameter("otherRequest"));

				//各種の要望メッセージをOderBeansにセット
				oderData.setRequestBeans(oderRequest);


				/* == 個人情報の取得 == */
				String zip = request.getParameter("zip");
				String pref = request.getParameter("pref");
				String address = request.getParameter("address");
				String name = request.getParameter("name");
				String kana = request.getParameter("kana");
				String tel = request.getParameter("tel");

				UserDataBeans UserData = new UserDataBeans();

				//郵便番号処理
				if(!StringUtils.isBlank(zip)) {
					if(Helper.inputZipValidasion(zip)) {
						UserData.setZip(zip);
					}else {
						ActionMessage.add("郵便番号を正しく入力してください");
					}
				}else {
					ActionMessage.add("郵便番号を記入してください");
				}

				//都道府県処理
				if(!StringUtils.isBlank(pref)) {
					UserData.setPref(OderDAO.getOderPref(pref));
				}else {
					ActionMessage.add("都道府県を記入してください");
				}

				//市町村処理
				if(!StringUtils.isBlank(address)) {
					UserData.setAddress(address);
				}else {
					ActionMessage.add("市町村を記入してください");
				}

				//名前処理
				if(!StringUtils.isBlank(name)) {
					UserData.setName(name);
				}else {
					ActionMessage.add("名前を記入してください");
				}

				//ふりがな処理
				if(!StringUtils.isBlank(kana)) {
					if(Helper.inputKanaValidasion(kana)) {
						UserData.setKana(kana);
					}else {
						ActionMessage.add("ふりがなを正しく記入してください");
					}

				}else {
					ActionMessage.add("ふりがなを記入してください");
				}

				//電話番号処理
				if(!StringUtils.isBlank(tel)) {
					if(Helper.inputTelValidasion(tel)) {
						UserData.setTel(tel);
					}else {
						ActionMessage.add("電話番号を正しく記入してください");
					}
				}else {
					ActionMessage.add("電話番号を記入してください");
				}
				//ユーザー情報をOderBeansにセット
				oderData.setUserDataBeans(UserData);

				//合計金額
				oderData.setPrice(Helper.getTotalPrice(price));




				//エラーメッセージの確認
				if(!CollectionUtils.isEmpty(ActionMessage)){
					//エラーメッセージを確認した場合はオーダーフォームへフォワード
					request.setAttribute("ActionMessage", ActionMessage);
					request.getRequestDispatcher("WEB-INF/jsp/order.jsp").forward(request, response);
				}else {
					session.setAttribute("oderData",oderData);
					request.getRequestDispatcher("WEB-INF/jsp/buy.jsp").forward(request, response);
				}
			}else {
				//カートのセッションが無かった場合
				String cartActionMessage = "カートに商品はありません";
				request.setAttribute("cartActionMessage", cartActionMessage);
				//セッションが存在しない場合はカートへフォワード
				request.getRequestDispatcher("WEB-INF/jsp/cart.jsp").forward(request, response);
			}

		}catch(Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}

	}

}
