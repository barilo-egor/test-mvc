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
    },
    onDeleteClick: function() {
        let rows = Ext.getCmp('locationgrid').getStore().getRange();
        let set = new Set;
        for(let i = 0; i < rows.length; i++) {
            if(rows[i].data.active) {
                set.add(rows[i].data.id)
            }
        }
        let array = Array.from(set);
        if(array.length == 0) Ext.toast('Не выбрана строка для удаления.');
        else {
            Ext.Ajax.request({
                url: 'location/delete.form',
                method: 'POST',
                params: {
                    'array': array
                },
                success: function(response){
                    let result = Ext.decode(response.responseText);
                    let store = Ext.getStore('locationstore');
                    for(let i = 0; i < result.result.length; i++) {
                        store.remove(store.findRecord('id', result.result[i].id));
                    }
                },
                failure: function(form, action){
                    console.log()
                }
            });
        }
    }
});