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

import Clases.Basics.TableImpl;
import Clases.Managements.ManagementPlayerImpl;
import Validaciones.Validaciones;

public class PokerMain {

    public static void main (String[] args){

        ManagementPlayerImpl gesJugador = new ManagementPlayerImpl();
        Validaciones validaciones = new Validaciones();
        TableImpl mesa = new TableImpl();
        int saldoInicialJugador, jugadoresConSaldo;
        boolean quedanJugadores, seguirJugando;

        //leerYValidarJugador*
        //añadirJugador
        if (!mesa.setJugador(0,gesJugador.leerYValidarJugador())){  //El usuario que juega se colocara siempre en la posicion 0 y se comprueba que se haya introducido correctamente
            System.out.println("No se ha podido anhadir");
        }
        saldoInicialJugador = mesa.getSaldoJugador(0);    //Solo se utiliza para informacion al usuario al finalizar el juego

        //cargarBots
        mesa.generarBots();  //Coloca en el array de jugadores jugadores con valores generados aleatoriamente

        do {

            //restaurarMesa
            mesa.restaurarMesa();

            //Actualizar variables para nuevo juego
            quedanJugadores = true;

            for (int contador = 0; contador < 4 && quedanJugadores; contador++){
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
                    quedanJugadores = mesa.realizarApuestas();     //Pide la cantidad de dinero que se quiere apostar a cada jugador en su orden correspondiente
            }

            if (quedanJugadores){
                //mostrarPanelJuego
                mesa.mostrarPanelJuego();
            }

            //ingresarSaldoGanadores
            mesa.ingresarSaldoGanadoresYMostrarGanador();

            mesa.incrementarTurno();

            jugadoresConSaldo = gesJugador.jugadoresConSaldo(mesa.getJugadores());

            if (mesa.getSaldoJugador(0)>0 && jugadoresConSaldo > 0){
                seguirJugando = validaciones.leerYValidarSeguirJugando();
            }else{
                System.out.println("El jugador no tiene más saldo");
                seguirJugando = false;
            }

        }while (mesa.getSaldoJugador(0)>0
                && seguirJugando);

        System.out.println("El jugador "+mesa.getUsuarioJugador(0)+" empezo con "+saldoInicialJugador+" y acabo con "+mesa.getSaldoJugador(0)+"");

    }

}
