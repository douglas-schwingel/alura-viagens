package br.com.alura.aluraviagens.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.models.Pacote;
import br.com.alura.aluraviagens.util.DiasUtil;
import br.com.alura.aluraviagens.util.ImagemUtil;
import br.com.alura.aluraviagens.util.MoedaUtil;

public class ListaPacotesAdapter extends BaseAdapter{


    private final List<Pacote> pacotes;
    private final Context context;

    public ListaPacotesAdapter(Context context, List<Pacote> pacotes) {
        this.context = context;
        this.pacotes = pacotes;
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Pacote getItem(int posicao) {
        return pacotes.get(posicao);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int posicao, View convertView, ViewGroup parent) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent,false);
        Pacote pacote = pacotes.get(posicao);

        mostraPacote(viewCriada, pacote);

        return viewCriada;
    }

    private void mostraPacote(View viewCriada, Pacote pacote) {
        populaLocal(viewCriada, pacote);
        populaImagem(viewCriada, pacote);
        populaDias(viewCriada, pacote);
        populaPreco(viewCriada, pacote);
    }

    private void populaPreco(View viewCriada, Pacote pacote) {
        TextView campoPreco = viewCriada.findViewById(R.id.item_pacote_preco);
        String moedaBrasileira = MoedaUtil.formataParaReais(pacote.getPreco());
        campoPreco.setText(moedaBrasileira);
    }



    private void populaDias(View viewCriada, Pacote pacote) {
        TextView campoDias = viewCriada.findViewById(R.id.item_pacote_dias);
        String dias = DiasUtil.formataDiaEmTexto(pacote.getDias());
        campoDias.setText(dias);
    }


    private void populaImagem(View viewCriada, Pacote pacote) {
        ImageView campoImagem = viewCriada.findViewById(R.id.item_pacote_image);
        Drawable drawableImagemPacote = ImagemUtil.devolveDrawable(pacote.getImagem(), context);
        campoImagem.setImageDrawable(drawableImagemPacote);
    }



    private void populaLocal(View viewCriada, Pacote pacote) {
        TextView campoLocal = viewCriada.findViewById(R.id.item_pacote_local);
        campoLocal.setText(pacote.getLocal());
    }
}
