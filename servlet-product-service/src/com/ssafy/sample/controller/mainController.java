package com.ssafy.sample.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.event.TableColumnModelListener;

import org.omg.CosNaming._BindingIteratorImplBase;

import com.mysql.cj.Session;
import com.ssafy.sample.dto.Product;
import com.ssafy.sample.dto.User;
import com.ssafy.sample.model.service.ProductServiceImpl;
import com.ssafy.sample.model.service.UserServiceImpl;

/**
 * Servlet implementation class mainController
 */
@WebServlet("/main")
public class mainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mainController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void forward(HttpServletRequest request, HttpServletResponse response, String location) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher(location);
		dispatcher.forward(request, response);
	}
	
	protected void redirect(HttpServletRequest request, HttpServletResponse response, String location) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath()+ location);

	}
    
	protected void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		try {
			Product product=ProductServiceImpl.getImpl().select(request.getParameter("productCode"));
			
		
			request.setAttribute("product", product);
			forward(request, response, "/product/view.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		List<Product> list =  ProductServiceImpl.getImpl().list();
		request.setAttribute("products", list);
		forward(request, response, "/product/list.jsp");
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		redirect(request, response, "/product/list.jsp");

	}
	}
	protected void mvRegist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		redirect(request, response,"/product/regist.jsp");
	}
	protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String code =request.getParameter("productCode");
		String model =request.getParameter("productCode");
		String price =request.getParameter("price");
		System.out.println(code + " " + model + " " +code   );
		if (code == null) {
			request.setAttribute("msg", "code 다시입력");

			forward(request, response, "/product/regist.jsp");
			return ;
		}
		else if (model == null) {
			request.setAttribute("msg", "model 다시입력");
			forward(request, response, "/product/regist.jsp");

			mvRegist(request, response);

			return ;
		}
		else if (price == null) {
			request.setAttribute("msg", "price 다시입력");
			forward(request, response, "/product/regist.jsp");

			mvRegist(request, response);

			return ;
		}
		try {
			int num = Integer.parseInt(price);
			
			ProductServiceImpl.getImpl().regist(new Product(code,model,num));
		} catch (Exception e) {
			// TODO: handle exception
			//e.printStackTrace();
			//throw new ServletException();
			request.setAttribute("msg",  "다시입력");
			forward(request, response, "/product/regist.jsp");
			
		}
		
		request.setAttribute("msg", "성공하였습니다");
		forward(request, response, "/index.jsp");
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name=request.getParameter("name");
		String password=request.getParameter("password");

		try {
			int result = UserServiceImpl.getImpl().login(new User(name, password));
			HttpSession session  =request.getSession();
			if (result !=-1) {
				session.setAttribute("loginUser", new User(name, password));

			}
			else {
				session.setAttribute("loginUser", null);
				request.setAttribute("msg", "없");
			forward(request, response, "/index.jsp");

			}
			redirect(request, response, "/index.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		session.invalidate();
		redirect(request, response, "/index.jsp");

	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			int result = ProductServiceImpl.getImpl().delete(request.getParameter("productCode"));
			
			redirect(request, response, "/main?action=list");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			redirect(request, response, "/main?action=list");

		}
		
	}
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		String action =request.getParameter("action");
		System.out.print("sdasdsa");
		if ("list".equals(action)) {
			
			list(request,response);
		}
		else if ("view".equals(action)) 
		{
			detail(request, response);
		}
		else if ("delete".equals(action)) {
			delete(request, response);
		}
		else if ("regist".equals(action)) {
			regist(request, response);
		}
		else if ("mvRegist".equals(action)) 
		{

			mvRegist(request, response);
		}
		else if ("login".equals(action)) {
			login(request, response);
		}
		else if ("logout".equals(action)) {
			logout(request, response);
		}
		else {
			redirect(request, response, "/error/error.jsp");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
