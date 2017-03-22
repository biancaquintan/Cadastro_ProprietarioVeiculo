package com.example.davispc10.proprietario_david.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.davispc10.proprietario_david.R;
import com.example.davispc10.proprietario_david.model.Proprietario;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static android.R.id.list;

public class TelaCadastroProprietario extends AppCompatActivity {
    EditText nome, telefone, data, endereco;
    Button btsalvar,btalterar;
    Long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_proprietario);
        Intent intent = getIntent();

        id = (Long) intent.getSerializableExtra("id");

        String nomep = (String) intent.getSerializableExtra("nome");
        String enderecop = (String) intent.getSerializableExtra("endereco");
        String telefonep = (String) intent.getSerializableExtra("telefone");
        String datap = (String) intent.getSerializableExtra("data");

        EditText nome = (EditText) findViewById(R.id.nome);
        nome.setText(nomep);

        EditText endereco = (EditText) findViewById(R.id.endereco);
        endereco.setText(enderecop);

        EditText telefone = (EditText) findViewById(R.id.telefone);
        telefone.setText(telefonep);

        EditText data = (EditText) findViewById(R.id.data);
        data.setText(datap);

        btsalvar = (Button) findViewById(R.id.bSalvar);
        btalterar = (Button) findViewById(R.id.bAlterar);
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

        if (id != 0) {
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
        nome = (EditText) findViewById(R.id.nome);
        endereco = (EditText) findViewById(R.id.endereco);
        telefone = (EditText) findViewById(R.id.telefone);
        data = (EditText) findViewById(R.id.data);

        Proprietario proprietario = new Proprietario(nome.getText().toString(),endereco.getText().toString(),
                telefone.getText().toString(), data.getText().toString());
        proprietario.save();

        Toast.makeText(this,"Proprietário Cadastrado!",Toast.LENGTH_LONG).show();
        this.finish();
    }
    public void alterar() {
        nome = (EditText) findViewById(R.id.nome);
        endereco = (EditText) findViewById(R.id.endereco);
        telefone = (EditText) findViewById(R.id.telefone);
        data = (EditText) findViewById(R.id.data);

        Proprietario proprietario = Proprietario.findById(Proprietario.class, id);

        proprietario.setNome(nome.getText().toString());
        proprietario.setEndereco(endereco.getText().toString());
        proprietario.setTelefone(telefone.getText().toString());
        proprietario.setData(data.getText().toString());
        proprietario.save();

        Toast.makeText(this,"Proprietário Alterado",Toast.LENGTH_LONG).show();
        this.finish();
    }
}
