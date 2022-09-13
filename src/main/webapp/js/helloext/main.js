Ext.application({
    name: 'Сущности',
    launch: function() {
        var mainPanel = Ext.create('Ext.tab.Panel', {
            title: 'Сущности',
            layout: 'fit',
            renderTo: Ext.getBody(),
        });

        var questPanel = Ext.create('Ext.grid.Panel', {
                   title: 'Квесты'
                   });

        var npcPanel = Ext.create('Ext.grid.Panel', {
                           title: 'НПС'
                           });

        var locationPanel = Ext.create('Ext.grid.Panel', {
                           title: 'Локации'
                           });

        mainPanel.add(questPanel);

        mainPanel.add(npcPanel);

        mainPanel.add(locationPanel);

    }
});