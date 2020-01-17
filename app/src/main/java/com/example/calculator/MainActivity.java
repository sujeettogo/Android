package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    Stack<String> input;
    ArrayList<String> post_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input=new Stack<String>();
        post_input=new ArrayList<String>();
        final EditText et_input=(EditText)findViewById(R.id.et_input);
        et_input.setEnabled(false);
        final String[] ops={"c","del","dot","plus","minus","mul","div","percent","open","close","equal","sin","cos","log "};
        TextView t0=(TextView)findViewById(R.id.tv_0);
        TextView t1=(TextView)findViewById(R.id.tv_1);
        TextView t2=(TextView)findViewById(R.id.tv_2);
        TextView t3=(TextView)findViewById(R.id.tv_3);
        TextView t4=(TextView)findViewById(R.id.tv_4);
        TextView t5=(TextView)findViewById(R.id.tv_5);
        TextView t6=(TextView)findViewById(R.id.tv_6);
        TextView t7=(TextView)findViewById(R.id.tv_7);
        TextView t8=(TextView)findViewById(R.id.tv_8);
        TextView t9=(TextView)findViewById(R.id.tv_9);
        TextView c=(TextView)findViewById(R.id.tv_c);
        TextView del=(TextView)findViewById(R.id.tv_del);
        TextView sin=(TextView)findViewById(R.id.tv_sin);
        TextView cos=(TextView)findViewById(R.id.tv_cos);
        TextView log=(TextView)findViewById(R.id.tv_log);
        TextView lp=(TextView)findViewById(R.id.tv_open);
        TextView rp=(TextView)findViewById(R.id.tv_close);
        TextView pl=(TextView)findViewById(R.id.tv_plus);
        TextView mi=(TextView)findViewById(R.id.tv_minus);
        TextView mul=(TextView)findViewById(R.id.tv_mul);
        TextView div=(TextView)findViewById(R.id.tv_div);
        final TextView eq=(TextView)findViewById(R.id.tv_equal);
        TextView pc=(TextView)findViewById(R.id.tv_percent);
        TextView dot=(TextView)findViewById(R.id.tv_dot);
        t0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_input.setText(et_input.getText()+"0");
            }
        });
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_input.setText(et_input.getText()+"1");
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_input.setText(et_input.getText()+"2");
            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_input.setText(et_input.getText()+"3");
            }
        });
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_input.setText(et_input.getText()+"4");
            }
        });
        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_input.setText(et_input.getText()+"5");
            }
        });
        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_input.setText(et_input.getText()+"6");
            }
        });
        t7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_input.setText(et_input.getText()+"7");
            }
        });
        t8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_input.setText(et_input.getText()+"8");
            }
        });
        t9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_input.setText(et_input.getText()+"9");
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_input.setText("");
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str=et_input.getText().toString();
                if (str != null && str.length() > 0)
                    et_input.setText(str.substring(0, str.length() - 1));
            }
        });
        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_input.setText(et_input.getText()+"sin");
            }
        });
        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_input.setText(et_input.getText()+"cos");
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_input.setText(et_input.getText()+"log");
            }
        });
        lp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_input.setText(et_input.getText()+"(");
            }
        });
        rp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_input.setText(et_input.getText()+")");
            }
        });
        pl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_input.setText(et_input.getText()+"+");
            }
        });
        mi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_input.setText(et_input.getText()+"-");
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_input.setText(et_input.getText()+"x");

            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_input.setText(et_input.getText()+"/");

            }
        });

        pc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_input.setText(et_input.getText()+"%");
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_input.setText(et_input.getText()+".");
            }
        });
        eq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String equation=et_input.getText().toString();

                Log.e("equation",equation);
                if(check_valid(equation)==1)
                {
                    if(equation.startsWith("sin") || equation.startsWith("cos") || equation.startsWith("log")) {

                           String x=trig_calc(equation);
                           if(x.contains("E"))
                                et_input.setText("0.0");
                           else
                               et_input.setText(x);
                    }
                    else {
                        Log.e("equation", "postfix");
                        postFix(equation);
                        calc();
                        et_input.setText(input.peek());
                    }

                }
                else
                    et_input.setText("Invalid");

            }
        });
        //et_input.setSelection(et_input.getEditableText().length());
    }
    private void postFix(String ip){
        makeEmpty();
        post_input.clear();
        ip = ip.replaceAll("[\\+|\\-|x|\\/|\\(|\\)|\\%]", ",$0,");
        ip = ip.replaceAll(",,", ",");
        String sep[]=ip.split(",");
        for(int i=0;i<sep.length;i++){
            if(sep[i].equals("x") || sep[i].equals("(") || sep[i].equals("+") || sep[i].equals("-") ||
                    sep[i].equals("/") || sep[i].equals("%")) {

                    if(input.isEmpty())
                        input.push(sep[i]);
                     else if ((input.peek().equals("x") || input.peek().equals("/")) && (sep[i].equals("+") || sep[i].equals("-")
                    || sep[i].equals("x") || sep[i].equals("%"))) {
                        post_input.add(input.pop());
                        input.push(sep[i]);
                    }
                     else if ((input.peek().equals("+") || input.peek().equals("-")) && (sep[i].equals("+") || sep[i].equals("-"))){
                    post_input.add(input.pop());
                    input.push(sep[i]);
                    }
                     else {
                        input.push(sep[i]);
                    }
            }

            else if(sep[i].equals(")")){
                while(!input.peek().equals("("))
                    post_input.add(input.pop());
                input.pop();
            }
            else
                post_input.add(sep[i]);
        }
        while(!input.isEmpty())
            post_input.add(input.pop());
        Log.e("postfix",post_input.toString());
    }
    private void calc(){
        makeEmpty();
        /*
        post_input.clear();
        post_input.add("5");
        post_input.add("5");
        post_input.add("/");
        post_input.add("5");
        post_input.add("+");
         */
        for(String num:post_input){
            if(num.equals("x") || num.equals("+") || num.equals("-") || num.equals("/") ||
                    num.equals("%")){
                String va1_a=input.pop();
                String va1_b=input.pop();
                float a,b;
                try {
                    a = Integer.parseInt(va1_a);
                }
                catch (Exception e){
                    a = Float.parseFloat(va1_a);
                }
                try {
                    b = Integer.parseInt(va1_b);
                }
                catch (Exception e){
                    b = Float.parseFloat(va1_b);
                }
                switch (num){
                    case "+":
                        input.push(Float.toString(b+a));
                        break;
                    case "-":
                        input.push(Float.toString(b-a));
                        break;
                    case "x":
                        input.push(Float.toString(b*a));
                        break;
                    case "/":
                        input.push(Float.toString(b/a));
                        break;
                    case "%":
                        input.push(Float.toString(b%a));
                        break;
                }
            }
            else
                input.push(num);
        }
    }
    private String  trig_calc(String ip){
        double val = Double.parseDouble(ip.substring(3));
        Log.e("trig",Double.toString(val));

        if(ip.startsWith("sin")) {
            double value=(Math.sin(Math.toRadians(val)));
           // Log.e("trig",Double.toString(Math.sin(Math.toRadians(val))));
            return Double.toString(value);
        }
        else if(ip.startsWith("cos")) {
            double value=(Math.cos(Math.toRadians(val)));
            return Double.toString(value);
        }
        else if(ip.startsWith("log")) {
            double value=(Math.log10((val)));
            return Double.toString(value);
        }
        else
            return "Invalid";
    }


    private void makeEmpty(){
        while (!input.isEmpty())
            input.pop();
    }

    private int check_valid(String ip){
        int opc=0;
        int cc=0;
        int ob=0;
        int cb=0;
        ip = ip.replaceAll("[\\+|\\-|x|\\/|\\(|\\)|\\%]", ",$0,");
        ip = ip.replaceAll(",,", ",");
        String sep[]=ip.split(",");
        for(int i=0;i<sep.length;i++) {
            if (sep[i].equals("x") || sep[i].equals("+") || sep[i].equals("-") ||
                    sep[i].equals("/") || sep[i].equals("%")) {
                    opc=opc+1;
            }
            else if (sep[i].equals("("))
                ob=ob+1;
           else if (sep[i].equals(")"))
               cb=cb+1;
           else if (sep[i].matches("\\d+") || sep[i].matches("\\d+\\.\\d+"))
               cc=cc+1;
        }
        Log.e("opc,cc", Integer.toString(opc) + Integer.toString(cc));
        if((cc-1==opc && ob==cb)||(cc==0 && opc==0) )
        {
            return 1;
        }
        else {
            return 0;
        }
    }
}

