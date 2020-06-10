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


package basicsClasses;

import enums.Genders;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.GregorianCalendar;

@SuppressWarnings("unused")
public class PlayerImpl implements Cloneable {

    private String username, password, name, surname, email, IBAN;
    private Genders gender;
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
        this.gender = Genders.Other;
        this.email = "DEFAULT@DEFAULT.COM";
        this.IBAN = "ES0000000000000000000000";
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
        this.gender = Genders.Other;
        this.email = "DEFAULT@DEFAULT.COM";
        this.IBAN = "ES0000000000000000000000";
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

    public PlayerImpl(String username, String password, String name, String surname, Genders gender, String email, String IBAN, GregorianCalendar birthday, int balance, CardImpl[] cards){
        this.username = username;

        String passEncripted = null;
        try {
            byte[] bytesOfMessage = password.getBytes(StandardCharsets.UTF_8);
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] thedigest = md.digest(bytesOfMessage);
            BigInteger bigInt = new BigInteger(1,thedigest);
            passEncripted = bigInt.toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (passEncripted != null){
            this.password = passEncripted;
        }else{
            this.password = "DEFAULT";
        }

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
        this.username = other.username;
        this.password = other.password;
        this.name = other.name;
        this.surname = other.surname;
        this.gender = other.gender;
        this.email = other.email;
        this.IBAN = other.IBAN;
        this.birthday = (GregorianCalendar) other.birthday.clone();
        this.balance = other.balance;
        this.cards = other.cards;
    }

    /**
     * Return value of attribute "username"
     * @return String with value of attribute "username"
     */

    public String getUsername(){
        return this.username;
    }

    /**
     * Change value of attribute "username" whit value passed by parameter
     * @param username New value for attribute "username"
     */

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Return value of attribute "password"
     * @return String with value of attribute "password"
     */

    public String getPassword() {
        return password;
    }

    /**
     * Change value of attribute "password" whit value passed by parameter
     * @param password New value for attribute "password"
     */

    public void setPassword(String password) {
        String passEncripted = null;

        try {
            byte[] bytesOfMessage = password.getBytes(StandardCharsets.UTF_8);
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] thedigest = md.digest(bytesOfMessage);
            BigInteger bigInt = new BigInteger(1,thedigest);
            passEncripted = bigInt.toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (passEncripted != null){
            this.password = passEncripted;
        }

    }

    /**
     * Return value of attribute "name"
     * @return String with value of attribute "name"
     */

    public String getName() {
        return name;
    }

    /**
     * Change value of attribute "name" whit value passed by parameter
     * @param name New value for attribute "name"
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return value of attribute "surname"
     * @return String with value of attribute "surname"
     */

    public String getSurname() {
        return surname;
    }

    /**
     * Change value of attribute "surname" whit value passed by parameter
     * @param surname New value for attribute "surname"
     */

    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Return value of attribute "gender"
     * @return String with value of attribute "gender"
     */

    public Genders getGender() {
        return gender;
    }

    /**
     * Change value of attribute "gender" whit value passed by parameter
     * @param gender New value for attribute "gender"
     */

    public void setGender(Genders gender) {
        this.gender = gender;
    }

    /**
     * Return value of attribute "email"
     * @return String with value of attribute "email"
     */

    public String getEmail() {
        return email;
    }

    /**
     * Change value of attribute "email" whit value passed by parameter
     * @param email New value for attribute "email"
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Return value of attribute "IBAN"
     * @return String with value of attribute "IBAN"
     */

    public String getIBAN() {
        return IBAN;
    }

    /**
     * Change value of attribute "IBAN" whit value passed by parameter
     * @param IBAN New value for attribute "IBAN"
     */

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    /**
     * Return value of attribute "birthday"
     * @return GregorianCalendar with value of attribute "birthday"
     */

    public GregorianCalendar getBirthday() {
        return (GregorianCalendar) birthday.clone();
    }

    /**
     * Change value of attribute "birthday" whit value passed by parameter
     * @param birthday New value for attribute "birthday"
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


    @Override
    public String toString(){

        return "Username: "+ username +", Name: "+ name +", Surname: "+ surname +", Gender: "+ gender.toString() +"\n" +"Birthday: "+ birthday.get(Calendar.DAY_OF_MONTH)+"/"+birthday.get(Calendar.MONTH)+"/"+birthday.get(Calendar.YEAR)+
                ", Email: "+ email +", IBAN: "+ IBAN +", Saldo: "+ balance+"\n"+
                "First card: "+cards[0].toString()+", Second card: "+cards[1].toString();

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
            if (object instanceof PlayerImpl){
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
        PlayerImpl clone = null;
        try {
            clone = (PlayerImpl) super.clone();
            clone.birthday = (GregorianCalendar) this.birthday.clone();
            for (int i = 0; i< cards.length; i++){
                clone.cards[i] = this.cards[i].clone();
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

}
