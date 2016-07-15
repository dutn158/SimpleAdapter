package simpleadapter.com.dagger;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by bernard on 4/28/14.
 */
@Module(library = true)
public class AndroidModule {
    private Application mApplication;

    public AndroidModule(Application application) {
        mApplication = application;
    }

    @Provides @Singleton @ForApplication
    Context provideApplicationContext() {
        return mApplication;
    }
}
