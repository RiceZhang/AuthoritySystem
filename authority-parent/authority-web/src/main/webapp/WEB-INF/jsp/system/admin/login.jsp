<%-- 
    Function   ：Expression function is undefined on line 2, column 19 in Templates/JSP_Servlet/JSP.jsp.
    Document   : login
    Created on : 2015-8-28, 21:02:38
    Author     : 张日雄 <your.name at your.org>
    Version    ：1.0
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        
        <link rel="stylesheet" href="mystatic/myplugins/login/bootstrap.min.css" />
        <link rel="stylesheet" href="mystatic/myplugins/login/css/camera.css" />
        <link rel="stylesheet" href="mystatic/myplugins/login/bootstrap-responsive.min.css" />
        <link rel="stylesheet" href="mystatic/myplugins/login/font-awesome.css" /> 
        <link rel="stylesheet" href="mystatic/myplugins/login/matrix-login.css" />
        <script type="text/javascript" src="mystatic/myplugins/login/js/jquery-1.5.1.min.js"></script>
    </head>
    <body>
        <div style="width:100%;text-align: center;margin: 0 auto;position: absolute;">
            <div id="loginbox">
                <form action="" method="post" name="loginForm" id="loginForm">
                    <div class="control-group normal_text">
                        <h3>
                            <img src="mystatic/myplugins/login/logo.png" alt="Logo" />
                        </h3>
                    </div>                    
                    <div class="control-group">
                        <div class="controls">
                            <div class="main_input_box">
                                <span class="add-on bg_lg">
                                    <i><img height="37"  src="mystatic/myplugins/login/user.png" ></i>
                                </span>
                                <input type="text" name="loginname" id="loginname" value="" placeholder="请输入用户名" >                                     
                            </div>
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">
                            <div class="main_input_box">
                                <span class="add-on bg_ly">
                                    <i><img height="37" src="mystatic/myplugins/login/suo.png" ></i>
                                </span>
                                <input type="password"  name="password" id="password" placeholder="请输入密码" value="" >                                    
                            </div>
                        </div>
                    </div>
                    <div style="float:right;padding-right:10%;">
                        <div style="float: left;margin-top:3px;margin-right:2px;">
                            <font color="white">记住密码</font>
                        </div>
                        <div style="float: left;">
                            <input name="form-field-checkbox" id="saveid" type="checkbox"
                                   onclick="savePaw();" style="padding-top:0px;" />
                        </div>
                    </div>

                    <div class="form-actions">
                        <div style="width:86%;padding-left:8%;">
                            <div style="float: left;">
                                <i><img src="mystatic/myplugins/login/yan.png" /></i>
                            </div>
                            <div style="float: left;" class="codediv">
                                <input type="text" name="code" id="code" class="login_code"
                                       style="height:16px; padding-top:0px;" />
                            </div>
                            <div style="float: left;">
                                <i><img style="height:22px;" id="codeImg" alt="点击更换"
                                        title="点击更换" src="" /></i>
                            </div>
                            <span class="pull-right" style="padding-right:3%;">
                                <a href="javascript:quxiao();" class="btn btn-success">取消</a>
                            </span>
                            <span class="pull-right">
                                <a onclick="severCheck();"  class="flip-link btn btn-info" id="to-recover">登录</a>
                            </span>
                                
                        </div>
                    </div>
                </form>

                <div class="controls">
                    <div class="main_input_box">
                        <font color="white"><span id="nameerr">Copyright © FH
                            2100</span></font>
                    </div>
                </div>
                
            </div>        
        </div>
<script type="text/javascript">
jQuery(function() {
        var loginname = $.cookie('loginname');
        var password = $.cookie('password');
        if (typeof(loginname) != "undefined"
                        && typeof(password) != "undefined") {
                $("#loginname").val(loginname);
                $("#password").val(password);
                $("#saveid").attr("checked", true);
                $("#code").focus();
        }
});    

$(document).ready(function() {
        changeCode();
        $("#codeImg").bind("click", changeCode);
});

function changeCode() {
        $("#codeImg").attr("src", "code.do?t=" + genTimestamp());
}

function genTimestamp() {
        var time = new Date();
        return time.getTime();
}

//服务器校验
function severCheck(){
        if(check()){
            var loginname = $("#loginname").val();
            var password = $("#password").val();
            var code = "qq12345678fh"+loginname+",fh,"+password+"QQ98765423fh"+",fh,"+$("#code").val();
            $.ajax({
                type: "POST",
                url: 'login_login.do?tm=' + genTimestamp() ,
                data: {KEYDATA:code},
                dataType:'json',
                cache: false,
                success: function (data, textStatus, jqXHR) {
                    //result 为后台来的key 
                    if("success" == data.result){
                        saveCookie();
                        window.location.href="login_index.do";
                     }else if("usererror" == data.result){
                            $("#loginname").tips({
                                    side : 1,
                                    msg : "用户名或密码有误",
                                    bg : '#FF5080',
                                    time : 15
                            });
                            $("#loginname").focus();                         
                     }else if("codeerror" == data.result){
                            $("#code").tips({
                                    side : 1,
                                    msg : "验证码输入有误",
                                    bg : '#FF5080',
                                    time : 15
                            });
                            $("#code").focus();                         
                     }else{
                            $("#loginname").tips({
                                    side : 1,
                                    msg : "缺少参数",
                                    bg : '#FF5080',
                                    time : 15
                            });
                            $("#loginname").focus();   
                     }                   
                },
                error: function (jqXHR, textStatus, errorThrown) {
                        console.info("出错505！");
                }
            });
        }
}

//客户端校验
function check() {
        //checking the properties "loginname"
        if ($("#loginname").val() == "") {
                $("#loginname").tips({
                        side : 2,
                        msg : '用户名不得为空',
                        bg : '#AE81FF',
                        time : 3
                });
                $("#loginname").focus();
                return false;       
        }else {
            $("#loginname").val(jQuery.trim($('#loginname').val()));
        }
        
        //checking the properties "password"
        if ($("#password").val() == "") {
                $("#password").tips({
                    side : 2,
                    msg : '密码不得为空',
                    bg : '#AE81FF',
                    time : 3
                });
                $("#password").focus();
                return false;                
        }
        
        //checking the properties "code"
        if ($("#code").val() == "") {
                $("#code").tips({
                        side : 1,
                        msg : '验证码不得为空',
                        bg : '#AE81FF',
                        time : 3
                });
                $("#code").focus();
                return false;
        }
        
        //show the tips when executer the login operation
        $("#loginbox").tips({
                side : 1,
                msg : '正在登录 , 请稍后 ...',
                bg : '#68B500',
                time : 10
        });
        
        return true;
}

//remember me 
function saveCookie() {
        if ($("#saveid").attr("checked")) {
                $.cookie('loginname', $("#loginname").val(), {
                        expires : 7
                });
                $.cookie('password', $("#password").val(), {
                        expires : 7
                });
        }
}


</script>

<script src="static/js/bootstrap.min.js"></script>
<script src="static/js/jquery-1.7.2.js"></script>
<script src="static/login/js/jquery.easing.1.3.js"></script>
<script src="static/login/js/jquery.mobile.customized.min.js"></script>
<script src="static/login/js/camera.min.js"></script>
<script src="static/login/js/templatemo_script.js"></script>
<script type="text/javascript" src="static/js/jquery.tips.js"></script>
<script type="text/javascript" src="static/js/jquery.cookie.js"></script>

    </body>
</html>
