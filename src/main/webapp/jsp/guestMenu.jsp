<%--
  Created by IntelliJ IDEA.
  User: Skazzka
  Date: 10.10.2018
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form class="px-4 py-3" action="/login" method="post">
    <div class="form-group">
        <label for="exampleDropdownFormEmail1">Логин</label>
        <input type="email" class="form-control" id="exampleDropdownFormEmail1" placeholder="login">
    </div>
    <div class="form-group">
        <label for="exampleDropdownFormPassword1">Пароль</label>
        <input type="password" class="form-control" id="exampleDropdownFormPassword1" placeholder="password">
    </div>
    <button type="submit" class="btn btn-primary">Войти</button>
    <div class="dropdown-divider"></div>
    <a class="dropdown-item" href="/register">Регистрация</a>
</form>