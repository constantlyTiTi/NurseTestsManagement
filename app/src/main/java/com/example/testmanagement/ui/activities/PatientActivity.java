package com.example.testmanagement.ui.activities;

import androidx.fragment.app.FragmentActivity;
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
    private Button addNewPatient_bt;
    private PatientListOfNurseFragment patientListOfNurseFragment;
    private AddPatientFragment addPatientFragment;
    private FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        addNewPatient_bt=(Button)findViewById(R.id.addNewPatient_bt);
        patientListOfNurseFragment=(PatientListOfNurseFragment)getSupportFragmentManager().findFragmentById(R.id.patientListViewFragment);
        addPatientFragment=(AddPatientFragment)getSupportFragmentManager().findFragmentById(R.id.addNewPatientFragment);



        fragmentInitialDisplay();

        addNewPatient_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPatientButtonOnClick();
            }
        });

    }

    private void fragmentInitialDisplay(){
        fragmentTransaction=getSupportFragmentManager().beginTransaction();
        if(patientListOfNurseFragment.isHidden()){fragmentTransaction.show(patientListOfNurseFragment);}
        if(!addPatientFragment.isHidden()){fragmentTransaction.hide(addPatientFragment);}
    }

    private void addPatientButtonOnClick(){
        fragmentTransaction.hide(patientListOfNurseFragment);
        fragmentTransaction.show(addPatientFragment);
    }
}