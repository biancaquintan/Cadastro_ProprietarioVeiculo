package com.example.davispc10.proprietario_david.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.davispc10.proprietario_david.R;
import com.example.davispc10.proprietario_david.model.Veiculo;

import java.util.ArrayList;

/**
 * Created by aluno on 20/03/17.
 */

public class VeiculoAdapter  extends ArrayAdapter<Veiculo> {

    private Context context = null;
    private ArrayList<Veiculo> veiculos = null;

    public VeiculoAdapter(Context context, ArrayList<Veiculo> veiculos) {
        super(context, R.layout.linhaveiculo, veiculos);
        this.context = context;
        this.veiculos = veiculos;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context
          .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.linhaveiculo, parent, false);

        TextView modelo = (TextView) rowView.findViewById(R.id.tvllvModelo);
        //TextView placa = (TextView) rowView.findViewById(R.id.);
        TextView ano = (TextView) rowView.findViewById(R.id.tvllvAno);
        TextView proprietario = (TextView) rowView.findViewById(R.id.tvllvProprietario);

        modelo.setText(veiculos.get(position).getModelo());
        //placa.setText(veiculos.get(position).getPlaca());
        ano.setText(veiculos.get(position).getAno());
        proprietario.setText(veiculos.get(position).getProprietario().getNome());

        return rowView;
    }
}
