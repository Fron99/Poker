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
 *  - valorNumero: int, Consultable
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
 *  public int getValorNumero();
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
     * Return the equivalent value in int of the card number
     * @return valor int with equivalent value in int of the card number
     */

    public int getValorNumero(){
        int valor = 0;
        switch (this.getNumero()){
            case "A":
                valor = 13;
                break;
            case "2":
                valor = 1;
                break;
            case "3":
                valor = 2;
                break;
            case "4":
                valor = 3;
                break;
            case "5":
                valor = 4;
                break;
            case "6":
                valor = 5;
                break;
            case "7":
                valor = 6;
                break;
            case "8":
                valor = 7;
                break;
            case "9":
                valor = 8;
                break;
            case "10":
                valor = 9;
                break;
            case "J":
                valor = 10;
                break;
            case "Q":
                valor = 11;
                break;
            case "K":
                valor = 12;
                break;
        }
        return valor;
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


    //TODO Documentar compareTo y desarrollar javadoc

    /**
     * This method return an int with value of hashCode of the number
     * @return int with value compare
     */

    public int compareTo(CartaImpl otra){
        int resultado = -1;
        if (this.getValorNumero() == otra.getValorNumero()){
            resultado = 0;
        }else{
            if (this.getValorNumero() > otra.getValorNumero()){
                resultado = 1;
            }
        }
        return resultado;
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
