package com.example.testmanagement.ui.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.testmanagement.R;
import com.example.testmanagement.service.models.Test;
import com.example.testmanagement.ui.adapters.TestsRecyclerViewAdapter;
import com.example.testmanagement.ui.viewModels.TestViewModel;

import java.util.List;

public class TestRecyclerFragment extends Fragment {

    private static final String TAG = "RecyclerViewFragment";

    protected TestsRecyclerViewAdapter testsListViewAdapter;
    protected List<Test> getTestsByPatientId;
    protected TestViewModel testViewModel;
    protected SharedPreferences getSelectedPatientIdPre;
    protected String selectedPatientIdString;
    protected Long selectedPatientId;
    protected RecyclerView testRecyclerView;
    protected RecyclerView.LayoutManager mLayoutManager;
    Button selectedDelete_bt;


    public TestRecyclerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_test_recycler, container, false);
        rootView.setTag(TAG);
        testRecyclerView=(RecyclerView)rootView.findViewById(R.id.testRecyclerView);

        setRecyclerViewLayoutManager();
        selectedDelete_bt=(Button)rootView.findViewById(R.id.testRecyclerView_delete_bt);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        mLayoutManager= new LinearLayoutManager(this.getActivity());
        testViewModel= ViewModelProviders.of(this).get(TestViewModel.class);
        //retrieve selected patient id
        getSelectedPatientIdPre=this.getActivity().getSharedPreferences(
                String.valueOf(R.string.patientSharedPreference),this.getActivity().MODE_PRIVATE);
        selectedPatientIdString=getSelectedPatientIdPre
                .getString(String.valueOf(R.string.selectedPatientId),selectedPatientIdString);
        selectedPatientId=Long.parseLong(selectedPatientIdString);

        //retrieve tests by patient id;
        testViewModel.getTestsByPatient(selectedPatientId).observe(this,result->{
            getTestsByPatientId=result;
            testsListViewAdapter=new TestsRecyclerViewAdapter(this.getActivity(),getTestsByPatientId);
            testRecyclerView.setAdapter(testsListViewAdapter);

            selectedDelete_bt.setOnClickListener(v->{
                List<Test> selectedItems=testsListViewAdapter.getSelectedDeleteTests();
                testViewModel.delete(selectedItems.toArray(new Test [selectedItems.size()]));
            });
        });

    }

    public void setRecyclerViewLayoutManager() {
        int scrollPosition = 0;

        // If a layout manager has already been set, get current scroll position.
        if (testRecyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) testRecyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }

                mLayoutManager = new LinearLayoutManager(getActivity());

        testRecyclerView.setLayoutManager(mLayoutManager);
        testRecyclerView.scrollToPosition(scrollPosition);
    }
}