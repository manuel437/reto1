package com.tennis.objeto.model.entity;

public class Puntuacion {
    public int puntosA;
    public int puntosB;

    public Puntuacion() {
        this.puntosA = 0;
        this.puntosB = 0;
    }

    public void AumentoA(){
        this.puntosA += 15;
    }
    public void AumentoB(){
        this.puntosB += 15;
    }

    public int getPuntosA() {
        return puntosA;
    }

    public int getPuntosB() {
        return puntosB;
    }

    public void mostrarPuntuaciones(){

    }
}

