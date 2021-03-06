package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.util.Calendar;

import javax.xml.parsers.FactoryConfigurationError;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class MainActivity extends AppCompatActivity {
    Calendar c;
    DatePickerDialog dpd;
    TimePickerDialog tpd;
    TimePicker tp;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner spin =(Spinner)findViewById(R.id.spin);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.marital, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        final EditText e1 =(EditText)findViewById(R.id.e1);
        final EditText e2 =(EditText)findViewById(R.id.e2);
        final EditText e3 =(EditText)findViewById(R.id.e3);
        final EditText e4 =(EditText)findViewById(R.id.e4);
        final EditText e5 =(EditText)findViewById(R.id.e5);
        final EditText e6 =(EditText)findViewById(R.id.e6);
       // e5.setEnabled(false);
        e5.setFocusable(FALSE);
        e5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                int day=c.get(Calendar.DAY_OF_MONTH);
                int month=c.get(Calendar.MONTH);
                int year=c.get(Calendar.YEAR);

                dpd=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int myear, int mmonth, int mdayOfMonth) {
                        e5.setText(mdayOfMonth + "/" +(mmonth+1) + "/" + myear);
                    }
                },day,month,year);
                dpd.setTitle("Select Date");
                dpd.show();

            }
        });
        e6.setFocusable(FALSE);
        e6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c=Calendar.getInstance();
                int hour=c.get(Calendar.HOUR_OF_DAY);
                int minute=c.get(Calendar.YEAR);
                tpd=new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int thourOfDay, int tminute) {
                        if(thourOfDay<12 && thourOfDay!=0)
                            e6.setText(thourOfDay + ":" +(tminute<10? "0":"")+tminute+" AM");

                        else if (thourOfDay==0)
                            e6.setText((thourOfDay+12) + ":" + (tminute<10? "0":"")+tminute +" AM");

                        else if(thourOfDay==12)
                            e6.setText((thourOfDay) + ":" + (tminute<10? "0":"")+tminute +" PM");
                        else
                            e6.setText((thourOfDay-12) + ":" + (tminute<10? "0":"")+tminute +" PM");
                    }
                },hour,minute,FALSE);
                tpd.setTitle("Select Time");
                tpd.show();
            }
        });
        final RadioGroup rg=(RadioGroup)findViewById(R.id.rg);
        final RadioButton r1=(RadioButton)findViewById(R.id.r1);
        final RadioButton r2=(RadioButton)findViewById(R.id.r2);

        final CheckBox cb1=(CheckBox)findViewById(R.id.cb1);
        final CheckBox cb2=(CheckBox)findViewById(R.id.cb2);

        final Button reset=(Button)findViewById(R.id.resetb);
        final Button submit=(Button)findViewById(R.id.submitb);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText("");
                e2.setText("");
                e3.setText("");
                e4.setText("");
                e5.setText("");
                e6.setText("");
                r1.setChecked(FALSE);
                r2.setChecked(FALSE);
                cb1.setChecked(FALSE);
                cb2.setChecked(FALSE);
                spin.setSelection(0);

            }
        });
        r1.setId(1);
        r2.setId(2);
        Log.e("radio button", String.valueOf(rg.getCheckedRadioButtonId()));
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(MainActivity.this,report.class);
                i1.putExtra("name",e1.getText().toString());
                i1.putExtra("address",e3.getText().toString());
                i1.putExtra("age",e2.getText().toString());
                i1.putExtra("dob",e5.getText().toString());
                i1.putExtra("phone",e4.getText().toString());
                i1.putExtra("time",e6.getText().toString());
                i1.putExtra("spinner",spin.getSelectedItem().toString());
                i1.putExtra("radio1",r1.isChecked());
                i1.putExtra("radio2",r2.isChecked());
                i1.putExtra("radio1v",r1.getText().toString());
                i1.putExtra("radio2v",r2.getText().toString());
                i1.putExtra("cb1p",cb1.isChecked());
                i1.putExtra("cb2p",cb2.isChecked());
             //   if (cb1.isChecked())
                i1.putExtra("cb1v",cb1.getText().toString());
                //Log.e("cb1",cb1.getText().toString());
               // if(cb2.isChecked())
                i1.putExtra("cb2v",cb2.getText().toString());
                startActivity(i1);
                finish();
            }
        });

    }
}
