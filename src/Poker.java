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
import Validaciones.Validations;

public class Poker {

    public void playGame(){

        ManagementPlayerImpl managePlayer = new ManagementPlayerImpl();
        Validations validations = new Validations();
        TableImpl table = new TableImpl();
        int balanceInitialPlayer, playerWithBalance;
        boolean remainPlayers, continuePlay;

        //leerYValidarJugador*
        //añadirJugador
        table.setPlayer(0,managePlayer.leerYValidarJugador());  //El usuario que juega se colocara siempre en la posicion 0 y se comprueba que se haya introducido correctamente
        balanceInitialPlayer = table.getBalancePlayer(0);    //Solo se utiliza para informacion al usuario al finalizar el juego

        //cargarBots
        table.generateBots();  //Coloca en el array de jugadores jugadores con valores generados aleatoriamente

        do {

            //restaurarMesa
            table.restoreTable();

            //Actualizar variables para nuevo juego
            remainPlayers = true;

            for (int contador = 0; contador < 4 && remainPlayers; contador++){
                    //Se utiliza este if para que solo se generen una vez las 3 cartas despues de la primera jugada
                    if (contador == 1) {
                        //generarTresCartasMesa
                        table.generateThreeCardsToTable();
                    }

                    //Se utiliza este if para que solo se generen una carta a partir de la 2 apuesta
                    if (contador > 1) {
                        //generarCartaMesa
                        table.generateCardTable();
                    }

                    //mostrarPanelJuego
                    table.showPanelPlay();

                    //realizarApuestas
                    remainPlayers = table.doBet();     //Pide la cantidad de dinero que se quiere apostar a cada jugador en su orden correspondiente
            }

            if (remainPlayers){
                //mostrarPanelJuego
                table.showPanelPlay();
            }

            //ingresarSaldoGanadores
            table.depositBalanceWinnerAndShowWinner();

            table.increaseTurn();

            playerWithBalance = managePlayer.jugadoresConSaldo(table.getPlayers());

            if (table.getBalancePlayer(0)>0 && playerWithBalance > 0){
                continuePlay = validations.readAndValidateContinuePlaying();
            }else{
                System.out.println("El jugador no tiene más saldo");
                continuePlay = false;
            }

        }while (table.getBalancePlayer(0)>0
                && continuePlay);

        System.out.println("El jugador "+table.getUsernamePlayer(0)+" empezo con "+balanceInitialPlayer+" y acabo con "+table.getBalancePlayer(0)+"");

    }

}
