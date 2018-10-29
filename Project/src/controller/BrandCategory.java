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
 * Servlet implementation class BrandCategory
 */
@WebServlet("/BrandCategory")
public class BrandCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BrandCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Id = request.getParameter("id");
		String Date1 = request.getParameter("No");
		String Date2 = request.getParameter("data");

		if(Id.equals("1")) {
			try {
				ArrayList<ItemDataBeans>itemList = CategoryDAO.getBrandItemData(Id);
				request.setAttribute("itemList",itemList);
				request.setAttribute("No",Date1);
				request.setAttribute("data",Date2);

				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/clothList.jsp");
				dispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}


		}else if(Id.equals("2")){
			try {
				ArrayList<ItemDataBeans>itemList = CategoryDAO.getBrandItemData(Id);
				request.setAttribute("itemList",itemList);
				request.setAttribute("No",Date1);
				request.setAttribute("data",Date2);

				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/clothList.jsp");
				dispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}


		}else if(Id.equals("3")) {
			try {
				ArrayList<ItemDataBeans>itemList = CategoryDAO.getBrandItemData(Id);
				request.setAttribute("itemList",itemList);
				request.setAttribute("No",Date1);
				request.setAttribute("data",Date2);

				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/clothList.jsp");
				dispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}


		}else if(Id.equals("4")) {
			try {
				ArrayList<ItemDataBeans>itemList = CategoryDAO.getBrandItemData(Id);
				request.setAttribute("itemList",itemList);
				request.setAttribute("No",Date1);
				request.setAttribute("data",Date2);

				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/clothList.jsp");
				dispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}


		}else if(Id.equals("5")) {
			try {
				ArrayList<ItemDataBeans>itemList = CategoryDAO.getBrandItemData(Id);
				request.setAttribute("itemList",itemList);
				request.setAttribute("No",Date1);
				request.setAttribute("data",Date2);

				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/clothList.jsp");
				dispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}


		}else if(Id.equals("6")) {
			try {
				ArrayList<ItemDataBeans>itemList = CategoryDAO.getBrandItemData(Id);
				request.setAttribute("itemList",itemList);
				request.setAttribute("No",Date1);
				request.setAttribute("data",Date2);

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
