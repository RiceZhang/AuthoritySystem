<%-- 
    Function   ：Expression function is undefined on line 2, column 19 in Templates/JSP_Servlet/JSP.jsp.
    Document   : default
    Created on : 2015-9-2, 18:02:27
    Author     : 张日雄 <your.name at your.org>
    Version    ：1.0
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html lang="en">
<head>
<base href="<%=basePath%>">
    <!-- jsp文件头和头部 -->
    <%@ include file="top.jsp"%>

</head>
<body>
    <div class="container-fluid" id="main-container">
       <h1>Hello World!</h1>
    </div>
    </body>
</html>
