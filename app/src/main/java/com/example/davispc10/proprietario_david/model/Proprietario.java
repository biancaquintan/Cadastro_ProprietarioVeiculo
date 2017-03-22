package com.example.davispc10.proprietario_david.model;

import com.orm.SugarApp;
import com.orm.SugarRecord;
import android.database.sqlite.*;
import android.os.Parcel;
import android.os.Parcelable;
import com.orm.dsl.Table;
import java.util.Date;
import java.util.List;

/**
 * Created by davispc10 on 10/03/17.
 */


public class Proprietario extends SugarRecord implements Parcelable {
    //private Long id;
    private String nome;
    private String endereco;
    private String telefone;
    private String data;

    public Proprietario(String nome, String endereco, String telefone, String data) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.data = data;
    }

    public List<Veiculo> getVeiculos() {
        return Veiculo.find(Veiculo.class, "proprietario = ?", new String(getId().toString()));
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {  this.telefone = telefone;   }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(endereco);
        dest.writeString(telefone);
        dest.writeString(data);
    }

    //public Long getId() {
//        return id;
//    }

    private Proprietario(Parcel from){
       // id = from.readLong();
        endereco = from.readString();
        nome = from.readString();
        telefone = from.readString();
        data = from.readString();
    }

    public static final Parcelable.Creator<Proprietario>
            CREATOR = new Parcelable.Creator<Proprietario>() {

        public Proprietario createFromParcel(Parcel in) {
            return new Proprietario(in);
        }

        public Proprietario[] newArray(int size) {
            return new Proprietario[size];
        }
    };

    @Override
    public String toString()
    {
        return nome;
    }
}
