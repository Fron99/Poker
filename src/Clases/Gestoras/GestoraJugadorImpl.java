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

    //TODO Desarrollar javadoc


    public int calcularApostarBot(int apuestaMinima, MesaImpl mesa, int jugador){
        int totalApostar, valorCartas, cantidadApostar, farol;
        double porcenApostar;
        GestoraCartaImpl gesCarta = new GestoraCartaImpl();
        valorCartas = gesCarta.evaluarCartas(jugador, mesa);
        valorCartas += calcularPuntosFarol(mesa);
        porcenApostar = (((valorCartas*100)/267)*0.01);
        cantidadApostar = (int)((mesa.getJugadores()[jugador].getSaldo()/4)*porcenApostar);

        //TODO Comprobar funcionamiento de este metodo y documentar
        //TODO Realizar test de este metodo
        if (cantidadApostar >= apuestaMinima){
            if ((apuestaMinima-cantidadApostar) < (int)(cantidadApostar*0.3)){
                totalApostar = apuestaMinima;
            }else {
                totalApostar = cantidadApostar;
            }
        }else {
            totalApostar = 0;
        }

        return totalApostar;
    }



    /*
     * SIGNATURA: public int calcularPuntosFarol(MesaImpl mesa);
     * COMENTARIO: Calcular cantidad de puntos que debe incrementar la apuesta el bot
     * PRECONDICIONES: - Nada
     * ENTRADA: - Un objeto MesaImpl
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre la cantidad de puntos que debe incrementar en un farol el bot dependiendo de la ronda en la que se encuentre
     */

    //TODO Desarrollar javadoc

    public int calcularPuntosFarol(MesaImpl mesa){
        int puntosFarol = 0,porcentaje;
        Random r = new Random();

        if (mesa.getApuestasJugadores()[0][0] == 0
                && mesa.getApuestasJugadores()[1][0] == 0
                && mesa.getApuestasJugadores()[2][0] == 0
                && mesa.getApuestasJugadores()[3][0] == 0){

            //PROBABILIDAD PRIMERA MANO
            porcentaje = r.nextInt(99)+1;
            if (porcentaje > 0 && porcentaje < 6){
                puntosFarol = 10;
            }

        }else{
            if (mesa.getApuestasJugadores()[0][1] == 0
                    && mesa.getApuestasJugadores()[1][1] == 0
                    && mesa.getApuestasJugadores()[2][1] == 0
                    && mesa.getApuestasJugadores()[3][1] == 0){

                //PROBABILIDAD SEGUNDA MANO
                porcentaje = r.nextInt(99)+1;
                if (porcentaje > 0 && porcentaje < 11){
                    puntosFarol = 15;
                }

            }else{
                if (mesa.getApuestasJugadores()[0][2] == 0
                        && mesa.getApuestasJugadores()[1][2] == 0
                        && mesa.getApuestasJugadores()[2][2] == 0
                        && mesa.getApuestasJugadores()[3][2] == 0){

                    //PROBABILIDAD TERCERA MANO
                    porcentaje = r.nextInt(99)+1;
                    if (porcentaje > 0 && porcentaje < 16){
                        puntosFarol = 25;
                    }

                }else{
                    if (mesa.getApuestasJugadores()[0][3] == 0
                            && mesa.getApuestasJugadores()[1][3] == 0
                            && mesa.getApuestasJugadores()[2][3] == 0
                            && mesa.getApuestasJugadores()[3][3] == 0){

                        //PROBABILIDAD CUARTA MANO
                        porcentaje = r.nextInt(99)+1;
                        if (porcentaje > 0 && porcentaje < 21){
                            puntosFarol = 50;
                        }

                    }
                }
            }
        }
        return puntosFarol;
    }






}
