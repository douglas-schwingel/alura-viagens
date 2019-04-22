package br.com.alura.aluraviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.dao.PacoteDAO;
import br.com.alura.aluraviagens.models.Pacote;
import br.com.alura.aluraviagens.ui.adapter.ListaPacotesAdapter;

import static br.com.alura.aluraviagens.ui.activity.PacoteActivityContstantes.CHAVE_PACOTE;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String TITULO_APP_BAR = "Pacotes";
    private List<Pacote> pacotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);

        setTitle(TITULO_APP_BAR);

        configuraLista();

    }

    private void configuraLista() {
        pacotes = new PacoteDAO().lista();
        final ListView listaPacotes = findViewById(R.id.lista_pacotes);
        listaPacotes.setAdapter(new ListaPacotesAdapter(this, pacotes));
        listaPacotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pacote pacoteClicado = pacotes.get(position);
                vaiParaResumoPacote(pacoteClicado);
            }
        });

    }

    private void vaiParaResumoPacote(Pacote pacoteClicado) {
        Intent intent = new Intent(ListaPacotesActivity.this, ResumoPacoteActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacoteClicado);
        criaToast(pacoteClicado);
        startActivity(intent);
    }

    private void criaToast(Pacote pacoteClicado) {
        Toast.makeText(ListaPacotesActivity.this,
                "Pacote " + pacoteClicado.getLocal() + " selecionado...", Toast.LENGTH_SHORT).show();
    }
}
