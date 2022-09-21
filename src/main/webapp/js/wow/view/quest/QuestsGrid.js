Ext.define('wow.view.quest.QuestsGrid', {
    extend: 'Ext.grid.Panel',
    xtype: 'questsgrid',
    store: 'queststore',
    id: 'questsgrid',
    requires: ['wow.view.quest.QuestGridController', 'wow.view.quest.ViewQuestWindow'],
    controller: 'questGridController',
    listeners: {
            rowdblclick: function(row, record){
                Ext.create('wow.view.quest.ViewQuestWindow', {
                    title: 'Форма для просмотра квеста',
                    viewModel: {
                        data: {
                           quest: record.data
                        }
                    }
                }).show();
            }
    },
    columns: [
        {
            xtype: 'checkcolumn',
            dataIndex: 'active'
        },
        {
            header: 'ID',
            dataIndex: 'id',
            flex: 1
        },
        {
            header: 'Название',
            dataIndex: 'name',
            flex: 3
        },
        {
            header: 'Тип квеста',
            dataIndex: 'questType',
            flex: 2
        },
        {
            header: 'Имя нпс',
            dataIndex: 'npc',
            flex: 2
        }],
        dockedItems: [
            {
                xtype:'toolbar',
                docked: 'top',
                items: [
                    {
                        text:'Создать',
                        handler: 'onCreateClick'

                    },
                    {
                        text:'Редактировать',
                        handler: 'onEditClick'
                    },
                    {
                        text:'Удалить',
                        handler: 'onDeleteClick'
                    }
                ]
            }
        ]
});