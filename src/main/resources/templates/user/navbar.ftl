<!-- NavBar -->
<nav class="navbar navbar-inverse main-nav-bar" id="mainNavBar">
    <div class="container-fluid">
        <!-- Logo -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#mainNavBarMob">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="/user/service-requests" class="navbar-brand">Service Requests</a>
        </div>
        <!-- Menu Items -->
        <div id="mainNavBarMob" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Create Service Request
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/user/abandoned-vehicle">Abandoned Vehicle Complaint</a></li>
                        <li><a href="/user/alley-light-out">Alley Light Out</a></li>
                        <li><a href="/user/street-lights-all-out">Street Lights - All/Out</a></li>
                        <li><a href="/user/street-light-one-out">Street Light - 1/Out</a></li>
                        <li><a href="/user/garbage-cart">Garbage Cart Black Maintenance/Replacement</a></li>
                        <li><a href="/user/rodent-baiting">Rodent Baiting/Rat Complaint</a></li>
                        <li><a href="/user/pot-hole">Pot Hole in Street</a></li>
                        <li><a href="/user/graffiti-removal">Graffiti Removal</a></li>
                        <li><a href="/user/tree-debris">Tree Debris</a></li>
                        <li><a href="/user/tree-trim">Tree Trim</a></li>
                        <li><a href="/user/tree-sanitation-code">Sanitation Code Violation</a></li>
                        <li><a href="/user/vacant-building">Vacant/Abandoned Building</a></li>
                    </ul>
                </li>
            </ul>
            <ol class="nav navbar-nav navbar-right">
                <li>
                    <a href="/user/sf/requests-per-type-in-range">Total requests per type in a specific time range</a>
                </li>
                <li>
                    <a href="/user/sf/requests-with-type-in-range">Total requests with type in a specific time range</a>
                </li>
                <li>
                    <a href="/user/sf/most-common-per-zip-for-day">Most common type per zip code for a specific day</a>
                </li>
                <li>
                    <a href="/user/sf/avg-completion-time-in-range">Average completion time per type in a specific time range</a>
                </li>
                <li>
                    <a href="/user/sf/most-common-in-bounding-box-for-day">Most common type in bounding box for a specific day</a>
                </li>
                <li>
                    <a href="/user/sf/five-top-ssa-per-total-requests">Top 5 SSA per total requests in a specific time range</a>
                </li>
                <li>
                    <a href="/user/sf/licence-plates-involved-in-more-than-one-requests">Licence plates involved in more than one requests</a>
                </li>
                <li>
                    <a href="/user/sf/second-most-common-vehicle-color">Second most common vehicle color</a>
                </li>
                <li>
                    <a href="/user/sf/premises-baited-less-than">Rodent Baiting Requests with Premises baited less than</a>
                </li>
                <li>
                    <a href="/user/sf/premises-with-garbage-less-than">Rodent Baiting Requests with Premises with Garbage less than</a>
                </li>
                <li>
                    <a href="/user/sf/premises-with-rates-less-than">Rodent Baiting Requests with Premises with Rats less than</a>
                </li>
                <li>
                    <a href="/user/sf/pot-holes-rodent-baiting-for-day">Police districts completing more than 1 rodent baiting and more than 1 pot hole request for a day</a>
                </li>
                <li>
                    <a href="/logout">Logout</a>
                </li>
            </ol>
        </div>
    </div>
</nav>
<div id="info-message" class="infoMessageStyle centered" style="display:none;">${infoMessage!""}</div>
<div id="error-message" class="errorMessageStyle centered" style="display:none;">${errorMessage!""}</div>
<#include "service-request/create-service-request-modal.ftl">

