package simpleadapter.com.login;

import rx.Observable;
import simpleadapter.com.dagger.Injector;

/**
 * Created by chuchuynh on 7/15/16.
 */
public class ApiRequesterImpl implements ApiRequester {

    public ApiRequesterImpl() {
        Injector.INSTANCE.inject(this);
    }

    @Override
    public Observable<LoginDto> login(String username, String password) {
        // In fact you must request to server. I give some sample response only


        LoginDto dto = new LoginDto();
        // Case 1
        dto.username = username;
        dto.password = password;
        dto.deviceid = "htc";
        dto.token = "adsfasdfasdfasdfasfs";
        dto.errorcode = 0; // Success
        return Observable.just(dto);
    }
}
