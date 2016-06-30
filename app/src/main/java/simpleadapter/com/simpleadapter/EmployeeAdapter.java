package simpleadapter.com.simpleadapter;

import android.content.Context;
import android.view.View;

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
