package com.example.practica6_android.models;

public class Celcius extends Grado {

    public Celcius(Double valor)
    {
        this.setValor(valor);
        this.setUnidad("C");
    }

    public Celcius parse(Farenheit F)
    {

        return new Celcius((F.getValor() - 32) / 1.8);
    }

    public Celcius parse(Kelvin K)
    {

        return new Celcius(K.getValor() - 273.15);
    }

}
