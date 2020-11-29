<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加一条新闻</title>
</head>
<body>
      <form action="AddNewsServlet" method="post">
               新闻类型：<select name="ntid">
       <option value="1">国内</option>
       <option value="2">国际</option>
       <option value="3">军事</option>
       <option value="4">体育</option>
       </select><br>
               新闻标题：<input type="text" name="ntitle"><br>
               新闻作者：<input type="text" name="nauthor"><br>
               新闻内容：<textarea rows="10" cols="10" name="ncontent"></textarea><br>
               新闻概括：<textarea rows="10" cols="10" name="nsummary"></textarea><br>
               <input type="submit" value="提交">
      </form>
</body>
</html>