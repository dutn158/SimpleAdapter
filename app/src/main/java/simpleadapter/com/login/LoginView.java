package simpleadapter.com.login;

import simpleadapter.com.base.view.LoadingView;

/**
 * Created by huyletran84@gmail.com on 7/14/16.
 */
public interface LoginView extends LoadingView {
    void showErrorMessage(String message);
    void showSuccessMessage();
}
