package com.hotmail;

public class ListaElementos {
    public String name, asunto, cuerpo, hora, descrip;
    public int imagen;
    public ListaElementos(int imagen, String name, String asunto, String cuerpo, String hora, String descrip){
        this.imagen = imagen;
        this.name = name;
        this.asunto = asunto;
        this.cuerpo = cuerpo;
        this.descrip = descrip;
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

    public String getDescrip(){return descrip;}

    public int getImagen() {
        return imagen;
    }
}
