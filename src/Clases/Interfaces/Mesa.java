/*
 * PROPIEDADES BASICAS:
 *
 *  - cartasMesa: CartaImpl[5], Consultable, Modificable
 *  - totalApuestas: int, Consultable, Modificable
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
 * METODOS AÑADIDOS:
 *
 *  public void anhadirCarta(int posicion, CartaImpl carta);
 *
 *  public void incrementarTotalApuestas(int cantidadIncrementar);
 *
 */

package Clases.Interfaces;

import Clases.Basicas.CartaImpl;

public interface Mano {

    public CartaImpl[] getCartasMesa();
    public void setCartasMesa(CartaImpl[] cartas);

    public int getTotalApuestas();
    public void setTotalApuestas(int totalApuestas);

}
