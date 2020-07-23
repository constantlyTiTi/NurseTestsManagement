package com.example.testmanagement.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.testmanagement.R;

public class MainActivity extends AppCompatActivity {
private LoginFragment loginFragment;
private RegisterFragment registerFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginFragment=(LoginFragment)getSupportFragmentManager().findFragmentById(R.id.login_fragment);
        registerFragment=(RegisterFragment)getSupportFragmentManager().findFragmentById(R.id.register_fragment);
        loginFragment.fragmentShow();
        registerFragment.fragmentShow();
    }
}