
Ext.application({
    name: 'Форма для редактирования/добавления локации',
    launch: function() {
        var viewport = Ext.create('Ext.container.Viewport', {
            layout: 'border',
            renderTo: Ext.getBody(),
        })
        var form = Ext.create('Ext.form.Panel', {
            title: 'Форма для редактирования/добавления локации',
            region: 'center',
            cls: 'mainField-margin',
            layout: {
                type: 'vbox',
                align: 'center'
            },
            items: [{
                        xtype: 'textfield',
                        fieldLabel: 'id',
                        name: 'id',
                        labelAlign: 'top',
                        width: 150,
                        height: 30,
                        cls: 'field-margin',
                      },{
                        xtype: 'textfield',
                        fieldLabel: 'Название',
                        name: 'name',
                        labelAlign: 'top',
                        width: 150,
                        height: 30,
                        cls: 'field-margin',
                      },{
                        xtype: 'textfield',
                        fieldLabel: 'Континент',
                        name: 'mainland',
                        labelAlign: 'top',
                        width: 150,
                        height: 30,
                        cls: 'field-margin',
                      }],
                      buttons: [{
                        text: 'Оправить',
                        handler: function() {
                            // действие отправки
                        }
                      }, {
                        text: 'Отмена',
                        handler: function() {
                            // действие отмены
                            }
                      }]
          });
          viewport.add(form);
    }
});