package simpleadapter.com.login;

import rx.Observable;

/**
 * Created by chuchuynh on 7/14/16.
 */
public interface Repository {
    Observable<LoginModel> login(String userName, String password);
}
