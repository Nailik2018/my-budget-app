package de.androidnewcomer.my_budget_app;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Room;
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

public class EinnahmenActivity extends AppCompatActivity implements View.OnClickListener {

    private EinnahmenActivity mainActivity;
    private Button home;
    private Button createEinnahme;
    TextView inputTextEinnahme;
    TextView inputNumberEinnahme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_einnahmen);
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

    @Insert
    public void createEinnahme(String name, double betrag){
        Einnahme einnahme = new Einnahme(name, betrag);
        if(einnahme.getNameDerEinnahme() != "" && einnahme.getBetragDerEinnahme() > 0){
            EinnahmeDatabase db = Room.databaseBuilder(getApplicationContext(),
                    EinnahmeDatabase.class, "myBudgetApp").build();
            db.einnahmeDAO().insertAll(einnahme);
        }
    }
}
