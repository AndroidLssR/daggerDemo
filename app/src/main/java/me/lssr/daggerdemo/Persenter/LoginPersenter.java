package me.lssr.daggerdemo.Persenter;


import me.lssr.daggerdemo.model.LoginModel;
import me.lssr.daggerdemo.model.impl.LoginModelImpl;
import me.lssr.daggerdemo.view.LoginView;

public class LoginPersenter {

    private LoginView loginView;
    private LoginModel loginModel;

    public LoginPersenter(LoginView loginView) {
        this.loginModel=new LoginModelImpl();
        this.loginView = loginView;
    }
    public void login(final String userName, final String password){
        loginView.showLoading();

        loginModel.login(userName, password, new LoginModel.LoginListener() {
            @Override
            public void loginSuccess() {
                loginView.hideLoading();
                loginView.LoginSuccess();
            }

            @Override
            public void loginFailed(String msg) {
                loginView.hideLoading();
                loginView.showError(msg);
            }
        });
    }
}