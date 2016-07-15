package simpleadapter.com.login;

import android.text.TextUtils;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;
import simpleadapter.com.dagger.Injector;

/**
 * Created by chuchuynh on 7/14/16.
 */
public class LoginPresenterImpl implements LoginPresenter {

    private final CompositeSubscription mSubscription = new CompositeSubscription();

    protected CompositeSubscription getSubscription() {
        return mSubscription;
    }

    protected void clearSubscription() {
        mSubscription.clear();
    }

    private LoginView mView;
    private LoginRouter mRouter;

    @Inject
    Repository mRepository;

    public LoginPresenterImpl(LoginView view, LoginRouter router) {
        mView = view;
        mRouter = router;
        Injector.INSTANCE.inject(this);
    }
    @Override
    public void onLoginButtonClick(String userName, String passWord) {
        if (!isInputAll(userName, passWord)) {
            mView.showErrorMessage("Please input all data!");
            return;
        }

        if (!isNetworkOK()) {
            return;
        }

        // Login
        getSubscription()
                .add(mRepository.login(userName, passWord)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<LoginModel>() {
                    @Override
                    public void call(LoginModel loginModel) {
                        mView.dismissProgressDialog();
                        if (loginModel.errorcode == 0) {
                            mRouter.openMainScreen();
                            // Some other logic such as: save username and password to Section... TODO
                        } else {
                            mView.showErrorMessage("Login failure!");
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        // Error here
                        mView.dismissProgressDialog();
                        mView.showErrorMessage("Login failure!");
                    }
                }));
    }

    @Override
    public boolean isInputAll(String userName, String passWord) {
        return !TextUtils.isEmpty(userName) && !TextUtils.isEmpty(passWord);
    }

    @Override
    public boolean isNetworkOK() {
        // TODO: in fact you must implement it to check the network state
        return true;
    }

    @Override
    public boolean hasErrorInResponse() {
        return false;
    }
}
