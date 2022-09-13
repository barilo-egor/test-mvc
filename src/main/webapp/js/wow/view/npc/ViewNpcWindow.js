Ext.define('wow.view.npc.ViewNpcWindow', {
    extend: 'Ext.window.Window',
    height: 400,
    width: 500,
    layout: 'fit',
    modal: 'true',
    requires: ['wow.view.npc.NpcPanel'],
    items: [
        {
            xtype: 'npcpanel',
            viewModel: {
                data: {
                    bind: {
                        npc: '{npc}'
                    }
                }
            }
        }
    ]
});