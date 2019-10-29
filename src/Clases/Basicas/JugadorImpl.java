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

public class JugadorImpl implements Jugador {

    private String usuario;
    private int saldo;
    private CartaImpl[] cartas;
    private boolean activo;

    public JugadorImpl(){
        this.usuario = "DEFAULT";
        this.saldo = 0;
        cartas = new CartaImpl[2];
        this.activo = true;
    }

    public JugadorImpl(String usuario, int dinero){
        this.usuario = usuario;
        this.saldo = dinero;
        this.cartas = new CartaImpl[2];
        this.activo = true;
    }

    public JugadorImpl(String usuario, int dinero, CartaImpl[] cartas){
        this.usuario = usuario;
        this.saldo = dinero;
        this.cartas = cartas;
        this.activo = true;
    }


    public JugadorImpl(JugadorImpl otro){
        this.usuario = otro.getUsuario();
        this.saldo = otro.getSaldo();
        this.cartas = otro.getCartas();
        this.activo = otro.getActivo();
    }

    public String getUsuario(){
        return this.usuario;
    }

    public int getSaldo(){
        return this.saldo;
    }

    public void setSaldo(int saldo){
        this.saldo = saldo;
    }

    public CartaImpl[] getCartas(){
        return this.cartas;
    }

    public void setCartas(CartaImpl[] cartas){
        this.cartas = cartas;
    }

    public boolean getActivo(){
        return this.activo;
    }

    public void setActivo(boolean activo){
        this.activo = activo;
    }

    //METODOS ANHADIDOS

    //TODO DOCUMENTAR METODOS RAROS

    public void disminuirDinero(int saldo){
        this.saldo -= saldo;
    }

    public void aumentarDinero(int saldo){
        this.saldo += saldo;
    }

    public CartaImpl obtenerCarta(int posicion){
        return this.cartas[posicion];
    }

    public void asignarCarta(int posicion, CartaImpl carta){
        this.cartas[posicion] = carta;
    }

    //TODO Sobreescribir metodos heredados


}
