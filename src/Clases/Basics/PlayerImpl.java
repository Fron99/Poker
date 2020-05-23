/*
 * ESTUDIO
 *
 * PROPIEDADES BASICAS:
 *
 *  - usuario: String, Consultable
 *  - saldo: int, Consultable, Modificable
 *  - cartas: CartaImpl[], Consultable, Modificable
 *  - activo: boolean, Consultable, Modificable
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
 *  public String getUsuario();
 *
 *  public int getSaldo();
 *  public void setSaldo(int saldo);
 *
 *  public CartaImpl[] getCartas();
 *  public void setCartas(CartaImpl[] cartas);
 *
 *  public boolean getActivo();
 *  public void setActivo(boolean activo);
 *
 * METODOS AÑADIDOS:
 *
 * public void disminuirSaldo(int saldo);
 *
 * public void aumentarSaldo(int saldo);
 *
 * public CartaImpl obtenerCarta(int posicion);
 *
 * public void asignarCarta(int posicion, CartaImpl carta);
 *
 */


package Clases.Basicas;

import Clases.Interfaces.Jugador;

public class PlayerImpl implements Jugador, Cloneable {

    private String username;
    private int saldo;
    private CardImpl[] cards;
    private boolean active;
    private boolean allInMenor;

    /**
     * This constructor places the default attributes
     */

    public PlayerImpl(){
        this.username = "DEFAULT";
        this.saldo = 0;
        this.cards = new CardImpl[2];
        for (int i = 0; i<this.cards.length; i++){
            this.cards[i] = new CardImpl();
        }
        this.active = true;
        this.allInMenor = false;
    }

    /**
     * This constructor places the values of attributes with values passed by parameter
     * @param username String name of player
     * @param saldo int balance of player
     */

    public PlayerImpl(String username, int saldo){
        this.username = username;
        this.saldo = saldo;
        this.cards = new CardImpl[2];
        for (int i = 0; i<this.cards.length; i++){
            this.cards[i] = new CardImpl();
        }
        this.active = true;
        this.allInMenor = false;
    }

    /**
     * This constructor places the values of attributes with values passed by parameter
     * @param username String name of player
     * @param saldo int balance of player
     * @param cards array of letters
     */

    //TODO Comprobar = al asignar cartas y controlar tamaño

    public PlayerImpl(String username, int saldo, CardImpl[] cards){
        this.username = username;
        this.saldo = saldo;
        this.cards = cards;
        this.active = true;
        this.allInMenor = false;
    }

    /**
     * This constructor places the values of attributes with values of other player passed by parameter
     * @param otro another player we want to copy their values ​​from
     */

    public PlayerImpl(PlayerImpl otro){
        this.username = otro.getUsername();
        this.saldo = otro.getSaldo();
        this.cards = otro.getCards();
        this.active = otro.getActive();
        this.allInMenor = otro.getAllInMenor();
    }

    /**
     * Return value of attribute "usuario"
     * @return String with value of attribute "usuario"
     */

    public String getUsername(){
        return this.username;
    }

    /**
     * Return value of attribute "saldo"
     * @return int with value of attribute "saldo"
     */

    public int getSaldo(){
        return this.saldo;
    }

    /**
     * Set value passed by parameter in attribute "saldo"
     * @param saldo new value of attribute "saldo"
     */

    public void setSaldo(int saldo){
        this.saldo = saldo;
    }

    /**
     * Return the array of the value of the "cartas" attribute
     * @return CartaImpl[] array of the value of the "cartas" attribute
     */

    public CardImpl[] getCards(){
        //TODO Cambiar que no devuelva el array por referencia en todos los metodos get
        return this.cards;
    }

    /**
     * Set value passed by parameter in attribute "cartas"
     * @param cards new value of attribute "cartas"
     */

    public void setCards(CardImpl[] cards){
        this.cards = cards;
    }


    /**
     * @param posCarta
     * @param carta
     */

    public void setCarta(int posCarta, CardImpl carta){
        this.cards[posCarta] = carta;
    }

    /**
     * Return value of attribute "activo"
     * @return boolean with value of attribute "activo"
     */

    public boolean getActive(){
        return this.active;
    }

    /**
     * Set value passed by parameter in attribute "activo"
     * @param active new value of attribute "activo"
     */

    public void setActive(boolean active){
        this.active = active;
    }

    /**
     * Return value of attribute "allInMenor"
     * @return boolean with value of attribute "allInMenor"
     */

    public boolean getAllInMenor(){
        return this.allInMenor;
    }

    /**
     * Set value passed by parameter in attribute "allInMenor"
     * @param allInMenor new value of attribute "allInMenor"
     */

    public void setAllInMenor(boolean allInMenor){
        this.allInMenor = allInMenor;
    }

    //METODOS ANHADIDOS

    /**
     * This method decrease value of attribute saldo
     * @param saldo Balance to decrease
     */

    public void disminuirDinero(int saldo){
        this.saldo -= saldo;
    }

    /**
     * This method increase value of attribute saldo
     * @param saldo Balance to increase
     */

    public void aumentarDinero(int saldo){
        this.saldo += saldo;
    }

    /**
     * This method returns a specific carte from an array of the index passed by parameter
     * @param posicion index of the carte to return
     * @return CartaImpl
     */

    public CardImpl obtenerCarta(int posicion){
        return this.cards[posicion];
    }

    /**
     * This method assign a carte passed by parameter in index of array
     * @param posicion index of where to assign the carte
     * @param carta carte to assign in array
     */

    public void asignarCarta(int posicion, CardImpl carta){
        this.cards[posicion] = carta;
    }

    /**
     * This method return a String with attributes of the player
     * @return String with attributes of the player
     */

    @Override
    public String toString(){
        return "Usuario: "+ username +", Saldo: "+saldo+", Activo: "+ active +", AllInMenor: "+allInMenor;
    }

    /**
     * This method return an int with value of hashCode of the player
     * @return int with value of hashCode of the player
     */

    @Override
    public int hashCode(){
        return saldo+ username.hashCode();
    }

    /**
     * This method returns a Boolean value depending on whether the value of the player passed by parameter is equal to that compared
     * @return boolean its value depending on whether the value of the player passed by parameter is equal to that compared
     */

    @Override
    public boolean equals(Object objeto){
        boolean resul = false;
        if (this == objeto){
            resul = true;
        }else{
            if (objeto != null && objeto instanceof PlayerImpl){
                PlayerImpl nueva = (PlayerImpl) objeto;
                if (this.getUsername().equals(nueva.getUsername())
                        && this.getCards()==nueva.getCards()
                        && this.getSaldo()==nueva.getSaldo()
                        && this.getActive()==nueva.getActive()){
                    resul = true;
                }
            }
        }
        return resul;
    }

    /**
     * This method returns a object JugadorImpl cloned from which it is called
     * @return JugadorImpl Cloned player
     */

    @Override
    public PlayerImpl clone() {
        PlayerImpl jugador = new PlayerImpl();
        jugador.username = this.username;
        jugador.saldo = this.saldo;
        for (int i = 0; i< cards.length; i++){
            jugador.cards[i] = this.cards[i].clone();
        }
        jugador.active = this.active;
        return jugador;
    }

}
