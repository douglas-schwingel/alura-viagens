package br.com.alura.aluraviagens.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.models.Pacote;
import br.com.alura.aluraviagens.util.DataUtil;
import br.com.alura.aluraviagens.util.ImagemUtil;
import br.com.alura.aluraviagens.util.MoedaUtil;

import static br.com.alura.aluraviagens.ui.activity.PacoteActivityContstantes.CHAVE_PACOTE;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo da Compra";
    private Pacote pacote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);

        setTitle(TITULO_APPBAR);

        carregaPacoteRecebido();
        carregaBotao();

    }

    private void carregaBotao() {
        Button botaoRetorno = findViewById(R.id.resumo_compra_botao_inicio);
        botaoRetorno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResumoCompraActivity.this, ListaPacotesActivity.class);
                startActivity(intent);
            }
        });
    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if(intent.hasExtra(CHAVE_PACOTE)){
            pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);

            inicializaCampos();
        }
    }

    private void inicializaCampos() {
        populaImagem(pacote);
        populaLocal(pacote);
        populaData(pacote);
        populaPreco(pacote);
    }

    private void populaPreco(Pacote pacote) {
        TextView campoPreco = findViewById(R.id.resumo_compra_preco);
        campoPreco.setText(MoedaUtil.formataParaReais(pacote.getPreco()));
    }

    private void populaData(Pacote pacote) {
        TextView campoData = findViewById(R.id.resumo_compra_data);
        campoData.setText(DataUtil.formataData(pacote.getDias()));
    }

    private void populaLocal(Pacote pacote) {
        TextView campoLocal = findViewById(R.id.resumo_compra_local);
        campoLocal.setText(pacote.getLocal());
    }

    private void populaImagem(Pacote pacote) {
        ImageView campoImagem = findViewById(R.id.resumo_compra_imagem_pacote);
        campoImagem.setImageDrawable(ImagemUtil.devolveDrawable(pacote.getImagem(), this));
    }
}
