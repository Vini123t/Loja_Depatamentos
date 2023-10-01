package com.example.loja_departamentos;

import com.example.loja_departamentos.Modelo.Cliente;
import com.example.loja_departamentos.Modelo.Pedido;
import com.example.loja_departamentos.Modelo.Itens;
import com.example.loja_departamentos.Modelo.Vendedor;

import java.util.ArrayList;

public class Controller {

    private static Controller instancia;

    private ArrayList<Cliente> listaCliente;

    private ArrayList<Vendedor> listaVendedor;

    private ArrayList<Pedido> listaPedido;

    private ArrayList<Itens> listaItens;

    public static Controller getInstance(){
        if(instancia == null) {
            return instancia = new Controller();
        }else {
            return instancia;
        }
    }


    private Controller(){
        listaCliente = new ArrayList<>();
        listaVendedor = new ArrayList<>();
        listaPedido = new ArrayList<>();
        listaItens = new ArrayList<>();

    }
    public void salvarCliente(Cliente cliente){
        listaCliente.add(cliente);
    }

    public ArrayList<Cliente> retornarCliente() {
        return listaCliente;
    }

    public void salvarVendedor(Vendedor vendedor){
        listaVendedor.add(vendedor);
    }

    public ArrayList<Vendedor> retornarVendedor() {
        return listaVendedor;
    }

    public void salvarPedido(Pedido pedido){
        listaPedido.add(pedido);
    }

    public ArrayList<Pedido> retornarPedido() {
        return listaPedido;
    }

    public void salvaItens( Itens itens){
        listaItens.add(itens);
    }

    public ArrayList<Itens> retornarItens() {
        return listaItens;
    }





}
