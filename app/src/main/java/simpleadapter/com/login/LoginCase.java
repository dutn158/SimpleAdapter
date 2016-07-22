package simpleadapter.com.login;

import javax.inject.Inject;

import rx.Observable;
import simpleadapter.com.base.interactor.UseCase;
import simpleadapter.com.base.thread.PostExecutionThread;
import simpleadapter.com.base.thread.ThreadExecutor;

/**
 * Created by huyletran84@gmail.com on 7/22/16.
 */
public class LoginCase extends UseCase {
    private LoginRepository mRepository;
    private String mUserName;
    private String mPassword;

    @Inject
    protected LoginCase(LoginRepository loginRepository,
                        ThreadExecutor threadExecutor,
                        PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        mRepository = loginRepository;
    }

    public void setUserNameAndPass(String userName, String password) {
        mUserName = userName;
        mPassword = password;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return mRepository.login(mUserName, mPassword);
    }
}
