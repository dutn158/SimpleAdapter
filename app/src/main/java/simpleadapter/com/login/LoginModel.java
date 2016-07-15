package simpleadapter.com.login;

/**
 * Created by chuchuynh on 7/14/16.
 */
public class LoginModel {
    public String username;
    public String password;
    public String token;
    public int errorcode;

    public LoginModel(LoginDto dto) {
        username = dto.username;
        password = dto.password;
        token = dto.token;
        errorcode = dto.errorcode;
    }
}
