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

public class JugadorImpl implements Jugador, Cloneable {

    private String usuario;
    private int saldo;
    private CartaImpl[] cartas;
    private boolean activo;

    /**
     * This constructor places the default attributes
     */

    public JugadorImpl(){
        this.usuario = "DEFAULT";
        this.saldo = 0;
        this.cartas = new CartaImpl[2];
        for (int i = 0;i<this.cartas.length;i++){
            this.cartas[i] = new CartaImpl();
        }
        this.activo = true;
    }

    /**
     * This constructor places the values of attributes with values passed by parameter
     * @param usuario String name of player
     * @param saldo int balance of player
     */

    public JugadorImpl(String usuario, int saldo){
        this.usuario = usuario;
        this.saldo = saldo;
        this.cartas = new CartaImpl[2];
        for (int i = 0;i<this.cartas.length;i++){
            this.cartas[i] = new CartaImpl();
        }
        this.activo = true;
    }

    /**
     * This constructor places the values of attributes with values passed by parameter
     * @param usuario String name of player
     * @param saldo int balance of player
     * @param cartas array of letters
     */

    //TODO Comprobar = al asignar cartas y controlar tamaño

    public JugadorImpl(String usuario, int saldo, CartaImpl[] cartas){
        this.usuario = usuario;
        this.saldo = saldo;
        this.cartas = cartas;
        this.activo = true;
    }

    /**
     * This constructor places the values of attributes with values of other player passed by parameter
     * @param otro another player we want to copy their values ​​from
     */

    public JugadorImpl(JugadorImpl otro){
        this.usuario = otro.getUsuario();
        this.saldo = otro.getSaldo();
        this.cartas = otro.getCartas();
        this.activo = otro.getActivo();
    }

    /**
     * Return value of attribute "usuario"
     * @return String with value of attribute "usuario"
     */

    public String getUsuario(){
        return this.usuario;
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

    public CartaImpl[] getCartas(){
        return this.cartas;
    }

    /**
     * Set value passed by parameter in attribute "cartas"
     * @param cartas new value of attribute "cartas"
     */

    public void setCartas(CartaImpl[] cartas){
        this.cartas = cartas;
    }


    /**
     * @param posCarta
     * @param carta
     */

    public void setCarta(int posCarta, CartaImpl carta){
        this.cartas[posCarta] = carta;
    }

    /**
     * Return value of attribute "activo"
     * @return boolean with value of attribute "activo"
     */

    public boolean getActivo(){
        return this.activo;
    }

    /**
     * Set value passed by parameter in attribute "activo"
     * @param activo new value of attribute "activo"
     */

    public void setActivo(boolean activo){
        this.activo = activo;
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

    public CartaImpl obtenerCarta(int posicion){
        return this.cartas[posicion];
    }

    /**
     * This method assign a carte passed by parameter in index of array
     * @param posicion index of where to assign the carte
     * @param carta carte to assign in array
     */

    public void asignarCarta(int posicion, CartaImpl carta){
        this.cartas[posicion] = carta;
    }

    /**
     * This method return a String with attributes of the player
     * @return String with attributes of the player
     */

    @Override
    public String toString(){
        return "Usuario: "+usuario+", Saldo: "+saldo+", Activo: "+activo;
    }

    /**
     * This method return an int with value of hashCode of the player
     * @return int with value of hashCode of the player
     */

    @Override
    public int hashCode(){
        return saldo+usuario.hashCode();
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
            if (objeto != null && objeto instanceof JugadorImpl){
                JugadorImpl nueva = (JugadorImpl) objeto;
                if (this.getUsuario().equals(nueva.getUsuario())
                        && this.getCartas()==nueva.getCartas()
                        && this.getSaldo()==nueva.getSaldo()
                        && this.getActivo()==nueva.getActivo()){
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
    public JugadorImpl clone() {
        JugadorImpl jugador = null;
        jugador.usuario = this.usuario;
        jugador.saldo = this.saldo;
        for (int i = 0;i<cartas.length; i++){
            jugador.cartas[i] = this.cartas[i].clone();
        }
        jugador.activo = this.activo;
        return jugador;
    }

}
