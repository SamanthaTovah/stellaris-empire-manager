// due to dynamic content loading and DataTables initialization
// the content in this file cannot be imported via the fragment
$(window).on('load', function() {
    $('.stats-table').each(function() {
        if (!$.fn.DataTable.isDataTable(this)) {
            $(this).DataTable({
                "order": []
            });
        }
    });

    $('.view-empires-table').DataTable({
        "order": [[4, "desc"]],
        "pageLength": 100,
        "columnDefs": [{
            "targets": [1, 2, 5],
            "orderable": false
        }]
    });
});
