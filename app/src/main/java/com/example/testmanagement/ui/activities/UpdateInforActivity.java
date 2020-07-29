package com.example.testmanagement.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testmanagement.R;
import com.example.testmanagement.service.models.Patient;
import com.example.testmanagement.ui.viewModels.PatientViewModel;

import java.util.Observable;
import java.util.Observer;

public class UpdateInforActivity extends AppCompatActivity {
    SharedPreferences getSelectedPatientIdPre;
    SharedPreferences getLoginNurseId;
    String selectedPatientIdString,nurseIdString;
    Long selectedId,nurseId;
    TextView patientId_tv;
    EditText nurseId_et;
    EditText firstName_et;
    EditText lastName_et;
    EditText room_et;
    EditText department;
    PatientViewModel patientViewModel;
    Patient patient;
    Button updatePatient_bt;
    Button goToTest_bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_infor);
        //retrieve patient ID
        patientViewModel= ViewModelProviders.of(this).get(PatientViewModel.class);
        getSelectedPatientIdPre=getSharedPreferences(
                String.valueOf(R.string.patientSharedPreference),MODE_PRIVATE);
        selectedPatientIdString=getSelectedPatientIdPre
                .getString(String.valueOf(R.string.selectedPatientId),selectedPatientIdString);
        selectedId=Long.parseLong(selectedPatientIdString);

        //retrieve Login Nurse ID
        getLoginNurseId=getSharedPreferences(
                String.valueOf(R.string.nurseSharedReference),MODE_PRIVATE);
        nurseIdString=getLoginNurseId.getString(String.valueOf(R.string.autherizedNurseId),nurseIdString);
        nurseId=Long.parseLong(nurseIdString);

        // define elements
        patientId_tv=(TextView)findViewById(R.id.patient_Id_update_tv);
        nurseId_et=(EditText)findViewById(R.id.patientNurseId_update_et);
        firstName_et=(EditText)findViewById(R.id.patientFirstName_update_et);
        lastName_et=(EditText)findViewById(R.id.patientLastName_update_et);
        room_et=(EditText)findViewById(R.id.patientRoom_update_et);
        department=(EditText)findViewById(R.id.patientDepartment_update_et);
        updatePatient_bt=(Button)findViewById(R.id.editSubmit_update_bt);
        goToTest_bt=(Button)findViewById(R.id.updateToTestPage_bt);

        //implement function
        displayPatientInfor(selectedId);
        updatePatient_bt.setOnClickListener(v->updatePatientInfor());
        goToTest_bt.setOnClickListener(v->goToTestPage());
    }

    private void displayPatientInfor(Long selectedId) {
        patientViewModel.getPatientInfor(selectedId).observe(this, result -> {
            patient=result;
            patientId_tv.setText(String.valueOf(patient.getPatientId()));
            nurseId_et.setText(String.valueOf(patient.getNurseId()));
            firstName_et.setText(String.valueOf(patient.getFirstName()));
            lastName_et.setText(String.valueOf(patient.getLastName()));
            room_et.setText(String.valueOf(patient.getRoom()));
            department.setText(String.valueOf(patient.getDepartment()));
        });
    }
    private void updatePatientInfor(){
        patient.setNurseId(Long.parseLong(nurseId_et.getText().toString()));
        patient.setFirstName(firstName_et.getText().toString());
        patient.setLastName(lastName_et.getText().toString());
        patient.setRoom(room_et.getText().toString());
        patient.setDepartment(department.getText().toString());
        patientViewModel.updatePatient(patient);
        patientViewModel.getUpdateResult().observe(UpdateInforActivity.this,result->{
            if(result==1){
                Toast.makeText(UpdateInforActivity.this,
                        "patient Update Success",
                        Toast.LENGTH_LONG)
                        .show();
            }
            else {
                Toast.makeText(UpdateInforActivity.this,
                        "patient Update Failed",
                        Toast.LENGTH_LONG)
                        .show();
            }
        });
        if(patient.getNurseId()!=nurseId){
            Intent intent=new Intent(UpdateInforActivity.this,Patient.class);
            startActivity(intent);
        }
    }
    private void goToTestPage(){
        Intent intent=new Intent(UpdateInforActivity.this,ViewTestInforActivity.class);
        startActivity(intent);
    }
}