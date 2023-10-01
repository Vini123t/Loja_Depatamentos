package com.example.loja_departamentos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btCadastroCliente;

    private Button btCadastroVendedor;

    private Button btCadastroItens;

    private Button btCadastroPedidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCadastroCliente = findViewById(R.id.btCadastroCliente);

        btCadastroVendedor = findViewById(R.id.btCadastroVendedor);

        btCadastroItens = findViewById(R.id.btCadastroItens);

        btCadastroPedidos = findViewById(R.id.btCadastroPedidos);



        btCadastroCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirActivity(Cadastro_cliente.class);
            }
        });

        btCadastroVendedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirActivity(Cadastro_vendedor.class);
            }
        });
        btCadastroItens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirActivity(cadastro_itens.class);
            }
        });
        btCadastroPedidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirActivity(cadastro_pedidos.class);
            }
        });


    }
    private void abrirActivity(Class<?> activity) {
        Intent intent = new Intent(MainActivity.this,activity);
        startActivity(intent);


    }
}