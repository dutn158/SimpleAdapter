package simpleadapter.com;

import android.app.Activity;
import android.app.Application;

import java.util.Arrays;
import java.util.List;


import dagger.ObjectGraph;

import simpleadapter.com.dagger.AndroidModule;
import simpleadapter.com.dagger.ApplicationModule;
import simpleadapter.com.dagger.Injector;

public class App extends Application {

    private static App sInstance;

    public static App getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        Injector.INSTANCE.setObjectGraph(ObjectGraph.create(getModules().toArray()));
        Injector.INSTANCE.inject(this);
    }

    protected List<Object> getModules() {
        return Arrays.asList(
                new AndroidModule(this),
                new ApplicationModule(this)
        );
    }
}
