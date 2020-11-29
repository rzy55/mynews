<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.xx.news.dao.Impl.NewsDaoImpl"%>
<%@ page import="com.xx.news.dao.NewsDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.xx.news.entity.News" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>根据条件查询新闻</title>
</head>
<body>
    <%
     NewsDao newsdao=new NewsDaoImpl();
     List<News> newslist=newsdao.getAllNews();
     %>
    <form action="${pageContext.request.contextPath}/SelectNewsByConditionServlet" method="post">
           新闻标题：<input type="text" name="ntitle"><br>
           新闻创建时间：<input type="date" name="ncreateDate"><br>
           新闻作者：<input type="text" name="nauthor"><br>
           新闻类型：<select name="ntid">
                <option value="2">国际</option>
           </select><br>
           <input type="submit" value="提交">
      </form>
      <table>
			<tr>
				<th>新闻标题</th>
				<th>新闻作者</th>
				<th>创建时间</th>
				<th>修改时间</th>
				<th>操作</th>
			</tr>
			<c:forEach var="news" items="${newsByCondition}">
				 <tr>
				     <td>
				         <input type="checkbox" name="nids" value="${news.nid}"/>
				     </td>
				     <td>${news.nid}</td>
				     <td><a href="${pageContext.request.contextPath}/SelectNewsServlet?nid=${news.nid}">${news.ntitle}</a></td>
				     <td>${news.nauthor}</td>
				     <td>${news.ncreateDate}</td>
				     <td>
				         <a href="${pageContext.request.contextPath}/SelectNewsServlet?nid=${news.nid}&option=edit">修改</a>
				         <a href="${pageContext.request.contextPath}/DeleteNewsServlet?nid=${news.nid}">删除</a>
				     </td>
			     </tr>			
		     </c:forEach>
		</table>
</body>
</html>