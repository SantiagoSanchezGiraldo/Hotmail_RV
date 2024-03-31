package com.hotmail;

public class ListaElementos {
    public String name, asunto, cuerpo, hora;
    public int imagen;
    public ListaElementos(int imagen, String name, String asunto, String cuerpo, String hora){
        this.imagen = imagen;
        this.name = name;
        this.asunto = asunto;
        this.cuerpo = cuerpo;
        this.hora = hora;
    }

    public String getName() {
        return name;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public String getHora() {
        return hora;
    }

    public int getImagen() {
        return imagen;
    }
}
