<%-- 
    Function   ：Expression function is undefined on line 2, column 19 in Templates/JSP_Servlet/JSP.jsp.
    Document   : login
    Created on : 2015-8-28, 21:02:38
    Author     : 张日雄 <your.name at your.org>
    Version    ：1.0
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html lang="en">
    <head>
        <title>${pd.SYSNAME}</title>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />

        <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/static/myplugins/login/bootstrap.min.css" />
        <link rel="stylesheet" href="mystatic/myplugins/login/bootstrap-responsive.min.css" />
        
        
        <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/static/myplugins/login/css/camera.css" />
      
        <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/static/myplugins/login/matrix-login.css" />
          <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/static/myplugins/login/font-awesome.css" /> 
        <script type="text/javascript" src="${pageContext.servletContext.contextPath }/static/myplugins/login/js/jquery-1.5.1.min.js"></script>
    </head>
    <body>
        <div style="width:100%;text-align: center;margin: 0 auto;position: absolute;">
            <div id="loginbox">
                <form action="" method="post" name="loginForm" id="loginForm">
                    <div class="control-group normal_text">
                        <h3>
                            <img src="${pageContext.servletContext.contextPath }/static/myplugins/login/logo.png" alt="Logo" />
                        </h3>
                    </div>                    
                    <div class="control-group">
                        <div class="controls">
                            <div class="main_input_box">
                                <span class="add-on bg_lg">
                                    <i><img height="37"  src="${pageContext.servletContext.contextPath }/static/myplugins/login/user.png" ></i>
                                </span>
                                <input type="text" name="loginname" id="loginname" value="" placeholder="请输入用户名" >                                     
                            </div>
                        </div>
                    </div>
                </form>
            </div>        
        </div>

    </body>
</html>
