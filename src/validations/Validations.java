package validations;

import basicsClasses.PlayerImpl;
import basicsClasses.TableImpl;
import utils.UtilsPlayerImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Validations {

    /**
     * Read and validate if the player wants to continue playing
     * @return Return True if want continue playing, False if wan't continue
     */

    public boolean readAndValidateContinuePlaying(){
        Scanner sc = new Scanner(System.in);
        char caracter;
            do {
                System.out.print("Insert 'S' if want continue playing or 'N' if want leave of table game: ");
                caracter = Character.toUpperCase(sc.next().charAt(0));
            }while (caracter != 'S' && caracter != 'N');
        return caracter == 'S';
    }

    /**
     * Read and Validate a Username
     * @param connection Connection to check the username
     * @return Validate password
     */

    public String readAndValidateUsername(Connection connection){
        Scanner sc = new Scanner(System.in);
        boolean exist = false;
        String username;

        Statement sentence = null;
        ResultSet user = null;

        do {
            System.out.print("Insert the username: ");
            username = sc.next();
            String select = "SELECT Username " +
                            "FROM Users " +
                            "WHERE Username = '"+username+"'";

            try {
                sentence = connection.createStatement();
                user = sentence.executeQuery(select);
                if (!(exist = user.next())){
                    System.out.println("The username don`t exist.");
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            finally {
                try {
                    user.close();
                    sentence.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }while (!exist);

        return username;
    }


    /**
     * Read and Validate a Password
     * @return Return password encripted
     */

    public String readAndValidatePassword(){
        Scanner sc = new Scanner(System.in);
        UtilsPlayerImpl u = new UtilsPlayerImpl();
        String password;

        do {
            System.out.print("Insert the password: ");
            if ((password = sc.next()).length() < 8){
                System.out.println("The password must be longer than 7 characters");
            }
        }while (password.length() < 8);

        password = u.encriptPassword(password);
        return password;
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

    /**
     * Read and Validate a Player
     * @return Return a player validated
     */

    public PlayerImpl readAndValidateUsername(){
        PlayerImpl nuevoJugador;
        String usuario = readUser();
        int saldo = readAndValidateInitialBalance();
        nuevoJugador = new PlayerImpl(usuario,saldo);
        return nuevoJugador;
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

    /**
     * Read and validate bet of user
     * @param indexPlayer Index of player in table
     * @param minBet Minimum bet
     * @param table Table to get data
     * @return Return quantity of the player want bet
     */

    public int readAndValidateBet(int indexPlayer, int minBet, TableImpl table){
        Scanner sc = new Scanner(System.in);
        int quantityBet;
        boolean allIn = false;
        do {
            System.out.println("Dispose of: "+table.getBalancePlayer(indexPlayer)+" €");
            System.out.println("The minimum bet is: "+(minBet-table.getBetPlayer(indexPlayer,table.getRound())));
            System.out.print("Insert quantity do you want bet: ");
            quantityBet = sc.nextInt();
            if (quantityBet < minBet-table.getBetPlayer(indexPlayer,table.getRound())){
                if (quantityBet == table.getBalancePlayer(indexPlayer)){
                    allIn = true;
                }
            }
        }while (quantityBet+table.getBetPlayer(indexPlayer,table.getRound()) < minBet
                || (quantityBet+table.getBetPlayer(indexPlayer,table.getRound()) < minBet && !allIn && quantityBet != 0 )
                || quantityBet > table.getBalancePlayer(indexPlayer));

        return quantityBet;
    }


}
