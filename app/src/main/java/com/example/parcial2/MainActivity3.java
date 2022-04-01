package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity3 extends AppCompatActivity {
    EditText comprarb;
    Button  pagarb;
    Button menupizza;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        menupizza=(Button) findViewById(R.id.menupizza);
        pagarb = (Button) findViewById(R.id.pagarb);
        comprarb = (EditText) findViewById(R.id.comprarb);




        menupizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _comprarb="";
                _comprarb = comprarb.getText().toString();
                GuardarDatos(_comprarb);
                Intent intent = new Intent(MainActivity3.this,MainActivity4.class);
                //intent.putExtra("Comprarb",_comprarb);
                startActivity(intent);
            }
        });

        pagarb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _comprarb="";
                _comprarb = comprarb.getText().toString();
                GuardarDatos(_comprarb);
                Intent intent = new Intent(MainActivity3.this,MainActivity5.class);
                //intent.putExtra("Comprarb",_comprarb);
                startActivity(intent);
            }
        });
    }
    private void GuardarDatos(String comprarb) {
        preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Bebida",comprarb);
        editor.commit();
    }

}