Ext.define('wow.store.NpcStore', {
    extend: 'Ext.data.Store',
    model: 'wow.model.NpcModel',
    autoLoad: true,
    storeId: 'npcstore',
    proxy: {
        type: 'ajax',
        url: 'npc/getAll.form',
        reader: {
            type: 'json'
        }
    }
});