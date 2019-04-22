package br.com.alura.aluraviagens.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.models.Pacote;
import br.com.alura.aluraviagens.util.MoedaUtil;

import static br.com.alura.aluraviagens.ui.activity.PacoteActivityContstantes.CHAVE_PACOTE;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pagamento";
    private Pacote pacote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        setTitle(TITULO_APPBAR);

        carregaPacoteRecebido();


    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if(intent.hasExtra(CHAVE_PACOTE)) {
            pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);

            mostraPreco(pacote);
            configuraBotao();
        }
    }

    private void configuraBotao() {
        Button botaoFinalizarCompra = findViewById(R.id.pagamento_botao_finaliza_compra);
        botaoFinalizarCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
                intent.putExtra(CHAVE_PACOTE, pacote);
                startActivity(intent);
            }
        });
    }

    private void mostraPreco(Pacote pacote) {
        TextView campoPreco = findViewById(R.id.pagamento_preco_pacote);
        campoPreco.setText(MoedaUtil.formataParaReais(pacote.getPreco()));
    }
}
