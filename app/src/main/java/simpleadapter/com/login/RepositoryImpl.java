package simpleadapter.com.login;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;
import simpleadapter.com.dagger.Injector;

/**
 * Created by chuchuynh on 7/14/16.
 */
public class RepositoryImpl implements Repository {

    @Inject
    ApiRequester mApiRequester;

    public RepositoryImpl() {
        Injector.INSTANCE.inject(this);
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
