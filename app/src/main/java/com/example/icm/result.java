package com.example.icm;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class result extends AppCompatActivity {

    TextView viewResultado, viewPeso, viewAltura;
    double icm;
    String peso, altura, res;
    ImageView viewImgObecidad;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);

        viewResultado = findViewById(R.id.txtViewResult);
        viewPeso = findViewById(R.id.txtEditPeso);
        viewAltura = findViewById(R.id.txtEdirAltura);
        viewImgObecidad = findViewById(R.id.imgViewObecidad);

        Bundle obtenerData = getIntent().getExtras();
        assert obtenerData != null;

        peso = obtenerData.getString("peso");
        altura = obtenerData.getString("altura");


        icm = Double.parseDouble(peso) / (Double.parseDouble(altura) * Double.parseDouble(altura));

        if (icm < 10.5) {
            viewImgObecidad.setImageResource(R.drawable.nivel1);
            res = ("Criticamente bajo de peso : " + icm);
        } else if (icm < 15.9) {
            viewImgObecidad.setImageResource(R.drawable.nivel2);
            res = "Severamente bajo de peso : " + icm;
        } else if (icm < 18.5) {
            viewImgObecidad.setImageResource(R.drawable.nivel3);
            res = "Bajo de peso : " + icm;
        } else if (icm < 25) {
            viewImgObecidad.setImageResource(R.drawable.nivel4);
            res = "Normal peso saludable : " + icm;
        } else if (icm < 30) {
            viewImgObecidad.setImageResource(R.drawable.nivel5);
            res = "Sobrepeso : " + icm;
        } else if (icm < 35) {
            viewImgObecidad.setImageResource(R.drawable.nivel3);
            res = "Obecidad clase 1 Moderadamente : " + icm;
        } else if (icm < 40) {
            viewImgObecidad.setImageResource(R.drawable.nivel4);

            res = "Obecidad clase 2 - Severamente obeso : " + icm;
        } else if (icm < 50) {
            viewImgObecidad.setImageResource(R.drawable.nivel5);
            res = "Obecidad clase 3 - Criticamente obeso : " + icm;
        } else {
            res = "IMC no valido";
        }

        viewPeso.setText(peso);
        viewAltura.setText(altura);
        viewResultado.setText(String.valueOf(res));

    }

    public void pantallaCalcular(View v) {
        Intent lanzar = new Intent(this, data.class);
        startActivity(lanzar);
        finish();
    }

    public void salir(View v) {
        finish();
    }

}