<%@ page import="service.tour.impl.PlaceSrv" %>
<%@ page import="service.tour.impl.SubjectSrv" %>
<%@ page import="utils.DropDownHtmlCompiler" %>
<%@ page import="java.util.function.Function" %>
<%@ page import="service.tour.impl.DurationSrv" %>
<%@ page import="pojo.Duration" %>
<%--
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
            <li class="nav-item">
                <a class="nav-link" href="/tours">Все туры<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="subjectDropdown" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">Тематика</a>
                <div class="dropdown-menu" aria-labelledby="subjectDropdown">
                    <%
                        out.print(new DropDownHtmlCompiler().compileDropDown(new SubjectSrv().getAll(), new Function<Subject, Object[]>() {
                            @Override
                            public Object[] apply(Subject subject) {
                                return new Object[]{subject.getId(), subject.getName()};
                            }
                        }, "subjectDropdown", "searchSubject"));
                    %>
                </div>
            </li>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="placeDropdown" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">Места</a>
                <div class="dropdown-menu" aria-labelledby="placeDropdown">
                    <%
                        out.print(new DropDownHtmlCompiler().compileDropDown(new PlaceSrv().getAll(), new Function<Place, Object[]>() {
                            @Override
                            public Object[] apply(Place place) {
                                return new Object[]{place.getId(), place.getName()};
                            }
                        }, "placeDropdown", "searchPlace"));
                    %>
                </div>
            </li>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="durationDropdown" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">Длительность</a>
                <div class="dropdown-menu" aria-labelledby="durationDropdown">
                    <%
                        out.print(new DropDownHtmlCompiler().compileDropDown(new DurationSrv().getAll(), new Function<Duration, Object[]>() {
                            @Override
                            public Object[] apply(Duration duration) {
                                return new Object[]{duration.getId(), duration.getName()};
                            }
                        }, "durationDropdown", "searchDuration"));
                    %>
                </div>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="#">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="wishListViewCheckBox"
                               onchange="document.getElementById('searchInWishList').value = this.checked ? 1 : 0;">
                        <label class="form-check-label" for="wishListViewCheckBox">
                            В избранном
                        </label>
                    </div>
                    <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#" id="advBtn">Дополнительно<span class="sr-only">(current)</span></a>
            </li>
        </ul>
    </div>
    <form class="form-inline my-2 my-lg-0" action="/tours" method="get">
        <input type="hidden" id="searchSubject" name="subjectId" value="-1">
        <input type="hidden" id="searchPlace" name="placeId" value="-1">
        <input type="hidden" id="searchInWishList" name="inWishList" value="0">
        <input type="hidden" id="searchDateBegin" name="DateBegin">
        <input type="hidden" id="searchDateEnd" name="DateEnd">
        <input type="hidden" id="searchCostBegin" name="costFrom">
        <input type="hidden" id="searchCostEnd" name="costTo">
        <input type="hidden" id="searchDurationBegin" name="durationFrom">
        <input type="hidden" id="searchDurationEnd" name="durationTo">

        <input class="form-control mr-sm-2" type="search" placeholder="Фудзи саккура ..." aria-label="Search"
               name="searchString">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Найти</button>
    </form>
</nav>


<!-- Modal -->
<div class="modal fade" id="advModal" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header" style="padding:15px 20px;">
                <h4><span class="glyphicon glyphicon-lock"></span>Дополнительные параметры</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body" style="padding:20px 25px;">
                <form role="form">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="searchDateBeginView">Дата&nbsp;вылета</label>
                            <input type="email" class="form-control" id="searchDateBeginView"
                                   placeholder="с"
                                   onchange="document.getElementById('searchDateBegin').value = this.value;">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="searchDateEndView">&nbsp;</label>
                            <input type="email" class="form-control" id="searchDateEndView"
                                   placeholder="по"
                                   onchange="document.getElementById('searchDateEnd').value = this.value;">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="searchCostBeginView">Стоимость</label>
                            <input type="email" class="form-control" id="searchCostBeginView"
                                   placeholder="от"
                                   onchange="document.getElementById('searchCostBegin').value = this.value;">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="searchCostEndView">&nbsp;</label>
                            <input type="email" class="form-control" id="searchCostEndView"
                                   placeholder="до"
                                   onchange="document.getElementById('searchCostEnd').value = this.value;">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="searchDurationBeginView">Продолжительность</label>
                            <input type="email" class="form-control" id="searchDurationBeginView"
                                   placeholder="от"
                                   onchange="document.getElementById('searchDurationBegin').value = this.value;">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="searchDurationEndView">&nbsp;</label>
                            <input type="email" class="form-control" id="searchDurationEndView"
                                   placeholder="до"
                                   onchange="document.getElementById('searchDurationEnd').value = this.value;">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-success" id="advOkButton"><span
                        class="glyphicon glyphicon-off"></span> Ок
                </button>
                <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal">
                    <span class="glyphicon glyphicon-remove"></span> Отмена
                </button>
            </div>
        </div>
    </div>
</div>
