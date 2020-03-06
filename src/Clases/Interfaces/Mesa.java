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

package Clases.Interfaces;

import Clases.Basicas.CartaImpl;
import Clases.Basicas.JugadorImpl;

public interface Mesa {

    public CartaImpl getCartaBaraja(int indice);
    public void setCartaBaraja(CartaImpl baraja, int indice);

    public JugadorImpl getJugador(int indice);
    public void setJugador(int jugador, JugadorImpl jugadores);

    public CartaImpl[] getCartasMesa();
    public void setCartaMesa(int indiceCarta, CartaImpl cartas);

    public int getApuestaJugador(int jugador, int ronda);
    public void setApuestaJugador(int jugador,int ronda, int apuestas);

    public int getTotalApuestas();

}
