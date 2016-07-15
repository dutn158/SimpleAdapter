package simpleadapter.com.dagger;


import dagger.ObjectGraph;

/**
 * Created by bernard on 6/24/14.
 */
public enum Injector {
    INSTANCE;

    private ObjectGraph mObjectGraph;

    public void setObjectGraph(ObjectGraph objectGraph) {
        mObjectGraph = objectGraph;
    }

    public ObjectGraph getObjectGraph() {
        return mObjectGraph;
    }

    public void inject(Object object) {
        mObjectGraph.inject(object);
    }
}
