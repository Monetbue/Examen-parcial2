package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity4 extends AppCompatActivity {
    EditText comprarp;
    Button pagarp;
    Button menubebida;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        menubebida=(Button) findViewById(R.id.menubebida);
        pagarp = (Button) findViewById(R.id.pagarp);
        comprarp = (EditText) findViewById(R.id.comprarp);



        menubebida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _comprarp="";
                _comprarp = comprarp.getText().toString();
                GuardarDatos(_comprarp);
                Intent intent = new Intent(MainActivity4.this,MainActivity3.class);
                //intent.putExtra("Comprarp",_comprarp);
                startActivity(intent);
            }
        });

        pagarp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _comprarp="";
                _comprarp = comprarp.getText().toString();
                GuardarDatos(_comprarp);
                Intent intent = new Intent(MainActivity4.this,MainActivity5.class);
                //intent.putExtra("Comprarp",_comprarp);
                startActivity(intent);
            }
        });
    }
    private void GuardarDatos(String comprarp) {
        preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Pizza",comprarp);
        editor.commit();
    }
}