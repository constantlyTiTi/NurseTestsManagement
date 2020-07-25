package com.example.testmanagement.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.testmanagement.service.models.Nurse;

import java.util.List;
import java.util.Optional;

//get all Nurses in Database for future function
@Dao
public interface NurseDao {
    @Insert
    void insert(Nurse nurse);
    @Query("select * from Nurse order by nurseId")
    LiveData<List<Nurse>> getAllNurse();
    @Update
    void update(Nurse nurse);
    @Query("select*from Nurse where nurseId=:nurseId")
    LiveData<Optional<Nurse>> getLoginNurseInfor(int nurseId);
}
