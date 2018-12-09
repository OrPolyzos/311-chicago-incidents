<#import "/spring.ftl" as spring/>
<html>
<head>
    <title>More than 1 pot holes together with more than 1 rodent baiting requests for specific day</title>
     <#include "../../common-head.ftl">
    <#include "../../datatables-bundle.ftl">
    <script src="/scripts/user/stored-functions/one/sf-one-data-table.js"></script>
</head>
<body>
<#include "../navbar.ftl">
<div class="container" style="position: relative;">
    <form class="form-inline text-center" role="form" action="/user/sf/pot-holes-rodent-baiting-for-day" method="POST" name="searchForm">
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
                Police Districts
            </th>
        </tr>
        </thead>
        <tbody>
        <#if results??>
            <#list results as result>
                <tr>
                    <td class="text-center">${result?c}</td>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>
</div>
</body>
</html>
