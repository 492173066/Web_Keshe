<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<jsp:include page="top.jsp">
    <jsp:param name="userNum" value="${sessionScope.user.userNum}"/>
</jsp:include>
<div class="text-center panel-footer panel-body bg-light">
    <a href="<%=basePath%>/sensor/send?request=08">
        <button name="on_light" type="button" id="light_btn" style="width: 80px;height: 25px">灯</button>
    </a>
</div>

<div class="text-center panel-footer panel-body bg-light">
    <a href="<%=basePath%>/sensor/send?request=01">
        <button name="on_light" type="button" id="fan_btn" style="width: 80px;height: 25px">风扇</button>
    </a>
</div>

<div class="text-center panel-footer panel-body bg-light">
    <a href="<%=basePath%>/sensor/send?request=09">
        <button name="on_light" type="button" id="on_btn" style="width: 80px;height: 25px">全部打开</button>
    </a>
</div>

<div class="text-center panel-footer panel-body bg-light">
    <a href="<%=basePath%>/sensor/send?request=00">
        <button name="on_light" type="button" id="off_btn" style="width: 80px;height: 25px">全部关闭</button>
    </a>
</div>

