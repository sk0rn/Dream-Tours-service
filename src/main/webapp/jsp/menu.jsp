<%@ page import="pojo.Subject" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Skazzka
  Date: 10.10.2018
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="dropdown navbar-brand">
            <%
                Integer options = (Integer) request.getSession().getAttribute("options");
                if (options == null) {
                    //Кто угодно
            %>
            <%@include file="guestMenu.jsp" %>
            <%
            } else if (options == 0) {
                //Клиент
            %>
            <%@include file="clientMenu.jsp" %>
            <%
            } else if (options == 1) {
                //Сотрудник
            %>
            <%@include file="employeeMenu.jsp" %>
            <%
            } else {
                //Кто угодно
            %>
            <%@include file="guestMenu.jsp" %>
            <%
                }
            %>
        </div>

        <!-- эта кнопка будет видна, когда для меню не хватит места -->
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>


        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="subjectDropdown" role="button"
                       data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        Тематика
                    </a>
                    <input type="hidden" id="searchSubject" name="searchSubject" value="-1">
                    <div class="dropdown-menu" aria-labelledby="subjectDropdown">
                        <%
                            List<Subject> subjects = (List<Subject>) request.getAttribute("subjects");

                            if (subjects != null && subjects.size() > 0) {
                                for (Subject subject : subjects) {
                        %><a class="dropdown-item" href="#"
                             onclick="document.getElementById('subjectDropdown').innerText = '<%=subject.getName()%>';document.getElementById('searchSubject').value = <%=subject.getId()%>;"><%=subject.getName()%>
                    </a><%
                        }
                    } else {
                    %><a class="dropdown-item" href="#">Пусто</a><%
                        }
                    %>
                    </div>
                </li>

                <li class="nav-item active">
                    <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="/tours">Все туры <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>


                <li class="nav-item">
                    <a class="nav-link disabled" href="#">Disabled</a>
                </li>
            </ul>

            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Найти</button>
            </form>
        </div>
    </nav>
