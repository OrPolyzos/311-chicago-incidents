<#if srForm.serviceRequestId??>
<div class="input-group">
    <label for="serviceRequestId">Service Request ID</label>
    <@spring.bind "srForm.serviceRequestId"/>
    <input id="serviceRequestId" type="hidden" name="serviceRequestId" value="${srForm.serviceRequestId!""}" class="form-control">
</div>
<div class="input-group">
    <label for="creationDateTime">Creation Date Time</label>
    <@spring.bind "srForm.creationDateTime"/>
    <input id="creationDateTime" type="datetime-local" name="creationDateTime" value="${srForm.creationDateTime!""}" class="form-control" readonly>
</div>
<div class="input-group">
    <label for="completionDateTime">Completion Date Time</label>
    <@spring.bind "srForm.completionDateTime"/>
    <input id="completionDateTime" type="datetime-local" name="completionDateTime" value="${srForm.completionDateTime!""}" class="form-control">
</div>
</#if>
<div class="input-group">
    <label for="status">Status</label>
    <@spring.bind "srForm.status"/>
    <input id="status" type="text" name="status" value="${srForm.status!""}" class="form-control">
</div>
<div class="input-group">
    <label for="streetAddress">Street Address</label>
    <@spring.bind "srForm.streetAddress"/>
    <input id="streetAddress" type="text" name="streetAddress" value="${srForm.streetAddress!""}" class="form-control">
</div>
<div class="input-group">
    <label for="zipCode">Zip Code</label>
    <@spring.bind "srForm.zipCode"/>
    <input id="zipCode" type="number" step="1" name="zipCode" value="${srForm.zipCode!""}" class="form-control">
</div>
<div class="input-group">
    <label for="coordinateX">Coordinate X</label>
    <@spring.bind "srForm.coordinateX"/>
    <input id="coordinateX" type="number" step="any" name="coordinateX" value="${srForm.coordinateX!""}" class="form-control">
</div>
<div class="input-group">
    <label for="coordinateY">Coordinate Y</label>
    <@spring.bind "srForm.coordinateY"/>
    <input id="coordinateY" type="number" step="any" name="coordinateY" value="${srForm.coordinateY!""}" class="form-control">
</div>
<div class="input-group">
    <label for="ward">Ward</label>
    <@spring.bind "srForm.ward"/>
    <input id="ward" type="number" step="1" name="ward" value="${srForm.ward!""}" class="form-control">
</div>
<div class="input-group">
    <label for="policeDistrict">Police District</label>
    <@spring.bind "srForm.policeDistrict"/>
    <input id="policeDistrict" type="number" step="1" name="policeDistrict" value="${srForm.policeDistrict!""}" class="form-control">
</div>
<div class="input-group">
    <label for="communityArea">Community Area</label>
    <@spring.bind "srForm.communityArea"/>
    <input id="communityArea" type="number" step="1" name="communityArea" value="${srForm.communityArea!""}" class="form-control">
</div>
<div class="input-group">
    <label for="longitude">Longitude</label>
    <@spring.bind "srForm.longitude"/>
    <input id="longitude" type="number" step="any" name="longitude" value="${srForm.longitude!""}" class="form-control">
</div>
<div class="input-group">
    <label for="latitude">Latitude</label>
    <@spring.bind "srForm.latitude"/>
    <input id="latitude" type="number" step="1" name="latitude" value="${srForm.latitude!""}" class="form-control">
</div>
<div class="input-group">
    <label for="location">Location</label>
    <@spring.bind "srForm.location"/>
    <input id="location" type="text" name="location" value="${srForm.location!""}" class="form-control">
</div>