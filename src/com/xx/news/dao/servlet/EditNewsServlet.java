package com.xx.news.dao.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
 * Servlet implementation class editNewsServlet
 */
@WebServlet("/editNewsServlet")
public class EditNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditNewsServlet() {
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
		try {
			String nid = request.getParameter("nid");
			News news = new News();
			news.setNauthor(request.getParameter("nauthor"));
			news.setNcontent(request.getParameter("ncontent"));
			news.setNpicPath(request.getParameter("npicPath"));
			news.setNsummary(request.getParameter("nsummary"));
			news.setNmodifyDate(new Date());
			
			String ncreateDate = request.getParameter("ncreateDate");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			news.setNcreateDate(sdf.parse(ncreateDate));
			
			news.setNid(Integer.valueOf(request.getParameter("nid")));
			news.setNtid(Integer.valueOf(request.getParameter("ntid")));
			news.setNtitle(request.getParameter("ntitle"));
			
			NewsDao newsDao = new NewsDaoImpl();
			int result = newsDao.editNews(Integer.valueOf(nid), news);
			
			if(result>0) {
				request.setAttribute("message", "修改成功！");
			}else {
				request.setAttribute("message", "修改失败！");
			}
			
			request.getRequestDispatcher("/allnews.jsp").forward(request, response);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
