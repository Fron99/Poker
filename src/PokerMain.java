/*
 * Programa: PokerMain.java
 * Comentario: Este programa trata sobre un juego de poker tradicional pero informatizado y de una manera en la que se puede jugar solo sin nadie mas.
 *              Este programa incluye una serie de funcionalidades que hace que los demas jugadores de la mesa en la que juegas "piensen" sus apuestas.
 *              Cada bot que hay en la mesa realiza las apuestas en funcion de las cartas que tienen y de las posibilidades que creen que tienen de ganar la partida.
 *
 * Entrada:
 *  - Un String con el usuario
 *  - Un int con la cantidad de saldo inicial
 *
 * Salida:
 *  - Mensajes al usuario
 *  - Eco de los datos
 *  - Resultado de las acciones elegidas por el usuario
 *
 * Restricciones:
 *  - El saldo inicial no puede ser menor de 2000€ ni superior a 10000€
 *
 * PG0
 * INICIO
 *  leerUsuario*
 *  leerYValidarSaldoInicial*
 *  //añadirJugador
 *  cargarBots*
 *  //generarTurnoJugador
 *  repetir
 *      limpiarMesa*
 *      restaurarBaraja*
 *      generarCartasJugadores*
 *      colocarJugadoresActivos*
 *      mostrarPanelJuego*
 *      realizarApuestas*
 *      generarTresCartasMesa*
 *      mostrarPanelJuego*
 *      realizarApuestas*
 *      para(contador = 0; contador < 2; contador++)
 *          generarCartaMesa*
 *          mostrarPanelJuego*
 *          realizarApuestas*
 *      finPara
 *      mostrarPanelJuegoCompleto*
 *      calcularCantidadGanadores*
 *      si(cantidad ganadores > 1)
 *          obtenerGanadores*
 *          ingresarSaldoGanadores*
 *      sino
 *          obtenerGanador*
 *          ingresarSaldoGanador*
 *      finSi
 *      si(turno jugador == 4)
 *          turno jugador = 0
 *      sino
 *          //incrementar turno jugador
 *      finSi
 *  mientras(saldo usuario > 0 && queden bots con saldo)
 *  //mostrarJuegosFin
 * FIN
 *
 */


import Clases.Basicas.JugadorImpl;
import Clases.Basicas.MesaImpl;
import Clases.Gestoras.GestoraJugadorImpl;
import Clases.Gestoras.GestoraMesaImpl;
import Clases.Resguardos.ResguardosMesaImpl;


import java.util.Random;

public class PokerMain {

    public static void main (String[] args){

        Random random = new Random();
        GestoraJugadorImpl gesJugador = new GestoraJugadorImpl();
        GestoraMesaImpl gesMesa = new GestoraMesaImpl();
        ResguardosMesaImpl resMesa = new ResguardosMesaImpl();

        String usuarioJugador;
        int saldoInicialJugador, turnoJugador, cantidadGanadores = 0;
        MesaImpl mesa = new MesaImpl();
        int ronda;

        //leerUsuario
        usuarioJugador = gesJugador.leerUsuario();

        //leerYValidarDineroInicial
        saldoInicialJugador = gesJugador.leerYValidarSaldoInicial();

        //añadirJugador
        //El usuario que juega se colocara siempre en la posicion 0
        mesa.anhadirJugador(0,new JugadorImpl(usuarioJugador,saldoInicialJugador));

        //cargarBots
        gesJugador.cargarBots(mesa.getJugadores());  //Coloca en el array de jugadores jugadores con valores generados

        //generarTurnoJugador
        //turnoJugador = random.nextInt(5);   //Genera un numero del 0 al 4 que es la cantidad de jugadores que hay para saber quien empieza a apostar
        turnoJugador = 1;
        do {

            ronda = 0;

            //limpiarMesa
            gesMesa.limpiarMesa(mesa);      //TODO Barajar posibilidad de introducirlo como metodo de mesa

            //restaurarBaraja
            mesa.restaurarBaraja();

            //generarCartasJugadores
            gesMesa.generarCartasJugadores(mesa.getBaraja(),mesa);    //Asigna 2 cartas a cada jugador sin reeptir carta.

            //colocarActivosJugadores
            gesJugador.colocarJugadoresActivos(mesa);

            //mostrarPanelJuego
            gesMesa.mostrarPanelJuego(mesa,ronda);

            //realizarApuestas
            gesMesa.realizarApuestas(turnoJugador,mesa,ronda);     //Pide la cantidad de dinero que se quiere apostar a cada jugador en su orden correspondiente
            ronda++;

            //generarTresCartasMesa
            gesMesa.generarTresCartasMesa(mesa.getBaraja(),mesa.getCartasMesa());  //Coloca 3 cartas aleatorias en el array de las cartas que hay en esta mesa

            //mostrarPanelJuego
            gesMesa.mostrarPanelJuego(mesa,ronda);

            //realizarApuestas
            gesMesa.realizarApuestas(turnoJugador,mesa,ronda);     //Pide la cantidad de dinero que se quiere apostar a cada jugador en su orden correspondiente
            ronda++;

            for (int contador = 0; contador < 2; contador++){

                //generarCartaMesa
                gesMesa.generarCartaMesa(mesa.getBaraja(),mesa.getCartasMesa());

                //mostrarPanelJuego
                gesMesa.mostrarPanelJuego(mesa,ronda);

                //realizarApuestas
                gesMesa.realizarApuestas(turnoJugador,mesa,ronda);     //Pide la cantidad de dinero que se quiere apostar a cada jugador en su orden correspondiente
                ronda++;

            }

            //mostrarPanelJuegoCompleto
            gesMesa.mostrarPanelJuego(mesa,ronda);

            //calcularCantidadGanadores

            if (cantidadGanadores > 1){
                //obtenerGanadores
                //ingresarSaldoGanadores
            }else{
                //obtenerGanador
                //ingresarSaldoGanador
            }

            if (turnoJugador == 4){
                turnoJugador = 0;
            }else{
                turnoJugador++; //incrementar turno jugador
            }

        }while (mesa.getJugadores()[0].getSaldo()>0);

        System.out.println("El jugador "+usuarioJugador+" empezo con "+saldoInicialJugador+" y acabo con "+(saldoInicialJugador-mesa.getJugadores()[0].getSaldo())+"");

    }

}
