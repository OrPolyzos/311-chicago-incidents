<#import "/spring.ftl" as spring/>
<html>
<head>
    <title>Service Requests</title>
     <#include "../../common-head.ftl">
    <#include "../../datatables-bundle.ftl">
    <script src="/scripts/user/service-request/service-requests-data-table.js"></script>
    <script src="/scripts/user/service-request/show-create-service-request-modal.js"></script>
</head>
<body>
<#include "../navbar.ftl">
<#include "create-service-request-modal.ftl"/>
<div class="container" style="position: relative;">
    <form class="form-inline text-center" role="form" action="/user/service-requests" method="POST" name="searchForm">
        <div class="form-inline">
            <div class="input-group ">
                <label for="serviceRequestId">Service Request ID</label>
                <@spring.bind "searchForm.serviceRequestId"/>
                <input id="serviceRequestId" type="number" step="1" name="serviceRequestId" value="${searchForm.serviceRequestId!""}" class="form-control">
            </div>
            <div class="input-group">
                <label for="streetAddress">Street Address</label>
                <@spring.bind "searchForm.streetAddress"/>
                <input id="streetAddress" type="search" name="streetAddress" value="${searchForm.streetAddress!""}" class="form-control">
            </div>
            <div class="input-group">
                <label for="zipCode">Zip Code</label>
                <@spring.bind "searchForm.zipCode"/>
                <input id="zipCode" type="search" name="zipCode" value="${searchForm.zipCode!""}" class="form-control">
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
                    ID
                </th>
                <th class="text-center">
                    SrNumber
                </th>
                <th class="text-center">
                    Type
                </th>
                <th class="text-center">
                    Creation DT
                </th>
                <th class="text-center">
                    Completion DT
                </th>
                <th class="text-center">
                    Zip Code
                </th>
                <th class="text-center">
                    Street Address
                </th>
                <th class="text-center">
                    Coord. X
                </th>
                <th class="text-center">
                    Coord. Y
                </th>
                <th class="text-center">
                    Ward
                </th>
                <th class="text-center">
                    Police District
                </th>
                <th class="text-center">
                    Community Area
                </th>
                <th class="text-center">
                    Longitude
                </th>
                <th class="text-center">
                    Latitude
                </th>
                <th class="text-center">
                    Location
                </th>
            </tr>
            </thead>
            <tbody>
                <#if results??>
                    <#list results as serviceRequest>
                        <tr>
                            <td class="text-center">${serviceRequest.srId!""}</td>
                            <td class="text-center">${serviceRequest.srNumber!""}</td>
                            <td class="text-center">${serviceRequest.srType.value!""}</td>
                            <td class="text-center">${serviceRequest.creationDateTime!""}</td>
                            <td class="text-center">${serviceRequest.completionDateTime!""}</td>
                            <td class="text-center">${serviceRequest.zipCode!""}</td>
                            <td class="text-center">${serviceRequest.streetAddress!""}</td>
                            <td class="text-center">${serviceRequest.coordinateX!""}</td>
                            <td class="text-center">${serviceRequest.coordinateY!""}</td>
                            <td class="text-center">${serviceRequest.ward!""}</td>
                            <td class="text-center">${serviceRequest.policeDistrict!""}</td>
                            <td class="text-center">${serviceRequest.communityArea!""}</td>
                            <td class="text-center">${serviceRequest.longitude!""}</td>
                            <td class="text-center">${serviceRequest.latitude!""}</td>
                            <td class="text-center">${serviceRequest.location!""}</td>
                        </tr>
                    </#list>
                </#if>
            </tbody>
        </table>
    </div>
</body>
</html>
