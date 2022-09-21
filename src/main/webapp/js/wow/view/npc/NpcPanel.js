Ext.define('wow.view.npc.NpcPanel', {
    xtype: 'npcpanel',
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
                value: '{npc.id}'
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
            fieldLabel: 'Имя',
            bind: {
                value: '{npc.name}'
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
            fieldLabel: 'Элита',
            bind: {
                value: '{npc.eliteStatus}'
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
            fieldLabel: 'Фракция',
            bind: {
                value: '{npc.fraction}'
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
            fieldLabel: 'Локация',
            bind: {
                value: '{npc.location}'
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