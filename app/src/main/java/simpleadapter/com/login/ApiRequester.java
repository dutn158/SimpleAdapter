package simpleadapter.com.login;

import android.util.Log;

import rx.Observable;

/**
 * Created by chuchuynh on 7/15/16.
 */
public interface ApiRequester {
    Observable<LoginDto> login(String username, String password);
}
