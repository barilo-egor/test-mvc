Ext.define('wow.view.npc.NpcForm', {
    extend: 'Ext.form.Panel',
    xtype: 'npcform',
    id: 'npcform',
    requires: ['wow.view.npc.NpcFormController'],
    controller: 'npcFormController',
    url: 'npc/create.form',
    layout: {
        type: 'vbox',
        align: 'center'
    },
    items:[
        {
            xtype: 'textfield',
            name: 'id',
            id: 'npcidtextfield',
            hidden: true,
            bind: {
                value: '{npc.id}'
            }
        },
        {
            xtype: 'textfield',
            name: 'name',
            fieldLabel: 'Имя',
            id: 'npcnametextfield',
            labelAlign: 'top',
            width: 250,
            bind: {
                value: '{npc.name}'
            }
        },
        {
            xtype: 'combobox',
            name: 'eliteStatus',
            fieldLabel: 'Элита',
            id: 'elitestatuscombobox',
            labelAlign: 'top',
            valueField:'value',
            displayField:'displayName',
            queryMode:'remote',
            editable: false,
            width: 250,
            value: true,
            bind: {
                value: '{npc.eliteStatus}'
            },
            store: {
                fields: ['value', 'displayName'],
                data: [
                    {
                        value: true,
                        displayName: 'Да'
                    },
                    {
                        value: false,
                        displayName: 'Нет'
                    }
                ],
            }
        },
        {
            xtype: 'combobox',
            name: 'fraction',
            fieldLabel: 'Фракция',
            id: 'fractioncombobox',
            labelAlign: 'top',
            valueField:'name',
            displayField:'displayName',
            queryMode:'remote',
            editable: false,
            width: 250,
            store: {
                fields: ['name', 'displayName'],
                autoLoad: {
                    scope: this,
                    callback: function() {
                        let comboBox = Ext.getCmp("fractioncombobox");
                        let store = comboBox.store;
                        if(comboBox.up('window').getViewModel()) {
                        let npc = comboBox.up('window').getViewModel().getData().npc;
                            for ( let i = 0; i < store.getRange().length; i++) {
                                if(store.getRange()[i].data.displayName === npc.fraction) {
                                    comboBox.setValue(store.getRange()[i]);
                                }
                            }
                        } else comboBox.setValue(store.first());
                    }
                },
                proxy: {
                    type: 'ajax',
                    url: 'npc/fractions.form',
                    reader: {
                        type: 'json'
                    }
                }
            }
        },
        {
            xtype: 'combobox',
            name: 'locationId',
            fieldLabel: 'Локация',
            id: 'locationcombobox',
            labelAlign: 'top',
            valueField:'id',
            displayField:'name',
            queryMode:'remote',
            editable: false,
            width: 250,
            store: {
                fields: ['id', 'name'],
                autoLoad: {
                    scope: this,
                    callback: function() {
                        let comboBox = Ext.getCmp("locationcombobox");
                        let store = comboBox.store;
                        if(comboBox.up('window').getViewModel()) {
                        let npc = comboBox.up('window').getViewModel().getData().npc;
                                for ( let i = 0; i < store.getRange().length; i++) {
                                    if(store.getRange()[i].data.name === npc.location) {
                                        comboBox.setValue(store.getRange()[i]);
                                    }
                                }
                            } else comboBox.setValue(store.first());
                    }
                },
                proxy: {
                    type: 'ajax',
                    url: 'npc/locations.form',
                    reader: {
                        type: 'json'
                    }
                }
            }
        }
    ],
    buttons: [
        {
            text: 'Сохранить',
            handler: 'onSaveClick'
        },
        {
            text: 'Отмена',
            handler: 'onCancelClick'
        }
    ]
});