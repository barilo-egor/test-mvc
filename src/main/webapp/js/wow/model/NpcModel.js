Ext.define('wow.model.NpcModel', {
    extend: 'Ext.data.Model',
    fields: [
        {
            name: 'id',
            type: 'int'
        },
        {
            name: 'name',
            type: 'string'
        },
        {
            name: 'eliteStatus',
            type: 'bool'
        },
        {
            name: 'fraction',
            type: 'string'
        },
        {
            name: 'location',
            type: 'string'
        }
    ]
});