/*
 * Programa: PokerMain.java
 * Comentario: Este programa trata sobre un juego de poker tradicional pero informatizado y de una manera en la que se puede jugar solo sin nadie mas.
 *              Este programa incluye una serie de funcionalidades que hace que los demas jugadores de la mesa en la que juegas "piensen" sus apuestas.
 *              Cada bot que hay en la mesa realiza las apuestas en funcion de las cartas que tienen y de las posibilidades que creen que tienen de ganar la partida.
 *
 * Entrada:
 *  - Un String con el usuario
 *  - Un int con la cantidad de saldo inicial
 *  - Un int para la cantidad que apuesta el jugador
 *
 * Salida:
 *  - Mensajes al usuario
 *  - Eco de los datos
 *  - Resultado de las acciones elegidas por el usuario
 *  - Ganadores
 *  - La informacion de la mesa
 *
 * Restricciones:
 *  - El saldo inicial no puede ser menor de 2000€ ni superior a 10000€
 *
 * PG0
 * INICIO
 *  leerUsuario*
 *  leerYValidarSaldoInicial*
 *  //añadirJugador
 *  cargarBots*
 *  //generarTurnoJugador
 *  repetir
 *      //actualizarRonda
 *      limpiarMesa*
 *      restaurarBaraja*
 *      generarCartasJugadores*
 *      colocarJugadoresActivos*
 *      mostrarPanelJuego*
 *      realizarApuestas*
 *      generarTresCartasMesa*
 *      mostrarPanelJuego*
 *      realizarApuestas*
 *      para(contador = 0; contador < 2; contador++)
 *          generarCartaMesa*
 *          mostrarPanelJuego*
 *          realizarApuestas*
 *      finPara
 *      mostrarPanelJuego*
 *      calcularCantidadGanadores*
 *      si(cantidad ganadores > 1)
 *          obtenerGanadores*
 *          ingresarSaldoGanadores*
 *      sino
 *          obtenerGanador*
 *          ingresarSaldoGanador*
 *      finSi
 *      si(turno jugador == 4)
 *          turno jugador = 0
 *      sino
 *          //incrementar turno jugador
 *      finSi
 *  mientras(saldo usuario > 0 && queden bots con saldo)
 *  //mostrarJuegosFin
 * FIN
 *
 */


import Clases.Basicas.JugadorImpl;
import Clases.Basicas.MesaImpl;
import Clases.Gestoras.GestoraJugadorImpl;
import Clases.Gestoras.GestoraMesaImpl;

import java.util.Random;

public class PokerMain {

    public static void main (String[] args){

        Random random = new Random();
        GestoraJugadorImpl gesJugador = new GestoraJugadorImpl();
        GestoraMesaImpl gesMesa = new GestoraMesaImpl();

        String usuarioJugador;
        int saldoInicialJugador, turnoJugador, cantidadGanadores, ronda, ganador;
        MesaImpl mesa = new MesaImpl();

        //leerUsuario
        usuarioJugador = gesJugador.leerUsuario();

        //leerYValidarDineroInicial
        saldoInicialJugador = gesJugador.leerYValidarSaldoInicial();

        //añadirJugador
        //El usuario que juega se colocara siempre en la posicion 0
        mesa.anhadirJugador(0,new JugadorImpl(usuarioJugador,saldoInicialJugador));

        //cargarBots
        gesJugador.cargarBots(mesa.getJugadores());  //Coloca en el array de jugadores jugadores con valores generados

        //generarTurnoJugador
        //turnoJugador = random.nextInt(5);   //Genera un numero del 0 al 4 que es la cantidad de jugadores que hay para saber quien empieza a apostar
        turnoJugador = 3;

        do {
            ronda = 0;  //Se actualiza la variable ronda para cada vez que se juega una partida

            //limpiarMesa
            mesa.limpiarMesa(); //Coloca por defecto las cartas de la mesa y las apuestas de los jugadores

            //restaurarBaraja
            mesa.restaurarBaraja();

            //generarCartasJugadores
            gesMesa.generarCartasJugadores(mesa.getBaraja(),mesa);    //Asigna 2 cartas a cada jugador sin reeptir carta.

            //colocarActivosJugadores
            gesJugador.colocarJugadoresActivos(mesa);

            //mostrarPanelJuego
            gesMesa.mostrarPanelJuego(mesa,ronda);

            //realizarApuestas
            gesMesa.realizarApuestas(turnoJugador,mesa,ronda);     //Pide la cantidad de dinero que se quiere apostar a cada jugador en su orden correspondiente
            ronda++;

            //generarTresCartasMesa
            gesMesa.generarTresCartasMesa(mesa.getBaraja(),mesa.getCartasMesa());  //Coloca 3 cartas aleatorias en el array de las cartas que hay en esta mesa

            //mostrarPanelJuego
            gesMesa.mostrarPanelJuego(mesa,ronda);

            //realizarApuestas
            gesMesa.realizarApuestas(turnoJugador,mesa,ronda);     //Pide la cantidad de dinero que se quiere apostar a cada jugador en su orden correspondiente
            ronda++;

            for (int contador = 0; contador < 2; contador++){

                //generarCartaMesa
                gesMesa.generarCartaMesa(mesa.getBaraja(),mesa.getCartasMesa());

                //mostrarPanelJuego
                gesMesa.mostrarPanelJuego(mesa,ronda);

                //realizarApuestas
                gesMesa.realizarApuestas(turnoJugador,mesa,ronda);     //Pide la cantidad de dinero que se quiere apostar a cada jugador en su orden correspondiente
                ronda++;

            }

            //mostrarPanelJuego
            gesMesa.mostrarPanelJuego(mesa,ronda);

            //calcularCantidadGanadores
            cantidadGanadores = gesMesa.calcularCantidadGanadores(mesa);    //TODO

            if (cantidadGanadores > 1){
                //obtenerGanadores
                for (int i = 0; i<5/*Aqui no deberia ir un 5 sino el array con los ganadores*/ ;i++){
                    gesMesa.ingresarDineroGanador(0/*Aqui no va 0 va el ganador*/,mesa);
                }
            }else{
                //obtenerGanador
                ganador = gesMesa.obtenerGanador(mesa);
                //ingresarSaldoGanador
                gesMesa.ingresarDineroGanador(ganador,mesa);
            }

            if (turnoJugador == 4){
                turnoJugador = 0;
            }else{
                turnoJugador++;
            }

        }while (mesa.getJugadores()[0].getSaldo()>0);

        System.out.println("El jugador "+usuarioJugador+" empezo con "+saldoInicialJugador+" y acabo con "+(saldoInicialJugador-mesa.getJugadores()[0].getSaldo())+"");

    }

}
