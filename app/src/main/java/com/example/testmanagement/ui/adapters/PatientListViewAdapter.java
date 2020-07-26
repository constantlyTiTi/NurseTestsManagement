package com.example.testmanagement.ui.adapters;

import android.app.Activity;
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
    private LinearLayout editViewButtonLayout;

    private Activity context;

    private List<Patient> patients;

    public PatientListViewAdapter(@NonNull Activity context, @NonNull List<Patient> objects) {
        super(context, R.layout.paitent_listview, objects);
        objects.add(0,null);
        this.patients=objects;
        this.context=context;
    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater=this.context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.paitent_listview, null,true);
        paitentId_tv=(TextView)rowView.findViewById(R.id.patientId_listView_tv);
        patientFirstName_tv=(TextView)rowView.findViewById(R.id.patientFirstName_listView_tv);
        patientLastName_tv=(TextView)rowView.findViewById(R.id.patientLastName_listView_tv);
        editViewButtonLayout=(LinearLayout)rowView.findViewById(R.id.editViewbtLayout_listView);
        if(position!=0){
            if(editViewButtonLayout!=null){
                Button editViewButton=new Button(this.context);
                editViewButton.setText(R.string.patientListViewEditView);
                editViewButtonLayout.addView(editViewButton);
            }
            paitentId_tv.setText(patients.get(position).getPatientId().toString());
            patientFirstName_tv.setText(patients.get(position).getFirstName());
            patientLastName_tv.setText(patients.get(position).getLastName());}
        else {
/*            TextView editViewTextView=new TextView(this.context);
            editViewButtonLayout.addView(editViewTextView);
            editViewTextView.setText(R.string.patientListViewEditView);
            editViewTextView.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
            editViewTextView.setHeight(LinearLayout.LayoutParams.MATCH_PARENT);
            editViewTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            editViewTextView.setTextSize(14);*/
            patientFirstName_tv.setText(R.string.patientListViewPatientFN);
            patientLastName_tv.setText(R.string.patientListViewPatientLN);
            paitentId_tv.setText(R.string.patientListViewPatientId);
        }
        return rowView;
    }

}
