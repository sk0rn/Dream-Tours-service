<%@ page import="pojo.Tour" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div align="center">
    <form action="" method="post">
        <%
            List<Tour> tourList = (List<Tour>) request.getAttribute("ИМЯ АТРИБУТА");
            if(tourList != null)
            for (Tour i : tourList) {
        %>
        <div class="col-12" align="left">
            <div class="form-row">
                <div class="col-3">
                    <div class="card" style="width: 22rem;">
                        <img class="card-img-top" src="D:\Innopolis\image.jpg" alt="Card image cap" name="imgArea">
                    </div>
                </div>
                <div class="col-9">
                    <a><%=i.getName()%>
                    </a>
                    <div class="form-group">
                        <textarea class="form-control" id="exampleFormControlTextarea1" rows="5"
                                  name="tourName"><%=i.getDesc()%></textarea>
                    </div>
                </div>
            </div>
        </div>
        <%}%>
    </form>
</div>