package simpleadapter.com.simpleadapter.viewholder;

import android.view.View;
import android.widget.TextView;

import simpleadapter.com.base.adapter.BaseSimpleViewHolder;
import simpleadapter.com.model.EmployeeModel;
import simpleadapter.com.R;

/**
 * Created by chuchuynh on 6/25/16.
 */
public class EmployeeViewHolder extends BaseSimpleViewHolder<EmployeeModel> {
    TextView mNameTv;
    TextView mJobTv;

    public EmployeeViewHolder(View itemView) {
        super(itemView);
        mNameTv = (TextView) itemView.findViewById(R.id.name);
        mJobTv = (TextView) itemView.findViewById(R.id.job);
    }

    @Override
    public void bind(EmployeeModel employeeModel) {
        mNameTv.setText(employeeModel.name);
        mJobTv.setText(employeeModel.job);
    }
}
