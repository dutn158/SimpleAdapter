package simpleadapter.com.login;

import rx.Observable;

/**
 * Created by huyletran84@gmail.com on 7/14/16.
 */
public interface LoginRepository {
    Observable<LoginModel> login(String userName, String password);
}
