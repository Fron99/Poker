/*
 * PROPIEDADES BASICAS:
 *
 *  - cartasMesa: CartaImpl[5], Consultable, Modificable
 *  - totalApuestas: int, Consultable, Modificable
 *  - jugadores: JugadorImpl[5], Consultable, Modificable
 *
 * PROPIEDADES DERIVADAS:
 *
 *  - No hay
 *
 * PROPIEDADES COMPARTIDAS:
 *
 *  - No hay
 *
 * METODOS:
 *
 *  public CartaImpl[] getCartasMesa();
 *  public void setCartasMesa(CartaImpl[] cartas);
 *
 *  public int getTotalApuestas();
 *  public void setTotalApuestas(int totalApuestas);
 *
 *  public JugadorImpl[] getJugadores();
 *  public void setJugadores(JugadorImpl[] jugadores);
 *
 * METODOS AÑADIDOS:
 *
 *  public void anhadirCarta(int posicion, CartaImpl carta);
 *
 *  public void incrementarTotalApuestas(int cantidadIncrementar);
 *
 *  public JugadorImpl getJugador(int posicion);
 *  public void setJugador(int posicion, JugadorImpl jugador)
 *
 */

package Clases.Basicas;

import Clases.Interfaces.Mesa;

public class MesaImpl implements Mesa {

    private CartaImpl[] cartasMesa;
    private int totalApuestas;
    private JugadorImpl[] jugadores;

    public MesaImpl(){
        this.cartasMesa = new CartaImpl[5];
        this.totalApuestas = 0;
        this.jugadores = new JugadorImpl[5];
    }

    public MesaImpl(CartaImpl[] cartas, int totalApuestas, JugadorImpl[] jugadores){
        this.cartasMesa = cartas;
        this.totalApuestas = totalApuestas;
        this.jugadores = jugadores;
    }

    public MesaImpl(MesaImpl otro){
        this.cartasMesa = otro.getCartasMesa();
        this.totalApuestas = otro.getTotalApuestas();
        this.jugadores = otro.getJugadores();
    }

    public CartaImpl[] getCartasMesa(){
        return this.cartasMesa;
    }

    public void setCartasMesa(CartaImpl[] cartas){
        this.cartasMesa = cartas;
    }

    public int getTotalApuestas(){
        return this.totalApuestas;
    }

    public void setTotalApuestas(int totalApuestas){
        this.totalApuestas = totalApuestas;
    }

    public JugadorImpl[] getJugadores(){
        return this.jugadores;
    }

    public void setJugadores(JugadorImpl[] jugadores){
        this.jugadores = jugadores;
    }

    public void anhadirCarta(int posicion, CartaImpl carta){
        this.cartasMesa[posicion] = carta;
    }

    public void incrementarTotalApuestas(int cantidadIncrementar){
        this.totalApuestas += cantidadIncrementar;
    }

    public JugadorImpl obtenerJugador(int posicion){
        return this.jugadores[posicion];
    }

    public void anhadirJugador(int posicion, JugadorImpl jugador){
        this.jugadores[posicion] = jugador;
    }




}
