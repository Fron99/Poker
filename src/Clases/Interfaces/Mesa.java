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

package Clases.Interfaces;

import Clases.Basicas.CartaImpl;
import Clases.Basicas.JugadorImpl;

public interface Mesa {

    public CartaImpl[] getBaraja();
    public void setBaraja(CartaImpl[] baraja);

    public JugadorImpl[] getJugadores();
    public void setJugadores(JugadorImpl[] jugadores);

    public CartaImpl[] getCartasMesa();
    public void setCartasMesa(CartaImpl[] cartas);

    public int[][] getApuestasJugadores();
    public void setApuestasJugadores(int[][] apuestas);

    public int getTotalApuestas();

}
