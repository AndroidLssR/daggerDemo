package me.lssr.daggerdemo.Module;


import dagger.Module;
import dagger.Provides;
import me.lssr.daggerdemo.LoginActivity;
import me.lssr.daggerdemo.Persenter.LoginPersenter;
import me.lssr.daggerdemo.component.PerApp;

@Module
public class LoginPersenterModule {
    private LoginActivity loginActivity;

    public LoginPersenterModule(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;
    }
    @PerApp
    @Provides
    LoginActivity provideLoginActivity(){
        return loginActivity;
    }

    @PerApp
    @Provides
    LoginPersenter ProvideLoginPersenter(LoginActivity loginActivity){
        return new LoginPersenter(loginActivity);
    }
}