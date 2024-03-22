document.addEventListener("DOMContentLoaded", function() {
    document.querySelectorAll('.clickable-row').forEach(function(row) {
        row.addEventListener('click', function() {
            var empireIds = this.getAttribute('data-empire-ids');
            if (empireIds === '[]') {
                window.location.href = '/empires';
            } else {
                empireIds = empireIds.replace(/[\[\] ]/g, '');
                var queryString = empireIds ? '?empireIds=' + empireIds : '';
                window.location.href = '/filtered-empires' + queryString;
            }
        });
    });
});
