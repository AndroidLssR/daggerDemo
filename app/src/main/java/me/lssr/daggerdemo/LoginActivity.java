package me.lssr.daggerdemo;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import me.lssr.daggerdemo.Module.LoginPersenterModule;
import me.lssr.daggerdemo.Persenter.LoginPersenter;
import me.lssr.daggerdemo.component.DaggerLoginPersenterCompoent;
import me.lssr.daggerdemo.component.LoginPersenterCompoent;
import me.lssr.daggerdemo.view.LoginView;

import static android.R.attr.password;

public class LoginActivity extends AppCompatActivity implements LoginView {

    @Inject
    LoginPersenter loginPersenter;

    private LoginPersenterCompoent loginPersenterCompoent;

    ProgressDialog progressDialog;
    private TextInputLayout layoutAccount,layoutPassword;
    private EditText userName,passWord;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        layoutAccount = (TextInputLayout) findViewById(R.id.layout_account);
        layoutPassword = (TextInputLayout) findViewById(R.id.layout_password);

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPersenter.login(userName.getText().toString().trim(),passWord.getText().toString().trim());
            }
        });

        layoutAccount.setHint("UserName");
        layoutPassword.setHint("PassWord");

        userName = layoutAccount.getEditText();
        passWord = layoutPassword.getEditText();

        DaggerLoginPersenterCompoent.builder().
                loginPersenterModule(new LoginPersenterModule(this)).build().inject(this);
    }

    @Override
    public void showLoading() {
        progressDialog= ProgressDialog.show(LoginActivity.this,"正在登录","正在登录请稍后……",true,false);
    }

    @Override
    public void hideLoading() {
        progressDialog.dismiss();
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void LoginSuccess() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
    }
}
