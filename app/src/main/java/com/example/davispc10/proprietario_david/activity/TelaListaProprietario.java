package com.example.davispc10.proprietario_david.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.davispc10.proprietario_david.R;
import com.example.davispc10.proprietario_david.adapter.ProprietarioAdapter;
import com.example.davispc10.proprietario_david.model.Proprietario;

import java.util.ArrayList;

public class TelaListaProprietario extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_main);
        Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar1);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaListaProprietario.this, TelaCadastroProprietario.class);
                intent.putExtra("id", Long.valueOf(0));
                intent.putExtra("nome", "");
                intent.putExtra("telefone", "");
                intent.putExtra("endereco", "");
                intent.putExtra("data", "");
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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
        final ArrayList<Proprietario> proprietarios = (ArrayList<Proprietario>) Proprietario.listAll(Proprietario.class);

        ListView lista = (ListView) findViewById(R.id.lvProprietarios);
        ProprietarioAdapter adapter = new ProprietarioAdapter(this, proprietarios);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(TelaListaProprietario.this, TelaCadastroProprietario.class);

                intent.putExtra("id",proprietarios.get(i).getId());
                intent.putExtra("nome",proprietarios.get(i).getNome());
                intent.putExtra("endereco",proprietarios.get(i).getEndereco());
                intent.putExtra("data",proprietarios.get(i).getData());
                intent.putExtra("telefone",proprietarios.get(i).getTelefone());

                startActivity(intent);
            }
        });
    }
}