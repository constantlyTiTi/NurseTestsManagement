package com.example.testmanagement.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.testmanagement.R;
import com.example.testmanagement.ui.fragments.TestRecyclerFragment;
import com.example.testmanagement.ui.viewModels.TestViewModel;

public class ViewTestInforActivity extends AppCompatActivity {


 /*   Layout viewTestListView;*/
    Button delete_bt,addNewTest_bt;
/*    protected TestViewModel testViewModel;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_test_infor);
/*        testViewModel= ViewModelProviders.of(this).get(TestViewModel.class);*/

        //show Recycler View
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        TestRecyclerFragment fragment=new TestRecyclerFragment();
        transaction.replace(R.id.testRecyclerFragLayout,fragment);
        transaction.commit();

        //button function
        addNewTest_bt=(Button)findViewById(R.id.testListView_addNewTest_bt);
        addNewTest_bt.setOnClickListener(v->addNewTest());
    }

    private void addNewTest(){
        Intent intent =new Intent(this,TestActivity.class);
        startActivity(intent);
    }
}