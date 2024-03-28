package com.example.icm;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class data extends AppCompatActivity {
    EditText txtpeso, txtaltura;
//    TextView errorMensaje;
    String altura, peso;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_data);

        txtpeso = findViewById(R.id.txtEditPeso);
        txtaltura = findViewById(R.id.txtEdirAltura);
    }

    public void calcular(View v) {
        peso = txtpeso.getText().toString();
        altura = txtaltura.getText().toString();


        if (altura.isEmpty() || peso.isEmpty()) {
            Toast.makeText(this, "Por favor ingrese sus datos!", Toast.LENGTH_SHORT).show();
        }

        if (peso.isEmpty()) {
            Toast.makeText(this, "Por favor ingrese su peso!", Toast.LENGTH_SHORT).show();
        } else if (altura.isEmpty()) {
            Toast.makeText(this, "Por favor ingrese su altura!", Toast.LENGTH_SHORT).show();
        } else {
            Intent enviaraResult = new Intent(data.this, result.class);
            enviaraResult.putExtra("peso", peso);
            enviaraResult.putExtra("altura", altura);

            startActivity(enviaraResult);
            finish();

        }


    }

    public void pantallaMain(View v) {
        Intent lanzar = new Intent(this, MainActivity.class);
        startActivity(lanzar);
        finish();
    }
}