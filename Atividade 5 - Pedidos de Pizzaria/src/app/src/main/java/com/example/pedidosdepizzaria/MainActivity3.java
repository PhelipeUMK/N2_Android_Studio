package com.example.pedidosdepizzaria;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    TextView resultado;
    String pizzas, tamanho, pagamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        resultado = findViewById(R.id.txtResultadoFinal);

        pizzas = getIntent().getStringExtra("pizzas");
        tamanho = getIntent().getStringExtra("tamanho");
        pagamento = getIntent().getStringExtra("pagamento");

        resultado.setText("Resumo:\n Sabor(es) escolhido(s): " + pizzas +
                "\n Tamanho escolhido: " + tamanho +
                "\n Forma de pagamento: " + pagamento);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}