package com.tennis.objeto.control;

import com.tennis.objeto.model.entity.Puntuacion;
import com.tennis.objeto.model.repositories.PuntuacionRepository;
import com.tennis.objeto.view.PuntuacionView;

public class PuntuacionController {
    private PuntuacionView puntuacionView;
    private PuntuacionRepository puntuacionRepository;

    public PuntuacionController() {
        this.puntuacionRepository = new PuntuacionRepository();
        this.puntuacionView = new PuntuacionView();
    }

    public int actualPuntuacionA() {
        return this.puntuacionRepository.getHistorialPuntuacion().getLast().getPuntosA();

    }


    public int actualPuntuacionB() {
        return this.puntuacionRepository.getHistorialPuntuacion().getLast().getPuntosB();

    }

    public void mostrarPuntuacionTotal(){
        int i = 0;
        while( i < this.getPuntuacionRepository().getHistorialPuntuacion().size()){
            this.getPuntuacionView().mostrarPuntuacionPerfecto(this.puntuacionRepository.getHistorialPuntuacion().get(i));
            i++;
        }
    }

    public PuntuacionRepository getPuntuacionRepository() {
        return puntuacionRepository;
    }

    public PuntuacionView getPuntuacionView() {
        return puntuacionView;
    }

    public void ingresoPunto() {
        int resp = this.getPuntuacionView().puntoPara();
        Puntuacion pun = new Puntuacion();

        int a = this.actualPuntuacionA();
        int b = this.actualPuntuacionB();

        if(resp == 1) {
            pun.setPuntosA( a +1);
            pun.setPuntosB(b);
            this.getPuntuacionRepository().getHistorialPuntuacion().addLast(pun);

        }else if(resp == 2){
            pun.setPuntosB(b+1);
            pun.setPuntosA(a);
            this.getPuntuacionRepository().getHistorialPuntuacion().addLast(pun);
        }else{
            System.out.println("No se pudo anotar la puntuacion");
        }

    }
    public int comprobarFinal(Puntuacion puntuacion){
        int resp = 0;
        if(puntuacion.getPuntosA() >= 3 && puntuacion.getPuntosB() >= 3){
             //desempate
            if((puntuacion.getPuntosA() == (puntuacion.getPuntosB() +2)) || (puntuacion.getPuntosA() +2 == puntuacion.getPuntosB())){
                resp = 1;
            }
        }else{
            if((puntuacion.getPuntosA() == 4 && puntuacion.getPuntosB() < 4) || (puntuacion.getPuntosB() == 4 && puntuacion.getPuntosA() < 4)){
                resp = 1;
            }
        }
        return resp;
    }

    public void inicPartido() {
        this.getPuntuacionRepository().addPuntuacion(new Puntuacion());

        System.out.println("   P1   P2");

        do {
            this.ingresoPunto();
            this.getPuntuacionView().mostrarPuntuacionPerfecto(this.getPuntuacionRepository().lastPuntuacion());

        }while((this.comprobarFinal(this.getPuntuacionRepository().lastPuntuacion())) == 0);
        System.out.println("Resumen del partido");
        System.out.println("");
         this.mostrarPuntuacionTotal();
    }


}
