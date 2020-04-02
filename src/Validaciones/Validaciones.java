package Validaciones;

import java.util.Scanner;

public class Validaciones {

    /*
     * SIGNATURA:
     * COMENTARIO:
     * PRECONDICIONES:
     * ENTRADA: -
     *          -
     * SALIDA: -
     * ENTRADA/SALIDA: -
     * POSTCONDICIONES: -
     */

    /**
     * @return
     */

    public boolean leerYValidarSeguirJugando(){
        Scanner te = new Scanner(System.in);
        char caracter;
            do {
                System.out.println("Introduce 'S' si desea seguir jugando o 'N' si desea salir de la mesa: ");
                caracter = Character.toUpperCase(te.next().charAt(0));
            }while (caracter != 'S' && caracter != 'N');
        return caracter == 'S';
    }

}
