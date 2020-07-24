package com.example.testmanagement.ui.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.testmanagement.R;
import com.example.testmanagement.service.models.Patient;

import java.util.List;

public class PatientListViewAdapter extends ArrayAdapter<Patient> {

    private TextView paitentId_tv;
    private TextView patientFirstName_tv;
    private TextView patientLastName_tv;
    private LinearLayout updateButtonLayout;
    private LinearLayout deleteButtonLayout;
    private Activity context;

    private List<Patient> patients;

    public PatientListViewAdapter(@NonNull Activity context, @NonNull List<Patient> objects) {
        super(context, R.layout.paitent_listview, objects);
        this.patients=objects;
        this.context=context;
    }

    public View getView(int position, View view, ViewGroup parent){
        Button updateButton=new Button(this.context);
        Button deleteButton=new Button(this.context);

        LayoutInflater inflater=this.context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.paitent_listview, null,true);
        paitentId_tv=(TextView)rowView.findViewById(R.id.patientId_listView_tv);
        patientFirstName_tv=(TextView)rowView.findViewById(R.id.patientFirstName_listView_tv);
        patientLastName_tv=(TextView)rowView.findViewById(R.id.patientFirstName_listView_tv);
        updateButtonLayout=(LinearLayout)rowView.findViewById(R.id.updatebtLayout_listView);
        deleteButtonLayout=(LinearLayout)rowView.findViewById(R.id.deletebtLayout_listView);
        if(updateButtonLayout!=null){
            updateButtonLayout.addView(updateButton);
        }
        if(deleteButtonLayout!=null){
            deleteButtonLayout.addView(deleteButton);
        }
        return rowView;
    }

}
