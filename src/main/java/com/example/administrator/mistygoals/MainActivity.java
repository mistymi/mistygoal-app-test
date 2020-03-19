package com.example.administrator.mistygoals;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btu1,btu2,btu3,btu4,btu5,btu6;
    TextView score,test;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/
        score=(TextView)findViewById(R.id.score);

        findViewById(R.id.duihuan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent();
                i.putExtra("key",score.getText()+"");
                i.setClass(MainActivity.this,change.class);
                startActivityForResult(i,1);
            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences("user_info",MODE_PRIVATE);
        //取出数据（注意这里直接用实例取就行了，不用获取编辑器editor）
        boolean isFirstRun=sharedPreferences.getBoolean("isFirstRun", true);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        if(isFirstRun){
            //Toast.makeText(MainActivity.this, "第一次运行", Toast.LENGTH_SHORT).show();
            editor.putBoolean("isFirstRun", false);
            editor.commit();
        }
        else
        { int age = sharedPreferences.getInt("age", 0);
        //打印出来
        //Toast.makeText(MainActivity.this, "后几次运行", Toast.LENGTH_SHORT).show();
        score=(TextView)findViewById(R.id.score);
        score.setText(age+"");
            }


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




        btu1.setOnClickListener(this);
        btu2.setOnClickListener(this);
        btu3.setOnClickListener(this);
        btu4.setOnClickListener(this);
        btu5.setOnClickListener(this);
        btu6.setOnClickListener(this);




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

        SharedPreferences sharedPreferences = getSharedPreferences("user_info", MODE_PRIVATE);
        //获取操作SharedPreferences实例的编辑器（必须通过此种方式添加数据）
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //添加数据

        editor.putInt("age", result);

        //提交
        editor.commit();

    /*    //SharedPreferences sharedPreferences = getSharedPreferences("user_info",MODE_PRIVATE);
        //取出数据（注意这里直接用实例取就行了，不用获取编辑器editor）
        int age = sharedPreferences.getInt("age", -1);
        //打印出来
        Toast.makeText(MainActivity.this, ""+age, Toast.LENGTH_SHORT).show();

*/



    }

     //积分兑换后的值回传
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode==1){
        String getresult = data.getStringExtra("extra_data");
       // Toast.makeText(MainActivity.this, getresult, Toast.LENGTH_SHORT).show();
        score.setText(getresult);

        //存入sharepreference
            SharedPreferences sharedPreferences = getSharedPreferences("user_info", MODE_PRIVATE);
            //获取操作SharedPreferences实例的编辑器（必须通过此种方式添加数据）
            SharedPreferences.Editor editor = sharedPreferences.edit();
            //添加数据

            editor.putInt("age", Integer.parseInt(getresult));

            //提交
            editor.commit();
      }
    }



}
