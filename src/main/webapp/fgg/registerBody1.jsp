<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="headTag.jsp" %>
<body>
<%@include file="menu.jsp" %>

<div align="center">
    <div class="col-4" align="left">
        <form action="/register" method="post">
            <%
                if (("" + request.getParameter("errorCode")).equals("errLogin")) {
            %>
            <a style="color: red">Пользователь с данным логином уже существует!</a>
            <%}%>
            <br><input class="form-control" type="text" placeholder="логин" required name="login">
            <br>
            <%
                if (("" + request.getParameter("errorCode")).equals("errPass")) {
            %>
            <a style="color: red">Пароль не соответствует требовниям!</a>
            <%}%>
            <br>
            <div class="form-group">
                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="пароль" required
                       name="pass">
                <small id="passwordHelpInline" class="text-muted">
                    Минимальная длина 8 символов (минимум 2 строчные буквы, 2 заглавные буквы, 2 цифры)
                </small>
            </div>
            <%
                if (("" + request.getParameter("errorCode")).equals("errPhone")) {
            %>
            <a style="color: red">Номер телефона не соответствует требовниям!</a>
            <%}%>
            <br>
            <input class="form-control" type="text" placeholder="телефон" required name="phone">
            <small id="phoneHelpInline" class="text-muted">
                Длина 11 цифр
            </small>
            <br><br>
            <div class="form-group">
                <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com"
                       required name="email">
            </div>
            <br>
            <button type="submit" class="btn btn-primary">Зарегистрироваться</button>
        </form>
    </div>
</div>

<%@include file="tail.jsp" %>
</body>
</html>
