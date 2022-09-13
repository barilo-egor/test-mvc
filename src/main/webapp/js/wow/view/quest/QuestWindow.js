Ext.define('wow.view.quest.QuestWindow', {
    extend: 'Ext.window.Window',
    id: 'questwindow',
    height: 400,
    width: 300,
    layout: 'fit',
    modal: 'true',
    requires: ['wow.view.quest.QuestForm'],
    items: [
        {
            xtype: 'questform',
            viewModel: {
                data: {
                    bind: {
                        quest: '{quest}',
                    }
                }
            },
//            bind: {
//                url: '{url}'
//            }
        }
    ]
});

