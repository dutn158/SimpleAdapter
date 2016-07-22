package simpleadapter.com.sectionadapter.section;

import android.content.Context;

import java.util.List;

public abstract class ManyItemSection<IItem> extends Section {
    protected List<IItem> mItems;

    public ManyItemSection(Context context, int viewType, List<IItem> items) {
        super(context, viewType);
        mItems = items;
    }

    public ManyItemSection(Context context, int viewType) {
        super(context, viewType);
    }


    @Override
    public int itemCount() {
        return isNotEmpty(mItems) ? mItems.size() : 0;
    }

    public void setItems(List items) {
        if (isNotEmpty(mItems)) {
            mItems.clear();
            mItems = null;
        }
        mItems = items;
    }

    @Override
    public int positionOf(Object object) {
        int size = mItems.size();
        for (int i = 0; i < size; i++) {
            if (mItems.get(i).equals(object)) {
                return i;
            }
        }
        return super.positionOf(object);
    }
}
