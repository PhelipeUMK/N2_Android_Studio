package com.example.pedidosdepizzaria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    RadioButton tamanho1, tamanho2, tamanho3, pagamento1, pagamento2, pagamento3;
    Button buttonPagamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        buttonPagamento = findViewById(R.id.btnPagamento);
        tamanho1 = findViewById(R.id.rbTamanho1);
        tamanho2 = findViewById(R.id.rbTamanho2);
        tamanho3 = findViewById(R.id.rbTamanho3);
        pagamento1 = findViewById(R.id.rbPagamento1);
        pagamento2 = findViewById(R.id.rbPagamento2);
        pagamento3 = findViewById(R.id.rbPagamento3);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        buttonPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tamanho = "campo vazio";
                String pagamento = "campo vazio";

                if (tamanho1.isChecked()) {
                    tamanho = "brotinho";
                }
                if (tamanho2.isChecked()) {
                    tamanho = "médio";
                }
                if (tamanho3.isChecked()) {
                    tamanho = "grande";
                }
                if (pagamento1.isChecked()) {
                    pagamento = "pix";
                }
                if (pagamento2.isChecked()) {
                    pagamento = "débito";
                }
                if (pagamento3.isChecked()) {
                    pagamento = "crédito";
                }
                String pizzas = getIntent().getStringExtra("pizzas");
                Intent telaFinal = new Intent(MainActivity2.this, MainActivity3.class);
                telaFinal.putExtra("pizzas", pizzas);
                telaFinal.putExtra("tamanho", tamanho);
                telaFinal.putExtra("pagamento", pagamento);
                startActivity(telaFinal);
                finish();
            }
        });
    }
}