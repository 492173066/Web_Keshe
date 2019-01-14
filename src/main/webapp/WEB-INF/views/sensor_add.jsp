<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<jsp:include page="top.jsp">
    <jsp:param name="userNum" value="${sessionScope.user.userNum}"/>
</jsp:include>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2>添加传感器数据</h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <form:form action="/sensor/add" modleAttribute="sensor" id="admin-form" name="addForm">
                <div class="panel-body bg-light">
                    <div class="section-divider mt20 mb40">
                        <span>基本信息</span>
                    </div>
                    <div class="section row">
                        <div class="col-md-6">
                            <label for="time" class="field prepend-icon">
                                <form:input path="time" cssClass="gui-input" placeholder="时间..."/>
                                <label for="time" class="field-icon">
                                    <i class="fa fa-user"></i>
                                </label>
                            </label>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="temp" class="field prepend-icon">
                                    <form:input path="temp" cssClass="gui-input" placeholder="温度..."/>
                                    <label for="temp" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="col-md-6">
                                <label for="humi" class="field prepend-icon">
                                    <form:input path="humi" cssClass="gui-input" placeholder="湿度..."/>
                                    <label for="humi" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section">
                            <label for="light" class="field prepend-icon">
                                <form:input path="light" cssClass="gui-input" placeholder="光照..."/>
                                <label for="light" class="field-icon">
                                    <i class="fa fa-lock"></i>
                                </label>
                            </label>
                        </div>
                        <div class="panel-footer text-right">
                            <button type="submit" class="button">注册</button>
                            <button type="button" class="button" onclick="javascript:window.history.go(-1);">返回</button>
                        </div>
                    </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</section>
