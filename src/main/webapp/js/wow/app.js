Ext.application({
    extend: 'Ext.app.Application',
    name: 'wow',
    appFolder: 'wow',
    autoCreateViewport: true,
    stores: ['wow.store.QuestStore', 'wow.store.NpcStore', 'wow.store.LocationStore']
});