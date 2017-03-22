package com.example.davispc10.proprietario_david.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.davispc10.proprietario_david.R;
import com.example.davispc10.proprietario_david.adapter.VeiculoAdapter;
import com.example.davispc10.proprietario_david.model.Veiculo;

import java.util.ArrayList;

public class TelaListaVeiculo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lista_veiculo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaListaVeiculo.this,TelaCadastroVeiculo.class);
                intent.putExtra("id", Long.valueOf(0));
                intent.putExtra("modelo", "");
                intent.putExtra("proprietario", "");
                intent.putExtra("ano", "");
                intent.putExtra("placa", "");

                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tela_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onResume() {
       super.onResume();
       final ArrayList<Veiculo> veiculos = (ArrayList<Veiculo>) Veiculo.listAll(Veiculo.class);

        ListView lista = (ListView) findViewById(R.id.lvVeiculos);
        VeiculoAdapter adapter = new VeiculoAdapter(this, veiculos);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(TelaListaVeiculo.this, TelaCadastroVeiculo.class);

                intent.putExtra("id",veiculos.get(i).getId());
                intent.putExtra("modelo",veiculos.get(i).getModelo());
                intent.putExtra("proprietario",veiculos.get(i).getProprietario().getId());
                intent.putExtra("ano",veiculos.get(i).getAno());
                intent.putExtra("placa",veiculos.get(i).getPlaca());

                startActivity(intent);
            }
        });
    }
}
