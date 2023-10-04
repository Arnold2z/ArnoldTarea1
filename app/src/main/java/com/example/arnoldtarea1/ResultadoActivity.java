package com.example.arnoldtarea1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class ResultadoActivity extends AppCompatActivity {
    private EditText txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Button btnRegreso = findViewById(R.id.btnRegresar);


        txtResultado = findViewById(R.id.txtResultado);

        // Recibir el resultado de la actividad anterior
        Intent intent = getIntent();
        double resultado = intent.getDoubleExtra("resultado", 0);

        // Mostrar el resultado en el EditText
        txtResultado.setText(String.valueOf(resultado));


btnRegreso.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent2);
    }
});


    }
}