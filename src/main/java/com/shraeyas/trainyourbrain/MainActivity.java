package com.shraeyas.trainyourbrain;

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
    int sc=0,q=0;

    void check(View view)
    {
        TextView click = (TextView)view;

        Log.i("Random",String.valueOf(click.getTag()));
        Log.i("Random",Integer.toString(b1-1));

        if(Integer.parseInt((click.getTag()).toString()) == b1-1)
        {
            sc++;

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
        setContentView(R.layout.activity_main);

        TextView score = (TextView)findViewById(R.id.score);
        score.setText(String.valueOf(sc)+"/"+String.valueOf(q));


        Random r = new Random();
        Random selbox = new Random();

        int i1 = r.nextInt(99)+10, i2 = r.nextInt(99)+10;
        b1 = selbox.nextInt(3)+1;
        int b2 = (b1+1)%4,b3 = (b1+2)%4,b4 = (b1+3)%4;

        GridLayout gl = (GridLayout)findViewById(R.id.gl);

        TextView ans = (TextView) gl.getChildAt(b1);
        ans.setText(String.valueOf(i1 + i2));

        ans = (TextView) gl.getChildAt(b2);
        ans.setText(String.valueOf((i1 + i2 + 10) % 91));

        ans = (TextView) gl.getChildAt(b3);
        ans.setText(String.valueOf(i1 + i2 - 9));

        ans = (TextView) gl.getChildAt(b4);
        ans.setText(String.valueOf((i1 + i2 - 18) % 97));

        /*Log.i("Random",String.valueOf(b1));
        Log.i("Random",String.valueOf(b2));
        Log.i("Random",String.valueOf(b3));
        Log.i("Random",String.valueOf(b4));*/

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

