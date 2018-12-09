<div class="form-group">
    <label for="currentActivity-${serviceRequest.srId?c}">Current Activity</label>
    <input type="text" class="form-control" id="currentActivity-${serviceRequest.srId?c}" name="currentActivity" value="${serviceRequest.activity.currentActivity!"-"}" disabled/>
</div>
<div class="form-group">
    <label for="mostRecentAction-${serviceRequest.srId?c}">Most Recent Action</label>
    <input type="text" class="form-control" id="mostRecentAction-${serviceRequest.srId?c}" name="mostRecentAction" value="${serviceRequest.activity.mostRecentAction!"-"}" disabled/>
</div>