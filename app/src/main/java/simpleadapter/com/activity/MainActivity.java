package simpleadapter.com.activity;

import android.content.Intent;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;
import simpleadapter.com.R;
import simpleadapter.com.base.activity.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.simple_list_button)
    void onSimpleListButtonClick() {
        Intent intent = new Intent(this, SimpleListActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.section_list_button)
    void onSectionListButtonClick() {
        Intent intent = new Intent(this, SectionListActivity.class);
        startActivity(intent);
    }
}
