package com.example.tresenraya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Inicio extends AppCompatActivity {

    Button unJugador;
    Button dosJugadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);

        dosJugadores = (Button)findViewById(R.id.dosJugadores);

        dosJugadores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dosJugadores = new Intent(Inicio.this, DosJugadores.class);
                startActivity(dosJugadores);
            }
        });

        unJugador = (Button)findViewById(R.id.unJugador);

        unJugador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent unJugador = new Intent(Inicio.this, MenuUnJugador.class);
                startActivity(unJugador);
            }
        });
    }
}