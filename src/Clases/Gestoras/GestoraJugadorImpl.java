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
     * SIGNATURA: public int leerYValidarApuesta(JugadorImpl jugador, int apuestaMinima);
     * COMENTARIO: Lee y valida la cantidad de dinero que puede apostar el jugador
     * PRECONDICIONES: Ninguna
     * ENTRADA: - Un jugador
     *          - Apuesta minima
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con la cantidad de dinero que apuesta el jugador
     *
     */

    //TODO Desarrollar javadoc
    //TODO Pasar mesa para tener todos los datos mejor
    //TODO Pasar int jugador, int ronda, int cantidadMinima, int ronda

    public int leerYValidarApuesta(JugadorImpl jugador, int cantidadMinima){
        Scanner teclado = new Scanner(System.in);
        int cantidadApuesta;
        boolean allIn = false;
        do {
            System.out.println("Dispone de "+jugador.getSaldo()+" de saldo");
            System.out.print("Introduce cuanto quiere apostar: ");
            cantidadApuesta = teclado.nextInt();
            if (cantidadApuesta < cantidadMinima){
                if (cantidadApuesta == jugador.getSaldo()){
                    allIn = true;
                }
            }
        }while (((cantidadApuesta > jugador.getSaldo() || cantidadApuesta < cantidadMinima) && cantidadApuesta != 0 ) && !allIn);
        return cantidadApuesta;
    }


    /*
     * SIGNATURA: public int calcularApostarBot(int apuestaMinima, MesaImpl mesa, int jugador, int ronda)
     * COMENTARIO: Metodo para calcular cuanto debe apostar el bot pasado por parametro
     * PRECONDICIONES: - Nada
     * ENTRADA: - Un objeto MesaImpl
     *          - Un entero con la apuesta minima
     *          - Un entero con el numero del jugador
     *          - Un entero con el numero de la ronda
     * SALIDA: - Un entero con la cantidad a apostar
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con la cantidad de saldo a apostar
     */

    //TODO Desarrollar javadoc


    public int calcularApostarBot(int apuestaMinima, MesaImpl mesa, int jugador, int ronda){
        int totalApostar, valorCartas, cantidadApostar, puntosFarol;
        double porcenApostar;
        GestoraCartaImpl gesCarta = new GestoraCartaImpl();
        //Saca el valor en puntos que tiene las cartas de las que posee
        valorCartas = gesCarta.evaluarCartas(jugador, mesa);
        //Calcula cuantos puntos debe sumar en el caso de que haya farol, si no hay farol devuelve 0
        puntosFarol = calcularPuntosFarol(mesa,ronda);
        //Calcula el porcentaje a apostar


        if (mesa.obtenerApuesta(jugador,ronda) == 0){
            valorCartas += puntosFarol;
            porcenApostar = (double)valorCartas/319;
            cantidadApostar = (int)((mesa.obtenerJugador(jugador).getSaldo()/4)*porcenApostar);
            //Si la cantidad que desea apostar el bot es mayor o igual que la minima que hay que apostar calculara si desea igualar o subir
            if (cantidadApostar >= apuestaMinima){
                //Si la diferencia entre lo que desea apostar y lo que debe apostar es mayor al 30% de lo que quiere apostar sube la apuesta, sino iguala la apuesta
                if ((cantidadApostar - apuestaMinima) < (int)(cantidadApostar*0.3)){
                    totalApostar = apuestaMinima;
                }else {
                    totalApostar = cantidadApostar;
                }
                //En el caso de que no iguale ni suba la apuesta apostara 0
                //TODO Tener un margen de si le interesa subir o no y contolar los casos en los que hace all-in sin llegar a la cantidad minima
            }else {
                totalApostar = 0;
            }
        }else{
            porcenApostar = (double)valorCartas/319;
            cantidadApostar = (int)((mesa.obtenerJugador(jugador).getSaldo()/4)*porcenApostar);
            if ((apuestaMinima - mesa.obtenerApuesta(jugador,ronda)) < (int)(cantidadApostar*0.3)){
                totalApostar = (apuestaMinima - mesa.obtenerApuesta(jugador,ronda));
            }else {
                totalApostar = 0;
            }
        }
        //TODO Comprobar funcionamiento de este metodo y documentar
        //TODO Realizar test de este metodo

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

    public int calcularPuntosFarol(MesaImpl mesa, int ronda){
        int puntosFarol = 0,porcentaje;
        Random r = new Random();

        switch (ronda){
            case 0:
                //PROBABILIDAD PRIMERA MANO
                porcentaje = r.nextInt(99)+1;
                if (porcentaje > 0 && porcentaje < 6){
                    puntosFarol = 10;
                }
                break;
            case 1:
                //PROBABILIDAD SEGUNDA MANO
                porcentaje = r.nextInt(99)+1;
                if (porcentaje > 0 && porcentaje < 11){
                    puntosFarol = 15;
                }
                break;
            case 2:
                //PROBABILIDAD TERCERA MANO
                porcentaje = r.nextInt(99)+1;
                if (porcentaje > 0 && porcentaje < 16){
                    puntosFarol = 25;
                }
                break;
            case 3:
                //PROBABILIDAD CUARTA MANO
                porcentaje = r.nextInt(99)+1;
                if (porcentaje > 0 && porcentaje < 21){
                    puntosFarol = 50;
                }
                break;
            case 4:
                //PROBABILIDAD CUARTA MANO
                porcentaje = r.nextInt(99)+1;
                if (porcentaje > 0 && porcentaje < 5){
                    puntosFarol = 100;
                }
                break;
        }
        return puntosFarol;
    }

    /*
     * SIGNATURA: public void colocarJugadoresActivos(MesaImpl mesa)
     * COMENTARIO: Metodo para colocar todos los jugadores de la mesa activos
     * PRECONDICIONES: - Nada
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Un objeto MesaImpl
     * POSTCONDICIONES: - Modifica el objeto pasado por parametro colocando todos los jugadores en activo.
     */

    public void colocarJugadoresActivos(MesaImpl mesa){
        for(JugadorImpl jugador: mesa.getJugadores()){
            jugador.setActivo(true);
        }
    }







}
