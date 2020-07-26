package com.example.testmanagement.data;

import android.content.Context;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.testmanagement.service.models.Patient;

import java.util.List;

public class PatientRepository {

    private FragmentTransaction mFragmentTransaction;
    private FragmentManager mFragmentManager;
    private LiveData<List<Patient>> _patientList;
    private MutableLiveData<Long> insertPatientId=new MutableLiveData<>();
    private final PatientDao patientDao;

    public PatientRepository(Context context) {
       AppDatabase db=AppDatabase.getInstance(context);
       patientDao=db.patientDao();
    }

    public LiveData<List<Patient>> getPatientList(Long nurseId){
        this._patientList=patientDao.getAllPatients(nurseId);
        return this._patientList;}
    public void insert(Patient patient){asyncInsert(patient);}
    public LiveData<Long> getInsertPatientId(){
        return insertPatientId;
    }
    public LiveData<Patient> getPatientInfor(Long patientId){return patientDao.getPatientInfor(patientId);}
    private void asyncInsert(final Patient patient){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    insertPatientId.postValue(patientDao.insert(patient));
                }
                catch (Exception e){
                    insertPatientId.postValue(-1l);
                }
            }
        }).start();
    }
}
