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
    private final List<ListaElementos> myData;
    private final LayoutInflater myInflater;
    private final Context myContext;

    public ListAdapter(List<ListaElementos> itemList, Context context){
        this.myData = itemList;
        this.myInflater = LayoutInflater.from(context);
        this.myContext = context;
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = myInflater.inflate(R.layout.list_element, parent, false);
        return new ViewHolder(view);
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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iconImage = itemView.findViewById(R.id.iconoImageView);
            name = itemView.findViewById(R.id.nameTextView);
            asunto = itemView.findViewById(R.id.asuntoTextView);
            cuerpo = itemView.findViewById(R.id.cuerpoTextView);
            hora = itemView.findViewById(R.id.horaTextView);
        }

        void bindData(final ListaElementos item){
            iconImage.setImageResource(item.getImagen());
            name.setText(item.getName());
            asunto.setText(item.getAsunto());
            cuerpo.setText(item.getCuerpo());
            hora.setText(item.getHora());
        }
    }
}
