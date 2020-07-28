package com.example.testmanagement.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.testmanagement.R;
import com.example.testmanagement.service.models.Test;
import com.example.testmanagement.ui.adapters.TestsListViewAdapter;
import com.example.testmanagement.ui.viewModels.TestViewModel;

public class TestActivity extends AppCompatActivity {
    Button addNewTest_bt;
    EditText bplTest_et;
    EditText bphTest_et;
    EditText temperatureTest_et;
    TestViewModel testViewModel;
    EditText nurseId_et;
    SharedPreferences getPatientIdPre;
    String selectedPatientIdStirng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        bphTest_et=(EditText)findViewById(R.id.test_bph_et);
        bplTest_et=(EditText)findViewById(R.id.test_bpl_et);
        temperatureTest_et=(EditText)findViewById(R.id.test_temperature_et);
        addNewTest_bt=(Button)findViewById(R.id.test_submit_bt);
        nurseId_et=(EditText)findViewById(R.id.test_nurseId_et);
        testViewModel= ViewModelProviders.of(this).get(TestViewModel.class);
        //retrieve selected patientID
        getPatientIdPre=getSharedPreferences(String.valueOf(R.string.patientSharedPreference),MODE_PRIVATE);
        selectedPatientIdStirng=getPatientIdPre.getString(String.valueOf(R.string.selectedPatientId),
                                selectedPatientIdStirng);
        //Add Test to the patient
        addNewTest_bt.setOnClickListener(v->addNewTest());
    }

    private void addNewTest(){
        Test test=new Test();
        test.set_nurseId(Long.parseLong(nurseId_et.getText().toString()));
        test.set_BPH(bphTest_et.getText().toString());
        test.set_BPL(bplTest_et.getText().toString());
        test.set_temperature(Double.parseDouble(temperatureTest_et.getText().toString()));
        test.set_patientId(Long.parseLong(selectedPatientIdStirng));
        testViewModel.insert(test);
        //Go back to test list page
        Intent intent =new Intent(TestActivity.this,ViewTestInforActivity.class);
        startActivity(intent);
    }
}