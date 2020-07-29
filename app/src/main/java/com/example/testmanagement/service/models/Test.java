package com.example.testmanagement.service.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "Test",
        foreignKeys = {@ForeignKey(entity=Patient.class,
                        parentColumns ="patientId",
                        childColumns = "patientId")})
public class Test {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="testId")
    private Long _testId;
    @ColumnInfo(name="patientId")
    private Long _patientId;
    @ColumnInfo(name="nurseId")
    private Long _nurseId;
    @ColumnInfo(name="BPL")
    private String _BPL;
    @ColumnInfo(name="BPH")
    private String _BPH;
    @ColumnInfo(name="temperature")
    private double _temperature;
    @ColumnInfo(name="cbc")
    private double _cbc;

    public Test() {
    }
/*
    public Test(int testId, int patientId, int nurseId, String bpl, String bph, double temp){
        this._testId=testId;
        this._patientId=patientId;
        this._nurseId=nurseId;
        this._BPL=bpl;
        this._BPH=bph;
        this._temperature=temp;
    }*/

    public void set_testId(Long _testId) {
        this._testId = _testId;
    }

    public void set_patientId(Long _patientId) {
        this._patientId = _patientId;
    }

    public void set_nurseId(Long _nurseId) {
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

    public void set_cbc(double _cbc){this._cbc=_cbc;}

    public Long get_testId(){
        return this._testId;
    }
    public Long get_patientId(){
        return this._patientId;
    }

    public Long get_nurseId() {
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

    public double get_cbc(){return this._cbc;}

}
