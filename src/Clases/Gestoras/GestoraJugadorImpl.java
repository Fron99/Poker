package Clases.Gestoras;

import Clases.Basicas.JugadorImpl;
import Clases.Basicas.MesaImpl;

import java.util.Random;
import java.util.Scanner;

public class GestoraJugadorImpl {

    /*
     * SIGNATURA: public int leerYValidarSaldoInicial();
     * COMENTARIO: Lee y valida el dinero inicial del jugador
     * PRECONDICIONES: - Ninguna
     * ENTRADA: - Nada
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con la cantidad de dinero con el que el jugador va a iniciar el juego
     *
     */

    //TODO Desarrollar javadoc

    public int leerYValidarSaldoInicial(){
        int dinero;
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.print("Introduce dinero con el que iniciar: ");
            dinero = teclado.nextInt();
        }while (dinero < 2000 || dinero > 10000);
        return dinero;
    }

    /*
     * SIGNATURA: public String leerUsuario();
     * COMENTARIO: Lee el usuario con el que quiere jugar el jugador
     * PRECONDICIONES: - Ninguna
     * ENTRADA: - Nada
     * SALIDA: - Un String
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un String con el usuario con el que quiere jugar el jugador
     *
     */

    //TODO Desarrollar javadoc

    public String leerUsuario(){
        String usuario;
        Scanner teclado = new Scanner(System.in);
            System.out.print("Introduce usuario con el que quiere jugar: ");
            usuario = teclado.nextLine();
        return usuario;
    }

    /*
     * SIGNATURA: public void cargarJugadores(JugadorImpl[] jugadores);
     * COMENTARIO: Carga un array pasado por parametros con jugadores aleatorios
     * PRECONDICIONES: - El array debe ser de JugadorImpl
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Array de JugadorImpl
     * POSTCONDICIONES: - Modifica el array de Jugadores pasado por parametro añadiendo usuarios aleatorios
     *
     */

    //TODO Desarrollar javadoc

    public void cargarBots(JugadorImpl[] jugadores){

        Random random = new Random();
        String[] nombresAleatorios = {"Kun","Wang","YanYan","Zhao","Yun","Sasha","Volodia","Hedeon","Grigory"};
        for (int i = 1; i<jugadores.length;i++){
            jugadores[i] = new JugadorImpl(nombresAleatorios[random.nextInt(8)],jugadores[0].getSaldo());
        }

    }

    /*
     * SIGNATURA: public int leerYValidarApuesta(JugadorImpl jugador);
     * COMENTARIO: Lee y valida la cantidad de dinero que puede apostar el jugador
     * PRECONDICIONES: Ninguna
     * ENTRADA: - Un jugador
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con la cantidad de dinero que apuesta el jugador
     *
     */

    //TODO Desarrollar javadoc

    public int leerYValidarApuesta(JugadorImpl jugador){
        Scanner teclado = new Scanner(System.in);
        int cantidadApuesta;
        do {
            System.out.println("Dispone de "+jugador.getSaldo()+" de saldo");
            System.out.print("Introduce cuanto quiere apostar: ");
            cantidadApuesta = teclado.nextInt();
        }while (cantidadApuesta<0 || cantidadApuesta > jugador.getSaldo());
        return cantidadApuesta;
    }


    /*
     * SIGNATURA: public int calcularApostarBot(int apuestaMinima, MesaImpl mesa, int jugador)
     * COMENTARIO: Metodo para calcular cuanto debe apostar el bot pasado por parametro
     * PRECONDICIONES: - Nada
     * ENTRADA: - Un objeto MesaImpl
     *          - Un entero con la apuesta minima
     *          - Un entero con el numero del jugador
     * SALIDA: - Un entero con la cantidad a apostar
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con la cantidad de saldo a apostar
     */

    public int calcularApostarBot(int apuestaMinima, MesaImpl mesa, int jugador){
        int totalApostar = 0, valorCartas;
        GestoraCartaImpl gesCarta = new GestoraCartaImpl();
        valorCartas = gesCarta.evaluarCartas(jugador, mesa);
        return totalApostar;
    }


}
