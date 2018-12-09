<a class="btn" data-toggle="modal" data-target="#pot-hole-modal-${serviceRequest.srId?c}">
    Pot Hole...
</a>
<!-- Modal -->
<div class="modal fade" id="pot-hole-modal-${serviceRequest.srId?c}" role="dialog">
    <div class="modal-dialog modal-lg">
        <form class="form-horizontal">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Pot Hole</h4>
                </div>
                <div class="modal-body">
                    <div class="container-fluid main-container">
                        <div class="row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                <fieldset>
                                    <div class="form-group">
                                        <label for="numberOfPotholesFilledOnBlock-${serviceRequest.srId?c}">Number of Pot Holes Filled on Block</label>
                                        <input type="text" class="form-control" id="numberOfPotholesFilledOnBlock-${serviceRequest.srId?c}" name="numberOfPotholesFilledOnBlock"
                                               value="${serviceRequest.numberOfPotholesFilledOnBlock!"-"}" disabled/>
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