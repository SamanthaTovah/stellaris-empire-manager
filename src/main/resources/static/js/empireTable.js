function confirmDelete(empireId) {
    if (confirm("Are you sure you want to delete this empire?")) {
        fetch('/delete-empire/' + empireId, {
            method: 'DELETE',
        }).then(response => window.location.reload());
    }
}

$(document).ready(function() {
    $('.empire-table').DataTable({
        "order": [[2, "desc"]],
        "pageLength": 100,
        "columnDefs": [{
            "targets": 3,
            "orderable": false, // This makes the Actions column not sortable
        }]
    });
});
