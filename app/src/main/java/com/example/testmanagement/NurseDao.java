package com.example.testmanagement;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.testmanagement.service.models.Nurse;

import java.util.List;
import java.util.Optional;

//get all Nurses in Database for future function
public interface NurseDao {
    @Insert
    void insert(Nurse nurse);
    @Query("select * from Nurse order by _nurseId")
    LiveData<Optional<List<Nurse>>> getAllNurse();
}
