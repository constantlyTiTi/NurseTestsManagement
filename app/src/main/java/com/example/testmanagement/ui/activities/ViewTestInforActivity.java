package com.example.testmanagement.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.example.testmanagement.R;
import com.example.testmanagement.service.models.Test;
import com.example.testmanagement.ui.adapters.TestsListViewAdapter;
import com.example.testmanagement.ui.viewModels.TestViewModel;

import java.util.List;

public class ViewTestInforActivity extends AppCompatActivity {
    SharedPreferences getSelectedPatientIdPre;
    String selectedPatientIdString;
    Long selectedPatientId;
    TestViewModel testViewModel;
    List<Test> getTestsByPatientId;
    TestsListViewAdapter testsListViewAdapter;
    ListView viewTestListView;
    Button delete_bt,addNewTest_bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_test_infor);

        testViewModel= ViewModelProviders.of(this).get(TestViewModel.class);
        //retrieve selected patient id
        getSelectedPatientIdPre=getSharedPreferences(
                String.valueOf(R.string.patientSharedPreference),MODE_PRIVATE);
        selectedPatientIdString=getSelectedPatientIdPre
                .getString(String.valueOf(R.string.selectedPatientId),selectedPatientIdString);
        selectedPatientId=Long.parseLong(selectedPatientIdString);

        //retrieve tests by patient id;
        testViewModel.getTestsByPatient(selectedPatientId).observe(this,result->{
            getTestsByPatientId=result;
        });

        //show ListView
        testsListViewAdapter=new TestsListViewAdapter(this,getTestsByPatientId);
        viewTestListView=findViewById(R.id.testListView_listView);
        viewTestListView.setAdapter(testsListViewAdapter);

        //button function
        delete_bt=(Button)findViewById(R.id.testListView_delete_bt);
        addNewTest_bt=(Button)findViewById(R.id.testListView_addNewTest_bt);
        addNewTest_bt.setOnClickListener(v->addNewTest());
    }

    //button function method
    private void deleteSelectedTests(){
        testViewModel.delete((Test) testsListViewAdapter.getSelectedTests());
    }

    private void addNewTest(){
        Intent intent =new Intent(this,TestActivity.class);
        startActivity(intent);
    }
}