package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ItemDataBeans;
/**
 * Servlet implementation class Buy
 */
@WebServlet("/Order")
public class Order extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Order() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//セッション
		HttpSession session = request.getSession();

		try {

			//カートアイテム取得
			ArrayList<ItemDataBeans> cart = (ArrayList<ItemDataBeans>) session.getAttribute("cart");

			//カートが無かった場合
			if (cart == null) {
				cart = new ArrayList<ItemDataBeans>();
				session.setAttribute("cart", cart);
			}


			//カートの中身を確認
			if(cart.size() != 0) {
				request.getRequestDispatcher(Forward.ORDER_PAGE).forward(request, response);
			}else {
				request.setAttribute("cartActionMessage", "購入する商品がありません");
				request.getRequestDispatcher(Forward.CART_PAGE).forward(request, response);
			}

		}catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

}
