<%--
  Created by IntelliJ IDEA.
  User: Skazzka
  Date: 10.10.2018
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown"
        aria-haspopup="true" aria-expanded="false">
    Войдите
</button>

<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    <form class="px-4 py-3" action="/login" method="post">
    <div class="form-group">
        <label for="exampleDropdownFormEmail1">Логин</label>
        <input type="text" class="form-control" id="exampleDropdownFormEmail1" placeholder="login" name="login">
    </div>
    <div class="form-group">
        <label for="exampleDropdownFormPassword1">Пароль</label>
        <input type="password" class="form-control" id="exampleDropdownFormPassword1" placeholder="password"
               name="password">
    </div>
    <button type="submit" class="btn btn-primary">Войти</button>
    <div class="dropdown-divider"></div>
    <a class="dropdown-item" href="/register">Регистрация</a>
</form>
</div>
