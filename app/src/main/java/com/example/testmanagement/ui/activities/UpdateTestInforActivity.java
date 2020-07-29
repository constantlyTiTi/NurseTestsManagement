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
import com.example.testmanagement.ui.viewModels.TestViewModel;

public class UpdateTestInforActivity extends AppCompatActivity {

    Button updateTest_bt;
    EditText bplTest_et;
    EditText bphTest_et;
    EditText temperatureTest_et;
    EditText nurseId_et;
    EditText patientId_et;
    TextView testId_tv;
    TestViewModel testViewModel;
    SharedPreferences getTestIdPre;
    String getTestIdPreString;
    Test test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_test_infor);

        updateTest_bt=(Button)findViewById(R.id.updateTest_submit_bt);
        bplTest_et=(EditText)findViewById(R.id.updateTest_bpl_et);
        bphTest_et=(EditText)findViewById(R.id.updateTest_bph_et);
        temperatureTest_et=(EditText)findViewById(R.id.updateTest_temperature_et);
        nurseId_et=(EditText)findViewById(R.id.updateTest_nurseId_et);
        patientId_et=(EditText)findViewById(R.id.updateTest_patientId_et);
        testId_tv=(TextView) findViewById(R.id.updateTest_testId_tv);

        testViewModel= ViewModelProviders.of(this).get(TestViewModel.class);
        getTestIdPre=getSharedPreferences(String.valueOf(R.string.selectedTestSharedPreference),MODE_PRIVATE);
        getTestIdPreString=getTestIdPre.getString(String.valueOf(R.string.selectedTestId),getTestIdPreString);

        //Retrieve selected Test infor
        testViewModel.getTestInforByTestId(Long.parseLong(getTestIdPreString))
                    .observe(this,result->{
                        test=result;
                        testId_tv.setText(String.valueOf(test.get_testId()));
                        patientId_et.setText(String.valueOf(test.get_patientId()));
                        nurseId_et.setText(String.valueOf(test.get_nurseId()));
                        bplTest_et.setText(test.get_BPL());
                        bphTest_et.setText(test.get_BPH());
                        temperatureTest_et.setText(String.valueOf(test.get_temperature()));
                    });
        //update
        updateTest_bt.setOnClickListener(v->updateTestInfor());
    }

    private void updateTestInfor(){
        test.set_patientId(Long.parseLong(patientId_et.getText().toString()));
        test.set_nurseId(Long.parseLong(nurseId_et.getText().toString()));
        test.set_temperature(Double.parseDouble(temperatureTest_et.getText().toString()));
        test.set_BPL(bplTest_et.getText().toString());
        test.set_BPH(bphTest_et.getText().toString());
        testViewModel.update(test);
        Intent intent=new Intent(UpdateTestInforActivity.this, ViewTestInforActivity.class);
        startActivity(intent);
    }
}