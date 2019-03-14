package de.androidnewcomer.my_budget_app;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * ##################################################################################################################################
 * ##################################################################################################################################
 * ##################################################################################################################################
 *
 *
 *
 * @autor                   Ki LIAN
 * @version                 1.0
 * @date                    14.03.2019
 *
 *
 * Klasse EinnahmenActivity
 * Erstellung der Ausgaben
 * @param AusgabenActivity das Activiti des home Menus
 * @param home Button Zurück zum Home Menu
 * @param createEinnahme Erstellung der Einnahme
 * @param inputTextAusgabe Inputfeld Name des Betrags der Ausgabe
 * @param inputNumberAusgabe Inputfeld Betrag der Ausgabe
 *
 *
 *
 * ##################################################################################################################################
 * ##################################################################################################################################
 * ##################################################################################################################################
 */
public class EinnahmenActivity extends AppCompatActivity implements View.OnClickListener {

    private EinnahmenActivity mainActivity;
    private Button home;
    private Button createEinnahme;
    EditText inputTextEinnahme;
    EditText inputNumberEinnahme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_einnahmen);
        mainActivity = this;
        home = (Button) findViewById(R.id.btn_zurueck);
        home.setOnClickListener(this);
    }

    /**
     * @param view übergabe der Home Activity um zurück zur Startseite zu gelangen
     * Beim klicken auf den Button btn_zurueck gelangt der Anwender zur Startseite mainActivity.
     *
     * Beim klicken auf den btn_einnahmen wird eine neue Einnahme erstellt
     */
    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_zurueck) {
            startActivityForResult(new Intent( this, MainActivity.class), 1);
        }
        if(view.getId() == R.id.btn_einnahmen){
            inputTextEinnahme = findViewById(R.id.inputTextEinnahme);
            inputNumberEinnahme = findViewById(R.id.inputNumberEinnahme);
            createEinnahme(inputTextEinnahme.getText().toString(), Double.parseDouble(inputNumberEinnahme.getText().toString()));
        }


    }

    /**
     * @param name name der Einnahme
     * @param betrag betrag der Einnahme
     * Fügt die Ausgaben in die Datenank myBudgetApp
     * Bei erfolgreicher erstellung ist eine Konsolenausgabe ersichtlich
     */
    public void createEinnahme(final String name, final double betrag){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                Einnahme einnahme = new Einnahme(name, betrag);
                if (einnahme.getNameDerEinnahme() != "" && einnahme.getBetragDerEinnahme() > 0) {
                    DatabaseConnection db = Room.databaseBuilder(getApplicationContext(),
                            DatabaseConnection.class, "myBudgetApp").fallbackToDestructiveMigration().build();
                    db.einnahmeDAO().insertAll(einnahme);
                    // Konsolen Nachricht
                    Log.d("Einnahme", "Einnahme eingefügt");
                }
            }
        });
        //Toast.makeText(mainActivity, "Juuuu", Toast.LENGTH_LONG);
    }
}
