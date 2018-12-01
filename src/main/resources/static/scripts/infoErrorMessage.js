$(document).ready(function () {
    var infoMessage = $("#info-message");
    if (infoMessage.text().trim() !== '') {
        infoMessage.fadeIn(400).delay(3000).fadeOut(400); //fade out after 3 seconds
    }
    var errorMessage = $("#error-message");
    if (errorMessage.text().trim() !== '') {
        errorMessage.fadeIn(400).delay(3000).fadeOut(400); //fade out after 3 seconds
    }
    var modalErrorMessage = $("#modal-error-message");
    if (modalErrorMessage.text().trim() !== '') {
        modalErrorMessage.fadeIn();
    }
});