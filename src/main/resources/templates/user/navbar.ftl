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
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="/logout">Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div id="info-message" class="infoMessageStyle centered" style="display:none;">${infoMessage!""}</div>
<div id="error-message" class="errorMessageStyle centered" style="display:none;">${errorMessage!""}</div>