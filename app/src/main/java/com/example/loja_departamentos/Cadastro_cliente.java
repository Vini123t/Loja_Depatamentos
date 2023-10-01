package com.example.loja_departamentos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loja_departamentos.Modelo.Cliente;

public class Cadastro_cliente extends AppCompatActivity {

    private Button btSalvar;
    private EditText edNomeCliente;
    private EditText edCpfCliente;

    private TextView tvClientesCadastrados;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);

        btSalvar = findViewById(R.id.btSalvar);
        edNomeCliente = findViewById(R.id.edNomeCliente);
        edCpfCliente = findViewById(R.id.edCpfCliente);
        tvClientesCadastrados = findViewById(R.id.tvClientesCadastrados);

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarCliente();
            }
        });

        atualizarListaClientes();



    }

    private void salvarCliente() {
        if(edNomeCliente.getText().toString().isEmpty()){
            edNomeCliente.setError("Informe o Nome do Cliente!");
            return;
        }
        if(edCpfCliente.getText().toString().isEmpty()){
            edCpfCliente.setError("Informe o CPF do Cliente!");
            return;
        }
        Cliente cliente = new Cliente();

        cliente.setNome(edNomeCliente.getText().toString());
        cliente.setCpf(edCpfCliente.getText().toString());

        Controller.getInstance().salvarCliente(cliente);


        Toast.makeText(Cadastro_cliente.this,
                    "Cliente Cadastrado com Sucesso!!",
                Toast.LENGTH_LONG).show();

        this.finish();
    }


    private void atualizarListaClientes(){
        String texto = "";
        for (Cliente cliente : Controller.getInstance().retornarCliente()) {
            texto += "Nome: "+cliente.getNome()+" - "+cliente.getCpf()+"\n";

        }
        tvClientesCadastrados.setText(texto);
    }
    private void limparCampos() {
        edNomeCliente.getText().clear();
        edCpfCliente.getText().clear();
    }



}