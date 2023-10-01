package com.example.loja_departamentos.Modelo;

public class Vendedor {

    private String nome;

    private String Cpf;

    public Vendedor( ) {

    }

    public Vendedor(String nome, String cpf) {
        this.nome = nome;
        Cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        Cpf = cpf;
    }
}
