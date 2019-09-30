package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import beans.OderBeans;
import beans.OderNameDsingBeans;
import beans.OderPocketBeans;
import beans.OderRequestBeans;
import beans.OderSizeBeanse;
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
			//エラーメッセージ用
			List<String> ActionMessage = new ArrayList<String>();
			//その他の要望用
			OderRequestBeans oderRequest = new OderRequestBeans();

			/* ==  == *///サイズ情報の処理
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
						}
					}else {
						//パラメータがnullもしくは空白の場合
						ActionMessage.add("サイズ記入欄を埋めてください");
						break;
					}
				}


				/* == シルエット情報の取得 == */
				int silhouetteId = Integer.parseInt(request.getParameter("style"));
				String silhouetteType = OderDAO.getOderSilhouette(silhouetteId);


				/* == 襟情報の取得 == */
				CharSequence collarId = request.getParameter("collar");
				oderRequest.setCollarRequest(request.getParameter("collarRequest"));

				String collarType = "";
				if(!StringUtils.isBlank(collarId)) {
					 collarType = OderDAO.getOderColler(collarId);
				}else {
					ActionMessage.add("襟のデザインを選択してください");
				}


				/* == カフスデザイン情報の取得 == */
				CharSequence cuffsDesingId= request.getParameter("cuffsDesing");
				oderRequest.setCuffsRequest(request.getParameter("cuffsRequest"));
				String cuffsDesingType = "";

				if(!StringUtils.isBlank(cuffsDesingId)) {
					cuffsDesingType = OderDAO.getOderCuffsDesing(cuffsDesingId);
				}else {
					ActionMessage.add("カフスのデザインを選択してください");
				}


				/* == カフスボタン情報の取得 == */
				CharSequence cuffsButtonId= request.getParameter("cuffsButton");
				String cuffsButtonType = "";

				if(!StringUtils.isBlank(cuffsButtonId)) {
					cuffsButtonType = OderDAO.getOderCuffsButton(cuffsButtonId);
				}else {
					ActionMessage.add("カフスのコンバーチブル仕様を選択してください");
				}


				/* == カフス時計情報の取得 == */
				CharSequence cuffWatchId= request.getParameter("cuffsWatch");
				String cuffsWatchType = "";

				if(!StringUtils.isBlank(cuffsButtonId)) {
					cuffsWatchType = OderDAO.getOderCuffsWatch(cuffWatchId);
				}else {
					ActionMessage.add("カフスの時計仕様を選択してください");
				}


				/* == ポケットデザイン情報の取得 == */
				CharSequence pocketId = request.getParameter("pocket");
				oderRequest.setPocketRequest(request.getParameter("pocketRequest"));
				OderPocketBeans oderPocket = new OderPocketBeans();

				if(!StringUtils.isBlank(pocketId)) {
					oderPocket = OderDAO.getOderPocket(pocketId);
				}else {
					ActionMessage.add("ポケット情報を入力してください");
				}


				/* == ネーム情報の取得 == */
				int name = Integer.parseInt(request.getParameter("nameDo_Not"));
				String nameDesingId = request.getParameter("nameDesing");
				String nameInitial = request.getParameter("nameInitial");
				String nameColorId1 = request.getParameter("nameColor1");
				String nameColorId2 = request.getParameter("nameColor2");
				String namePosition = request.getParameter("namePosition");

				OderNameDsingBeans nameDsing = new OderNameDsingBeans();
				String nameMessage = "";

				//ネームを入れない場合
				if(name == 1) {
					if(!nameDesingId.isEmpty() || !nameColorId1.isEmpty() || !nameColorId2.isEmpty() || !namePosition.isEmpty()) {
						ActionMessage.add("ネームを入れる場合は[ネームを入れる]を選択してください");
					}else {
						nameMessage = "ネームは入れない";
					}

				//ネームを入れる場合
				}else if(name == 2) {
					nameMessage = "ネームを入いれる";
					//デザイン情報の取得
					if(!nameDesingId.isEmpty()) {
						nameDsing = OderDAO.getOderNameDesing(nameDesingId);
					}else {
						ActionMessage.add("ネームの種類を選択してください");
					}

					//イニシャル情報処理
					if(!StringUtils.isBlank(nameInitial)) {

					}

				}

				//各オーダー情報をbeansにセット
				OderBeans oderData = new OderBeans();
				oderData.setSizeBeanse(oderSize);
				oderData.setSilhouetteType(silhouetteType);
				oderData.setCollarType(collarType);
				oderData.setCuffsDesingType(cuffsDesingType);
				oderData.setCuffsButtonType(cuffsButtonType);
				oderData.setCuffsWatchType(cuffsWatchType);
				oderData.setRequestBeans(oderRequest);
				oderData.setPocketBeans(oderPocket);
				oderData.setNameMessage(nameMessage);
				oderData.setNameDsingBeans(nameDsing);







				//エラーメッセージの確認
				if(!CollectionUtils.isEmpty(ActionMessage)){
					//エラーメッセージを確認した場合はカートへフォワード
					request.setAttribute("ActionMessage", ActionMessage);
					request.getRequestDispatcher("WEB-INF/jsp/order.jsp").forward(request, response);
				}else {
					session.setAttribute("oderData",oderData);
					request.getRequestDispatcher("WEB-INF/jsp/buy.jsp").forward(request, response);
				}

		}catch(Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}

	}

}
