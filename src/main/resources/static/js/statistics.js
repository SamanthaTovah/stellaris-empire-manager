document.addEventListener("DOMContentLoaded", function() {
    document.querySelectorAll('.clickable-row-empires').forEach(function(row) {
        row.addEventListener('click', function() {
            var empireIds = this.getAttribute('data-empire-ids');
            if (empireIds === '[]') {
                window.location.href = '/empires';
            } else {
                empireIds = empireIds.replace(/[\[\] ]/g, '');
                window.location.href = '/filtered-empires?empireIds=' + empireIds;
            }
        });
    });
});
