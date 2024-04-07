package com.tennis.objeto.model.repositories;

import com.tennis.objeto.model.entity.Puntuacion;

import java.util.ArrayList;

public class PuntuacionRepository {
    private ArrayList<Puntuacion> historialPuntuacion;

    public PuntuacionRepository() {
        this.historialPuntuacion = new ArrayList<>() ;
    }

    public void setHistorialPuntuacion(ArrayList<Puntuacion> historialPuntuacion) {
        this.historialPuntuacion = historialPuntuacion;
    }

    public ArrayList<Puntuacion> getHistorialPuntuacion() {
        return historialPuntuacion;
    }


    public void addPuntuacion(Puntuacion pun){
        this.historialPuntuacion.add(pun);
    }

    public Puntuacion lastPuntuacion(){
        return this.historialPuntuacion.getLast();
    }
}
