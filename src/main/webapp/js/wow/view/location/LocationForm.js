Ext.define('wow.view.location.LocationForm', {
    extend: 'Ext.form.Panel',
    xtype: 'locationform',
    id: 'locationform',
    requires: ['wow.view.location.LocationFormController'],
    controller: 'locationFormController',
    url: 'location/create.form',
    layout: {
        type: 'vbox',
        align: 'center'
    },
    items:[
        {
            xtype: 'textfield',
            name: 'id',
            id: 'locationidtextfield',
            hidden: true,
            bind: {
                value: '{location.id}'
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
                value: '{location.name}'
            }
        },
        {
            xtype: 'combobox',
            name: 'mainland',
            fieldLabel: 'Континент',
            id: 'mainlandcombobox',
            valueField:'name',
            displayField:'displayName',
            queryMode:'remote',
            editable: false,
            store: {
                fields: ['name', 'displayName'],
                autoLoad: {
                    scope: this,
                    callback: function() {
                        var comboBox = Ext.getCmp("mainlandcombobox");
                        var store = comboBox.store;
                        var location = comboBox.up('window').getViewModel().getData().location;
                        if(location) {
                            for ( let i = 0; i < store.getRange().length; i++) {
                                if(store.getRange()[i].data.displayName === location.mainland) {
                                    comboBox.setValue(store.getRange()[i]);
                                }
                            }
                        } else comboBox.setValue(store.first());
                    }
                },
                proxy: {
                    type: 'ajax',
                    url: 'location/mainlands.form',
                    reader: {
                        type: 'json'
                    }
                }
            }
        },
        {
            xtype: 'datefield',
            name: 'introductionDate',
            fieldLabel: 'Дата введения',
            id: 'locationdatefield',
            labelAlign: 'top',
            bind: {
                value: '{location.introductionDate}'
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