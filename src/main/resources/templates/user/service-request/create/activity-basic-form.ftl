<div class="input-group">
    <label for="currentActivity">Current Activity</label>
    <@spring.bind "srForm.currentActivity"/>
    <input id="currentActivity" type="text" name="currentActivity" value="${srForm.currentActivity!""}" class="form-control">
</div>
<div class="input-group">
    <label for="mostRecentAction">Most Recent Action</label>
    <@spring.bind "srForm.mostRecentAction"/>
    <input id="mostRecentAction" type="text" name="mostRecentAction" value="${srForm.mostRecentAction!""}" class="form-control">
</div>