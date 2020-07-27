package com.example.testmanagement.ui.adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.testmanagement.R;
import com.example.testmanagement.service.models.Test;
import com.example.testmanagement.ui.activities.TestEditActivity;

import java.util.List;

public class PatientTestsListViewAdapter extends ArrayAdapter {
    Activity context;
    List<Test> tests;
    TextView testId_tv, nuseId_tv,testItems_tv;
    LinearLayout deleteCheckbox_Layout, viewEditButton_Layout;
    public PatientTestsListViewAdapter(@NonNull Activity context, int resource, @NonNull List<Test> objects) {
        super(context, R.layout.test_listview_layout, objects);
        this.tests=objects;
        this.context=context;
        tests.add(0,null);

    }
    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.test_listview_layout,null,false);

        deleteCheckbox_Layout=(LinearLayout)rowView.findViewById(R.id.testListView_deleteCheckbox_layout);
        viewEditButton_Layout=(LinearLayout)rowView.findViewById(R.id.testListView_EditView_layout);
        testId_tv=(TextView)rowView.findViewById(R.id.testListView_testId_tv);
        nuseId_tv=(TextView)rowView.findViewById(R.id.testListView_nurseId_tv);
        testItems_tv=(TextView)rowView.findViewById(R.id.testListView_testItems_tv);

        if(position!=0){
            CheckBox checkBox=new CheckBox(context);
            Button button=new Button(context);
            String testItemsTVString=null;

            testId_tv.setText(tests.get(position).get_testId());
            nuseId_tv.setText(tests.get(position).get_nurseId());
            if(tests.get(position).get_BPL()!=null){
                testItemsTVString+="BPL";
            }
            if(tests.get(position).get_BPH()!=null){
                testItemsTVString+="<br/>BPH";
            }
            if(tests.get(position).get_temperature()!=0){
                testItemsTVString+="<br/>Temperature";
            }
            testItems_tv.setText(testItemsTVString);

            if(deleteCheckbox_Layout!=null){
                deleteCheckbox_Layout.addView(checkBox);
            }
            if(viewEditButton_Layout!=null){
                viewEditButton_Layout.addView(button);
                button.setOnClickListener(v->{
                    Intent intent=new Intent(context, TestEditActivity.class);
                    context.startActivity(intent);
                });
            }
        }


        return rowView;
    }
}
