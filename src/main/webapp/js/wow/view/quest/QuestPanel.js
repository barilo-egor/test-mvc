Ext.define('wow.view.quest.QuestPanel', {
    xtype: 'questpanel',
    extend: 'Ext.panel.Panel',
    layout: {
        type: 'vbox',
        align: 'center'
    },
    items: [
        {
            xtype: 'textfield',
            fieldLabel: 'ID',
            bind: {
                value: '{quest.id}'
            },
            margin: 10,
            width: 300,
            editable: false,
            inputWrapCls: '',
            triggerWrapCls: '',
            fieldStyle: 'background:none'
        },
        {
            xtype: 'textfield',
            fieldLabel: 'Название',
            bind: {
                value: '{quest.name}'
            },
            margin: 10,
            width: 300,
            editable: false,
            inputWrapCls: '',
            triggerWrapCls: '',
            fieldStyle: 'background:none'
        },
        {
        xtype: 'textfield',
        fieldLabel: 'Тип квеста',
        bind: {
            value: '{quest.questType}'
        },
        margin: 10,
        width: 300,
        editable: false,
        inputWrapCls: '',
        triggerWrapCls: '',
        fieldStyle: 'background:none'
        },
        {
        xtype: 'textfield',
        fieldLabel: 'Имя нпс',
        bind: {
            value: '{quest.npc}'
        },
        margin: 10,
        width: 300,
        editable: false,
        inputWrapCls: '',
        triggerWrapCls: '',
        fieldStyle: 'background:none'
        }
    ]
});