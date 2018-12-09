<a class="btn" data-toggle="modal" data-target="#rodent-baiting-modal-${serviceRequest.srId?c}">
    Rodent Baiting...
</a>
<!-- Modal -->
<div class="modal fade" id="rodent-baiting-modal-${serviceRequest.srId?c}" role="dialog">
    <div class="modal-dialog modal-lg">
        <form class="form-horizontal">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Rodent Baiting</h4>
                </div>
                <div class="modal-body">
                    <div class="container-fluid main-container">
                        <div class="row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                <fieldset>
                                    <div class="form-group">
                                        <label for="numberOfPremisesBaited-${serviceRequest.srId?c}">Number of Premises Baited</label>
                                        <input type="text" class="form-control" id="numberOfPremisesBaited-${serviceRequest.srId?c}" name="numberOfPremisesBaited" value="${serviceRequest.numberOfPremisesBaited!"-"}" disabled/>
                                    </div>
                                    <div class="form-group">
                                        <label for="numberOfPremisesWithGarbage-${serviceRequest.srId?c}">Number of Premises with Garbage</label>
                                        <input type="text" class="form-control" id="numberOfPremisesWithGarbage-${serviceRequest.srId?c}" name="numberOfPremisesWithGarbage" value="${serviceRequest.numberOfPremisesWithGarbage!"-"}" disabled/>
                                    </div>
                                    <div class="form-group">
                                        <label for="numberOfPremisesWithRats-${serviceRequest.srId?c}">Number of Premises with Rats</label>
                                        <input type="text" class="form-control" id="numberOfPremisesWithRats-${serviceRequest.srId?c}" name="numberOfPremisesWithRats" value="${serviceRequest.numberOfPremisesWithRats!"-"}" disabled/>
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