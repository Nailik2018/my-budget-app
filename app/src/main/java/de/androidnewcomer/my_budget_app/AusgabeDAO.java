package de.androidnewcomer.my_budget_app;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface AusgabeDAO {
    @Query("SELECT * FROM ausgabe")
    List<Ausgabe> getAll();

    @Insert
    void insertAll(Ausgabe... ausgaben);

    @Delete
    void delete(Ausgabe ausgabe);
}
