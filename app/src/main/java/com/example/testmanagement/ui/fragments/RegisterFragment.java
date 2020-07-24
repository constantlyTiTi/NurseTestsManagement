package com.example.testmanagement.ui.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.testmanagement.R;
import com.example.testmanagement.ui.activities.RegisterActivity;

public class RegisterFragment extends Fragment {
    private Button register_bt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_register, container, false);
        return view;
    }

    public void fragmentShow(){
        register_bt=(Button)getView().findViewById(R.id.register_fragment_bt);
        register_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

}