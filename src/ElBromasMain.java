/*
 *
 * PG0
 * INICIO
 *
 *  leerUsuario*
 *  leerYValidarDineroInicial*
 *  cargarBots*
 *  //generarTurnoJugador
 *  repetir
 *      restaurarBaraja*
 *      limpiarMesa*
 *      generar3Cartas*
 *      mostrarPanelJuego*
 *      realizarJugadas*
 *      generarCarta*
 *      mostrarPanelJuego*
 *      realizarJugadas*
 *      generarCarta*
 *      mostrarPanelJuego*
 *      realizarJugadas*
 *      calcularGanador*
 *      ingresarDineroGanador*
 *      //incrementarTurnoJugador
 *  mientras(usuario tenga dinero y queden bots)
 *
 * FIN
 *
 *
 * //realizarJugadas*
 *
 * PG1
 * INICIO
 * si(turnoJugador == idUsuario)
 *  //leerYValidarApuestaJugador
 *  mientras(queden bots sin apostar)
 *      //generarCantidadApuesta
 *      //incrementarTotalApuestas
 *  finMientras
 * siNo
 *  mientras(no se llegue al final del array)
 *      //generarCantidadApuesta
 *      //incrementarTotalApuestas
 *  finMientras
 *  //leerYValidarApuestaJugador
 *  //incrementarTotalApuestas
 *  mientras(queden bots sin apostar)
 *      //generarCantidadApuesta
 *      //incrementarTotalApuestas
 *  finMientras
 * finSi
 * FIN
 *
 */


import Clases.Basicas.CartaImpl;
import Clases.Basicas.JugadorImpl;
import Clases.Basicas.MesaImpl;
import Clases.Gestoras.GestoraJugadorImpl;
import Clases.Gestoras.GestoraMesaImpl;
import Clases.Resguardos.ResguardosMesaImpl;


import java.util.Random;
import java.util.Scanner;

public class ElBromasMain {

    public static void main (String[] args){

        Random random = new Random();
        GestoraJugadorImpl gesJugador = new GestoraJugadorImpl();
        GestoraMesaImpl gesMesa = new GestoraMesaImpl();
        ResguardosMesaImpl resMesa = new ResguardosMesaImpl();

        String usuarioJugador;
        int dineroInicialJugador, turnoJugador, jugadorGanador;
        MesaImpl mesa = new MesaImpl();
        CartaImpl[] baraja = new CartaImpl[54];

        //leerUsuario
        usuarioJugador = gesJugador.leerUsuario();

        //leerYValidarDineroInicial
        dineroInicialJugador = gesJugador.leerYValidarDineroInicial();

        //El usuario que juega se colocara siempre en la posicion 0
        mesa.anhadirJugador(0,new JugadorImpl(usuarioJugador,dineroInicialJugador));

        //cargarBots
        gesJugador.cargarJugadores(mesa.getJugadores());  //Coloca en el array de jugadores jugadores con valores generados

        //generarIniciador

        turnoJugador = random.nextInt(5);   //Genera un numero del 0 al 4 que es la cantidad de jugadores que hay
        //para saber quien empieza a apostar

        //do {

            //restaurarCartas
            gesMesa.inicializarBaraja(baraja);

            //limpiarMesa
            gesMesa.limpiarMesa(mesa.getCartasMesa());

            //generar3Cartas
            gesMesa.generar3Cartas(baraja,mesa.getCartasMesa());  //Coloca 3 cartas aleatorias en el array de las cartas que hay en esta mesa

            //mostrarPanelJuego
            gesMesa.mostrarPanelJuego(mesa);

            //realizarJugadas
            resMesa.realizarJugadas(turnoJugador,mesa);     //Pide la cantidad de dinero que se quiere apostar a cada jugador en su orden correspondiente

            //generarCarta
            gesMesa.generarCarta(baraja,mesa.getCartasMesa());

            //mostrarPanelJuego
            gesMesa.mostrarPanelJuego(mesa);

            //realizarJugadas
            resMesa.realizarJugadas(turnoJugador,mesa);     //Pide la cantidad de dinero que se quiere apostar a cada jugador en su orden correspondiente

            //generarCarta
            gesMesa.generarCarta(baraja,mesa.getCartasMesa());

            //mostrarPanelJuego
            gesMesa.mostrarPanelJuego(mesa);

            //realizarJugadas
            resMesa.realizarJugadas(turnoJugador,mesa);     //Pide la cantidad de dinero que se quiere apostar a cada jugador en su orden correspondiente

            //calcularGanador
            jugadorGanador = resMesa.calcularGanador(mesa);

            //calcularGanador
            resMesa.ingresarDineroGanador(jugadorGanador,mesa);

            //incrementarTurnoJugador
            if (turnoJugador < 4){
                turnoJugador++;
            }else{
                turnoJugador = 0;
            }

        //}while (mesa.getJugadores()[0].getDinero()>0);





           /*
            turnoJugador = random.nextInt(5);
            if (turnoJugador == jugadores[0].getID()){
                apuestaInicial = gesJugador.leerYValidarApuesta(jugadores[0]);
                totalApuestas += apuestaInicial;
                turnoJugador++;
                while (turnoJugador<jugadores.length){
                    totalApuestas += apuestaInicial;
                    turnoJugador++;
                }
           }else{
                while (turnoJugador<jugadores.length){
                    apuestaInicial = 2000;
                    totalApuestas += apuestaInicial;
                    turnoJugador++;
                    cantidadJugadas++;
                }
                if(cantidadJugadas<5){
                    apuestaJugador = gesJugador.leerYValidarApuesta(jugadores[0]);
                    totalApuestas += apuestaJugador;
                }
           }*/



    }

}
