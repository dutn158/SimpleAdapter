package simpleadapter.com.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import simpleadapter.com.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
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
