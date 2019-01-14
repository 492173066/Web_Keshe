<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<jsp:include page="top.jsp">
    <jsp:param name="userNum" value="${sessionScope.user.userNum}"/>
</jsp:include>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<!--解释一下，这个command类似于struts的引用的form对象，使用jsp:userBean是引用在spring-mvc.xml配置文件中的command对象。-->
<jsp:useBean id="command" class="com.cassie.zigbee_dao.entity.User" scope="request" >
</jsp:useBean>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2>用户修改信息</h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <form:form action="update" modleAttribute="user" id="admin-form" name="addForm">
                    <form:hidden path="userPassword"/>
                    <div class="panel-body bg-light">
                        <input type="hidden" name="userNum" value="${user.userNum}">
                        <div class="section-divider mt20 mb40">
                            <span>基本信息</span>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="userNum" class="field prepend-icon">
                                    <form:input path="userNum" cssClass="gui-input" placeholder="帐号..." readonly="true"/>
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