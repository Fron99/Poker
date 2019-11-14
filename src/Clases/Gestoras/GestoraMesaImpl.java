package Clases.Gestoras;

import Clases.Basicas.CartaImpl;
import Clases.Basicas.JugadorImpl;
import Clases.Basicas.MesaImpl;

import java.util.Random;

public class GestoraMesaImpl {

    /*
     * SIGNATURA: public void limpiarMesa(MesaImpl mesa)
     * COMENTARIO: Coloca en defecto todas las cartas del array pasado por parametro y coloca todas las apuestas de los jugadores a 0
     * PRECONDICIONES: - Nada
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Un objeto MesaImpl
     * POSTCONDICIONES: Modifica los atributo cartasMesa y apuestasJugadores del objeto MesaImpl pasado por
     *                  parametro colocando en defecto todas las cartas del array pasado por parametro y coloca todas las apuestas de los jugadores a 0.
     */

    //TODO Desarrollar javadoc

    public void limpiarMesa(MesaImpl mesa) {
        for (int i = 0; i < mesa.getCartasMesa().length; i++) {
            mesa.getCartasMesa()[i] = new CartaImpl();
        }
        for (int i = 0; i < mesa.getApuestasJugadores().length; i++) {
            for (int j = 0; j < mesa.getApuestasJugadores().length; j++) {
                mesa.getApuestasJugadores()[i][j] = 0;
            }
        }
    }


    /*
     * SIGNATURA: public void generarTresCartasMesa(CartaImpl[] baraja, CartaImpl[] cartas);
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

    //TODO Desarrollar javadoc

    public void generarTresCartasMesa(CartaImpl[] baraja, CartaImpl[] cartas) {

        Random r = new Random();
        int numPosicionCarta;

        numPosicionCarta = r.nextInt(52);
        for (int i = 0; i < 3; i++) {
            do {
                if (baraja[numPosicionCarta].getPalo() != 'D') {
                    cartas[i] = baraja[numPosicionCarta];
                    baraja[numPosicionCarta] = new CartaImpl();
                }
                numPosicionCarta = r.nextInt(52);
            } while (baraja[numPosicionCarta].getPalo() == 'D');

        }

    }


    /*
     * SIGNATURA: public void generarCartasJugadores(CartaImpl[] baraja, MesaImpl mesa);
     * COMENTARIO: Saca dos cartas de la baraja para cada jugador y se las asigna a cada jugador
     * PRECONDICIONES: - La baraja debe contener 54 campos
     *                 - La bajara debe estar completa o como minimo tener la cantidad de jugadores * 2 en cartas libres
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Un array de CartaImpl[] con la baraja
     *                 - Un objeto MesaImpl con la mesa en la que se esta jugando
     * POSTCONDICIONES: - Modifica el array de la baraja colocando por defecto las cartas sacadas y modifica el objeto mesa
     *                      asignando las cartas a los jugadores de la mesa
     */

    //TODO Desarrollar javadoc

    public void generarCartasJugadores(CartaImpl[] baraja, MesaImpl mesa) {

        Random r = new Random();
        int numPosicionCarta;

        numPosicionCarta = r.nextInt(52);

        for (int i = 0; i<mesa.getJugadores().length;i++){
            for (int j = 0; j<2; j++){
                do {
                    if (baraja[numPosicionCarta].getPalo() != 'D') {
                        mesa.getJugadores()[i].getCartas()[j] = baraja[numPosicionCarta];
                        baraja[numPosicionCarta] = new CartaImpl();
                    }
                    numPosicionCarta = r.nextInt(52);
                } while (baraja[numPosicionCarta].getPalo() == 'D');
            }
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

    //TODO Desarrollar javadoc

    public void mostrarPanelJuego(MesaImpl mesa) {

        int dinJugador, dinBot1, dinBot2, dinBot3, dinBot4;
        char paloCarta0, paloCarta1, paloCarta2, paloCarta3, paloCarta4;
        String numeroCarta0, numeroCarta1, numeroCarta2, numeroCarta3, numeroCarta4, userJugador, userBot1, userBot2, userBot3, userBot4;
        String numCar1Usuario, numCar2Usuario;
        char paloCar1Usuario, paloCar2Usuario;

        numCar1Usuario = mesa.getJugadores()[0].getCartas()[0].getNumero();
        numCar2Usuario = mesa.getJugadores()[0].getCartas()[1].getNumero();

        paloCar1Usuario = mesa.getJugadores()[0].getCartas()[0].getPalo();
        paloCar2Usuario = mesa.getJugadores()[0].getCartas()[1].getPalo();


        userJugador = mesa.getJugadores()[0].getUsuario();
        userBot1 = mesa.getJugadores()[1].getUsuario();
        userBot2 = mesa.getJugadores()[2].getUsuario();
        userBot3 = mesa.getJugadores()[3].getUsuario();
        userBot4 = mesa.getJugadores()[4].getUsuario();

        dinJugador = mesa.getJugadores()[0].getSaldo();
        dinBot1 = mesa.getJugadores()[1].getSaldo();
        dinBot2 = mesa.getJugadores()[2].getSaldo();
        dinBot3 = mesa.getJugadores()[3].getSaldo();
        dinBot4 = mesa.getJugadores()[4].getSaldo();

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
        System.out.println("                                      |º º|     -----        -----                                    |º º|    -----        -----");
        System.out.println("                                      |---|    | ?   |      | ?   |                                   |---|   | ?   |      | ?   |  ");
        System.out.println("                                               | ?   |      | ?   |                                           | ?   |      | ?   |");
        System.out.println("                                                -----        -----                                             -----        -----");



        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("       " + userBot1 + "                                                                                                                              " + userBot4);
        System.out.println("                                                        ----- " + "       " + " ----- " + "       " + " ----- " + "       " + " ----- " + "       " + " ----- ");
        System.out.println("       " + dinBot1 + "€                                           | " + paloCarta0 + "   |" + "       " + "| " + paloCarta1 + "   |" + "       " + "| " + paloCarta2 + "   |" + "       " + "| " + paloCarta3 + "   |" + "       " + "| " + paloCarta4 + "   |                      " + dinBot4 + "€");
        System.out.println("       |º º|       -----        -----                  | " + numeroCarta0 + "   |" + "       " + "| " + numeroCarta1 + "   |" + "       " + "| " + numeroCarta2 + "   |" + "       " + "| " + numeroCarta3 + "   |" + "       " + "| " + numeroCarta4 + "   |                      |º º|      -----        -----");
        System.out.println("       |---|      | ?   |      | ?   |                 |     |" + "       " + "|     |" + "       " + "|     |" + "       " + "|     |" + "       " + "|     |" + "                      |---|     | ?   |      | ?   |");
        System.out.println("                  | ?   |      | ?   |                  ----- " + "       " + " ----- " + "       " + " ----- " + "       " + " ----- " + "       " + " -----                                 |     | ?    | ?   |");
        System.out.println("                   -----        -----                                                                                                                  -----        -----");

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
     * SIGNATURA:
     * COMENTARIO:
     * PRECONDICIONES:
     * ENTRADA:
     * SALIDA:
     * ENTRADA/SALIDA:
     * POSTCONDICIONES:
     */

    //TODO Desarrollar javadoc
    //TODO Desarrollar interfaz

    public void uj(MesaImpl mesa) {

        int dinJugador, dinBot1, dinBot2, dinBot3, dinBot4;
        char paloCarta0, paloCarta1, paloCarta2, paloCarta3, paloCarta4;
        String numeroCarta0, numeroCarta1, numeroCarta2, numeroCarta3, numeroCarta4, userJugador, userBot1, userBot2, userBot3, userBot4;
        String numCar1Bot1, numCar2Bot1, numCar1Bot2, numCar2Bot2, numCar1Bot3, numCar2Bot3, numCar1Bot4, numCar2Bot4, numCar1Usuario, numCar2Usuario;
        char paloCar1Bot1, paloCar2Bot1, paloCar1Bot2, paloCar2Bot2, paloCar1Bot3, paloCar2Bot3, paloCar1Bot4, paloCar2Bot4, paloCar1Usuario, paloCar2Usuario;

        numCar1Usuario = mesa.getJugadores()[0].getCartas()[0].getNumero();
        numCar2Usuario = mesa.getJugadores()[0].getCartas()[1].getNumero();

        paloCar1Usuario = mesa.getJugadores()[0].getCartas()[0].getPalo();
        paloCar2Usuario = mesa.getJugadores()[0].getCartas()[1].getPalo();


        userJugador = mesa.getJugadores()[0].getUsuario();
        userBot1 = mesa.getJugadores()[1].getUsuario();
        userBot2 = mesa.getJugadores()[2].getUsuario();
        userBot3 = mesa.getJugadores()[3].getUsuario();
        userBot4 = mesa.getJugadores()[4].getUsuario();

        dinJugador = mesa.getJugadores()[0].getSaldo();
        dinBot1 = mesa.getJugadores()[1].getSaldo();
        dinBot2 = mesa.getJugadores()[2].getSaldo();
        dinBot3 = mesa.getJugadores()[3].getSaldo();
        dinBot4 = mesa.getJugadores()[4].getSaldo();

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
        System.out.println("                                      |º º|     -----        -----                                    |º º|    -----        -----");
        System.out.println("                                      |---|    | ?   |      | ?   |                                   |---|   | ?   |      | ?   |  ");
        System.out.println("                                               | ?   |      | ?   |                                           | ?   |      | ?   |");
        System.out.println("                                                -----        -----                                             -----        -----");



        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("       " + userBot1 + "                                                                                                                              " + userBot4);
        System.out.println("                                                        ----- " + "       " + " ----- " + "       " + " ----- " + "       " + " ----- " + "       " + " ----- ");
        System.out.println("       " + dinBot1 + "€                                           | " + paloCarta0 + "   |" + "       " + "| " + paloCarta1 + "   |" + "       " + "| " + paloCarta2 + "   |" + "       " + "| " + paloCarta3 + "   |" + "       " + "| " + paloCarta4 + "   |                      " + dinBot4 + "€");
        System.out.println("       |º º|       -----        -----                  | " + numeroCarta0 + "   |" + "       " + "| " + numeroCarta1 + "   |" + "       " + "| " + numeroCarta2 + "   |" + "       " + "| " + numeroCarta3 + "   |" + "       " + "| " + numeroCarta4 + "   |                      |º º|      -----        -----");
        System.out.println("       |---|      | ?   |      | ?   |                 |     |" + "       " + "|     |" + "       " + "|     |" + "       " + "|     |" + "       " + "|     |" + "                      |---|     | ?   |      | ?   |");
        System.out.println("                  | ?   |      | ?   |                  ----- " + "       " + " ----- " + "       " + " ----- " + "       " + " ----- " + "       " + " -----                                 |     | ?    | ?   |");
        System.out.println("                   -----        -----                                                                                                                  -----        -----");

        System.out.println();
        //System.out.println("                                                              DINERO EN MESA: " + mesa.getTotalApuestas() + "€");
        System.out.println();
        System.out.println();

        System.out.println("                                                                     " + userJugador);
        System.out.println("                                                              TU SALDO ES: " + dinJugador + "€");
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
     * SIGNATURA: public void generarCartaMesa(CartaImpl[] baraja, CartaImpl[] cartas);
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

    //TODO Desarrollar javadoc

    public void generarCartaMesa(CartaImpl[] baraja, CartaImpl[] cartas) {

        Random r = new Random();
        int numPosicionCarta, indiceCartaGenerar = 0;

        numPosicionCarta = r.nextInt(52);

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
            numPosicionCarta = r.nextInt(52);
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

    //TODO Desarrollar javadoc

    public void ingresarDineroGanador(int ganador, MesaImpl mesa) {
        int cantidadMesa;
        cantidadMesa = mesa.getTotalApuestas();
        mesa.getJugadores()[ganador].aumentarDinero(cantidadMesa);
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
                    apuestaJugador = gesJug.calcularApostarBot(apuestaMinima,mesa,turnoJugador);
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
                        apuestaJugador = gesJug.calcularApostarBot(apuestaMinima, mesa, turnoJugador);    //TODO Tener en cuenta que la cantidad a apostar no sea mayor a lo que el usuario tiene
                        //TODO En el caso de querer apostar y no poder por no llegar al minimo que haga all-in  (Creo que ya esta solucionado pero tengo que comprobarlo)
                    }
                    if (apuestaJugador != apuestaMinima || jugadorPasa) {
                        jugadorPasa = false;
                        if (apuestaJugador == 0) {
                            mesa.obtenerJugador(turnoJugador).setActivo(false);
                        } else {
                            if (apuestaJugador > apuestaMinima) {
                                apuestaMinima = apuestaJugador;
                                if (totalJugadas == 5){
                                    totalJugadas += 4;
                                }else{
                                    totalJugadas ++;
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