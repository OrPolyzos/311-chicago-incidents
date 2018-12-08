<#import "/spring.ftl" as spring/>
<html>
<head>
    <title>Most common request per zip code for a specific day</title>
     <#include "../../common-head.ftl">
    <#include "../../datatables-bundle.ftl">
    <script src="/scripts/user/stored-functions/one/sf-one-data-table.js"></script>
</head>
<body>
<#include "../navbar.ftl">
<div class="container" style="position: relative;">
    <form class="form-inline text-center" role="form" action="/user/sf/most-common-per-zip-for-day" method="POST" name="searchForm">
        <div class="form-inline">
            <div class="input-group ">
                <label for="time">Day</label>
                <@spring.bind "searchForm.time"/>
                <input id="fromTime" type="date" name="time" value="${searchForm.time!""}" class="form-control">
            </div>
        </div>
        <br>
        <div class="input-group">
            <button type="submit" class="btn btn-success">
                Submit
            </button>
        </div>
    </form>
</div>
<div class="container col-lg-12 col-md-12 col-sm-12 co-xs-12">
    <table id="resultsTable" class="table table-responsive table-striped table-hover custom-data-table">
        <thead>
        <tr>
            <th class="text-center">
                Zip Code
            </th>
            <th class="text-center">
                Service Request Type
            </th>
            <th class="text-center">
                Count
            </th>
        </tr>
        </thead>
        <tbody>
        <#if results??>
            <#list results as result>
                <tr>
                    <td class="text-center">${result.zipCode?c}</td>
                    <td class="text-center">${result.serviceRequestType.value}</td>
                    <td class="text-center">${result.count?c}</td>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>
</div>
</body>
</html>
