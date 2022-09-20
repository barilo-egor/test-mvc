Ext.define('wow.view.npc.NpcGrid', {
    extend: 'Ext.grid.Panel',
//    title: 'НПС',
    xtype: 'npcgrid',
    store: 'npcstore',
    id: 'npcgrid',
    requires: ['wow.view.npc.NpcGridController', 'wow.view.npc.ViewNpcWindow'],
    controller: 'npcGridController',
    listeners: {
        rowdblclick: function(row, record){
            if(record.data.eliteStatus) record.data.eliteStatus = 'Да';
            else record.data.eliteStatus = 'Нет';
            Ext.create('wow.view.npc.ViewNpcWindow', {
                title: 'Форма для просмотра нпс',
                viewModel: {
                    data: {
                        npc: record.data
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
            header: 'Имя',
            dataIndex: 'name',
            flex: 3
        },
        {
            header: 'Элита',
            xtype: 'booleancolumn',
            dataIndex: 'eliteStatus',
            trueText:'Да',
            falseText:'Нет',
            flex: 2
        },
        {
            header: 'Фракция',
            dataIndex: 'fraction',
            flex: 2
        },
        {
            header: 'Локация',
            dataIndex: 'location',
            flex: 3
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