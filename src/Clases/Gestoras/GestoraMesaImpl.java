package Clases.Gestoras;

import Clases.Basicas.CartaImpl;
import Clases.Basicas.MesaImpl;

import java.util.Random;

public class GestoraMesaImpl {

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
        //mesa.setTotalApuestas(0);
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


    public void generarCartasJugadores(CartaImpl[] baraja, MesaImpl mesa) {

        Random r = new Random();
        int numPosicionCarta;

        numPosicionCarta = r.nextInt(54);

        for (int i = 0; i<mesa.getJugadores().length;i++){
            for (int j = 0; j<2; j++){
                do {
                    if (baraja[numPosicionCarta].getPalo() != 'D') {
                        mesa.getJugadores()[i].getCartas()[j] = baraja[numPosicionCarta];
                        baraja[numPosicionCarta] = new CartaImpl();
                    }
                    numPosicionCarta = r.nextInt(54);
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

    public void mostrarPanelJuego(MesaImpl mesa) {

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
        //cantidadMesa = mesa.getTotalApuestas();
        //mesa.getJugadores()[ganador].aumentarDinero(cantidadMesa);
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

    public void realizarJugadas(int turnoJugador, MesaImpl mesa) {

        GestoraJugadorImpl gesJugador = new GestoraJugadorImpl();
        int apuestaInicial, cantidadJugadas = 0;

        if (turnoJugador == 0) {
            apuestaInicial = gesJugador.leerYValidarApuesta(mesa.getJugadores()[0]);    //Pregunta al jugador cuento quiere apostar
            mesa.getJugadores()[0].disminuirDinero(apuestaInicial);
            //mesa.incrementarTotalApuestas(apuestaInicial);
            turnoJugador++;
            while (turnoJugador<mesa.getJugadores().length){
                //TODO Falta generar apuesta conforme las cartas que tenga el bot
                //mesa.incrementarTotalApuestas(apuestaInicial);  //Apuesta lo mismo que elige el jugador porque aun no se ha implementado la IA
                mesa.getJugadores()[turnoJugador].disminuirDinero(apuestaInicial);  //Disminuye el dinero apostado del saldo del usuario
                turnoJugador++;
            }
        } else {
            while (turnoJugador < mesa.getJugadores().length && cantidadJugadas < 5) {
                apuestaInicial = 10;      //Colocamos 10 euros por defecto porque aun no se ha generado el metodo el cual el bot genere la cantidad a apostar segun sus cartas
                if (turnoJugador == 4) {
                    //mesa.incrementarTotalApuestas(apuestaInicial);
                    mesa.getJugadores()[turnoJugador].disminuirDinero(apuestaInicial);  //Disminuye el dinero apostado del saldo del usuario
                    turnoJugador = 0;
                    cantidadJugadas++;
                }
                if (cantidadJugadas < 5) {
                    //mesa.incrementarTotalApuestas(apuestaInicial);
                    //TODO De esta manera solo elige cantidad a apostar cuando el usuario empieza, si no empieza apuesta lo que apueste el primero.
                    mesa.getJugadores()[turnoJugador].disminuirDinero(apuestaInicial);  //Disminuye el dinero apostado del saldo del usuario
                    turnoJugador++;
                    cantidadJugadas++;
                }
            }
        }
    }


    /*
     * SIGNATURA: public void realizarApuestas(int turnoJugador, MesaImpl mesa)
     * COMENTARIO: Realizar las apuestas de todos los jugadores de la mesa
     * PRECONDICIONES:
     * ENTRADA: - Un entero con el turno
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Un objeto mesa
     * POSTCONDICIONES: - Modifica el objeto mesa, incrementando el total del dinero que hay en mesa.
     *
     */


    public void realizarApuestas(int turnoJugador, MesaImpl mesa){

        GestoraJugadorImpl gesJugador = new GestoraJugadorImpl();
        int apuestaBase, apuestaJugador, cantidadJugadas = 0, totalJugadas = 5;

        if (turnoJugador == 0) {
            apuestaJugador = gesJugador.leerYValidarApuesta(mesa.getJugadores()[0]);    //Pregunta al jugador cuento quiere apostar
            apuestaBase = apuestaJugador;   //Como este jugador es el primero en jugar se coloca su apuesta como apuesta base
            mesa.getJugadores()[0].disminuirDinero(apuestaJugador);
            //mesa.incrementarTotalApuestas(apuestaJugador);
            turnoJugador++;
            cantidadJugadas++;
            while (turnoJugador<mesa.getJugadores().length && cantidadJugadas < totalJugadas){
                //TODO Falta generar apuesta conforme las cartas que tenga el bot
                apuestaJugador = gesJugador.leerYValidarApuesta(mesa.getJugadores()[turnoJugador]);    //TODO Valor puesto de prueba mientras no se genera el metodo de la IA
                //TODO Falta validar que la apuesta no sea menor a la apostada por en anterior jugador anteriormente
                if (apuestaJugador > apuestaBase){
                    apuestaBase = apuestaJugador;
                    if (totalJugadas == 5){
                        totalJugadas +=3;
                    }else{
                        totalJugadas++;
                    }
                    //mesa.incrementarTotalApuestas(apuestaJugador);  //Apuesta lo mismo que elige el jugador porque aun no se ha implementado la IA
                    mesa.getJugadores()[turnoJugador].disminuirDinero(apuestaJugador);  //Disminuye el dinero apostado del saldo del usuario
                    turnoJugador++;
                    cantidadJugadas++;
                }else{
                    if (apuestaJugador == apuestaBase){
                        //mesa.incrementarTotalApuestas(apuestaJugador);  //Apuesta lo mismo que elige el jugador porque aun no se ha implementado la IA
                        mesa.getJugadores()[turnoJugador].disminuirDinero(apuestaJugador);  //Disminuye el dinero apostado del saldo del usuario
                        turnoJugador++;
                        cantidadJugadas++;
                    }
                }

                if (turnoJugador == 5 && cantidadJugadas<totalJugadas){
                    turnoJugador = 0;
                }

            }
        }
    }





}