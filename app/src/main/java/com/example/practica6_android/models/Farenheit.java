package com.example.practica6_android.models;

public class Farenheit extends Grado{
    public Farenheit(Double valor)
    {
        this.setValor(valor);
        this.setUnidad("F");
    }
    public Farenheit parse(Celcius c)
    {
        return new Farenheit((c.getValor()*1.8)+32);
    }

    public Farenheit parse(Kelvin k)
    {
        return new Farenheit(((k.getValor() - 273.15) * 9/5) + 32);
    }
}
