package com.example.testmanagement.ui.activities;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.testmanagement.R;
import com.example.testmanagement.service.models.Patient;
import com.example.testmanagement.ui.adapters.PatientListViewAdapter;
import com.example.testmanagement.ui.fragments.AddPatientFragment;
import com.example.testmanagement.ui.fragments.PatientListOfNurseFragment;
import com.example.testmanagement.ui.viewModels.PatientViewModel;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class PatientActivity extends FragmentActivity {
    private FragmentTransaction mFragmentTransaction;
    private FragmentManager mFragmentManager;
    private Button addNewPatient_bt;
    private PatientListOfNurseFragment patientListOfNurseFragment;
    private AddPatientFragment addPatientFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);
        mFragmentManager = getSupportFragmentManager();
        addNewPatient_bt=(Button)findViewById(R.id.goToAddNewPatient_bt);
//        patientListOfNurseFragment=(PatientListOfNurseFragment)getSupportFragmentManager().findFragmentById(R.id.patientListViewFragment);
        addPatientFragment= new AddPatientFragment();
        patientListOfNurseFragment = new PatientListOfNurseFragment();

        fragmentInitialDisplay();

        addNewPatient_bt.setOnClickListener(v -> addPatientButtonOnClick());

    }

    private void fragmentInitialDisplay(){
        if(!patientListOfNurseFragment.isAdded()){
            mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.add(R.id.patientLayout, patientListOfNurseFragment).commit();
        }
    }

    private void addPatientButtonOnClick(){
        mFragmentTransaction = mFragmentManager.beginTransaction();
        if(!addPatientFragment.isAdded()){
            mFragmentTransaction.add(R.id.patientLayout, addPatientFragment);
        }
        if(addPatientFragment.isDetached()){
//            mFragmentTransaction.replace(R.id.patientLayout,addPatientFragment);
            mFragmentTransaction.attach(addPatientFragment);
            mFragmentTransaction.detach(patientListOfNurseFragment);

        }else{
            mFragmentTransaction.detach(addPatientFragment);
        }
        mFragmentTransaction.commit();
//        getSupportFragmentManager().beginTransaction().add(addPatientFragment,"patientFragment").commit();
    }
}