package com.example.testmanagement.ui.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.testmanagement.data.TestRepository;
import com.example.testmanagement.service.models.Test;

import java.util.List;

public class TestViewModel extends AndroidViewModel {
    TestRepository testRepository;
    private LiveData<List<Test>> getPatientTestsByPatient;
    private LiveData<Long> insertTestId;
    private LiveData<Integer> updateTestResult;
    public TestViewModel(@NonNull Application application) {
        super(application);
        testRepository=new TestRepository(application);
    }

    public LiveData<List<Test>> getTestsByPatient(Long patientId){
        getPatientTestsByPatient=testRepository.getTestListByPatient(patientId);
        return getPatientTestsByPatient;
    }
    public LiveData<Test> getTestInforByTestId(Long testId){
         return testRepository.getTestInfor(testId);
    }
    public void update(Test test){
        testRepository.update(test);
        updateTestResult=testRepository.getUpdateResult();
    }
    public LiveData<Integer> getUpdateResult(){
        return updateTestResult;
    }
    public void insert(Test test){
        testRepository.insert(test);
        insertTestId=testRepository.getInsertTestId();
    }
    public LiveData<Long> getInsertTestId(){
        return insertTestId;
    }

    public void delete(Test... tests){
        testRepository.delete(tests);
    }
}
