package simpleadapter.com.sectionadapter.section;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

public class SingleItemSection extends Section {

    public SingleItemSection(Context context, int viewType) {
        super(context, viewType);
    }

    @Override
    public int itemCount() {
        return isEnabled() ? 1 : 0;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int sectionPosition) {
        // Maybe not need
    }
}