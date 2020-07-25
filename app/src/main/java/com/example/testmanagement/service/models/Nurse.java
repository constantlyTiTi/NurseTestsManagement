package com.example.testmanagement.service.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "nurse")
public class Nurse {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="nurseId")
    private int _nurseId;
    @ColumnInfo(name="firstName")
    private String _firstName;
    @ColumnInfo(name="lastName")
    private String _lastName;
    @ColumnInfo(name="department")
    private String _department;
    @ColumnInfo(name="Password")
    private String _password;

    public Nurse() {
    }

/*    public Nurse(int nurseId,String firstName,String lastName,String department,String password){
        this._nurseId=nurseId;
        this._firstName=firstName;
        this._lastName=lastName;
        this._department=department;
        this._password=password;
    }*/

    public void set_nurseId(int _nurseId) {
        this._nurseId = _nurseId;
    }

    public void set_firstName(String _firstName) {
        this._firstName = _firstName;
    }

    public void set_lastName(String _lastName) {
        this._lastName = _lastName;
    }

    public void set_department(String _department) {
        this._department = _department;
    }

    public void set_password(String _password) {
        this._password = _password;
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
