/*
 * ESTUDIO
 *
 * PROPIEDADES BASICAS:
 *
 *  - ID: int, Consultable
 *  - usuario: String, Consultable
 *  - dinero: int, Consultable, Modificable
 *  - cartas: CartaImpl[], Consultable, Modificable
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
 *  public int getID();
 *
 *  public String getUsuario();
 *
 *  public int getDinero();
 *  public void setDinero(int dinero);
 *
 *  public CartaImpl[] getCartas();
 *  public void setCartas(CartaImpl[] cartas);
 *
 * METODOS AÑADIDOS:
 *
 * public void disminuirDinero(int dinero);
 *
 * public void aumentarDinero(int dinero);
 *
 * public CartaImpl obtenerCarta(int posicion);
 *
 */


package Clases.Interfaces;
import Clases.Basicas.CartaImpl;

public interface Jugador {

    public int getID();

    public String getUsuario();

    public int getDinero();
    public void setDinero(int dinero);

    public CartaImpl[] getCartas();
    public void setCartas(CartaImpl[] cartas);

}
