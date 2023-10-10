package com.example.practica6_android.models;

public class Kelvin extends Grado{

    public Kelvin(Double valor)
    {
        this.setValor(valor);
        this.setUnidad("K");
    }
    public Kelvin parse(Farenheit F)
    {
        return new Kelvin(((F.getValor() - 32) * 5/9) + 273.15);
    }

    public Kelvin parse(Celcius C)
    {
        return new Kelvin(C.getValor()+273.15);
    }
}
