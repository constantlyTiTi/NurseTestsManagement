package com.example.testmanagement.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.testmanagement.service.models.Patient;
import com.example.testmanagement.service.models.Test;

import java.util.List;

public class TestRepository {
    private LiveData<List<Test>> tests;
    private LiveData<Test> test;
    private MutableLiveData<Long> insertTestId=new MutableLiveData<>();
    private MutableLiveData<Integer> updateTestResult=new MutableLiveData<>();
    private TestPatientNurseDao testPatientNurseDao;
    AppDatabase appDatabase;

    public TestRepository(Context context){
        appDatabase=AppDatabase.getInstance(context);
        testPatientNurseDao=appDatabase.testPatientNurseDao();
    }

    public LiveData<List<Test>> getTestListByPatient(Long patientId){
        this.tests=testPatientNurseDao.getAllTestsByPatient(patientId);
        return this.tests;}
    public void insert(Test test){asyncInsert(test);}
    public void update(Test test){asyncUpdate(test);}
    public LiveData<Long> getInsertPatientId(){
        return insertTestId;
    }
    public LiveData<Integer> getUpdateResult(){return  updateTestResult;}
    public LiveData<Test> getTestInfor(Long testId){return testPatientNurseDao.getTestInfor(testId);}
    private void asyncInsert(final Test test){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    insertTestId.postValue(testPatientNurseDao.insert(test));
                }
                catch (Exception e){
                    insertTestId.postValue(-1l);
                }
            }
        }).start();
    }

    private void asyncUpdate(final Test test){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    testPatientNurseDao.update(test);
                    updateTestResult.postValue(1);
                }
                catch (Exception e){
                    updateTestResult.postValue(0);
                }
            }
        }).start();
    }

}
