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
 * public int getApuestaTotal();
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


    public MesaImpl(){
        this.baraja = new CartaImpl[52];
        this.jugadores = new JugadorImpl[5];
        this.cartasMesa = new CartaImpl[5];
        this.apuestasJugadores = new int[5][5];
    }

    public MesaImpl(CartaImpl[] baraja, JugadorImpl[] jugadores, CartaImpl[] cartas, int[][] apuestasJugadores){
        this.baraja = baraja;
        this.jugadores = jugadores;
        this.cartasMesa = cartas;
        this.apuestasJugadores = apuestasJugadores;
    }

    public MesaImpl(MesaImpl otro){
        this.baraja = otro.getBaraja();
        this.jugadores = otro.getJugadores();
        this.cartasMesa = otro.getCartasMesa();
        this.apuestasJugadores = otro.getApuestasJugadores();
    }

    public CartaImpl[] getBaraja(){
        return this.baraja;
    }

    public void setBaraja(CartaImpl[] baraja){
        this.baraja = baraja;
    }

    public JugadorImpl[] getJugadores(){
        return this.jugadores;
    }

    public void setJugadores(JugadorImpl[] jugadores){
        this.jugadores = jugadores;
    }

    public CartaImpl[] getCartasMesa(){
        return this.cartasMesa;
    }

    public void setCartasMesa(CartaImpl[] cartas){
        this.cartasMesa = cartas;
    }

    public int[][] getApuestasJugadores(){
        return this.apuestasJugadores;
    }

    public void setApuestasJugadores(int[][] apuestas){
        this.apuestasJugadores = apuestas;
    }

    public int getApuestaTotal(){
        int total = 0;
        for (int i = 0; i<this.apuestasJugadores.length; i++){
            for (int j = 0; j<this.apuestasJugadores.length; j++){
                total += this.apuestasJugadores[i][j];
            }
        }
        return total;
    }

    //TODO DOCUMENTAR METODOS RAROS

    //METODOS ANHADIDOS

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

    public void restaurarBaraja(){

        //TODO Mejorar esta parte y hacerla mas eficiente

        this.baraja[0] = new CartaImpl('P', "A");
        this.baraja[1] = new CartaImpl('P', "2");
        this.baraja[2] = new CartaImpl('P', "3");
        this.baraja[3] = new CartaImpl('P', "4");
        this.baraja[4] = new CartaImpl('P', "5");
        this.baraja[5] = new CartaImpl('P', "6");
        this.baraja[6] = new CartaImpl('P', "7");
        this.baraja[7] = new CartaImpl('P', "8");
        this.baraja[8] = new CartaImpl('P', "9");
        this.baraja[9] = new CartaImpl('P', "10");
        this.baraja[10] = new CartaImpl('P', "J");
        this.baraja[11] = new CartaImpl('P', "Q");
        this.baraja[12] = new CartaImpl('P', "K");

        this.baraja[13] = new CartaImpl('C', "A");
        this.baraja[14] = new CartaImpl('C', "2");
        this.baraja[15] = new CartaImpl('C', "3");
        this.baraja[16] = new CartaImpl('C', "4");
        this.baraja[17] = new CartaImpl('C', "5");
        this.baraja[18] = new CartaImpl('C', "6");
        this.baraja[19] = new CartaImpl('C', "7");
        this.baraja[20] = new CartaImpl('C', "8");
        this.baraja[21] = new CartaImpl('C', "9");
        this.baraja[22] = new CartaImpl('C', "10");
        this.baraja[23] = new CartaImpl('C', "J");
        this.baraja[24] = new CartaImpl('C', "Q");
        this.baraja[25] = new CartaImpl('C', "K");

        this.baraja[26] = new CartaImpl('R', "A");
        this.baraja[27] = new CartaImpl('R', "2");
        this.baraja[28] = new CartaImpl('R', "3");
        this.baraja[29] = new CartaImpl('R', "4");
        this.baraja[30] = new CartaImpl('R', "5");
        this.baraja[31] = new CartaImpl('R', "6");
        this.baraja[32] = new CartaImpl('R', "7");
        this.baraja[33] = new CartaImpl('R', "8");
        this.baraja[34] = new CartaImpl('R', "9");
        this.baraja[35] = new CartaImpl('R', "10");
        this.baraja[36] = new CartaImpl('R', "J");
        this.baraja[37] = new CartaImpl('R', "Q");
        this.baraja[38] = new CartaImpl('R', "K");

        this.baraja[39] = new CartaImpl('T', "A");
        this.baraja[40] = new CartaImpl('T', "2");
        this.baraja[41] = new CartaImpl('T', "3");
        this.baraja[42] = new CartaImpl('T', "4");
        this.baraja[43] = new CartaImpl('T', "5");
        this.baraja[44] = new CartaImpl('T', "6");
        this.baraja[45] = new CartaImpl('T', "7");
        this.baraja[46] = new CartaImpl('T', "8");
        this.baraja[47] = new CartaImpl('T', "9");
        this.baraja[48] = new CartaImpl('T', "10");
        this.baraja[49] = new CartaImpl('T', "J");
        this.baraja[50] = new CartaImpl('T', "Q");
        this.baraja[51] = new CartaImpl('T', "K");

    }

    public JugadorImpl obtenerJugador(int posicion){
        return this.jugadores[posicion];
    }

    public void anhadirJugador(int posicion, JugadorImpl jugador){
        this.jugadores[posicion] = jugador;
    }

    public void anhadirApuesta(int jugador, int rondaApuesta, int cantidad){
        this.apuestasJugadores[jugador][rondaApuesta] = cantidad;
    }

    public int obtenerApuesta(int jugador, int rondaApuesta){
        return this.apuestasJugadores[jugador][rondaApuesta];
    }


    //TODO Sobreescribir metodos heredados



}
