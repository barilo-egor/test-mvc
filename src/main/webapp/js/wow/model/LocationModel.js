Ext.define('wow.model.LocationModel', {
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
            name: 'mainland',
            type: 'string'
        },
        {
            name: 'introductionDate',
            type: 'date'
        }
    ]
});