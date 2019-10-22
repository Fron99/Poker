/*
 * ESTUDIO
 *
 * PROPIEDADES BASICAS:
 *
 *  - palo: char, Consultable
 *  - numero: String, Consultable
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
 *  public char getPalo();
 *
 *  public String getNumero();
 *
 * METODOS AÑADIDOS:
 *
 *  - No hay
 *
 */

package Clases.Basicas;

import Clases.Interfaces.Carta;

public class CartaImpl implements Carta{

    private char palo;
    private String numero;

    public CartaImpl(){
        this.palo = 'D';
        this.numero = "Default";
    }

    public CartaImpl(char palo, String numero){
        this.palo = palo;
        this.numero = numero;
    }

    public CartaImpl(CartaImpl otra){
        this.palo = otra.getPalo();
        this.numero = otra.getNumero();
    }

    public char getPalo(){
        return this.palo;
    }

    public String getNumero(){
        return this.numero;
    }

}
