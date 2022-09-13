Ext.define('wow.view.location.LocationGrid', {
    extend: 'Ext.grid.Panel',
//    title: 'Локации',
    xtype: 'locationgrid',
    store: 'locationstore',
    id: 'locationgrid',
    requires: ['wow.view.location.LocationGridController', 'wow.view.location.ViewLocationWindow'],
    controller: 'locationGridController',
    listeners: {
        rowdblclick: function(row, record){
            Ext.create('wow.view.location.ViewLocationWindow', {
                title: 'Форма для просмотра локации',
                viewModel: {
                    data: {
                        location: record.data
                    }
                }
            }).show();
        }
    },
    columns: [
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
            header: 'Континент',
            dataIndex: 'mainland',
            flex: 3
        },
        {
            header: 'Дата введения',
            dataIndex: 'introductionDate',
            xtype: 'datecolumn',
            format: 'd/m/Y',
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
                                action: 'delete'
                            }
                        ]
                    }
                ]
});