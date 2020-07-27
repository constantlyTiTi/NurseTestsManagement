package com.example.testmanagement.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.testmanagement.R;
import com.example.testmanagement.ui.adapters.PatientTestsListViewAdapter;

public class TestActivity extends AppCompatActivity {
    Button addNewTest_bt;
    EditText bplTest_et;
    EditText bphTest_et;
    EditText temperatureTest_et;
    PatientTestsListViewAdapter patientTestsListViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

    }
}