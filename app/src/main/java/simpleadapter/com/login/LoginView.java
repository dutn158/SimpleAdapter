package simpleadapter.com.login;

/**
 * Created by chuchuynh on 7/14/16.
 */
public interface LoginView {
    void showErrorMessage(String message);
    void showSuccessMessage();
    void showProgressDialog();
    void dismissProgressDialog();
}
