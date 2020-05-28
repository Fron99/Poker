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


package Clases.Basics;

import Clases.Interfaces.Player;

import java.util.GregorianCalendar;

public class PlayerImpl implements Player, Cloneable {

    private String username, password, name, surname, gender, email, IBAN;
    private GregorianCalendar birthday;
    private int balance;
    private CardImpl[] cards;

    /**
     * This constructor places the default attributes
     */

    public PlayerImpl(){
        this.username = "DEFAULT";
        this.password = "DEFAULT";
        this.name = "DEFAULT";
        this.surname = "DEFAULT";
        this.gender = "NONE";
        this.email = "DEFAULT@DEFAULT.COM";
        this.IBAN = "DEFAULT";
        this.birthday = new GregorianCalendar();
        this.balance = 0;
        this.cards = new CardImpl[2];
        for (int i = 0; i<this.cards.length; i++){
            this.cards[i] = new CardImpl();
        }
    }

    /**
     * This constructor places the values of attributes with values passed by parameter
     * @param username String name of player
     * @param balance int balance of player
     */

    public PlayerImpl(String username, int balance){
        this.username = username;
        this.password = "DEFAULT";
        this.name = "DEFAULT";
        this.surname = "DEFAULT";
        this.gender = "NONE";
        this.email = "DEFAULT@DEFAULT.COM";
        this.IBAN = "DEFAULT";
        this.birthday = new GregorianCalendar();
        this.balance = balance;
        this.cards = new CardImpl[2];
        for (int i = 0; i<this.cards.length; i++){
            this.cards[i] = new CardImpl();
        }
    }

    /**
     * This constructor places the values of attributes with values passed by parameter
     * @param username String name of player
     * @param balance int balance of player
     * @param cards array of letters
     */

    public PlayerImpl(String username, String password, String name, String surname, String gender, String email, String IBAN, GregorianCalendar birthday, int balance, CardImpl[] cards){
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.email = email;
        this.IBAN = IBAN;
        this.birthday = (GregorianCalendar) birthday.clone();
        this.balance = balance;
        if (cards.length < 3 && cards.length > 0){
            this.cards = cards;
        }else{
            this.cards = new CardImpl[2];
        }

    }

    /**
     * This constructor places the values of attributes with values of other player passed by parameter
     * @param other another player we want to copy their values ​​from
     */

    public PlayerImpl(PlayerImpl other){
        this.username = other.getUsername();
        this.balance = other.getBalance();
        this.cards = other.getCards();
    }

    /**
     * Return value of attribute "usuario"
     * @return String with value of attribute "usuario"
     */

    public String getUsername(){
        return this.username;
    }

    /**
     * @param username
     */

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return
     */

    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return
     */

    public String getName() {
        return name;
    }

    /**
     * @param name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */

    public String getSurname() {
        return surname;
    }

    /**
     * @param surname
     */

    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return
     */

    public String getGender() {
        return gender;
    }

    /**
     * @param gender
     */

    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return
     */

    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return
     */

    public String getIBAN() {
        return IBAN;
    }

    /**
     * @param IBAN
     */

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    /**
     * @return
     */

    public GregorianCalendar getBirthday() {
        return (GregorianCalendar) birthday.clone();
    }

    /**
     * @param birthday
     */

    public void setBirthday(GregorianCalendar birthday) {
        this.birthday = birthday;
    }

    /**
     * Return value of attribute "balance"
     * @return int with value of attribute "balance"
     */

    public int getBalance(){
        return this.balance;
    }

    /**
     * Set value passed by parameter in attribute "balance"
     * @param balance new value of attribute "balance"
     */

    public void setBalance(int balance){
        this.balance = balance;
    }

    /**
     * Return the array of the value of the "cards" attribute
     * @return CartaImpl[] array of the value of the "cards" attribute
     */

    public CardImpl[] getCards(){
        return this.cards.clone();
    }

    /**
     * Set value passed by parameter in attribute "cards"
     * @param cards new value of attribute "cards"
     */

    public void setCards(CardImpl[] cards){
        this.cards = cards.clone();
    }

    /**
     * This method assign a cart passed by parameter in index of array
     * @param index index of where to assign the cart
     * @param card carte to assign in array
     */

    public void setCard(int index, CardImpl card){
        this.cards[index] = card.clone();
    }

    /**
     * This method returns a specific carte from an array of the index passed by parameter
     * @param index index of the carte to return
     * @return CartaImpl
     */

    public CardImpl getCard(int index){
        return this.cards[index].clone();
    }

    /**
     * This method decrease value of attribute balance
     * @param balance Balance to decrease
     */

    public void decreaseBalance(int balance){
        this.balance -= balance;
    }

    /**
     * This method increase value of attribute balance
     * @param balance Balance to increase
     */

    public void increaseBalance(int balance){
        this.balance += balance;
    }

    /**
     * This method return a String with attributes of the player
     * @return String with attributes of the player
     */

    //TODO TERMINAR
    @Override
    public String toString(){
        return "Usuario: "+ username +", Saldo: "+ balance;
    }

    /**
     * This method return an int with value of hashCode of the player
     * @return int with value of hashCode of the player
     */

    @Override
    public int hashCode(){
        return balance + username.hashCode();
    }

    /**
     * This method returns a Boolean value depending on whether the value of the player passed by parameter is equal to that compared
     * @return boolean its value depending on whether the value of the player passed by parameter is equal to that compared
     */

    @Override
    public boolean equals(Object object){
        boolean result = false;
        if (this == object){
            result = true;
        }else{
            if (object != null && object instanceof PlayerImpl){
                PlayerImpl newPlayer = (PlayerImpl) object;
                if (this.getUsername().equals(newPlayer.getUsername())
                        && this.getCards()==newPlayer.getCards()
                        && this.getBalance()==newPlayer.getBalance()){
                    result = true;
                }
            }
        }
        return result;
    }

    /**
     * This method returns a object PlayerImpl cloned from which it is called
     * @return PlayerImpl Cloned player
     */

    @Override
    public PlayerImpl clone() {
        PlayerImpl player = new PlayerImpl();
        player.username = this.username;
        player.balance = this.balance;
        for (int i = 0; i< cards.length; i++){
            player.cards[i] = this.cards[i].clone();
        }
        return player;
    }

}
