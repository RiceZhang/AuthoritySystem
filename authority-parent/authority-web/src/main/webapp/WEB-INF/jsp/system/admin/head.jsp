<%-- 
    Function   ：Expression function is undefined on line 2, column 19 in Templates/JSP_Servlet/JSP.jsp.
    Document   : head
    Created on : 2015-8-30, 17:03:15
    Author     : 张日雄 <your.name at your.org>
    Version    ：1.0
--%>
<%
	String pathh = request.getContextPath();
	String basePathh = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+pathh+"/";
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="navbar navbar-inverse">
    <div class="navbar-inner">
        <div class="container-fluid">
            <a class="brand" href="login_index.do"><small><i class="icon-leaf"></i> ${pd.SYSNAME}</small> </a>

            <ul class="nav ace-nav pull-right">
                <li class="grey">
                    <a href="javascript:alert('预留功能,待开发');" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="icon-tasks"></i>
                        <span class="badge">4</span>
                    </a>
                    <ul class="pull-right dropdown-navbar dropdown-menu dropdown-caret dropdown-closer">
                        <li class="nav-header">
                            <i class="icon-ok"></i> 4 任务完成
                        </li>

                        <li>
                            <a href="javascript:alert('预留功能,待开发');">
                                <div class="clearfix">
                                    <span class="pull-left">软件更新</span>
                                    <span class="pull-right">65%</span>
                                </div>
                                <div class="progress progress-mini"><div class="bar" style="width:65%"></div></div>
                            </a>
                        </li>

                        <li>
                            <a href="javascript:alert('预留功能,待开发');">
                                <div class="clearfix">
                                    <span class="pull-left">软件更新</span>
                                    <span class="pull-right">35%</span>
                                </div>
                                <div class="progress progress-mini progress-danger"><div class="bar" style="width:35%"></div></div>
                            </a>
                        </li>

                        <li>
                            <a href="javascript:alert('预留功能,待开发');">
                                <div class="clearfix">
                                    <span class="pull-left">运行测试</span>
                                    <span class="pull-right">15%</span>
                                </div>
                                <div class="progress progress-mini progress-warning"><div class="bar" style="width:15%"></div></div>
                            </a>
                        </li>

                        <li>
                            <a href="javascript:alert('预留功能,待开发');">
                                <div class="clearfix">
                                    <span class="pull-left">Bug 修复</span>
                                    <span class="pull-right">90%</span>
                                </div>
                                <div class="progress progress-mini progress-success progress-striped active"><div class="bar" style="width:90%"></div></div>
                            </a>
                        </li>

                        <li>
                            <a href="javascript:alert('预留功能,待开发');">
                                查看任务明细
                                <i class="icon-arrow-right"></i>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="purple">
                    <a href="javascript:alert('预留功能,待开发');" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="icon-bell-alt icon-animated-bell icon-only"></i>
                        <span class="badge badge-important">8</span>
                    </a>
                    <ul class="pull-right dropdown-navbar navbar-pink dropdown-menu dropdown-caret dropdown-closer">
                        <li class="nav-header">
                            <i class="icon-warning-sign"></i> 8 通知计划
                        </li>

                        <li>
                            <a href="javascript:alert('预留功能,待开发');">
                                <div class="clearfix">
                                    <span class="pull-left"><i class="icon-comment btn btn-mini btn-pink"></i> 新消息</span>
                                    <span class="pull-right badge badge-info">+12</span>
                                </div>
                            </a>
                        </li>

                        <li>
                            <a href="javascript:alert('预留功能,待开发');">
                                <i class="icon-user btn btn-mini btn-primary"></i> 测试消息
                            </a>
                        </li>

                        <li>
                            <a href="javascript:alert('预留功能,待开发');">
                                <div class="clearfix">
                                    <span class="pull-left"><i class="icon-shopping-cart btn btn-mini btn-success"></i> 新订单</span>
                                    <span class="pull-right badge badge-success">+8</span>
                                </div>
                            </a>
                        </li>

                        <li>
                            <a href="javascript:alert('预留功能,待开发');">
                                <div class="clearfix">
                                    <span class="pull-left"><i class="icon-twitter btn btn-mini btn-info"></i> 等待消息</span>
                                    <span class="pull-right badge badge-info">+4</span>
                                </div>
                            </a>
                        </li>

                        <li>
                            <a href="javascript:alert('预留功能,待开发');">
                                查看所有消息
                                <i class="icon-arrow-right"></i>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="green">
                    <a href="javascript:alert('预留功能,待开发');" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="icon-envelope-alt icon-animated-vertical icon-only"></i>
                        <span class="badge badge-success">5</span>
                    </a>
                    <ul class="pull-right dropdown-navbar dropdown-menu dropdown-caret dropdown-closer">
                        <li class="nav-header">
                            <i class="icon-envelope"></i> 5 条信件
                        </li>

                        <li>
                            <a href="javascript:alert('预留功能,待开发');">
                                <img alt="Alex's Avatar" class="msg-photo" src="static/avatars/avatar.png" />
                                <span class="msg-body">
                                    <span class="msg-title">
                                        <span class="blue">张三:</span>
                                        你好，我们在哪里吃饭? ...
                                    </span>
                                    <span class="msg-time">
                                        <i class="icon-time"></i> <span>1个月以前</span>
                                    </span>
                                </span>
                            </a>
                        </li>

                        <li>
                            <a href="javascript:alert('预留功能,待开发');">
                                <img alt="Susan's Avatar" class="msg-photo" src="static/avatars/avatar3.png" />
                                <span class="msg-body">
                                    <span class="msg-title">
                                        <span class="blue">李四:</span>
                                        你在哪上班? ...
                                    </span>
                                    <span class="msg-time">
                                        <i class="icon-time"></i> <span>20分钟前</span>
                                    </span>
                                </span>
                            </a>
                        </li>

                        <li>
                            <a href="javascript:alert('预留功能,待开发');">
                                <img alt="Bob's Avatar" class="msg-photo" src="static/avatars/avatar4.png" />
                                <span class="msg-body">
                                    <span class="msg-title">
                                        <span class="blue">王五:</span>
                                        你好，我对你很感兴趣 ...
                                    </span>
                                    <span class="msg-time">
                                        <i class="icon-time"></i> <span>下午 3:15 </span>
                                    </span>
                                </span>
                            </a>
                        </li>

                        <li>
                            <a href="javascript:alert('预留功能,待开发');">
                                查看所有信件
                                <i class="icon-arrow-right"></i>
                            </a>
                        </li>									

                    </ul>
                </li>
                <li class="light-blue user-profile">
                    <a class="user-menu dropdown-toggle" href="javascript:alert('预留功能,待开发');" data-toggle="dropdown">
                        <img alt="FH" src="static/avatars/avatar.png" class="nav-user-photo" />
                        <span id="user_info">

                        </span>
                        <i class="icon-caret-down"></i>
                    </a>
                    <ul id="user_menu" class="pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-closer">
                        <li><a onclick="editUserH();" style="cursor:pointer;"><i class="icon-user"></i> 修改资料</a></li>
                        <li id="systemset"><a onclick="editSys();" style="cursor:pointer;"><i class="icon-cog"></i> 系统设置</a></li>
                        <li id="productCode"><a onclick="productCode();" style="cursor:pointer;"><i class="icon-cogs"></i> 代码生成</a></li>
                        <li class="divider"></li>
                        <li><a href="logout.do"><i class="icon-off"></i> 退出</a></li>
                    </ul>
                </li>
            </ul><!--/.ace-nav-->
        </div><!--/.container-fluid-->
    </div><!--/.navbar-inner-->
</div><!--/.navbar-->


<script type="text/javascript">
        //菜单状态切换
        var fmid = "fhindex";
        var mid = "fhindex";
        function siMenu(id,fid,MENU_NAME,MENU_URL){
                if(id != mid){
                        $("#"+mid).removeClass();
                        mid = id;
                }
                if(fid != fmid){
                        $("#"+fmid).removeClass();
                        fmid = fid;
                }
                $("#"+fid).attr("class","active open");
                $("#"+id).attr("class","active");
                top.mainFrame.tabAddHandler(id,MENU_NAME,MENU_URL);
                if(MENU_URL != "druid/index.html"){
                        jzts();
                }
        }

        $(function(){
                //换肤
                $("#skin-colorpicker").ace_colorpicker().on("change",function(){
                        var b=$(this).find("option:selected").data("class");
                        hf(b);
                        var url = '<%=basePathh%>/head/setSKIN.do?SKIN='+b+'&tm='+new Date().getTime();
                        $.get(url,function(data){});

                })
        })

    var USER_ID;

    function getUname() {
        $.ajax({
            type: "POST",
            url: 'head/getUname.do?tm=' + new Date().getTime(),
            data: encodeURI(""),
            dataType: 'json',
            //beforeSend: validateData,
            cache: false,
            success: function (data) {
                //alert(data.list.length);
                $.each(data.list, function (i, list) {

                    //登陆者资料
                    $("#user_info").html('<small>Welcome</small> ' + list.NAME + '');


                    USER_ID = list.USER_ID;//用户ID
                    hf(list.SKIN)//皮肤

                    if (list.USERNAME != 'admin') {
                        $("#adminmenu").hide();	//隐藏菜单设置
                        $("#adminzidian").hide();	//隐藏数据字典
                        $("#systemset").hide();	//隐藏系统设置
                        $("#productCode").hide();	//隐藏代码生成
                    }

                });
            }
        });
    }
    getUname();

    function hf(b) {

        var a = $(document.body);
        a.attr("class", a.hasClass("navbar-fixed") ? "navbar-fixed" : "");
        if (b != "default") {
            a.addClass(b)
        }
        if (b == "skin-1") {
            $(".ace-nav > li.grey").addClass("dark")
        } else {
            $(".ace-nav > li.grey").removeClass("dark")
        }
        if (b == "skin-2") {
            $(".ace-nav > li").addClass("no-border margin-1");
            $(".ace-nav > li:not(:last-child)").addClass("white-pink")
                    .find('> a > [class*="icon-"]').addClass("pink").end()
                    .eq(0).find(".badge").addClass("badge-warning")
        } else {
            $(".ace-nav > li").removeClass("no-border").removeClass("margin-1");
            $(".ace-nav > li:not(:last-child)").removeClass("white-pink")
                    .find('> a > [class*="icon-"]').removeClass("pink").end()
                    .eq(0).find(".badge").removeClass("badge-warning")
        }
        if (b == "skin-3") {
            $(".ace-nav > li.grey").addClass("red").find(".badge").addClass("badge-yellow")
        } else {
            $(".ace-nav > li.grey").removeClass("red").find(".badge").removeClass("badge-yellow")
        }
    }

    //修改个人资料
    function editUserH() {
        jzts();
        var diag = new top.Dialog();
        diag.Drag = true;
        diag.Title = "个人资料";
        diag.URL = '/user/goEditU.do?USER_ID=' + USER_ID + '&fx=head';
        diag.Width = 225;
        diag.Height = 389;
        diag.CancelEvent = function () { //关闭事件
            diag.close();
        };
        diag.show();
    }

    //系统设置
    function editSys() {
        jzts();
        var diag = new top.Dialog();
        diag.Drag = true;
        diag.Title = "系统设置";
        diag.URL = '/head/goSystem.do';
        diag.Width = 600;
        diag.Height = 596;
        diag.CancelEvent = function () { //关闭事件
            diag.close();
        };
        diag.show();
    }

    //代码生成
    function productCode() {
        jzts();
        var diag = new top.Dialog();
        diag.Drag = true;
        diag.Title = "代码生成器";
        diag.URL = '/head/goProductCode.do';
        diag.Width = 800;
        diag.Height = 450;
        diag.CancelEvent = function () { //关闭事件
            hangge();
            diag.close();
        };
        diag.show();
    }

    //数据字典
    function zidian() {
        jzts();
        var diag = new top.Dialog();
        diag.Drag = true;
        diag.Title = "数据字典";
        diag.URL = '/dictionaries.do?PARENT_ID=0';
        diag.Width = 799;
        diag.Height = 460;
        diag.CancelEvent = function () { //关闭事件
            diag.close();
        };
        diag.show();

    }

    //菜单
    function menu() {
        jzts();
        var diag = new top.Dialog();
        diag.Drag = true;
        diag.Title = "菜单编辑";
        diag.URL = '/menu.do';
        diag.Width = 720;
        diag.Height = 390;
        diag.CancelEvent = function () { //关闭事件
            diag.close();
        };
        diag.show();

    }

    //切换菜单
    function changeMenu() {
        window.location.href = 'login_index.do?changeMenu=yes';
    }

    //清除加载进度
    function hangge() {
        $("#jzts").hide();
    }

    //显示加载进度
    function jzts() {
        //$("#jzts").show();
    }
</script>

