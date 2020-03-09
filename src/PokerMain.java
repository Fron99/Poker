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
 *  leerYValidarJugador*
 *  //añadirJugador
 *  cargarBots*
 *  repetir
 *      restaurarMesa*
 *      para(contador = 0, mientras contador < 5, incrementar i)
 *          si contador == 1
 *              generarTresCartasMesa*
 *          finSi
 *          si contador > 1
 *              generarCartaMesa*
 *          finSi
 *          mostrarPanelJuego*
 *          realizarApuestas*
 *      finPara
 *      mostrarPanelJuego*
 *      ingresarSaldoGanadores*
 *      incrementarTurno*
 *  mientras(saldo usuario > 0 && queden bots con saldo)
 *  //mostrarJuegosFin
 * FIN
 *
 */


import Clases.Basicas.MesaImpl;
import Clases.Gestoras.GestoraJugadorImpl;

public class PokerMain {

    public static void main (String[] args){

        GestoraJugadorImpl gesJugador = new GestoraJugadorImpl();
        MesaImpl mesa = new MesaImpl();
        int saldoInicialJugador;

        //leerYValidarJugador*
        //añadirJugador
        mesa.anhadirJugador(0,gesJugador.leerYValidarJugador());    //El usuario que juega se colocara siempre en la posicion 0
        saldoInicialJugador = mesa.obtenerSaldoJugador(0);    //Solo se utiliza para informacion al usuario al finalizar el juego

        //cargarBots
        mesa.cargarBots();  //Coloca en el array de jugadores jugadores con valores generados aleatoriamente

        do {

            //restaurarMesa
            mesa.restaurarMesa();

            for (int contador = 0; contador < 4; contador++){

                //Se utiliza este if para que solo se generen una vez las 3 cartas despues de la primera jugada
                if (contador == 1) {
                    //generarTresCartasMesa
                    mesa.generarTresCartasMesa();
                }

                //Se utiliza este if para que solo se generen una carta a partir de la 2 apuesta
                if (contador > 1) {
                    //generarCartaMesa
                    mesa.generarCartaMesa();
                }

                //mostrarPanelJuego
                mesa.mostrarPanelJuego();

                //realizarApuestas
                mesa.realizarApuestas();     //Pide la cantidad de dinero que se quiere apostar a cada jugador en su orden correspondiente

            }

            //mostrarPanelJuego
            mesa.mostrarPanelJuego();

            //ingresarSaldoGanadores
            mesa.ingresarSaldoGanadores();

            mesa.incrementarTurno();

            //TODO Falta añadir que haya usuarios con saldo en el while y que el usuario quiera seguir
        }while (mesa.getJugadores()[0].getSaldo()>0);

        //TODO Solucion solo para que funcione de momento
        System.out.println("El jugador "+mesa.getJugadores()[0].getUsuario()+" empezo con "+saldoInicialJugador+" y acabo con "+(saldoInicialJugador-mesa.getJugadores()[0].getSaldo())+"");

    }

}
