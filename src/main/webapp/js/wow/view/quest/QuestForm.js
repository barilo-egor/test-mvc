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
            valueField:'name',
            displayField:'displayName',
            queryMode:'remote',
            editable: false,
            store: {
                fields: ['name', 'displayName'],
                autoLoad: {
                    scope: this,
                    callback: function() {
                        var comboBox = Ext.getCmp("questtypecombobox");
                        var store = comboBox.store;
                        var quest = comboBox.up('window').getViewModel().getData().quest;
                        if(quest) {
                            for ( let i = 0; i < store.getRange().length; i++) {
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
            valueField:'id',
            displayField:'name',
            queryMode:'remote',
            editable: false,
            store: {
                fields: ['id', 'name'],
                autoLoad: {
                    scope: this,
                    callback: function() {
                        var comboBox = Ext.getCmp("npccombobox");
                        var store = comboBox.store;
                        var quest = comboBox.up('window').getViewModel().getData().quest;
                            if(quest) {
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