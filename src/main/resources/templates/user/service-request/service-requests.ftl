<#import "/spring.ftl" as spring/>
<html>
<head>
    <title>Service Requests</title>
     <#include "../../common-head.ftl">
    <#include "../../datatables-bundle.ftl">
    <script src="/scripts/user/service-request/serviceRequestsDataTable.js"></script>
    <script src="/scripts/user/service-request/showCreateModal.js"></script>
</head>
<body>
<#include "../navbar.ftl">
<button data-toggle="modal" data-target="#create-service-request-modal" class="btn btn-success floating-button-right">+</button>
<#include "create-service-request-modal.ftl"/>
<div class="container col-lg-12 col-md-12 col-sm-12 co-xs-12">
        <table id="resultsTable" class="table table-responsive table-striped table-hover custom-data-table">
            <thead>
            <tr>
                <th class="text-center">
                    ID
                </th>
                <th class="text-center">
                    Number
                </th>
                <th class="text-center">
                    Type
                </th>
                <th class="text-center">
                    Zip Code
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
                <#if serviceRequests??>
                    <#list serviceRequests as serviceRequest>
                        <tr>
                            <td class="text-center">${serviceRequest.id}</td>
                            <td class="text-center">${serviceRequest.serviceRequestNumber}</td>
                            <td class="text-center">${serviceRequest.serviceRequestType}</td>
                            <td class="text-center">${serviceRequest.zipCode}</td>
                            <td class="text-center">${serviceRequest.coordinateX}</td>
                            <td class="text-center">${serviceRequest.coordinateY}</td>
                            <td class="text-center">${serviceRequest.ward}</td>
                            <td class="text-center">${serviceRequest.policeDistrict}</td>
                            <td class="text-center">${serviceRequest.communityArea}</td>
                            <td class="text-center">${serviceRequest.longitude}</td>
                            <td class="text-center">${serviceRequest.latitude}</td>
                            <td class="text-center">${serviceRequest.location}</td>
                        </tr>
                    </#list>
                </#if>
            </tbody>
        </table>
    </div>
</body>
</html>
