package com.hotmail;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    TextView nameTextView, asuntoTextView, cuerpoTextView, horaTextView, descripTextView;
    ImageView iconImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        String name = getIntent().getStringExtra("Name");
        String asunto = getIntent().getStringExtra("Asunto");
        String cuerpo = getIntent().getStringExtra("Cuerpo");
        String hora = getIntent().getStringExtra("Hora");
        String descrip = getIntent().getStringExtra("Descrip");
        int imagen = getIntent().getIntExtra("Imagen", 0);

        nameTextView = findViewById(R.id.nameTextView2);
        asuntoTextView = findViewById(R.id.asuntoTextView2);
        cuerpoTextView = findViewById(R.id.cuerpoTextView2);
        horaTextView = findViewById(R.id.horaTextView2);
        descripTextView = findViewById(R.id.descripTextView2);
        iconImageView = findViewById(R.id.iconoImageView2);


        nameTextView.setText(name);
        asuntoTextView.setText(asunto);
        cuerpoTextView.setText(cuerpo);
        horaTextView.setText(hora);
        descripTextView.setText(descrip);
        iconImageView.setImageResource(imagen);
    }
}