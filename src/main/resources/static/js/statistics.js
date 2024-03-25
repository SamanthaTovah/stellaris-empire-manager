document.addEventListener("DOMContentLoaded", function() {
    document.querySelectorAll('.clickable-row-empires').forEach(function(row) {
        row.addEventListener('click', function(event) {
            if (event.target.classList.contains('clickable-wins-cell')) {
                return;
            }
            var empireIds = this.getAttribute('data-empire-ids');
            if (empireIds === '[]') {
                window.location.href = '/empires';
            } else {
                empireIds = empireIds.replace(/[\[\] ]/g, '');
                window.location.href = '/filtered-empires?empireIds=' + empireIds;
            }
        });
    });

    document.querySelectorAll('.clickable-wins-cell').forEach(function(cell) {
        cell.addEventListener('click', function() {
            var empireIdsWon = this.getAttribute('data-empire-ids-won');
            if (empireIdsWon === '[]') {
                window.location.href = '/empires';
            } else {
                empireIdsWon = empireIdsWon.replace(/[\[\] ]/g, '');
                window.location.href = '/filtered-empires?empireIds=' + empireIdsWon;
            }
        });
    });
});
