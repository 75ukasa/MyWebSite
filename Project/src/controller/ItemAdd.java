package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ItemDataBeans;
import dao.ItemDAO;

/**
 * Servlet implementation class ItemAdd
 */
@WebServlet("/ItemAdd")
public class ItemAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

		// TODO Auto-generated method stub

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		/*文字化け対策*/
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();

		try {
			//選択された商品の数量
			//int num = Integer.parseInt(request.getParameter("num"));
			//選択された商品のID
			int Data = Integer.parseInt(request.getParameter("id"));

			//アイテム情報の取得
			ItemDataBeans item = ItemDAO.getItemDetail(Data);

			//アイテム情報をリクエストパラメータにセット
			request.setAttribute("item",item );
			//カートを取得
			ArrayList<ItemDataBeans> cart = (ArrayList<ItemDataBeans>) session.getAttribute("cart");

			//セッションにカートが無い場合カートを作成
			if(cart == null) {
				cart = new ArrayList<ItemDataBeans>();
			}

			//カートにアイテムを追加
			cart.add(item);

			//カート情報更新
			session.setAttribute("cart", cart);
			//session.setAttribute("num", num);

			//更新メッセージ
			request.setAttribute("cartActionMessage", "商品を追加しました");
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/cart.jsp");
			dispatcher.forward(request, response);
		}
		catch (Exception e){
			e.printStackTrace();
			session.setAttribute("errorMessarge", e.toString());
			response.sendRedirect("Error");

		}

	}

}
