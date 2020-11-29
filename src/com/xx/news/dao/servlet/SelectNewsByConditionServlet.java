package com.xx.news.dao.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xx.news.dao.NewsDao;
import com.xx.news.dao.Impl.NewsDaoImpl;
import com.xx.news.entity.News;


/**
 * Servlet implementation class SelectNewsByConditionServlet
 */
@WebServlet("/SelectNewsByConditionServlet")
public class SelectNewsByConditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectNewsByConditionServlet() {
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
		String ntitle = request.getParameter("ntitle");
        String ncreateDate = request.getParameter("ncreateDate");
		String ntid = request.getParameter("ntid");
		String nauthor = request.getParameter("nauthor");
		try {
			NewsDao newsdao=new NewsDaoImpl();
			News news=new News();
			news.setNtitle(ntitle);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		    news.setNcreateDate(sdf.parse(ncreateDate));
		    news.setNtid(Integer.valueOf(ntid));
		    news.setNauthor(nauthor);
		    List<News> newsByCondition=newsdao.getNewsByCondition(news);
		    request.setAttribute("newsByCondition", newsByCondition);
		} catch (ParseException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		request.getRequestDispatcher("/selectnewsbycondition.jsp").forward(request, response);
	}

}
