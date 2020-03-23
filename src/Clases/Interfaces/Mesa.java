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

package Clases.Interfaces;

import Clases.Basicas.CartaImpl;
import Clases.Basicas.JugadorImpl;

public interface Mesa {

    public CartaImpl getCartaBaraja(int indice);

    public JugadorImpl getJugador(int indice);

    public CartaImpl[] getCartasMesa();

    public int getApuestaJugador(int jugador, int ronda);

    public int getTotalApuestas();

}
