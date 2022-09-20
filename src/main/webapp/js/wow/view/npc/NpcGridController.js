Ext.define('wow.view.npc.NpcGridController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.npcGridController',
    requires: ['wow.view.npc.NpcWindow'],
    onCreateClick: function() {
        Ext.create('wow.view.npc.NpcWindow', {
            title: 'Создание нпс',
        }).show();
    },
    onEditClick: function() {
        let selectedRows = Ext.getCmp('npcgrid').getSelectionModel().getSelection();
        if(selectedRows.length == 0) {
            Ext.toast('Не выбрана строка для редактирования.')
        } else {
            Ext.create('wow.view.npc.NpcWindow', {
                title: 'Редактирование нпс',
                viewModel: {
                    data: {
                        npc: selectedRows[0].data,
                    }
                }
            }).show();
        }
    },
    onDeleteClick: function() {
        let rows = Ext.getCmp('npcgrid').getStore().getRange();
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
                url: 'npc/delete.form',
                method: 'POST',
                params: {
                    'array': array
                },
                success: function(response){
                    let result = Ext.decode(response.responseText);
                    let store = Ext.getStore('npcstore');
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