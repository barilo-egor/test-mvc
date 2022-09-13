Ext.define('wow.view.location.ViewLocationWindow', {
    extend: 'Ext.window.Window',
    height: 400,
    width: 500,
    layout: 'fit',
    modal: 'true',
    requires: ['wow.view.location.LocationPanel'],
    items: [
        {
            xtype: 'locationpanel',
            viewModel: {
                data: {
                    bind: {
                        location: '{location}'
                    }
                }
            }
        }
    ]
});