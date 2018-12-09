<#import "/spring.ftl" as spring/>
<html>
<head>
    <title>Second most common vehicle color</title>
     <#include "../../common-head.ftl">
    <#include "../../datatables-bundle.ftl">
    <script src="/scripts/user/stored-functions/one/sf-one-data-table.js"></script>
</head>
<body>
<#include "../navbar.ftl">
<div class="container col-lg-12 col-md-12 col-sm-12 co-xs-12">
    <table id="resultsTable" class="table table-responsive table-striped table-hover custom-data-table">
        <thead>
        <tr>
            <th class="text-center">
                Vehicle color
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
                    <td class="text-center">${result.color}</td>
                    <td class="text-center">${result.count?c}</td>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>
</div>
</body>
</html>
