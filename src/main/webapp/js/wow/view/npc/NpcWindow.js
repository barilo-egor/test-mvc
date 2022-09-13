Ext.define('wow.view.npc.NpcWindow', {
    extend: 'Ext.window.Window',
    id: 'npcwindow',
    height: 400,
    width: 300,
    layout: 'fit',
    modal: 'true',
    requires: ['wow.view.npc.NpcForm'],
    items: [
        {
            xtype: 'npcform',
            viewModel: {
                data: {
                    bind: {
                        npc: '{npc}',
                    }
                }
            }
        }
    ]
});