package com.example.tresenraya;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuUnJugador extends AppCompatActivity {

    Button facil;
    Button avanzado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_un_jugador);

        facil = (Button)findViewById(R.id.facil);

        facil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent facil = new Intent(MenuUnJugador.this, NivelFacil.class);
                startActivity(facil);
            }
        });

        avanzado = (Button)findViewById(R.id.avanzado);

        avanzado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent avanzado = new Intent(MenuUnJugador.this, NivelAvanzado.class);
                startActivity(avanzado);
            }
        });
    }

}
