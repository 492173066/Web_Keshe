<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<jsp:include page="top.jsp">
    <jsp:param name="userNum" value="${sessionScope.user.userNum}"/>
</jsp:include>
<jsp:useBean id="command" class="com.cassie.zigbee_dao.entity.User" scope="request" >
</jsp:useBean>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2>添加用户</h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <form:form action="add" modleAttribute="user" id="admin-form" name="addForm">
                    <div class="panel-body bg-light">
                        <div class="section-divider mt20 mb40">
                            <span>基本信息</span>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="userNum" class="field prepend-icon">
                                    <form:input path="userNum" cssClass="gui-input" placeholder="帐号..."/>
                                    <label for="userNum" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="col-md-6">
                                <label for="userName" class="field prepend-icon">
                                    <form:input path="userName" cssClass="gui-input" placeholder="姓名..."/>
                                    <label for="userName" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="col-md-6">
                                <label for="userPhone" class="field prepend-icon">
                                    <form:input path="userPhone" cssClass="gui-input" placeholder="电话..."/>
                                    <label for="userPhone" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="panel-footer text-right">
                            <button type="submit" class="button">保存</button>
                            <button type="button" class="button" onclick="javascript:window.history.go(-1);">返回</button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</section>

