<a class="btn" data-toggle="modal" data-target="#graffiti-removal-modal-${serviceRequest.srId?c}">
    Graffiti Removal...
</a>
<!-- Modal -->
<div class="modal fade" id="graffiti-removal-modal-${serviceRequest.srId?c}" role="dialog">
    <div class="modal-dialog modal-lg">
        <form class="form-horizontal">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Graffiti Removal</h4>
                </div>
                <div class="modal-body">
                    <div class="container-fluid main-container">
                        <div class="row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                <fieldset>
                                    <div class="form-group">
                                        <label for="whatTypeOfSurfaceTheGraffitiIsOn-${serviceRequest.srId?c}">Type of Surface</label>
                                        <input type="text" class="form-control" id="whatTypeOfSurfaceTheGraffitiIsOn-${serviceRequest.srId?c}" name="whatTypeOfSurfaceTheGraffitiIsOn"
                                               value="${serviceRequest.whatTypeOfSurfaceTheGraffitiIsOn!"-"}" disabled/>
                                    </div>
                                    <div class="form-group">
                                        <label for="whereIsTheGraffitiLocated-${serviceRequest.srId?c}">Where is Located</label>
                                        <input type="text" class="form-control" id="whereIsTheGraffitiLocated-${serviceRequest.srId?c}" name="whereIsTheGraffitiLocated"
                                               value="${serviceRequest.whereIsTheGraffitiLocated!"-"}" disabled/>
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