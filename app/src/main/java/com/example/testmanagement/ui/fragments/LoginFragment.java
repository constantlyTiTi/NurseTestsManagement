package com.example.testmanagement.ui.fragments;

import android.content.Intent;
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
import com.example.testmanagement.ui.activities.LoginActivity;
import com.example.testmanagement.ui.viewModels.NurseViewModel;
import com.example.testmanagement.R;

import java.util.concurrent.atomic.AtomicBoolean;

import static android.content.Context.MODE_PRIVATE;

public class LoginFragment extends Fragment {

    private Button login_bt;
    private Intent intent;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);
        return view;
    }

    public void fragmentShow(){
        login_bt=(Button)getView().findViewById(R.id.login_fragment_bt);
        login_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }



}