package com.example.arnoldtarea1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.arnoldtarea1.Operaciones.operacionesMatematicas;


public class MainActivity extends AppCompatActivity {

    private EditText txtNum1, txtNum2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNum1 = findViewById(R.id.txtNum1);
        txtNum2 = findViewById(R.id.txtNum2);

        Button btnSuma = findViewById(R.id.btnSuma);
        Button btnResta = findViewById(R.id.btnResta);
        Button btnDiv = findViewById(R.id.btnDiv);
        Button btnMult = findViewById(R.id.btnMult);

        btnSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarOperacion("+");
            }
        });

        btnResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarOperacion("-");
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarOperacion("/");
            }
        });

        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarOperacion("*");
            }
        });
    }

    private void realizarOperacion(String operador) {

        double num1 = Double.parseDouble(txtNum1.getText().toString());
        double num2 = Double.parseDouble(txtNum2.getText().toString());
        double resultado = 0;

        switch (operador) {
            case "+":
                resultado = operacionesMatematicas.sumar(num1, num2);
                break;
            case "-":
                resultado = operacionesMatematicas.restar(num1, num2);
                break;
            case "*":
                resultado = operacionesMatematicas.multiplicar(num1, num2);
                break;
            case "/":
                try {
                    resultado = operacionesMatematicas.dividir(num1, num2);
                } catch (ArithmeticException e) {

                }
                break;
        }

        // Enviar el resultado a la actividad ResultadoActivity
        Intent intent = new Intent(MainActivity.this, ResultadoActivity.class);
        intent.putExtra("resultado", resultado);
        startActivity(intent);

    }


}