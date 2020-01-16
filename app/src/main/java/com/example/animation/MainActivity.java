package com.example.animation;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    int x=0;
    int y=0;
    int z=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt_paint=findViewById(R.id.bt_paint);
        Button bt_animate=findViewById(R.id.bt_animate);
        final Button bt_car=findViewById(R.id.bt_car);
        Button bt_forward=findViewById(R.id.bt_forward);
        Button bt_backward=findViewById(R.id.bt_backward);
        final ImageView iv_animate=findViewById(R.id.iv_animate);
        bt_paint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //paint p=new paint(MainActivity.class);
                //setContentView(p);
                if(z%3==0) {
                    iv_animate.setBackgroundResource(R.drawable.car);
                    z=z+1;
                }
               else if(z%3==1)
                {
                    iv_animate.setBackgroundResource(R.drawable.car2);
                    z=z+1;
                }
               else if (z%3==2)
                {
                    iv_animate.setBackgroundResource(R.drawable.car3);
                    z=z+1;
                }


            }
        });
        bt_animate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(x%3==0) {
                    iv_animate.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_in));
                    x = x + 1;
                }
                else if (x%3==1) {
                    iv_animate.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in));
                    x=x+1;
                }
                else if(x%3==2) {
                    iv_animate.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in));
                    x = x + 1;
                }
            }
        });
        bt_car.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Bitmap b=Bitmap.createBitmap(720,1280, Bitmap.Config.ARGB_8888);
                iv_animate.setBackgroundDrawable(new BitmapDrawable(b));
                Canvas canvas=new Canvas(b);
                if(y%4==0) {
                    Paint p=new Paint();
                    p.setStrokeWidth(10);
                    p.setColor(Color.GREEN);
                    RectF r = new RectF(100, 100, 500, 500);
                    canvas.drawRect(r,p);

                    y=y+1;
                }
               else if (y%4==1) {
                    Paint p=new Paint();
                    p.setStrokeWidth(10);
                    p.setColor(Color.RED);
                    canvas.drawArc(200, 200, 600, 600, 20, 115, true, p);
                    y=y+1;
                }
              else  if (y%4==2) {
                    Paint p=new Paint();
                    p.setStrokeWidth(10);
                    p.setColor(Color.BLACK);
                    canvas.drawLine(200, 200, 600, 600, p);
                    y=y+1;
                }
                else if (y%4==3) {
                    Paint p=new Paint();
                    p.setStrokeWidth(10);
                    p.setColor(Color.BLUE);
                    canvas.drawCircle(400, 400, 200, p);
                    y=y+1;
                }

            }
        });
        bt_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_animate.animate().translationXBy(300f).setDuration(600);
            }
        });
        bt_backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_animate.animate().translationXBy(-300f).setDuration(600);
            }
        });
    }
}

