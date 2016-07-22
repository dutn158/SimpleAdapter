package simpleadapter.com.base.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by chuchuynh on 6/25/16.
 */
public abstract class BaseSimpleViewHolder<TItem> extends RecyclerView.ViewHolder {

    protected Context mContext;

    public BaseSimpleViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(itemView);
    }

    public void bind(TItem item) {
        throw new UnsupportedOperationException("You must override this method: " + this.getClass().toString());
    }
}
