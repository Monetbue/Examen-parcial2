package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity5 extends AppCompatActivity {
    TextView mensaje1;
    Button regresar1;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        mensaje1 = (TextView) findViewById(R.id.mensaje1);
        regresar1 = (Button) findViewById(R.id.regresar1);


        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            String dato1 = extras.getString("Nombre");
            String dato2 = extras.getString("Direccion");
            String dato3 = extras.getString("Pizza");
            String dato4 = extras.getString("Bebida");

            if(!dato1.equals("")&&!dato2.equals("")&&!dato3.equals("")&&!dato4.equals("")){
                mensaje1.setText("Estimado "+dato1+" con direccion: " +dato2+ " has seleccionado la pizza" +dato3+ " con la bebida " +dato4+ " el total de la compra es: ");
            }
            else
                mensaje1.setText("Los datos que enviaste son incorrectos");

        }
        else {
            mensaje1.setText("No se envio ningun extra en el intent");
            LeerDatos();
        }

        regresar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity5.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
    private void LeerDatos() {
        preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        String dato1 = preferences.getString("Nombre","No hay dato");
        String dato2 = preferences.getString("Direccion","No hay dato");
        String dato3 = preferences.getString("Pizza","No hay dato");
        String dato4 = preferences.getString("Bebida","No hay dato");



        if(!dato1.equals("")&&!dato2.equals("")&&!dato3.equals("")&&!dato4.equals(""))
            mensaje1.setText("Estimado "+dato1+" con direccion: "+dato2+"has seleccionado la pizza" +dato3+"con la bebida"+dato4+ "el total de la compra es: ");
        else
            mensaje1.setText("Los datos que enviaste son incorrectos nombre: "+dato1+" direccion: "+dato2+ "Pizza: " +dato3+ "Bebida: "+dato4);


    }


}




