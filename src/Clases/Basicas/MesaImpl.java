/*
 * PROPIEDADES BASICAS:
 *
 *  - baraja: CartaImpl[], Consultable, Modificable
 *  - jugadores: JugadorImpl[], Consultable, Modificable
 *  - cartasMesa: CartaImpl[], Consultable, Modificable
 *  - apuestasJugadores: int[][], Consultable, Modificable
 *
 * PROPIEDADES DERIVADAS:
 *
 *  - apuestaTotal: int, Consultable
 *
 * PROPIEDADES COMPARTIDAS:
 *
 *  - No hay
 *
 * METODOS:
 *
 * public CartaImpl[] getCartasBaraja();
 * public void setCartasBaraja(CartaImpl[] baraja);
 *
 * public JugadorImpl[] getJugadores();
 * public void setJugadores(JugadorImpl[] jugadores);
 *
 * public CartaImpl[] getCartasMesa();
 * public void setCartasMesa(CartaImpl[] cartas);
 *
 * public int[][] getApuestasJugadores();
 * public void setApuestasJugadores(int[][] apuestas);
 *
 * public int getTotalApuestas();
 *
 * METODOS AÑADIDOS:
 *
 * public void anhadirCartaMesa(int posicion, CartaImpl carta);
 * public void limpiarCartasMesa();
 *
 * public void cargarBaraja();
 *
 * public JugadorImpl obtenerJugador(int posicion);
 * public void anhadirJugador(int posicion, JugadorImpl jugador)
 *
 * public void anhadirApuesta(int jugador, int rondaApuesta, int cantidad)
 * public int obtenerApuesta(int jugador, int rondaApuesta)
 *
 * public void limpiarMesa()
 *
 */

package Clases.Basicas;

import Clases.Gestoras.GestoraJugadorImpl;
import Clases.Interfaces.Mesa;

import java.util.ArrayList;
import java.util.Random;

public class MesaImpl implements Mesa {

    private CartaImpl[] baraja;
    private JugadorImpl[] jugadores;
    private CartaImpl[] cartasMesa;
    private int[][] apuestasJugadores;
    private int turnoJugador;
    private int ronda;

    /**
     * This constructor put the attributes with default values
     */

    public MesaImpl(){
        Random random = new Random();
        this.baraja = new CartaImpl[52];
        this.jugadores = new JugadorImpl[5];
        this.cartasMesa = new CartaImpl[5];
        this.apuestasJugadores = new int[5][5];
        this.turnoJugador = random.nextInt(5);
        this.ronda = 0;
    }

    /**
     * This constructor put the attributes with the values passed by parameter
     * @param baraja array of letters
     * @param jugadores array of players
     * @param cartas array of letters
     */

    public MesaImpl(CartaImpl[] baraja, JugadorImpl[] jugadores, CartaImpl[] cartas){   //TODO No copiar los arrays con =
        Random random = new Random();
        this.baraja = baraja;
        this.jugadores = jugadores;
        this.cartasMesa = cartas;
        this.apuestasJugadores = new int[5][5];
        this.turnoJugador = random.nextInt(5);
        this.ronda = 0;
    }

    /**
     * This constructor put the attributes with the values passed by parameter
     * @param baraja array of letters
     * @param jugadores array of players
     * @param cartas array of letters
     * @param apuestasJugadores array of int
     */

    public MesaImpl(CartaImpl[] baraja, JugadorImpl[] jugadores, CartaImpl[] cartas, int[][] apuestasJugadores){    //TODO No copiar los arrays con =
        Random random = new Random();
        this.baraja = baraja;
        this.jugadores = jugadores;
        this.cartasMesa = cartas;
        this.apuestasJugadores = apuestasJugadores;
        this.turnoJugador = random.nextInt(5);
        this.ronda = 0;
    }

    /**
     * This constructor put the attributes with the values of the other object passed by parameter
     * @param otro another table of we want to copy their values
     */

    public MesaImpl(MesaImpl otro){     //Todo comprobar si al modificar este se modifica el original
        this.baraja = otro.getBaraja();
        this.jugadores = otro.getJugadores();
        this.cartasMesa = otro.getCartasMesa();
        this.apuestasJugadores = otro.getApuestasJugadores();
    }

    /**
     * Return array of attribute "baraja"
     * @return CartaImpl[] array of attribute "baraja"
     */

    public CartaImpl[] getBaraja(){
        CartaImpl[] baraja = new CartaImpl[this.baraja.length];
        System.arraycopy(this.baraja,0,baraja,0,this.baraja.length);
        return baraja;
    }

    /**
     * Return the card of the index in the array "baraja"
     * @return CartaImpl card that you want get
     * @param indice index of the card of you will want return
     */

    public CartaImpl getCartaBaraja(int indice){
        return this.baraja[indice].clone(); //todo Comprobar si el clone hace una copia por referencia.
    }

    /**
     * Set array passed by parameter in attribute "baraja"
     * @param baraja new value of attribute "baraja"
     */

    private void setBaraja(CartaImpl[] baraja){
        this.baraja = baraja;
    }

    /**
     * Set value of the card that index with the card passed by parameter
     * @param baraja new value of attribute "baraja"
     * @param indice index of the card that will be changed the value
     */

    public void setCartaBaraja(CartaImpl baraja, int indice){
        this.baraja[indice] = baraja;
    }

    /**
     * Return array of attribute "jugadores"
     * @return JugadorImpl[] array of attribute "jugadores"
     */

    public JugadorImpl[] getJugadores(){
        JugadorImpl[] jugadores = new JugadorImpl[this.jugadores.length];
        System.arraycopy(this.jugadores,0,jugadores,0,this.jugadores.length);
        return jugadores;
    }

    /**
     * Return the player of the index in the array "jugadores"
     * @param indice index of the card of you will want return
     * @return JugadorImpl player that you want get
     */

    public JugadorImpl getJugador(int indice){
        return this.jugadores[indice].clone();      //todo Comprobar si el clone hace una copia por referencia.
    }

    /**
     * Return array with cards of player
     * @param jugador int of the player
     * @return JugadorImpl[] array of attribute "jugadores"
     */

    private CartaImpl[] getCartasJugador(int jugador){
        CartaImpl[] cartasJugador = new CartaImpl[2];
        System.arraycopy(this.jugadores[jugador].getCartas(),0,cartasJugador,0,this.jugadores[jugador].getCartas().length);
        return cartasJugador;
    }

    /**
     * @param jugador
     * @param carta
     * @return
     */

    public CartaImpl getCartaJugador(int jugador,int carta){
        return this.jugadores[jugador].getCartas()[carta];
    }

    /**
     * Set array passed by parameter in attribute "jugadores"
     * @param jugadores new value of attribute "jugadores"
     */

    private void setJugadores(JugadorImpl[] jugadores){
        this.jugadores = jugadores;
    }


    /**
     * @param jugador
     * @param jugadores
     */

    public void setJugador(int jugador, JugadorImpl jugadores){
        this.jugadores[jugador] = jugadores;
    }

    /**
     * Return array of attribute "cartasMesa"
     * @return CartaImpl[] array of attribute "cartasMesa"
     */

    public CartaImpl[] getCartasMesa(){
        CartaImpl[] cartas = new CartaImpl[this.cartasMesa.length];
        System.arraycopy(this.cartasMesa,0,cartas,0,this.cartasMesa.length);
        return cartas;
    }


    /**
     * @param indiceCarta
     * @return
     */


    public CartaImpl getCartaMesa(int indiceCarta){
        return this.cartasMesa[indiceCarta].clone();        //todo Comprobar si el clone hace una copia por referencia.
    }

    /**
     * Set array passed by parameter in attribute "cartas"
     * @param cartas new value of attribute "cartas"
     */

    private void setCartasMesa(CartaImpl[] cartas){
        this.cartasMesa = cartas;
    }


    /**
     * @param indiceCarta
     * @param cartas
     */

    public void setCartaMesa(int indiceCarta, CartaImpl cartas){
        this.cartasMesa[indiceCarta] = cartas;
    }

    /**
     * Return array of attribute "apuestasJugadores"
     * @return int[][] array of attribute "apuestasJugadores"
     */

    private int[][] getApuestasJugadores(){
        int[][] apeustas = new int[5][5];
        System.arraycopy(this.apuestasJugadores,0,apeustas,0,this.apuestasJugadores.length);
        return apeustas;
    }


    /**
     * @param jugador
     * @param ronda
     * @return
     */

    public int getApuestaJugador(int jugador, int ronda){
        return this.apuestasJugadores[jugador][ronda];
    }

    /**
     * Set array passed by parameter in attribute "apuestasJugadores"
     * @param apuestas new value of attribute "apuestas"
     */

    private void setApuestasJugadores(int[][] apuestas){
        this.apuestasJugadores = apuestas;
    }

    /**
     * @param jugador
     * @param ronda
     * @param apuestas
     */

    public void setApuestaJugador(int jugador,int ronda, int apuestas){
        this.apuestasJugadores[jugador][ronda] = apuestas;
    }

    /**
     * Return value of sum all bets
     * @return int value of sum all bets
     */

    public int getTotalApuestas(){
        int total = 0;
        for (int i = 0; i<this.apuestasJugadores.length; i++){
            for (int j = 0; j<this.apuestasJugadores.length; j++){
                total += this.apuestasJugadores[i][j];
            }
        }
        return total;
    }

    //METODOS ANHADIDOS

    /*
     * SIGNATURA: public void restaurarMesa();
     * COMENTARIO: Elimina todos los cambios que se hayan realizado sobre los atributos y lo coloca por defecto para empezar una partida nueva.
     * PRECONDICIONES: - Nada
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Modifica el valor de todos los atributos y los pone por defecto
     *
     */

    //TODO Revisar esto

    public void restaurarMesa(){
        limpiarMesa();
        restaurarBaraja();
        colocarJugadoresActivos();
        generarCartasJugadores();
    }


    /*
     * SIGNATURA: public void colocarJugadoresActivos()
     * COMENTARIO: Metodo para colocar todos los jugadores de la mesa activos
     * PRECONDICIONES: - Nada
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Coloca todos los jugadores del array jugadores de la mesa en activo.
     */

    /**
     * This method set active all players
     */

    private void colocarJugadoresActivos(){
        for(JugadorImpl jugador: this.jugadores){
            jugador.setActivo(true);
        }
    }

    /*
     * SIGNATURA:
     * COMENTARIO:
     * PRECONDICIONES: -
     * ENTRADA: -
     * SALIDA: -
     * ENTRADA/SALIDA: -
     * POSTCONDICIONES: -
     */

    //TODO  Desarrollar javadoc

    public void ingresarSaldoGanadores(){

        //TODO

    }

    /*
     * SIGNATURA: public void generarCartasJugadores();
     * COMENTARIO: Saca dos cartas de la baraja para cada jugador y se las asigna a cada jugador
     * PRECONDICIONES: - Nada
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Modifica el array de la baraja colocando por defecto las cartas sacadas y asigna las cartas a los jugadores de la mesa
     */

    /**
     * Draw 2 cards for each player and assign them to them
     */

    public void generarCartasJugadores() {

        Random r = new Random();
        int numPosicionCarta;

        numPosicionCarta = r.nextInt(52);

        for (int i = 0; i<this.jugadores.length;i++){
            for (int j = 0; j<2; j++){
                do {
                    if (baraja[numPosicionCarta].getPalo() != 'D') {
                        //TODO Revisar no se hace asi, deberia hacerse con un set
                        this.getCartasJugador(i)[j] = baraja[numPosicionCarta];
                        baraja[numPosicionCarta] = new CartaImpl();
                    }
                    numPosicionCarta = r.nextInt(52);
                } while (baraja[numPosicionCarta].getPalo() == 'D');
            }
        }

    }


    /*
     * SIGNATURA: public void generarCartaMesa();
     * COMENTARIO: Saca 1 cartas de la baraja y las coloca en el segundo array pasado por parametro
     * PRECONDICIONES: - El primer array debe tener 54 campos
     *                 - El segundo array debe tener 5 campos
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Un array de CartaImpl con todas las cartas posibles
     *                 - Un array de CartaImpl con las cartas de la mesa
     * POSTCONDICIONES: Modifica el array pasado por parametro eliminando las cartas que se saquen aleatoriamente y anhadiendose
     *                  al segundo array pasado por parametro que son las cartas de la mesa
     */

    //TODO Desarrollar javadoc

    public void generarCartaMesa() {

        Random r = new Random();
        int numPosicionCarta, indiceCartaGenerar = 0;

        numPosicionCarta = r.nextInt(52);

        //Calcula cual es la siguiente carta sin levantar y guarda el indice
        for (int i = 0; i < this.cartasMesa.length && this.cartasMesa[i].getPalo() != 'D'; i++) {
            if ((i + 1) <= this.cartasMesa.length) {
                if (this.cartasMesa[i + 1].getPalo() == 'D') {
                    indiceCartaGenerar = i + 1;
                }
            }
        }

        //Guarda la carta que se ha sacado de la baraja en las cartas de la mesa
        do {
            if (this.baraja[numPosicionCarta].getPalo() != 'D') {
                this.cartasMesa[indiceCartaGenerar] = this.baraja[numPosicionCarta];
                this.baraja[numPosicionCarta] = new CartaImpl();
            }
            numPosicionCarta = r.nextInt(52);
        } while (this.baraja[numPosicionCarta].getPalo() == 'D');

    }


    /*
     * SIGNATURA: public void cargarJugadores(JugadorImpl[] jugadores);
     * COMENTARIO: Carga un array pasado por parametros con jugadores aleatorios
     * PRECONDICIONES: - El array debe ser de JugadorImpl
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Array de JugadorImpl
     * POSTCONDICIONES: - Modifica el array de Jugadores pasado por parametro añadiendo usuarios aleatorios
     *
     */

    //TODO Desarrollar javadoc

    public void cargarBots(){

        Random random = new Random();
        String[] nombresAleatorios = {"Kun","Wang","YanYan","Zhao","Yun","Sasha","Volodia","Hedeon","Grigory"};
        for (int i = 1; i<jugadores.length;i++){
            this.jugadores[i] = new JugadorImpl(nombresAleatorios[random.nextInt(8)],jugadores[0].getSaldo());
        }

    }

    /**
     * This method add the carte passed by parameter to array of letters of table in the position passed by parameter
     * @param posicion position where the card is added
     * @param carta carte to add
     */

    public void anhadirCartaMesa(int posicion, CartaImpl carta){
        this.cartasMesa[posicion] = carta;
    }

    /*
     * SIGNATURA: public void limpiarCartasMesa()
     * COMENTARIO: Coloca todas las cartas de la mesa con palo D y numero D
     * PRECONDICIONES: - Nada
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Un array de CartaImpl
     * POSTCONDICIONES: Modifica el array pasado por parametro colocando todas las cartas de la mesa con palo D y numero D
     */

    /**
     * Set all the table cards by default
     */

    public void limpiarCartasMesa(){
        for (int i = 0; i<this.cartasMesa.length; i++){
            this.cartasMesa[i] = new CartaImpl();
        }
    }

    /*
     * SIGNATURA: public void restaurarBaraja()
     * COMENTARIO: Anhade todas las cartas posibles al array pasado por parametro
     * PRECONDICIONES: - El array debe tener como minimo 52 campos
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: Modifica el array pasado por parametro anhadiendo todas las cartas posibles
     */

    /**
     * Place all possible cards in the deck in an array
     */

    public void restaurarBaraja(){

        this.baraja[0] = new CartaImpl('P', "A");
        for (int i = 1, numero = 2; i<10;i++){
            this.baraja[i] = new CartaImpl('P', ""+numero);
            numero++;
        }
        this.baraja[10] = new CartaImpl('P', "J");
        this.baraja[11] = new CartaImpl('P', "Q");
        this.baraja[12] = new CartaImpl('P', "K");


        this.baraja[13] = new CartaImpl('C', "A");
        for (int i = 14, numero = 2; i<23;i++){
            this.baraja[i] = new CartaImpl('C', ""+numero);
            numero++;
        }
        this.baraja[23] = new CartaImpl('C', "J");
        this.baraja[24] = new CartaImpl('C', "Q");
        this.baraja[25] = new CartaImpl('C', "K");


        this.baraja[26] = new CartaImpl('R', "A");
        for (int i = 27, numero = 2; i<36;i++){
            this.baraja[i] = new CartaImpl('R', ""+numero);
            numero++;
        }
        this.baraja[36] = new CartaImpl('R', "J");
        this.baraja[37] = new CartaImpl('R', "Q");
        this.baraja[38] = new CartaImpl('R', "K");


        this.baraja[39] = new CartaImpl('T', "A");
        for (int i = 40, numero = 2; i<49;i++){
            this.baraja[i] = new CartaImpl('T', ""+numero);
            numero++;
        }
        this.baraja[49] = new CartaImpl('T', "J");
        this.baraja[50] = new CartaImpl('T', "Q");
        this.baraja[51] = new CartaImpl('T', "K");

    }


    /*
     * SIGNATURA: public void limpiarMesa()
     * COMENTARIO: Coloca en defecto todas las cartas del array pasado por parametro y coloca todas las apuestas de los jugadores a 0
     * PRECONDICIONES: - Nada
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: Modifica las cartas de la mesa colocandolas por defecto y coloca todas las apuestas a 0
     */

    /**
     * Change the cards of the table to default and set bets to 0
     */

    public void limpiarMesa() {
        for (int i = 0; i < this.getCartasMesa().length; i++) {
            this.getCartasMesa()[i] = new CartaImpl();
        }
        for (int i = 0; i < this.getApuestasJugadores().length; i++) {
            for (int j = 0; j < this.getApuestasJugadores().length; j++) {
                this.getApuestasJugadores()[i][j] = 0;
            }
        }
    }

    /*
     * SIGNATURA: public void generarTresCartasMesa(CartaImpl[] baraja, CartaImpl[] cartas);
     * COMENTARIO: Saca 3 cartas de la baraja y las coloca en el segundo array pasado por parametro
     * PRECONDICIONES: - El primer array debe tener 54 campos
     *                 - El segundo array debe tener 5 campos
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Un array de CartaImpl con todas las cartas posibles
     *                 - Un array de CartaImpl con las cartas de la mesa
     * POSTCONDICIONES: Modifica el array pasado por parametro eliminando las cartas que se saquen aleatoriamente y anhadiendose
     *                  al segundo array pasado por parametro que son las cartas de la mesa
     */

    //TODO Desarrollar javadoc
    //TODO Revisar interfaz

    public void generarTresCartasMesa() {

        Random r = new Random();
        int numPosicionCarta;

        numPosicionCarta = r.nextInt(52);
        for (int i = 0; i < 3; i++) {
            do {
                if (this.baraja[numPosicionCarta].getPalo() != 'D') {
                    this.cartasMesa[i] = this.baraja[numPosicionCarta];
                    this.baraja[numPosicionCarta] = new CartaImpl();
                }
                numPosicionCarta = r.nextInt(52);
            } while (this.baraja[numPosicionCarta].getPalo() == 'D');

        }

    }


    /*
     * SIGNATURA: public void realizarApuestas(int turnoJugador, MesaImpl mesa, int ronda)
     * COMENTARIO: Realizar las apuestas de todos los jugadores de la mesa
     * PRECONDICIONES:
     * ENTRADA: - Un entero con el turno
     *          - Un entero con la ronda
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Un objeto mesa
     * POSTCONDICIONES: - Modifica el objeto mesa, incrementando el total del dinero que hay en mesa.
     */

    /*
     * apuestaMinima = 0
     * jugadorPasa = false
     *
     * si (turnoJugador == 0)
     *  si (jugador[0].getActivo() == true)
     *      apuestaJugador = leerApuesta
     *      si (apuestaJugador > apuestaMinima)
     *          apuestaMinima = apuestaJugador
     *      sino
     *          si (apuestaJugador == apuestaMinima)
     *              jugadorPasa = true
     *          finSi
     *      finSi
     *  finSi
     *  turnoJugador++
     *  cantidadJugadas++
     *
     *  mientras(turnoJugador < 5 && cantidadJugadas < totalJugadas)
     *      si(jugador[turnoJugador].getActivo() == true)
     *          si(jugador[turnoJugador].getSalto > 0)
     *              apuestaJugador = calcularApuesta
     *              si(apuestaJugador != apuestaMinima || jugadorPasa == false)
     *                  jugadorPasa = false
     *                  si(apuestaJugador == 0)
     *                      jugador.seActivo(false)
     *                      sino
     *                          si(apuestaJugador == apuestaMinima)
     *                              jugador.disminuirSaldo(apuestaJugador)
     *                              mesa.anhadirApuesta(turnoJugador,ronda,apuestaJugador)
     *                          sino
     *                              si(apuestaJugador > apuestaMinima)
     *                                  cantidadJugadas += 4
     *                                  jugador.disminuirSaldo(apuestaJugador)
     *                                  mesa.anhadirApuesta(turnoJugador,ronda,apuestaJugador)
     *                              finSi
     *                          finSi
     *                   finSi
     *              finSi
     *          finSi
     *      finSi
     *      cantidadJugadas++
     *      si(turnoJugador < 4 && cantidadJugadas < jugadasTotal)
     *          turnoJugador == 0;
     *      sino
     *          turnoJugador++;
     *      finSi
     *  finMientras
     *
     *
     */


    //TODO Desarrollar javadoc
    //TODO Documentar codigo mejor
    //TODO Ver si se puede modular
    //TODO Disminuir dinero despues de todas las jugadas

    public void realizarApuestas(){
        GestoraJugadorImpl gesJug = new GestoraJugadorImpl();
        int apuestaMinima = 0, cantidadJugadas = 0, totalJugadas = 5, apuestaJugador, cantidadJugadoresPasan = 0;
        boolean jugadorPasa = false;
        for (JugadorImpl jugador: this.getJugadores()) {
            if (!jugador.getActivo()){
                cantidadJugadoresPasan ++;
            }
        }
        if (cantidadJugadoresPasan != 4) {
            if (this.obtenerJugador(this.turnoJugador).getActivo() && this.obtenerJugador(this.turnoJugador).getSaldo() > 0) {
                if (this.turnoJugador == 0){
                    apuestaJugador = gesJug.leerYValidarApuesta(this.obtenerJugador(this.turnoJugador), apuestaMinima);
                }else{
                    apuestaJugador = gesJug.calcularApostarBot(apuestaMinima,this,this.turnoJugador,this.ronda);
                }
                if (apuestaJugador > apuestaMinima) {
                    apuestaMinima = apuestaJugador;
                    this.anhadirApuesta(this.turnoJugador, this.ronda, apuestaMinima);
                    this.obtenerJugador(this.turnoJugador).disminuirDinero(apuestaMinima);
                } else {
                    //Si el jugador apuesta el mismo valor que la apuesta minima (es decir 0) significa que pasa
                    if (apuestaJugador == apuestaMinima) {
                        jugadorPasa = true;
                    }
                }
            }
            cantidadJugadas++;
            if (this.turnoJugador == 4 && cantidadJugadas < totalJugadas) {
                this.turnoJugador = 0;
            } else {
                this.turnoJugador++;
            }
            while (turnoJugador < 5 && cantidadJugadas < totalJugadas) {
                if (this.obtenerJugador(this.turnoJugador).getActivo() && this.obtenerJugador(this.turnoJugador).getSaldo() > 0) {
                    if (this.turnoJugador == 0){
                        apuestaJugador = gesJug.leerYValidarApuesta(this.obtenerJugador(this.turnoJugador),apuestaMinima);
                    }else{
                        apuestaJugador = gesJug.calcularApostarBot(apuestaMinima, this, this.turnoJugador,this.ronda);
                        //TODO En el caso de querer apostar y no poder por no llegar al minimo que haga all-in  (Creo que ya esta solucionado pero tengo que comprobarlo)
                    }
                    if (apuestaJugador != apuestaMinima || jugadorPasa) {
                        jugadorPasa = false;
                        if (apuestaJugador == 0) {
                            this.obtenerJugador(this.turnoJugador).setActivo(false);
                        } else {
                            if (apuestaJugador > apuestaMinima) {
                                apuestaMinima = apuestaJugador;
                                if ((totalJugadas-cantidadJugadas) < 5){
                                    totalJugadas += 4;
                                }else{
                                    totalJugadas++;
                                }
                                this.obtenerJugador(this.turnoJugador).disminuirDinero(apuestaJugador);
                                this.anhadirApuesta(this.turnoJugador, this.ronda, apuestaJugador);
                            } else {
                                this.obtenerJugador(this.turnoJugador).disminuirDinero(apuestaJugador);
                                this.anhadirApuesta(this.turnoJugador, this.ronda, apuestaJugador);
                            }
                        }
                    } else {
                        this.obtenerJugador(this.turnoJugador).disminuirDinero(apuestaJugador);
                        this.anhadirApuesta(this.turnoJugador, this.ronda, apuestaJugador);
                    }
                }
                //Actualizamos variables despues de realizar jugada
                cantidadJugadas++;
                if (this.turnoJugador == 4 && cantidadJugadas < totalJugadas) {
                    this.turnoJugador = 0;
                } else {
                    this.turnoJugador++;
                }
            }
        }
        this.ronda++;
    }



    /*
     * SIGNATURA: public int[] obtenerGanadores(MesaImpl mesa)
     * COMENTARIO: Calcula quienes son los ganadores de la ronda
     * PRECONDICIONES:
     * ENTRADA: - Un objeto mesa
     * SALIDA: - Un array de enteros
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre la cantidad de ganadores posibles
     */

    //TODO Javadoc
    //TODO Hacer

    public int[] obtenerGanadores(){
        int[] cantGanadores = {0,0,0};

        //Calcular posibles ganadores
        ArrayList<Integer> posiblesGanadores = new ArrayList<>();
        JugadorImpl[] jugadores = this.jugadores;
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i].getActivo()){
                posiblesGanadores.add(i);
            }
        }

        return cantGanadores;
    }


    /*
     * SIGNATURA: public void ingresarDineroGanador(int ganador, MesaImpl mesa);
     * COMENTARIO: Aumenta el saldo del usuario ganador de la mano
     * PRECONDICIONES: - El ganador no puede ser menor de 0 ni mayor de 5
     * ENTRADA: - Un entero con el ganador
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Un objeto mesa
     * POSTCONDICIONES: - Modifica el objeto mesa incrementando el saldo del usuario ganador con el total de apuestas de la mano jugada.
     *
     */

    //TODO Desarrollar javadoc
    //TODO Revisar

    public void ingresarDineroGanador(int ganador) {
        int cantidadMesa;
        cantidadMesa = this.getTotalApuestas();
        this.jugadores[ganador].aumentarDinero(cantidadMesa);
    }


    /*
     * SIGNATURA: public void ingresarDineroGanador(int ganador, MesaImpl mesa);
     * COMENTARIO: Aumenta el saldo del usuario ganador de la mano
     * PRECONDICIONES: - El ganador no puede ser menor de 0 ni mayor de 5
     * ENTRADA: - Un entero con el ganador
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Un objeto mesa
     * POSTCONDICIONES: - Modifica el objeto mesa incrementando el saldo del usuario ganador con el total de apuestas de la mano jugada.
     *
     */

    //TODO Desarrollar javadoc
    //TODO Revisar

    public void incrementarTurno(){
        if (this.turnoJugador == 4){
            this.turnoJugador = 0;
        }else{
            this.turnoJugador++;
        }
    }


    /*
     * SIGNATURA: public void mostrarPanelJuego (MesaImpl mesa, int ronda);
     * COMENTARIO: Imprime por pantalla las cartas que hay en la mesa, el dinero de los demas jugadores y el total del bote de la mesa
     * PRECONDICIONES: - Nada
     * ENTRADA: - Un objeto Mesa
     *          - Un entero
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - No devuelve nada, solo imprime por pantalla el estado actual en el que se encuentran los jugadores y las cartas
     */

    //TODO Desarrollar javadoc
    //TODO Utilizar arraybidimensional para esto
    //TODO Controlar cuando sea la ultima ronda para que muestre informacion adiciona sobre quien ha ganado y mostrar todas las cartas
    //TODO Implementar imprimir por rondas

    public void mostrarPanelJuego() {

        String numCar1Usuario, numCar2Usuario;
        char paloCar1Usuario, paloCar2Usuario;

        numCar1Usuario = this.obtenerJugador(0).obtenerCarta(0).getNumero();
        numCar2Usuario = this.obtenerJugador(0).obtenerCarta(1).getNumero();

        paloCar1Usuario = this.getJugadores()[0].getCartas()[0].getPalo();
        paloCar2Usuario = this.getJugadores()[0].getCartas()[1].getPalo();


        String[] usersJugadores = new String[5];
        //TODO Revisar esto. Se deberia hacer patron delegacion
        for (int i = 0; i<usersJugadores.length;i++){
            usersJugadores[i] = this.getJugadores()[i].getUsuario();
        }

        int[] saldoJugadores = new int[5];
        //TODO Revisar esto. Se deberia hacer patron delegacion
        for (int i = 0; i<saldoJugadores.length;i++){
            saldoJugadores[i] = this.getJugadores()[i].getSaldo();
        }

        char[] palosCartasMesa = new char[5];
        //TODO Revisar esto. Se deberia hacer patron delegacion
        for (int i = 0; i<palosCartasMesa.length;i++){
            palosCartasMesa[i] = this.getCartasMesa()[i].getPalo();
        }

        String[] numerosCartasMesa = new String[5];
        //TODO Revisar esto. Se deberia hacer patron delegacion
        for (int i = 0; i<numerosCartasMesa.length;i++){
            numerosCartasMesa[i] = this.getCartasMesa()[i].getNumero();
        }


        System.out.println("                                      " + usersJugadores[2] + "                                       " + usersJugadores[3]);
        System.out.println();
        System.out.println("                                      " + saldoJugadores[2] + "€                                               " + saldoJugadores[3] + "€");
        System.out.println("                                      |º º|     -----        -----                                    |º º|    -----        -----");
        System.out.println("                                      |---|    | ?   |      | ?   |                                   |---|   | ?   |      | ?   |  ");
        System.out.println("                                               | ?   |      | ?   |                                           | ?   |      | ?   |");
        System.out.println("                                                -----        -----                                             -----        -----");



        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("       " + usersJugadores[1] + "                                                                                                                              " + usersJugadores[4]);
        System.out.println("                                                        ----- " + "       " + " ----- " + "       " + " ----- " + "       " + " ----- " + "       " + " ----- ");
        System.out.println("       " + saldoJugadores[1] + "€                                           | " + palosCartasMesa[0] + "   |" + "       " + "| " + palosCartasMesa[1] + "   |" + "       " + "| " + palosCartasMesa[2] + "   |" + "       " + "| " + palosCartasMesa[3] + "   |" + "       " + "| " + palosCartasMesa[4] + "   |                      " + saldoJugadores[4] + "€");
        System.out.println("       |º º|       -----        -----                  | " + numerosCartasMesa[0] + "   |" + "       " + "| " + numerosCartasMesa[1] + "   |" + "       " + "| " + numerosCartasMesa[2] + "   |" + "       " + "| " + numerosCartasMesa[3] + "   |" + "       " + "| " + numerosCartasMesa[4] + "   |                      |º º|      -----        -----");
        System.out.println("       |---|      | ?   |      | ?   |                 |     |" + "       " + "|     |" + "       " + "|     |" + "       " + "|     |" + "       " + "|     |" + "                      |---|     | ?   |      | ?   |");
        System.out.println("                  | ?   |      | ?   |                  ----- " + "       " + " ----- " + "       " + " ----- " + "       " + " ----- " + "       " + " -----                                 |     | ?    | ?   |");
        System.out.println("                   -----        -----                                                                                                                  -----        -----");

        System.out.println();
        System.out.println("                                                              DINERO EN MESA: " + this.getTotalApuestas() + "€");
        System.out.println();
        System.out.println();

        System.out.println("                                                                     " + usersJugadores[0]);
        System.out.println("                                                              TU SALDO ES: " + saldoJugadores[0] + "€");
        System.out.println();
        System.out.println("                                                           _______________________");
        System.out.println("                                                          |                       |");
        System.out.println("                                                          |    __           __    |");
        System.out.println("                                                          |   |º |         |º |   |            ----------           ----------");
        System.out.println("                                                          |    --           --    |           | "+paloCar1Usuario+"        |         | "+paloCar2Usuario+"        |");
        System.out.println("                                                          |                       |           | "+numCar1Usuario+"        |         | "+numCar2Usuario+"        |");
        System.out.println("                                                          |   \\              /    |           |          |         |          |");
        System.out.println("                                                          |     \\___________/     |           |          |         |          |");
        System.out.println("                                                          |                       |            ----------           ----------");
        System.out.println("                                                           -----------------------");
        System.out.println();

    }


    /**
     * This method returns the player of the position passed by parameter
     * @param posicion position of the player you want to get
     * @return JugadorImpl player yo want to get
     */

    public JugadorImpl obtenerJugador(int posicion){
        return this.jugadores[posicion];
    }

    /**
     * This method adds the player or parameter passed to the array of players
     * @param posicion position where the player wants to add
     * @param jugador player you want to add
     */

    public void anhadirJugador(int posicion, JugadorImpl jugador){
        this.jugadores[posicion] = jugador;
    }

    /**
     * Add user bet in an exact round
     * @param jugador int index of the user you want set bet
     * @param rondaApuesta int index of the round you want set bet
     * @param cantidad int amount to add
     */

    public void anhadirApuesta(int jugador, int rondaApuesta, int cantidad){
        this.apuestasJugadores[jugador][rondaApuesta] += cantidad;
    }

    /**
     * Add cards passed by parameter to the player
     * @param jugador int position of player where do you want add the cards passed by parameter
     * @param cartas CartaImpl[] with the cards you want to add to the player
     */

    public void anhadirCartasJugador(int jugador, CartaImpl[] cartas){
        this.jugadores[jugador].setCartas(cartas);
    }

    /**
     * Get user bet in an exact round
     * @param jugador int index of the user you want get bet
     * @param rondaApuesta int index of the round you want get bet
     * @return int bet of the user in the round
     */

    public int obtenerApuesta(int jugador, int rondaApuesta){
        return this.apuestasJugadores[jugador][rondaApuesta];
    }


    /**
     * This method return a String with attributes of the table
     * @return String with attributes of the table
     */

    @Override
    public String toString(){
        return this.getBaraja().toString()+"  "+this.getJugadores().toString()+"  "+this.getCartasMesa().toString()+"  "+this.getApuestasJugadores().toString();
    }

    /**
     * This method return an int with value of hashCode of the table
     * @return int with value of hashCode of the table
     */

    @Override
    public int hashCode(){
        return this.getTotalApuestas()+this.getJugadores().hashCode();
    }

    /**
     * This method returns a Boolean value depending on whether the value of the table passed by parameter is equal to that compared
     * @return boolean its value depending on whether the value of the table passed by parameter is equal to that compared
     */

    @Override
    public boolean equals(Object objeto){
        boolean resul = false;
        if (this == objeto){
            resul = true;
        }else{
            if (objeto != null && objeto instanceof MesaImpl){
                MesaImpl nueva = (MesaImpl) objeto;
                if (this.getBaraja()==nueva.getBaraja()
                    && this.getCartasMesa()==nueva.getCartasMesa()
                    && this.getJugadores()==nueva.getJugadores()
                    && this.getApuestasJugadores()==nueva.getApuestasJugadores()){
                    resul = true;
                }
            }
        }
        return resul;
    }

    /**
     * This method returns a object MesaImpl cloned from which it is called
     * @return MesaImpl Cloned table
     */

    @Override
    public MesaImpl clone() {
        MesaImpl mesa = null;
        try {
            mesa = (MesaImpl) super.clone();
        } catch(CloneNotSupportedException error) {
            System.out.println("Error en la copia");
        }
        return mesa;
    }



}
