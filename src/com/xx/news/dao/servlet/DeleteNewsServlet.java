package com.xx.news.dao.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xx.news.dao.NewsDao;
import com.xx.news.dao.Impl.NewsDaoImpl;
import com.xx.news.entity.News;

/**
 * Servlet implementation class DeleteNewsServlet
 */
@WebServlet("/DeleteNewsServlet")
public class DeleteNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteNewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nid = request.getParameter("nid");
		NewsDao newsdao=new NewsDaoImpl();
		try {
			newsdao.deleteNews(Integer.valueOf(nid));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("/updatenews.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] nids=request.getParameterValues("nids");
		try {
			NewsDao newsdao=new NewsDaoImpl();
			for(String nid :nids){
				newsdao.deleteNews(Integer.valueOf(nid));
			} 
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/updatenews.jsp").forward(request, response);
	}

}
