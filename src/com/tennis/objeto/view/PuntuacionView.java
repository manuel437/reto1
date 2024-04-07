package com.tennis.objeto.view;

import com.tennis.objeto.model.entity.Puntuacion;

import java.util.Scanner;

public class PuntuacionView {
    private Scanner scanner;

    public PuntuacionView() {
        this.scanner = new Scanner(System.in);
    }

    public Scanner getScanner() {
        return scanner;
    }

    public int puntoPara(){
        System.out.println("Ingrese que jugador hizo el punto | 1 -> P1 | 2 -> P2 |");
        return scanner.nextInt();
    }

    public void mostrarPuntosInd(int puntuacion){
        if(puntuacion == 0){
            System.out.print("|Love|");
        }else if(puntuacion == 1){
            System.out.print("| 15 |");
        }else if(puntuacion == 2){
            System.out.print("| 30 |");
        }else if(puntuacion == 3){
            System.out.print("| 40 |");
        }
    }

    public void mostrarPuntuacionJuegoEmpate(Puntuacion pun){
        int gan = 0;
        if(pun.getPuntosA() == pun.getPuntosB()){
            System.out.println("|    Deuce    |");
        }else if(pun.getPuntosA() == (pun.getPuntosB() + 1)){
            System.out.println("|  Ventaja P1 |");
        }else if(pun.getPuntosA() == (pun.getPuntosB() -1)){
            System.out.println("|  Ventaja P2 |");
        }else if(pun.getPuntosA() == (pun.getPuntosB() + 2)){
            System.out.println("|    Gana P1  |");
        }else if (pun.getPuntosA() == (pun.getPuntosB() - 2)){
            System.out.println("|   Gana P2   |");
        }

    }

    public void mostrarPuntuacionJuegoNormal(Puntuacion pun){
            if(pun.getPuntosA() == 4 || pun.getPuntosB() == 4){
                if(pun.getPuntosA() == 4){
                    System.out.println("|    Gana P1  |");
                }else{
                    System.out.println("|    Gana P2   |");
                }
            }else{
                System.out.print("");
                mostrarPuntosInd(pun.getPuntosA());
                System.out.print(" - ");
                mostrarPuntosInd(pun.getPuntosB());
                System.out.println("");

            }
    }

    public void mostrarPuntuacionPerfecto(Puntuacion puntuacion){
        if(puntuacion.getPuntosA() >= 3 && puntuacion.getPuntosB() >= 3){
            this.mostrarPuntuacionJuegoEmpate(puntuacion);
        }else{
            this.mostrarPuntuacionJuegoNormal(puntuacion);
        }
    }



}
