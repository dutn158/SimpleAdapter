package simpleadapter.com.base.net;

import android.util.Log;

import rx.Observable;
import simpleadapter.com.login.LoginDto;

/**
 * Created by huyletran84@gmail.com on 7/15/16.
 */
public interface ApiRequester {
    Observable<LoginDto> login(String username, String password);
}
