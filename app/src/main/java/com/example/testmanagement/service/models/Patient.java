package com.example.testmanagement.service.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Patient {
@PrimaryKey(autoGenerate = true)
    private int _patientId;
    private String _firstName;
    private String _lastName;
    private String _department;
    private int _nurseId;
    private String _room;

    public Patient(int patientId, String firstName, String lastName,String department,int nurseId,String room){
        this._patientId=patientId;
        this._firstName=firstName;
        this._lastName=lastName;
        this._department=department;
        this._nurseId=nurseId;
        this._room=room;
    }

    public int get_patientId(){
        return this._patientId;
    }
    public String get_firstName(){
        return this._firstName;
    }
    public String get_lastName(){
        return this._lastName;
    }
    public String get_department(){
        return this._department;
    }
    public int get_nurseId(){
        return this._nurseId;
    }
    public String get_room(){
        return this._room;
    }
}
