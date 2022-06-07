package com.example.examen01;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class RectanguloActivity extends AppCompatActivity {

    private TextView lblNombre, lblBase, lblAltura, lblArea, lblPerimetro;
    private RadioButton rarea, rperimetro;
    private Button btnRegresar, btnCalcular;

protected void onCreate(Bundle savedInstanceState){
super.onCreate(savedInstanceState);
setContentView(R.layout.rectangulo);

    rarea = (RadioButton) findViewById(R.id.rarea);
    rperimetro = (RadioButton) findViewById(R.id.rperimetro);
    btnRegresar = (Button) findViewById(R.id.btnRegresar);
    btnCalcular = (Button) findViewById(R.id.btnCalcular);
    lblNombre = (TextView) findViewById(R.id.lblNombre);
    lblBase = (TextView) findViewById(R.id.lblBase);
    lblAltura = (TextView) findViewById(R.id.lblAltura);
    lblArea = (TextView) findViewById(R.id.lblArea);
    lblPerimetro = (TextView) findViewById(R.id.lblPerimetro);

    Rectangulo rectangulo = new Rectangulo();
    Intent intent = getIntent();
    String nombre = intent.getStringExtra("nombre");
    String basee = intent.getStringExtra("base");
    String alturaa = intent.getStringExtra("altura");

    lblNombre.setText("Nombre: "+nombre);
    lblBase.setText("Base: "+basee);
    lblAltura.setText("Altura: "+alturaa);

    btnCalcular.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
             float altura = Float.parseFloat(alturaa);
             float base = Float.parseFloat(basee);
             rectangulo.setAltura(altura);
             rectangulo.setBase(base);
             boolean estado = rperimetro.isChecked();
             boolean estado2 = rarea.isChecked();
             if(estado){

                     lblPerimetro.setText(String.valueOf(rectangulo.calcularPerimetro()));
             }
             if(estado2){
                 lblArea.setText(String.valueOf(rectangulo.calculoArea()));
             }
        }
    });

    btnRegresar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        AlertDialog.Builder confirmar = new AlertDialog.Builder(RectanguloActivity.this);
        confirmar.setTitle("Regersar?");
        confirmar.setMessage("Se descartara toda la informacion ingresada");
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
