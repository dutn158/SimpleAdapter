package simpleadapter.com.sectionadapter.section;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import simpleadapter.com.R;

/**
 * Created by chuchuynh on 6/30/16.
 */
public class SampleTitleSection extends SingleItemSection {
    public SampleTitleSection(Context context, int viewType) {
        super(context, viewType);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.simple_title_view, null);
        return new RecyclerView.ViewHolder(view) {
        };
    }
}
