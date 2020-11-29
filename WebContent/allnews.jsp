<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.xx.news.dao.Impl.*"%>
<%@ page import="com.xx.news.dao.*" %>
<%@ page import="java.util.List" %>
<%@ page import="com.xx.news.entity.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示所有新闻</title>
</head>
<body>
     <%
     NewsDao newsdao=new NewsDaoImpl();
     List<News> newslist=newsdao.getAllNews();
     TopicDaoImpl topic = new TopicDaoImpl();	
	 List<Topic> topiclist = topic.allTopic();
     %>
     ${message}
     <c:forEach items="<%=topiclist%>" var="topiclist" >
		    <a class="topic" data-tid="${topic.tid}" href="javascript:void(0)">${topiclist.tname}</a>
		</c:forEach>
		
	 <a href="${pageContext.request.contextPath }/PageNewsServlet?contPage=1&pageSize=10">分页查询</a>
     <table>
     <tr>
     <td>
     <input type="submit" value="批量删除""/>
     </td>
     <td>新闻序号</td>
     <td>新闻标题</td>
     <td>新闻作者</td>
     <td>创建时间</td>
     <td>操作</td>
     </tr>
     <c:forEach items="<%=newslist%>" var="news">
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
     <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	 <script type="text/javascript">
		$(".topic").on('click',function(){
			var tid = $(this).data("tid")
			$.ajax({
				"url":"SelectNewsByTidServlet",
				"type":"GET",
				"dataType":"json",
				"data":{"tid":tid},
				"success":function(data){
					debugger
				},
				"error":function(){
					alert("内部错误！")
				}
			})
		})
	</script>
</body>
</html>