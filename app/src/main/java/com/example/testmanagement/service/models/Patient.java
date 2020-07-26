package com.example.testmanagement.service.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "patient")
public class Patient {
    @PrimaryKey(autoGenerate = true)
     private Long patientId;
    @ColumnInfo(name="firstname")
    private String firstName;
    @ColumnInfo(name="lastName")
    private String lastName;
    @ColumnInfo(name="department")
    private String department;
    @ColumnInfo(name="nurseId")
    private Long nurseId;
    @ColumnInfo(name="room")
    private String room;

    public Patient() {
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNurseId(Long nurseId) {
        this.nurseId = nurseId;
    }

    public void setRoom(String room) {
        this.room = room;
    }
    public Long getPatientId(){
        return this.patientId;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getDepartment(){
        return this.department;
    }
    public Long getNurseId(){
        return this.nurseId;
    }
    public String getRoom(){
        return this.room;
    }
}
