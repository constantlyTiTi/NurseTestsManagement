package com.example.testmanagement.ui.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.testmanagement.R;
import com.example.testmanagement.service.models.Patient;
import com.example.testmanagement.ui.activities.PatientActivity;
import com.example.testmanagement.ui.adapters.PatientListViewAdapter;
import com.example.testmanagement.ui.viewModels.PatientViewModel;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class PatientListOfNurseFragment extends Fragment {

    private ListView patientListView;
    List<Patient> patients;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_patient_list_of_nurse, container, false);
        patientListView=(ListView)view.findViewById(R.id.patientListOfNurse_ListView);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        PatientViewModel patientViewModel= ViewModelProviders.of(this.getActivity()).get(PatientViewModel.class);
        patientViewModel.getAllPatientsByNurse().observe(this,result->{
            patients=result;
            PatientListViewAdapter patientListViewAdapter=
                    new PatientListViewAdapter(this.getActivity(),patients);
            patientListView.setAdapter(patientListViewAdapter);
        });
    }

}