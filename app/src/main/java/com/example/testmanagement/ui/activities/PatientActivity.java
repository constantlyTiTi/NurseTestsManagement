package com.example.testmanagement.ui.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.testmanagement.R;
import com.example.testmanagement.ui.fragments.AddPatientFragment;
import com.example.testmanagement.ui.fragments.PatientListOfNurseFragment;
import com.example.testmanagement.ui.viewModels.PatientViewModel;

public class PatientActivity extends FragmentActivity {
//    ConstraintLayout mConstraintLayout;
    private FragmentTransaction mFragmentTransaction;
    private FragmentManager mFragmentManager;
    private Button addNewPatient_bt;
    private PatientListOfNurseFragment patientListOfNurseFragment;
    private AddPatientFragment addPatientFragment;
    PatientViewModel patientViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);
        mFragmentManager = getSupportFragmentManager();
        addNewPatient_bt=(Button)findViewById(R.id.goToAddNewPatient_bt);
        patientListOfNurseFragment = new PatientListOfNurseFragment();
        addPatientFragment = new AddPatientFragment();
//        patientListOfNurseFragment=(PatientListOfNurseFragment)getSupportFragmentManager().findFragmentById(R.id.patientListViewFragment);
//        addPatientFragment=(AddPatientFragment)getSupportFragmentManager().findFragmentById(R.id.addNewPatientFragment);

        fragmentInitialDisplay();

        addNewPatient_bt.setOnClickListener(v -> addPatientButtonOnClick());

        patientViewModel= ViewModelProviders.of(this).get(PatientViewModel.class);
        patientViewModel.getInsertPatientId().observe(this,pid -> {
            if(pid>-1){
                mFragmentManager.beginTransaction()
                        .attach(patientListOfNurseFragment)
                        .detach(addPatientFragment)
                        .commit();
                addNewPatient_bt.setVisibility(View.VISIBLE);
            }
        });
    }

    private void fragmentInitialDisplay(){
        if(!patientListOfNurseFragment.isVisible()){
            mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.add(R.id.patientActLayout, patientListOfNurseFragment)
                    .commit();
        }
//        mFragmentTransaction
//                .detach(addPatientFragment)
//                .add(patientListOfNurseFragment,"patientFragment")
//                .remove(addPatientFragment)
//                .commit();
//        getSupportFragmentManager().beginTransaction()..commit();
/*        fragmentTransaction.commit();*/
    }

    private void addPatientButtonOnClick(){
        mFragmentTransaction = mFragmentManager.beginTransaction();
        if(!addPatientFragment.isAdded()){
            mFragmentTransaction.add(R.id.patientActLayout, addPatientFragment);
        }
        mFragmentTransaction
                .attach(addPatientFragment)
                .detach(patientListOfNurseFragment)
                .addToBackStack(null)
                .commit();
        addNewPatient_bt.setVisibility(View.GONE);
    }
}