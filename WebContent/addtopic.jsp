<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加主题</title>
</head>
<body>
      <form>
           <input type="text" name="tname">
      </form>
      <script type="text/javascript">
      var xhr = new XMLHttpRequest();
      if(xhr == null){
      	xhr = new ActiveXObject("Microsoft.XMLHTTP");
      }
      xhr.open("post","AddTopicServlet",true);
      xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
      xhr.send("tname="+document.getElmentsByName("tname")[0].value);
      xhr.onreadystatechange = function (){
      	if(xhr.readyState == 4 && xhr.status == 200){
      		alert(xhr.responseText)
      	}
      }
      </script>
</body>
</html>