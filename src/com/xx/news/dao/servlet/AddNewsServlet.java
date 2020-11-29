package com.xx.news.dao.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xx.news.dao.NewsDao;
import com.xx.news.dao.Impl.NewsDaoImpl;
import com.xx.news.entity.News;

/**
 * Servlet implementation class AddNewsServlet
 */
@WebServlet("/AddNewsServlet")
public class AddNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewsServlet() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ntid=request.getParameter("ntid");
		String ntitle=request.getParameter("ntitle");
		String nauthor=request.getParameter("nauthor");
		String npicPath=request.getParameter("npicPath");
		String ncontent=request.getParameter("ncontent");
		String nsummary=request.getParameter("nsummary");
		
		NewsDao newsdao=new NewsDaoImpl();
		
		News news=new News();
		news.setNtid(Integer.valueOf(ntid));
		news.setNtitle(ntitle);
		news.setNauthor(nauthor);
		news.setNcreateDate(new Date());
		news.setNpicPath(npicPath);
		news.setNcontent(ncontent);
		news.setNmodifyDate(new Date());
		news.setNsummary(nsummary);
		try {
			newsdao.AddNews(news);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("message", ntitle+"添加成功");
		request.getRequestDispatcher("allnews.jsp").forward(request, response);
		
	}

}
