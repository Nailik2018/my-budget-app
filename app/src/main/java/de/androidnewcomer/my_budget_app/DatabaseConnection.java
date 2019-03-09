package de.androidnewcomer.my_budget_app;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Einnahme.class, Ausgabe.class}, version = 3)
public abstract class DatabaseConnection extends RoomDatabase {
    public abstract EinnahmeDAO einnahmeDAO();

    public abstract AusgabeDAO ausgabeDAO();
}