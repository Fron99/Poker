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
 */

package Clases.Basicas;

import Clases.Interfaces.Mesa;

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
     * ENTRADA/SALIDA: - Un array de CartaImpl
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
        this.apuestasJugadores[jugador][rondaApuesta] = cantidad;
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
