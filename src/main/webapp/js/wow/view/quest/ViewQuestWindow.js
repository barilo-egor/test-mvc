Ext.define('wow.view.quest.ViewQuestWindow', {
    extend: 'Ext.window.Window',
    height: 400,
    width: 500,
    layout: 'fit',
    modal: 'true',
    requires: ['wow.view.quest.QuestPanel'],
    items: [
        {
            xtype: 'questpanel',
            viewModel: {
                data: {
                    bind: {
                        quest: '{quest}'
                    }
                }
            }
        }
    ]
});