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

import basicsClasses.TableImpl;
import managements.ManagementPoker;
import validations.Validations;

import java.sql.Connection;

public class Poker {

    public static void main(String[] args){

        ManagementPoker managePoker = new ManagementPoker();
        Validations validations = new Validations();
        TableImpl table = new TableImpl();
        boolean remainPlayers, continuePlay, existUser;
        Connection connectionDataBase = managePoker.getConnection();
        String username, password;


        if (connectionDataBase != null){
            username = validations.readAndValidateUsername(connectionDataBase);
            password = validations.readAndValidatePassword();
            existUser = managePoker.existUser(username, password, connectionDataBase);

            if (existUser){

                //cargarBots
                table.setPlayer(0,managePoker.getUser(username, connectionDataBase));
                table.setPlayer(1,managePoker.getRandomUser(connectionDataBase));
                table.setPlayer(2,managePoker.getRandomUser(connectionDataBase));
                table.setPlayer(3,managePoker.getRandomUser(connectionDataBase));
                table.setPlayer(4,managePoker.getRandomUser(connectionDataBase));

                do {

                    //restaurarMesa
                    table.restoreTable();

                    //Actualizar variables para nuevo juego
                    remainPlayers = true;

                    for (int counter = 0; counter < 4 && remainPlayers; counter++){
                        //Se utiliza este if para que solo se generen una vez las 3 cartas despues de la primera jugada
                        if (counter == 1) {
                            //generarTresCartasMesa
                            table.generateThreeCardsToTable();
                        }

                        //Se utiliza este if para que solo se generen una carta a partir de la 2 apuesta
                        if (counter > 1) {
                            //generarCartaMesa
                            table.generateCardTable();
                        }

                        //mostrarPanelJuego
                        table.showPanelPlay();

                        //realizarApuestas
                        table.doBet();     //Pide la cantidad de dinero que se quiere apostar a cada jugador en su orden correspondiente
                        remainPlayers = table.remainPlayersToPlay();
                    }

                    if (remainPlayers){
                        //mostrarPanelJuego
                        table.showPanelPlay();
                    }

                    if (!managePoker.insertFinalStadistic(table,connectionDataBase)){
                        System.out.println("The play don't save");
                    }

                    //ingresarSaldoGanadores
                    table.depositBalanceWinnerAndShowWinner();

                    table.increaseTurn();

                    if (table.getBalancePlayer(0)>0 && table.quantityPlayerWithBalancePositive() > 0){
                        continuePlay = validations.readAndValidateContinuePlaying();
                    }else{
                        System.out.println("The player haven't more money");
                        continuePlay = false;
                    }

                }while (table.getBalancePlayer(0)>0
                        && continuePlay);

            }else{
                System.out.println("Error in LogIn");
            }

        }else{
            System.out.println("Error in connection");
        }

    }

}
