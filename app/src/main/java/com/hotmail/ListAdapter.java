package com.hotmail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private final RecyclerViewerInterface recyclerViewerInterface;
    private final List<ListaElementos> myData;
    private final LayoutInflater myInflater;
    private final Context myContext;

    public ListAdapter(List<ListaElementos> itemList, Context context,
                       RecyclerViewerInterface recyclerViewerInterface){
        this.myData = itemList;
        this.myInflater = LayoutInflater.from(context);
        this.myContext = context;
        this.recyclerViewerInterface = recyclerViewerInterface;
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = myInflater.inflate(R.layout.list_element, null);
        return new ViewHolder(view, recyclerViewerInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
        holder.bindData(myData.get(position));
    }

    @Override
    public int getItemCount() {
        return myData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iconImage;
        TextView name, asunto, cuerpo, hora;

        ImageView leer;

        public ViewHolder(@NonNull View itemView, RecyclerViewerInterface recyclerViewerInterface) {
            super(itemView);
            iconImage = itemView.findViewById(R.id.iconoImageView);
            name = itemView.findViewById(R.id.nameTextView);
            asunto = itemView.findViewById(R.id.asuntoTextView);
            cuerpo = itemView.findViewById(R.id.cuerpoTextView);
            hora = itemView.findViewById(R.id.horaTextView);
            leer = itemView.findViewById(R.id.lectura);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewerInterface != null){
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION){
                            recyclerViewerInterface.OnItemClick(pos);
                        }
                    }
                }
            });
        }

        void bindData(final ListaElementos item){
            iconImage.setImageResource(item.getImagen());
            name.setText(item.getName());
            asunto.setText(item.getAsunto());
            cuerpo.setText(item.getCuerpo());
            hora.setText(item.getHora());
            if (item.isLeer()){
                leer.setVisibility(View.VISIBLE);
            }else{
                leer.setVisibility(View.GONE);
            }
        }
    }
}
