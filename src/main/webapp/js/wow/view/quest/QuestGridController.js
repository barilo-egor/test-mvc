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
        if(selectedRows.length == 0) {
            Ext.toast('Не выбрана строка для редактирования.')
        } else {
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
        Ext.Ajax.request({
            url: 'location/{' + selectedRows[0].data.id + '}/delete.form',
            success: function(response, options){
                let result = Ext.decode(action.response.responseText)
                Ext.getStore('queststore').add(result.result)
            },
            failure: function(response, options){
                console.log()
            }
        });
    }
});