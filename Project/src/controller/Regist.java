package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

/**
 * Servlet implementation class Regist
 */
@WebServlet("/Regist")
public class Regist extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Regist() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * 会員登録画面へ遷移
	 *
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		//前ページ情報の取得
		String returnUrl = request.getParameter("url");

		if(!StringUtils.isBlank(returnUrl)) {
			//Sessionにリターンページ情報を書き込む
			session.setAttribute("returnUrl", returnUrl);
		}

		request.getRequestDispatcher(Forward.REGIST_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
