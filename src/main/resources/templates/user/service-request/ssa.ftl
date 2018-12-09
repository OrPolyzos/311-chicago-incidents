<div class="form-group">
    <label for="ssa-${serviceRequest.srId?c}">Special Service Area</label>
    <input type="text" class="form-control" id="ssa-${serviceRequest.srId?c}" name="ssa" value="${serviceRequest.specialServiceArea.ssa!"-"}" disabled/>
</div>