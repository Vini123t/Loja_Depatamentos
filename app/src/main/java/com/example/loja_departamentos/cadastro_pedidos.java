package com.example.loja_departamentos;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loja_departamentos.Modelo.Cliente;
import com.example.loja_departamentos.Controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;



public class cadastro_pedidos extends AppCompatActivity {
    private Spinner spinnerClientes;
    private int numeroPedido = 1;
    private Spinner spinnerItensVenda;
    private EditText editTextQuantidade;
    private EditText editTextValorUnitario;
    private Button btnAdicionarItem;
    private ListView listViewItensPedido;
    private List<String> itensAdicionados = new ArrayList<>();
    private ArrayAdapter<String> adapterItensPedido;
    private TextView tvValorTotalItens;
    private RadioGroup radioGroupCondicaoPagamento;
    private RadioButton radioButtonAVista;
    private RadioButton radioButtonAPrazo;
    private EditText editTextQuantidadeParcelas;
    private ListView listViewParcelas;
    private List<String> parcelas = new ArrayList<>();
    private ArrayAdapter<String> adapterParcelas;
    private TextView tvValorTotalPedido;
    private Button btnConcluirPedido;

    private Cliente cliente;

    private ArrayList<Cliente>listaCliente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pedidos);
        spinnerClientes = findViewById(R.id.spinnerClientes);
        spinnerItensVenda = findViewById(R.id.spinnerItensVenda);
        editTextQuantidade = findViewById(R.id.editTextQuantidade);
        editTextValorUnitario = findViewById(R.id.editTextValorUnitario);
        btnAdicionarItem = findViewById(R.id.btnAdicionarItem);
        listViewItensPedido = findViewById(R.id.listViewItensPedido);
        tvValorTotalItens = findViewById(R.id.tvValorTotalItens);
        radioGroupCondicaoPagamento = findViewById(R.id.radioGroupCondicaoPagamento);
        radioButtonAVista = findViewById(R.id.radioButtonAVista);
        radioButtonAPrazo = findViewById(R.id.radioButtonAPrazo);
        editTextQuantidadeParcelas = findViewById(R.id.editTextQuantidadeParcelas);
        listViewParcelas = findViewById(R.id.listViewParcelas);
        tvValorTotalPedido = findViewById(R.id.tvValorTotalPedido);
        btnConcluirPedido = findViewById(R.id.btnConcluirPedido);

        carregarcliente();
        adicionarItemAoPedido();
        concluirPedido();

    }

    private void carregarcliente(){
        listaCliente = Controller.getInstance().retornarCliente();
        String[]vetClientes = new String[listaCliente.size()];
        for (int i = 0; i < listaCliente.size(); i++) {
            Cliente Cliente = listaCliente.get(i);
            vetClientes[i] = Cliente.getNome();
        }
        ArrayAdapter adapter = new ArrayAdapter(cadastro_pedidos.this,
                android.R.layout.simple_dropdown_item_1line, vetClientes);

        spinnerClientes.setAdapter(adapter);
    }



    private void adicionarItemAoPedido() {
        String quantidadeStr = editTextQuantidade.getText().toString();
        String valorUnitarioStr = editTextValorUnitario.getText().toString();

        if (quantidadeStr.isEmpty() || valorUnitarioStr.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }

        double quantidade = Double.parseDouble(quantidadeStr);
        double valorUnitario = Double.parseDouble(valorUnitarioStr);

        if (quantidade <= 0 || valorUnitario <= 0) {
            Toast.makeText(this, "Quantidade e valor devem ser maiores que zero", Toast.LENGTH_SHORT).show();
            return;
        }


        double valorItem = quantidade * valorUnitario;
        DecimalFormat df = new DecimalFormat("#.00");
        String item = "Descrição: " + spinnerItensVenda.getSelectedItem().toString() +
                "\nQuantidade: " + quantidadeStr +
                "\nValor Unitário: " + valorUnitarioStr +
                "\nValor Total: " + df.format(valorItem);
        itensAdicionados.add(item);
        adapterItensPedido.notifyDataSetChanged();


        double totalItens = calcularTotalItens();
        tvValorTotalItens.setText("Total dos Itens: R$" + df.format(totalItens));


        editTextQuantidade.setText("");
        editTextValorUnitario.setText("");
    }

    private double calcularTotalItens() {
        double total = 0;
        for (String item : itensAdicionados) {
            String[] parts = item.split("\nValor Total: ");
            String valorTotalStr = parts[1].replace(",", ".");
            total += Double.parseDouble(valorTotalStr);
        }
        return total;
    }
    private void concluirPedido() {

        String codigoPedido = "PED" + String.format("%03d", numeroPedido);


        Toast.makeText(this, "Pedido " + codigoPedido + " cadastrado com sucesso!", Toast.LENGTH_SHORT).show();


        numeroPedido++;

        editTextQuantidade.setText("");
        editTextValorUnitario.setText("");
        itensAdicionados.clear();
        adapterItensPedido.notifyDataSetChanged();


        radioGroupCondicaoPagamento.clearCheck();
        editTextQuantidadeParcelas.setText("");
        parcelas.clear();
        adapterParcelas.notifyDataSetChanged();


        tvValorTotalItens.setText("Total dos Itens: R$0.00");
        tvValorTotalPedido.setText("Valor Total do Pedido: R$0.00");


    }


}





