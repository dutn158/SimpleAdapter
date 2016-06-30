package simpleadapter.com.simpleadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

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
