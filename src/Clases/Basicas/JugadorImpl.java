/*
 * ESTUDIO
 *
 * PROPIEDADES BASICAS:
 *
 *  - ID: int, Consultable
 *  - usuario: String, Consultable
 *  - dinero: int, Consultable, Modificable
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
 *  public int getID();
 *
 *  public String getUsuario();
 *
 *  public int getDinero();
 *  public void setDinero(int dinero);
 *
 *  public CartaImpl[] getCartas();
 *  public void setCartas(CartaImpl[] cartas);
 *
 *  public boolean getActivo();
 *  public void setActivo(boolean activo);
 *
 * METODOS AÑADIDOS:
 *
 * public void disminuirDinero(int dinero);
 *
 * public void aumentarDinero(int dinero);
 *
 * public CartaImpl obtenerCarta(int posicion);
 *
 */


package Clases.Basicas;

import Clases.Interfaces.Jugador;

public class JugadorImpl implements Jugador {

    private int ID;
    private String usuario;
    private int dinero;
    private CartaImpl[] cartas = new CartaImpl[2];
    private boolean activo;

    private static int contadorID = 0;


    public JugadorImpl(){
        this.ID = contadorID;
        contadorID++;
        this.usuario = "DEFAULT";
        this.dinero = 0;
        this.activo = true;
    }

    public JugadorImpl(String usuario, int dinero){
        this.ID = contadorID;
        contadorID++;
        this.usuario = usuario;
        this.dinero = dinero;
        this.activo = true;
    }

    public JugadorImpl(JugadorImpl otro){
        this.ID = contadorID;
        contadorID++;
        this.usuario = otro.getUsuario();
        this.dinero = otro.getDinero();
        this.activo = otro.getActivo();
    }

    public int getID(){
        return this.ID;
    }

    public String getUsuario(){
        return this.usuario;
    }

    public int getDinero(){
        return this.dinero;
    }

    public void setDinero(int dinero){
        this.dinero = dinero;
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

    public void disminuirDinero(int dinero){
        this.dinero = this.dinero - dinero;
    }

    public void aumentarDinero(int dinero){
        this.dinero = this.dinero + dinero;
    }

    public CartaImpl obtenerCarta(int posicion){
        return this.cartas[posicion];
    }


    @Override
    public String toString(){
        return (this.getID()+", "+this.getUsuario()+", "+this.getDinero());
    }

}
