package com.example.testmanagement.service.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Test {
    @PrimaryKey(autoGenerate = true)
    private int _testId;
    private int _patientId;
    private int _nurseId;
    private String _BPL;
    private String _BPH;
    private double _temperature;

    public Test(int testId,int patientId,int nurseId, String bpl,String bph,double temp){
        this._testId=testId;
        this._patientId=patientId;
        this._nurseId=nurseId;
        this._BPL=bpl;
        this._BPH=bph;
        this._temperature=temp;
    }

    public int get_testId(){
        return this._testId;
    }
    public int get_patientId(){
        return this._patientId;
    }

    public int get_nurseId() {
        return _nurseId;
    }

    public String get_BPL() {
        return _BPL;
    }

    public String get_BPH() {
        return _BPH;
    }

    public double get_temperature() {
        return _temperature;
    }
}
