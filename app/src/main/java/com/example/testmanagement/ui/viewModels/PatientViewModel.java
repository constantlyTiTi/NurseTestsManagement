package com.example.testmanagement.ui.viewModels;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.testmanagement.data.AsyncInsertResponse;
import com.example.testmanagement.data.PatientRepository;
import com.example.testmanagement.service.models.Patient;

import java.util.List;

public class PatientViewModel extends AndroidViewModel implements AsyncInsertResponse {
    private PatientRepository patientRepository;
    private String nurseId;
    private SharedPreferences getNurseIdSharedPreference;
    public PatientViewModel(@NonNull Application application) {
        super(application);
        getNurseIdSharedPreference=application.getSharedPreferences("Nurse", Context.MODE_PRIVATE);
        nurseId=getNurseIdSharedPreference.getString("LoginNurseId",nurseId);
        patientRepository=new PatientRepository(application,Integer.parseInt(nurseId));
    }

    public LiveData<List<Patient>> getAllPatientsByNurse(){
        return patientRepository.getPatientList();
    }

    @Override
    public void processInsert(Long id) {

    }
}
