package com.example.testmanagement.ui.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testmanagement.R;
import com.example.testmanagement.service.models.Test;
import com.example.testmanagement.ui.activities.UpdateTestInforActivity;

import java.util.List;

public class TestsRecyclerViewAdapter extends RecyclerView.Adapter<TestsRecyclerViewAdapter.TestViewHolder> {
    Activity context;
    List<Test> tests;
    SharedPreferences editViewTestInforSharedPreference;
    SharedPreferences.Editor editViewTestInforPreEditor;
    String testItemsTVString;
    private List<Test> selectedTests;
    public TestsRecyclerViewAdapter(@NonNull Activity context, @NonNull List<Test> objects) {
        this.tests=objects;
        this.context=context;
/*        tests.add(0,null);*/
        editViewTestInforSharedPreference=context
                .getSharedPreferences(
                        String.valueOf(R.string.selectedTestSharedPreference)
                        ,context.MODE_PRIVATE);
        editViewTestInforPreEditor=editViewTestInforSharedPreference.edit();
    }

    @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.test_listview_layout, parent, false);

        return new TestViewHolder(v,context);
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder viewHolder, int position) {

/*        if(position!=0){*/
            viewHolder.getTestId_tv().setText(String.valueOf(tests.get(position).get_testId()));
            viewHolder.getNuseId_tv().setText(String.valueOf(tests.get(position).get_nurseId()));
            if(tests.get(position).get_BPL()!=null){
                testItemsTVString+="BPL";
            }
            if(tests.get(position).get_BPH()!=null){
                testItemsTVString+="<br/>BPH";
            }
            if(tests.get(position).get_temperature()!=0){
                testItemsTVString+="<br/>Temperature";
            }
            viewHolder.getTestItems_tv().setText(testItemsTVString);

            //Selected items to be deleted
            /*viewHolder.getCheckBox().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(isChecked){
                            rowView.setTag(tests.get(position));
                            selectedTests.add(tests.get(position));}
                        else {
                            rowView.setTag(null);
                            selectedTests.remove(tests.get(position));
                        }
                    }
                });*/
            //Edit and View Test information button
                viewHolder.getButton().setText("View/Edit");
                viewHolder.getButton().setOnClickListener(v->{
                    editViewTestInforPreEditor.putString(String.valueOf(
                            R.string.selectedTestId)
                            ,String.valueOf(tests.get(position).get_testId()));

                    Intent intent=new Intent(context, UpdateTestInforActivity.class);
                    context.startActivity(intent);
                });
/*            }
        else {
            viewHolder.getTestId_tv().setText("Test ID");
            viewHolder.getNuseId_tv().setText("Responsible by");
            viewHolder.getTestItems_tv().setText("Test Items");
        }*/

    }

    @Override
    public int getItemCount() {
        return tests==null?0:tests.size();
    }

    public class TestViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout deleteCheckbox_Layout;
        private LinearLayout viewEditButton_Layout;
        private TextView testId_tv;
        private TextView nuseId_tv;
        private TextView testItems_tv;
        CheckBox checkBox;
        Button button;
        public TestViewHolder(@NonNull View itemView, Activity context) {
            super(itemView);
            bind(context,itemView);
        }

        private void bind(Activity context,View itemView){
            deleteCheckbox_Layout=(LinearLayout)itemView.findViewById(R.id.testListView_deleteCheckbox_layout);
            viewEditButton_Layout=(LinearLayout)itemView.findViewById(R.id.testListView_EditView_layout);
            testId_tv=(TextView)itemView.findViewById(R.id.testListView_testId_tv);
            nuseId_tv=(TextView)itemView.findViewById(R.id.testListView_nurseId_tv);
            testItems_tv=(TextView)itemView.findViewById(R.id.testListView_testItems_tv);

            checkBox=new CheckBox(context);
            button=new Button(context);
            deleteCheckbox_Layout.addView(checkBox);
            viewEditButton_Layout.addView(button);
        }

        public LinearLayout getDeleteCheckbox_Layout() {
            return deleteCheckbox_Layout;
        }

        public LinearLayout getViewEditButton_Layout() {
            return viewEditButton_Layout;
        }

        public TextView getTestId_tv() {
            return testId_tv;
        }

        public TextView getNuseId_tv() {
            return nuseId_tv;
        }

        public TextView getTestItems_tv() {
            return testItems_tv;
        }
        public CheckBox getCheckBox(){
            return checkBox;
        }
        public Button getButton(){
            return button;
        }
    }
}
