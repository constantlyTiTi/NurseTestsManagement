package com.example.testmanagement.ui.activities;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testmanagement.service.models.Nurse;
import com.example.testmanagement.ui.viewModels.NurseViewModel;
import com.example.testmanagement.R;

import java.util.concurrent.atomic.AtomicBoolean;

import static android.content.Context.MODE_PRIVATE;

public class LoginFragment extends Fragment {

    private EditText nurseId_et;
    private EditText password_et;
    private Button login_bt;

    private Nurse nurse;

    SharedPreferences nurseIdSharedPreference;
    SharedPreferences.Editor nurseIdSharedPreferenceEditor;
    NurseViewModel nurseViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        int nurseId;
        String enteredPassword;

        //link viewModel
        nurseViewModel= ViewModelProviders.of(this).get(NurseViewModel.class);

        //Assign values
        nurseId_et=(EditText)getView().findViewById(R.id.nurseId_et);
        password_et=(EditText)getView().findViewById(R.id.password_et);
        login_bt=(Button)getView().findViewById(R.id.login_bt);
        nurseId=Integer.parseInt(nurseId_et.getText().toString());
        enteredPassword=password_et.getText().toString();

        //Add onClick event to Login button and register button
        login_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isUserExist(nurseId)) {
                    if (isPasswordCorrect(enteredPassword)) {
                        nurseIdSharedPreference = getContext().getSharedPreferences("NurseId", MODE_PRIVATE);
                        nurseIdSharedPreferenceEditor = nurseIdSharedPreference.edit();
                        nurseIdSharedPreferenceEditor.putString("LoginNurseId", nurseId_et.toString());
                        nurseIdSharedPreferenceEditor.commit();
                    } else {
                        Toast toast = Toast.makeText(getContext(), R.string.wrong_password, Toast.LENGTH_LONG);
                    }
                }
                else {
                    Toast toast=Toast.makeText(getContext(),R.string.user_not_exist,Toast.LENGTH_LONG);
                }
            }
        });
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    private boolean isPasswordCorrect(String enteredPassword){
        String passwordInDatabase;
        passwordInDatabase=nurse.get_password().toString();
        return enteredPassword.compareTo(passwordInDatabase)==0? true:false;
        }

    private boolean isUserExist(int nurseId){
        AtomicBoolean loginValidation= new AtomicBoolean(false);
//        nurse = nurseViewModel.getLoginNurseInfor(nurseId).getValue().
        nurseViewModel.getLoginNurseInfor(nurseId).getValue()
                .ifPresent(n -> { loginValidation.set(true);
                nurse=n;
        });
        return loginValidation.get();
    }

}