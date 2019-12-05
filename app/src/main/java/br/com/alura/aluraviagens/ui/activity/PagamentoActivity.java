package br.com.alura.aluraviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.util.MoedaUtil;

import static br.com.alura.aluraviagens.ui.activity.PacoteActivityConstants.CHAVE_PACOTE;

public class PagamentoActivity extends AppCompatActivity {

    private static final String TITLE_APPBAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        setTitle(TITLE_APPBAR);

        carregaPacoteRecebido();

    }

    private void carregaPacoteRecebido() {
        final Intent intent = getIntent();

        if(intent.hasExtra(CHAVE_PACOTE)) {
            final Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);

            mostraPreco(pacote);

            configuraBotaoFinalizaCompra(pacote);
        }
    }

    private void configuraBotaoFinalizaCompra(final Pacote pacote) {
        Button botaoFinaliza = findViewById(R.id.pagamento_botao_finaliza_compra);
        botaoFinaliza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vaiParaResumoCompra(pacote);
            }
        });
    }

    private void vaiParaResumoCompra(Pacote pacote) {
        final Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_preco_pacote);
        final String precoPacoteFormatado = MoedaUtil.formataParaBrasileiro(pacote.getPreco());
        preco.setText(precoPacoteFormatado);
    }
}
