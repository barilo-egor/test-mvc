Ext.define('wow.view.Viewport', {
    extend: 'Ext.container.Viewport',
    layout: 'fit',
    requires: ['wow.view.MainTabPanel'],
    items: [
        {
            xtype: 'mainpanel'
        }
    ]
});