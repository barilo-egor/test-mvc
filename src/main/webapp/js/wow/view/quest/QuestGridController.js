Ext.define('wow.view.quest.QuestGridController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.questGridController',
    requires: ['wow.view.quest.QuestWindow'],
    onCreateClick: function() {
        Ext.create('wow.view.quest.QuestWindow', {
            title: 'Создание квеста',
//            viewModel: {
//                data: {
//                    url: 'quest/create.form'
//                }
//            }
        }).show();
    },
    onEditClick: function() {
        let selectedRows = Ext.getCmp('questsgrid').getSelectionModel().getSelection();
        if(selectedRows.length == 0) Ext.toast('Не выбрана строка для редактирования.');
        else {
            Ext.create('wow.view.quest.QuestWindow', {
                title: 'Редактирование квеста',
                viewModel: {
                    data: {
                        quest: selectedRows[0].data,
//                        url: 'quest/edit.form'
                    }
                }
            }).show();
        }
    },
    onDeleteClick: function() {
        let rows = Ext.getCmp('questsgrid').getStore().getRange();
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
            url: 'quest/delete.form',
            method: 'POST',
            params: {
                'array': array
            },
            success: function(response){
                let result = Ext.decode(response.responseText);
                let store = Ext.getStore('queststore');
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