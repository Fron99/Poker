package Clases.Gestoras;

import Clases.Basicas.CartaImpl;
import Clases.Basicas.MesaImpl;

import java.util.Random;

public class GestoraMesaImpl {


    /*
     * SIGNATURA: public void inicializarBaraja(CartaImpl[] cartas)
     * COMENTARIO: Anhade todas las cartas posibles al array pasado por parametro
     * PRECONDICIONES: - El array debe tener como minimo 54 campos
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Un array de CartaImpl
     * POSTCONDICIONES: Modifica el array pasado por parametro anhadiendo todas las cartas posibles
     */

    public void inicializarBaraja(CartaImpl[] cartas) {

        cartas[0] = new CartaImpl('P', "A");
        cartas[1] = new CartaImpl('P', "2");
        cartas[2] = new CartaImpl('P', "3");
        cartas[3] = new CartaImpl('P', "4");
        cartas[4] = new CartaImpl('P', "5");
        cartas[5] = new CartaImpl('P', "6");
        cartas[6] = new CartaImpl('P', "7");
        cartas[7] = new CartaImpl('P', "8");
        cartas[8] = new CartaImpl('P', "9");
        cartas[9] = new CartaImpl('P', "10");
        cartas[10] = new CartaImpl('P', "J");
        cartas[11] = new CartaImpl('P', "Q");
        cartas[12] = new CartaImpl('P', "K");

        cartas[13] = new CartaImpl('C', "A");
        cartas[14] = new CartaImpl('C', "2");
        cartas[15] = new CartaImpl('C', "3");
        cartas[16] = new CartaImpl('C', "4");
        cartas[17] = new CartaImpl('C', "5");
        cartas[18] = new CartaImpl('C', "6");
        cartas[19] = new CartaImpl('C', "7");
        cartas[20] = new CartaImpl('C', "8");
        cartas[21] = new CartaImpl('C', "9");
        cartas[22] = new CartaImpl('C', "10");
        cartas[23] = new CartaImpl('C', "J");
        cartas[24] = new CartaImpl('C', "Q");
        cartas[25] = new CartaImpl('C', "K");

        cartas[26] = new CartaImpl('R', "A");
        cartas[27] = new CartaImpl('R', "2");
        cartas[28] = new CartaImpl('R', "3");
        cartas[29] = new CartaImpl('R', "4");
        cartas[30] = new CartaImpl('R', "5");
        cartas[31] = new CartaImpl('R', "6");
        cartas[32] = new CartaImpl('R', "7");
        cartas[33] = new CartaImpl('R', "8");
        cartas[34] = new CartaImpl('R', "9");
        cartas[35] = new CartaImpl('R', "10");
        cartas[36] = new CartaImpl('R', "J");
        cartas[37] = new CartaImpl('R', "Q");
        cartas[38] = new CartaImpl('R', "K");

        cartas[39] = new CartaImpl('T', "A");
        cartas[40] = new CartaImpl('T', "2");
        cartas[41] = new CartaImpl('T', "3");
        cartas[42] = new CartaImpl('T', "4");
        cartas[43] = new CartaImpl('T', "5");
        cartas[44] = new CartaImpl('T', "6");
        cartas[45] = new CartaImpl('T', "7");
        cartas[46] = new CartaImpl('T', "8");
        cartas[47] = new CartaImpl('T', "9");
        cartas[48] = new CartaImpl('T', "10");
        cartas[49] = new CartaImpl('T', "J");
        cartas[50] = new CartaImpl('T', "Q");
        cartas[51] = new CartaImpl('T', "K");

        cartas[52] = new CartaImpl('J', "J");
        cartas[53] = new CartaImpl('J', "J");

    }


    /*
     * SIGNATURA: public void limpiarMesa(MesaImpl mesa)
     * COMENTARIO: Coloca en defecto todas las cartas del array pasado por parametro y el total de las apuestas en 0
     * PRECONDICIONES: - El array debe tener 5 campos
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Un array de CartaImpl
     * POSTCONDICIONES: Modifica el array pasado por parametro colocando por defecto todas las cartas y las apuestas en 0
     */

    public void limpiarMesa(MesaImpl mesa) {
        for (int i = 0; i < mesa.getCartasMesa().length; i++) {
            mesa.getCartasMesa()[i] = new CartaImpl();
        }
        mesa.setTotalApuestas(0);
    }


    /*
     * SIGNATURA: public void sacar3Cartas(CartaImpl[] baraja, CartaImpl[] cartas);
     * COMENTARIO: Saca 3 cartas de la baraja y las coloca en el segundo array pasado por parametro
     * PRECONDICIONES: - El primer array debe tener 54 campos
     *                 - El segundo array debe tener 5 campos
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Un array de CartaImpl con todas las cartas posibles
     *                 - Un array de CartaImpl con las cartas de la mesa
     * POSTCONDICIONES: Modifica el array pasado por parametro eliminando las cartas que se saquen aleatoriamente y anhadiendose
     *                  al segundo array pasado por parametro que son las cartas de la mesa
     */


    public void generar3Cartas(CartaImpl[] baraja, CartaImpl[] cartas) {

        Random r = new Random();
        int numPosicionCarta = 0;

        numPosicionCarta = r.nextInt(54);
        for (int i = 0; i < 3; i++) {
            do {
                if (baraja[numPosicionCarta].getPalo() != 'D') {
                    cartas[i] = baraja[numPosicionCarta];
                    baraja[numPosicionCarta] = new CartaImpl();
                }
                numPosicionCarta = r.nextInt(54);
            } while (baraja[numPosicionCarta].getPalo() == 'D');

        }

    }


    /*
     * SIGNATURA: public void mostrarPanelJuego (MesaImpl mesa);
     * COMENTARIO: Imprime por pantalla las cartas que hay en la mesa, el dinero de los demas jugadores y el total del bote de la mesa
     * PRECONDICIONES: - Nada
     * ENTRADA: - Un objeto Mesa
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - No devuelve nada, solo imprime por pantalla el estado actual en el que se encuentran los jugadores y las cartas
     */

    public void mostrarPanelJuego(MesaImpl mesa) {

        int dinJugador, dinBot1, dinBot2, dinBot3, dinBot4;
        char paloCarta0, paloCarta1, paloCarta2, paloCarta3, paloCarta4;
        String numeroCarta0, numeroCarta1, numeroCarta2, numeroCarta3, numeroCarta4, userJugador, userBot1, userBot2, userBot3, userBot4;

        userJugador = mesa.getJugadores()[0].getUsuario();
        userBot1 = mesa.getJugadores()[1].getUsuario();
        userBot2 = mesa.getJugadores()[2].getUsuario();
        userBot3 = mesa.getJugadores()[3].getUsuario();
        userBot4 = mesa.getJugadores()[4].getUsuario();

        dinJugador = mesa.getJugadores()[0].getDinero();
        dinBot1 = mesa.getJugadores()[1].getDinero();
        dinBot2 = mesa.getJugadores()[2].getDinero();
        dinBot3 = mesa.getJugadores()[3].getDinero();
        dinBot4 = mesa.getJugadores()[4].getDinero();

        paloCarta0 = mesa.getCartasMesa()[0].getPalo();
        paloCarta1 = mesa.getCartasMesa()[1].getPalo();
        paloCarta2 = mesa.getCartasMesa()[2].getPalo();
        paloCarta3 = mesa.getCartasMesa()[3].getPalo();
        paloCarta4 = mesa.getCartasMesa()[4].getPalo();

        numeroCarta0 = mesa.getCartasMesa()[0].getNumero();
        numeroCarta1 = mesa.getCartasMesa()[1].getNumero();
        numeroCarta2 = mesa.getCartasMesa()[2].getNumero();
        numeroCarta3 = mesa.getCartasMesa()[3].getNumero();
        numeroCarta4 = mesa.getCartasMesa()[4].getNumero();

        System.out.println("                                      " + userBot2 + "                                       " + userBot3);
        System.out.println();
        System.out.println("                                      " + dinBot2 + "€                                               " + dinBot3 + "€");
        System.out.println("                                      |º º|                                               |º º|");
        System.out.println("                                      |---|                                               |---|");

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("       " + userBot1 + "                                                                                                                                                                                                     " + userBot4);
        System.out.println("                                    ----- " + "       " + " ----- " + "       " + " ----- " + "       " + " ----- " + "       " + " ----- ");
        System.out.println("       " + dinBot1 + "€                       | " + paloCarta0 + "   |" + "       " + "| " + paloCarta1 + "   |" + "       " + "| " + paloCarta2 + "   |" + "       " + "| " + paloCarta3 + "   |" + "       " + "| " + paloCarta4 + "   |                      " + dinBot4 + "€");
        System.out.println("       |º º|                       | " + numeroCarta0 + "   |" + "       " + "| " + numeroCarta1 + "   |" + "       " + "| " + numeroCarta2 + "   |" + "       " + "| " + numeroCarta3 + "   |" + "       " + "| " + numeroCarta4 + "   |                      |º º|");
        System.out.println("       |---|                       |     |" + "       " + "|     |" + "       " + "|     |" + "       " + "|     |" + "       " + "|     |" + "                      |---|");
        System.out.println("                                    ----- " + "       " + " ----- " + "       " + " ----- " + "       " + " ----- " + "       " + " ----- ");

        System.out.println();
        System.out.println("                                                              DINERO EN MESA: " + mesa.getTotalApuestas() + "€");
        System.out.println();
        System.out.println();

        System.out.println("                                                                     " + userJugador);
        System.out.println("                                                              TU SALDO ES: " + dinJugador + "€");
        System.out.println();
        System.out.println("                                                           _______________________");
        System.out.println("                                                          |                       |");
        System.out.println("                                                          |    __           __    |");
        System.out.println("                                                          |   |º |         |º |   |");
        System.out.println("                                                          |    --           --    |");
        System.out.println("                                                          |                       |");
        System.out.println("                                                          |   \\              /    |");
        System.out.println("                                                          |     \\___________/     |");
        System.out.println("                                                          |                       |");
        System.out.println("                                                           -----------------------");
        System.out.println();

    }


    /*
     * SIGNATURA: public void generarCarta(CartaImpl[] baraja, CartaImpl[] cartas);
     * COMENTARIO: Saca 1 cartas de la baraja y las coloca en el segundo array pasado por parametro
     * PRECONDICIONES: - El primer array debe tener 54 campos
     *                 - El segundo array debe tener 5 campos
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Un array de CartaImpl con todas las cartas posibles
     *                 - Un array de CartaImpl con las cartas de la mesa
     * POSTCONDICIONES: Modifica el array pasado por parametro eliminando las cartas que se saquen aleatoriamente y anhadiendose
     *                  al segundo array pasado por parametro que son las cartas de la mesa
     */


    public void generarCarta(CartaImpl[] baraja, CartaImpl[] cartas) {

        Random r = new Random();
        int numPosicionCarta, indiceCartaGenerar = 0;

        numPosicionCarta = r.nextInt(54);

        //Calcula cual es la siguiente carta sin levantar y guarda el indice
        for (int i = 0; i < cartas.length && cartas[i].getPalo() != 'D'; i++) {
            if ((i + 1) <= cartas.length) {
                if (cartas[i + 1].getPalo() == 'D') {
                    indiceCartaGenerar = i + 1;
                }
            }
        }

        //Guarda la carta que se ha sacado de la baraja en las cartas de la mesa
        do {
            if (baraja[numPosicionCarta].getPalo() != 'D') {
                cartas[indiceCartaGenerar] = baraja[numPosicionCarta];
                baraja[numPosicionCarta] = new CartaImpl();
            }
            numPosicionCarta = r.nextInt(54);
        } while (baraja[numPosicionCarta].getPalo() == 'D');

    }

    /*
     * SIGNATURA: public void ingresarDineroGanador(int ganador, MesaImpl mesa);
     * COMENTARIO: Aumenta el saldo del usuario ganador de la mano
     * PRECONDICIONES: - El ganador no puede ser menor de 0 ni mayor de 5
     * ENTRADA: - Un entero con el ganador
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Un objeto mesa
     * POSTCONDICIONES: - Modifica el objeto mesa incrementando el saldo del usuario ganador con el total de apuestas de la mano jugada.
     *
     */

    public void ingresarDineroGanador(int ganador, MesaImpl mesa) {
        int cantidadMesa;
        cantidadMesa = mesa.getTotalApuestas();
        mesa.getJugadores()[ganador].aumentarDinero(cantidadMesa);
    }


    /*
     * SIGNATURA: public void realizarJugadas(int turnoJugador, MesaImpl mesa);
     * COMENTARIO: Realiza el proceso de apuestas de cada ronda segun el orden pasado.
     * PRECONDICIONES: - El turnoJugador no puede ser mayor a 4 ni menor que 0
     * ENTRADA: - Un entero para el iniciador
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Un objeto mesa con el que se este jugando
     * POSTCONDICIONES: - Modifica la apuesta total de la mesa pasada por parametro incrementando su valor conforme los jugadores apuesten
     *
     */

    /*
     * INICIO
     * si(iniciador == idUsuario)
     *  //leerYValidarApuestaJugador
     *  mientras(queden bots sin apostar)
     *      //generarCantidadApuesta
     *      //incrementarTotalApuestas
     *  finMientras
     * siNo
     *  mientras(no se llegue al final del array)
     *      //generarCantidadApuesta
     *      //incrementarTotalApuestas
     *  finMientras
     *  //leerYValidarApuestaJugador
     *  //incrementarTotalApuestas
     *  mientras(queden bots sin apostar)
     *      //generarCantidadApuesta
     *      //incrementarTotalApuestas
     *  finMientras
     * finSi
     * FIN
     */

    public void realizarJugadas(int turnoJugador, MesaImpl mesa) {

        GestoraJugadorImpl gesJugador = new GestoraJugadorImpl();
        int apuestaInicial, cantidadJugadas = 0;

        //TODO Disminuir saldo al apostar a cada jugador

        if (turnoJugador == mesa.getJugadores()[0].getID()) {
            apuestaInicial = gesJugador.leerYValidarApuesta(mesa.getJugadores()[0]);
            mesa.incrementarTotalApuestas(apuestaInicial);
            turnoJugador++;
            while (turnoJugador < mesa.getJugadores().length) {
                mesa.incrementarTotalApuestas(apuestaInicial);
                turnoJugador++;
            }
        } else {
            while (turnoJugador < mesa.getJugadores().length && cantidadJugadas < 5) {
                apuestaInicial = 2000;
                if (turnoJugador == 4) {
                    turnoJugador = 0;
                    mesa.incrementarTotalApuestas(apuestaInicial);
                    turnoJugador++;
                    cantidadJugadas++;
                }
                if (cantidadJugadas < 5) {
                    mesa.incrementarTotalApuestas(apuestaInicial);
                    //TODO De esta manera solo elige cantidad a apostar cuando el usuario empieza, si no empieza apuesta lo que apueste el primero.
                    turnoJugador++;
                    cantidadJugadas++;
                }
            }
        }
    }
}