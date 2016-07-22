package simpleadapter.com.login;

import rx.Observable;

/**
 * Created by huyletran84@gmail.com on 7/15/16.
 */
public interface LoginApiRequester {
    Observable<LoginDto> login(String username, String password);
}
