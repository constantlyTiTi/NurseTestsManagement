package com.example.testmanagement.ui.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
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
import java.util.Optional;
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
        login_bt.setOnClickListener(v -> {
            Long nurseId;
            String enteredPassword;
            nurseId = Long.parseLong(nurseId_et.getText().toString());
            enteredPassword = password_et.getText().toString();

            nurseViewModel.getLoginNurseInfor(nurseId)
                        .observe(LoginActivity.this, optionalN -> {
                            optionalN.ifPresent(n -> {
                                    if (n.get_password().equals(enteredPassword)) {
                                        nurseIdSharedPreference = getSharedPreferences(String.valueOf(R.string.nurseSharedReference), MODE_PRIVATE);
                                        nurseIdSharedPreferenceEditor = nurseIdSharedPreference.edit();
                                        nurseIdSharedPreferenceEditor.putString(String.valueOf(R.string.autherizedNurseId), nurseId.toString());
                                        nurseIdSharedPreferenceEditor.commit();
                                        startActivity(new Intent(LoginActivity.this, NurseProfileActivity.class));
                                    }
                                    else { password_et.setError("Password is Wrong");}
                            });
 /*                            if(optionalN.equals(null)){nurseId_et.setError("Nurse dose not exist in the database");}*/

                        });
        });

    }

    private void isUserExist(){
        Toast.makeText(getApplicationContext(), R.string.user_not_exist, Toast.LENGTH_LONG);

    }


}