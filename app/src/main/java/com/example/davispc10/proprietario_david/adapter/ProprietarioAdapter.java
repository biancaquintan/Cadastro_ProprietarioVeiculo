package com.example.davispc10.proprietario_david.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.davispc10.proprietario_david.R;
import com.example.davispc10.proprietario_david.model.Proprietario;

import java.util.ArrayList;

/**
 * Created by davispc10 on 10/03/17.
 */

public class ProprietarioAdapter extends ArrayAdapter<Proprietario> {
    private Context context = null;
    private ArrayList<Proprietario> proprietarios = null;

    public ProprietarioAdapter(Context context, ArrayList<Proprietario> proprietarios) {
        super(context, R.layout.linhaproprietario, proprietarios);
        this.context = context;
        this.proprietarios = proprietarios;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.linhaproprietario, parent, false);

        TextView nome = (TextView) rowView.findViewById(R.id.tvllvNome);
        TextView telefone = (TextView) rowView.findViewById(R.id.tvllvTelefone);

        nome.setText(proprietarios.get(position).getNome());
        telefone.setText(proprietarios.get(position).getTelefone());
        return rowView;
    }
}