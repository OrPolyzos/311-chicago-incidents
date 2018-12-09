<#import "/spring.ftl" as spring/>
<html>
<head>
    <title>Abandoned Vehicle Complaints</title>
     <#include "../../../common-head.ftl">
</head>
<body>
<#include "../../navbar.ftl">
<div class="container" style="position: relative;">
    <form class="form-inline text-center" role="form" action="/user/abandoned-vehicle" method="POST" name="srForm">
        <div class="form-inline">
            <#include "service-request-basic-form.ftl"/>
            <#include "activity-basic-form.ftl"/>
            <#include "ssa-basic-form.ftl"/>
            <div class="input-group">
                <label for="licensePlate">License Plate</label>
                 <@spring.bind "srForm.licensePlate"/>
                <input id="licensePlate" type="text" name="licensePlate" value="${srForm.licensePlate!""}" class="form-control">
            </div>
            <div class="input-group">
                <label for="vehicleMakeModel">Vehicle Make/Model</label>
                 <@spring.bind "srForm.vehicleMakeModel"/>
                <input id="vehicleMakeModel" type="text" name="vehicleMakeModel" value="${srForm.vehicleMakeModel!""}" class="form-control">
            </div>
            <div class="input-group">
                <label for="vehicleColor">Vehicle Color</label>
                 <@spring.bind "srForm.vehicleColor"/>
                <input id="vehicleColor" type="text" name="vehicleColor" value="${srForm.vehicleColor!""}" class="form-control">
            </div>
            <div class="input-group">
                <label for="howManyDaysReportedAsParked">How Many Days Has the Vehicle Been Reported as Parked?</label>
                 <@spring.bind "srForm.howManyDaysReportedAsParked"/>
                <input id="howManyDaysReportedAsParked" type="text" name="howManyDaysReportedAsParked" value="${srForm.howManyDaysReportedAsParked!""}" class="form-control">
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
</body>
</html>
