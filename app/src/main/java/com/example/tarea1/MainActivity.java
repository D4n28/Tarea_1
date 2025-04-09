package com.example.tarea1;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView mensaje;
    Button btnAumentar, btnDecrementar, btnCambiarColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mensaje = findViewById(R.id.txtmensaje);
        btnAumentar = findViewById(R.id.btnAumentar);
        btnDecrementar = findViewById(R.id.btnDecrementar);
        btnCambiarColor = findViewById(R.id.btnCambiarColor);

        btnAumentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float size = mensaje.getTextSize() / getResources().getDisplayMetrics().scaledDensity;
                mensaje.setTextSize(TypedValue.COMPLEX_UNIT_SP, size + 2);
            }
        });

        btnDecrementar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float size = mensaje.getTextSize() / getResources().getDisplayMetrics().scaledDensity;
                if (size > 10) { // Evita que el texto sea demasiado pequeño
                    mensaje.setTextSize(TypedValue.COMPLEX_UNIT_SP, size - 2);
                }
            }
        });

        btnCambiarColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int color = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
                mensaje.setTextColor(color);
            }
        });
    }
}