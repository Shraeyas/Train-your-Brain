package com.shraeyas.trainyourbrain;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    Integer b1;
    int sc=0,q=0,x=0;
    long time=10;
    long shr;
    TextView tv;// = (TextView)findViewById(R.id.timer);

    CountDownTimer ct = new CountDownTimer(time*1000, 1000)
    {
        @Override
        public void onTick(long l)
        {
            time = l;

            tv = (TextView)findViewById(R.id.timer);
            tv.setText(String.valueOf(l/1000));
        }

        @Override
        public void onFinish()
        {
            setContentView(R.layout.gameover);
            TextView fsc = (TextView)findViewById(R.id.fscore);
            fsc.setText(String.valueOf((sc/q)*100));
        }
    };

    void playagain(View view)
    {
        sc=0;
        q=0;
        //time = 20;
        x=0;

        /*setContentView(R.layout.activity_main);

        TextView score = (TextView)findViewById(R.id.score);
        score.setText(String.valueOf(sc)+"/"+String.valueOf(q));

        TextView timer = (TextView)findViewById(R.id.timer);
        timer.setText(String.valueOf(20));*/

        //setContentView(R.layout.activity_main);

        creategame(view);
    }

    void check(View view)
    {

        TextView click = (TextView)view;

        //Log.i("Random",String.valueOf(click.getTag()));
        //Log.i("Random",Integer.toString(b1-1));

        if(Integer.parseInt((click.getTag()).toString()) == b1)
        {
            sc++;

            ct.start();
            //ct.cancel();
            //time+=5;

            //ct.onTick(time);
            //ct.start();
            //ct.start();
            //ct.crea();
            //count();

            Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
            //q++;
        }

        else
        {
            Toast.makeText(MainActivity.this, "Incorrect!", Toast.LENGTH_SHORT).show();
        }

        q++;

        creategame(view);
    }

    void creategame(View view)
    {

        //ct.onTick(time);

        if(x == 0)
        {
            ct.start();
            x=1;
        }
        //count();
        //CountDownTimer(time*1000,1000).start();
        //if(q==0)
            //count();


        //ct = CountDownTimer(time*1000,1000);
        //ct.onTick(time);

        setContentView(R.layout.activity_main);

        TextView score = (TextView)findViewById(R.id.score);
        score.setText(String.valueOf(sc)+"/"+String.valueOf(q));


        Random r = new Random();
        Random selbox = new Random();

        int i1 = r.nextInt(99)+10, i2 = r.nextInt(99)+10;
        b1 = selbox.nextInt(4);
        int b2 = (b1+1)%4,b3 = (b1+2)%4,b4 = (b1+3)%4;

        GridLayout gl = (GridLayout)findViewById(R.id.gl);

        TextView ans = (TextView) gl.getChildAt(b1);
        ans.setTag(b1);
        ans.setText(String.valueOf(i1 + i2));

        ans = (TextView) gl.getChildAt(b2);
        ans.setTag(b2);
        ans.setText(String.valueOf((i1 + i2 + 29) % 91));

        ans = (TextView) gl.getChildAt(b3);
        ans.setTag(b3);
        ans.setText(String.valueOf(i1 + i2 - 10));

        ans = (TextView) gl.getChildAt(b4);
        ans.setTag(b4);
        ans.setText(String.valueOf((i1 + i2 - 18) % 97));

        Log.i("Random",String.valueOf(b1));
        Log.i("Random",String.valueOf(b2));
        Log.i("Random",String.valueOf(b3));
        Log.i("Random",String.valueOf(b4));

        TextView ques = (TextView)findViewById(R.id.ques);
        ques.setText(String.valueOf(i1)+ " + " + String.valueOf(i2) + " = ?");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
    }
}

