package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import beans.UserDataBeans;
import dao.UserDAO;

/**
 * ユーザー登録入力内容確認画面
 */
@WebServlet("/RegistConfirm")
public class RegistConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     *
     */
    public RegistConfirm() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * 入力内容を確認 バリデーションエラーがある場合新規登録画面に遷移
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字化け対策
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		try {
			String userName = request.getParameter("name");
			String userKana = request.getParameter("kana");
			String loginId = request.getParameter("login_id");
			String password = request.getParameter("password");
			String userZip = request.getParameter("zip");
			String userAddress = request.getParameter("address");
			String userTel = request.getParameter("tel");
			String userGender = request.getParameter("gender");

			UserDataBeans udb = new UserDataBeans();
			udb.setName(userName);
			udb.setKana(userKana);
			udb.setLoginId(loginId);
			udb.setPassword(password);
			udb.setZip(userZip);
			udb.setAddress(userAddress);
			udb.setTel(userTel);

			String registMessage = "";

			// loginIdの重複をチェック
			if(UserDAO.isOverlapLoginId(loginId, 0)) {
				registMessage = "ほかのユーザーが使用中のログインIDです";
			}

			//男女の判断
			if(userGender.equals("1")) {
				udb.setGender("男性");
			}else if(userGender.equals("2")) {
				udb.setGender("女性");
			}


			//エラーメッセージがないなら確認画面へ
			if(StringUtils.isBlank(registMessage)) {
				request.setAttribute("udb", udb);
				request.getRequestDispatcher(Forward.REGIST_CONFIRM_PAGE).forward(request, response);
			}else {
				session.setAttribute("udb", udb);
				session.setAttribute("registMessage", registMessage);
				response.sendRedirect("Regist");
			}


		}catch(Exception e) {
				e.printStackTrace();
				session.setAttribute("errorMessage", e.toString());
				response.sendRedirect("Error");
		}
	}

}
