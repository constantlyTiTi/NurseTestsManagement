package com.example.testmanagement;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.testmanagement.service.models.Test;

import java.util.List;

@Dao
public interface TestPatientNurseDao {
    @Insert
    void insert(Test test);
    @Query("select * from Test where _nurseId=:nurseId and _patientId=:patientId")
    LiveData<List<Test>> getAllTestsByNursePatient(int nurseId,int patientId);
}
