Ext.define('wow.view.location.LocationPanel', {
    xtype: 'locationpanel',
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
                value: '{location.id}'
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
                value: '{location.name}'
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
        fieldLabel: 'Континент',
        bind: {
            value: '{location.mainland}'
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
        fieldLabel: 'Дата введения',
        bind: {
            value: '{location.introductionDate}'
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