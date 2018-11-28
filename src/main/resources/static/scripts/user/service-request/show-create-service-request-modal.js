$(document).ready(function () {
    var showModal = $("#show-create-service-request-modal").attr("value");
    if (showModal === true) {
        $("#create-service-request-modal").modal();
    }
});