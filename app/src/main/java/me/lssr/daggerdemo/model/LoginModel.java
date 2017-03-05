package me.lssr.daggerdemo.model;

public interface LoginModel {
    void login(String userName, String password,LoginListener listener);

    interface LoginListener {
        void loginSuccess();
        void loginFailed(String msg);
    }
}