package com.example.examen01;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtNombre;
    private EditText txtAltura;
    private EditText txtBase;
    private Button btnLimpiar;
    private Button btnSiguiente;
    private Button btnSalir;
    private Rectangulo rectangulo= new Rectangulo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSalir = (Button) findViewById(R.id.btnSalir);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);;
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtBase = (EditText) findViewById(R.id.txtBase);
        txtAltura = (EditText) findViewById(R.id.txtAltura);

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNombre.setText("");
                txtBase.setText("");
                txtAltura.setText("");
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(txtNombre.getText().toString().matches("")||
               txtAltura.getText().toString().matches("")||
                    txtBase.getText().toString().matches("")){

                Toast.makeText(MainActivity.this,
                        "Falto Capturar Informacion",
                        Toast.LENGTH_SHORT).show();
                return;
            }

                String nombre = txtNombre.getText().toString();
                String base = txtBase.getText().toString();
                String altura = txtAltura.getText().toString();
                Intent intent = new Intent( MainActivity.this,RectanguloActivity.class);
                intent.putExtra("nombre",nombre);
                intent.putExtra("base", base);
                intent.putExtra("altura", altura);
                startActivity(intent);

            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder confirmar = new AlertDialog.Builder(MainActivity.this);
                confirmar.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        finish();
                    }
                });
                confirmar.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                confirmar.show();
            }
        });



    }



}