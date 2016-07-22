package simpleadapter.com.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import simpleadapter.com.R;
import simpleadapter.com.model.EmployeeModel;
import simpleadapter.com.simpleadapter.EmployeeAdapter;

public class SimpleListActivity extends AppCompatActivity {

    @BindView(R.id.simple_list_recycler_view) RecyclerView mSimpleRecyclerView;

    private EmployeeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list);
        ButterKnife.bind(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mSimpleRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new EmployeeAdapter(getApplicationContext());
        mSimpleRecyclerView.setAdapter(mAdapter);

        // Json parse
        // converting back to object
        try {
            InputStream is = getAssets().open("simple_list_data.json");
            Type listType = new TypeToken<ArrayList<EmployeeModel>>() {
            }.getType();
            StringWriter writer = new StringWriter();
            IOUtils.copy(is, writer, "UTF-8");
            String jsonArrayStr = writer.toString();
            List<EmployeeModel> employeeModels = new Gson().fromJson(jsonArrayStr, listType);
            mAdapter.set(employeeModels);
            mAdapter.notifyDataSetChanged();
        } catch (IOException e) {

        }
    }

    @OnClick(R.id.add_footer_button)
    void addFooterButtonClick() {
        View loadingView = LayoutInflater.from(this).inflate(R.layout.loading_view, null);
        mAdapter.addFooterView(loadingView);
        mSimpleRecyclerView.smoothScrollToPosition(mAdapter.getItemCount());
    }

    @OnClick(R.id.remove_footer_button)
    void removeFooterButtonClick() {
        mAdapter.removeFooterView();
    }
}
