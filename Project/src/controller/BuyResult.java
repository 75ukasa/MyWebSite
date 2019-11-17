package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.BuyBeans;
import beans.CartBeans;
import dao.BuyDAO;

/**
 * Servlet implementation class BuyResult
 */
@WebServlet("/BuyResult")
public class BuyResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		try{
			//カート情報の取得
			ArrayList<CartBeans> cart = (ArrayList<CartBeans>) Helper.cutSessionAttribute(session,"cart");
			//オーダー情報の取得
			BuyBeans ordereDate = (BuyBeans) Helper.cutSessionAttribute(session,"orderData");

			//ログイン確認
			boolean isLogin = session.getAttribute("isLogin") != null ? (boolean) session.getAttribute("isLogin") : false;

			//非会員はユーザーID = 0 ： 会員は登録ID
			int  userId = 0;
			if(isLogin) {
				userId =  (int) session.getAttribute("userId");
			}

			ordereDate.setUserId(userId);

			//購入データを登録
			int buyId = BuyDAO.insertBuy(ordereDate);

		}catch(Exception e) {

		}
	}

}
