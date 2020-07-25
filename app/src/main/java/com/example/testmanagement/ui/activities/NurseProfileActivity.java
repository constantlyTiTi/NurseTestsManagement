package com.example.testmanagement.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.testmanagement.R;
import com.example.testmanagement.service.models.Nurse;
import com.example.testmanagement.ui.viewModels.NurseViewModel;

public class NurseProfileActivity extends AppCompatActivity {

    private Button goToPatient_bt;
    private TextView nurseId_tv;
    private EditText firstNameRegister_et;
    private EditText lastNameRegister_et;
    private EditText departmentRegister_et;
    private EditText passwordRegister_et;
    private NurseViewModel nurseViewModel;
    private Nurse nurse;
    private SharedPreferences getNurseId;
    String nurseId_String;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurse_profile);
        int nurseId;

        nurseId_tv=(TextView)findViewById(R.id.nurseId_tv_profile);
        goToPatient_bt=(Button)findViewById(R.id.goToPatient_bt_profile);
        firstNameRegister_et=(EditText)findViewById(R.id.firstNameRegister_et_profile);
        lastNameRegister_et=(EditText)findViewById(R.id.lastNameRegister_et_profile);
        departmentRegister_et=(EditText)findViewById(R.id.departmentRegister_et_profile);
        passwordRegister_et=(EditText)findViewById(R.id.passwordRegister_et_profile);
        nurseViewModel=ViewModelProviders.of(this).get(NurseViewModel.class);
        getNurseId=getSharedPreferences("nurse",MODE_PRIVATE);
        nurseId_String=getNurseId.getString("nurseRegisterId",nurseId_String);
        nurseId=Integer.parseInt(nurseId_String);

        display(nurseId);
        goToPatient_bt.setOnClickListener(v -> buttonOnClick());

    }

    private void display(int nurseId){
        nurse=nurseViewModel.getLoginNurseInfor(nurseId).getValue().get();
        nurseId_tv.setText(nurseId);
        firstNameRegister_et.setText(nurse.get_firstName());
        lastNameRegister_et.setText(nurse.get_lastName());
        departmentRegister_et.setText(nurse.get_department());
        passwordRegister_et.setText(nurse.get_password());
    }

    private void buttonOnClick(){
        Intent intent=new Intent(this,PatientActivity.class);
        startActivity(intent);
    }
}