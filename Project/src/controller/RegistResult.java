package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserDataBeans;
import dao.SizeDAO;
import dao.UserDAO;


/**
 * 登録完了画面
 */
@WebServlet("/RegistResult")
public class RegistResult extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public RegistResult() {
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
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		try{
			UserDataBeans userData = new UserDataBeans();

			//beansに各ユーザー情報をセット
			userData.setName(request.getParameter("name"));
			userData.setKana(request.getParameter("kana"));
			userData.setLoginId(request.getParameter("login_id"));
			userData.setPassword(request.getParameter("password"));
			userData.setZip(request.getParameter("zip"));
			userData.setAddress(request.getParameter("address"));
			userData.setTel(request.getParameter("tel"));
			userData.setGender(request.getParameter("gender"));

			//ユーザー情報をDBへ追加
			UserDAO.insertUser(userData);
			request.setAttribute("udb",userData);

			//ユーザーIDの取得
			int userId = UserDAO.getUserId(userData.getLoginId(), userData.getPassword());

			//ユーザーのサイズ情報をDBへ仮追加
			SizeDAO.insertTemporarilyUserSize(userId);

			request.getRequestDispatcher(Forward.REGIST_RESULT_PAGE).forward(request, response);

			}catch(Exception e) {
				e.printStackTrace();
			}

		}
	}


