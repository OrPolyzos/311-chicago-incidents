<a class="btn" data-toggle="modal" data-target="#abandoned-vehicle-modal-${serviceRequest.srId?c}">
    Abandoned Vehicle...
</a>
<!-- Modal -->
<div class="modal fade" id="abandoned-vehicle-modal-${serviceRequest.srId?c}" role="dialog">
    <div class="modal-dialog modal-lg">
        <form class="form-horizontal">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Abandoned Vehicle</h4>
                </div>
                <div class="modal-body">
                    <div class="container-fluid main-container">
                        <div class="row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                <fieldset>
                                    <div class="form-group">
                                        <label for="licensePlate-${serviceRequest.srId?c}">Licence Plate</label>
                                        <input type="text" class="form-control" id="licensePlate-${serviceRequest.srId?c}" name="licensePlate" value="${serviceRequest.licensePlate!"-"}" disabled/>
                                    </div>
                                    <div class="form-group">
                                        <label for="vehicleMakeModel-${serviceRequest.srId?c}">Vehicle Make Model</label>
                                        <input type="text" class="form-control" id="vehicleMakeModel-${serviceRequest.srId?c}" name="vehicleMakeModel" value="${serviceRequest.vehicleMakeModel!"-"}" disabled/>
                                    </div>
                                    <div class="form-group">
                                        <label for="vehicleColor-${serviceRequest.srId?c}">Vehicle Color</label>
                                        <input type="text" class="form-control" id="vehicleColor-${serviceRequest.srId?c}" name="vehicleColor" value="${serviceRequest.vehicleColor!"-"}" disabled/>
                                    </div>
                                    <div class="form-group">
                                        <label for="howManyDaysReportedAsParked-${serviceRequest.srId?c}">How Many Days Reported as Parked</label>
                                        <input type="text" class="form-control" id="howManyDaysReportedAsParked-${serviceRequest.srId?c}" name="howManyDaysReportedAsParked" value="${serviceRequest.howManyDaysReportedAsParked!"-"}" disabled/>
                                    </div>
                                    <#if serviceRequest.activity??>
                                        <#include "../activity.ftl">
                                    </#if>
                                    <#if serviceRequest.specialServiceArea??>
                                        <#include "../ssa.ftl">
                                    </#if>
                                </fieldset>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </form>
    </div>
</div>