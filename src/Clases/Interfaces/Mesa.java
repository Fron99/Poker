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

package Clases.Interfaces;

import Clases.Basicas.CartaImpl;
import Clases.Basicas.JugadorImpl;

public interface Mesa {

    public CartaImpl[] getCartasMesa();
    public void setCartasMesa(CartaImpl[] cartas);

    public int getTotalApuestas();
    public void setTotalApuestas(int totalApuestas);

    public JugadorImpl[] getJugadores();
    public void setJugadores(JugadorImpl[] jugadores);

}
