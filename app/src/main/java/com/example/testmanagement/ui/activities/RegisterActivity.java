package com.example.testmanagement.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testmanagement.R;
import com.example.testmanagement.service.models.Nurse;
import com.example.testmanagement.ui.viewModels.NurseViewModel;

import java.util.List;

public class RegisterActivity extends AppCompatActivity {
    private Button register_submit_bt;
    private EditText firstNameRegister_et;
    private EditText lastNameRegister_et;
    private EditText departmentRegister_et;
    private EditText passwordRegister_et;
    private NurseViewModel nurseViewModel;
    SharedPreferences registerNurseIdPreference;
    SharedPreferences.Editor registerNurseIdPreEditor;
    Intent intent;
    Nurse nurse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nurseViewModel= ViewModelProviders.of(this).get(NurseViewModel.class);

        register_submit_bt=(Button)findViewById(R.id.register_submit_bt);
        firstNameRegister_et=(EditText)findViewById(R.id.firstNameRegister_et);
        lastNameRegister_et=(EditText)findViewById(R.id.lastNameRegister_et);
        departmentRegister_et=(EditText)findViewById(R.id.departmentRegister_et);
        passwordRegister_et=(EditText)findViewById(R.id.passwordRegister_et);
        registerNurseIdPreference=getSharedPreferences(String.valueOf(R.string.nurseSharedReference),MODE_PRIVATE);
        registerNurseIdPreEditor=registerNurseIdPreference.edit();
        intent=new Intent(RegisterActivity.this,NurseProfileActivity.class);
        nurseViewModel.get_insertNurseIdResult().observe(this, result -> {
            if(result>-1) {
                registerNurseIdPreEditor.putString(String.valueOf(R.string.autherizedNurseId),String.valueOf(result));
                registerNurseIdPreEditor.commit();
                startActivity(intent);
            }
        });


        register_submit_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nurse=new Nurse();
                nurse.set_firstName(firstNameRegister_et.getText().toString());
                nurse.set_lastName(lastNameRegister_et.getText().toString());
                nurse.set_department(departmentRegister_et.getText().toString());
                nurse.set_password(passwordRegister_et.getText().toString());
//                nurse.set_nurseId(nurseViewModel.insertNurseAndReturnNurseId(nurse));
                nurseViewModel.insertNurse(nurse);
//                nurseViewModel.insertNurseAndReturnNurseId(nurse);
//                nurseViewModel.processInsert();


            }
        });

    }


}