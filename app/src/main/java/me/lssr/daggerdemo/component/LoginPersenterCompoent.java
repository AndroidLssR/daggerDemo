package me.lssr.daggerdemo.component;


import javax.inject.Singleton;

import dagger.Component;
import me.lssr.daggerdemo.LoginActivity;
import me.lssr.daggerdemo.Module.LoginPersenterModule;

@PerApp//定义注解范围
@Singleton
@Component(modules = LoginPersenterModule.class)
public interface LoginPersenterCompoent {
    void inject(LoginActivity activity);
}