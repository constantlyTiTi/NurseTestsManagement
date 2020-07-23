package com.example.testmanagement;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Update;

import com.example.testmanagement.service.models.Nurse;

import java.util.Optional;

//get the login Nurse information
@Dao
public interface NurseLoginDao {
    @Update
    void update(Nurse nurse);
    @Query("select*from Nurse where _nurseId=:nurseId")
    LiveData<Optional<Nurse>> getLoginNurseInfor(int nurseId);
}
