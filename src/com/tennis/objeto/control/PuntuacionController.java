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
            if(this.getPuntuacionRepository().getHistorialPuntuacion().get(i).getPuntosA() >= 3 && this.getPuntuacionRepository().getHistorialPuntuacion().get(i).getPuntosB() >= 3){
                this.getPuntuacionView().mostrarPuntuacionJuegoEmpate(this.getPuntuacionRepository().getHistorialPuntuacion().get(i));
            }else{
                this.getPuntuacionView().mostrarPuntuacionJuegoNormal(this.getPuntuacionRepository().getHistorialPuntuacion().get(i));

            }
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

    public void inicPartido() {
        int punGan;
        int flag = 0;
        this.getPuntuacionRepository().addPuntuacion(new Puntuacion());
        System.out.println("   P1   P2");
        do {
            this.ingresoPunto();
            if(this.actualPuntuacionA() >= 3 && this.actualPuntuacionB() >= 3){
                this.puntuacionView.mostrarPuntuacionJuegoEmpate(this.getPuntuacionRepository().lastPuntuacion());
                if((this.actualPuntuacionA() == (this.actualPuntuacionB()+2)) || (this.actualPuntuacionA() == (this.actualPuntuacionB()-2))){
                    flag = 1;
                }
            }else{
                this.getPuntuacionView().mostrarPuntuacionJuegoNormal(this.getPuntuacionRepository().lastPuntuacion());
                if(this.actualPuntuacionA() == 4 || this.actualPuntuacionA() == 4){
                    flag = 1;
                }
            }


        }while(flag == 0);
         this.mostrarPuntuacionTotal();
    }


}
