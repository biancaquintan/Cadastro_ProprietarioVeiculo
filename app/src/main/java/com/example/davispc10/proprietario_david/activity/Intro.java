package com.example.davispc10.proprietario_david.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.davispc10.proprietario_david.R;

public class Intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
    }

    public void chamaTelaProprietario(View v) {
        Intent intent = new Intent(Intro.this, TelaListaProprietario.class);
        startActivity(intent);
    }

    public void chamaTelaVeiculo(View v){
        Intent intent = new Intent(Intro.this, TelaListaVeiculo.class);
        startActivity(intent);
    }
}
