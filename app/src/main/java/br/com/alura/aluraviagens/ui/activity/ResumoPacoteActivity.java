package br.com.alura.aluraviagens.ui.activity;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.models.Pacote;
import br.com.alura.aluraviagens.util.DataUtil;
import br.com.alura.aluraviagens.util.DiasUtil;
import br.com.alura.aluraviagens.util.ImagemUtil;
import br.com.alura.aluraviagens.util.MoedaUtil;

import static br.com.alura.aluraviagens.ui.activity.PacoteActivityContstantes.CHAVE_PACOTE;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITULO_APP_BAR = "Resumo do Pacote";
    public Pacote pacote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        setTitle(TITULO_APP_BAR);
        carregaPacoteRecebido();


    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if(intent.hasExtra(CHAVE_PACOTE)) {
            pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);

            inicializaCampos();
            configuraBotao();
        }
    }

    private void configuraBotao() {
        Button botaoRealizarPagamento = findViewById(R.id.resumo_pacote_realizar_pagamento);
        botaoRealizarPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResumoPacoteActivity.this, PagamentoActivity.class);
                intent.putExtra(CHAVE_PACOTE, pacote);
                startActivity(intent);
            }
        });
    }

    private void inicializaCampos() {
        populaImagem(pacote);
        populaLocal(pacote);
        populaDias(pacote);
        populaData(pacote);
        populaPreco(pacote);
    }

    private void populaPreco(Pacote pacote) {
        TextView campoPreco = findViewById(R.id.resumo_pacote_preco);
        campoPreco.setText(MoedaUtil.formataParaReais(pacote.getPreco()));
    }

    private void populaData(Pacote pacote) {
        TextView campoData = findViewById(R.id.resumo_pacote_data);
        String dataFinal = DataUtil.formataData(pacote.getDias());
        campoData.setText(dataFinal);
    }


    private void populaDias(Pacote pacote) {
        TextView campoDias = findViewById(R.id.resumo_pacote_dias);
        campoDias.setText(DiasUtil.formataDiaEmTexto(pacote.getDias()));
    }

    private void populaLocal(Pacote pacote) {
        TextView campoLocal = findViewById(R.id.resumo_pacote_local);
        campoLocal.setText(pacote.getLocal());
    }

    private void populaImagem(Pacote pacote) {
        ImageView campoImagem = findViewById(R.id.resumo_pacote_imagem);
        campoImagem.setImageDrawable(ImagemUtil.devolveDrawable(pacote.getImagem(), this));
    }
}
