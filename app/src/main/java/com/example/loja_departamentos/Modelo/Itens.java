package com.example.loja_departamentos.Modelo;

public class Itens {

    private  int Id;

    private String Descricao;
    private Double  ValorUnitario;

    public Itens() {
    }

    public Itens(int id, String descricao, Double valorUnitario) {
        Id = id;
        Descricao = descricao;
        ValorUnitario = valorUnitario;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public Double getValorUnitario() {
        return ValorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        ValorUnitario = valorUnitario;
    }
}
