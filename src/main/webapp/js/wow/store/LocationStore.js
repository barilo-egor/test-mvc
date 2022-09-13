Ext.define('wow.store.LocationStore', {
    extend: 'Ext.data.Store',
    model: 'wow.model.LocationModel',
    autoLoad: true,
    storeId: 'locationstore',
    proxy: {
        type: 'ajax',
        url: 'location/getAll.form',
        reader: {
            type: 'json'
        }
    }
});