Ext.application({
    name: 'Сущности',
    launch: function() {
        var mainPanel = Ext.create('Ext.tab.Panel', {
            title: 'Сущности',
            layout: 'fit',
            renderTo: Ext.getBody(),
        });

        var questPanel = Ext.create('Ext.grid.Panel', {
           title: 'Квесты',
           store: questStore,
           columns: [{
                header: 'ID',
                dataIndex: 'id',
                flex: 1
           }, {
                header: 'Название',
                dataIndex: 'name',
                flex: 1
           }, {
                header: 'Тип квеста',
                dataIndex: 'questType',
                flex: 1
           }, {
                header: 'Имя нпс',
                dataIndex: 'npc',
                flex: 1
           }],

        });

        mainPanel.add(questPanel);

        Ext.define('Quest', {
            extend: 'Ext.data.Model',

            idProperty: 'id',

            fields: [{
                name: 'id',
                type: 'int'
            }, {
                name: 'name',
                type: 'String'
            }, {
                name: 'questType',
                type: 'questType'
            }, {
                name: 'npc',
                type: 'npc'
            }]
        });

        var questStore = Ext.create('Ext.data.Store', {
            model: 'Quest',
            autoLoad: true,
            proxy: {
                type: 'ajax',
                url: 'quests.json',
                reader: {
                    type: 'json',
                    root: 'quests'
                }
            }
        });

        var npcPanel = Ext.create('Ext.grid.Panel', {
            title: 'НПС',
            store: npcStore,
            columns: [{
                header: 'ID',
                dataIndex: 'id',
                flex: 1
            }, {
                header: 'Имя',
                dataIndex: 'name',
                flex: 1
            }, {
                header: 'Элита',
                dataIndex: 'eliteStatus',
                flex: 1
            }, {
                header: 'Фракция',
                dataIndex: 'fraction',
                flex: 1
            }, {
                header: 'Локация',
                dataIndex: 'location',
                flex: 1
            }],
        });

        mainPanel.add(npcPanel);

        Ext.define('NPC', {
                    extend: 'Ext.data.Model',

                    idProperty: 'id',

                    fields: [{
                        name: 'id',
                        type: 'int'
                    }, {
                        name: 'name',
                        type: 'String'
                    }, {
                        name: 'eliteStatus',
                        type: 'eliteStatus'
                    }, {
                        name: 'fraction',
                        type: 'fraction'
                    }, {
                        name: 'location',
                        type: 'location'
                    }]
                });

        var npcStore = Ext.create('Ext.data.Store', {
            model: 'NPC',
            autoLoad: true,
            proxy: {
                type: 'ajax',
                url: 'npc.json',
                reader: {
                    type: 'json',
                    root: 'npc'
                }
            }
        });
    }
});