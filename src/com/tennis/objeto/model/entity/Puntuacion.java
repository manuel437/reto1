package com.tennis.objeto.model.entity;

public class Puntuacion {
    private int puntosA;
    private int puntosB;


    public Puntuacion() {
        this.puntosA = 0;
        this.puntosB = 0;

    }
    public Puntuacion(int p1,int p2) {
        this.puntosA = p1;
        this.puntosB = p2;

    }


    public void setPuntosA(int puntos ) {
        this.puntosA = puntos;
    }
    public void setPuntosB(int puntos) {
        this.puntosB = puntos;
    }

    public void setCeroPuntuaciones(){
        this.puntosA = 0;
        this.puntosB = 0;

    }
    public void setPuntuaciones(int p1,int p2){
        this.puntosA = p1;
        this.puntosB = p2;

    }


    public int getPuntosA() {
        return puntosA;
    }

    public int getPuntosB() {
        return puntosB;
    }

    public void mostrarPuntuaciones(){
        System.out.println("p1 " + this.puntosA + " - p2 " + this.puntosB);
    }
}

