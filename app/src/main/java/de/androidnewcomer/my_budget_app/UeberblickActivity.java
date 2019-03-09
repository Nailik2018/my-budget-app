package de.androidnewcomer.my_budget_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class UeberblickActivity extends AppCompatActivity implements View.OnClickListener  {

    private UeberblickActivity mainActivity;
    private Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ueberblick);
        mainActivity = this;
        home = (Button) findViewById(R.id.btn_zurueck);
        home.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_zurueck) {
            startActivityForResult(new Intent( this, MainActivity.class), 1);
        }
    }
}
