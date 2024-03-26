$(document).ready(function() {
    $('.empire').click(function() {
        var empireId = $(this).data('empire-id');
        $('#form-empire-' + empireId).submit();
    });
});
