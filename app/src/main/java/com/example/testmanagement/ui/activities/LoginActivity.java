package com.example.testmanagement.ui.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testmanagement.R;
import com.example.testmanagement.service.models.Nurse;
import com.example.testmanagement.ui.viewModels.NurseViewModel;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class LoginActivity extends AppCompatActivity {

    private EditText nurseId_et;
    private EditText password_et;
    private Button login_bt;

    private Nurse nurse;

    SharedPreferences nurseIdSharedPreference;
    SharedPreferences.Editor nurseIdSharedPreferenceEditor;
    NurseViewModel nurseViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //link viewModel
        nurseViewModel= ViewModelProviders.of(this).get(NurseViewModel.class);

        //Assign values
        nurseId_et=(EditText)findViewById(R.id.nurseId_et);
        password_et=(EditText)findViewById(R.id.password_et);
        login_bt=(Button)findViewById(R.id.login_bt);

        //Add onClick event to Login button and register button
        login_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Long nurseId;
                String enteredPassword;
                nurseId=Long.parseLong(nurseId_et.getText().toString());
                enteredPassword=password_et.getText().toString();
                if (isUserExist(nurseId)) {
                    if (isPasswordCorrect(enteredPassword)) {
                        nurseIdSharedPreference = getSharedPreferences("nurse", MODE_PRIVATE);
                        nurseIdSharedPreferenceEditor = nurseIdSharedPreference.edit();
                        nurseIdSharedPreferenceEditor.putString("loginNurseId", nurseId_et.toString());
                        nurseIdSharedPreferenceEditor.commit();
                    } else {
                        Toast toast = Toast.makeText(getApplicationContext(), R.string.wrong_password, Toast.LENGTH_LONG);
                    }
                }
                else {
                    Toast toast=Toast.makeText(getApplicationContext(),R.string.user_not_exist,Toast.LENGTH_LONG);
                }
            }
        });

    }

    private boolean isPasswordCorrect(String enteredPassword){
        String passwordInDatabase;
        passwordInDatabase=nurse.get_password().toString();
        return enteredPassword.compareTo(passwordInDatabase)==0? true:false;
    }

    private boolean isUserExist(Long nurseId){
        AtomicBoolean loginValidation= new AtomicBoolean(false);
//        nurse = nurseViewModel.getLoginNurseInfor(nurseId).getValue().
        nurseViewModel.getLoginNurseInfor(nurseId).getValue()
                .ifPresent(n -> { loginValidation.set(true);
                    nurse=n;
                });
        return loginValidation.get();
    }


}