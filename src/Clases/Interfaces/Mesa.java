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
 *  public CartaImpl[] getCartasBaraja();
 *  public void setCartasBaraja(CartaImpl[] baraja);
 *
 *  public JugadorImpl[] getJugadores();
 *  public void setJugadores(JugadorImpl[] jugadores);
 *
 *  public CartaImpl[] getCartasMesa();
 *  public void setCartasMesa(CartaImpl[] cartas);
 *
 *  public int[][] getApuestasJugadores();
 *  public void setApuestasJugadores(int[][] apuestas);
 *
 *  public int getApuestaTotal();
 *
 * METODOS AÑADIDOS:
 *
 *  public void anhadirCartaMesa(int posicion, CartaImpl carta);
 *  public void limpiarCartasMesa();
 *
 *  public void cargarBaraja();
 *
 *  public JugadorImpl getJugador(int posicion);
 *  public void setJugador(int posicion, JugadorImpl jugador)
 *
 *
 */

package Clases.Interfaces;

import Clases.Basicas.CartaImpl;
import Clases.Basicas.JugadorImpl;

public interface Mesa {

    public CartaImpl[] getCartasBaraja();
    public void setCartasBaraja(CartaImpl[] baraja);

    public JugadorImpl[] getJugadores();
    public void setJugadores(JugadorImpl[] jugadores);

    public CartaImpl[] getCartasMesa();
    public void setCartasMesa(CartaImpl[] cartas);

    public int[][] getApuestasJugadores();
    public void setApuestasJugadores(int[][] apuestas);

    public int getApuestaTotal();

}
