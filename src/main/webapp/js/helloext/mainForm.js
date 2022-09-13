Ext.application({
    name: 'Сущности',
    launch: function() {
        Ext.create('Ext.tab.Panel', {
          title: 'Сущности',
          renderTo: Ext.getBody(),
          items: [{
            Ext.create('Ext.grid.Panel', {
              title: 'Квесты',
              columns: [{
                header: 'ID',
                dataIndex: 'id'
              }, {
                header: 'Название',
                dataIndex: 'name'
              }, {
                header: 'Тип квеста',
                dataIndex: 'questType'
              }, {
                header: 'Имя нпс',
                dataIndex: 'npc'
              }]
            })
          }, {
           Ext.create('Ext.grid.Panel', {
            title: 'НПС',
            columns: [{
                header: 'ID',
                dataIndex: 'id'
            }, {
                header: 'Имя',
                dataIndex: 'name'
            }, {
                header: 'Элита',
                dataIndex: 'eliteStatus'
            }, {
                header: 'Фракция',
                dataIndex: 'fraction'
            }, {
                header: 'Локация',
                dataIndex: 'location'
            }]
           })
          }, {
            Ext.create('Ext.grid.Panel', {
                title: 'Локации',
                columns: [{
                    header: 'ID',
                    dataIndex: 'id'
                }, {
                    header: 'Название',
                    dataIndex: 'name'
                }, {
                    header: 'Континент',
                    dataIndex: 'mainland'
                }]
            })
          }]
          });
    }
});