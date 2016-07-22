package simpleadapter.com.login;

import com.fernandocejas.frodo.annotation.RxLogSubscriber;

import javax.inject.Inject;

import simpleadapter.com.base.interactor.DefaultSubscriber;
import simpleadapter.com.base.interactor.UseCase;
import simpleadapter.com.base.scope.PerActivity;

/**
 * Created by huyletran84@gmail.com on 7/14/16.
 */
@PerActivity
public class LoginPresenterImpl implements LoginPresenter {

    private UseCase mLoginCase;
    private LoginView mView;
    private LoginRouter mRouter;

    @Inject
    public LoginPresenterImpl(UseCase loginCase) {
        this.mLoginCase = loginCase;
    }

    @Override
    public void setViewAndRouter(LoginView loginView, LoginRouter router) {
        mView = loginView;
        mRouter = router;
    }

    @Override
    public void onLoginButtonClick(String userName, String passWord) {
        mLoginCase.execute(new LoginSubscriber());
    }

    @RxLogSubscriber
    private final class LoginSubscriber extends DefaultSubscriber<LoginModel> {

        @Override public void onCompleted() {
            LoginPresenterImpl.this.mView.dismissLoadingView();
        }

        @Override public void onError(Throwable e) {
            LoginPresenterImpl.this.mView.dismissLoadingView();
            LoginPresenterImpl.this.mView.showErrorMessage("There is error when logging in.");
        }

        @Override public void onNext(LoginModel loginModel) {
            LoginPresenterImpl.this.mRouter.openMainScreen();
        }
    }
}
