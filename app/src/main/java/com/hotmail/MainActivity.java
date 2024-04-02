package com.hotmail;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

public class MainActivity extends AppCompatActivity implements RecyclerViewerInterface{
    List<ListaElementos> elementos;
    String[] descrip = {
            "Mi nombre es Julian Ramirez, soy programador backend, manejo Java, Ruby y PHP. En este correo te adjunto mi CV u hoja de vida.",
            "Tenemos ciertas propuestas para la proxima actualización y para ello necesitamos que revisemos ciertos componentes, requisitos para la compatibilidad del proyecto con otros dispositivos.",
            "Ya hemos reunido bastante material para darle una nueva iamgen a nuestra pagina Web, te lo vamos a dejar un link a la carpeta en drive donde estaran los nuevos asets para su revision.",
            "Este correo es un pequeño recuerdo de que se acerca la fecha de pago de su factura, debes 152.800 COP$. Puedes pagar varios medios, Efecty, Visa Master Card y PSE.",
            "Vamos a festejar mi cumple años el 7 de mayo a las 4PM en mi casa, vamos cantar, bailar, beber y comer unas comidas riquizimas, para que no te lo pierdas."
    };
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
        elementos.add(new ListaElementos(imagen[0],"Pedro","Hoja de vida", "Hola, quisiera trabajar aqui","5:30 PM", descrip[0]));
        elementos.add(new ListaElementos(imagen[1], "Julian","Revision de Proyecto", "Tenemos que reunirnos para revisar el proyecto","7:50 AM", descrip[1]));
        elementos.add(new ListaElementos(imagen[2],"Monica","Update PaginaWeb", "Tenemos listo los asets para actualizar la pagina","8:28 AM",descrip[2]));
        elementos.add(new ListaElementos(imagen[3], "Samira","Recuerdo de Pago", "Por favor  pagar su factura ","7:00 AM",descrip[3]));
        elementos.add(new ListaElementos(imagen[4], "Daniel","Fiesta Invitacion", "Ven mi queridisimo amigo a mi fiesta","2:04 PM",descrip[4]));


        ListAdapter listAdapter = new ListAdapter(elementos,this, this);
        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }

    @Override
    public void OnItemClick(int position) {
        ListaElementos selected = elementos.get(position);
        selected.setLeer(true);
        saveStatus();

        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("Name", elementos.get(position).getName());
        intent.putExtra("Asunto", elementos.get(position).getAsunto());
        intent.putExtra("Cuerpo", elementos.get(position).getCuerpo());
        intent.putExtra("Hora", elementos.get(position).getHora());
        intent.putExtra("Imagen", elementos.get(position).getImagen());
        intent.putExtra("Descrip", elementos.get(position).getDescrip());

        startActivity(intent);
    }

    private void loadReadStatus() {
        SharedPreferences sharedPreferences = getSharedPreferences("EmailReadStatus", Context.MODE_PRIVATE);
        for (ListaElementos correo : elementos) {
            correo.setLeer(sharedPreferences.getBoolean(correo.getDescrip(), false));
        }
    }

    public void saveStatus(){
        SharedPreferences sharedPreferences = getSharedPreferences("EmailReadStatus", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        for (ListaElementos correo : elementos) {
            editor.putBoolean(correo.getDescrip(),correo.isLeer());
        }
        editor.apply();
    }
}