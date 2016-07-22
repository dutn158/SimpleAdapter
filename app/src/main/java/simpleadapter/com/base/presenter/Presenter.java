package simpleadapter.com.base.presenter;

/**
 * Created by huyletran84@gmail.com on 7/22/16.
 */
public interface Presenter<TView, TRouter> {
    void setViewAndRouter(TView view, TRouter router);
}
