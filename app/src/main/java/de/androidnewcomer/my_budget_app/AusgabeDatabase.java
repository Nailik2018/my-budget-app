package de.androidnewcomer.my_budget_app;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Ausgabe.class}, version = 1)
public abstract class AusgabeDatabase extends RoomDatabase {
    public abstract AusgabeDAO einnahmeDAO();
}