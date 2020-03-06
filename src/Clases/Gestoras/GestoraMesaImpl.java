package Clases.Gestoras;

import Clases.Basicas.CartaImpl;
import Clases.Basicas.JugadorImpl;
import Clases.Basicas.MesaImpl;

import java.util.ArrayList;
import java.util.Random;

public class GestoraMesaImpl {

    /*
     * SIGNATURA: public void mostrarPanelJuego (MesaImpl mesa, int ronda);
     * COMENTARIO: Imprime por pantalla las cartas que hay en la mesa, el dinero de los demas jugadores y el total del bote de la mesa
     * PRECONDICIONES: - Nada
     * ENTRADA: - Un objeto Mesa
     *          - Un entero
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - No devuelve nada, solo imprime por pantalla el estado actual en el que se encuentran los jugadores y las cartas
     */

    //TODO Desarrollar javadoc
    //TODO Utilizar arraybidimensional para esto
    //TODO Controlar cuando sea la ultima ronda para que muestre informacion adiciona sobre quien ha ganado y mostrar todas las cartas

    public void mostrarPanelJuego(MesaImpl mesa, int ronda) {

        String numCar1Usuario, numCar2Usuario;
        char paloCar1Usuario, paloCar2Usuario;

        numCar1Usuario = mesa.obtenerJugador(0).obtenerCarta(0).getNumero();
        numCar2Usuario = mesa.obtenerJugador(0).obtenerCarta(1).getNumero();

        paloCar1Usuario = mesa.getJugadores()[0].getCartas()[0].getPalo();
        paloCar2Usuario = mesa.getJugadores()[0].getCartas()[1].getPalo();


        String[] usersJugadores = new String[5];
        //TODO Revisar esto. Se deberia hacer patron delegacion
        for (int i = 0; i<usersJugadores.length;i++){
            usersJugadores[i] = mesa.getJugadores()[i].getUsuario();
        }

        int[] saldoJugadores = new int[5];
        //TODO Revisar esto. Se deberia hacer patron delegacion
        for (int i = 0; i<saldoJugadores.length;i++){
            saldoJugadores[i] = mesa.getJugadores()[i].getSaldo();
        }

        char[] palosCartasMesa = new char[5];
        //TODO Revisar esto. Se deberia hacer patron delegacion
        for (int i = 0; i<palosCartasMesa.length;i++){
            palosCartasMesa[i] = mesa.getCartasMesa()[i].getPalo();
        }

        String[] numerosCartasMesa = new String[5];
        //TODO Revisar esto. Se deberia hacer patron delegacion
        for (int i = 0; i<numerosCartasMesa.length;i++){
            numerosCartasMesa[i] = mesa.getCartasMesa()[i].getNumero();
        }


        System.out.println("                                      " + usersJugadores[2] + "                                       " + usersJugadores[3]);
        System.out.println();
        System.out.println("                                      " + saldoJugadores[2] + "€                                               " + saldoJugadores[3] + "€");
        System.out.println("                                      |º º|     -----        -----                                    |º º|    -----        -----");
        System.out.println("                                      |---|    | ?   |      | ?   |                                   |---|   | ?   |      | ?   |  ");
        System.out.println("                                               | ?   |      | ?   |                                           | ?   |      | ?   |");
        System.out.println("                                                -----        -----                                             -----        -----");



        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("       " + usersJugadores[1] + "                                                                                                                              " + usersJugadores[4]);
        System.out.println("                                                        ----- " + "       " + " ----- " + "       " + " ----- " + "       " + " ----- " + "       " + " ----- ");
        System.out.println("       " + saldoJugadores[1] + "€                                           | " + palosCartasMesa[0] + "   |" + "       " + "| " + palosCartasMesa[1] + "   |" + "       " + "| " + palosCartasMesa[2] + "   |" + "       " + "| " + palosCartasMesa[3] + "   |" + "       " + "| " + palosCartasMesa[4] + "   |                      " + saldoJugadores[4] + "€");
        System.out.println("       |º º|       -----        -----                  | " + numerosCartasMesa[0] + "   |" + "       " + "| " + numerosCartasMesa[1] + "   |" + "       " + "| " + numerosCartasMesa[2] + "   |" + "       " + "| " + numerosCartasMesa[3] + "   |" + "       " + "| " + numerosCartasMesa[4] + "   |                      |º º|      -----        -----");
        System.out.println("       |---|      | ?   |      | ?   |                 |     |" + "       " + "|     |" + "       " + "|     |" + "       " + "|     |" + "       " + "|     |" + "                      |---|     | ?   |      | ?   |");
        System.out.println("                  | ?   |      | ?   |                  ----- " + "       " + " ----- " + "       " + " ----- " + "       " + " ----- " + "       " + " -----                                 |     | ?    | ?   |");
        System.out.println("                   -----        -----                                                                                                                  -----        -----");

        System.out.println();
        System.out.println("                                                              DINERO EN MESA: " + mesa.getTotalApuestas() + "€");
        System.out.println();
        System.out.println();

        System.out.println("                                                                     " + usersJugadores[0]);
        System.out.println("                                                              TU SALDO ES: " + saldoJugadores[0] + "€");
        System.out.println();
        System.out.println("                                                           _______________________");
        System.out.println("                                                          |                       |");
        System.out.println("                                                          |    __           __    |");
        System.out.println("                                                          |   |º |         |º |   |            ----------           ----------");
        System.out.println("                                                          |    --           --    |           | "+paloCar1Usuario+"        |         | "+paloCar2Usuario+"        |");
        System.out.println("                                                          |                       |           | "+numCar1Usuario+"        |         | "+numCar2Usuario+"        |");
        System.out.println("                                                          |   \\              /    |           |          |         |          |");
        System.out.println("                                                          |     \\___________/     |           |          |         |          |");
        System.out.println("                                                          |                       |            ----------           ----------");
        System.out.println("                                                           -----------------------");
        System.out.println();

    }


    /*
     * SIGNATURA: public void realizarApuestas(int turnoJugador, MesaImpl mesa, int ronda)
     * COMENTARIO: Realizar las apuestas de todos los jugadores de la mesa
     * PRECONDICIONES:
     * ENTRADA: - Un entero con el turno
     *          - Un entero con la ronda
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Un objeto mesa
     * POSTCONDICIONES: - Modifica el objeto mesa, incrementando el total del dinero que hay en mesa.
     */

    /*
     * apuestaMinima = 0
     * jugadorPasa = false
     *
     * si (turnoJugador == 0)
     *  si (jugador[0].getActivo() == true)
     *      apuestaJugador = leerApuesta
     *      si (apuestaJugador > apuestaMinima)
     *          apuestaMinima = apuestaJugador
     *      sino
     *          si (apuestaJugador == apuestaMinima)
     *              jugadorPasa = true
     *          finSi
     *      finSi
     *  finSi
     *  turnoJugador++
     *  cantidadJugadas++
     *
     *  mientras(turnoJugador < 5 && cantidadJugadas < totalJugadas)
     *      si(jugador[turnoJugador].getActivo() == true)
     *          si(jugador[turnoJugador].getSalto > 0)
     *              apuestaJugador = calcularApuesta
     *              si(apuestaJugador != apuestaMinima || jugadorPasa == false)
     *                  jugadorPasa = false
     *                  si(apuestaJugador == 0)
     *                      jugador.seActivo(false)
     *                      sino
     *                          si(apuestaJugador == apuestaMinima)
     *                              jugador.disminuirSaldo(apuestaJugador)
     *                              mesa.anhadirApuesta(turnoJugador,ronda,apuestaJugador)
     *                          sino
     *                              si(apuestaJugador > apuestaMinima)
     *                                  cantidadJugadas += 4
     *                                  jugador.disminuirSaldo(apuestaJugador)
     *                                  mesa.anhadirApuesta(turnoJugador,ronda,apuestaJugador)
     *                              finSi
     *                          finSi
     *                   finSi
     *              finSi
     *          finSi
     *      finSi
     *      cantidadJugadas++
     *      si(turnoJugador < 4 && cantidadJugadas < jugadasTotal)
     *          turnoJugador == 0;
     *      sino
     *          turnoJugador++;
     *      finSi
     *  finMientras
     *
     *
     */


    //TODO Desarrollar javadoc
    //TODO Documentar codigo mejor
    //TODO Ver si se puede modular
    //TODO Disminuir dinero despues de todas las jugadas

    public void realizarApuestas(int turnoJugador, MesaImpl mesa,int ronda){
        GestoraJugadorImpl gesJug = new GestoraJugadorImpl();
        int apuestaMinima = 0, cantidadJugadas = 0, totalJugadas = 5, apuestaJugador, cantidadJugadoresPasan = 0;
        boolean jugadorPasa = false;
        for (JugadorImpl jugador: mesa.getJugadores()) {
            if (!jugador.getActivo()){
                cantidadJugadoresPasan ++;
            }
        }
        if (cantidadJugadoresPasan != 4) {
            if (mesa.obtenerJugador(turnoJugador).getActivo() && mesa.obtenerJugador(turnoJugador).getSaldo() > 0) {
                if (turnoJugador == 0){
                    apuestaJugador = gesJug.leerYValidarApuesta(mesa.obtenerJugador(turnoJugador), apuestaMinima);
                }else{
                    apuestaJugador = gesJug.calcularApostarBot(apuestaMinima,mesa,turnoJugador,ronda);
                }
                if (apuestaJugador > apuestaMinima) {
                    apuestaMinima = apuestaJugador;
                    mesa.anhadirApuesta(turnoJugador, ronda, apuestaMinima);
                    mesa.obtenerJugador(turnoJugador).disminuirDinero(apuestaMinima);
                } else {
                    //Si el jugador apuesta el mismo valor que la apuesta minima (es decir 0) significa que pasa
                    if (apuestaJugador == apuestaMinima) {
                        jugadorPasa = true;
                    }
                }
            }
            cantidadJugadas++;
            if (turnoJugador == 4 && cantidadJugadas < totalJugadas) {
                turnoJugador = 0;
            } else {
                turnoJugador++;
            }
            while (turnoJugador < 5 && cantidadJugadas < totalJugadas) {
                if (mesa.obtenerJugador(turnoJugador).getActivo() && mesa.obtenerJugador(turnoJugador).getSaldo() > 0) {
                    if (turnoJugador == 0){
                        apuestaJugador = gesJug.leerYValidarApuesta(mesa.obtenerJugador(turnoJugador),apuestaMinima);
                    }else{
                        apuestaJugador = gesJug.calcularApostarBot(apuestaMinima, mesa, turnoJugador,ronda);
                        //TODO En el caso de querer apostar y no poder por no llegar al minimo que haga all-in  (Creo que ya esta solucionado pero tengo que comprobarlo)
                    }
                    if (apuestaJugador != apuestaMinima || jugadorPasa) {
                        jugadorPasa = false;
                        if (apuestaJugador == 0) {
                            mesa.obtenerJugador(turnoJugador).setActivo(false);
                        } else {
                            if (apuestaJugador > apuestaMinima) {
                                apuestaMinima = apuestaJugador;
                                if ((totalJugadas-cantidadJugadas) < 5){
                                    totalJugadas += 4;
                                }else{
                                    totalJugadas++;
                                }
                                mesa.obtenerJugador(turnoJugador).disminuirDinero(apuestaJugador);
                                mesa.anhadirApuesta(turnoJugador, ronda, apuestaJugador);
                            } else {
                                mesa.obtenerJugador(turnoJugador).disminuirDinero(apuestaJugador);
                                mesa.anhadirApuesta(turnoJugador, ronda, apuestaJugador);
                            }
                        }
                    } else {
                        mesa.obtenerJugador(turnoJugador).disminuirDinero(apuestaJugador);
                        mesa.anhadirApuesta(turnoJugador, ronda, apuestaJugador);
                    }
                }
                //Actualizamos variables despues de realizar jugada
                cantidadJugadas++;
                if (turnoJugador == 4 && cantidadJugadas < totalJugadas) {
                    turnoJugador = 0;
                } else {
                    turnoJugador++;
                }
            }
        }
    }

}