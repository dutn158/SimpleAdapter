package simpleadapter.com.sectionadapter;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import simpleadapter.com.section.EmployeeSection;
import simpleadapter.com.section.LoadingSection;
import simpleadapter.com.section.SampleTitleSection;
import simpleadapter.com.model.EmployeeModel;

/**
 * Created by chuchuynh on 6/30/16.
 */
public class SampleSectionAdapter extends BaseSectionAdapter {
    final int TITLE_TYPE = 1;
    final int EMPLOYEE_TYPE = 2;
    final int LOADING_TYPE = 3;


    public SampleSectionAdapter(Context context) {
        super(context);

        try {
            InputStream is = mContext.getAssets().open("simple_list_data.json");
            Type listType = new TypeToken<ArrayList<EmployeeModel>>() {
            }.getType();
            StringWriter writer = new StringWriter();
            IOUtils.copy(is, writer, "UTF-8");
            String jsonArrayStr = writer.toString();
            List<EmployeeModel> employeeModels = new Gson().fromJson(jsonArrayStr, listType);

            SampleTitleSection titleSection = new SampleTitleSection(mContext, TITLE_TYPE);
            EmployeeSection employeeSection = new EmployeeSection(mContext, EMPLOYEE_TYPE, employeeModels);
            LoadingSection loadingSection = new LoadingSection(mContext, LOADING_TYPE);
            addSection(titleSection);
            addSection(employeeSection);
            addSection(loadingSection);
        } catch (IOException e) {
            // Not importance
        }
    }
}
