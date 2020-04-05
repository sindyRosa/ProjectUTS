package com.example.projectuts;

import com.example.projectuts.models.Account;
import com.example.projectuts.models.session;

public class Application extends android.app.Application {
    private static session session;
    private static Account account;

    @Override
    public void onCreate()
    {
        super.onCreate();
        account = new Account("Sindy Rosa");
        session = new session(this);
    }

    public static Account getAccount() {
        return account;
    }
    public static session getSession() {
        return session;
    }
}
