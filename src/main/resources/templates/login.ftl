<#import "/spring.ftl" as spring/>
<html>
<head>
    <title>Login</title>
    <#include "common-head.ftl">
</head>
<body style="background-image: url(/bg/white-background.jpg);">
    <nav class="login-navbar navbar navbar-inverse" id="loginNavBar">
        <div class="container-fluid">
            <div class="navbar-header"></div>
        </div>
    </nav>
    <div id="error-message" class="errorMessageStyle">${errorMessage!""}</div>
    <br/><br/><br/>
    <div class="container">
        <div class="row">
            <div class="col-lg-6 col-lg-offset-3 col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3 col-xs-6 col-xs-offset-3">
                <form class="form-horizontal" action="/login" method="POST" id="loginForm" name="loginForm">
                    <fieldset>
                        <legend class="bigLegend">Login</legend>
                        <div class="form-group">
                            <label for="username">Username</label>
                            <@spring.bind "loginForm.username"/>
                            <input type="text" class="form-control" id="username" name="username" placeholder="Your username..." value="${loginForm.username!""}" required/>
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <@spring.bind "loginForm.password"/>
                            <input type="password" class="form-control" id="password" name="password" placeholder="Your password..." value="${loginForm.password!""}" required/>
                        </div>
                    </fieldset>
                    <div class="centered">
                    <span>
                        <button type="submit" id="btn-submit" class="btn btn-success btn-md">Submit</button>
                        <button type="reset" id="btn-clear" class="btn btn-danger btn-md">Clear</button>
                    </span>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
