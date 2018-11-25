let customDatatables = function () {
    let initTables = function () {
        let tables = $('.custom-data-table');
        for (let i = 0; i < tables.length; i++) {
            let table = $(tables[i]);
            table.DataTable({
                responsive: {
                    details: {
                        display: $.fn.dataTable.Responsive.display.childRow,
                        renderer: $.fn.dataTable.Responsive.renderer.tableAll()
                    }
                },
                lengthMenu: [5, 10, 25, 50],
                pageLength: 25,
                order: [[0, 'asc']],
                columnDefs: [
                    {
                        targets: 0,
                        responsivePriority: 1,
                        orderable: true
                    },
                    {
                        targets: 1,
                        responsivePriority: 2,
                        orderable: true
                    },
                    {
                        targets: 2,
                        responsivePriority: 3,
                        orderable: true
                    },
                    {
                        targets: 3,
                        orderable: true
                    },
                    {
                        targets: 4,
                        orderable: true
                    },
                    {
                        targets: 5,
                        orderable: true
                    },
                    {
                        targets: 6,
                        orderable: true
                    },
                    {
                        targets: 7,
                        orderable: true
                    },
                    {
                        targets: 8,
                        orderable: true
                    },
                    {
                        targets: 9,
                        orderable: true
                    },
                    {
                        targets: 10,
                        orderable: true
                    }
                ]
            });
        }
    };
    return {
        init: function () {
            initTables();
        }
    };
}();

jQuery(document).ready(function () {
    customDatatables.init();

});