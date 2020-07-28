package com.example.testmanagement.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.testmanagement.service.models.Nurse;
import com.example.testmanagement.service.models.Patient;
import com.example.testmanagement.service.models.Test;

@Database(version=1,entities={Patient.class, Test.class, Nurse.class})
abstract class AppDatabase extends RoomDatabase {
    private static volatile AppDatabase INSTANCE;
    private static final String DATABASE_NAME = "NursePatientTestDB";
    public abstract PatientDao patientDao();
    public abstract NurseDao nurseDao();
    public abstract TestPatientNurseDao testPatientNurseDao();

    public static synchronized AppDatabase getInstance(Context context){
        if (INSTANCE==null){
            INSTANCE= Room.databaseBuilder(context, AppDatabase.class,DATABASE_NAME).build();
        }
        return INSTANCE;
    }

}
