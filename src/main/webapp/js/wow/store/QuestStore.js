Ext.define('wow.store.QuestStore', {
    extend: 'Ext.data.Store',
    model: 'wow.model.QuestModel',
    autoLoad: true,
    storeId: 'queststore',
    proxy: {
        type: 'ajax',
        url: 'quest/getAll.form',
        reader: {
            type: 'json'
        }
    }
});