<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<jsp:include page="top.jsp">
    <jsp:param name="userNum" value="${sessionScope.user.userNum}"/>
</jsp:include>

<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2>个人信息</h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <div class="panel-body bg-light">
                    <div class="section-divider mt20 mb20">
                        <span>基本信息</span>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">帐号</div>
                        <div class="col-md-4">${sessionScope.user.userNum}</div>
                        <div class="col-md-2">姓名</div>
                        <div class="col-md-4">${sessionScope.user.userName}</div>
                        <div class="col-md-2">电话</div>
                        <div class="col-md-4">${sessionScope.user.userPhone}</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

