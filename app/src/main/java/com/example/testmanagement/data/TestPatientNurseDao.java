package com.example.testmanagement.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.testmanagement.service.models.Test;

import java.util.List;

@Dao
public interface TestPatientNurseDao {
    @Insert
    Long insert(Test test);
    @Update
    void update(Test test);
    @Delete
    void delete(Test... tests);
    @Query("select * from test where nurseId=:nurseId and patientId=:patientId")
    LiveData<List<Test>> getAllTestsByNursePatient(Long nurseId,Long patientId);
    @Query("select * from test where patientId=:patientId")
    LiveData<List<Test>> getAllTestsByPatient(Long patientId);
    @Query("select * from test where testId=:testId")
    LiveData<Test> getTestInfor(Long testId);
}
