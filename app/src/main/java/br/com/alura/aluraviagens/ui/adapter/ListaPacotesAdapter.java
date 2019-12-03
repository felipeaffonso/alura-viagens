package br.com.alura.aluraviagens.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.util.DiasUtil;
import br.com.alura.aluraviagens.util.MoedaUtil;
import br.com.alura.aluraviagens.util.ResourceUtil;

import static android.view.LayoutInflater.from;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private final Context context;

    public ListaPacotesAdapter(final List<Pacote> pacotes, final Context context) {
        this.pacotes = pacotes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.pacotes.size();
    }

    @Override
    public Pacote getItem(int position) {
        return this.pacotes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View viewCriada = from(context).inflate(R.layout.item_pacote, parent, false);

        final Pacote pacote = pacotes.get(position);

        mostraLocal(viewCriada, pacote);
        mostraImagem(viewCriada, pacote);
        mostraDias(viewCriada, pacote);
        mostraPreco(viewCriada, pacote);

        return viewCriada;
    }

    private void mostraPreco(View viewCriada, Pacote pacote) {
        final TextView preco = viewCriada.findViewById(R.id.item_pacote_preco);
        preco.setText( MoedaUtil.formataParaBrasileiro(pacote.getPreco()));
    }

    private void mostraDias(View viewCriada, Pacote pacote) {
        final TextView dias = viewCriada.findViewById(R.id.item_pacote_dias);
        String diasEmTexto = DiasUtil.formataDiasEmTexto(pacote.getDias());
        dias.setText(diasEmTexto);
    }


    private void mostraImagem(View viewCriada, Pacote pacote) {
        final ImageView imagem = viewCriada.findViewById(R.id.item_pacote_imagem);

        final Drawable drawableImagemPacote = ResourceUtil.devolveDrawable(context, pacote.getImagem());
        imagem.setImageDrawable(drawableImagemPacote);
    }


    private void mostraLocal(View viewCriada, Pacote pacote) {
        final TextView local = viewCriada.findViewById(R.id.item_pacote_local);

        local.setText(pacote.getLocal());
    }

}
