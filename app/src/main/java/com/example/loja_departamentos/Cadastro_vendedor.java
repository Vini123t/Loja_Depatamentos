package com.example.loja_departamentos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



import com.example.loja_departamentos.Modelo.Vendedor;

public class Cadastro_vendedor extends AppCompatActivity {

    private Button btSalvar;
    private EditText edNomeVendedor;
    private EditText edCpfVendedor;

    private TextView tvVendedorCadastrados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_vendedor);

        btSalvar = findViewById(R.id.btSalvar);
        edNomeVendedor = findViewById(R.id.edNomeVendedor);
        edCpfVendedor = findViewById(R.id.edCpfVendedor);
        tvVendedorCadastrados = findViewById(R.id.tvVendedorCadastrados);

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarVendedor();
            }
        });

        atualizarListaVendedor();

    }
    private void salvarVendedor() {
        if(edNomeVendedor.getText().toString().isEmpty()){
            edNomeVendedor.setError("Informe o Nome do Vendedor!");
            return;
        }
        if(edCpfVendedor.getText().toString().isEmpty()){
            edCpfVendedor.setError("Informe o CPF do Vendedor!");
            return;
        }
        Vendedor vendedor = new Vendedor();

        vendedor.setNome(edNomeVendedor.getText().toString());
        vendedor.setCpf(edCpfVendedor.getText().toString());

        Controller.getInstance().salvarVendedor(vendedor);


        Toast.makeText(Cadastro_vendedor.this,
                "Vendedor Cadastrado com Sucesso!!",
                Toast.LENGTH_LONG).show();

        this.finish();
    }



    private void atualizarListaVendedor(){
        String texto = "";
        for (Vendedor vendedor : Controller.getInstance().retornarVendedor()) {
            texto += "Nome: "+vendedor.getNome()+" - "+vendedor.getCpf()+"\n";

        }
        tvVendedorCadastrados.setText(texto);
    }


}
