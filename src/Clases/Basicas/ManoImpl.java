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

package Clases.Basicas;

import Clases.Interfaces.Mano;

public class ManoImpl implements Mano {

    private CartaImpl[] cartasMesa = new CartaImpl[5];
    private int totalApuestas;

    public ManoImpl(){

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

    public void anhadirCarta(int posicion, CartaImpl carta){
        this.cartasMesa[posicion] = carta;
    }

    public void incrementarTotalApuestas(int cantidadIncrementar){
        this.totalApuestas += cantidadIncrementar;
    }



}
