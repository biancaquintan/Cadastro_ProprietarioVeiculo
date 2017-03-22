package com.example.davispc10.proprietario_david.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by aluno on 20/03/17.
 */

public class Veiculo extends SugarRecord {
    private String placa, modelo, ano;
    private Proprietario proprietario;

    public Veiculo(String placa, String modelo, String ano, Proprietario proprietario) {
        this.placa = placa;
        this.modelo = modelo;
        this.ano = ano;
        this.proprietario = proprietario;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }
}