package com.example.practica6_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.example.practica6_android.models.Celcius;
import com.example.practica6_android.models.Farenheit;
import com.example.practica6_android.models.Kelvin;


import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{

    private Spinner tipo,escoger;
    private EditText escribir;
    private Button boton;
    private TextView resultado;
    String seleccion1,seleccion2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        this.resultado = (TextView) findViewById(R.id.resultado);
        this.tipo= (Spinner) findViewById(R.id.tipo);
        this.escoger= (Spinner) findViewById(R.id.escoger);
        this.escribir = (EditText) findViewById(R.id.escribir);
        this.boton = (Button) findViewById(R.id.boton);

        this.boton.setOnClickListener(this);
        this.tipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                seleccion1 = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"Tipo de grado: "+seleccion1,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        this.escoger.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                seleccion2 = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"Convertir a: "+seleccion2,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.boton)
        {
            String texto = this.escribir.getText().toString().trim();
            if(texto.isEmpty())
            {
                Toast.makeText(getApplicationContext(),"Campo vacio",Toast.LENGTH_SHORT).show();
            }
            else if(seleccion1.equals("Farenheit")&&seleccion2.equals("Celsius"))
            {
                double valor = Double.parseDouble(texto);
                Farenheit farenheit = new Farenheit(valor);
                Celcius celcius = new Celcius(valor);

                Celcius farencelcius= celcius.parse(farenheit);

                resultado.setText(""+farencelcius.getValor()+" °"+celcius.getUnidad());
            }
            else if(seleccion1.equals("Farenheit")&&seleccion2.equals("Kelvin"))
            {
                double valor = Double.parseDouble(texto);
                Farenheit farenheit = new Farenheit(valor);
                Kelvin kelvin = new Kelvin(valor);
                Kelvin farenkelvin= kelvin.parse(farenheit);
                resultado.setText(""+farenkelvin.getValor()+" °"+kelvin.getUnidad());
            }
            else if(seleccion1.equals("Celsius")&&seleccion2.equals("Farenheit"))
            {
                double valor = Double.parseDouble(texto);
                Farenheit farenheit = new Farenheit(valor);
                Celcius celcius = new Celcius(valor);
                Farenheit celciusfaren= farenheit.parse(celcius);

                resultado.setText(""+celciusfaren.getValor()+" °"+farenheit.getUnidad());
            }
            else if(seleccion1.equals("Celsius")&&seleccion2.equals("Kelvin"))
            {
                double valor = Double.parseDouble(texto);
                Celcius celcius = new Celcius(valor);
                Kelvin kelvin = new Kelvin(valor);
                Kelvin celciuskel= kelvin.parse(celcius);

                resultado.setText(""+celciuskel.getValor()+" °"+kelvin.getUnidad());
            }
            else if(seleccion1.equals("Kelvin")&&seleccion2.equals("Farenheit"))
            {

                double valor = Double.parseDouble(texto);
                Kelvin kelvin = new Kelvin(valor);
                Farenheit farenheit = new Farenheit(valor);
                Farenheit kelvinfaren= farenheit.parse(kelvin);

                resultado.setText(""+kelvinfaren.getValor()+" °"+farenheit.getUnidad());
            }

            else if(seleccion1.equals("Kelvin")&&seleccion2.equals("Celsius"))
            {

                double valor = Double.parseDouble(texto);
                Kelvin kelvin = new Kelvin(valor);
                Celcius celcius = new Celcius(valor);
                Celcius kelvincelcius= celcius.parse(kelvin);

                resultado.setText(""+kelvincelcius.getValor()+" °"+celcius.getUnidad());
            }


        }
    }
}