Ext.define('wow.view.location.LocationGridController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.locationGridController',
    requires: ['wow.view.location.LocationWindow'],
    onCreateClick: function() {
        Ext.create('wow.view.location.LocationWindow', {
            title: 'Создание локации',
        }).show();
    },
    onEditClick: function() {
        let selectedRows = Ext.getCmp('locationgrid').getSelectionModel().getSelection();
        if(selectedRows.length == 0) {
            Ext.toast('Не выбрана строка для редактирования.')
        } else {
            Ext.create('wow.view.location.LocationWindow', {
                title: 'Редактирование локации',
                viewModel: {
                    data: {
                        location: selectedRows[0].data
                    }
                }
            }).show();
        }
    }
});