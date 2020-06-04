package managements;

import basicsClasses.CardImpl;
import basicsClasses.PlayerImpl;
import basicsClasses.TableImpl;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.Scanner;

public class ManagementPlayerImpl {

    /**
     * @param password
     * @return
     */

    public String encriptPassword(String password){
        String passEncripted = null;

        try {
            byte[] bytesOfMessage = password.getBytes(StandardCharsets.UTF_8);
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] thedigest = md.digest(bytesOfMessage);
            BigInteger bigInt = new BigInteger(1,thedigest);
            passEncripted = bigInt.toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return passEncripted;
    }


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

    /**
     * Read and validate the player's initial money
     * @return int This method returns the amount of money validated with which the player wants to play
     */

    public int leerYValidarSaldoInicial(){
        int dinero;
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.println("La cantidad minima para iniciar es 2000€ y la maxima 10000€");
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

    /**
     * @return
     */

    public String leerUsuario(){
        String usuario;
        Scanner teclado = new Scanner(System.in);
            System.out.print("Introduce usuario con el que quiere jugar: ");
            usuario = teclado.nextLine();
        return usuario;
    }


    /*
     * SIGNATURA:
     * COMENTARIO: Lee y valida la cantidad de dinero que puede apostar el jugador
     * PRECONDICIONES: Ninguna
     * ENTRADA: - Un jugador
     *          - Apuesta minima
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con la cantidad de dinero que apuesta el jugador
     *
     */

    /**
     * @param jugador
     * @param apuestaMinima
     * @param mesa
     * @param apuestaMaxima
     * @return
     */

    public int leerYValidarApuesta(int jugador, int apuestaMinima, int apuestaMaxima, TableImpl mesa){
        Scanner teclado = new Scanner(System.in);
        int cantidadApuesta;
        boolean allIn = false;
        do {
            System.out.println("Dispone de "+mesa.getBalancePlayer(jugador)+" de saldo");
            System.out.println("La apuesa minima es: "+(apuestaMinima-mesa.getBetPlayer(jugador,mesa.getRound())) + " y la apuesta maxima es: "+apuestaMaxima);
            System.out.print("Introduce cuanto quiere apostar: ");
            cantidadApuesta = teclado.nextInt();
            if (cantidadApuesta < apuestaMinima-mesa.getBetPlayer(jugador,mesa.getRound())){
                if (cantidadApuesta == mesa.getBalancePlayer(jugador)){
                    allIn = true;
                }
            }
        }while (cantidadApuesta < apuestaMinima
                || cantidadApuesta > apuestaMaxima
                || (cantidadApuesta < apuestaMinima && !allIn && cantidadApuesta != 0)
                || cantidadApuesta > mesa.getBalancePlayer(jugador));

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

    /**
     * @param jugador
     * @param apuestaMinima
     * @param apuestaMaxima
     * @param mesa
     * @return
     */

    public int calcularApostarBot(int jugador, int apuestaMinima, int apuestaMaxima, TableImpl mesa){
        int totalApostar, valorCartas, valorFarolRonda, puntosPosibilidad;
        double porcenApostar;
        ManagementCardImpl gesCarta = new ManagementCardImpl();

        //Obtener puntos de las cartas
        valorCartas = gesCarta.evaluateCardsFromPlayer(jugador,mesa);

        //Obtener puntos de farol
        valorFarolRonda = calcularPuntosFarolRonda(mesa.getRound());

        //Obtener puntos por posibilidad
        puntosPosibilidad = calcularPuntosPosibilidad(gesCarta.getCardsToEvaluate(jugador,mesa));

        if (mesa.getBalancePlayer(jugador) < 2000){
            
            totalApostar = 0;
            //TODO Implementar cuando el saldo sea mas bajo de x cantidad para que no apueste con porcentajes.

        }else{

            //Porcentaje apostar
            porcenApostar = ((double)((valorFarolRonda+valorCartas+puntosPosibilidad)*100) / 319)*0.01;

            //Total calculado que va a apostar
            totalApostar = (int)(mesa.getBalancePlayer(jugador) * porcenApostar);

            //Comprueba si la apuesta es mayor o igual.
            if (apuestaMinima >= totalApostar){
                //En el caso de que la apuesta minima sea mayor calculamos si con un incremento del 30% al total apostar si quiere subir e igualar a la apuesta minima
                if ((int)(totalApostar*1.30) >= apuestaMinima){
                    totalApostar = apuestaMinima - mesa.getBetPlayer(jugador,mesa.getRound());
                }else{
                    //En el caso de que la apuesta minima sea mucho mas alta que lo que pensaba apostar el jugador, valorar si tiene suficiente buenas cartas como para subir la apuesta
                    //192 puntos concuerda con el 60% del total de puntos
                    //Quizas se deberia poner con la personalidad del jugador
                    if ((valorFarolRonda+valorCartas+puntosPosibilidad) >= 192){
                        totalApostar = apuestaMinima - mesa.getBetPlayer(jugador,mesa.getRound());
                    }else{
                        //En el caso de que decidiera no subir la apuesta e igualarla se "tiraria"
                        totalApostar = 0;
                    }
                }
            }else{
                //Calcula si debe bajar la apuesta con un decremento del 30%. Si aun asi sigue siendo mayor que la apuesta minima seguira apostando lo que pensaba apostar
                if ((int)(totalApostar*0.70) < apuestaMinima){
                    totalApostar = apuestaMinima - mesa.getBetPlayer(jugador,mesa.getRound());
                }
            }

            //No apostar mas de lo que los demas jugadores puedan apostar
            if (totalApostar > apuestaMaxima){
                totalApostar = apuestaMaxima;
            }

        }

        return totalApostar;
    }


    /*
     * SIGNATURA: public int calcularPuntosFarol(int ronda);
     * COMENTARIO: Calcular cantidad de puntos que debe incrementar la apuesta el bot
     * PRECONDICIONES: - Nada
     * ENTRADA: - Un entero
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre la cantidad de puntos que debe incrementar en un farol el bot dependiendo de la ronda en la que se encuentre
     */

    /**
     * @param ronda
     * @return
     */

    private int calcularPuntosFarolRonda(int ronda){
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
     * SIGNATURA: private int calcularPuntosPosibilidad()
     * COMENTARIO: Calcula la posibilidad que tienen las cartas del jugador a tener algo de valor
     * PRECONDICIONES: - El array no debe tener cartas por defecto.
     * ENTRADA: - Un array de CartaImpl
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre el valor en puntos de la posibilidad de tener cartas de valor en la partida.
     */

    //TODO

    /**
     * @param cartasAEvaluar
     * @return
     */

    private int calcularPuntosPosibilidad(CardImpl[] cartasAEvaluar){
        int puntosPosibilidad = 0, puntos = 0, colorP = 0, colorT = 0, colorR = 0, colorC = 0 ;
        ManagementCardImpl gestoraCarta = new ManagementCardImpl();
        boolean unaParaEscalera;

        switch (cartasAEvaluar.length){
            //Si el array contiene 2 cartas significa que esta en la primera ronda
            case 2:

                for (CardImpl carta : cartasAEvaluar) {
                    if (carta.getValueNumber() == 13 || carta.getValueNumber() == 12 || carta.getValueNumber() == 11 || carta.getValueNumber() == 10) {
                        puntosPosibilidad = 20;
                    }
                }

                if (cartasAEvaluar[0].getValueNumber() == 13 || cartasAEvaluar[0].getValueNumber() == 12 || cartasAEvaluar[0].getValueNumber() == 11 || cartasAEvaluar[0].getValueNumber() == 10
                    && cartasAEvaluar[1].getValueNumber() == 13 || cartasAEvaluar[1].getValueNumber() == 12 || cartasAEvaluar[1].getValueNumber() == 11 || cartasAEvaluar[1].getValueNumber() == 10){
                    puntosPosibilidad = 30;
                }

                if (cartasAEvaluar[0].getSuit() == cartasAEvaluar[1].getSuit()){
                    puntosPosibilidad = 50;
                }

                if (cartasAEvaluar[0].getNumber().equals(cartasAEvaluar[1].getNumber())){
                    puntosPosibilidad = 50;
                }

                break;
            //Si el array contiene 5 cartas significa que esta en la segunda ronda
            case 5:

                for (CardImpl carta : cartasAEvaluar) {
                    if (carta.getValueNumber() == 13 || carta.getValueNumber() == 12 || carta.getValueNumber() == 11 || carta.getValueNumber() == 10) {
                        puntosPosibilidad = 10;
                    }
                }

                puntos = gestoraCarta.calculateValuePair(cartasAEvaluar);

                if (puntos > 0){
                    puntosPosibilidad = 40;
                }

                for (CardImpl carta : cartasAEvaluar) {
                    switch (carta.getSuit()){
                        case 'P':
                            colorP++;
                            break;
                        case 'T':
                            colorT++;
                            break;
                        case 'R':
                            colorR++;
                            break;
                        case 'C':
                            colorC++;
                            break;
                    }
                }

                if (colorP == 4 || colorT == 4 || colorR == 4 || colorC == 4){
                    puntosPosibilidad = 50;
                }

                unaParaEscalera = gestoraCarta.unaParaEscalera(cartasAEvaluar);

                if (unaParaEscalera){
                    puntosPosibilidad = 50;
                }

                break;
            //Si el array contiene 6 cartas significa que esta en la tercera ronda
            case 6:

                for (CardImpl carta : cartasAEvaluar) {
                    if (carta.getValueNumber() == 13 || carta.getValueNumber() == 12 || carta.getValueNumber() == 11 || carta.getValueNumber() == 10) {
                        puntosPosibilidad = 10;
                    }
                }

                puntos = gestoraCarta.calculateValuePair(cartasAEvaluar);

                if (puntos > 0){
                    puntosPosibilidad = 20;
                }

                for (CardImpl carta : cartasAEvaluar) {
                    switch (carta.getSuit()){
                        case 'P':
                            colorP++;
                            break;
                        case 'T':
                            colorT++;
                            break;
                        case 'R':
                            colorR++;
                            break;
                        case 'C':
                            colorC++;
                            break;
                    }
                }

                if (colorP == 4 || colorT == 4 || colorR == 4 || colorC == 4){
                    puntosPosibilidad = 20;
                }

                puntos = gestoraCarta.calculateValueTrio(cartasAEvaluar);

                if (puntos > 0){
                    puntosPosibilidad = 30;
                }

                puntos = gestoraCarta.calculateValueDoublePair(cartasAEvaluar);

                if (puntos > 0){
                    puntosPosibilidad = 40;
                }

                unaParaEscalera = gestoraCarta.unaParaEscalera(cartasAEvaluar);

                if (unaParaEscalera){
                    puntosPosibilidad = 50;
                }

                break;
            //En la cuarta ronda no hay incremento por posibilidad
        }
        return puntosPosibilidad;
    }


    /*
     * SIGNATURA: public JugadorImpl leerYValidarJugador();
     * COMENTARIO:
     * PRECONDICIONES: - Nada
     * ENTRADA: - Nada
     * SALIDA: - Un objeto JugadorImpl
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: -
     */

    /**
     * @return
     */

    public PlayerImpl leerYValidarJugador(){
        PlayerImpl nuevoJugador;
            String usuario = leerUsuario();
            int saldo = leerYValidarSaldoInicial();
            nuevoJugador = new PlayerImpl(usuario,saldo);
        return nuevoJugador;
    }


    /*
     * SIGNATURA:
     * COMENTARIO:
     * PRECONDICIONES: -
     * ENTRADA: -
     * SALIDA: -
     * ENTRADA/SALIDA: -
     * POSTCONDICIONES: -
     */

    /**
     * @param jugadores
     * @return
     */

    public int jugadoresConSaldo(PlayerImpl[] jugadores){
        int cantidad = 0;
        if (jugadores.length == 5){
            for (int i = 1; i < jugadores.length; i++){
                if (jugadores[i].getBalance() > 0){
                    cantidad++;
                }
            }
        }
        return cantidad;
    }

}
