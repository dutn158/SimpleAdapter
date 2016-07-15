package simpleadapter.com.login;

/**
 * Created by chuchuynh on 7/14/16.
 */
public interface LoginPresenter {
    void onLoginButtonClick(String userName, String password);
    boolean isInputAll(String userName, String passWord);
    boolean isNetworkOK();
    boolean hasErrorInResponse();
}
