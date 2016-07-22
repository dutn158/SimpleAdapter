package simpleadapter.com.base.module;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import simpleadapter.com.AndroidApplication;
import simpleadapter.com.base.net.ApiRequester;
import simpleadapter.com.base.net.ApiRequesterImpl;
import simpleadapter.com.base.thread.PostExecutionThread;
import simpleadapter.com.base.thread.ThreadExecutor;
import simpleadapter.com.base.thread.UIThread;
import simpleadapter.com.base.executor.JobExecutor;

@Module
public class ApplicationModule {

    private final AndroidApplication application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides @Singleton Context provideApplicationContext() {
        return this.application;
    }

    @Provides @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides
    @Singleton
    ApiRequester provideApiRequester() {
        return new ApiRequesterImpl();
    }

    @Provides
    @Singleton
    SharedPreferences provideSharePreference() {
        // TODO
        return null;
    }
}
