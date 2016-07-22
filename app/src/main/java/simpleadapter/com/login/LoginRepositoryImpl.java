package simpleadapter.com.login;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;
import simpleadapter.com.base.scope.PerActivity;

/**
 * Created by huyletran84@gmail.com on 7/14/16.
 */
@PerActivity
public class LoginRepositoryImpl implements LoginRepository {

    LoginApiRequester mApiRequester;

    public LoginRepositoryImpl(LoginApiRequester requester) {
        this.mApiRequester = requester;
    }

    @Override
    public Observable<LoginModel> login(String userName, String password) {
        return mApiRequester.login(userName, password)
                .map(new Func1<LoginDto, LoginModel>() {
            @Override
            public LoginModel call(LoginDto loginDto) {
                return new LoginModel(loginDto);
            }
        });
    }
}
