<a class="btn" data-toggle="modal" data-target="#sanitation-code-complaint-modal-${serviceRequest.srId?c}">
    Sanitation Code Complaint...
</a>
<!-- Modal -->
<div class="modal fade" id="sanitation-code-complaint-modal-${serviceRequest.srId?c}" role="dialog">
    <div class="modal-dialog modal-lg">
        <form class="form-horizontal">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Sanitation Code Complaint</h4>
                </div>
                <div class="modal-body">
                    <div class="container-fluid main-container">
                        <div class="row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                <fieldset>
                                    <div class="form-group">
                                        <label for="natureOfThisCodeViolation-${serviceRequest.srId?c}">,What is the Nature of this Code Violation?</label>
                                        <input type="text" class="form-control" id="natureOfThisCodeViolation-${serviceRequest.srId?c}" name="natureOfThisCodeViolation"
                                               value="${serviceRequest.natureOfThisCodeViolation!"-"}" disabled/>
                                    </div>
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