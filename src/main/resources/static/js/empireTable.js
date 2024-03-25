function confirmDelete(empireId) {
    if (confirm("Are you sure you want to delete this empire?")) {
        fetch('/delete-empire/' + empireId, {
            method: 'DELETE',
        }).then(response => window.location.reload());
    }
}

document.addEventListener("DOMContentLoaded", function() {
    document.querySelectorAll('.clickable-row-empire').forEach(function(row) {
        row.addEventListener('click', function() {
            var empireId = this.getAttribute('data-empire-id');
            if (empireId === null) {
                window.location.href = '/empires';
            } else {
                window.location.href = '/empire/' + empireId;
            }
        });
    });
});
