package com.example.administrator.mistygoals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;
import android.widget.Toast;

public class score extends AppCompatActivity implements View.OnClickListener{
    Button btu1,btu2,btu3,btu4,btu5,btu6;
    TextView score;
    Button aa;//兑换按钮


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        findViewById(R.id.change).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(score.this,change.class));
            }
        });

        initclick();
    }
    public void initclick(){
       score=(TextView)findViewById(R.id.score);
       btu1=(Button)findViewById(R.id.getup);
       btu2=(Button)findViewById(R.id.basic);
       btu3=(Button)findViewById(R.id.self);
       btu4=(Button)findViewById(R.id.run);
       btu5=(Button)findViewById(R.id.bcz);
       btu6=(Button)findViewById(R.id.reading);
       aa=(Button)findViewById(R.id.change);



       btu1.setOnClickListener(this);
        btu2.setOnClickListener(this);
        btu3.setOnClickListener(this);
        btu4.setOnClickListener(this);
        btu5.setOnClickListener(this);
        btu6.setOnClickListener(this);
       aa.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        String str=score.getText().toString();
        int result=Integer.parseInt(str);
        switch (view.getId()){
            case R.id.getup:result+=10;break;
            case R.id.basic:result+=10;break;
            case R.id.self:result+=15;break;
            case R.id.run:result+=15;break;
            case R.id.bcz:result+=5;break;
            case R.id.reading:result+=5;break;


           // Toast.makeText(score.this, "You clicked Button 1", Toast.LENGTH_SHORT).show();

        }
        score.setText(""+result+"");
        if(view.getId()==R.id.change){

            Intent intent = new Intent();
            intent.setClass(score.this, exchange.class);
            startActivity(intent);
            Toast.makeText(score.this, "aaaaa", Toast.LENGTH_SHORT).show();
        }
       // int as=view.getId();
        //Toast.makeText(score.this, ""+as+"", Toast.LENGTH_SHORT).show();





    }

    public void turn(){
        Intent intent = new Intent();
        intent.setClass(score.this, change.class);
        startActivity(intent);

    }
}
