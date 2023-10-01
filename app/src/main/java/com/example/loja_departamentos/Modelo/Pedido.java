package com.example.loja_departamentos.Modelo;

import java.util.ArrayList;

public class Pedido {
    private int ID;
    private int CodigoPedido ;
    private Double DataPedido ;
    private Double ValorTotal ;
        private int CondiçãoPagamento;
    private int QuantidadeParcela;

    private ArrayList<Cliente> cliente;
    private ArrayList<Vendedor> Vendedor;

    private ArrayList<Itens> Itens;

    public Pedido() {
    }

    public Pedido(int ID, int codigoPedido, Double dataPedido, Double valorTotal, int condiçãoPagamento, int quantidadeParcela, ArrayList<Cliente> cliente, ArrayList<com.example.loja_departamentos.Modelo.Vendedor> vendedor, ArrayList<com.example.loja_departamentos.Modelo.Itens> itens) {
        this.ID = ID;
        CodigoPedido = codigoPedido;
        DataPedido = dataPedido;
        ValorTotal = valorTotal;
        CondiçãoPagamento = condiçãoPagamento;
        QuantidadeParcela = quantidadeParcela;
        this.cliente = cliente;
        Vendedor = vendedor;
        Itens = itens;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCodigoPedido() {
        return CodigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        CodigoPedido = codigoPedido;
    }

    public Double getDataPedido() {
        return DataPedido;
    }

    public void setDataPedido(Double dataPedido) {
        DataPedido = dataPedido;
    }

    public Double getValorTotal() {
        return ValorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        ValorTotal = valorTotal;
    }

    public int getCondiçãoPagamento() {
        return CondiçãoPagamento;
    }

    public void setCondiçãoPagamento(int condiçãoPagamento) {
        CondiçãoPagamento = condiçãoPagamento;
    }

    public int getQuantidadeParcela() {
        return QuantidadeParcela;
    }

    public void setQuantidadeParcela(int quantidadeParcela) {
        QuantidadeParcela = quantidadeParcela;
    }

    public ArrayList<Cliente> getCliente() {
        return cliente;
    }

    public void setCliente(ArrayList<Cliente> cliente) {
        this.cliente = cliente;
    }

    public ArrayList<com.example.loja_departamentos.Modelo.Vendedor> getVendedor() {
        return Vendedor;
    }

    public void setVendedor(ArrayList<com.example.loja_departamentos.Modelo.Vendedor> vendedor) {
        Vendedor = vendedor;
    }

    public ArrayList<com.example.loja_departamentos.Modelo.Itens> getItens() {
        return Itens;
    }

    public void setItens(ArrayList<com.example.loja_departamentos.Modelo.Itens> itens) {
        Itens = itens;
    }
}
