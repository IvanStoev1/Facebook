package com.vso.controller.deleteaccount;

import com.vso.model.entity.User;
import com.vso.model.service.deleteaccount.DeleteAccountImpl;
import com.vso.view.SystemMsgsView;

public class DeleteAccountController {

    private final DeleteAccountImpl deleteAccount = new DeleteAccountImpl();
    private final SystemMsgsView systemMsgsView = new SystemMsgsView();

    public DeleteAccountController() {

    }

    public void setDeleteAccount(User user){
        deleteAccount.deleteAccount(user);
        systemMsgsView.showAccountDeleted();
    }
}
