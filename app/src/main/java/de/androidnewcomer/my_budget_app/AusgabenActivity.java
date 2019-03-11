package de.androidnewcomer.my_budget_app;

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

public class AusgabenActivity extends AppCompatActivity implements View.OnClickListener {

    private AusgabenActivity mainActivity;
    private Button home;
    EditText inputTextAusgabe;
    EditText inputNumberAusgabe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ausgaben);
        mainActivity = this;
        home = (Button) findViewById(R.id.btn_zurueck);
        home.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.btn_zurueck) {
            startActivityForResult(new Intent( this, MainActivity.class), 1);
        }

        if(view.getId() == R.id.btn_ausgabe_speichern){
            inputTextAusgabe = findViewById(R.id.inputTextAusgabe);
            inputNumberAusgabe = findViewById(R.id.inputNumberAusgabe);
            createAusgabe(inputTextAusgabe.getText().toString(), Double.parseDouble(inputNumberAusgabe.getText().toString()));
        }
    }

    /**
     * @param name name der Ausgabe
     * @param betrag betrag der Ausgabe
     * Fügt die Ausgaben in die Datenank myBudgetApp
     *
     */
    public void createAusgabe(final String name, final double betrag){
        Log.d("Ausgabe", "Ausgabe Runnable");
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                Ausgabe ausgabe = new Ausgabe(name, betrag);
                if (ausgabe.getNameDerAusgabe() != "" && ausgabe.getBetragDerAusgabe() > 0) {
                    DatabaseConnection db = Room.databaseBuilder(getApplicationContext(),
                            DatabaseConnection.class, "myBudgetApp").fallbackToDestructiveMigration().build();
                    db.ausgabeDAO().insertAll(ausgabe);
                    // Konsolen Nachricht
                    Log.d("Ausgabe", "Ausgabe eingefügt");
                }
            }
        });
        //Toast.makeText(mainActivity, "Juuuu", Toast.LENGTH_LONG);
    }
}
