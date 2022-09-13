Ext.define('wow.view.quest.QuestFormController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.questFormController',
    onSaveClick: function(button) {
        let win = button.up('window');
        let form = button.up('form');
        let values = form.getValues();
        if(values.name.trim().length == 0) {
            Ext.toast('Поле названия не заполнено.')
            return
        }
        form.submit({
            success: function(form, action) {
                let result = Ext.decode(action.response.responseText)
                Ext.getStore('queststore').add(result.result)
                win.close();
            },
            failure: function(form, action) {
                            console.log()
                            win.close();
                        }
        });
    },
    onCancelClick: function(button) {
        button.up('window').close();
    }
});