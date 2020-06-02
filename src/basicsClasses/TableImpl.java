/*
 * PROPIEDADES BASICAS:
 *
 *  - baraja: CartaImpl[], Consultable
 *  - jugadores: JugadorImpl[], Consultable
 *  - cartasMesa: CartaImpl[], Consultable
 *  - apuestasJugadores: int[][], Consultable
 *  - turnoJugador: int
 *  - ronda: int
 *
 * PROPIEDADES DERIVADAS:
 *
 *  - apuestaTotal: int, Consultable
 *
 * PROPIEDADES COMPARTIDAS:
 *
 *  - No hay
 *
 * METODOS:
 *
 * public CartaImpl[] getBaraja();
 * private void setBaraja(CartaImpl[] baraja);
 * public CartaImpl getCartaBaraja(int indiceCarta);
 * private void setCartaBaraja(int indiceBaraja, CartaImpl carta);
 * public String getNumeroCartaBaraja(int indiceBaraja);
 * public char getPaloCartaBaraja(int indiceBaraja);
 *
 * public JugadorImpl[] getJugadores();
 * private void setJugadores(JugadorImpl[] jugadores);
 * public JugadorImpl getJugador(int posicionJugador);
 * private void setJugador(int posicionJugador, JugadorImpl jugador);
 * public String getUsuarioJugador(int posicionJugador);
 * public double getSaldoJugador(int posicionJugador);
 * private void setSaldoJugador(int posicionJugador, double saldo);
 * public CartaImpl[] getCartasJugador(int posicionJugador);
 * public void setCartasJugador(int posicionJugador, CartaImpl[] cartas);
 * public CartaImpl getCartaJugador(int posicionJugador, int posicionCarta);
 * private void setCartaJugador(int posicionJugador, int posicionCarta, CartaImpl carta);
 * public boolean getActivoJugador(int posicionJugador);
 *
 * public CartaImpl[] getCartasMesa();
 * private void setCartasMesa(CartaImpl[] cartas);
 * public CartaImpl getCartaMesa(int indiceCarta);
 * private void setCartaMesa(int indiceCarta, CartaImpl carta);
 * public String getNumeroCartaMesa(int indiceMesa);
 * public char getPaloCartaMesa(int indiceMesa);
 *
 * public int[][] getApuestasJugadores();
 * private void setApuestasJugadores(int[][] apuestas);
 * public int[] getApuestasJugador(int indiceJugador);
 * private void setApuestasJugador(int indiceJugador, int[] apuestas);
 * public int getApuestaJugador(int indiceJugador, int rondaApuesta);
 * private void setApuestaJugador(int indiceJugador, int indiceApuesta, int apuesta);
 *
 * public int getTotalApuestas();
 *
 * public int getRonda();
 *
 * METODOS AÑADIDOS:
 *
 * public void limpiarCartasMesa();
 * public void cargarBaraja();
 * public JugadorImpl obtenerJugador(int posicion);
 * public void anhadirJugador(int posicion, JugadorImpl jugador)
 * public void incrementarApuesta(int jugador, int rondaApuesta, int cantidad)
 * public int obtenerApuesta(int jugador, int rondaApuesta)
 * public void restaurarMesa()
 * private void colocarJugadoresActivos()
 * public void ingresarSaldoGanadores()
 * public void generarCartasJugadores()
 * public void generarCartaMesa()
 * public void cargarBots()
 * public void limpiarCartasMesa()
 * public void restaurarBaraja()
 * public void limpiarMesa()
 * public void generarTresCartasMesa()
 * public int[] obtenerGanadores()
 * public void ingresarDineroGanador(int ganador)
 * public void incrementarTurno()
 * public void mostrarPanelJuego()
 * public String toString()
 * public int hashCode()
 * public boolean equals(Object objeto)
 * public MesaImpl clone()
 *
 */

package basicsClasses;

import managements.ManagementCardImpl;
import managements.ManagementPlayerImpl;
import enums.Genders;
import interfaces.Table;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Random;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class TableImpl implements Table, Cloneable {

    private final CardImpl[] deckOfCards;
    private final PlayerImpl[] players;
    private CardImpl[] cardsOfTable;
    private int[][] betsPlayers;
    private final boolean[] playerActive;
    private final boolean[] playerAllInLower;
    private int playerTurn;
    private int round;

    /**
     * This constructor put the attributes with default values
     */

    public TableImpl(){
        Random random = new Random();
        this.deckOfCards = new CardImpl[52];
        for (int i = 0; i<this.deckOfCards.length; i++){
            this.deckOfCards[i] = new CardImpl();
        }
        this.players = new PlayerImpl[5];
        for (int i = 0; i<this.players.length; i++){
            this.players[i] = new PlayerImpl();
        }
        this.cardsOfTable = new CardImpl[5];
        for (int i = 0; i<this.cardsOfTable.length; i++){
            this.cardsOfTable[i] = new CardImpl();
        }
        this.betsPlayers = new int[5][4];

        this.playerActive = new boolean[5];
        Arrays.fill(this.playerActive, false);

        this.playerAllInLower = new boolean[5];
        Arrays.fill(this.playerAllInLower, false);

        this.playerTurn = random.nextInt(5);
        this.round = 0;
    }

    /**
     * This constructor put the attributes with the values passed by parameter.
     * If length of deckOfCards isn't 52, the constructor builds a array with defaults objects.
     * If length of players isn't 5, the constructor builds a array with defaults objects.
     * If length of cardsOfTable isn't 5, the constructor builds a array with defaults objects.
     * @param deckOfCards array of letters
     * @param players array of players
     * @param cardsOfTable array of letters
     */

    public TableImpl(CardImpl[] deckOfCards, PlayerImpl[] players, CardImpl[] cardsOfTable){
        Random random = new Random();

        this.deckOfCards = new CardImpl[52];
        if (deckOfCards.length == 52){
            System.arraycopy(deckOfCards,0,this.deckOfCards,0,deckOfCards.length);
        }else{
            for (int i = 0; i<this.deckOfCards.length; i++){
                this.deckOfCards[i] = new CardImpl();
            }
        }

        this.players = new PlayerImpl[5];
        if (players.length == 5){
            System.arraycopy(players,0,this.players,0,players.length);
        }else{
            for (int i = 0; i<this.players.length; i++){
                this.players[i] = new PlayerImpl();
            }
        }

        this.cardsOfTable = new CardImpl[5];
        if (cardsOfTable.length == 5){
            System.arraycopy(cardsOfTable,0,this.cardsOfTable,0,cardsOfTable.length);
        }else{
            for (int i = 0; i<this.cardsOfTable.length; i++){
                this.cardsOfTable[i] = new CardImpl();
            }
        }

        this.betsPlayers = new int[5][4];

        this.playerActive = new boolean[5];
        Arrays.fill(this.playerActive, false);

        this.playerAllInLower = new boolean[5];
        Arrays.fill(this.playerAllInLower, false);

        this.playerTurn = random.nextInt(5);
        this.round = 0;
    }

    /**
     * This constructor put the attributes with the values passed by parameter.
     * If length of deskOfCards isn't 52, the constructor builds a array with defaults objects.
     * If length of players isn't 5, the constructor builds a array with defaults objects.
     * If length of cardsOfTable isn't 5, the constructor builds a array with defaults objects.
     * If length of betsPlayers isn't 5 times 5, the constructor builds a array with defaults values.
     * If length of playerActive isn't 5, the constructor builds a array with false.
     * If length of playerAllInLower isn't 5, the constructor builds a array with false.
     * @param deskOfCards array of letters
     * @param players array of players
     * @param cardsOfTable array of letters
     * @param betsPlayers array of int
     * @param playerActive array of boolean
     * @param playerAllInLower array of boolean
     */


    public TableImpl(CardImpl[] deskOfCards, PlayerImpl[] players, CardImpl[] cardsOfTable, int[][] betsPlayers, boolean[] playerActive, boolean[] playerAllInLower){
        Random random = new Random();
        this.deckOfCards = new CardImpl[52];
        if (deskOfCards.length == 52){
            System.arraycopy(deskOfCards,0,this.deckOfCards,0,deskOfCards.length);
        }else{
            for (int i = 0; i<this.deckOfCards.length; i++){
                this.deckOfCards[i] = new CardImpl();
            }
        }

        this.players = new PlayerImpl[5];
        if (players.length == 5){
            System.arraycopy(players,0,this.players,0,players.length);
        }else{
            for (int i = 0; i<this.players.length; i++){
                this.players[i] = new PlayerImpl();
            }
        }

        this.cardsOfTable = new CardImpl[5];
        if (cardsOfTable.length == 5){
            System.arraycopy(cardsOfTable,0,this.cardsOfTable,0,cardsOfTable.length);
        }else{
            for (int i = 0; i<this.cardsOfTable.length; i++){
                this.cardsOfTable[i] = new CardImpl();
            }
        }

        this.betsPlayers = new int[5][4];
        if (betsPlayers.length == 5 && betsPlayers[0].length == 4){
            for (int i = 0;i < betsPlayers[0].length;i++){
                System.arraycopy(betsPlayers[i],0,this.betsPlayers[i],0,betsPlayers[0].length);
            }
        }

        this.playerActive = new boolean[5];
        if (playerActive.length == 5){
            System.arraycopy(playerActive,0,this.playerActive,0,playerActive.length);
        }else{
            Arrays.fill(this.playerActive, false);
        }

        this.playerAllInLower = new boolean[5];
        if (playerAllInLower.length == 5){
            System.arraycopy(playerAllInLower,0,this.playerAllInLower,0,playerAllInLower.length);
        }else{
            Arrays.fill(this.playerAllInLower, false);
        }

        this.playerTurn = random.nextInt(5);
        this.round = 0;
    }

    /**
     * This constructor put the attributes with the values of the other object passed by parameter
     * @param other another table of we want to copy their values
     */

    public TableImpl(TableImpl other){
        this.deckOfCards = new CardImpl[52];
        System.arraycopy(other.deckOfCards,0,this.deckOfCards,0,other.deckOfCards.length);

        this.players = new PlayerImpl[5];
        System.arraycopy(other.players,0,this.players,0,other.players.length);

        this.cardsOfTable = new CardImpl[5];
        System.arraycopy(other.cardsOfTable,0,this.cardsOfTable,0,other.cardsOfTable.length);

        this.betsPlayers = new int[5][4];
        for (int i = 0; i< betsPlayers.length; i++){
            System.arraycopy(other.betsPlayers[i],0,this.betsPlayers[i],0, betsPlayers.length);
        }

        this.playerActive = new boolean[5];
        System.arraycopy(other.playerActive,0,this.playerActive,0,other.playerActive.length);

        this.playerAllInLower = new boolean[5];
        System.arraycopy(other.playerAllInLower,0,this.playerAllInLower,0,other.playerAllInLower.length);

        this.playerTurn = other.playerTurn;
        this.round = other.round;

    }

    /**
     * Return array of attribute "deckOfCards"
     * @return CartaImpl[] array of attribute "deckOfCards"
     */

    public CardImpl[] getDeckOfCards(){
        CardImpl[] baraja = new CardImpl[this.deckOfCards.length];
        System.arraycopy(this.deckOfCards,0,baraja,0,this.deckOfCards.length);
        return baraja;
    }

    /**
     * Set array passed by parameter in attribute "deckOfCards"
     * @param deckOfCards new value of attribute "deckOfCards"
     */

    private void setDeckOfCards(CardImpl[] deckOfCards){
        for (int i = 0; i< deckOfCards.length; i++){
            this.deckOfCards[i] = deckOfCards[i].clone();
        }
    }

    /**
     * Return the card of the index in the array "deckOfCards". The allowed range of the index is 0 to 51.
     * @param indexDeskOfCards index of the card of you will want return
     * @return CartaImpl card that you want to get if the value of index passed by parameter is allowed.
     *                   If the value of index not allowed, return a card with value 0 and 0
     */

    public CardImpl getCardOfDeskOfCards(int indexDeskOfCards){
        return (indexDeskOfCards >= 0 && indexDeskOfCards <= 51) ? this.deckOfCards[indexDeskOfCards].clone() : new CardImpl('0',"0");
    }

    /**
     * Set value of the card that index with the card passed by parameter. The allowed range of the index is 0 to 51.
     * @param deskOfCards new value of attribute "deskOfCards"
     * @param indexDeskOfCards index of the card that will be changed the value
     * @return res Return true if the value of the array index card passed by parameter has been changed.
     *             Return false if the value of the array index card passed by parameter hasn't been changed.
     */

    private boolean setCardOfDeskOfCards(CardImpl deskOfCards, int indexDeskOfCards){
        boolean res = false;
        if (indexDeskOfCards >= 0 && indexDeskOfCards <= 51){
            this.deckOfCards[indexDeskOfCards] = deskOfCards;
            res = true;
        }
        return res;
    }

    /**
     * Get the number of the card of the desk. The allowed range of the index is 0 to 51.
     * @param indexOfDeskOfCards index of the card that will want get number
     * @return Return a String with the value of number of the card. If the index not between of range allowed return 0.
     */

    public String getNumberOfCardOfDesk(int indexOfDeskOfCards){
        return (indexOfDeskOfCards >= 0 && indexOfDeskOfCards <= 51) ? this.deckOfCards[indexOfDeskOfCards].getNumber() : "0";
    }

    /**
     * Get the stick of the card of the desk. The allowed range of the index is 0 to 51.
     * @param indexOfDeskOfCards index of the card that will want get stick
     * @return Return a char with the value of stick of the card. If the index not between of range allowed return 0.
     */

    public char getSuitOfCardOfDesk(int indexOfDeskOfCards){
        return (indexOfDeskOfCards >= 0 && indexOfDeskOfCards <= 51) ? this.deckOfCards[indexOfDeskOfCards].getSuit() : '0';
    }

    /**
     * Return array of attribute "players"
     * @return JugadorImpl[] array of attribute "players"
     */

    public PlayerImpl[] getPlayers(){
        PlayerImpl[] players = new PlayerImpl[this.players.length];
        System.arraycopy(this.players,0,players,0,this.players.length);
        return players;
    }

    /**
     * Set array passed by parameter in attribute "players"
     * @param players new value of attribute "players"
     */

    private void setPlayers(PlayerImpl[] players){
        for (int i = 0; i< players.length; i++){
            this.players[i] = players[i].clone();
        }
    }

    /**
     * This method return the player of the position passed by parameter. The allowed range of the index is 0 to 4.
     * @param index position of the player you want to get
     * @return PlayerImpl player yo want to get. If the index not between of range allowed return a player with value "IndexOvertakeRange" in "username".
     */

    public PlayerImpl getPlayer(int index){
        return (index >= 0 && index <= 4) ? this.players[index].clone() : new PlayerImpl("IndexOvertakeRange",0);
    }

    /**
     * This method adds the player passed by parameter to the array of players. The allowed range of the index is 0 to 4.
     * @param indexPlayer position where the player wants to add
     * @param player player you want to add
     * @return Return true if the value of the array index player passed by parameter has been changed.
     *         Return false if the value of the array index player passed by parameter hasn't been changed.
     */

    public boolean setPlayer(int indexPlayer, PlayerImpl player){
        boolean res = false;
        if (indexPlayer >= 0 && indexPlayer <= 4){
            this.players[indexPlayer] = player.clone();
            res = true;
        }
        return res;
    }

    /**
     * Get the "username" of the player. The allowed range of the indexPlayer is 0 to 4.
     * @param indexPlayer index of the player that will want get "username"
     * @return Return a String with the value of "username" of the player. If the index not between of range allowed return 0.
     */

    public String getUsernamePlayer(int indexPlayer){
        return (indexPlayer >= 0 && indexPlayer <= 4) ? this.players[indexPlayer].getUsername() : "0";
    }

    /**
     * Set the "username" of the player. The allowed range of the indexPlayer is 0 to 4.
     * @param indexPlayer index of the player that will want change "username"
     * @param newUsername String with new Username
     * @return Return true if the value of the username of player has been changed.
     *         Return false if the value of the username of player hasn't been changed.
     */

    public boolean setUsernamePlayer(int indexPlayer, String newUsername){
        boolean changed = false;
        if (indexPlayer >= 0 && indexPlayer <= 4){
            this.players[indexPlayer].setUsername(newUsername);
            changed = true;
        }
        return changed;
    }

    /**
     * Get the "password" of the player. The allowed range of the indexPlayer is 0 to 4.
     * @param indexPlayer index of the player that will want get "password"
     * @return Return a String with the value of "password" of the player. If the index not between of range allowed return 0.
     */

    public String getPasswordPlayer(int indexPlayer){
        return (indexPlayer >= 0 && indexPlayer <= 4) ? this.players[indexPlayer].getPassword() : "0";
    }

    /**
     * This method change the password passed by parameter in the player of position passed by parameter(index). The allowed range of the index is 0 to 4.
     * @param indexPlayer Position of the player that change password
     * @param newPassword String with new Password
     * @return Return true if password was changed to the player.
     *         Return false if password wasn't changed to the player.
     */

    public boolean setPasswordPlayer(int indexPlayer, String newPassword){
        boolean res = false;
        if (indexPlayer >= 0 && indexPlayer <= 4){
            this.players[indexPlayer].setPassword(newPassword);
            res = true;
        }
        return res;
    }

    /**
     * Get the "name" of the player. The allowed range of the indexPlayer is 0 to 4.
     * @param indexPlayer index of the player that will want get "name"
     * @return Return a String with the value of "name" of the player. If the index not between of range allowed return 0.
     */

    public String getNamePlayer(int indexPlayer){
        return (indexPlayer >= 0 && indexPlayer <= 4) ? this.players[indexPlayer].getName() : "0";
    }

    /**
     * This method change the name passed by parameter in the player of position passed by parameter(index). The allowed range of the index is 0 to 4.
     * @param indexPlayer Position of the player that wants to change name
     * @param newName String with new name
     * @return Return true if name was changed to the player.
     *         Return false if name wasn't changed to the player.
     */

    public boolean setNamePlayer(int indexPlayer, String newName){
        boolean res = false;
        if (indexPlayer >= 0 && indexPlayer <= 4){
            this.players[indexPlayer].setName(newName);
            res = true;
        }
        return res;
    }

    /**
     * Get the "surname" of the player. The allowed range of the indexPlayer is 0 to 4.
     * @param indexPlayer index of the player that will want get "surname"
     * @return Return a String with the value of "surname" of the player. If the index not between of range allowed return 0.
     */

    public String getSurnamePlayer(int indexPlayer){
        return (indexPlayer >= 0 && indexPlayer <= 4) ? this.players[indexPlayer].getSurname() : "0";
    }

    /**
     * This method change the surname passed by parameter in the player of position passed by parameter(index). The allowed range of the index is 0 to 4.
     * @param indexPlayer Position of the player that wants to change surname
     * @param newSurname String with new surname
     * @return Return true if surname was changed to the player.
     *         Return false if surname wasn't changed to the player.
     */

    public boolean setSurnamePlayer(int indexPlayer, String newSurname){
        boolean res = false;
        if (indexPlayer >= 0 && indexPlayer <= 4){
            this.players[indexPlayer].setSurname(newSurname);
            res = true;
        }
        return res;
    }

    /**
     * Get the "gender" of the player. The allowed range of the indexPlayer is 0 to 4.
     * @param indexPlayer index of the player that will want get "gender"
     * @return Return a Genders with the value of "gender" of the player. If the index not between of range allowed return 0.
     */

    public Genders getGenderPlayer(int indexPlayer){
        return (indexPlayer >= 0 && indexPlayer <= 4) ? this.players[indexPlayer].getGender() : Genders.Other;
    }

    /**
     * This method change the gender passed by parameter in the player of position passed by parameter(index). The allowed range of the index is 0 to 4.
     * @param indexPlayer Position of the player that wants to change gender
     * @param newGender Genders with new gender
     * @return Return true if gender was changed to the player.
     *         Return false if gender wasn't changed to the player.
     */

    public boolean setGenderPlayer(int indexPlayer, Genders newGender){
        boolean res = false;
        if (indexPlayer >= 0 && indexPlayer <= 4){
            this.players[indexPlayer].setGender(newGender);
            res = true;
        }
        return res;
    }

    /**
     * Get the "email" of the player. The allowed range of the indexPlayer is 0 to 4.
     * @param indexPlayer index of the player that will want get "email"
     * @return Return a String with the value of "email" of the player. If the index not between of range allowed return 0.
     */

    public String getEmailPlayer(int indexPlayer){
        return (indexPlayer >= 0 && indexPlayer <= 4) ? this.players[indexPlayer].getEmail() : "0";
    }

    /**
     * This method change the email passed by parameter in the player of position passed by parameter(index). The allowed range of the index is 0 to 4.
     * @param indexPlayer Position of the player that wants to change email
     * @param newEmail String with new email
     * @return Return true if email was changed to the player.
     *         Return false if email wasn't changed to the player.
     */

    public boolean setEmailPlayer(int indexPlayer, String newEmail){
        boolean res = false;
        if (indexPlayer >= 0 && indexPlayer <= 4){
            this.players[indexPlayer].setEmail(newEmail);
            res = true;
        }
        return res;
    }

    /**
     * Get the "IBAN" of the player. The allowed range of the indexPlayer is 0 to 4.
     * @param indexPlayer index of the player that will want get "IBAN"
     * @return Return a String with the value of "IBAN" of the player. If the index not between of range allowed return 0.
     */

    public String getIBANPlayer(int indexPlayer){
        return (indexPlayer >= 0 && indexPlayer <= 4) ? this.players[indexPlayer].getIBAN() : "0";
    }

    /**
     * This method change the IBAN passed by parameter in the player of position passed by parameter(index). The allowed range of the index is 0 to 4.
     * @param indexPlayer Position of the player that wants to change IBAN
     * @param newIBAN String with new IBAN
     * @return Return true if IBAN was changed to the player.
     *         Return false if IBAN wasn't changed to the player.
     */

    public boolean setIBANPlayer(int indexPlayer, String newIBAN){
        boolean res = false;
        if (indexPlayer >= 0 && indexPlayer <= 4){
            this.players[indexPlayer].setIBAN(newIBAN);
            res = true;
        }
        return res;
    }

    /**
     * Get the "birthday" of the player. The allowed range of the indexPlayer is 0 to 4.
     * @param indexPlayer index of the player that will want get "birthday"
     * @return Return a GregorianCalendar with the value of "birthday" of the player. If the index not between of range allowed return 0.
     */

    public GregorianCalendar getBirthdayPlayer(int indexPlayer){
        return (indexPlayer >= 0 && indexPlayer <= 4) ? this.players[indexPlayer].getBirthday() : null;
    }

    /**
     * Get the "balance" of the player. The allowed range of the index is 0 to 4.
     * @param indexPlayer index of the player that will want get "balance"
     * @return Return a int with the value of "balance" of the player. If the index not between of range allowed return 0.
     */

    public int getBalancePlayer(int indexPlayer){
        return (indexPlayer >= 0 && indexPlayer <= 4) ? this.players[indexPlayer].getBalance() : -1;
    }

    /**
     * This method change the balance passed by parameter in the player of position passed by parameter(index). The allowed range of the index is 0 to 4.
     * @param indexPlayer Position of the player that wants to add money
     * @param balance Money to add to the player
     * @return Return true if money was changed to the player.
     *         Return false if money wasn't changed to the player.
     */

    public boolean setBalancePlayer(int indexPlayer, int balance){
        boolean res = false;
        if (indexPlayer >= 0 && indexPlayer <= 4){
            this.players[indexPlayer].setBalance(balance);
            res = true;
        }
        return res;
    }

    /**
     * Get all card of the player passed by parameter. The allowed range of the index is 0 to 4.
     * @param indexPlayer Position of the player that wants get cards
     * @return Return all cards of the player if index passed by parameter is allowed.
     *         Return null if index passed by parameter isn't allowed.
     */

    public CardImpl[] setCardsPlayer(int indexPlayer){
        CardImpl[] cardsPlayer = null;
        if (indexPlayer >= 0 && indexPlayer <= 4){
            cardsPlayer = new CardImpl[2];
            System.arraycopy(this.players[indexPlayer].getCards(),0,cardsPlayer,0,this.players[indexPlayer].getCards().length);
        }
        return cardsPlayer;
    }

    /**
     * Add cards passed by parameter to the player. The allowed range of the index is 0 to 4.
     * @param indexPlayer int position of player where do you want add the cards passed by parameter
     * @param cards CartaImpl[] with the cards you want to add to the player
     * @return Return true if the cards was added to the player.
     *         Return false if the cards wasn't added to the player.
     */

    public boolean setCardsPlayer(int indexPlayer, CardImpl[] cards){
        boolean res = false;
        if (indexPlayer >= 0 && indexPlayer <= 4){
            this.players[indexPlayer].setCards(cards.clone());
            res = true;
        }
        return res;
    }

    /**
     * @param indexPlayer index of player that you want get card. The allowed range of the index of player is 0 to 4. The allowed range of the index of card is 0 to 1.
     * @param indexCard index of card you want get
     * @return card that you want to get if the value of index passed by parameter is allowed.
     *         If the value of index not allowed, return a card with value 0 and 0
     */

    public CardImpl getCardPlayer(int indexPlayer, int indexCard){
        return (indexPlayer >= 0 && indexPlayer <= 4) ? (indexCard == 0 || indexCard == 1) ? this.setCardsPlayer(indexPlayer)[indexCard] : new CardImpl('0',"0") : new CardImpl('0',"0");
    }

    /**
     * Get the stick of the card of the player. The allowed range of the player of the index is 0 to 4. The allowed range of the card of the index is 0 to 1.
     * @param indexPlayer index of the player that will want get stick from one card
     * @param indexCard index of the card that will want get stick
     * @return Return a char with the value of stick of the card. If the index not between of range allowed return 0.
     */

    public char getSuitCardPlayer(int indexPlayer, int indexCard){
        return (indexPlayer >= 0 && indexPlayer <= 4) ? (indexCard == 0 || indexCard == 1) ? this.getCardPlayer(indexPlayer,indexCard).getSuit() : '0' : '0';
    }

    /**
     * Get the number of the card of the player. The allowed range of the player of the index is 0 to 4. The allowed range of the card of the index is 0 to 1.
     * @param indexPlayer index of the player that will want get stick from one card
     * @param indexCard index of the card that will want get number
     * @return Return a String with the value of number of the card. If the index not between of range allowed return 0.
     */

    public String getNumberCardPlayer(int indexPlayer, int indexCard){
        return (indexPlayer >= 0 && indexPlayer <= 4) ? (indexCard == 0 || indexCard == 1) ? this.getCardPlayer(indexPlayer,indexCard).getNumber() : "0" : "0";
    }

    /**
     * This method added the card passed by parameter to the cards of the player. The allowed range of the player of the index is 0 to 4. The allowed range of the card of the index is 0 to 1.
     * @param indexPlayer index of the player to which you want to add the card passed by parameter
     * @param indexCard index of the card where it will be added
     * @param card card to add
     * @return Return true if the card was added to the player.
     *         Return false if the card wasn't added to the player.
     */

    private boolean setCardPlayer(int indexPlayer, int indexCard, CardImpl card){
        boolean res = false;
        if ((indexPlayer >= 0 && indexPlayer <= 4) && (indexCard == 0 || indexCard == 1)){
            this.players[indexPlayer].setCard(indexCard, card);
            res = true;
        }
        return res;
    }

    /**
     * Obtain if player is active or not. The allowed range of the player of the index is 0 to 4.
     * @param indexPlayer index of the player you want to obtain if it is active or not
     * @return Return 1 is player is active.
     *         Return 0 is player isn't active.
     *         Return -1 if the index passed by parameter not between of range allowed.
     */

    public int getActivePlayer(int indexPlayer){
        return (indexPlayer >= 0 && indexPlayer <= 4) ? (this.playerActive[indexPlayer]) ? 1 : 0 : -1;
    }

    /**
     * This method return array of attribute "cardsOfTable"
     * @return CardImpl[] array of attribute "cardsOfTable"
     */

    public CardImpl[] getCardsOfTable(){
        CardImpl[] cards = new CardImpl[this.cardsOfTable.length];
        System.arraycopy(this.cardsOfTable,0,cards,0,this.cardsOfTable.length);
        return cards;
    }

    /**
     * Set array passed by parameter in attribute "cards"
     * @param cards new value of attribute "cards"
     */

    public void setCardsOfTable(CardImpl[] cards){
        this.cardsOfTable = cards.clone();
    }

    /**
     * This method return the card select by the index passed by parameter from atribute "cartasMesa". The allowed range of the index of cards is 0 to 4.
     * @param indexCard index of the card that you want obtain
     * @return Return card select by the index passed by parameter from atribute "cartasMesa"
     *         If the value of index not allowed, return a card with value 0 and 0
     *
     */

    public CardImpl getCardTable(int indexCard){
        return (indexCard >= 0 && indexCard <= 4) ? this.cardsOfTable[indexCard].clone() : new CardImpl('0',"0");
    }

    /**
     * This method add the carte passed by parameter to array of letters of table in the position passed by parameter. The allowed range of the cards of the index is 0 to 4.
     * @param indexCard position where the card is added
     * @param card carte to add
     * @return Return true if the card was added to the cards of table.
     *         Return false if the card wasn't added to the cards of table.
     */

    private boolean setCardTable(int indexCard, CardImpl card){
        boolean res = false;
        if (indexCard >= 0 && indexCard <= 4){
            this.cardsOfTable[indexCard] = card;
            res = true;
        }
        return res;
    }

    /**
     * Get the number of the card of the table. The allowed range of the cards of the index is 0 to 4.
     * @param indexCard index of the card that will want get number
     * @return Return a String with the value of number of the card. If the index not between of range allowed return 0.
     */

    public String getNumberCardTable(int indexCard){
        return (indexCard >= 0 && indexCard <= 4) ? this.getCardTable(indexCard).getNumber() : "0";
    }

    /**
     * Get the stick of the card of the table. The allowed range of the cards of the index is 0 to 4.
     * @param indexCard index of the card that will want get stick
     * @return Return a char with the value of stick of the card. If the index not between of range allowed return 0.
     */

    public char getSuitCardTable(int indexCard){
        return (indexCard >= 0 && indexCard <= 4) ? this.getCardTable(indexCard).getSuit() : '0';
    }

    /**
     * This method return array of attribute "betsPlayers"
     * @return int[][] array of attribute "betsPlayers"
     */

    public int[][] getBetsPlayers(){
        int[][] apuestas = new int[5][4];
        for (int i = 0; i<this.betsPlayers.length; i++){
            System.arraycopy(this.betsPlayers[i],0,apuestas[i],0,this.betsPlayers[i].length);
        }
        return apuestas;
    }

    /**
     * Set array passed by parameter in attribute "betsPlayers"
     * @param bets new value of attribute "bets"
     * @return Return true if the bets were added.
     *         Return false if the bets weren't added.
     */

    private boolean setPlayersBets(int[][] bets){
        boolean res = false;
        if (bets.length == 5 && bets[0].length == 4){
            this.betsPlayers = bets.clone();
            res = true;
        }
        return res;
    }

    /**
     * Get all bets from a player for the index passed by parameter. The allowed range of the player of the index is 0 to 4.
     * @param indexPlayer index of the player that will want get stick
     * @return Return a int[] with all bets of the player passed by parameter.
     *         Return null if the index of player passed by parameter isn't allowed.
     */

    public int[] getBetsPlayer(int indexPlayer){
        int[] playerBets = null;
        if (indexPlayer >= 0 && indexPlayer <= 4){
            playerBets = new int[this.betsPlayers[indexPlayer].length];
            System.arraycopy(this.betsPlayers[indexPlayer],0,playerBets,0,this.betsPlayers[indexPlayer].length);
        }
        return playerBets;
    }

    /**
     * Assign the bets passed by parameter to the player of the index passed by parameter. The allowed range of the player of the index is 0 to 4.
     * @param indexPlayer index of the player that will want assign bets.
     * @param bets Bets that will want assign to player.
     * @return Return true if the bets was added to the player.
     *         Return false if the bets wasn't added to the player.
     */

    private boolean setBetsPlayer(int indexPlayer, int[] bets){
        boolean res = false;
        if (indexPlayer >= 0 && indexPlayer <= 4){
            this.betsPlayers[indexPlayer] = bets;
            res = true;
        }
        return res;
    }

    /**
     * Get user bet in an exact round. The allowed range of the player of the index is 0 to 4. The allowed range of the round of the index is 0 to 4.
     * @param indexPlayer int index of the user you want get bet
     * @param roundBet int index of the round you want get bet
     * @return Return int bet of the user in the round
     *
     */

    public int getBetPlayer(int indexPlayer, int roundBet){
        return (indexPlayer >= 0 && indexPlayer <= 4) ? (roundBet >= 0 && roundBet <= 4) ? this.betsPlayers[indexPlayer][roundBet] : -1 : -1;
    }

    /**
     * Assign a round set of the index passed by parameter to the player of the index passed by parameter. The allowed range of the player of the index is 0 to 4. The allowed range of the round of the index is 0 to 4.
     * @param indexPlayer int index of the user you want get bet
     * @param roundBet int index of the round you want get bet
     * @param bet int bet to assign to the player
     */

    private boolean setBetPlayer(int indexPlayer, int roundBet, int bet){
        boolean res = false;
        if ((indexPlayer >= 0 && indexPlayer <= 4) && (roundBet >= 0 && roundBet <= 4)){
            this.betsPlayers[indexPlayer][roundBet] = bet;
            res = true;
        }
        return res;
    }

    /**
     * Return value of sum all bets
     * @return int value of sum all bets
     */

    public int getTotalAllBets(){
        int total = 0;
        for (int[] jugador:this.betsPlayers) {
            for (int apuesta:jugador) {
                total += apuesta;
            }
        }
        return total;
    }

    /**
     * Return value of the round
     * @return int value of the round
     */

    public int getRound(){
        return this.round;
    }

    /**
     * Removes all changes made to the "deskOfCards", "activePlayer", "cardsPlayer", "cardsTable", "bets" and "round" attributes and defaults to starting a new play.
     */

    public void restoreTable(){
        restoreDeskOfCards();
        setPlayersActive();
        generateCardsPlayers();
        restoreCardsTable();
        restoreBets();
        this.round = 0;
    }

    /*
     * SIGNATURA: public void restoreCardsTable()
     * COMENTARIO: Coloca todas las cartas de la mesa con palo D y numero D
     * PRECONDICIONES: - Nada
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Un array de CartaImpl
     * POSTCONDICIONES: Modifica el atributo cartas mesa colocando todas las cartas de la mesa por defecto (con palo D y numero D)
     */

    /**
     * Set all the table cards by default
     */

    public void restoreCardsTable(){
        for (int i = 0; i<this.cardsOfTable.length; i++){
            this.cardsOfTable[i] = new CardImpl();
        }
    }

    /*
     * SIGNATURA: public void restoreDeskOfCards()
     * COMENTARIO: Restaura todas las cartas de la baraja del atributo baraja
     * PRECONDICIONES: - Nada
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: Modifica el atributo baraja restaurando todas sus cartas.
     */

    /**
     * Restores all cards in the deck of the deck attribute
     */

    public void restoreDeskOfCards(){
        char[] suits = new char[]{'P','C','R','T'};
        String[] numbers = new String[]{"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        int counter = 0;
        for (char suit: suits){
            for (String number : numbers) {
                this.deckOfCards[counter] = new CardImpl(suit, number);
                counter++;
            }
        }
    }

    /*
     * SIGNATURA: public void restoreBets()
     * COMENTARIO: Coloca en defecto todas las cartas del array pasado por parametro y coloca todas las apuestas de los jugadores a 0
     * PRECONDICIONES: - Nada
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: Modifica las cartas de la mesa colocandolas por defecto y coloca todas las apuestas a 0
     */

    /**
     * Change the cards of the table to default and set bets to 0
     */

    public void restoreBets() {
        for (int i = 0; i < this.betsPlayers.length; i++) {
            for (int j = 0; j < this.betsPlayers[0].length; j++) {
                this.betsPlayers[i][j] = 0;
            }
        }
    }

    /*
     * SIGNATURA: public void colocarJugadoresActivos()
     * COMENTARIO: Metodo para colocar todos los jugadores de la mesa activos
     * PRECONDICIONES: - Nada
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Coloca todos los jugadores del atributo jugadores de la mesa en activo.
     */

    /**
     * This method set active all players
     */

    private void setPlayersActive(){
        for (int i = 0; i < playerActive.length; i++){
            this.playerActive[i] = true;
        }
    }

    /*
     * SIGNATURA: public void generateBots();
     * COMENTARIO: Genera jugadores con nombres aleatorios y los añade en el atributo jugadores.
     * PRECONDICIONES: - El array debe ser de JugadorImpl
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Array de JugadorImpl
     * POSTCONDICIONES: - Modifica el atributo jugadores anhadiendo jugadores con nombres aleatorios.
     *
     */

    /**
     * Generate players with random names and add them in the players attribute.
     */

    public void generateBots(){

        Random random = new Random();
        String[] aleatoryName = {"Kun","Wang","YanYan","Zhao","Yun","Sasha","Volodia","Hedeon","Grigory"};
        for (int i = 1; i< players.length; i++){
            this.players[i] = new PlayerImpl(aleatoryName[random.nextInt(8)], players[0].getBalance());
        }

    }

    /*
     * SIGNATURA: public void generateThreeCardsToTable();
     * COMENTARIO: Saca 3 cartas de la baraja y las coloca en el array de las cartas de la mesa
     * PRECONDICIONES: - Nada
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: Modifica el array de las barajas, colocando 3 los huecos de las 3 cartas sacadas como cartas por defecto y coloca las cartas sacadas
     *                  en el array de las cartas de la mesa.
     */

    /**
     * Takes 3 cards from the deck of the cards and places them in the array of cards on the table
     */

    public void generateThreeCardsToTable() {

        Random r = new Random();
        int indexCard;

        for (int i = 0; i < 3; i++) {
            do {
                indexCard = r.nextInt(52);
            } while (this.deckOfCards[indexCard].getSuit() == 'D');
            this.cardsOfTable[i] = this.deckOfCards[indexCard];
            this.deckOfCards[indexCard] = new CardImpl();
        }

    }

    /*
     * SIGNATURA: public void generateCardsPlayers();
     * COMENTARIO: Saca dos cartas de la baraja para cada jugador y se las asigna a cada jugador
     * PRECONDICIONES: - Nada
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Modifica el array de la baraja colocando por defecto las cartas sacadas y asigna las cartas a los jugadores de la mesa
     */

    /**
     * Draw 2 cards for each player and assign them to them placing by default in the deck the drawn
     */

    public void generateCardsPlayers() {

        Random r = new Random();
        int indexCard;

        for (int i = 0; i<this.players.length; i++){
            for (int j = 0; j<2; j++){
                do {
                    indexCard = r.nextInt(52);
                    if (deckOfCards[indexCard].getSuit() != 'D') {    //Comprueba si la carta seleccionada de la baraja no ha salido ya (Que es cuando esta por defecto)
                        //En el caso de que no haya salido se le asigna al jugador y se coloca por defecto en la baraja
                        if (!(this.setCardPlayer(i, j, deckOfCards[indexCard]))) {  //Anhade la carta y compruba si se añadio correctamente
                            System.out.println("No se ha podido anhadir la carta");
                        }
                    }
                } while (deckOfCards[indexCard].getSuit() == 'D');
                deckOfCards[indexCard] = new CardImpl();
            }
        }

    }

    /*
     * SIGNATURA: public void generateCardTable();
     * COMENTARIO: Saca 1 cartas de la baraja y las coloca en el array de cartas de la mesa del objeto
     * PRECONDICIONES: - Debe haber como minimo 1 hueco libre en las cartas de la mesa.
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Coloca una carta sacada aleatoriamente de la baraja en la siguiente posicion libre de las cartas de la mesa.
     *                    La posicion de la carta sacada de la baraja pasara a ser una carta por defecto.
     *                    Si no se cumple la precondicion del hueco libre, no se sacara ninguna carta.
     */

    /**
     * Draw 1 cards of deck of cards and put this in array of cards from the object
     */

    public void generateCardTable() {

        Random r = new Random();
        int indexCard, indexGenerateCard = -1;

        //Calcula cual es la siguiente carta sin levantar y guarda el indice
        for (int i = 0; i < this.cardsOfTable.length && indexGenerateCard == -1; i++) {
            if (this.cardsOfTable[i].getSuit() == 'D') {
                indexGenerateCard = i;
            }
        }

        if (indexGenerateCard != -1){
            //Guarda la carta que se ha sacado de la baraja en las cartas de la mesa
            do {
                indexCard = r.nextInt(52);
                if (this.deckOfCards[indexCard].getSuit() != 'D') {
                    this.cardsOfTable[indexGenerateCard] = this.deckOfCards[indexCard];
                }
            } while (this.deckOfCards[indexCard].getSuit() == 'D');
            this.deckOfCards[indexCard] = new CardImpl();
        }
    }

    /*
     * SIGNATURA: public void depositBalanceWinnerAndShowWinner();
     * COMENTARIO: Ingresa el saldo al ganador/ganadores de la partida
     * PRECONDICIONES: - Nada
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Modifica el saldo de los jugadores que hayan ganado incrementando su saldo en la cantidad correspondiente
     */

    /*
     * INICIO
     *
     * repetir
     *
     *  para(i = 0; mientras i < cantidad jugadores; incrementar i)
     *      si(jugador != indice guardado)
     *          //obtenerJugadorMayorPuntuacion
     *      finSi
     *  finPara
     *
     *  si(allInMenor del jugador es false)
     *      aumentarSaldoJugador //Con toodo el saldo de la mesa
     *  sino
     *      aumentarSaldoJugador    //Con la parte proporcional que tiene que ganar
     *      guardarIndiceJugador
     *  finSi
     *
     * mientras(queden jugadores ganadores)
     *
     * FIN
     */

    /**
     * Modify the balance of the players who have won by increasing their balance by the corresponding amount
     */

    //TODO Comprobar con todos los jugadores con 0$ y allInMenor


    public void depositBalanceWinnerAndShowWinner(){
        ManagementCardImpl gestoraCarta = new ManagementCardImpl();
        int indiceGanador = -1, totalGanancias = 0, puntosAnteriorGanador = 99999, puntosAnteriorJugador = 0, puntosJugadorCalculados;

        do{
            //Obtener ganador
            for (int i = 0; i< this.players.length; i++){
                if (this.playerActive[i]) {
                    puntosJugadorCalculados = gestoraCarta.evaluarCartas(i, this);
                    //Se utiliza puntosAnteriorGanador
                    if (puntosAnteriorGanador > puntosJugadorCalculados
                            && puntosJugadorCalculados > puntosAnteriorJugador) {
                        puntosAnteriorJugador = puntosJugadorCalculados;
                        //puntosAnteriorJugador = gestoraCarta.evaluarCartas(i,this);
                        indiceGanador = i;
                    }
                }
            }

            if (!this.playerAllInLower[indiceGanador]){
                //Incrementa el saldo total del jugador con toodo el dinero de la mesa
                this.players[indiceGanador].increaseBalance(this.getTotalAllBets());

                //Informar del ganador
                System.out.println("El ganador de la partida es: "+this.getUsernamePlayer(indiceGanador));

                //Colocar todas las apuestas a 0
                this.restoreBets();

            }else{

                //Calcular el total que debe ganar el jugador
                for (int i = 0; i < this.betsPlayers[indiceGanador].length; i++){
                    if (this.betsPlayers[indiceGanador][i] != 0){
                        for (int j = 0;j<5;j++){
                            totalGanancias += betsPlayers[j][i];
                        }
                    }
                }

                //Informar del ganador
                System.out.println("El ganador de la partida es: "+this.getUsernamePlayer(indiceGanador)+" pero como no llego a las apuestas minimas solo se llevo una parte del bote: "+totalGanancias+"€");

                //Aumentar saldo jugador
                this.players[indiceGanador].increaseBalance(totalGanancias);

                //Disminuir dinero en las apuestas las apuestas a las apuestas totales

                for (int i = 0; i < this.betsPlayers[indiceGanador].length; i++){
                    if (this.betsPlayers[indiceGanador][i] != 0){
                        for (int j = 0;j<5;j++){
                            betsPlayers[j][i] -= this.betsPlayers[indiceGanador][i];
                        }
                    }
                }

            }
        }while (this.getTotalAllBets() > 0);

    }

    /*
     * SIGNATURA: public void increaseTurn();
     * COMENTARIO: Este metodo incrementa el atributo turno de la mesa controlando los limites validos.
     * PRECONDICIONES: - Nada
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Este metodo incrementa el atributo turno controlando los limites.
     *
     */

    /**
     * This method increases the attribute turn of the table controlling the valid limits
     */

    public void increaseTurn(){
        if (this.playerTurn == 4){
            this.playerTurn = 0;
        }else{
            this.playerTurn++;
        }
    }

    /*
     * SIGNATURA: public void showPanelPlay ();
     * COMENTARIO: Imprime por pantalla las cartas que hay en la mesa y la de los jugadores segun la ronda, el dinero de los demas jugadores y el total del bote de la mesa
     * PRECONDICIONES: - Nada
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - No devuelve nada, solo imprime por pantalla el estado actual en el que se encuentran los jugadores y las cartas
     */

    /**
     *  Print in screen the table with all properties of users and the carts depending on the turn
     */

    public void showPanelPlay() {

        String[][] numbersCardsPlayer = new String[5][2];
        for (int i = 0;i<numbersCardsPlayer.length;i++){
            for (int j = 0;j<numbersCardsPlayer[i].length;j++){
                numbersCardsPlayer[i][j] = this.getNumberCardPlayer(i,j);
                while (numbersCardsPlayer[i][j].length() < 3){
                    numbersCardsPlayer[i][j] += " ";
                }
            }
        }

        char[][] suitsCardsPlayer = new char[5][2];
        for (int i = 0;i<suitsCardsPlayer.length;i++){
            for (int j = 0;j<suitsCardsPlayer[i].length;j++){
                suitsCardsPlayer[i][j] = this.getSuitCardPlayer(i,j);
            }
        }

        String[] usernamePlayers = new String[5];
        for (int i = 0; i<usernamePlayers.length;i++){
            usernamePlayers[i] = this.getUsernamePlayer(i);
            while (usernamePlayers[i].length() < 20){
                usernamePlayers[i] += " ";
            }
            if (usernamePlayers[i].length() > 20){
                usernamePlayers[i] = usernamePlayers[i].substring(0,20);
            }
        }

        String[] balancePlayers = new String[5];
        for (int i = 0; i<balancePlayers.length;i++){
            balancePlayers[i] = this.getBalancePlayer(i)+"€";
            while (balancePlayers[i].length() < 11){
                balancePlayers[i] += " ";
            }
            if (balancePlayers[i].length() > 11){
                balancePlayers[i] = balancePlayers[i].substring(0,11);
            }
        }

        char[] suitsCardsTable = new char[5];
        for (int i = 0; i<suitsCardsTable.length;i++){
            suitsCardsTable[i] = this.getSuitCardTable(i);
        }

        String[] numbersCardsTable = new String[5];
        for (int i = 0; i<numbersCardsTable.length;i++){
            numbersCardsTable[i] = this.getNumberCardTable(i);
            while (numbersCardsTable[i].length() < 3){
                numbersCardsTable[i] += " ";
            }
        }


        System.out.println("                                      " + usernamePlayers[2] + "                                                         " + usernamePlayers[3]);
        System.out.println();
        System.out.println("                                      " + balancePlayers[2] + "                                                     " + balancePlayers[3]);
        System.out.println("                                      |º º|     -----        -----                                    |º º|    -----        -----");
        System.out.println("                                      |---|    | "+(this.round ==4?suitsCardsPlayer[2][0]:"?")+"   |      | "+(this.round ==4?suitsCardsPlayer[2][1]:"?")+"   |                                   |---|   | "+(this.round ==4?suitsCardsPlayer[3][0]:"?")+"   |      | "+(this.round ==4?suitsCardsPlayer[3][1]:"?")+"   |  ");
        System.out.println("                                               | "+(this.round ==4?numbersCardsPlayer[2][0]:"?  ")+" |      | "+(this.round ==4?numbersCardsPlayer[2][1]:"?  ")+" |                                           | "+(this.round ==4?numbersCardsPlayer[3][0]:"?  ")+" |      | "+(this.round ==4?numbersCardsPlayer[3][1]:"?  ")+" |");
        System.out.println("                                                -----        -----                                             -----        -----");



        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("       " + usernamePlayers[1] + "                                                                                                                              " + usernamePlayers[4]);
        System.out.println("                                                        ----- " + "       " + " ----- " + "       " + " ----- " + "       " + " ----- " + "       " + " ----- ");
        System.out.println("       " + balancePlayers[1] + "                                     | " + suitsCardsTable[0] + "   |" + "       " + "| " + suitsCardsTable[1] + "   |" + "       " + "| " + suitsCardsTable[2] + "   |" + "       " + "| " + suitsCardsTable[3] + "   |" + "       " + "| " + suitsCardsTable[4] + "   |                      " + balancePlayers[4]);
        System.out.println("       |º º|       -----        -----                  | " + numbersCardsTable[0] + " |" + "       " + "| " + numbersCardsTable[1] + " |" + "       " + "| " + numbersCardsTable[2] + " |" + "       " + "| " + numbersCardsTable[3] + " |" + "       " + "| " + numbersCardsTable[4] + " |                      |º º|      -----        -----");
        System.out.println("       |---|      | "+(this.round ==4?suitsCardsPlayer[1][0]:"?")+"   |      | "+(this.round ==4?suitsCardsPlayer[1][1]:"?")+"   |                 |     |" + "       " + "|     |" + "       " + "|     |" + "       " + "|     |" + "       " + "|     |" + "                      |---|     | "+(this.round ==4?suitsCardsPlayer[4][0]:"?")+"   |      | "+(this.round ==4?suitsCardsPlayer[4][1]:"?")+"   |");
        System.out.println("                  | "+(this.round ==4?numbersCardsPlayer[1][0]:"?  ")+" |      | "+(this.round ==4?numbersCardsPlayer[1][1]:"?  ")+" |                  ----- " + "       " + " ----- " + "       " + " ----- " + "       " + " ----- " + "       " + " -----                                 | "+(this.round ==4?numbersCardsPlayer[4][0]:"?  ")+" |      | "+(this.round ==4?numbersCardsPlayer[4][1]:"?  ")+" |");
        System.out.println("                   -----        -----                                                                                                                  -----        -----");

        System.out.println();
        System.out.println("                                                              DINERO EN MESA: " + this.getTotalAllBets() + "€");
        System.out.println();
        System.out.println();

        System.out.println("                                                                 " + usernamePlayers[0]);
        System.out.println("                                                              TU SALDO ES: " + balancePlayers[0]);
        System.out.println();
        System.out.println("                                                           _______________________");
        System.out.println("                                                          |                       |");
        System.out.println("                                                          |    __           __    |");
        System.out.println("                                                          |   |º |         |º |   |            ----------           ----------");
        System.out.println("                                                          |    --           --    |           | "+suitsCardsPlayer[0][0]+"        |         | "+suitsCardsPlayer[0][1]+"        |");
        System.out.println("                                                          |                       |           | "+numbersCardsPlayer[0][0]+"      |         | "+numbersCardsPlayer[0][1]+"      |");
        System.out.println("                                                          |   \\              /    |           |          |         |          |");
        System.out.println("                                                          |     \\___________/     |           |          |         |          |");
        System.out.println("                                                          |                       |            ----------           ----------");
        System.out.println("                                                           -----------------------");
        System.out.println();

    }

    /**
     * Increase the bet in the round passed by parameter for the player passed by parameter
     * @param indexPlayer int index of the user you want set bet
     * @param roundBet int index of the round you want set bet
     * @param quantity int amount to add
     * @return Return true if the bet was increased.
     *         Return false if the bet wasn't increased.
     */

    private boolean increaseBets(int indexPlayer, int roundBet, int quantity){
        boolean res = false;
        if ((indexPlayer >= 0 && indexPlayer <= 4) && (roundBet >= 0 && roundBet <= 4)){
            this.betsPlayers[indexPlayer][roundBet] += quantity;
            res = true;
        }
        return res;
    }


    /**
     * Method to calculate if exist 2 or more players remain active
     * @return Returns true if exist 2 or more players remain active
     *         Returns false if not exist 2 or more players remain active
     */

    //TODO Revisar

    private boolean remainPlayersToPlay(){
        int amountPlayersToPlay = 0;
        for (int i = 0; i < this.players.length; i++){
            if ((this.playerActive[i] && this.players[i].getBalance() > 0) ||  (this.playerActive[i] && this.players[i].getBalance() == 0 && this.playerAllInLower[i])){
                amountPlayersToPlay++;
            }
        }
        return amountPlayersToPlay > 1;
    }

    /**
     * @return
     */

    private boolean remainPlayersWithoutAllIn(){
        int amountPlayersWithoutAllIn = 0;
        for (int i = 0; i < this.players.length; i++){
            if (this.playerActive[i] && this.players[i].getBalance() > 0 && !this.playerAllInLower[i]){
                amountPlayersWithoutAllIn++;
            }
        }
        return amountPlayersWithoutAllIn > 1;
    }

    /**
     * @return
     */

    //TODO No funciona bien
    private int getMaxBet(){
        int maxBet = -1, maxBetComparable = -2;
        //Obtenemos la apuesta maxima que se puede hacer
        for (int i = 0; i < this.players.length; i++){
            if (this.players[i].getBalance() > maxBetComparable && this.playerActive[i]){
                maxBetComparable = this.players[i].getBalance();
            }
        }

        //Obtenemos la segunda apuesta maxima que se puede hacer
        for (int i = 0; i < this.players.length; i++){
            if (this.players[i].getBalance() > maxBet && this.playerActive[i] && this.players[i].getBalance() < maxBetComparable){
                maxBet = this.players[i].getBalance();
            }
        }

        //En el caso de que sea la primera partida y tengan todos los jugadores activos el mismo saldo se pone uno de ellos
        if (maxBet == -1){
            maxBet = maxBetComparable;
        }
        return maxBet;
    }

    //TODO corregir

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

    /**
     * This method places the bets of the players
     * @return Return true if there are more than 1 active players
     *         Return false if there are less than 1 active players
     */

    //TODO Separar realizar apuesta con comprobar lo de los jugadores, mirar que doBet no devuelva nada

    public boolean doBet(){
        ManagementPlayerImpl managPlayer = new ManagementPlayerImpl();
        int minBet = 0, betPlayer, turnPlayerPartial = this.playerTurn, turnPlayerFinal = this.playerTurn, maxBet;
        boolean quedanJugadoresParaJugar, quedanJugadoresSinAllIn;
        //Calcula cuantos jugadores se han "tirado"
        quedanJugadoresParaJugar = this.remainPlayersToPlay();

        quedanJugadoresSinAllIn = this.remainPlayersWithoutAllIn();

        //Si se han tirado 4 o mas jugadores no se realizan apuestas
        if (quedanJugadoresParaJugar && quedanJugadoresSinAllIn) {

            //Este bucle se utiliza para sacar el primer jugador que va a apostar
            //Ya que puede ocurrir que el delider se haya "tirado"
            while (!playerActive[turnPlayerPartial] && !playerAllInLower[turnPlayerPartial]){
                turnPlayerPartial = (turnPlayerPartial == 4)?0:++turnPlayerPartial;
            }

            //Comprueba que el jugador este activo y tenga un saldo mayor a 0
            if (playerActive[turnPlayerPartial] && this.getBalancePlayer(turnPlayerPartial) > 0 && !playerAllInLower[turnPlayerPartial]) {
                maxBet = getMaxBet();
                if(turnPlayerPartial == 0){
                    minBet = managPlayer.leerYValidarApuesta(turnPlayerPartial, minBet, maxBet,this);
                }else{
                    minBet = managPlayer.calcularApostarBot(turnPlayerPartial, minBet, maxBet,this);
                }
                //Disminuir el saldo del jugador
                this.players[turnPlayerPartial].decreaseBalance(minBet);
                //Anhadir apuesta a las apuestas de la partida
                if (!(this.setBetPlayer(turnPlayerPartial,this.round,minBet))){
                    System.out.println("No se pudo añadir la apuesta al jugador");
                }
            }

            System.out.println("El jugador "+this.getUsernamePlayer(turnPlayerPartial)+" ha iniciado apostando: "+minBet);

            //Incrementar turno
            turnPlayerPartial = (turnPlayerPartial == 4)?0:++turnPlayerPartial;

            while(turnPlayerPartial != turnPlayerFinal){

                //Comprueba que el jugador este activo y tenga un saldo mayor a 0
                if (playerActive[turnPlayerPartial] && this.getBalancePlayer(turnPlayerPartial) > 0 && !playerAllInLower[turnPlayerPartial]) {
                    maxBet = getMaxBet();
                    if(turnPlayerPartial == 0){
                        betPlayer = managPlayer.leerYValidarApuesta(turnPlayerPartial, minBet, maxBet,this);
                    }else{
                        betPlayer = managPlayer.calcularApostarBot(turnPlayerPartial, minBet, maxBet,this);
                    }

                    try {
                        Thread.sleep(1500);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    //Evaluar las apuestas
                    if ((betPlayer+this.getBetPlayer(turnPlayerPartial, round)) == minBet){
                        System.out.println("El jugador "+this.getUsernamePlayer(turnPlayerPartial)+" ha igualado la apuesta a: "+(betPlayer+this.getBetPlayer(turnPlayerPartial, round)));
                        //En el caso de que el jugador iguale la apuesta se le resta la apuesta realizada
                        this.players[turnPlayerPartial].decreaseBalance(betPlayer);
                        //Se le incrementa la apuesta en la ronda
                        if (!(this.increaseBets(turnPlayerPartial, round,betPlayer))){
                            System.out.println("No se ha podido incrementar la apuesta");
                        }

                    }else{
                        if ((betPlayer+this.getBetPlayer(turnPlayerPartial, round)) > minBet){
                            System.out.println("El jugador "+this.getUsernamePlayer(turnPlayerPartial)+" ha subido la apuesta a: "+(betPlayer+this.getBetPlayer(turnPlayerPartial, round)));
                            //En el caso de que el jugador suba la apuesta se le resta la apuesta realizada
                            this.players[turnPlayerPartial].decreaseBalance(betPlayer);
                            //Se le incrementa la apuesta en la ronda
                            if (!(this.increaseBets(turnPlayerPartial, round,betPlayer))){
                                System.out.println("No se ha podido incrementar la apuesta");
                            }
                            //Se guarda su posicion para volver a recorrer el array hasta que llegue a su posicion y asi poder tirar todos los jugadores
                            turnPlayerFinal = turnPlayerPartial;
                            //Se coloca su apuesta como apuesta minima para los demas jugadores
                            minBet = this.getBetPlayer(turnPlayerPartial, round);
                        }else{
                            //No hace falta comprobar que sea menor porque ya esta comprobado en los if de arriba
                            //En este caso se controla que el jugador haga all-in pero no llegue a la apuesta minima
                            if (this.players[turnPlayerPartial].getBalance() == betPlayer){
                                System.out.println("El jugador "+this.getUsernamePlayer(turnPlayerPartial)+" ha hecho allIn sin llegar al minimo con: "+(betPlayer+this.getBetPlayer(turnPlayerPartial, round)));
                                this.players[turnPlayerPartial].decreaseBalance(betPlayer);
                                //Coloca allInMejor en true para despues poder evaluar los ganadores
                                playerAllInLower[turnPlayerPartial] = true;
                                if (!(this.increaseBets(turnPlayerPartial, round,betPlayer))){
                                    System.out.println("No se ha podido incrementar la apuesta");
                                }
                            }else{  //Este es el caso de que el jugador se tire
                                System.out.println("El jugador "+this.getUsernamePlayer(turnPlayerPartial)+" se ha tirado.");
                                //this.players[turnPlayerPartial].setActive(false); //TODO REVISAR ESTO CREO QUE ES TRUE Y NO FALSE
                                playerActive[turnPlayerPartial] = true;
                            }
                        }
                    }
                }
                turnPlayerPartial = (turnPlayerPartial == 4)?0:++turnPlayerPartial;

            }

            //Calcula cuantos jugadores se han "tirado"
            quedanJugadoresParaJugar = this.remainPlayersToPlay();
        }
        this.round++;
        return quedanJugadoresParaJugar;
    }

    /**
     * This method return a String with attributes of the table
     * @return String with attributes of the table
     */

    @SuppressWarnings("StringConcatenationInLoop")
    @Override
    public String toString(){
        String stringDeskOfCards = "",stringPlayers = "",stringCardsTable = "", stringBets = "";

        for (CardImpl card : deckOfCards) {
            stringDeskOfCards += card.toString() + "\n";
        }

        for (PlayerImpl player : players) {
            stringPlayers += player.toString() + "\n";
        }

        for (CardImpl card : cardsOfTable) {
            stringCardsTable += card.toString() + "\n";
        }

        for (int i = 0; i< betsPlayers.length; i++){
            stringBets += "Apuestas jugador "+i+": ";
            for (int j = 0; j< betsPlayers[i].length; j++){
                stringBets += betsPlayers[i][j]+",";
            }
            stringBets += "\n";
        }

        return stringDeskOfCards+"\n"+stringPlayers+"\n"+stringCardsTable+"\n"+stringBets;

    }

    /**
     * This method return an int with value of hashCode of the table
     * @return int with value of hashCode of the table
     */

    @Override
    public int hashCode(){
        //noinspection ArrayHashCode
        return this.getTotalAllBets()+this.getPlayers().hashCode();
    }

    /**
     * This method return a Boolean value depending on whether the value of the table passed by parameter is equal to that compared
     * @param object An object with which you want to check if they are the same
     * @return boolean its value depending on whether the value of the table passed by parameter is equal to that compared
     */

    @Override
    public boolean equals(Object object){
        boolean result = false;
        if (this == object){
            result = true;
        }else{
            if (object instanceof TableImpl){
                TableImpl newTable = (TableImpl) object;
                if (this.getDeckOfCards()==newTable.getDeckOfCards()
                        && this.getCardsOfTable()==newTable.getCardsOfTable()
                        && this.getPlayers()==newTable.getPlayers()
                        && this.getBetsPlayers()==newTable.getBetsPlayers()){
                    result = true;
                }
            }
        }
        return result;
    }

    /**
     * This method return a object MesaImpl cloned from which it is called
     * @return MesaImpl Cloned table
     */

    @Override
    public TableImpl clone() {
        TableImpl clone = null;
        try {
            clone = (TableImpl) super.clone();

            for (int i = 0; i<clone.deckOfCards.length; i++){
                clone.deckOfCards[i] = this.deckOfCards[i].clone();
            }

            for (int i = 0; i<clone.players.length; i++){
                clone.players[i] = this.players[i].clone();
            }

            for (int i = 0; i<clone.cardsOfTable.length; i++){
                clone.cardsOfTable[i] = this.cardsOfTable[i].clone();
            }

            for (int i = 0; i<clone.cardsOfTable.length; i++){
                System.arraycopy(this.betsPlayers[i],0,clone.betsPlayers[i],0,5);
            }

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }

}
