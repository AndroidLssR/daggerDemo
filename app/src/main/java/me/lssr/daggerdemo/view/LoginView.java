package me.lssr.daggerdemo.view;

public interface LoginView {
    void showLoading();
    void hideLoading();
    void showError(String msg);
    void LoginSuccess();
}
