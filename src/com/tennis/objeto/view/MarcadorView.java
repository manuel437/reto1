package com.tennis.objeto.view;
import com.tennis.objeto.model.entity.Puntuacion;
import com.tennis.objeto.model.entity.Marcador;
import java.util.Scanner;

public class MarcadorView {
        private Scanner scanner;

    public MarcadorView( ) {
        this.scanner = new Scanner(System.in);
    }

    public Scanner getScanner() {
        return scanner;
    }



}
