package com.example.davispc10.proprietario_david.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.davispc10.proprietario_david.R;
import com.example.davispc10.proprietario_david.model.Proprietario;
import com.example.davispc10.proprietario_david.model.Veiculo;

import java.util.ArrayList;

public class TelaCadastroVeiculo extends AppCompatActivity {

    EditText modelo, placa, ano;
    Spinner spProprietario;
    Button btsalvar,btalterar;
    Long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_veiculo);

        Intent intent = getIntent();
        id = (Long) intent.getSerializableExtra("id");
        String modelop = (String) intent.getSerializableExtra("modelo");
        String placap = (String) intent.getSerializableExtra("placa");
        String anop = (String) intent.getSerializableExtra("ano");

        EditText modelo = (EditText) findViewById(R.id.etModeloVeiculo);
        modelo.setText(modelop);

        final ArrayList<Proprietario> proprietarios =  (ArrayList<Proprietario>) Proprietario.listAll(Proprietario.class);

        ArrayAdapter<Proprietario> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, proprietarios);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spProprietario = (Spinner) findViewById(R.id.spProprietarioinVeiculo);
        spProprietario.setAdapter(adapter);

        EditText placa = (EditText) findViewById(R.id.etPLacaVeiculo);
        placa.setText(placap);

        EditText ano = (EditText) findViewById(R.id.etAnoVeiculo);
        ano.setText(anop);

        btsalvar = (Button) findViewById(R.id.btSalvarVeiculo);
        btalterar = (Button) findViewById(R.id.btAlterarVeiculoo);

        btsalvar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                salvar();
            }
        });
        btalterar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                alterar();
            }
        });

        if (id !=0) {
            btsalvar.setEnabled(false);
            btsalvar.setClickable(false);
            btsalvar.setVisibility(View.INVISIBLE);
        }
        else {
            btalterar.setEnabled(false);
            btalterar.setClickable(false);
            btalterar.setVisibility(View.INVISIBLE);
        }
    }

    public void salvar() {
        modelo = (EditText) findViewById(R.id.etModeloVeiculo);
        Proprietario proprietario = ((Proprietario) spProprietario.getSelectedItem());
        placa = (EditText) findViewById(R.id.etPLacaVeiculo);
        ano = (EditText) findViewById(R.id.etAnoVeiculo);

        Veiculo veiculo = new Veiculo(placa.getText().toString(),
                modelo.getText().toString(),ano.getText().toString(), proprietario);

        veiculo.save();

        Toast.makeText(this,"Veiculo Cadastrado",Toast.LENGTH_LONG).show();
        this.finish();
    }
    public void alterar() {
        modelo = (EditText) findViewById(R.id.etModeloVeiculo);
        Proprietario proprietario = ((Proprietario) spProprietario.getSelectedItem());
        placa = (EditText) findViewById(R.id.etPLacaVeiculo);
        ano = (EditText) findViewById(R.id.etAnoVeiculo);

        Veiculo veiculo = Veiculo.findById(Veiculo.class, id);

        veiculo.setModelo(modelo.getText().toString());
        veiculo.setProprietario(proprietario);
        veiculo.setAno(ano.getText().toString());
        veiculo.setPlaca(placa.getText().toString());

        veiculo.save();

        Toast.makeText(this,"Veiculo Alterado",Toast.LENGTH_LONG).show();
        this.finish();
    }
}
