package com.example.testmanagement.service.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Nurse {
    @PrimaryKey(autoGenerate = true)
    private int _nurseId;
    private String _firstName;
    private String _lastName;
    private String _department;
    private String _password;

    public Nurse(int nurseId,String firstName,String lastName,String department,String password){
        this._nurseId=nurseId;
        this._firstName=firstName;
        this._lastName=lastName;
        this._department=department;
        this._password=password;
    }

    public int get_nurseId() {
        return _nurseId;
    }

    public String get_firstName() {
        return _firstName;
    }

    public String get_lastName() {
        return _lastName;
    }

    public String get_department() {
        return _department;
    }

    public String get_password() {
        return _password;
    }
}
