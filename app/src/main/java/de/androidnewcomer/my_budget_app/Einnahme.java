package de.androidnewcomer.my_budget_app;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Einnahme {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "nameDerEinnahme")
    private String nameDerEinnahme;

    @ColumnInfo(name = "betragDerEinnahme")
    private double betragDerEinnahme;

    public Einnahme(){
    }

    public Einnahme(String nameDerEinnahme, double betragDerEinnahme){
        this.nameDerEinnahme = nameDerEinnahme;
        this.betragDerEinnahme = betragDerEinnahme;
    }

    public void setBetragDerEinnahme(double betragDerEinnahme) {
        this.betragDerEinnahme = betragDerEinnahme;
    }

    public void setNameDerEinnahme(String nameDerEingabe){
        this.nameDerEinnahme = nameDerEingabe;
    }

    public String getNameDerEinnahme(){
        return this.nameDerEinnahme;
    }

    public Double getBetragDerEinnahme(){
        return this.betragDerEinnahme;
    }
}
