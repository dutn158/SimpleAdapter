package simpleadapter.com.simpleadapter;

import android.content.Context;
import android.view.View;
import simpleadapter.com.R;
import simpleadapter.com.base.adapter.BaseSimpleAdapter;
import simpleadapter.com.model.EmployeeModel;
import simpleadapter.com.simpleadapter.viewholder.EmployeeViewHolder;

/**
 * Created by chuchuynh on 6/29/16.
 */
public class EmployeeAdapter extends BaseSimpleAdapter<EmployeeModel, EmployeeViewHolder> {
    public EmployeeAdapter(Context context) {
        super(context);
    }

    @Override
    public EmployeeViewHolder createHolder(View view) {
        return new EmployeeViewHolder(view);
    }

    @Override
    public int getItemLayoutResource() {
        return R.layout.employee_item;
    }
}
