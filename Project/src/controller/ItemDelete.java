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

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import beans.CartBeans;

/**
 * Servlet implementation class ItemDelete
 */
@WebServlet("/ItemDelete")
public class ItemDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * カートアイテムの変更
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		try {
			ArrayList<CartBeans> cart = (ArrayList<CartBeans>) session.getAttribute("cart");
			//nullチェック
			if(!CollectionUtils.isEmpty(cart)) {
				int Id  = Integer.parseInt(request.getParameter("id"));
				String cartActionMessage = "";

				if(Id == 1) {
					//カートアイテムの消去
					int DeleteItemID = Integer.parseInt(request.getParameter("delete_id"));
					for(CartBeans cartItem : cart) {
						if(cartItem.getItemId() == DeleteItemID) {
							cart.remove(cartItem);
							break;
						}
					}
					cartActionMessage = "消去しました";
					request.setAttribute("cartActionMessage", cartActionMessage);
					//フォワード
					RequestDispatcher dispatcher = request.getRequestDispatcher(Forward.CART_PAGE);
					dispatcher.forward(request, response);

				}else if(Id == 2) {
					//カートアイテムの数量変更
					//nullチェック
					if(!StringUtils.isBlank(request.getParameter("num"))){
						int num = Integer.parseInt(request.getParameter("num"));
						int ChangeItemID = Integer.parseInt(request.getParameter("Change_id"));

						for(CartBeans cartItem : cart) {
							if(cartItem.getItemId() == ChangeItemID) {
								cartItem.setNum(num);
								break;
							}
						}
						cartActionMessage = "枚数を変更しました";
						request.setAttribute("cartActionMessage", cartActionMessage);
						//フォワード
						RequestDispatcher dispatcher = request.getRequestDispatcher(Forward.CART_PAGE);
						dispatcher.forward(request, response);
					}else{
						cartActionMessage = "枚数を記入してください";
						request.setAttribute("cartActionMessage", cartActionMessage);
						//フォワード
						RequestDispatcher dispatcher = request.getRequestDispatcher(Forward.CART_PAGE);
						dispatcher.forward(request, response);
					}
				}
			}else {
				//カートのセッションが無かった場合
				String cartActionMessage = "カートに商品はありません";
				request.setAttribute("cartActionMessage", cartActionMessage);
				//セッションが存在しない場合はカートへフォワード
				request.getRequestDispatcher(Forward.CART_PAGE).forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}

	}

}
