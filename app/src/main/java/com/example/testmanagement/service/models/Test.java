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

    public Test() {
    }

    public Test(int testId, int patientId, int nurseId, String bpl, String bph, double temp){
        this._testId=testId;
        this._patientId=patientId;
        this._nurseId=nurseId;
        this._BPL=bpl;
        this._BPH=bph;
        this._temperature=temp;
    }

    public void set_testId(int _testId) {
        this._testId = _testId;
    }

    public void set_patientId(int _patientId) {
        this._patientId = _patientId;
    }

    public void set_nurseId(int _nurseId) {
        this._nurseId = _nurseId;
    }

    public void set_BPL(String _BPL) {
        this._BPL = _BPL;
    }

    public void set_BPH(String _BPH) {
        this._BPH = _BPH;
    }

    public void set_temperature(double _temperature) {
        this._temperature = _temperature;
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
