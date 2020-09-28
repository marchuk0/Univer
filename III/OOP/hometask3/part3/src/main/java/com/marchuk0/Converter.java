package com.marchuk0;

public class Converter {

    private final double usd;
    private final double eur;

    public Converter(double usd, double eur) {
        this.usd = usd;
        this.eur = eur;
    }

    public double uahToEur(double uah) {
        return uah/eur;
    }

    public double uahToUsd(double uah) {
        return uah/usd;
    }

    public double usdToUah(double usd) {
        return usd*this.usd;
    }

    public double eurToUah(double eur) {
        return eur*this.eur;
    }

}
