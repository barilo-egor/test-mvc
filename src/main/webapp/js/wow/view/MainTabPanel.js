Ext.define('wow.view.MainTabPanel', {
    xtype: 'mainpanel',
    extend: 'Ext.tab.Panel',
    title: 'Энциклопедия WoW',
    requires: ['wow.view.quest.QuestsGrid', 'wow.view.npc.NpcGrid', 'wow.view.location.LocationGrid'],
    items: [
        {
            title: 'Квесты',
            layout: 'fit',
            items: [
                {
                    xtype: 'questsgrid'
                }
            ]
        },
        {
            title: 'НПС',
            layout: 'fit',
            items: [
                {
                    xtype: 'npcgrid'
                }
            ]
        },
        {
            title: 'Локации',
            layout: 'fit',
            items: [
                {
                    xtype: 'locationgrid'
                }
            ]
        }
    ]
});