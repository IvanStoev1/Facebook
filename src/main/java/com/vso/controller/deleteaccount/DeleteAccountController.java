package com.vso.controller.deleteaccount;

import com.vso.model.entity.User;
import com.vso.model.service.DeleteAccount;
import com.vso.view.SystemMsgsView;

public class DeleteAccountController {

    private final DeleteAccount deleteAccount = new DeleteAccount();
    private final SystemMsgsView systemMsgsView = new SystemMsgsView();

    public DeleteAccountController() {
    }

    public void setDeleteAccount(User user){
        deleteAccount.deleteAccount(user);
        systemMsgsView.showAccountDeleted();

    }
}
