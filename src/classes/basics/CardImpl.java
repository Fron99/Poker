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

package classes.basics;
import classes.interfaces.Card;

@SuppressWarnings("unused")
public class CardImpl implements Card, Cloneable{

    private final char suit;
    private final String number;

    /**
     * This constructor put attribute "palo" and attribute numero with value "D"
     */

    public CardImpl(){
        this.suit = 'D';
        this.number = "D";
    }

    /**
     * This constructor sets the value of the "palo" and "numero" attribute with the values ​​passed with the parameter
     * @param suit char with value of palo
     * @param number String with value of numero
     */

    public CardImpl(char suit, String number){
        if ((suit == 'P' || suit == 'C' || suit == 'R' || suit == 'T') && (number.equals("1") || number.equals("2") || number.equals("3") || number.equals("4") || number.equals("5") || number.equals("6")
                                                                            || number.equals("7") ||number.equals("8") || number.equals("9") || number.equals("10") || number.equals("J") || number.equals("Q") || number.equals("K"))){
                this.number = number;
                this.suit = suit;
        }else{
            this.suit = 'D';
            this.number = "D";
        }
    }

    /**
     * This constructor sets the value of the "palo" and "numero" attribute with the values ​​of the other card passed by parameter
     * @param other CartaImpl other object CartaImpl
     */

    public CardImpl(CardImpl other){
        this.suit = other.getSuit();
        this.number = other.getNumber();
    }

    /**
     * Return value of attribute "palo"
     * @return char with value of attribute "palo"
     */

    public char getSuit(){
        return this.suit;
    }

    /**
     * Return value of attribute "numero"
     * @return String with value of attribute "numero"
     */

    public String getNumber(){
        return this.number;
    }

    /**
     * Return the equivalent value in int of the card number
     * @return valor int with equivalent value in int of the card number
     */

    public int getValueNumber(){
        int value = 0;
        switch (this.getNumber()){
            case "A":
                value = 13;
                break;
            case "2":
                value = 1;
                break;
            case "3":
                value = 2;
                break;
            case "4":
                value = 3;
                break;
            case "5":
                value = 4;
                break;
            case "6":
                value = 5;
                break;
            case "7":
                value = 6;
                break;
            case "8":
                value = 7;
                break;
            case "9":
                value = 8;
                break;
            case "10":
                value = 9;
                break;
            case "J":
                value = 10;
                break;
            case "Q":
                value = 11;
                break;
            case "K":
                value = 12;
                break;
        }
        return value;
    }

    /**
     * This method return a String with attributes of the carte
     * @return String of a String with attributes of the carte
     */


    @Override
    public String toString(){
        return ("Suit: "+this.suit+" Number: "+this.number);
    }

    /**
     * This method return an int with value of hashCode of the number
     * @return int with value of hashCode of the number
     */

    @Override
    public int hashCode(){
        return this.number.hashCode();
    }

    /**
     * This method return an int with value of hashCode of the number.
     * Return -1 if the number of the card passed by parameter is biggest.
     * Return 0 if the number of the card passed by parameter is equals.
     * Return 1 if the number of the card passed by parameter is lower.
     * @return int with value compare
     */

    public int compareTo(CardImpl other){
        int result = -1;
        if (this.getValueNumber() == other.getValueNumber()){
            result = 0;
        }else{
            if (this.getValueNumber() > other.getValueNumber()){
                result = 1;
            }
        }
        return result;
    }

    /**
     * This method returns a Boolean value depending on whether the value of the carte passed by parameter is equal to that compared
     * @return boolean its value depending on whether the value of the carte passed by parameter is equal to that compared
     */

    @Override
    public boolean equals(Object object){
        boolean result = false;
        if (this == object){
            result = true;
        }else{
            if (object instanceof CardImpl){
                CardImpl newCard = (CardImpl) object;
                if (this.number.equals(newCard.number)
                    && this.suit == newCard.suit){
                    result = true;
                }
            }
        }
        return result;
    }

    /**
     * This method returns a object CartaImpl cloned from which it is called
     * @return CartaImpl Cloned carte
     */

    @Override
    public CardImpl clone() {
        CardImpl card = null;
        try {
            card = (CardImpl) super.clone();
        } catch(CloneNotSupportedException error) {
            System.out.println("Copy error");
        }
        return card;
    }

}
