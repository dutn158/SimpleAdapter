package simpleadapter.com.section;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import simpleadapter.com.R;

/**
 * Created by chuchuynh on 6/30/16.
 */
public class LoadingSection extends SingleItemSection {
    public LoadingSection(Context context, int viewType) {
        super(context, viewType);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.loading_view, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new RecyclerView.ViewHolder(view) {
        };
    }
}
