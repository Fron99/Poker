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
 * private void setJugadorMesa(int posicionJugador, JugadorImpl jugador);
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

import Clases.Gestoras.GestoraJugadorImpl;
import Clases.Interfaces.Mesa;

import java.util.ArrayList;
import java.util.Random;

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

    }

    /**
     * Return array of attribute "baraja"
     * @return CartaImpl[] array of attribute "baraja"
     */

    public CartaImpl[] getBaraja(){
        CartaImpl[] baraja = new CartaImpl[this.baraja.length];
        //TODO Comprobar
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
     * Return the card of the index in the array "baraja"
     * @return CartaImpl card that you want get
     * @param indice index of the card of you will want return
     */

    public CartaImpl getCartaBaraja(int indice){    //TODO Controlar que no se salga del rango
        return this.baraja[indice].clone();
    }

    /**
     * Set value of the card that index with the card passed by parameter
     * @param baraja new value of attribute "baraja"
     * @param indice index of the card that will be changed the value
     */

    private void setCartaBaraja(CartaImpl baraja, int indice){  //TODO Controlar que no se salga del rango
        this.baraja[indice] = baraja;
    }

    /**
     * @param indiceBaraja
     * @return
     */

    public String getNumeroCartaBaraja(int indiceBaraja){   //TODO Controlar indice
        return this.baraja[indiceBaraja].getNumero();
    }

    /**
     * @param indiceBaraja
     * @return
     */

    public char getPaloCartaBaraja(int indiceBaraja){   //TODO Controlar indice
        return this.baraja[indiceBaraja].getPalo();
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
        this.jugadores = jugadores;
    }

    /**
     * This method returns the player of the position passed by parameter
     * @param posicion position of the player you want to get
     * @return JugadorImpl player yo want to get
     */

    public JugadorImpl getJugador(int posicion){    //TODO Controlar que no se salga del rango
        return this.jugadores[posicion];    //TODO Hacer con clone
    }

    /**
     * This method adds the player or parameter passed to the array of players
     * @param posicion position where the player wants to add
     * @param jugador player you want to add
     */

    private void setJugadorMesa(int posicion, JugadorImpl jugador){ //TODO Controlar que no se salga del rango
        this.jugadores[posicion] = jugador;
    }

    /**
     * @param posicionJugador
     * @return
     */

    public String getUsuarioJugador(int posicionJugador){   //TODO Controlar que no se salga del rango
        return this.jugadores[posicionJugador].getUsuario();
    }

    /**
     * @param posicionJugador
     * @return
     */

    public int getSaldoJugador(int posicionJugador){    //TODO Controlar que no se salga del rango
        return this.jugadores[posicionJugador].getSaldo();
    }

    /**
     * @param posicionJugador
     * @param saldo
     */

    private void setSaldoJugador(int posicionJugador, int saldo){   //TODO Controlar que no se salga del rango
        this.jugadores[posicionJugador].setSaldo(saldo);
    }

    /**
     * Return array with cards of player
     * @param jugador int of the player
     * @return JugadorImpl[] array of attribute "jugadores"
     */

    private CartaImpl[] getCartasJugador(int jugador){  //TODO Controlar que no se salga del rango
        CartaImpl[] cartasJugador = new CartaImpl[2];
        System.arraycopy(this.jugadores[jugador].getCartas(),0,cartasJugador,0,this.jugadores[jugador].getCartas().length);
        return cartasJugador;
    }

    /**
     * Add cards passed by parameter to the player
     * @param jugador int position of player where do you want add the cards passed by parameter
     * @param cartas CartaImpl[] with the cards you want to add to the player
     */

    private void setCartasJugador(int jugador, CartaImpl[] cartas){ //TODO Controlar que no se salga del rango
        this.jugadores[jugador].setCartas(cartas);
    }

    /**
     * @param jugador
     * @param carta
     * @return
     */

    public CartaImpl getCartaJugador(int jugador,int carta){    //TODO Controlar que no se salga del rango
        return this.jugadores[jugador].getCartas()[carta];
    }

    /**
     * @param jugador
     * @param carta
     * @return
     */

    public char getPaloCartaJugador(int jugador,int carta){    //TODO Controlar que no se salga del rango
        return this.jugadores[jugador].getCartas()[carta].getPalo();
    }

    /**
     * @param jugador
     * @param carta
     * @return
     */

    public String getNumeroCartaJugador(int jugador,int carta){    //TODO Controlar que no se salga del rango
        return this.jugadores[jugador].getCartas()[carta].getNumero();
    }

    /**
     * @param jugador
     * @param posCarta
     * @param carta
     */

    private void setCartaJugador(int jugador,int posCarta, CartaImpl carta){    //TODO Controlar que no se salga del rango
        this.jugadores[jugador].setCarta(posCarta, carta);
    }

    /**
     * @param posicionJugador
     * @return
     */

    public boolean getActivoJugador(int posicionJugador){   //TODO Controlar que no se salga del rango
        return this.jugadores[posicionJugador].getActivo();
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
     * @param indiceCarta
     * @return
     */

    public CartaImpl getCartaMesa(int indiceCarta){     //TODO Controlar que no se salga del rango
        return this.cartasMesa[indiceCarta].clone();        //todo Comprobar si el clone hace una copia por referencia.
    }

    /**
     * This method add the carte passed by parameter to array of letters of table in the position passed by parameter
     * @param indiceCarta position where the card is added
     * @param carta carte to add
     */

    private void setCartaMesa(int indiceCarta, CartaImpl carta){    //TODO Controlar que no se salga del rango
        this.cartasMesa[indiceCarta] = carta;
    }

    /**
     * @param indiceMesa
     * @return
     */

    public String getNumeroCartaMesa(int indiceMesa){   //TODO Controlar indice
        return this.cartasMesa[indiceMesa].getNumero();
    }

    /**
     * @param indiceMesa
     * @return
     */

    public char getPaloCartaMesa(int indiceMesa){   //TODO Controlar indice
        return this.cartasMesa[indiceMesa].getPalo();
    }

    /**
     * This method return array of attribute "apuestasJugadores"
     * @return int[][] array of attribute "apuestasJugadores"
     */

    public int[][] getApuestasJugadores(){
        int[][] apuestas = new int[5][5];
        for(int i = 0;i<apuestasJugadores.length;i++){
            for(int j = 0;j<apuestasJugadores.length;j++){
                apuestas[i][j] = apuestasJugadores[i][j];
            }
        }
        //TODO
        //System.arraycopy(this.apuestasJugadores,0,apuestas,0,this.apuestasJugadores.length);
        return apuestas;
    }

    /**
     * Set array passed by parameter in attribute "apuestasJugadores"
     * @param apuestas new value of attribute "apuestas"
     */

    private void setApuestasJugadores(int[][] apuestas){
        this.apuestasJugadores = apuestas;
    }

    /**
     * @param indiceJugador
     * @return
     */

    public int[] getApuestasJugador(int indiceJugador){     //TODO Comprobar que no sea por referencia  //TODO Controlar que no se salga del rango
        int[] apuestasJugador = new int[this.apuestasJugadores[indiceJugador].length];
        System.arraycopy(this.apuestasJugadores[indiceJugador],0,apuestasJugador,0,this.apuestasJugadores[indiceJugador].length);
        return apuestasJugador;
    }

    /**
     * @param indiceJugador
     * @param apuestas
     */

    private void setApuestasJugador(int indiceJugador, int[] apuestas){     //TODO Controlar que no se salga del rango
        this.apuestasJugadores[indiceJugador] = apuestas;
    }

    /**
     * Get user bet in an exact round
     * @param jugador int index of the user you want get bet
     * @param rondaApuesta int index of the round you want get bet
     * @return int bet of the user in the round
     */

    public int getApuestaJugador(int jugador, int rondaApuesta){    //TODO Controlar que no se salga del rango
        return this.apuestasJugadores[jugador][rondaApuesta];
    }

    /**
     * @param jugador
     * @param ronda
     * @param apuestas
     */

    private void setApuestaJugador(int jugador,int ronda, int apuestas){    //TODO Controlar que no se salga del rango
        this.apuestasJugadores[jugador][ronda] = apuestas;
    }

    /**
     * Return value of sum all bets
     * @return int value of sum all bets
     */

    public int getTotalApuestas(){
        int total = 0;
        for (int i = 0; i<this.apuestasJugadores.length; i++){
            for (int j = 0; j<this.apuestasJugadores.length; j++){
                total += this.apuestasJugadores[i][j];
            }
        }
        return total;
    }

    /*
     * SIGNATURA: public void limpiarCartasMesa()
     * COMENTARIO: Coloca todas las cartas de la mesa con palo D y numero D
     * PRECONDICIONES: - Nada
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Un array de CartaImpl
     * POSTCONDICIONES: Modifica el array pasado por parametro colocando todas las cartas de la mesa con palo D y numero D
     */

    /**
     * Set all the table cards by default
     */

    public void limpiarCartasMesa(){
        for (int i = 0; i<this.cartasMesa.length; i++){
            this.cartasMesa[i] = new CartaImpl();
        }
    }

    /**
     *
     */

    public void cargarBaraja(){
        //TODO
    }

    /*
     * SIGNATURA: public void restaurarMesa();
     * COMENTARIO: Elimina todos los cambios que se hayan realizado sobre los atributos y lo coloca por defecto para empezar una partida nueva.
     * PRECONDICIONES: - Nada
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Modifica el valor de todos los atributos y los pone por defecto
     *
     */

    //TODO Revisar esto

    /**
     *
     */

    public void restaurarMesa(){
        limpiarMesa();
        restaurarBaraja();
        colocarJugadoresActivos();
        generarCartasJugadores();
        this.ronda = 0;
    }

    /*
     * SIGNATURA: public void colocarJugadoresActivos()
     * COMENTARIO: Metodo para colocar todos los jugadores de la mesa activos
     * PRECONDICIONES: - Nada
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Coloca todos los jugadores del array jugadores de la mesa en activo.
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
     * SIGNATURA:
     * COMENTARIO:
     * PRECONDICIONES: -
     * ENTRADA: -
     * SALIDA: -
     * ENTRADA/SALIDA: -
     * POSTCONDICIONES: -
     */

    //TODO  Desarrollar javadoc
    //TODO Comprobar si deberia ser private

    public void ingresarSaldoGanadores(){

        //TODO

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
     * Draw 2 cards for each player and assign them to them
     */

    public void generarCartasJugadores() {

        Random r = new Random();
        int numPosicionCarta;

        numPosicionCarta = r.nextInt(52);

        //TODO Revisar este bucle, puede que este mal
        //TODO Comentar mas el codigo

        for (int i = 0; i<this.jugadores.length;i++){
            for (int j = 0; j<2; j++){
                do {
                    if (baraja[numPosicionCarta].getPalo() != 'D') {    //Comprueba si la carta seleccionada de la baraja no ha salido ya (Que es cuando esta por defecto)
                        //En el caso de que no haya salido se le asigna al jugador y se coloca por defecto en la baraja
                        this.setCartaJugador(i,j,baraja[numPosicionCarta]);
                        baraja[numPosicionCarta] = new CartaImpl();
                    }
                    numPosicionCarta = r.nextInt(52);
                } while (baraja[numPosicionCarta].getPalo() == 'D');
            }
        }

    }

    /*
     * SIGNATURA: public void generarCartaMesa();
     * COMENTARIO: Saca 1 cartas de la baraja y las coloca en el array de cartas de la mesa del objeto
     * PRECONDICIONES: - Nada
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Coloca la carta que haya sacado por defecto en la baraja y la coloca en la mesa
     */

    /**
     * Draw 1 cards of deck of cards and put this in array of cards from the object
     */

    public void generarCartaMesa() {

        Random r = new Random();
        int numPosicionCarta, indiceCartaGenerar = 0;

        numPosicionCarta = r.nextInt(52);

        //Calcula cual es la siguiente carta sin levantar y guarda el indice
        for (int i = 0; i < this.cartasMesa.length && this.cartasMesa[i].getPalo() != 'D'; i++) {
            if ((i + 1) <= this.cartasMesa.length) {
                if (this.cartasMesa[i + 1].getPalo() == 'D') {
                    indiceCartaGenerar = i + 1;
                }
            }
        }

        //Guarda la carta que se ha sacado de la baraja en las cartas de la mesa
        do {
            if (this.baraja[numPosicionCarta].getPalo() != 'D') {
                this.cartasMesa[indiceCartaGenerar] = this.baraja[numPosicionCarta];
                this.baraja[numPosicionCarta] = new CartaImpl();
            }
            numPosicionCarta = r.nextInt(52);
        } while (this.baraja[numPosicionCarta].getPalo() == 'D');

    }

    /*
     * SIGNATURA: public void cargarBots();
     * COMENTARIO: Carga un array pasado por parametros con jugadores aleatorios
     * PRECONDICIONES: - El array debe ser de JugadorImpl
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Array de JugadorImpl
     * POSTCONDICIONES: - Modifica el array de Jugadores pasado por parametro añadiendo usuarios aleatorios
     *
     */

    //TODO Desarrollar javadoc
    //TODO Comprobar si deberia ser private

    public void cargarBots(){

        Random random = new Random();
        String[] nombresAleatorios = {"Kun","Wang","YanYan","Zhao","Yun","Sasha","Volodia","Hedeon","Grigory"};
        for (int i = 1; i<jugadores.length;i++){
            this.jugadores[i] = new JugadorImpl(nombresAleatorios[random.nextInt(8)],jugadores[0].getSaldo());
        }

    }

    /*
     * SIGNATURA: public void restaurarBaraja()
     * COMENTARIO: Anhade todas las cartas posibles al array pasado por parametro
     * PRECONDICIONES: - El array debe tener como minimo 52 campos
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: Modifica el array pasado por parametro anhadiendo todas las cartas posibles
     */

    /**
     * Place all possible cards in the deck in an array
     */

    public void restaurarBaraja(){

        char[] palos = new char[]{'P','C','R','T'};
        String[] numeros = new String[]{"A","2","3","4","5","6","7","8","9","10","J","Q","K"};

        for (int i = 0, contador = 0;i<palos.length;i++){
            for (String numero : numeros) {
                this.baraja[contador++] = new CartaImpl(palos[i], numero);
            }
        }

    }

    /*
     * SIGNATURA: public void limpiarMesa()
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

    public void limpiarMesa() {
        for (int i = 0; i < this.getCartasMesa().length; i++) {
            this.getCartasMesa()[i] = new CartaImpl();
        }
        for (int i = 0; i < this.getApuestasJugadores().length; i++) {
            for (int j = 0; j < this.getApuestasJugadores().length; j++) {
                this.getApuestasJugadores()[i][j] = 0;
            }
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
     * SIGNATURA: public int[] obtenerGanadores()
     * COMENTARIO: Calcula quienes son los ganadores de la partida
     * PRECONDICIONES: - Nada
     * ENTRADA: - Nada
     * SALIDA: - Un array de enteros
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un array con la posicion de los ganadores
     */

    //TODO Hacer metodo

    /**
     * Calculate and return the positions of the game winners.
     * @return int[] array with position in array of winner
     */

    public int[] obtenerGanadores(){
        int[] cantGanadores = {0,0,0};

        //Calcular posibles ganadores
        ArrayList<Integer> posiblesGanadores = new ArrayList<>();
        JugadorImpl[] jugadores = this.jugadores;
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i].getActivo()){
                posiblesGanadores.add(i);
            }
        }

        return cantGanadores;
    }

    /*
     * SIGNATURA: public void ingresarDineroGanador(int ganador);
     * COMENTARIO: Aumenta el saldo del usuario ganador de la mano
     * PRECONDICIONES: - El ganador no puede ser menor de 0 ni mayor de 5
     * ENTRADA: - Un entero con el ganador
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Un objeto mesa
     * POSTCONDICIONES: - Modifica el objeto mesa incrementando el saldo del usuario ganador con el total de apuestas de la mano jugada.
     *
     */

    //TODO Hacer metodo

    /**
     * @param ganador
     */

    public void ingresarDineroGanador(int ganador) {
        int cantidadMesa;
        cantidadMesa = this.getTotalApuestas();
        this.jugadores[ganador].aumentarDinero(cantidadMesa);
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

    //TODO Implementar que no haya diferencias si hay mas de x dinero o si el nombre es mayor o menor

    /**
     *  Print in screen the table with all properties of users and the carts depending on the turn
     */

    public void mostrarPanelJuego() {

        String[][] numerosCartasJugadores = new String[5][2];
        for (int i = 0;i<numerosCartasJugadores.length;i++){
            for (int j = 0;j<numerosCartasJugadores[i].length;j++){
                numerosCartasJugadores[i][j] = this.getNumeroCartaJugador(i,j);
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
            usersJugadores[i] = this.getUsuarioJugador(i);;
        }

        int[] saldoJugadores = new int[5];
        for (int i = 0; i<saldoJugadores.length;i++){
            saldoJugadores[i] = this.getSaldoJugador(i);
        }

        char[] palosCartasMesa = new char[5];
        for (int i = 0; i<palosCartasMesa.length;i++){
            palosCartasMesa[i] = this.getPaloCartaMesa(i);
        }

        String[] numerosCartasMesa = new String[5];
        for (int i = 0; i<numerosCartasMesa.length;i++){
            numerosCartasMesa[i] = this.getNumeroCartaMesa(i);
        }


        System.out.println("                                      " + usersJugadores[2] + "                                                         " + usersJugadores[3]);
        System.out.println();
        System.out.println("                                      " + saldoJugadores[2] + "€                                                              " + saldoJugadores[3] + "€");
        System.out.println("                                      |º º|     -----        -----                                    |º º|    -----        -----");
        System.out.println("                                      |---|    | "+(this.ronda==4?palosCartasJugadores[2][0]:"?")+"   |      | "+(this.ronda==4?palosCartasJugadores[2][1]:"?")+"   |                                   |---|   | "+(this.ronda==4?palosCartasJugadores[3][0]:"?")+"   |      | "+(this.ronda==4?palosCartasJugadores[3][1]:"?")+"   |  ");
        System.out.println("                                               | "+(this.ronda==4?numerosCartasJugadores[2][0]:"?")+"   |      | "+(this.ronda==4?numerosCartasJugadores[2][1]:"?")+"   |                                           | "+(this.ronda==4?numerosCartasJugadores[3][0]:"?")+"   |      | "+(this.ronda==4?numerosCartasJugadores[3][1]:"?")+"   |");
        System.out.println("                                                -----        -----                                             -----        -----");



        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("       " + usersJugadores[1] + "                                                                                                                              " + usersJugadores[4]);
        System.out.println("                                                        ----- " + "       " + " ----- " + "       " + " ----- " + "       " + " ----- " + "       " + " ----- ");
        System.out.println("       " + saldoJugadores[1] + "€                                              | " + palosCartasMesa[0] + "   |" + "       " + "| " + palosCartasMesa[1] + "   |" + "       " + "| " + palosCartasMesa[2] + "   |" + "       " + "| " + palosCartasMesa[3] + "   |" + "       " + "| " + palosCartasMesa[4] + "   |                      " + saldoJugadores[4] + "€");
        System.out.println("       |º º|       -----        -----                  | " + numerosCartasMesa[0] + "   |" + "       " + "| " + numerosCartasMesa[1] + "   |" + "       " + "| " + numerosCartasMesa[2] + "   |" + "       " + "| " + numerosCartasMesa[3] + "   |" + "       " + "| " + numerosCartasMesa[4] + "   |                      |º º|      -----        -----");
        System.out.println("       |---|      | "+(this.ronda==4?palosCartasJugadores[1][0]:"?")+"   |      | "+(this.ronda==4?palosCartasJugadores[1][1]:"?")+"   |                 |     |" + "       " + "|     |" + "       " + "|     |" + "       " + "|     |" + "       " + "|     |" + "                      |---|     | "+(this.ronda==4?palosCartasJugadores[4][0]:"?")+"   |      | "+(this.ronda==4?palosCartasJugadores[4][1]:"?")+"   |");
        System.out.println("                  | "+(this.ronda==4?numerosCartasJugadores[1][0]:"?")+"   |      | "+(this.ronda==4?numerosCartasJugadores[1][1]:"?")+"   |                  ----- " + "       " + " ----- " + "       " + " ----- " + "       " + " ----- " + "       " + " -----                                 | "+(this.ronda==4?numerosCartasJugadores[4][0]:"?")+"   |      | "+(this.ronda==4?numerosCartasJugadores[4][1]:"?")+"   |");
        System.out.println("                   -----        -----                                                                                                                  -----        -----");

        System.out.println();
        System.out.println("                                                              DINERO EN MESA: " + this.getTotalApuestas() + "€");
        System.out.println();
        System.out.println();

        System.out.println("                                                                 " + usersJugadores[0]);
        System.out.println("                                                              TU SALDO ES: " + saldoJugadores[0] + "€");
        System.out.println();
        System.out.println("                                                           _______________________");
        System.out.println("                                                          |                       |");
        System.out.println("                                                          |    __           __    |");
        System.out.println("                                                          |   |º |         |º |   |            ----------           ----------");
        System.out.println("                                                          |    --           --    |           | "+palosCartasJugadores[0][0]+"        |         | "+palosCartasJugadores[0][1]+"        |");
        System.out.println("                                                          |                       |           | "+numerosCartasJugadores[0][0]+"        |         | "+numerosCartasJugadores[0][1]+"        |");
        System.out.println("                                                          |   \\              /    |           |          |         |          |");
        System.out.println("                                                          |     \\___________/     |           |          |         |          |");
        System.out.println("                                                          |                       |            ----------           ----------");
        System.out.println("                                                           -----------------------");
        System.out.println();

    }

    /**
     * Add user bet in an exact round
     * @param jugador int index of the user you want set bet
     * @param rondaApuesta int index of the round you want set bet
     * @param cantidad int amount to add
     */

    //TODO Comprobar si puede ser privado

    public void incrementarApuesta(int jugador, int rondaApuesta, int cantidad){
        this.apuestasJugadores[jugador][rondaApuesta] += cantidad;
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
     *                              mesa.incrementarApuesta(turnoJugador,ronda,apuestaJugador)
     *                          sino
     *                              si(apuestaJugador > apuestaMinima)
     *                                  cantidadJugadas += 4
     *                                  jugador.disminuirSaldo(apuestaJugador)
     *                                  mesa.incrementarApuesta(turnoJugador,ronda,apuestaJugador)
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

    public void realizarApuestas(){
        GestoraJugadorImpl gesJug = new GestoraJugadorImpl();
        int apuestaMinima = 0, cantidadJugadas = 0, totalJugadas = 5, apuestaJugador, cantidadJugadoresPasan = 0;
        boolean jugadorPasa = false;
        for (JugadorImpl jugador: this.getJugadores()) {
            if (!jugador.getActivo()){
                cantidadJugadoresPasan ++;
            }
        }
        if (cantidadJugadoresPasan != 4) {
            if (this.getJugador(this.turnoJugador).getActivo() && this.getJugador(this.turnoJugador).getSaldo() > 0) {
                if (this.turnoJugador == 0){
                    apuestaJugador = gesJug.leerYValidarApuesta(this.getJugador(this.turnoJugador), apuestaMinima);
                }else{
                    apuestaJugador = gesJug.calcularApostarBot(apuestaMinima,this,this.turnoJugador,this.ronda);
                }
                if (apuestaJugador > apuestaMinima) {
                    apuestaMinima = apuestaJugador;
                    this.incrementarApuesta(this.turnoJugador, this.ronda, apuestaMinima);
                    this.getJugador(this.turnoJugador).disminuirDinero(apuestaMinima);
                } else {
                    //Si el jugador apuesta el mismo valor que la apuesta minima (es decir 0) significa que pasa
                    if (apuestaJugador == apuestaMinima) {
                        jugadorPasa = true;
                    }
                }
            }
            cantidadJugadas++;
            if (this.turnoJugador == 4 && cantidadJugadas < totalJugadas) {
                this.turnoJugador = 0;
            } else {
                this.turnoJugador++;
            }
            while (turnoJugador < 5 && cantidadJugadas < totalJugadas) {
                if (this.getJugador(this.turnoJugador).getActivo() && this.getJugador(this.turnoJugador).getSaldo() > 0) {
                    if (this.turnoJugador == 0){
                        apuestaJugador = gesJug.leerYValidarApuesta(this.getJugador(this.turnoJugador),apuestaMinima);
                    }else{
                        apuestaJugador = gesJug.calcularApostarBot(apuestaMinima, this, this.turnoJugador,this.ronda);
                        //TODO En el caso de querer apostar y no poder por no llegar al minimo que haga all-in  (Creo que ya esta solucionado pero tengo que comprobarlo)
                    }
                    if (apuestaJugador != apuestaMinima || jugadorPasa) {
                        jugadorPasa = false;
                        if (apuestaJugador == 0) {
                            this.getJugador(this.turnoJugador).setActivo(false);
                        } else {
                            if (apuestaJugador > apuestaMinima) {
                                apuestaMinima = apuestaJugador;
                                if ((totalJugadas-cantidadJugadas) < 5){
                                    totalJugadas += 4;
                                }else{
                                    totalJugadas++;
                                }
                                this.getJugador(this.turnoJugador).disminuirDinero(apuestaJugador);
                                this.incrementarApuesta(this.turnoJugador, this.ronda, apuestaJugador);
                            } else {
                                this.getJugador(this.turnoJugador).disminuirDinero(apuestaJugador);
                                this.incrementarApuesta(this.turnoJugador, this.ronda, apuestaJugador);
                            }
                        }
                    } else {
                        this.getJugador(this.turnoJugador).disminuirDinero(apuestaJugador);
                        this.incrementarApuesta(this.turnoJugador, this.ronda, apuestaJugador);
                    }
                }
                //Actualizamos variables despues de realizar jugada
                cantidadJugadas++;
                if (this.turnoJugador == 4 && cantidadJugadas < totalJugadas) {
                    this.turnoJugador = 0;
                } else {
                    this.turnoJugador++;
                }
            }
        }
        this.ronda++;
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
     * This method returns a Boolean value depending on whether the value of the table passed by parameter is equal to that compared
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
     * This method returns a object MesaImpl cloned from which it is called
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
