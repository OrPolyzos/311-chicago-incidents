<#import "/spring.ftl" as spring/>
<html>
<head>
    <title>Top 5 SSA per total requests in a specific time range</title>
     <#include "../../common-head.ftl">
    <#include "../../datatables-bundle.ftl">
    <script src="/scripts/user/stored-functions/one/sf-one-data-table.js"></script>
</head>
<body>
<#include "../navbar.ftl">
<div class="container" style="position: relative;">
    <form class="form-inline text-center" role="form" action="/user/sf/five-top-ssa-per-total-requests" method="POST" name="searchForm">
        <div class="form-inline">
            <div class="input-group ">
                <label for="fromTime">From Time</label>
                <@spring.bind "searchForm.fromTime"/>
                <input id="fromTime" type="datetime-local" name="fromTime" value="${searchForm.fromTime!""}" class="form-control">
            </div>
            <div class="input-group">
                <label for="toTime">To Time</label>
                <@spring.bind "searchForm.toTime"/>
                <input id="toTime" type="datetime-local" name="toTime" value="${searchForm.toTime!""}" class="form-control">
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
                Special Service Area
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
                    <td class="text-center">${result.ssa}</td>
                    <td class="text-center">${result.count?c}</td>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>
</div>
</body>
</html>
