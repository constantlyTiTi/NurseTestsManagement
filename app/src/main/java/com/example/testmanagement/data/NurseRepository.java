package com.example.testmanagement.data;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.testmanagement.service.models.Nurse;

import java.util.List;
import java.util.Optional;

public class NurseRepository {
    private LiveData<List<Nurse>> _nurseList;
    private MutableLiveData<Integer> _insertResult=new MutableLiveData<>();
    private MutableLiveData<Integer> _updateResult=new MutableLiveData<>();
    private NurseDao nurseDao;

    public NurseRepository(Context context) {
        AppDatabase db=AppDatabase.getInstance(context);
        nurseDao=db.nurseDao();
        nurseDao=db.nurseDao();
        this._nurseList=nurseDao.getAllNurse();
    }

    public LiveData<Optional<Nurse>> getLoginNurseInfor(int nurseId){
        return nurseDao.getLoginNurseInfor(nurseId);
    }
    public void updateLoginNurseInfor(Nurse nurse){
        try{nurseDao.update(nurse);
        _updateResult.postValue(1);}
        catch (Exception e){
            _updateResult.postValue(0);
        }
    }
    public LiveData<List<Nurse>> getNurseList(){return this._nurseList;}
    public void insertNurse(Nurse nurse){asyncInsertNurse(nurse);}
    public LiveData<Integer> getNurseInsertResult(){return _insertResult;}
    public LiveData<Integer> getNurseUpdateResult(){return _updateResult;}
    private void asyncInsertNurse(final Nurse nurse){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{nurseDao.insert(nurse);
                    _insertResult.postValue(1);
            }
                catch (Exception e){
                    _insertResult.postValue(0);
                }
                }
        }).start();
    }
}
