package simpleadapter.com.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import simpleadapter.com.base.HasComponent;

/**
 * Created by huyletran84@gmail.com on 7/22/16.
 */
public abstract class BaseActivity extends AppCompatActivity {
//    /**
//     * Gets a component for dependency injection by its type.
//     */
//    @SuppressWarnings("unchecked")
//    protected <C> C getComponent(Class<C> componentType) {
//        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
//    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeInjector();
    }

    protected void initializeInjector() {
        // Implement at sub class if needed
    }
}
