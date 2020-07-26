package com.example.testmanagement.data;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.testmanagement.service.models.Nurse;

import java.util.List;
import java.util.Optional;

public class NurseRepository {
    private LiveData<List<Nurse>> nurseList;
    private MutableLiveData<Long> insertNurseIdResult=new MutableLiveData<>();
    private MutableLiveData<Integer> updateResult=new MutableLiveData<>();
    private MutableLiveData<Integer> nurseIdResult=new MutableLiveData<>();
    private NurseDao nurseDao;


    private Long nurseId;

    public Long getNurseId() {
        return nurseId;
    }

    public NurseRepository(Context context) {
        AppDatabase db=AppDatabase.getInstance(context);
        nurseDao=db.nurseDao();
        this.nurseList=nurseDao.getAllNurse();
    }

    public LiveData<Optional<Nurse>> getLoginNurseInfor(Long nurseId){
        return nurseDao.getLoginNurseInfor(nurseId);
    }
    public void updateLoginNurseInfor(Nurse nurse){
        try{nurseDao.update(nurse);
        updateResult.postValue(1);}
        catch (Exception e){
            updateResult.postValue(0);
        }
    }
    public LiveData<List<Nurse>> getNurseList(){return this.nurseList;}
    public void insertNurse(Nurse nurse){
        asyncInsertNurse(nurse);
    }
    public LiveData<Long> getNurseInsertNurseIdResult(){return insertNurseIdResult;}
    public LiveData<Integer> getNurseUpdateResult(){return updateResult;}

    private void asyncInsertNurse(final Nurse nurse){
        new Thread(() -> {
            try{
                Long id =nurseDao.insert(nurse);
                insertNurseIdResult.postValue(id);
        }
            catch (Exception e){
                insertNurseIdResult.postValue(-1l);
            }
            }).start();
    }
}
