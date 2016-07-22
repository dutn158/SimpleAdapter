package simpleadapter.com.base.module;

import android.app.Activity;
import android.support.v4.app.ActivityCompat;

import dagger.Module;
import dagger.Provides;
import simpleadapter.com.base.scope.PerActivity;

@Module
public class ActivityModule {
    private final ActivityCompat activity;

    public ActivityModule(ActivityCompat activity) {
        this.activity = activity;
    }

    /**
     * Expose the activity to dependents in the graph.
     */
    @Provides @PerActivity ActivityCompat activity() {
        return this.activity;
    }
}
