package com.example.pedidosdelanchonete;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    Button voltar;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        resultado = findViewById(R.id.txtResultado);

        String nomeRecebido = getIntent().getStringExtra("nome");
        String lancheRecebido = getIntent().getStringExtra("lanche");

        if (lancheRecebido == "Você não selecionou nenhum lanche.") {
            resultado.setText(nomeRecebido+ ", "  + lancheRecebido);
        } else {
            resultado.setText("Pronto, " + nomeRecebido +". O seu " + lancheRecebido + " está já foi preparado.");
        }

        voltar = findViewById(R.id.btnVoltar);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}