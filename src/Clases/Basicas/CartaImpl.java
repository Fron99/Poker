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

    /**
     * This constructor put attribute "palo" and attribute numero with value "D"
     */

    public CartaImpl(){
        this.palo = 'D';
        this.numero = "D";
    }

    /**
     * This constructor sets the value of the "palo" and "numero" attribute with the values ​​passed with the parameter
     * @param palo char with value of palo
     * @param numero String with value of numero
     */

    public CartaImpl(char palo, String numero){
        this.palo = palo;
        this.numero = numero;
    }

    /**
     * This constructor sets the value of the "palo" and "numero" attribute with the values ​​of the other card passed by parameter
     * @param otra CartaImpl other object CartaImpl
     */

    public CartaImpl(CartaImpl otra){
        this.palo = otra.getPalo();
        this.numero = otra.getNumero();
    }

    /**
     * Return value of attribute "palo"
     * @return char with value of attribute "palo"
     */

    public char getPalo(){
        return this.palo;
    }

    /**
     * Return value of attribute "numero"
     * @return String with value of attribute "numero"
     */

    public String getNumero(){
        return this.numero;
    }

    /**
     * This method return a String with attributes of the carte
     * @return String of a String with attributes of the carte
     */


    @Override
    public String toString(){
        return ("Palo: "+this.getPalo()+" Numero: "+this.numero);
    }

    /**
     * This method return an int with value of hashCode of the number
     * @return int with value of hashCode of the number
     */

    @Override
    public int hashCode(){
        return this.numero.hashCode();
    }

    /**
     * This method returns a Boolean value depending on whether the value of the carte passed by parameter is equal to that compared
     * @return boolean its value depending on whether the value of the carte passed by parameter is equal to that compared
     */

    @Override
    public boolean equals(Object objeto){
        boolean resul = false;
        if (this == objeto){
            resul = true;
        }else{
            if (objeto != null && objeto instanceof CartaImpl){
                CartaImpl nueva = (CartaImpl) objeto;
                if (this.getNumero().equals(nueva.getNumero())
                    && this.getPalo()==nueva.getPalo()){
                    resul = true;
                }
            }
        }
        return resul;
    }

    /**
     * This method returns a object CartaImpl cloned from which it is called
     * @return CartaImpl Cloned carte
     */

    @Override
    public CartaImpl clone() {
        CartaImpl carta = null;
        try {
            carta = (CartaImpl) super.clone();
        } catch(CloneNotSupportedException error) {
            System.out.println("Error en la copia");
        }
        return carta;
    }

}
