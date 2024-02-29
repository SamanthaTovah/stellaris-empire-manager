function confirmDelete(empireId) {
    if (confirm("Are you sure you want to delete this empire?")) {
        fetch('/delete-empire/' + empireId, {
            method: 'DELETE',
        }).then(response => window.location.reload());
    }
}
