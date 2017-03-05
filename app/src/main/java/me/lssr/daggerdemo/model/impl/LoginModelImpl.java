package me.lssr.daggerdemo.model.impl;


import android.os.Handler;
import android.text.TextUtils;

import me.lssr.daggerdemo.model.LoginModel;

public class LoginModelImpl implements LoginModel {
    @Override
    public void login(final String userName, final String password, final LoginListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (userName.equals("lssRan") && password.equals("123456")) {
                    listener.loginSuccess();
                } else if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)){
                    listener.loginFailed("用户名或密码不能为空");
                } else {
                    listener.loginFailed("用户名密码错误");
                }
            }
        }, 1000);
    }
}