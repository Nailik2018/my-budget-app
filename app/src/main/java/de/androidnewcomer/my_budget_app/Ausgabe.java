package de.androidnewcomer.my_budget_app;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Ausgabe {

    @PrimaryKey
    public int id;

    @ColumnInfo(name = "nameDerAusgabe")
    private String nameDerAusgabe;

    @ColumnInfo(name = "betragDerAusgabe")
    private double betragDerAusgabe;

    public Ausgabe(){
    }

    public Ausgabe(String nameDerAusgabe, double betragDerAusgabe){
        this.nameDerAusgabe = nameDerAusgabe;
        this.betragDerAusgabe = betragDerAusgabe;
    }

    public void setBetragDerAusgabe(double betragDerAusgabe) {
        this.betragDerAusgabe = betragDerAusgabe;
    }

    public void setNameDerAusgabe(String nameDerEingabe){
        this.nameDerAusgabe = nameDerEingabe;
    }

    public String getNameDerAusgabe(){
        return this.nameDerAusgabe;
    }

    public Double getBetragDerAusgabe(){
        return this.betragDerAusgabe;
    }
}
