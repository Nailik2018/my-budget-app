package de.androidnewcomer.my_budget_app;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface EinnahmeDAO {
    @Query("SELECT * FROM einnahme")
    List<Einnahme> getAll();

    @Insert
    void insertAll(Einnahme... einnahmmen);

    @Delete
    void delete(Einnahme einnahme);
}
