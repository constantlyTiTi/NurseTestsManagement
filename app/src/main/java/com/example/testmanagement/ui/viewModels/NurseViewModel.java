package com.example.testmanagement.ui.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.testmanagement.data.NurseRepository;
import com.example.testmanagement.service.models.Nurse;

import java.util.List;
import java.util.Optional;

public class NurseViewModel extends AndroidViewModel {

    private LiveData<Long> _insertNurseIdResult;
    private LiveData<Integer> _updateResult;
    private LiveData<List<Nurse>> _getAllNurse;
    private LiveData<Nurse> _getLoginNurse;
    private NurseRepository nurseRepository;
/*    private Long addedNurseID;*/

/*    public Long getAddedNurseID() {
        Log.d("NurseViewModel","NurseViewModel "+nurseRepository.getNurseId());
        return addedNurseID;
    }*/

    public NurseViewModel(@NonNull Application application) {
        super(application);
        nurseRepository=new NurseRepository(application);
        _insertNurseIdResult=nurseRepository.getNurseInsertNurseIdResult();
        _updateResult=nurseRepository.getNurseUpdateResult();
    }
    public void insertNurseAndReturnNurseId(Nurse nurse){
//        long nurseId;
//        nurseRepository.insertNurseAndReturnID(nurse, this);
//        nurseId=nurseRepository.getInsertNurseId();
//        return addedNurseID;
        nurseRepository.insertNurse(nurse);
    }
    public void insertNurse(Nurse nurse){
        nurseRepository.insertNurse(nurse);
    }
    public LiveData<Optional<Nurse>> getLoginNurseInfor(Long nurseId){
        return nurseRepository.getLoginNurseInfor(nurseId);
    }
    public LiveData<List<Nurse>>getAllNurse(){
        return nurseRepository.getNurseList();
    }

    public LiveData<Long> get_insertNurseIdResult() {
        return _insertNurseIdResult;
    }
    public LiveData<Integer> get_updateResult(){
        return _updateResult;
    }

/*    @Override
    public void processInsert(Long id) {
        addedNurseID = id;
    }*/
}
