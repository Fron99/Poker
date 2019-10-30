package Tests;

import Clases.Basicas.CartaImpl;
import Clases.Basicas.MesaImpl;

public class TestMesaImpl {

    public static void main(String[] args){

        MesaImpl mesa = new MesaImpl();


        System.out.println("Test restaurarBaraja");

        CartaImpl[] baraja = new CartaImpl[52];

        for (int i = 0; i<mesa.getBaraja().length;i++){
            baraja[i] = new CartaImpl();
        }

        mesa.setBaraja(baraja);

        System.out.println();
        System.out.println("BARAJA SIN RESTAURADA");
        System.out.println();

        for (int i = 0; i<mesa.getBaraja().length;i++){
            System.out.println("Palo: "+mesa.getBaraja()[i].getPalo()+"    Numero: "+mesa.getBaraja()[i].getNumero());
        }

        System.out.println();
        System.out.println("BARAJA RESTAURADA");
        System.out.println();


        mesa.restaurarBaraja();
        for (int i = 0; i<mesa.getBaraja().length;i++){
            System.out.println("Palo: "+mesa.getBaraja()[i].getPalo()+"    Numero: "+mesa.getBaraja()[i].getNumero());
        }


        System.out.println("Test getApuestaTotal");

        System.out.println();
        System.out.println("TODOS LOS JUGADORES TIENE UNA APUESTA DE 500 EN CADA RONDA");
        System.out.println();

        int[][] apuestas = {{500,500,500,500,500},{500,500,500,500,500},{500,500,500,500,500},{500,500,500,500,500},{500,500,500,500,500}};

        mesa.setApuestasJugadores(apuestas);

        System.out.println("Deberia dar 12500 y da: "+mesa.getTotalApuestas());

    }


}
