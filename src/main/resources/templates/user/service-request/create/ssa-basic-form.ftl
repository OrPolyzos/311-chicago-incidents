<div class="input-group">
    <label for="ssa">Special Service Area</label>
    <@spring.bind "srForm.ssa"/>
    <input id="ssa" type="number" step="1" name="ssa" value="${srForm.ssa!""}" class="form-control">
</div>
