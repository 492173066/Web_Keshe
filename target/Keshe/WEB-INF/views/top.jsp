<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>欢迎使用土质检测系统</title>

    <link rel="stylesheet" type="text/css" href="../../assets/skin/default_skin/css/theme.css">
    <link rel="stylesheet" type="text/css" href="../../assets/admin-tools/admin-forms/css/admin-forms.css">
    <link rel="shortcut icon" href="../../assets/img/favicon.ico">
</head>
<body class="admin-validation-page" data-spy="scroll" data-target="#nav-spy" data-offset="200">
<div id="main">
    <header class="navbar navbar-fixed-top navbar-shadow">
        <div class="navbar-branding">
            <a class="navbar-brand" href="dashboard.html">
                <b>土质检测系统</b>
            </a>
            <span id="toggle_sidemenu_l" class="ad ad-lines"></span>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown menu-merge">
                <a href="#" class="dropdown-toggle fw600 p15" data-toggle="dropdown">
                    <span class="hidden-xs pl15">个人中心</span>
                    <span class="caret caret-tp hidden-xs"></span>
                </a>
                <ul class="dropdown-menu list-group dropdown-persist w250" role="menu">
                    <li class="list-group-item">
                        <a href="self" class="animated animated-short fadeInUp">
                            <span class="fa fa-user"></span>个人信息
                            <span class="label label-warning"></span>
                        </a>
                    </li>
                    <li class="list-group-item">
                        <a href="to_change_password" class="animated animated-short fadeInUp">
                            <span class="fa fa-gear"></span>设置密码</a>
                    </li>
                    <li class="dropdown-footer">
                        <a href="quit" class="">
                            <span class="fa fa-power-off pr5"></span>退出</a>
                    </li>
                </ul>
            </li>
        </ul>
    </header>
    <aside id="sidebar_left" class="nano nano-light affix">
        <div class="sidebar-left-content nano-content" >
            <header class="sidebar-header">
                <div class="sidebar-widget author-widget">
                    <div class="media">
                        <a class="media-left" href="#"></a>
                        <div class="media-body">
                            <div class="media-author">欢迎您，<%=request.getParameter("userNum")%>，使用土质检测系统！</div>
                        </div>
                    </div>
                </div>
            </header>
            <ul class="nav sidebar-menu">
                <li class="sidebar-label pt15">用户管理</li>
                    <li>
                         <a href="user/list">
                             <span class="glyphicon glyphicon-calendar"></span>所有用户</a>
                    </li>
                     <li class="active">
                         <a href="user/to_add">
                             <span class="glyphicon glyphicon-check"></span>添加用户</a>
                     </li>
            </ul>
                <ul class="nav sidebar-menu">
                    <li class="sidebar-label pt20">日常管理</li>
                    <li>
                        <a href="sensor/list">
                            <span class="glyphicon glyphicon-book"></span>
                            <span class="sidebar-title">传感器实时数据</span>
                            <span class="sidebar-title-tray">
                            <span class="label label-xs bg-primary">New</span>
                        </span>
                        </a>
                    </li>
                    <li>
                        <a href="error/list">
                            <span class="glyphicon glyphicon-book"></span>
                            <span class="sidebar-title">传感器异常数据</span>
                            <span class="sidebar-title-tray">
                            <span class="label label-xs bg-primary">New</span>
                        </span>
                        </a>
                    </li>
                    <li>
                        <a href="sensor/to_send">
                            <span class="glyphicon glyphicon-calendar"></span>
                            <span class="sidebar-title">控制</span>
                        </a>
                    </li>
                </ul>
        </div>
    </aside>
</div>
</body>
</html>