package com.example.pedidosdepizzaria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    CheckBox c1, c2, c3;
    Button buttonPizzas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        c1 = findViewById(R.id.cb1);
        c2 = findViewById(R.id.cb2);
        c3 = findViewById(R.id.cb3);

        buttonPizzas = findViewById(R.id.btnPizzas);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        buttonPizzas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pizzas = "";

                if (c1.isChecked()) {
                    pizzas += "mussarela ";
                }
                if (c1.isChecked()) {
                    pizzas += "calabresa ";
                }
                if (c1.isChecked()) {
                    pizzas += "portuguesa ";
                }

                Intent telaPagamento = new Intent(MainActivity.this, MainActivity2.class);
                telaPagamento.putExtra("pizzas", pizzas);
            }
        });
    }
}