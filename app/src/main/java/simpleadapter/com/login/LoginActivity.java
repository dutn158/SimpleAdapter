package simpleadapter.com.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import simpleadapter.com.AndroidApplication;
import simpleadapter.com.R;
import simpleadapter.com.activity.MainActivity;
import simpleadapter.com.base.activity.BaseActivity;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.username_edt) EditText userName;
    @BindView(R.id.password_edt) EditText password;

    @Inject LoginPresenterImpl mPresenter;

    private LoginComponent mComponent;

    private LoginView mView = new LoginView() {
        @Override
        public void showErrorMessage(String message) {
            Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void showSuccessMessage() {
            Toast.makeText(LoginActivity.this, "Login success!", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void showLoadingView() {

        }

        @Override
        public void dismissLoadingView() {

        }
    };

    private LoginRouter mRouter = new LoginRouter() {
        @Override
        public void openMainScreen() {
            Intent intent  = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        // Init presenter with View and Router.
        mComponent.inject(this);
        mPresenter.setViewAndRouter(mView, mRouter);
    }

    @OnClick(R.id.login_btn)
    void onClickLogin() {
        // Login
        mPresenter.onLoginButtonClick(userName.getText().toString(),
                password.getText().toString());
    }

    @Override
    protected void initializeInjector() {
        super.initializeInjector();
        mComponent = DaggerLoginComponent.builder()
                .applicationComponent(((AndroidApplication)getApplication()).getApplicationComponent())
                .loginModule(new LoginModule())
                .build();
    }
}