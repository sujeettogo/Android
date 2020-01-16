package com.example.hms2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class report extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        final TextView t1=(TextView)findViewById(R.id.t1);
        final TextView t2=(TextView)findViewById(R.id.t2);
        final TextView t3=(TextView)findViewById(R.id.t3);
        final TextView t4=(TextView)findViewById(R.id.t4);
        final TextView t5=(TextView)findViewById(R.id.t5);
        final TextView t6=(TextView)findViewById(R.id.t6);


        t1.setText(getIntent().getExtras().getString("name"));
        t2.setText(getIntent().getExtras().getString("dob"));
        t5.setText(getIntent().getExtras().getString("phone"));
        t4.setText(getIntent().getExtras().getString("spinner"));

        Boolean r1=getIntent().getBooleanExtra("radio1",false);
        Boolean r2=getIntent().getBooleanExtra("radio2",false);
        if (r1.equals(true) || r2.equals(true)) {
            if (r1.equals(true))
                t3.setText(getIntent().getExtras().getString("radio1v"));
            else
                t3.setText(getIntent().getExtras().getString("radio2v"));
        }
        else
            t3.setText("Unselected");

        Boolean cb1=getIntent().getBooleanExtra("cb1p",false);
        Boolean cb2=getIntent().getBooleanExtra("cb2p",false);
        if (cb1.equals(true) && cb2.equals(true))
            t6.setText(getIntent().getExtras().getString("cb1v") +" & "+getIntent().getExtras().getString("cb2v"));
        else if(cb1.equals(true) && !cb2.equals(true))
            t6.setText(getIntent().getExtras().getString("cb1v")  );
        else if(!cb1.equals(true) && cb2.equals(true))
            t6.setText(getIntent().getExtras().getString("cb2v")  );
        else
            t6.setText("None");
    }
}
