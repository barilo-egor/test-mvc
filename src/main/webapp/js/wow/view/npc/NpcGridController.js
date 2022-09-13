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
    }
});