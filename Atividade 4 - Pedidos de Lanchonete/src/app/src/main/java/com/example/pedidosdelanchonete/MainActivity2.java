package com.example.pedidosdelanchonete;

import android.content.Intent;
import android.location.GnssAntennaInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private EditText textNome;
    private RadioButton rb1, rb2, rb3;
    private Button proximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        textNome = findViewById(R.id.etNome);
        String nome = textNome.getText().toString();

        proximo = findViewById(R.id.btnLanche);

        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lanche;
                if (rb1.isChecked()) {
                    lanche = "Hamburguer";
                }
                else if (rb2.isChecked()) {
                    lanche = "Bauru";
                }
                else if (rb3.isChecked()) {
                    lanche = "Hot Dog";
                } else {
                    lanche = "Você não selecionou nenhum lanche.";
                }

                Intent telaFinal = new Intent(MainActivity2.this, MainActivity3.class);
                telaFinal.putExtra("nome", nome);
                telaFinal.putExtra("lanche", lanche);
                startActivity(telaFinal);
                finish();
            }
        });


    }
}