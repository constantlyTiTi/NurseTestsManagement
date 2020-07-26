package com.example.testmanagement.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.testmanagement.service.models.Patient;

import java.util.List;

@Dao
public interface PatientDao {
    @Insert
     Long insert(Patient patient);
    @Update
    void update(Patient patient);
    @Delete
    void delete(Patient patient);
    @Query("select * from patient where nurseId= :nurseId")
    LiveData<List<Patient>> getAllPatients(Long nurseId);
    @Query(("select*from patient where patientId=:patientId"))
    LiveData<Patient> getPatientInfor(Long patientId);
}
