package com.example.testmanagement.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.testmanagement.R;
import com.example.testmanagement.service.models.Nurse;
import com.example.testmanagement.ui.viewModels.NurseViewModel;

public class RegisterActivity extends AppCompatActivity {
    private Button register_submit_bt;
    private EditText nurseIdRegister_et;
    private EditText firstNameRegister_et;
    private EditText lastNameRegister_et;
    private EditText departmentRegister_et;
    private EditText passwordRegister_et;
    private NurseViewModel nurseViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nurseViewModel= ViewModelProviders.of(this).get(NurseViewModel.class);

        register_submit_bt=(Button)findViewById(R.id.register_submit_bt);
        nurseIdRegister_et=(EditText)findViewById(R.id.nurseIdRegister_et);
        firstNameRegister_et=(EditText)findViewById(R.id.firstNameRegister_et);
        lastNameRegister_et=(EditText)findViewById(R.id.lastNameRegister_et);
        departmentRegister_et=(EditText)findViewById(R.id.departmentRegister_et);
        passwordRegister_et=(EditText)findViewById(R.id.passwordRegister_et);

        register_submit_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nurse nurse=new Nurse(Integer.parseInt(nurseIdRegister_et.toString()),
                        firstNameRegister_et.toString(),lastNameRegister_et.toString(),
                        departmentRegister_et.toString(),passwordRegister_et.toString());
                nurseViewModel.insertNurse(nurse);
            }
        });

    }
}