<%--
  Created by IntelliJ IDEA.
  User: Skazzka
  Date: 10.10.2018
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    switch ("" + (String) request.getAttribute("allRequestsAnswer")) {
        case "/register":
%>
<%@include file="registerBody3.jsp" %>
<%
        break;

    case "":
    case "/":
    case "/tour":
%>
<%@include file="tourBody.jsp" %>
<%
        break;
    default:
%>
Тело - бело!
<%
            break;
    }
%>
