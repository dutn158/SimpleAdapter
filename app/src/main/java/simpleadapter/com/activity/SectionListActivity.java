package simpleadapter.com.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import simpleadapter.com.sectionadapter.SampleSectionAdapter;
import simpleadapter.com.R;

public class SectionListActivity extends AppCompatActivity {

    @BindView(R.id.simple_list_recycler_view) RecyclerView mSimpleRecyclerView;

    private SampleSectionAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list);
        ButterKnife.bind(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mSimpleRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new SampleSectionAdapter(getApplicationContext());
        mSimpleRecyclerView.setAdapter(mAdapter);
    }
}
