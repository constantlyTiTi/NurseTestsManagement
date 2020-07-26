package com.example.testmanagement.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.testmanagement.service.models.Patient;

import java.util.List;

@Dao
public interface PatientDao {
    @Insert
     void insert(Patient patient);
    @Query("select * from patient where nurseId= :nurseId")
    LiveData<List<Patient>> getAllPatients(Long nurseId);
}
