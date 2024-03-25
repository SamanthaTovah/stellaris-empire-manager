$(document).ready(function() {
    $('.empire').click(function() {
        var empireId = $(this).data('empire-id');
        // Use the empireId to construct the form's ID dynamically and submit
        $('#form-empire-' + empireId).submit();
    });
});
