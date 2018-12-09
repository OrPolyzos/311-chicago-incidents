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
            <a href="<#--TODO ADD CREATE SERVICE REQUEST-->" data-toggle="modal" data-target="#create-service-request-modal" class="navbar-brand">Create Service Request</a>
        </div>
        <!-- Menu Items -->
        <div id="mainNavBarMob" class="collapse navbar-collapse">
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
                    <a href="/user/sf/premises-with-rates-less-than">Rodent Baiting Requests with Premises with Rates less than</a>
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

