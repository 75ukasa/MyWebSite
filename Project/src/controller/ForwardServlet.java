package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForwardServlet
 */
@WebServlet("/ForwardServlet")
public class ForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForwardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String Date = request.getParameter("id");

		if(Date.equals("1")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/design.jsp");
			dispatcher.forward(request,response);
		}else if(Date.equals("2")){
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/size1.jsp");
			dispatcher.forward(request,response);
		}else if(Date.equals("3")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/size2.jsp");
			dispatcher.forward(request,response);
		}else if(Date.equals("4")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/cart.jsp");
			dispatcher.forward(request,response);
		}else if(Date.equals("5")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/order.jsp");
			dispatcher.forward(request,response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/home.jsp");
			dispatcher.forward(request,response);
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)//
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
