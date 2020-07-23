package com.example.testmanagement.data;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.testmanagement.service.models.Patient;

import java.util.List;

public class PatientRepository {

    private LiveData<List<Patient>> _patientList;
    private MutableLiveData<Integer> _insertResult=new MutableLiveData<>();
    private final PatientDao patientDao;

    public PatientRepository(Context context,int nurseId) {
       AppDatabase db=AppDatabase.getInstance(context);
       patientDao=db.patientDao();
       this._patientList=patientDao.getAllPatients(nurseId);
    }

    public LiveData<List<Patient>> getPatientList(){return this._patientList;}
    public void insert(Patient patient){asyncInsert(patient);}
    private void asyncInsert(final Patient patient){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    patientDao.insert(patient);
                    _insertResult.postValue(1);
                }
                catch (Exception e){
                    _insertResult.postValue(0);
                }
            }
        }).start();
    }
}
