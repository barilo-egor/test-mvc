Ext.define('wow.view.quest.QuestForm', {
    extend: 'Ext.form.Panel',
    xtype: 'questform',
    id: 'questform',
    requires: ['wow.view.quest.QuestFormController'],
    controller: 'questFormController',
    url: 'quest/create.form',
    layout: {
        type: 'vbox',
        align: 'center'
    },
    items:[
        {
            xtype: 'textfield',
            name: 'id',
            id: 'questidtextfield',
            hidden: true,
            bind: {
                value: '{quest.id}'
            }
        },
        {
            xtype: 'textfield',
            name: 'name',
            fieldLabel: 'Название',
            id: 'questnametextfield',
            labelAlign: 'top',
            width: 250,
            bind: {
                value: '{quest.name}'
            }
        },
        {
            xtype: 'combobox',
            name: 'questType',
            fieldLabel: 'Тип квеста',
            id: 'questtypecombobox',
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
                        let comboBox = Ext.getCmp("questtypecombobox");
                        let store = comboBox.store;
                        if(comboBox.up('window').getViewModel()) {
                        let quest = comboBox.up('window').getViewModel().getData().quest;
                            for (let i = 0; i < store.getRange().length; i++) {
                                if(store.getRange()[i].data.displayName === quest.questType) {
                                    comboBox.setValue(store.getRange()[i]);
                                }
                            }
                        } else comboBox.setValue(store.first());
                    }
                },
                proxy: {
                    type: 'ajax',
                    url: 'quest/questTypes.form',
                    reader: {
                        type: 'json'
                    }
                }
            }
        },
        {
            xtype: 'combobox',
            name: 'npcId',
            fieldLabel: 'Имя нпс',
            id: 'npccombobox',
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
                        let comboBox = Ext.getCmp("npccombobox");
                        let store = comboBox.store;
                        if(comboBox.up('window').getViewModel()) {
                        let quest = comboBox.up('window').getViewModel().getData().quest;
                                for ( let i = 0; i < store.getRange().length; i++) {
                                    if(store.getRange()[i].data.name === quest.npc) {
                                        comboBox.setValue(store.getRange()[i]);
                                    }
                                }
                            } else comboBox.setValue(store.first());
                    }
                },
                proxy: {
                    type: 'ajax',
                    url: 'quest/npc.form',
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