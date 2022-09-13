Ext.define('wow.view.location.LocationWindow', {
    extend: 'Ext.window.Window',
    id: 'locationwindow',
    height: 400,
    width: 300,
    layout: 'fit',
    modal: 'true',
    requires: ['wow.view.location.LocationForm'],
    items: [
        {
            xtype: 'locationform',
            viewModel: {
                data: {
                    bind: {
                        location: '{location}',
                    }
                }
            }
        }
    ]
});