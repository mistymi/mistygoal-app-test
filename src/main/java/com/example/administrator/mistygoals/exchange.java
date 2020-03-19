package com.example.administrator.mistygoals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class exchange extends AppCompatActivity implements View.OnClickListener {
    Button btu1, btu2, btu3, btu4, btu5, btu6, btu7;
    TextView other, score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange);

        findViewById(R.id.change).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(exchange.this, score.class));
            }
        });

        initclick();

    }

    public void initclick() {
        other = (TextView) findViewById(R.id.other);
        btu1 = (Button) findViewById(R.id.movie);
        btu2 = (Button) findViewById(R.id.tea);
        btu3 = (Button) findViewById(R.id.thing);
        btu4 = (Button) findViewById(R.id.game);
        btu5 = (Button) findViewById(R.id.rest);
        btu6 = (Button) findViewById(R.id.travel);
        btu7 = (Button) findViewById(R.id.eat);
        score = (TextView) findViewById(R.id.score);

        btu1.setOnClickListener(this);
        btu2.setOnClickListener(this);
        btu3.setOnClickListener(this);
        btu4.setOnClickListener(this);
        btu5.setOnClickListener(this);
        btu6.setOnClickListener(this);
        btu7.setOnClickListener(this);


    }

    public void onClick(View view) {
        String str = score.getText().toString();
        int result = Integer.parseInt(str);
        switch (view.getId()) {
            case R.id.movie:
                result -= 200;
                break;
            case R.id.tea:
                result -= 100;
                break;
            case R.id.thing:
                result -= 300;
                break;
            case R.id.game:
                result -= 50;
                break;
            case R.id.rest:
                result -= 250;
                break;
            case R.id.travel:
                result -= 500;
                break;
            case R.id.eat:
                result -= 300;
                break;



        }
        other=score;
        other.setText("" + result + "");
        score.setText("" + result + "");
    }
}
