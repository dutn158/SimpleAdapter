package simpleadapter.com.sectionadapter.section;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import simpleadapter.com.model.EmployeeModel;
import simpleadapter.com.simpleadapter.viewholder.EmployeeViewHolder;
import simpleadapter.com.R;

/**
 * Created by chuchuynh on 6/30/16.
 */
public class EmployeeSection extends ManyItemSection<EmployeeModel> {
    public EmployeeSection(Context context, int viewType, List<EmployeeModel> models) {
        super(context, viewType, models);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.employee_item, parent, false);
        EmployeeViewHolder holder = new EmployeeViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int sectionPosition) {
        ((EmployeeViewHolder) holder).bind(mItems.get(sectionPosition));
    }
}
