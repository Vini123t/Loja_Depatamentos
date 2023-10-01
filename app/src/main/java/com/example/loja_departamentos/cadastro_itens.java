package com.example.loja_departamentos;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loja_departamentos.Modelo.Itens;


public class cadastro_itens extends AppCompatActivity {
    private Button btSalvar;
    private EditText edCodItem;
    private EditText edNomeItem;
    private EditText edValorItem;

    private TextView tvItemsCadastrado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_itens);
        btSalvar = findViewById(R.id.btSalvar);
        edCodItem = findViewById(R.id.edCodItem);
        edNomeItem = findViewById(R.id.edNomeItem);
        edValorItem = findViewById(R.id.edValorItem);
        tvItemsCadastrado = findViewById(R.id.tvItemsCadastrado);

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvaItens();
            }
        });

        atualizarListaVendedor();

    }
    private void salvaItens() {
        if(edCodItem.getText().toString().isEmpty()){
            edCodItem.setError("Informe o codigo do item!");
            return;
        }
        if(edNomeItem.getText().toString().isEmpty()){
            edNomeItem.setError("Informe o nome do item!");
            return;
        }
        if(edValorItem.getText().toString().isEmpty()){
            edValorItem.setError("Informe o CPF do Vendedor!");
            return;
        }
        Itens itens = new Itens();

        itens.setId(Integer.parseInt(edCodItem.getText().toString()));
        itens.setDescricao(edNomeItem.getText().toString());
        itens.setValorUnitario(Double.parseDouble(edValorItem.getText().toString()));

        Controller.getInstance().salvaItens(itens);


        Toast.makeText(cadastro_itens.this,
                "Intes Cadastrado com Sucesso!!",
                Toast.LENGTH_LONG).show();

        this.finish();
    }
    private void atualizarListaVendedor(){
        String texto = "";
        for (Itens itens : Controller.getInstance().retornarItens()){
            texto += "Codigo: " + itens.getId() + " - " + "\n Nome: " + itens.getDescricao() + " - " +
                    "Valor Unitario: R$" + itens.getValorUnitario()+"\n";
        }
        tvItemsCadastrado.setText(texto);
    }


}
