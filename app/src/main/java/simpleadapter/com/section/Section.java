package simpleadapter.com.section;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.Collection;

public class Section {

    protected Context mContext;
    protected boolean enabled = true;
    protected int mViewType;

    public Section(Context context, int viewType) {
        if (viewType < 0) {
            throw new UnsupportedOperationException("View type must be >=0");
        }

        mContext = context;
        mViewType = viewType;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void getItemOffsets(Rect outRect) {
        outRect.set(0, 0, 0, 0);
    }

    public int itemCount() {
        throw new UnsupportedOperationException("You must override this method");
    }

    public int viewType() {
        return getClass().toString().hashCode();
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        throw new UnsupportedOperationException("You must override this method");
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int sectionPosition) {
        throw new UnsupportedOperationException("You must override this method");
    }

    public int positionOf(Object object) {
        return -1;
    }

    protected boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    protected boolean isNotEmpty(Collection collection) {
        return collection != null && !collection.isEmpty();
    }
}
