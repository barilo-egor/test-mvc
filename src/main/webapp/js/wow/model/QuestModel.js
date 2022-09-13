Ext.define('wow.model.QuestModel', {
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
            name: 'questType',
            type: 'string'
        },
        {
            name: 'npc',
            type: 'string'
        }
    ]
});