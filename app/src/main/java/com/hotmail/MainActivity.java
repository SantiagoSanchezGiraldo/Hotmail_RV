package com.hotmail;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<ListaElementos> elementos;
    int[] imagen ={
            R.drawable.m1,
            R.drawable.m3,
            R.drawable.w1,
            R.drawable.w2,
            R.drawable.m2
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
    }

    public void  init(){
        elementos = new ArrayList<>();
        elementos.add(new ListaElementos(imagen[0],"Pedro","Hoja de vida", "Hola, quisiera trabajar aqui","5:30 PM"));
        elementos.add(new ListaElementos(imagen[1], "Julian","Revision de Proyecto", "Tenemos que reunirnos para revisar el proyecto","7:50 AM"));
        elementos.add(new ListaElementos(imagen[2],"Monica","Update PaginaWeb", "Tenemos listo los asets para actualizar la pagina","8:28 AM"));
        elementos.add(new ListaElementos(imagen[3], "Samira","Recuerdo de Pago", "Por favor recuerde pagar su factura ","7:00 AM"));
        elementos.add(new ListaElementos(imagen[4], "Daniel","Fiesta Invitacion", "Ven mi buen amigo a mi fiesta a las 4PM","2:04 PM"));


        ListAdapter listAdapter = new ListAdapter(elementos,this);
        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }
}