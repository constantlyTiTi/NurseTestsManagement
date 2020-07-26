package com.example.testmanagement.ui.viewModels;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.testmanagement.R;
import com.example.testmanagement.data.AsyncInsertResponse;
import com.example.testmanagement.data.PatientRepository;
import com.example.testmanagement.service.models.Patient;

import java.util.List;

public class PatientViewModel extends AndroidViewModel {
    private PatientRepository patientRepository;
    private Long nurseId;
    private SharedPreferences getNurseIdSharedPreference;
    public PatientViewModel(@NonNull Application application) {
        super(application);
        getNurseIdSharedPreference=application.getSharedPreferences(String.valueOf(R.string.nurseSharedReference), Context.MODE_PRIVATE);
        nurseId=Long.parseLong(getNurseIdSharedPreference.getString(String.valueOf(R.string.autherizedNurseId), String.valueOf(nurseId)));
        patientRepository=new PatientRepository(application);
    }

    public LiveData<List<Patient>> getAllPatientsByNurse(){
        return patientRepository.getPatientList(nurseId);
    }
}
