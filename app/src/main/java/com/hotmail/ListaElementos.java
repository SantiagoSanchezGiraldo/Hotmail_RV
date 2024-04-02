package com.hotmail;

public class ListaElementos {
    public String name, asunto, cuerpo, hora, descrip;
    public int imagen;
    public boolean leer;

    public ListaElementos(int imagen, String name, String asunto, String cuerpo, String hora, String descrip){
        this.imagen = imagen;
        this.name = name;
        this.asunto = asunto;
        this.cuerpo = cuerpo;
        this.descrip = descrip;
        this.hora = hora;
        this.leer = false;
    }

    public boolean isLeer() {
        return leer;
    }

    public void setLeer(boolean leido){
        leer = leido;
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

    public String getDescrip(){return descrip;}

    public int getImagen() {
        return imagen;
    }
}
