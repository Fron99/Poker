/*
 * PROPIEDADES BASICAS:
 *
 *  - baraja: CartaImpl[], Consultable, Modificable
 *  - jugadores: JugadorImpl[], Consultable, Modificable
 *  - cartasMesa: CartaImpl[], Consultable, Modificable
 *  - apuestasJugadores: int[][], Consultable, Modificable
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
 * public CartaImpl[] getCartasBaraja();
 * public void setCartasBaraja(CartaImpl[] baraja);
 *
 * public JugadorImpl[] getJugadores();
 * public void setJugadores(JugadorImpl[] jugadores);
 *
 * public CartaImpl[] getCartasMesa();
 * public void setCartasMesa(CartaImpl[] cartas);
 *
 * public int[][] getApuestasJugadores();
 * public void setApuestasJugadores(int[][] apuestas);
 *
 * public int getTotalApuestas();
 *
 * METODOS AÑADIDOS:
 *
 * public void anhadirCartaMesa(int posicion, CartaImpl carta);
 * public void limpiarCartasMesa();
 *
 * public void cargarBaraja();
 *
 * public JugadorImpl obtenerJugador(int posicion);
 * public void anhadirJugador(int posicion, JugadorImpl jugador)
 *
 * public void anhadirApuesta(int jugador, int rondaApuesta, int cantidad)
 * public int obtenerApuesta(int jugador, int rondaApuesta)
 *
 * public void limpiarMesa()
 *
 */

package Clases.Basicas;

import Clases.Interfaces.Mesa;

import java.util.Random;

public class MesaImpl implements Mesa {

    private CartaImpl[] baraja;
    private JugadorImpl[] jugadores;
    private CartaImpl[] cartasMesa;
    private int[][] apuestasJugadores;

    /**
     * This constructor places the default attributes
     */

    public MesaImpl(){
        this.baraja = new CartaImpl[52];
        this.jugadores = new JugadorImpl[5];
        this.cartasMesa = new CartaImpl[5];
        this.apuestasJugadores = new int[5][5];
    }

    /**
     * This constructor places the default attributes
     * @param baraja array of letters
     * @param jugadores array of players
     * @param cartas array of letters
     */

    public MesaImpl(CartaImpl[] baraja, JugadorImpl[] jugadores, CartaImpl[] cartas){
        this.baraja = baraja;
        this.jugadores = jugadores;
        this.cartasMesa = cartas;
        this.apuestasJugadores = new int[5][5];
    }

    /**
     * This constructor places the default attributes
     * @param baraja array of letters
     * @param jugadores array of players
     * @param cartas array of letters
     * @param apuestasJugadores array of int
     */

    public MesaImpl(CartaImpl[] baraja, JugadorImpl[] jugadores, CartaImpl[] cartas, int[][] apuestasJugadores){
        this.baraja = baraja;
        this.jugadores = jugadores;
        this.cartasMesa = cartas;
        this.apuestasJugadores = apuestasJugadores;
    }

    /**
     * This constructor places the default attributes
     * @param otro another mesa we want to copy their values ​​from
     */

    public MesaImpl(MesaImpl otro){
        this.baraja = otro.getBaraja();
        this.jugadores = otro.getJugadores();
        this.cartasMesa = otro.getCartasMesa();
        this.apuestasJugadores = otro.getApuestasJugadores();
    }

    /**
     * Return array of attribute "baraja"
     * @return CartaImpl[] array of attribute "baraja"
     */

    public CartaImpl[] getBaraja(){
        return this.baraja;
    }

    /**
     * Set array passed by parameter in attribute "baraja"
     * @param baraja new value of attribute "baraja"
     */

    public void setBaraja(CartaImpl[] baraja){
        this.baraja = baraja;
    }

    /**
     * Return array of attribute "jugadores"
     * @return JugadorImpl[] array of attribute "jugadores"
     */

    public JugadorImpl[] getJugadores(){
        return this.jugadores;
    }

    /**
     * Return array with cards of player
     * @param jugador int of the player
     * @return JugadorImpl[] array of attribute "jugadores"
     */

    //TODO Revisar

    public CartaImpl[] getCartasJugador(int jugador){
        return this.obtenerJugador(jugador).getCartas();
    }

    /**
     * Set array passed by parameter in attribute "jugadores"
     * @param jugadores new value of attribute "jugadores"
     */

    public void setJugadores(JugadorImpl[] jugadores){
        this.jugadores = jugadores;
    }

    /**
     * Return array of attribute "cartasMesa"
     * @return CartaImpl[] array of attribute "cartasMesa"
     */

    //TODO Revisar

    public CartaImpl[] getCartasMesa(){
        return this.cartasMesa;
    }

    /**
     * Set array passed by parameter in attribute "cartas"
     * @param cartas new value of attribute "cartas"
     */

    public void setCartasMesa(CartaImpl[] cartas){
        this.cartasMesa = cartas;
    }

    /**
     * Return array of attribute "apuestasJugadores"
     * @return int[][] array of attribute "apuestasJugadores"
     */

    public int[][] getApuestasJugadores(){
        return this.apuestasJugadores;
    }

    /**
     * Set array passed by parameter in attribute "apuestasJugadores"
     * @param apuestas new value of attribute "apuestas"
     */

    public void setApuestasJugadores(int[][] apuestas){
        this.apuestasJugadores = apuestas;
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

    //METODOS ANHADIDOS

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

    public void restaurarMesa(){
        limpiarMesa();
        restaurarBaraja();
        colocarJugadoresActivos();
        generarCartasJugadores();
    }


    /*
     * SIGNATURA: public void colocarJugadoresActivos(MesaImpl mesa)
     * COMENTARIO: Metodo para colocar todos los jugadores de la mesa activos
     * PRECONDICIONES: - Nada
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Un objeto MesaImpl
     * POSTCONDICIONES: - Modifica el objeto pasado por parametro colocando todos los jugadores en activo.
     */

    //TODO Revisar interfaz
    //TODO Desarrollar javadoc

    public void colocarJugadoresActivos(){
        for(JugadorImpl jugador: this.jugadores){
            jugador.setActivo(true);
        }
    }


    /*
     * SIGNATURA: public void generarCartasJugadores();
     * COMENTARIO: Saca dos cartas de la baraja para cada jugador y se las asigna a cada jugador
     * PRECONDICIONES: - Nada
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Modifica el array de la baraja colocando por defecto las cartas sacadas y modifica el objeto mesa
     *                      asignando las cartas a los jugadores de la mesa
     */

    //TODO Revisar interfaz
    //TODO Desarrollar javadoc

    public void generarCartasJugadores() {

        Random r = new Random();
        int numPosicionCarta;

        numPosicionCarta = r.nextInt(52);

        for (int i = 0; i<this.jugadores.length;i++){
            for (int j = 0; j<2; j++){
                do {
                    if (baraja[numPosicionCarta].getPalo() != 'D') {
                        //TODO Revisar no se hace asi, deberia hacerse con un set
                        this.getCartasJugador(i)[j] = baraja[numPosicionCarta];
                        baraja[numPosicionCarta] = new CartaImpl();
                    }
                    numPosicionCarta = r.nextInt(52);
                } while (baraja[numPosicionCarta].getPalo() == 'D');
            }
        }
    }


    /*
     * SIGNATURA: public void cargarJugadores(JugadorImpl[] jugadores);
     * COMENTARIO: Carga un array pasado por parametros con jugadores aleatorios
     * PRECONDICIONES: - El array debe ser de JugadorImpl
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Array de JugadorImpl
     * POSTCONDICIONES: - Modifica el array de Jugadores pasado por parametro añadiendo usuarios aleatorios
     *
     */

    //TODO Desarrollar javadoc

    public void cargarBots(){

        Random random = new Random();
        String[] nombresAleatorios = {"Kun","Wang","YanYan","Zhao","Yun","Sasha","Volodia","Hedeon","Grigory"};
        for (int i = 1; i<jugadores.length;i++){
            this.jugadores[i] = new JugadorImpl(nombresAleatorios[random.nextInt(8)],jugadores[0].getSaldo());
        }

    }

    /**
     * This method add the carte passed by parameter to array of letters of table in the position passed by parameter
     * @param posicion position where the card is added
     * @param carta carte to add
     */

    public void anhadirCartaMesa(int posicion, CartaImpl carta){
        this.cartasMesa[posicion] = carta;
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

        this.baraja[0] = new CartaImpl('P', "A");
        for (int i = 1, numero = 2; i<10;i++){
            this.baraja[i] = new CartaImpl('P', ""+numero);
            numero++;
        }
        this.baraja[10] = new CartaImpl('P', "J");
        this.baraja[11] = new CartaImpl('P', "Q");
        this.baraja[12] = new CartaImpl('P', "K");


        this.baraja[13] = new CartaImpl('C', "A");
        for (int i = 14, numero = 2; i<23;i++){
            this.baraja[i] = new CartaImpl('C', ""+numero);
            numero++;
        }
        this.baraja[23] = new CartaImpl('C', "J");
        this.baraja[24] = new CartaImpl('C', "Q");
        this.baraja[25] = new CartaImpl('C', "K");


        this.baraja[26] = new CartaImpl('R', "A");
        for (int i = 27, numero = 2; i<36;i++){
            this.baraja[i] = new CartaImpl('R', ""+numero);
            numero++;
        }
        this.baraja[36] = new CartaImpl('R', "J");
        this.baraja[37] = new CartaImpl('R', "Q");
        this.baraja[38] = new CartaImpl('R', "K");


        this.baraja[39] = new CartaImpl('T', "A");
        for (int i = 40, numero = 2; i<49;i++){
            this.baraja[i] = new CartaImpl('T', ""+numero);
            numero++;
        }
        this.baraja[49] = new CartaImpl('T', "J");
        this.baraja[50] = new CartaImpl('T', "Q");
        this.baraja[51] = new CartaImpl('T', "K");

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
    //TODO Revisar interfaz

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


    /**
     * This method returns the player of the position passed by parameter
     * @param posicion position of the player you want to get
     * @return JugadorImpl player yo want to get
     */

    public JugadorImpl obtenerJugador(int posicion){
        return this.jugadores[posicion];
    }

    /**
     * This method adds the player or parameter passed to the array of players
     * @param posicion position where the player wants to add
     * @param jugador player you want to add
     */

    public void anhadirJugador(int posicion, JugadorImpl jugador){
        this.jugadores[posicion] = jugador;
    }

    /**
     * Add user bet in an exact round
     * @param jugador int index of the user you want set bet
     * @param rondaApuesta int index of the round you want set bet
     * @param cantidad int amount to add
     */

    public void anhadirApuesta(int jugador, int rondaApuesta, int cantidad){
        this.apuestasJugadores[jugador][rondaApuesta] += cantidad;
    }

    /**
     * Add cards passed by parameter to the player
     * @param jugador int position of player where do you want add the cards passed by parameter
     * @param cartas CartaImpl[] with the cards you want to add to the player
     */

    public void anhadirCartasJugador(int jugador, CartaImpl[] cartas){
        this.jugadores[jugador].setCartas(cartas);
    }

    /**
     * Get user bet in an exact round
     * @param jugador int index of the user you want get bet
     * @param rondaApuesta int index of the round you want get bet
     * @return int bet of the user in the round
     */

    public int obtenerApuesta(int jugador, int rondaApuesta){
        return this.apuestasJugadores[jugador][rondaApuesta];
    }


    /**
     * This method return a String with attributes of the table
     * @return String with attributes of the table
     */

    @Override
    public String toString(){
        return this.getBaraja().toString()+"  "+this.getJugadores().toString()+"  "+this.getCartasMesa().toString()+"  "+this.getApuestasJugadores().toString();
    }

    /**
     * This method return an int with value of hashCode of the table
     * @return int with value of hashCode of the table
     */

    @Override
    public int hashCode(){
        return this.getTotalApuestas()+this.getJugadores().hashCode();
    }

    /**
     * This method returns a Boolean value depending on whether the value of the table passed by parameter is equal to that compared
     * @return boolean its value depending on whether the value of the table passed by parameter is equal to that compared
     */

    @Override
    public boolean equals(Object objeto){
        boolean resul = false;
        if (this == objeto){
            resul = true;
        }else{
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

    @Override
    public MesaImpl clone() {
        MesaImpl mesa = null;
        try {
            mesa = (MesaImpl) super.clone();
        } catch(CloneNotSupportedException error) {
            System.out.println("Error en la copia");
        }
        return mesa;
    }



}
