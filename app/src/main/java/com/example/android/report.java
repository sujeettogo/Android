package com.example.android;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class report extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report);

        TextView t1=(TextView)findViewById(R.id.t1);
        TextView t2=(TextView)findViewById(R.id.t2);
        TextView t3=(TextView)findViewById(R.id.t3);
        TextView t4=(TextView)findViewById(R.id.t4);
        TextView t5=(TextView)findViewById(R.id.t5);
        TextView t6=(TextView)findViewById(R.id.t6);
        TextView t7=(TextView)findViewById(R.id.t7);
        TextView t8=(TextView)findViewById(R.id.t8);
        TextView t9=(TextView)findViewById(R.id.t9);

        t1.setText("Name: "+getIntent().getExtras().getString("name"));
        t2.setText("Address: "+getIntent().getExtras().getString("address"));
        t3.setText("Age: "+getIntent().getExtras().getString("age"));
        t4.setText("Dob: "+getIntent().getExtras().getString("dob"));
        Boolean r1=getIntent().getBooleanExtra("radio1",false);
        Boolean r2=getIntent().getBooleanExtra("radio2",false);
        if (r1.equals(true) || r2.equals(true)) {
            if (r1.equals(true))
                t5.setText("Gender: "+getIntent().getExtras().getString("radio1v"));
            else
                t5.setText("Gender: "+getIntent().getExtras().getString("radio2v"));
        }
        else
            t5.setText("Gender: Unselected");
        //t5.setText("Gender: "+getIntent().getExtras().getString("radio"));
        t6.setText("Marital status: "+getIntent().getExtras().getString("spinner"));
        t7.setText("Phone: "+getIntent().getExtras().getString("phone"));
        t8.setText("Time: "+getIntent().getExtras().getString("time"));
        Boolean cb1=getIntent().getBooleanExtra("cb1p",false);
        Boolean cb2=getIntent().getBooleanExtra("cb2p",false);
        if (cb1.equals(true) && cb2.equals(true))
            t9.setText("Addiction: "+getIntent().getExtras().getString("cb1v") +" & "+getIntent().getExtras().getString("cb2v"));
        else if(cb1.equals(true) && !cb2.equals(true))
            t9.setText("Addiction: "+getIntent().getExtras().getString("cb1v")  );
        else if(!cb1.equals(true) && cb2.equals(true))
            t9.setText("Addiction: "+getIntent().getExtras().getString("cb2v")  );
        else
            t9.setText("Addiction: None");

    }

}
