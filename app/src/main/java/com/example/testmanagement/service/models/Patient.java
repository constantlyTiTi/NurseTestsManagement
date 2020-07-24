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

    public Patient() {
    }

    public void set_patientId(int _patientId) {
        this._patientId = _patientId;
    }

    public void set_department(String _department) {
        this._department = _department;
    }

    public void set_firstName(String _firstName) {
        this._firstName = _firstName;
    }

    public void set_lastName(String _lastName) {
        this._lastName = _lastName;
    }

    public void set_nurseId(int _nurseId) {
        this._nurseId = _nurseId;
    }

    public void set_room(String _room) {
        this._room = _room;
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
