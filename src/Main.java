import com.tennis.objeto.control.PuntuacionController;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int resp = 1;

        PuntuacionController puntuacionController = new PuntuacionController();
        do{
            puntuacionController.inicPartido();
            System.out.println("Desea iniciar un nuevo partido? |1 -> Si|  |0 -> No|");
            resp = scanner.nextInt();
            if(resp == 1){
                puntuacionController.resetPartido();
            }



        }while(resp == 1);
        puntuacionController.endScannerUse();
        scanner.close();

    }
}