package br.facapccp.n1_checkbox;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //declarando as variáveis
    private CheckBox opcao1, opcao2, opcao3, opcao4, opcao5;

    private Button btnCalcular;

    private TextView txtTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Instanciando os elementos
        btnCalcular = findViewById(R.id.btnCalcular);
        opcao1 = findViewById(R.id.cbOpcao1);
        opcao2 = findViewById(R.id.cbOpcao2);
        opcao3 = findViewById(R.id.cbOpcao3);
        opcao4 = findViewById(R.id.cbOpcao4);
        opcao5 = findViewById(R.id.cbOpcao5);
        txtTotal = findViewById(R.id.txtTotal);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Montando a lógica do app

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double total = 0.00;
                if (opcao1.isChecked()) {
                    total += 12.99;
                }
                if (opcao2.isChecked()) {
                    total += 8.89;
                }
                if (opcao3.isChecked()) {
                    total += 7.50;
                }
                if (opcao4.isChecked()) {
                    total += 15.00;
                }
                if (opcao5.isChecked()) {
                    total += 6.00;
                }
                txtTotal.setText("Total: R$" + String.format("%.2f", total));
            }
        });
    }
}