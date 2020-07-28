package com.example.testmanagement.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Layout;
import android.widget.Button;
import android.widget.ListView;

import com.example.testmanagement.R;
import com.example.testmanagement.service.models.Test;
import com.example.testmanagement.ui.adapters.TestsListViewAdapter;
import com.example.testmanagement.ui.fragments.TestRecyclerFragment;
import com.example.testmanagement.ui.viewModels.TestViewModel;

import java.util.List;

public class ViewTestInforActivity extends AppCompatActivity {


 /*   Layout viewTestListView;*/
    Button delete_bt,addNewTest_bt;
    protected TestViewModel testViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_test_infor);
        testViewModel= ViewModelProviders.of(this).get(TestViewModel.class);

        //show Recycler View
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        TestRecyclerFragment fragment=new TestRecyclerFragment();
        transaction.replace(R.id.testRecyclerFragLayout,fragment);
        transaction.commit();

/*        viewTestListView=findViewById(R.id.testRecyclerFragLayout);
        viewTestListView.setAdapter(testsListViewAdapter);*/

        //button function
        delete_bt=(Button)findViewById(R.id.testListView_delete_bt);
        addNewTest_bt=(Button)findViewById(R.id.testListView_addNewTest_bt);
        addNewTest_bt.setOnClickListener(v->addNewTest());
    }

    //button function method
    private void deleteSelectedTests(){
/*        testViewModel.delete((Test) testsListViewAdapter.getSelectedTests());*/
    }

    private void addNewTest(){
        Intent intent =new Intent(this,TestActivity.class);
        startActivity(intent);
    }
}