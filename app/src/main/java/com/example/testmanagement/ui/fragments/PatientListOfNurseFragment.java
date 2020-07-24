package com.example.testmanagement.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testmanagement.R;
import com.example.testmanagement.ui.adapters.PatientListViewAdapter;
import com.example.testmanagement.ui.viewModels.PatientViewModel;

import java.util.stream.Collectors;

public class PatientListOfNurseFragment extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_patient_list_of_nurse, container, false);
    }

    public void showFragment(){
        PatientViewModel patientViewModel= ViewModelProviders.of(this).get(PatientViewModel.class);

        PatientListViewAdapter patientListViewAdapter=
                new PatientListViewAdapter(getActivity(),patientViewModel.getAllPatientsByNurse().getValue().collect(Collectors.toList()));
    }
}