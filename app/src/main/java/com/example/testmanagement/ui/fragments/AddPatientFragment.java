package com.example.testmanagement.ui.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.testmanagement.R;
import com.example.testmanagement.service.models.Patient;
import com.example.testmanagement.ui.viewModels.PatientViewModel;

public class AddPatientFragment extends Fragment {
    Button addPatientSubmit_bt;
    EditText patientId_et;
    EditText patientFirstName_et;
    EditText patientLastName_et;
    EditText patientNurseId_et;
    EditText patientRoom_et;
    EditText patientDepartment_et;
    SharedPreferences getNursePre;
    PatientViewModel patientViewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_add_patient, container, false);
        addPatientSubmit_bt=(Button)view.findViewById(R.id.addPatient_bt);
        patientFirstName_et=(EditText)view.findViewById(R.id.patientFirstName_addPatient_et);
        patientLastName_et=(EditText)view.findViewById(R.id.patientLastName_addPatient_et);
        patientNurseId_et=(EditText)view.findViewById(R.id.patientNurseId_addPatient_et);
        patientRoom_et=(EditText)view.findViewById(R.id.patientRoom_addPatient_et);
        patientDepartment_et=(EditText)view.findViewById(R.id.patientDepartment_addPatient_et);

        addPatientSubmit_bt.setOnClickListener(v->submitNewPatient());

        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getNursePre=this.getActivity()
                .getSharedPreferences(String.valueOf(R.string.nurseSharedReference), Context.MODE_PRIVATE);
        String nurseIdString=getNursePre.getString(String.valueOf(R.string.autherizedNurseId),"");
        patientNurseId_et.setText(nurseIdString);
        patientViewModel= ViewModelProviders.of(this.getActivity()).get(PatientViewModel.class);
    }

    private void submitNewPatient(){
        Patient patient=new Patient();
/*        Long patientId=Long.parseLong(patientId_et.getText().toString());*/
        patient.setNurseId(Long.parseLong(patientNurseId_et.getText().toString()));
        patient.setFirstName(patientFirstName_et.getText().toString());
        patient.setLastName(patientLastName_et.getText().toString());
        patient.setDepartment(patientDepartment_et.getText().toString());
        patient.setRoom(patientRoom_et.getText().toString());
        patientViewModel.insertPatient(patient);

    }
}