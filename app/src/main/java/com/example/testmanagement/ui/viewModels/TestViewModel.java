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
    private LiveData<List<Test>> tests;
    private LiveData<Test> test;
    private LiveData<Long> insertTestId;
    private LiveData<Integer> updateTestResult;
    public TestViewModel(@NonNull Application application) {
        super(application);
        testRepository=new TestRepository(application);
    }
}
