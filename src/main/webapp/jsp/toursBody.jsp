<%@ page import="pojo.Place" %>
<%@ page import="pojo.Subject" %>
<%@ page import="pojo.TourExtend" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div align="center">
    <%
        List<TourExtend> tourList = (List<TourExtend>) request.getAttribute("tours");
        if (tourList != null)
            for (TourExtend tour : tourList) {
    %>
    <div class="col-12" align="left">
        <div class="form-row">
            <div class="col-3">
                <div class="card" style="width: 22rem;">
                    <img class="card-img-top" src="/images?album=<%=tour.getTour().getAlbumGuid()%>&filename=01"
                         alt="Card image cap" name="imgArea">
                </div>
            </div>
            <div class="col-9">
                <%
                    if (((Integer) 1).equals(request.getSession().getAttribute("options"))) {
                %>
                <button type="button" class="btn-sm btn-success"
                        onclick="document.location.href='/admin/add_content?id=<%=tour.getTour().getId()%>'">Изменить
                </button>&nbsp;
                <%
                    }
                %>

                <a href="/tour?id=<%=tour.getTour().getId()%>"><%=tour.getTour().getName()%>
                </a><br>
                <nobr>
                    <%
                        for (Subject subj : tour.getSubjects()) {
                    %>
                    <a href="/tours?subject=<%=subj.getId()%>" title="<%=subj.getName()%>"
                       data-content="<%=subj.getDesc()%>" data-toggle="popover"
                       data-trigger="hover">
                        <%=subj.getName()%>
                    </a>
                    <%}%>
                </nobr>
                <div class="form-group">
                        <textarea class="form-control" id="exampleFormControlTextarea1" rows="5"
                                  name="tourName"><%=tour.getTour().getDesc()%></textarea>
                    <nobr>
                        <%
                            for (Place place : tour.getPlaces()) {
                        %>
                        <a href="/tours?place=<%=place.getId()%>" title="<%=place.getName()%>"
                           data-content="<%=place.getDesc()%>" data-toggle="popover"
                           data-trigger="hover">
                            <%=place.getName()%>
                        </a>
                        <%}%>
                    </nobr>
                </div>
            </div>
        </div>
    </div>
    <%}%>
</div>
