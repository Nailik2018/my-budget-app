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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button einnahmen;
    private Button ausgaben;
    private Button ueberblick;
    private MainActivity einnahmenActivity;
    private MainActivity ausgabenActivity;
    private MainActivity ueberblickActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        einnahmenActivity = this;
        einnahmen = (Button) findViewById(R.id.btn_einnahmen);
        einnahmen.setOnClickListener(this);
        ausgabenActivity = this;
        ausgaben = (Button) findViewById(R.id.btn_ausgaben);
        ausgaben.setOnClickListener(this);
        ueberblickActivity = this;
        ueberblick = (Button) findViewById(R.id.btn_ueberblick);
        ueberblick.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.btn_einnahmen) {
            startActivityForResult(new Intent(this, EinnahmenActivity.class), 1);
        }

        if(view.getId() == R.id.btn_ausgaben) {
            startActivityForResult(new Intent( this, AusgabenActivity.class), 1);
        }

        if(view.getId() == R.id.btn_ueberblick) {
            startActivityForResult(new Intent( this, UeberblickActivity.class), 1);
        }
    }
}
