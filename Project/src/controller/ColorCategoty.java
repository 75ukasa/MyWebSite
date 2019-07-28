package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ItemDataBeans;
import dao.CategoryDAO;

/**
 * Servlet implementation class ColorCategoty
 */
@WebServlet("/ColorCategoty")
public class ColorCategoty extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ColorCategoty() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Data = request.getParameter("id");


		if(Data.equals("ホワイト")) {
			try {
				ArrayList<ItemDataBeans>itemList = CategoryDAO.getColorItemData(Data);
				request.setAttribute("itemList",itemList);
				request.setAttribute("Name",Data);

				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/clothList.jsp");
				dispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		}else if(Data.equals("ブルー")) {
			try {
				ArrayList<ItemDataBeans>itemList = CategoryDAO.getColorItemData(Data);
				request.setAttribute("itemList",itemList);
				request.setAttribute("Name",Data);

				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/clothList.jsp");
				dispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		}else if(Data.equals("ピンク")) {
			try {
				ArrayList<ItemDataBeans>itemList = CategoryDAO.getColorItemData(Data);
				request.setAttribute("itemList",itemList);
				request.setAttribute("Name",Data);

				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/clothList.jsp");
				dispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		}else if(Data.equals("グレー")) {
			try {
				ArrayList<ItemDataBeans>itemList = CategoryDAO.getColorItemData(Data);
				request.setAttribute("itemList",itemList);
				request.setAttribute("Name",Data);

				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/clothList.jsp");
				dispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		}else if(Data.equals("ブラック")) {
			try {
				ArrayList<ItemDataBeans>itemList = CategoryDAO.getColorItemData(Data);
				request.setAttribute("itemList",itemList);
				request.setAttribute("Name",Data);

				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/clothList.jsp");
				dispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		}else if(Data.equals("マルチ")) {
			try {
				ArrayList<ItemDataBeans>itemList = CategoryDAO.getColorItemData(Data);
				request.setAttribute("itemList",itemList);
				request.setAttribute("Name",Data);

				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/clothList.jsp");
				dispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
