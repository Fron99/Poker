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
 * private void setCartasJugador(int posicionJugador, CartaImpl[] cartas);
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

package Clases.Basicas;

import Clases.Gestoras.GestoraCartaImpl;
import Clases.Gestoras.GestoraJugadorImpl;
import Clases.Interfaces.Mesa;

import java.util.Random;

@SuppressWarnings("unused")
public class MesaImpl implements Mesa, Cloneable {

    private CartaImpl[] baraja;
    private JugadorImpl[] jugadores;
    private CartaImpl[] cartasMesa;
    private int[][] apuestasJugadores;
    private int turnoJugador;
    private int ronda;

    /**
     * This constructor put the attributes with default values
     */

    public MesaImpl(){
        Random random = new Random();
        this.baraja = new CartaImpl[52];
        for (int i = 0;i<this.baraja.length;i++){
            this.baraja[i] = new CartaImpl();
        }
        this.jugadores = new JugadorImpl[5];
        for (int i = 0;i<this.jugadores.length;i++){
            this.jugadores[i] = new JugadorImpl();
        }
        this.cartasMesa = new CartaImpl[5];
        for (int i = 0;i<this.cartasMesa.length;i++){
            this.cartasMesa[i] = new CartaImpl();
        }
        this.apuestasJugadores = new int[5][5];
        this.turnoJugador = random.nextInt(5);
        this.ronda = 0;
    }

    /**
     * This constructor put the attributes with the values passed by parameter.
     * If length of baraja isn't 52, the constructor builds a array with defaults objects.
     * If length of jugadores isn't 5, the constructor builds a array with defaults objects.
     * If length of cartasMesa isn't 5, the constructor builds a array with defaults objects.
     * @param baraja array of letters
     * @param jugadores array of players
     * @param cartasMesa array of letters
     */

    public MesaImpl(CartaImpl[] baraja, JugadorImpl[] jugadores, CartaImpl[] cartasMesa){
        Random random = new Random();

        this.baraja = new CartaImpl[52];
        if (baraja.length == 52){
            System.arraycopy(baraja,0,this.baraja,0,baraja.length);
        }else{
            for (int i = 0;i<this.baraja.length;i++){
                this.baraja[i] = new CartaImpl();
            }
        }

        this.jugadores = new JugadorImpl[5];
        if (jugadores.length == 5){
            System.arraycopy(jugadores,0,this.jugadores,0,jugadores.length);
        }else{
            for (int i = 0;i<this.jugadores.length;i++){
                this.jugadores[i] = new JugadorImpl();
            }
        }

        this.cartasMesa = new CartaImpl[5];
        if (cartasMesa.length == 5){
            System.arraycopy(cartasMesa,0,this.cartasMesa,0,cartasMesa.length);
        }else{
            for (int i = 0;i<this.cartasMesa.length;i++){
                this.cartasMesa[i] = new CartaImpl();
            }
        }

        this.apuestasJugadores = new int[5][5];
        this.turnoJugador = random.nextInt(5);
        this.ronda = 0;
    }

    /**
     * This constructor put the attributes with the values passed by parameter.
     * If length of baraja isn't 52, the constructor builds a array with defaults objects.
     * If length of jugadores isn't 5, the constructor builds a array with defaults objects.
     * If length of cartasMesa isn't 5, the constructor builds a array with defaults objects.
     * If length of apuestasJugadores isn't 5 times 5, the constructor builds a array with defaults values.
     * @param baraja array of letters
     * @param jugadores array of players
     * @param cartasMesa array of letters
     * @param apuestasJugadores array of int
     */

    public MesaImpl(CartaImpl[] baraja, JugadorImpl[] jugadores, CartaImpl[] cartasMesa, int[][] apuestasJugadores){
        Random random = new Random();
        this.baraja = new CartaImpl[52];
        if (baraja.length == 52){
            System.arraycopy(baraja,0,this.baraja,0,baraja.length);
        }else{
            for (int i = 0;i<this.baraja.length;i++){
                this.baraja[i] = new CartaImpl();
            }
        }

        this.jugadores = new JugadorImpl[5];
        if (jugadores.length == 5){
            System.arraycopy(jugadores,0,this.jugadores,0,jugadores.length);
        }else{
            for (int i = 0;i<this.jugadores.length;i++){
                this.jugadores[i] = new JugadorImpl();
            }
        }

        this.cartasMesa = new CartaImpl[5];
        if (cartasMesa.length == 5){
            System.arraycopy(cartasMesa,0,this.cartasMesa,0,cartasMesa.length);
        }else{
            for (int i = 0;i<this.cartasMesa.length;i++){
                this.cartasMesa[i] = new CartaImpl();
            }
        }

        this.apuestasJugadores = new int[5][5];
        if (apuestasJugadores.length == 5 && apuestasJugadores[0].length == 5){
            for (int i = 0;i<apuestasJugadores.length;i++){
                System.arraycopy(apuestasJugadores[i],0,this.apuestasJugadores[i],0,apuestasJugadores.length);
            }
        }

        this.turnoJugador = random.nextInt(5);
        this.ronda = 0;
    }

    /**
     * This constructor put the attributes with the values of the other object passed by parameter
     * @param otro another table of we want to copy their values
     */

    public MesaImpl(MesaImpl otro){
        this.baraja = new CartaImpl[52];
        System.arraycopy(otro.baraja,0,this.baraja,0,otro.baraja.length);

        this.jugadores = new JugadorImpl[5];
        System.arraycopy(otro.jugadores,0,this.jugadores,0,otro.jugadores.length);

        this.cartasMesa = new CartaImpl[5];
        System.arraycopy(otro.cartasMesa,0,this.cartasMesa,0,otro.cartasMesa.length);

        this.apuestasJugadores = new int[5][5];
        for (int i = 0;i<apuestasJugadores.length;i++){
            System.arraycopy(otro.apuestasJugadores[i],0,this.apuestasJugadores[i],0,apuestasJugadores.length);
        }

        this.turnoJugador = otro.turnoJugador;
        this.ronda = otro.ronda;

    }

    /**
     * Return array of attribute "baraja"
     * @return CartaImpl[] array of attribute "baraja"
     */

    public CartaImpl[] getBaraja(){
        CartaImpl[] baraja = new CartaImpl[this.baraja.length];
        System.arraycopy(this.baraja,0,baraja,0,this.baraja.length);
        return baraja;
    }

    /**
     * Set array passed by parameter in attribute "baraja"
     * @param baraja new value of attribute "baraja"
     */

    private void setBaraja(CartaImpl[] baraja){
        for (int i = 0;i<baraja.length; i++){
            this.baraja[i] = baraja[i].clone();
        }
    }

    /**
     * Return the card of the index in the array "baraja". The allowed range of the index is 0 to 51.
     * @param indiceBaraja index of the card of you will want return
     * @return CartaImpl card that you want to get if the value of index passed by parameter is allowed.
     *                   If the value of index not allowed, return a card with value 0 and 0
     */

    public CartaImpl getCartaBaraja(int indiceBaraja){
        return (indiceBaraja >= 0 && indiceBaraja <= 51) ? this.baraja[indiceBaraja].clone() : new CartaImpl('0',"0");
    }

    /**
     * Set value of the card that index with the card passed by parameter. The allowed range of the index is 0 to 51.
     * @param baraja new value of attribute "baraja"
     * @param indiceBaraja index of the card that will be changed the value
     * @return res Return true if the value of the array index card passed by parameter has been changed.
     *             Return false if the value of the array index card passed by parameter hasn't been changed.
     */

    private boolean setCartaBaraja(CartaImpl baraja, int indiceBaraja){
        boolean res = false;
        if (indiceBaraja >= 0 && indiceBaraja <= 51){
            this.baraja[indiceBaraja] = baraja;
            res = true;
        }
        return res;
    }

    /**
     * Get the number of the card of the desk. The allowed range of the index is 0 to 51.
     * @param indiceBaraja index of the card that will want get number
     * @return Return a String with the value of number of the card. If the index not between of range allowed return 0.
     */

    public String getNumeroCartaBaraja(int indiceBaraja){
        return (indiceBaraja >= 0 && indiceBaraja <= 51) ? this.baraja[indiceBaraja].getNumero() : "0";
    }

    /**
     * Get the stick of the card of the desk. The allowed range of the index is 0 to 51.
     * @param indiceBaraja index of the card that will want get stick
     * @return Return a char with the value of stick of the card. If the index not between of range allowed return 0.
     */

    public char getPaloCartaBaraja(int indiceBaraja){
        return (indiceBaraja >= 0 && indiceBaraja <= 51) ? this.baraja[indiceBaraja].getPalo() : '0';
    }

    /**
     * Return array of attribute "jugadores"
     * @return JugadorImpl[] array of attribute "jugadores"
     */

    public JugadorImpl[] getJugadores(){
        JugadorImpl[] jugadores = new JugadorImpl[this.jugadores.length];
        System.arraycopy(this.jugadores,0,jugadores,0,this.jugadores.length);
        return jugadores;
    }

    /**
     * Set array passed by parameter in attribute "jugadores"
     * @param jugadores new value of attribute "jugadores"
     */

    private void setJugadores(JugadorImpl[] jugadores){
        for (int i = 0;i<jugadores.length; i++){
            this.jugadores[i] = jugadores[i].clone();
        }
    }

    /**
     * This method return the player of the position passed by parameter. The allowed range of the index is 0 to 4.
     * @param posicion position of the player you want to get
     * @return JugadorImpl player yo want to get. If the index not between of range allowed return a player with value "IndexOvertakeRange" in "Usuario".
     */

    public JugadorImpl getJugador(int posicion){
        return (posicion >= 0 && posicion <= 4) ? this.jugadores[posicion].clone() : new JugadorImpl("IndexOvertakeRange",0);
    }

    /**
     * This method adds the player passed by parameter to the array of players. The allowed range of the index is 0 to 4.
     * @param indiceJugador position where the player wants to add
     * @param jugador player you want to add
     * @return Return true if the value of the array index player passed by parameter has been changed.
     *         Return false if the value of the array index player passed by parameter hasn't been changed.
     */

    public boolean setJugador(int indiceJugador, JugadorImpl jugador){
        boolean res = false;
        if (indiceJugador >= 0 && indiceJugador <= 4){
            this.jugadores[indiceJugador] = jugador.clone();
            res = true;
        }
        return res;
    }

    /**
     * Get the "usuario" of the player. The allowed range of the index is 0 to 4.
     * @param posicionJugador index of the player that will want get "usuario"
     * @return Return a String with the value of "usuario" of the player. If the index not between of range allowed return 0.
     */

    public String getUsuarioJugador(int posicionJugador){
        return (posicionJugador >= 0 && posicionJugador <= 4) ? this.jugadores[posicionJugador].getUsuario() : "0";
    }

    /**
     * Get the "saldo" of the player. The allowed range of the index is 0 to 4.
     * @param posicionJugador index of the player that will want get "saldo"
     * @return Return a int with the value of "saldo" of the player. If the index not between of range allowed return 0.
     */

    public int getSaldoJugador(int posicionJugador){
        return (posicionJugador >= 0 && posicionJugador <= 4) ? this.jugadores[posicionJugador].getSaldo() : -1;
    }

    /**
     * This method adds the money passed by parameter in the player of position passed by parameter(index). The allowed range of the index is 0 to 4.
     * @param posicionJugador Position of the player that wants to add money
     * @param saldo Money to add to the player
     * @return Return true if money was added to the player.
     *         Return false if money wasn't added to the player.
     */

    private boolean setSaldoJugador(int posicionJugador, int saldo){
        boolean res = false;
        if (posicionJugador >= 0 && posicionJugador <= 4){
            this.jugadores[posicionJugador].setSaldo(saldo);
            res = true;
        }
        return res;
    }

    /**
     * Get all card of the player passed by parameter. The allowed range of the index is 0 to 4.
     * @param posicionJugador Position of the player that wants get cards
     * @return Return all cards of the player if index passed by parameter is allowed.
     *         Return null if index passed by parameter isn't allowed.
     */

    public CartaImpl[] getCartasJugador(int posicionJugador){
        CartaImpl[] cartasJugador = null;
        if (posicionJugador >= 0 && posicionJugador <= 4){
            cartasJugador = new CartaImpl[2];
            System.arraycopy(this.jugadores[posicionJugador].getCartas(),0,cartasJugador,0,this.jugadores[posicionJugador].getCartas().length);
        }
        return cartasJugador;
    }

    /**
     * Add cards passed by parameter to the player. The allowed range of the index is 0 to 4.
     * @param posicionJugador int position of player where do you want add the cards passed by parameter
     * @param cartas CartaImpl[] with the cards you want to add to the player
     * @return Return true if the cards was added to the player.
     *         Return false if the cards wasn't added to the player.
     */

    private boolean setCartasJugador(int posicionJugador, CartaImpl[] cartas){
        boolean res = false;
        if (posicionJugador >= 0 && posicionJugador <= 4){
            this.jugadores[posicionJugador].setCartas(cartas);
            res = true;
        }
        return res;
    }

    /**
     * @param posicionJugador index of player that you want get card. The allowed range of the index of player is 0 to 4. The allowed range of the index of card is 0 to 1.
     * @param carta index of card you want get
     * @return card that you want to get if the value of index passed by parameter is allowed.
     *         If the value of index not allowed, return a card with value 0 and 0
     */

    public CartaImpl getCartaJugador(int posicionJugador,int carta){
        return (posicionJugador >= 0 && posicionJugador <= 4) ? (carta == 0 || carta == 1) ? this.getCartasJugador(posicionJugador)[carta] : new CartaImpl('0',"0") : new CartaImpl('0',"0");
    }

    /**
     * Get the stick of the card of the player. The allowed range of the player of the index is 0 to 4. The allowed range of the card of the index is 0 to 1.
     * @param posicionJugador index of the player that will want get stick from one card
     * @param carta index of the card that will want get stick
     * @return Return a char with the value of stick of the card. If the index not between of range allowed return 0.
     */

    public char getPaloCartaJugador(int posicionJugador,int carta){
        return (posicionJugador >= 0 && posicionJugador <= 4) ? (carta == 0 || carta == 1) ? this.getCartaJugador(posicionJugador,carta).getPalo() : '0' : '0';
    }

    /**
     * Get the number of the card of the player. The allowed range of the player of the index is 0 to 4. The allowed range of the card of the index is 0 to 1.
     * @param posicionJugador index of the player that will want get stick from one card
     * @param carta index of the card that will want get number
     * @return Return a String with the value of number of the card. If the index not between of range allowed return 0.
     */

    public String getNumeroCartaJugador(int posicionJugador,int carta){
        return (posicionJugador >= 0 && posicionJugador <= 4) ? (carta == 0 || carta == 1) ? this.getCartaJugador(posicionJugador,carta).getNumero() : "0" : "0";
    }

    /**
     * This method added the card passed by parameter to the cards of the player. The allowed range of the player of the index is 0 to 4. The allowed range of the card of the index is 0 to 1.
     * @param posicionJugador index of the player to which you want to add the card passed by parameter
     * @param posicionCarta index of the card where it will be added
     * @param carta card to add
     * @return Return true if the card was added to the player.
     *         Return false if the card wasn't added to the player.
     */

    private boolean setCartaJugador(int posicionJugador,int posicionCarta, CartaImpl carta){
        boolean res = false;
        if ((posicionJugador >= 0 && posicionJugador <= 4) && (posicionCarta == 0 || posicionCarta == 1)){
            this.jugadores[posicionJugador].setCarta(posicionCarta, carta);
            res = true;
        }
        return res;
    }

    /**
     * Obtain if player is active or not. The allowed range of the player of the index is 0 to 4.
     * @param posicionJugador index of the player you want to obtain if it is active or not
     * @return Return 1 is player is active.
     *         Return 0 is player isn't active.
     *         Return -1 if the index passed by parameter not between of range allowed.
     */

    public int getActivoJugador(int posicionJugador){
        return (posicionJugador >= 0 && posicionJugador <= 4) ? (this.getJugador(posicionJugador).getActivo()) ? 1 : 0 : -1;
    }

    /**
     * This method return array of attribute "cartasMesa"
     * @return CartaImpl[] array of attribute "cartasMesa"
     */

    public CartaImpl[] getCartasMesa(){
        CartaImpl[] cartas = new CartaImpl[this.cartasMesa.length];
        System.arraycopy(this.cartasMesa,0,cartas,0,this.cartasMesa.length);
        return cartas;
    }

    /**
     * Set array passed by parameter in attribute "cartas"
     * @param cartas new value of attribute "cartas"
     */

    private void setCartasMesa(CartaImpl[] cartas){
        this.cartasMesa = cartas;
    }

    /**
     * This method return the card select by the index passed by parameter from atribute "cartasMesa". The allowed range of the index of cards is 0 to 4.
     * @param indiceCarta index of the card that you want obtain
     * @return Return card select by the index passed by parameter from atribute "cartasMesa"
     *         If the value of index not allowed, return a card with value 0 and 0
     *
     */

    public CartaImpl getCartaMesa(int indiceCarta){
        return (indiceCarta >= 0 && indiceCarta <= 4) ? this.cartasMesa[indiceCarta].clone() : new CartaImpl('0',"0");
    }

    /**
     * This method add the carte passed by parameter to array of letters of table in the position passed by parameter. The allowed range of the cards of the index is 0 to 4.
     * @param indiceCarta position where the card is added
     * @param carta carte to add
     * @return Return true if the card was added to the cards of table.
     *         Return false if the card wasn't added to the cards of table.
     */

    private boolean setCartaMesa(int indiceCarta, CartaImpl carta){
        boolean res = false;
        if (indiceCarta >= 0 && indiceCarta <= 4){
            this.cartasMesa[indiceCarta] = carta;
            res = true;
        }
        return res;
    }

    /**
     * Get the number of the card of the table. The allowed range of the cards of the index is 0 to 4.
     * @param indiceCarta index of the card that will want get number
     * @return Return a String with the value of number of the card. If the index not between of range allowed return 0.
     */

    public String getNumeroCartaMesa(int indiceCarta){
        return (indiceCarta >= 0 && indiceCarta <= 4) ? this.getCartaMesa(indiceCarta).getNumero() : "0";
    }

    /**
     * Get the stick of the card of the table. The allowed range of the cards of the index is 0 to 4.
     * @param indiceCarta index of the card that will want get stick
     * @return Return a char with the value of stick of the card. If the index not between of range allowed return 0.
     */

    public char getPaloCartaMesa(int indiceCarta){
        return (indiceCarta >= 0 && indiceCarta <= 4) ? this.getCartaMesa(indiceCarta).getPalo() : '0';
    }

    /**
     * This method return array of attribute "apuestasJugadores"
     * @return int[][] array of attribute "apuestasJugadores"
     */

    public int[][] getApuestasJugadores(){
        int[][] apuestas = new int[5][5];
        for (int i = 0;i<this.apuestasJugadores.length;i++){
            System.arraycopy(this.apuestasJugadores[i],0,apuestas[i],0,this.apuestasJugadores[i].length);
        }
        return apuestas;
    }

    /**
     * Set array passed by parameter in attribute "apuestasJugadores"
     * @param apuestas new value of attribute "apuestas"
     */

    private void setApuestasJugadores(int[][] apuestas){
        this.apuestasJugadores = apuestas.clone();
    }

    /**
     * Get all bets from a player for the index passed by parameter. The allowed range of the player of the index is 0 to 4.
     * @param indiceJugador index of the player that will want get stick
     * @return Return a int[] with all bets of the player passed by parameter.
     *         Return null if the index of player passed by parameter isn't allowed.
     */

    public int[] getApuestasJugador(int indiceJugador){
        int[] apuestasJugador = null;
        if (indiceJugador >= 0 && indiceJugador <= 4){
            apuestasJugador = new int[this.apuestasJugadores[indiceJugador].length];
            System.arraycopy(this.apuestasJugadores[indiceJugador],0,apuestasJugador,0,this.apuestasJugadores[indiceJugador].length);
        }
        return apuestasJugador;
    }

    /**
     * Assign the bets passed by parameter to the player of the index passed by parameter. The allowed range of the player of the index is 0 to 4.
     * @param indiceJugador index of the player that will want assign bets.
     * @param apuestas Bets that will want assign to player.
     * @return Return true if the bets was added to the player.
     *         Return false if the bets wasn't added to the player.
     */

    private boolean setApuestasJugador(int indiceJugador, int[] apuestas){
        boolean res = false;
        if (indiceJugador >= 0 && indiceJugador <= 4){
            this.apuestasJugadores[indiceJugador] = apuestas;
            res = true;
        }
        return res;
    }

    /**
     * Get user bet in an exact round. The allowed range of the player of the index is 0 to 4. The allowed range of the round of the index is 0 to 4.
     * @param posicionJugador int index of the user you want get bet
     * @param rondaApuesta int index of the round you want get bet
     * @return Return int bet of the user in the round
     *
     */

    public int getApuestaJugador(int posicionJugador, int rondaApuesta){
        return (posicionJugador >= 0 && posicionJugador <= 4) ? (rondaApuesta >= 0 && rondaApuesta <= 4) ? this.apuestasJugadores[posicionJugador][rondaApuesta] : -1 : -1;
    }

    /**
     * Assign a round set of the index passed by parameter to the player of the index passed by parameter. The allowed range of the player of the index is 0 to 4. The allowed range of the round of the index is 0 to 4.
     * @param posicionJugador int index of the user you want get bet
     * @param rondaApuesta int index of the round you want get bet
     * @param apuestas int bet to assign to the player
     */

    private boolean setApuestaJugador(int posicionJugador,int rondaApuesta, int apuestas){
        boolean res = false;
        if ((posicionJugador >= 0 && posicionJugador <= 4) && (rondaApuesta >= 0 && rondaApuesta <= 4)){
            this.apuestasJugadores[posicionJugador][rondaApuesta] = apuestas;
            res = true;
        }
        return res;
    }

    /**
     * Return value of sum all bets
     * @return int value of sum all bets
     */

    public int getTotalApuestas(){
        int total = 0;
        for (int[] jugador:this.apuestasJugadores) {
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

    public int getRonda(){
        return this.ronda;
    }

    /*
     * SIGNATURA: public void restaurarMesa();
     * COMENTARIO: Elimina todos los cambios que se hayan realizado sobre los atributos baraja, activoJugadores, cartasJugadores, cartasMesa, apuestas y ronda y lo coloca por defecto para empezar una jugada nueva.
     * PRECONDICIONES: - Nada
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Elimina todos los cambios que se hayan realizado sobre los atributos baraja, activoJugadores, cartasJugadores, cartasMesa y apuestas y lo coloca por defecto para empezar una jugada nueva.
     *
     */

    /**
     * Removes all changes made to the "baraja", "activoJugadores", "cartasJugadores", "cartasMesa", "apuestas" and "ronda" attributes and defaults to starting a new play.
     */

    public void restaurarMesa(){
        restaurarBaraja();
        colocarJugadoresActivos();
        generarCartasJugadores();
        restaurarCartasMesa();
        restaurarApuestas();
        this.ronda = 0;
    }

    /*
     * SIGNATURA: public void restaurarCartasMesa()
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

    public void restaurarCartasMesa(){
        for (int i = 0; i<this.cartasMesa.length; i++){
            this.cartasMesa[i] = new CartaImpl();
        }
    }

    /*
     * SIGNATURA: public void restaurarBaraja()
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

    public void restaurarBaraja(){
        char[] palos = new char[]{'P','C','R','T'};
        String[] numeros = new String[]{"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        int contador = 0;
        for (char palo: palos){
            for (String numero : numeros) {
                this.baraja[contador] = new CartaImpl(palo, numero);
                contador++;
            }
        }
    }

    /*
     * SIGNATURA: public void restaurarApuestas()
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

    public void restaurarApuestas() {
        for (int i = 0; i < this.apuestasJugadores.length; i++) {
            for (int j = 0; j < this.apuestasJugadores.length; j++) {
                this.apuestasJugadores[i][j] = 0;
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

    private void colocarJugadoresActivos(){
        for(JugadorImpl jugador: this.jugadores){
            jugador.setActivo(true);
        }
    }

    /*
     * SIGNATURA: public void generarBots();
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

    public void generarBots(){

        Random random = new Random();
        String[] nombresAleatorios = {"Kun","Wang","YanYan","Zhao","Yun","Sasha","Volodia","Hedeon","Grigory"};
        for (int i = 1; i<jugadores.length;i++){
            this.jugadores[i] = new JugadorImpl(nombresAleatorios[random.nextInt(8)],jugadores[0].getSaldo());
        }

    }

    /*
     * SIGNATURA: public void generarTresCartasMesa();
     * COMENTARIO: Saca 3 cartas de la baraja y las coloca en el array de las cartas de la mesa
     * PRECONDICIONES: - Nada
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: Modifica el array de las barajas, colocando 3 los huecos de las 3 cartas sacadas como cartas por defecto y coloca las cartas sacadas
     *                  en el array de las cartas de la mesa.
     */

    /**
     *
     */

    public void generarTresCartasMesa() {

        Random r = new Random();
        int numPosicionCarta;

        numPosicionCarta = r.nextInt(52);
        for (int i = 0; i < 3; i++) {
            do {
                if (this.baraja[numPosicionCarta].getPalo() != 'D') {
                    this.cartasMesa[i] = this.baraja[numPosicionCarta];
                    this.baraja[numPosicionCarta] = new CartaImpl();
                }
                numPosicionCarta = r.nextInt(52);
            } while (this.baraja[numPosicionCarta].getPalo() == 'D');

        }

    }

    /*
     * SIGNATURA: public void generarCartasJugadores();
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

    public void generarCartasJugadores() {

        Random r = new Random();
        int numPosicionCarta;

        for (int i = 0; i<this.jugadores.length;i++){
            for (int j = 0; j<2; j++){
                do {
                    numPosicionCarta = r.nextInt(52);
                    if (baraja[numPosicionCarta].getPalo() != 'D') {    //Comprueba si la carta seleccionada de la baraja no ha salido ya (Que es cuando esta por defecto)
                        //En el caso de que no haya salido se le asigna al jugador y se coloca por defecto en la baraja
                        if (!(this.setCartaJugador(i, j, baraja[numPosicionCarta]))) {  //Anhade la carta y compruba si se añadio correctamente
                            System.out.println("No se ha podido anhadir la carta");
                        }
                    }
                } while (baraja[numPosicionCarta].getPalo() == 'D');
                baraja[numPosicionCarta] = new CartaImpl();
            }
        }

    }

    /*
     * SIGNATURA: public void generarCartaMesa();
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

    public void generarCartaMesa() {

        Random r = new Random();
        int numPosicionCarta, indiceCartaGenerar = -1;

        //Calcula cual es la siguiente carta sin levantar y guarda el indice
        for (int i = 0; i < this.cartasMesa.length && indiceCartaGenerar == -1; i++) {
            if (this.cartasMesa[i].getPalo() == 'D') {
                indiceCartaGenerar = i;
            }
        }

        if (indiceCartaGenerar != -1){
            //Guarda la carta que se ha sacado de la baraja en las cartas de la mesa
            do {
                numPosicionCarta = r.nextInt(52);
                if (this.baraja[numPosicionCarta].getPalo() != 'D') {
                    this.cartasMesa[indiceCartaGenerar] = this.baraja[numPosicionCarta];
                }
            } while (this.baraja[numPosicionCarta].getPalo() == 'D');
            this.baraja[numPosicionCarta] = new CartaImpl();
        }
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
     *
     */

    //TODO ASDasd

    public void ingresarSaldoGanadoresYMostrarGanador(){
        GestoraCartaImpl gestoraCarta = new GestoraCartaImpl();
        int cantidadGanadores = 0, indiceGanador = -1, totalGanancias = 0, puntosAnteriorGanador = 99999, puntosAnteriorJugador = 0, puntosJugadorCalculados;

        do{
            //Obtener ganador
            for (int i = 0; i< this.jugadores.length;i++){
                puntosJugadorCalculados = gestoraCarta.evaluarCartas(i,this);
                //Se utiliza puntosAnteriorGanador
                if (puntosAnteriorGanador > puntosJugadorCalculados
                    && puntosJugadorCalculados > puntosAnteriorJugador
                    && this.jugadores[i].getActivo()){
                        puntosAnteriorJugador = gestoraCarta.evaluarCartas(i,this);
                        indiceGanador = i;
                }
            }

            if (!this.jugadores[indiceGanador].getAllInMenor()){
                //Incrementa el saldo total del jugador con toodo el dinero de la mesa
                this.jugadores[indiceGanador].aumentarDinero(this.getTotalApuestas());

                //Informar del ganador
                System.out.println("El ganador de la partida es: "+this.getUsuarioJugador(indiceGanador));

                //Colocar todas las apuestas a 0
                this.restaurarApuestas();

            }else{

                //Calcular el total que debe ganar el jugador
                for (int i = 0; i < this.apuestasJugadores[indiceGanador].length;i++){
                    if (this.apuestasJugadores[indiceGanador][i] != 0){
                        for (int j = 0;j<5;j++){
                            totalGanancias += apuestasJugadores[j][i];
                        }
                    }
                }

                //Informar del ganador
                System.out.println("El ganador de la partida es: "+this.getUsuarioJugador(indiceGanador)+" pero como no llego a las apuestas minimas solo se llevo una parte del bote: "+totalGanancias+"€");

                //Aumentar saldo jugador
                this.jugadores[indiceGanador].aumentarDinero(totalGanancias);

                //Disminuir dinero en las apuestas las apuestas a las apuestas totales

                for (int i = 0; i < this.apuestasJugadores[indiceGanador].length;i++){
                    if (this.apuestasJugadores[indiceGanador][i] != 0){
                        for (int j = 0;j<5;j++){
                            apuestasJugadores[j][i] -= this.apuestasJugadores[indiceGanador][i];
                        }
                    }
                }

            }
        }while (this.getTotalApuestas() > 0);

    }

    /*
     * SIGNATURA: public void incrementarTurno();
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

    public void incrementarTurno(){
        if (this.turnoJugador == 4){
            this.turnoJugador = 0;
        }else{
            this.turnoJugador++;
        }
    }

    /*
     * SIGNATURA: public void mostrarPanelJuego ();
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

    public void mostrarPanelJuego() {

        String[][] numerosCartasJugadores = new String[5][2];
        for (int i = 0;i<numerosCartasJugadores.length;i++){
            for (int j = 0;j<numerosCartasJugadores[i].length;j++){
                numerosCartasJugadores[i][j] = this.getNumeroCartaJugador(i,j);
                while (numerosCartasJugadores[i][j].length() < 3){
                    numerosCartasJugadores[i][j] += " ";
                }
            }
        }

        char[][] palosCartasJugadores = new char[5][2];
        for (int i = 0;i<palosCartasJugadores.length;i++){
            for (int j = 0;j<palosCartasJugadores[i].length;j++){
                palosCartasJugadores[i][j] = this.getPaloCartaJugador(i,j);
            }
        }

        String[] usersJugadores = new String[5];
        for (int i = 0; i<usersJugadores.length;i++){
            usersJugadores[i] = this.getUsuarioJugador(i);
            while (usersJugadores[i].length() < 20){
                usersJugadores[i] += " ";
            }
            if (usersJugadores[i].length() > 20){
                usersJugadores[i] = usersJugadores[i].substring(0,20);
            }
        }

        String[] saldoJugadores = new String[5];
        for (int i = 0; i<saldoJugadores.length;i++){
            saldoJugadores[i] = this.getSaldoJugador(i)+"€";
            while (saldoJugadores[i].length() < 11){
                saldoJugadores[i] += " ";
            }
            if (saldoJugadores[i].length() > 11){
                saldoJugadores[i] = saldoJugadores[i].substring(0,11);
            }
        }

        char[] palosCartasMesa = new char[5];
        for (int i = 0; i<palosCartasMesa.length;i++){
            palosCartasMesa[i] = this.getPaloCartaMesa(i);
        }

        String[] numerosCartasMesa = new String[5];
        for (int i = 0; i<numerosCartasMesa.length;i++){
            numerosCartasMesa[i] = this.getNumeroCartaMesa(i);
            while (numerosCartasMesa[i].length() < 3){
                numerosCartasMesa[i] += " ";
            }
        }


        System.out.println("                                      " + usersJugadores[2] + "                                                         " + usersJugadores[3]);
        System.out.println();
        System.out.println("                                      " + saldoJugadores[2] + "                                                     " + saldoJugadores[3]);
        System.out.println("                                      |º º|     -----        -----                                    |º º|    -----        -----");
        System.out.println("                                      |---|    | "+(this.ronda==4?palosCartasJugadores[2][0]:"?")+"   |      | "+(this.ronda==4?palosCartasJugadores[2][1]:"?")+"   |                                   |---|   | "+(this.ronda==4?palosCartasJugadores[3][0]:"?")+"   |      | "+(this.ronda==4?palosCartasJugadores[3][1]:"?")+"   |  ");
        System.out.println("                                               | "+(this.ronda==4?numerosCartasJugadores[2][0]:"?  ")+" |      | "+(this.ronda==4?numerosCartasJugadores[2][1]:"?  ")+" |                                           | "+(this.ronda==4?numerosCartasJugadores[3][0]:"?  ")+" |      | "+(this.ronda==4?numerosCartasJugadores[3][1]:"?  ")+" |");
        System.out.println("                                                -----        -----                                             -----        -----");



        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("       " + usersJugadores[1] + "                                                                                                                              " + usersJugadores[4]);
        System.out.println("                                                        ----- " + "       " + " ----- " + "       " + " ----- " + "       " + " ----- " + "       " + " ----- ");
        System.out.println("       " + saldoJugadores[1] + "                                     | " + palosCartasMesa[0] + "   |" + "       " + "| " + palosCartasMesa[1] + "   |" + "       " + "| " + palosCartasMesa[2] + "   |" + "       " + "| " + palosCartasMesa[3] + "   |" + "       " + "| " + palosCartasMesa[4] + "   |                      " + saldoJugadores[4]);
        System.out.println("       |º º|       -----        -----                  | " + numerosCartasMesa[0] + " |" + "       " + "| " + numerosCartasMesa[1] + " |" + "       " + "| " + numerosCartasMesa[2] + " |" + "       " + "| " + numerosCartasMesa[3] + " |" + "       " + "| " + numerosCartasMesa[4] + " |                      |º º|      -----        -----");
        System.out.println("       |---|      | "+(this.ronda==4?palosCartasJugadores[1][0]:"?")+"   |      | "+(this.ronda==4?palosCartasJugadores[1][1]:"?")+"   |                 |     |" + "       " + "|     |" + "       " + "|     |" + "       " + "|     |" + "       " + "|     |" + "                      |---|     | "+(this.ronda==4?palosCartasJugadores[4][0]:"?")+"   |      | "+(this.ronda==4?palosCartasJugadores[4][1]:"?")+"   |");
        System.out.println("                  | "+(this.ronda==4?numerosCartasJugadores[1][0]:"?  ")+" |      | "+(this.ronda==4?numerosCartasJugadores[1][1]:"?  ")+" |                  ----- " + "       " + " ----- " + "       " + " ----- " + "       " + " ----- " + "       " + " -----                                 | "+(this.ronda==4?numerosCartasJugadores[4][0]:"?  ")+" |      | "+(this.ronda==4?numerosCartasJugadores[4][1]:"?  ")+" |");
        System.out.println("                   -----        -----                                                                                                                  -----        -----");

        System.out.println();
        System.out.println("                                                              DINERO EN MESA: " + this.getTotalApuestas() + "€");
        System.out.println();
        System.out.println();

        System.out.println("                                                                 " + usersJugadores[0]);
        System.out.println("                                                              TU SALDO ES: " + saldoJugadores[0]);
        System.out.println();
        System.out.println("                                                           _______________________");
        System.out.println("                                                          |                       |");
        System.out.println("                                                          |    __           __    |");
        System.out.println("                                                          |   |º |         |º |   |            ----------           ----------");
        System.out.println("                                                          |    --           --    |           | "+palosCartasJugadores[0][0]+"        |         | "+palosCartasJugadores[0][1]+"        |");
        System.out.println("                                                          |                       |           | "+numerosCartasJugadores[0][0]+"      |         | "+numerosCartasJugadores[0][1]+"      |");
        System.out.println("                                                          |   \\              /    |           |          |         |          |");
        System.out.println("                                                          |     \\___________/     |           |          |         |          |");
        System.out.println("                                                          |                       |            ----------           ----------");
        System.out.println("                                                           -----------------------");
        System.out.println();

    }

    /**
     * Increase the bet in the round passed by parameter for the player passed by parameter
     * @param posicionJugador int index of the user you want set bet
     * @param rondaApuesta int index of the round you want set bet
     * @param cantidad int amount to add
     * @return Return true if the bet was increased.
     *         Return false if the bet wasn't increased.
     */

    private boolean incrementarApuesta(int posicionJugador, int rondaApuesta, int cantidad){
        boolean res = false;
        if ((posicionJugador >= 0 && posicionJugador <= 4) && (rondaApuesta >= 0 && rondaApuesta <= 4)){
            this.apuestasJugadores[posicionJugador][rondaApuesta] += cantidad;
            res = true;
        }
        return res;
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

    /**
     * This method places the bets of the players
     * @return Return true if there are more than 1 active players
     *         Return false if there are less than 1 active players
     */

    public boolean realizarApuestas(){
        GestoraJugadorImpl gesJug = new GestoraJugadorImpl();
        int apuestaMinima = 0, apuestaJugador, cantidadJugadoresPasan = 0, turnoJugadorParcial = this.turnoJugador, turnoJugadorFinal = this.turnoJugador;
        boolean jugadorPasa = false, quedanJugadores = true;
        //Calcula cuantos jugadores se han "tirado"
        for (JugadorImpl jugador: this.getJugadores()) {
            if (!jugador.getActivo() && jugador.getSaldo() > 0){
                quedanJugadores = ++cantidadJugadoresPasan < 4;
            }
        }

        //Si se han tirado 4 o mas jugadores no se realizan apuestas
        if (quedanJugadores) {

            //Este bucle se utiliza para sacar el primer jugador que va a apostar
            //Ya que puede ocurrir que el delider se haya "tirado"
            while (!this.jugadores[turnoJugadorParcial].getActivo()){
                turnoJugadorParcial = (turnoJugadorParcial == 4)?0:++turnoJugadorParcial;
            }

            //Comprueba que el jugador este activo y tenga un saldo mayor a 0
            if (this.getJugador(turnoJugadorParcial).getActivo() && this.getSaldoJugador(turnoJugadorParcial) > 0) {
                //
                if(turnoJugadorParcial == 0){
                    apuestaMinima = gesJug.leerYValidarApuesta(turnoJugadorParcial, apuestaMinima, this);
                }else{
                    apuestaMinima = gesJug.calcularApostarBot(apuestaMinima,this,turnoJugadorParcial);
                }
                //Disminuir el saldo del jugador
                this.jugadores[turnoJugadorParcial].disminuirDinero(apuestaMinima);
                //Anhadir apuesta a las apuestas de la partida
                if (!(this.setApuestaJugador(turnoJugadorParcial,this.ronda,apuestaMinima))){
                    System.out.println("No se pudo añadir la apuesta al jugador");
                }
            }

            System.out.println("El jugador "+this.getUsuarioJugador(turnoJugadorParcial)+" ha iniciado apostando: "+apuestaMinima);

            //Incrementar turno
            turnoJugadorParcial = (turnoJugadorParcial == 4)?0:++turnoJugadorParcial;

            while(turnoJugadorParcial != turnoJugadorFinal){

                //Comprueba que el jugador este activo y tenga un saldo mayor a 0
                if (this.getJugador(turnoJugadorParcial).getActivo() && this.getSaldoJugador(turnoJugadorParcial) > 0) {
                    //
                    if(turnoJugadorParcial == 0){
                        //TODO No se puede apostar muchisimo porque si no los bots se tiran
                        apuestaJugador = gesJug.leerYValidarApuesta(turnoJugadorParcial, apuestaMinima, this);
                    }else{
                        apuestaJugador = gesJug.calcularApostarBot(apuestaMinima,this,turnoJugadorParcial);
                    }

                    //Evaluar las apuestas
                    if ((apuestaJugador+this.getApuestaJugador(turnoJugadorParcial,ronda)) == apuestaMinima){
                        System.out.println("El jugador "+this.getUsuarioJugador(turnoJugadorParcial)+" ha igualado la apuesta a: "+(apuestaJugador+this.getApuestaJugador(turnoJugadorParcial,ronda)));
                        //En el caso de que el jugador iguale la apuesta se le resta la apuesta realizada
                        this.jugadores[turnoJugadorParcial].disminuirDinero(apuestaJugador);
                        //Se le incrementa la apuesta en la ronda
                        if (!(this.incrementarApuesta(turnoJugadorParcial,ronda,apuestaJugador))){
                            System.out.println("No se ha podido incrementar la apuesta");
                        }

                    }else{
                        if ((apuestaJugador+this.getApuestaJugador(turnoJugadorParcial,ronda)) > apuestaMinima){
                            System.out.println("El jugador "+this.getUsuarioJugador(turnoJugadorParcial)+" ha subido la apuesta a: "+(apuestaJugador+this.getApuestaJugador(turnoJugadorParcial,ronda)));
                            //En el caso de que el jugador suba la apuesta se le resta la apuesta realizada
                            this.jugadores[turnoJugadorParcial].disminuirDinero(apuestaJugador);
                            //Se le incrementa la apuesta en la ronda
                            if (!(this.incrementarApuesta(turnoJugadorParcial,ronda,apuestaJugador))){
                                System.out.println("No se ha podido incrementar la apuesta");
                            }
                            //Se guarda su posicion para volver a recorrer el array hasta que llegue a su posicion y asi poder tirar todos los jugadores
                            turnoJugadorFinal = turnoJugadorParcial;
                            //Se coloca su apuesta como apuesta minima para los demas jugadores
                            apuestaMinima = apuestaJugador;
                        }else{
                            //No hace falta comprobar que sea menor porque ya esta comprobado en los if de arriba
                            //En este caso se controla que el jugador haga all-in pero no llegue a la apuesta minima
                            if (this.jugadores[turnoJugadorParcial].getSaldo() == apuestaJugador){
                                System.out.println("El jugador "+this.getUsuarioJugador(turnoJugadorParcial)+" ha hecho allIn sin llegar al minimo con: "+(apuestaJugador+this.getApuestaJugador(turnoJugadorParcial,ronda)));
                                this.jugadores[turnoJugadorParcial].disminuirDinero(apuestaJugador);
                                //Coloca allInMejor en true para despues poder evaluar los ganadores
                                this.jugadores[turnoJugadorParcial].setAllInMenor(true);
                                if (!(this.incrementarApuesta(turnoJugadorParcial,ronda,apuestaJugador))){
                                    System.out.println("No se ha podido incrementar la apuesta");
                                }
                            }else{  //Este es el caso de que el jugador se tire
                                System.out.println("El jugador "+this.getUsuarioJugador(turnoJugadorParcial)+" se ha tirado.");
                                this.jugadores[turnoJugadorParcial].setActivo(false);
                            }
                        }
                    }
                }
                turnoJugadorParcial = (turnoJugadorParcial == 4)?0:++turnoJugadorParcial;


                try {
                    Thread.sleep(2*1000);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        this.ronda++;
        return quedanJugadores;
    }

    /**
     * This method return a String with attributes of the table
     * @return String with attributes of the table
     */

    @SuppressWarnings("StringConcatenationInLoop")
    @Override
    public String toString(){
        String stringBaraja = "",stringJugadores = "",stringCartasMesa = "", stringApuestas = "";

        for (CartaImpl carta : baraja) {
            stringBaraja += carta.toString() + "\n";
        }

        for (JugadorImpl jugadore : jugadores) {
            stringJugadores += jugadore.toString() + "\n";
        }

        for (CartaImpl carta : cartasMesa) {
            stringCartasMesa += carta.toString() + "\n";
        }

        for (int i = 0; i<apuestasJugadores.length;i++){
            stringApuestas += "Apuestas jugador "+i+": ";
            for (int j = 0; j<apuestasJugadores[i].length;j++){
                stringApuestas += apuestasJugadores[i][j]+",";
            }
            stringApuestas += "\n";
        }

        return stringBaraja+"\n"+stringJugadores+"\n"+stringCartasMesa+"\n"+stringApuestas;

    }

    /**
     * This method return an int with value of hashCode of the table
     * @return int with value of hashCode of the table
     */

    @Override
    public int hashCode(){
        //noinspection ArrayHashCode
        return this.getTotalApuestas()+this.getJugadores().hashCode();
    }

    /**
     * This method return a Boolean value depending on whether the value of the table passed by parameter is equal to that compared
     * @param objeto An object with which you want to check if they are the same
     * @return boolean its value depending on whether the value of the table passed by parameter is equal to that compared
     */

    @Override
    public boolean equals(Object objeto){
        boolean resul = false;
        if (this == objeto){
            resul = true;
        }else{
            //noinspection ConditionCoveredByFurtherCondition
            if (objeto != null && objeto instanceof MesaImpl){
                MesaImpl nueva = (MesaImpl) objeto;
                if (this.getBaraja()==nueva.getBaraja()
                        && this.getCartasMesa()==nueva.getCartasMesa()
                        && this.getJugadores()==nueva.getJugadores()
                        && this.getApuestasJugadores()==nueva.getApuestasJugadores()){
                    resul = true;
                }
            }
        }
        return resul;
    }

    /**
     * This method return a object MesaImpl cloned from which it is called
     * @return MesaImpl Cloned table
     */

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    @Override
    public MesaImpl clone() {
        MesaImpl mesa = new MesaImpl();
        for (int i = 0;i<mesa.baraja.length;i++){
            mesa.baraja[i] = this.baraja[i].clone();
        }

        for (int i = 0;i<mesa.jugadores.length;i++){
            mesa.jugadores[i] = this.jugadores[i].clone();
        }

        for (int i = 0;i<mesa.cartasMesa.length;i++){
            mesa.cartasMesa[i] = this.cartasMesa[i].clone();
        }

        for (int i = 0;i<mesa.cartasMesa.length;i++){
            System.arraycopy(this.apuestasJugadores[i],0,mesa.apuestasJugadores[i],0,5);
        }

        mesa.turnoJugador = this.turnoJugador;
        mesa.ronda = this.ronda;

        return mesa;
    }

}
