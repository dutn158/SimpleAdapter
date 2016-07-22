package simpleadapter.com.login;

import simpleadapter.com.base.presenter.Presenter;
import simpleadapter.com.base.scope.PerActivity;

/**
 * Created by huyletran84@gmail.com on 7/14/16.
 */
@PerActivity
public interface LoginPresenter extends Presenter<LoginView, LoginRouter> {
    void onLoginButtonClick(String userName, String password);
}
