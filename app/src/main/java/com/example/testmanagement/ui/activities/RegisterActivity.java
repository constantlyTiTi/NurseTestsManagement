package com.example.testmanagement.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.testmanagement.R;

public class RegisterActivity extends AppCompatActivity {
    private Button register_submit_bt;
    private EditText nurseIdRegister_et;
    private EditText firstNameRegister_et;
    private EditText lastNameRegister_et;
    private EditText departmentRegister_et;
    private EditText passwordRegister_et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register_submit_bt=(Button)findViewById(R.id.register_submit_bt);
        nurseIdRegister_et=(EditText)findViewById(R.id.nurseIdRegister_et);
        firstNameRegister_et=(EditText)findViewById(R.id.firstNameRegister_et);
        lastNameRegister_et=(EditText)findViewById(R.id.lastNameRegister_et);
        departmentRegister_et=(EditText)findViewById(R.id.departmentRegister_et);
        passwordRegister_et=(EditText)findViewById(R.id.passwordRegister_et);
    }
}