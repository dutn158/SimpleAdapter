package simpleadapter.com.dagger;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import simpleadapter.com.App;
import simpleadapter.com.login.ApiRequester;
import simpleadapter.com.login.ApiRequesterImpl;
import simpleadapter.com.login.LoginActivity;
import simpleadapter.com.login.LoginPresenterImpl;
import simpleadapter.com.login.Repository;
import simpleadapter.com.login.RepositoryImpl;

@Module(
        injects = {
                App.class,
                LoginActivity.class,
                RepositoryImpl.class,
                LoginPresenterImpl.class,
                ApiRequesterImpl.class,
        },

        complete = false, library = true
)

public class ApplicationModule {
    private Context mContext;
    public ApplicationModule(Context context) {
        mContext = context;
    }

    @Provides
    @Singleton
    Repository provideRepository() {
        return new RepositoryImpl();
    }

    @Provides
    @Singleton
    ApiRequester provideApiRequester() {
        return new ApiRequesterImpl();
    }
}
