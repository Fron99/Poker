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

@SuppressWarnings("unused")
public class ManagementPlayerImpl {

    /**
     * This method encrypts the string passed by parameter with the MD5 format.
     * @param password String to encrypt.
     * @return Returns the string passed by encrypted parameter.
     */

    public String encriptPassword(String password){
        String passEncrypted = null;

        try {
            byte[] bytesOfMessage = password.getBytes(StandardCharsets.UTF_8);
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] thedigest = md.digest(bytesOfMessage);
            BigInteger bigInt = new BigInteger(1,thedigest);
            passEncrypted = bigInt.toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return passEncrypted;
    }


    /*
     * SIGNATURA: public int readAndValidateInitialBalance();
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

    public int readAndValidateInitialBalance(){
        int balance;
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.println("The minimum balance is 2000€ and the maximum 10000€");
            System.out.print("Insert init balance: ");
            balance = teclado.nextInt();
        }while (balance < 2000 || balance > 10000);
        return balance;
    }

    /*
     * SIGNATURA: public String readUser();
     * COMENTARIO: Lee el usuario con el que quiere jugar el jugador
     * PRECONDICIONES: - Ninguna
     * ENTRADA: - Nada
     * SALIDA: - Un String
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un String con el usuario con el que quiere jugar el jugador
     *
     */

    /**
     * @return Return String with User
     */

    public String readUser(){
        String username;
        Scanner SC = new Scanner(System.in);
            System.out.print("Insert username with you want play: ");
            username = SC.nextLine();
        return username;
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
    

    public int readAndValidateBet(int jugador, int apuestaMinima, TableImpl mesa){
        Scanner teclado = new Scanner(System.in);
        int cantidadApuesta;
        boolean allIn = false;
        do {
            System.out.println("Dispone de "+mesa.getBalancePlayer(jugador)+" de saldo");
            System.out.println("La apuesa minima es: "+(apuestaMinima-mesa.getBetPlayer(jugador,mesa.getRound())));
            System.out.print("Introduce cuanto quiere apostar: ");
            cantidadApuesta = teclado.nextInt();
            if (cantidadApuesta < apuestaMinima-mesa.getBetPlayer(jugador,mesa.getRound())){
                if (cantidadApuesta == mesa.getBalancePlayer(jugador)){
                    allIn = true;
                }
            }
        }while (cantidadApuesta+mesa.getBetPlayer(jugador,mesa.getRound()) < apuestaMinima
                || (cantidadApuesta+mesa.getBetPlayer(jugador,mesa.getRound()) < apuestaMinima && !allIn && cantidadApuesta != 0 )
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
    

    public int calculateBetBot(int jugador, int apuestaMinima, TableImpl mesa){
        int totalApostar, valorCartas, valorFarolRonda, puntosPosibilidad;
        double porcenApostar;
        ManagementCardImpl gesCarta = new ManagementCardImpl();

        //Obtener puntos de las cartas
        valorCartas = gesCarta.evaluateCardsFromPlayer(jugador,mesa);

        //Obtener puntos de farol
        valorFarolRonda = calculatePointBluffRound(mesa.getRound());

        //Obtener puntos por posibilidad
        puntosPosibilidad = calculatePointPosibility(gesCarta.getCardsToEvaluate(jugador,mesa));

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

        return totalApostar;
    }


    /*
     * SIGNATURA: public int calculatePointBluffRound(int ronda);
     * COMENTARIO: Calcular cantidad de puntos que debe incrementar la apuesta el bot
     * PRECONDICIONES: - Nada
     * ENTRADA: - Un entero
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre la cantidad de puntos que debe incrementar en un farol el bot dependiendo de la ronda en la que se encuentre
     */
    

    private int calculatePointBluffRound(int round){
        int puntosFarol = 0,porcentaje;
        Random r = new Random();

        switch (round){
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
     * SIGNATURA: private int calculatePointPosibility(CardImpl[] cardsToEvalue)
     * COMENTARIO: Calcula la posibilidad que tienen las cartas del jugador a tener algo de valor
     * PRECONDICIONES: - El array no debe tener cartas por defecto.
     * ENTRADA: - Un array de CartaImpl
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre el valor en puntos de la posibilidad de tener cartas de valor en la partida.
     */
    

    private int calculatePointPosibility(CardImpl[] cardsToEvalue){
        int puntosPosibilidad = 0, puntos, colorP = 0, colorT = 0, colorR = 0, colorC = 0 ;
        ManagementCardImpl gestoraCarta = new ManagementCardImpl();
        boolean unaParaEscalera;

        switch (cardsToEvalue.length){
            //Si el array contiene 2 cartas significa que esta en la primera ronda
            case 2:

                for (CardImpl carta : cardsToEvalue) {
                    if (carta.getValueNumber() == 13 || carta.getValueNumber() == 12 || carta.getValueNumber() == 11 || carta.getValueNumber() == 10) {
                        puntosPosibilidad = 20;
                    }
                }

                if (cardsToEvalue[0].getValueNumber() == 13 || cardsToEvalue[0].getValueNumber() == 12 || cardsToEvalue[0].getValueNumber() == 11 || cardsToEvalue[0].getValueNumber() == 10
                    && cardsToEvalue[1].getValueNumber() == 13 || cardsToEvalue[1].getValueNumber() == 12 || cardsToEvalue[1].getValueNumber() == 11 || cardsToEvalue[1].getValueNumber() == 10){
                    puntosPosibilidad = 30;
                }

                if (cardsToEvalue[0].getSuit() == cardsToEvalue[1].getSuit()){
                    puntosPosibilidad = 50;
                }

                if (cardsToEvalue[0].getNumber().equals(cardsToEvalue[1].getNumber())){
                    puntosPosibilidad = 50;
                }

                break;
            //Si el array contiene 5 cartas significa que esta en la segunda ronda
            case 5:

                for (CardImpl carta : cardsToEvalue) {
                    if (carta.getValueNumber() == 13 || carta.getValueNumber() == 12 || carta.getValueNumber() == 11 || carta.getValueNumber() == 10) {
                        puntosPosibilidad = 10;
                    }
                }

                puntos = gestoraCarta.calculateValuePair(cardsToEvalue);

                if (puntos > 0){
                    puntosPosibilidad = 40;
                }

                for (CardImpl carta : cardsToEvalue) {
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

                unaParaEscalera = gestoraCarta.oneToStair(cardsToEvalue);

                if (unaParaEscalera){
                    puntosPosibilidad = 50;
                }

                break;
            //Si el array contiene 6 cartas significa que esta en la tercera ronda
            case 6:

                for (CardImpl carta : cardsToEvalue) {
                    if (carta.getValueNumber() == 13 || carta.getValueNumber() == 12 || carta.getValueNumber() == 11 || carta.getValueNumber() == 10) {
                        puntosPosibilidad = 10;
                    }
                }

                puntos = gestoraCarta.calculateValuePair(cardsToEvalue);

                if (puntos > 0){
                    puntosPosibilidad = 20;
                }

                for (CardImpl carta : cardsToEvalue) {
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

                puntos = gestoraCarta.calculateValueTrio(cardsToEvalue);

                if (puntos > 0){
                    puntosPosibilidad = 30;
                }

                puntos = gestoraCarta.calculateValueDoublePair(cardsToEvalue);

                if (puntos > 0){
                    puntosPosibilidad = 40;
                }

                unaParaEscalera = gestoraCarta.oneToStair(cardsToEvalue);

                if (unaParaEscalera){
                    puntosPosibilidad = 50;
                }

                break;
            //En la cuarta ronda no hay incremento por posibilidad
        }
        return puntosPosibilidad;
    }


    /*
     * SIGNATURA: public JugadorImpl readAndValidateUsername();
     * COMENTARIO:
     * PRECONDICIONES: - Nada
     * ENTRADA: - Nada
     * SALIDA: - Un objeto JugadorImpl
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve un usuario creado
     */


    public PlayerImpl readAndValidateUsername(){
        PlayerImpl nuevoJugador;
            String usuario = readUser();
            int saldo = readAndValidateInitialBalance();
            nuevoJugador = new PlayerImpl(usuario,saldo);
        return nuevoJugador;
    }

    /*
     * SIGNATURA: public JugadorImpl quantityPlayerWithValancePositive(PlayerImpl[] players);
     * COMENTARIO: Devuelve la cantidad de jugadores que tienen saldo positivo en la partida
     * PRECONDICIONES: - Nada
     * ENTRADA: - Nada
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre la cantidad de jugadores que tienen saldo positivo en la partida
     */

    public int quantityPlayerWithValancePositive(PlayerImpl[] players){
        int cantidad = 0;
        if (players.length == 5){
            for (int i = 1; i < players.length; i++){
                if (players[i].getBalance() > 0){
                    cantidad++;
                }
            }
        }
        return cantidad;
    }

}
