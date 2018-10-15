<%@ page import="pojo.Place" %>
<%@ page import="pojo.Subject" %>
<%@ page import="pojo.TourExtend" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<TourExtend> tourList = (List<TourExtend>) request.getAttribute("tours");
    if (tourList != null)
        for (TourExtend tour : tourList) {
%>

<div class="row">
    <div class="col-3 px-3 py-3">
        <a href="/tour?tour=<%=tour.getTour().getId()%>">
            <img src="/images?album=<%=tour.getTour().getAlbumGuid()%>&filename=01" style="width: 100%; height: 220px;"
                 alt="<%=tour.getTour().getName()%>" name="imgArea">
        </a>
    </div>
    <div class="col-auto">
        <a href="/tour?tour=<%=tour.getTour().getId()%>"><h5 class="card-title"><%=tour.getTour().getName()%>
        </h5>
        </a>
        <nobr>
            <%
                for (Subject subj : tour.getSubjects()) {
            %>
            <a href="/tours?subject=<%=subj.getId()%>" title="<%=subj.getName()%>"
               data-toggle="popover" data-trigger="hover" data-content="<%=subj.getDesc()%>">
                <%=subj.getName()%>
            </a>
            <%}%>
        </nobr>
        <!--<div class="form-group">-->
        <textarea class="form-control" id="exampleFormControlTextarea1" rows="5"
                  name="tourName"><%=tour.getTour().getDesc()%></textarea>
        <nobr>
            <%
                for (Place place : tour.getPlaces()) {
            %>
            <a href="/tours?place=<%=place.getId()%>" title="<%=place.getName()%>"
               data-toggle="popover" data-trigger="hover" data-content="<%=place.getDesc()%>">
                <%=place.getName()%>
            </a>
            <%}%>
        </nobr>
        <!--</div>-->
    </div>
</div>
<%}%>
