package com.example.salarioeaumento;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText campoSalario;
    Button calcular;
    TextView resultado;
    RadioButton opcao40, opcao45, opcao50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        campoSalario = findViewById(R.id.etSalario);
        calcular = findViewById(R.id.btnCalcular);
        resultado = findViewById(R.id.txtResultado);
        opcao40 = findViewById(R.id.rb40);
        opcao45 = findViewById(R.id.rb45);
        opcao50 = findViewById(R.id.rb50);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Double salario = Double.valueOf(campoSalario.getText().toString());

                if (opcao40.isChecked()) {
                    double novoSalario = salario * 1.4;
                    resultado.setText("Novo salário: R$" + String.format("%.2f", novoSalario));
                } else if (opcao45.isChecked()) {
                    double novoSalario = salario * 1.45;
                    resultado.setText("Novo salário: R$" + String.format("%.2f", novoSalario));
                } else if (opcao50.isChecked()) {
                    double novoSalario = salario * 1.5;
                    resultado.setText("Novo salário: R$" + String.format("%.2f", novoSalario));
                }
            }
        });
    }
}