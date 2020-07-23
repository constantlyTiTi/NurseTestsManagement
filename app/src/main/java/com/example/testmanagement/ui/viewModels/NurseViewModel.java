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

    private LiveData<Integer> _insertResult;
    private LiveData<Integer> _updateResult;
    private LiveData<List<Nurse>> _getAllNurse;
    private LiveData<Nurse> _getLoginNurse;
    private NurseRepository nurseRepository;
    public NurseViewModel(@NonNull Application application) {
        super(application);
        nurseRepository=new NurseRepository(application);
    }
    public void insertNurse(Nurse nurse){
        nurseRepository.insertNurse(nurse);
    }
    public LiveData<Optional<Nurse>> getLoginNurseInfor(int nurseId){
        return nurseRepository.getLoginNurseInfor(nurseId);
    }
    public LiveData<List<Nurse>>getAllNurse(){
        return nurseRepository.getNurseList();
    }
}
