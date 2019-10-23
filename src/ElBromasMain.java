/*
 *
 * PG0
 * INICIO
 *
 *  //leerUsuario
 *  //leerYValidarDineroInicial
 *  //cargarBots
 *  repetir
 *      //generar3Cartas
 *      //mostrar3Cartas
 *      //generarIniciador
 *      si(iniciador == idUsuario)
 *          //leerYValidarApuestaJugador
 *          mientras(queden bots sin apostar)
 *              //generarCantidadApuesta
 *              //incrementarTotalApuestas
 *          finMientras
 *      siNo
 *          mientras(no se llegue al final del array)
 *              //generarCantidadApuesta
 *              //incrementarTotalApuestas
 *          finMientras
 *          //leerYValidarApuestaJugador
 *          //incrementarTotalApuestas
 *          mientras(queden bots sin apostar)
 *              //generarCantidadApuesta
 *              //incrementarTotalApuestas
 *          finMientras
 *      finSi
 *      //incrementarIniciador
 *      //generarCartas
 *      //mostrarCartas
 *      si(iniciador == idUsuario)
 *          //leerYValidarApuestaJugador
 *          mientras(queden bots sin apostar)
 *              //generarCantidadApuesta
 *              //incrementarTotalApuestas
 *          finMientras
 *      siNo
 *          mientras(no se llegue al final del array)
 *              //generarCantidadApuesta
 *              //incrementarTotalApuestas
 *          finMientras
 *          //leerYValidarApuestaJugador
 *          //incrementarTotalApuestas
 *          mientras(queden bots sin apostar)
 *              //generarCantidadApuesta
 *              //incrementarTotalApuestas
 *          finMientras
 *      finSi
 *      //incrementarIniciador
 *      //generarCartas
 *      //mostrarCartas
 *      si(iniciador == idUsuario)
 *          //leerYValidarApuestaJugador
 *          mientras(queden bots sin apostar)
 *              //generarCantidadApuesta
 *              //incrementarTotalApuestas
 *          finMientras
 *      siNo
 *          mientras(no se llegue al final del array)
 *              //generarCantidadApuesta
 *              //incrementarTotalApuestas
 *          finMientras
 *          //leerYValidarApuestaJugador
 *          //incrementarTotalApuestas
 *          mientras(queden bots sin apostar)
 *              //generarCantidadApuesta
 *              //incrementarTotalApuestas
 *          finMientras
 *      finSi
 *      //calcularGanador
 *      //ingresarDineroGanador
 *  mientras(usuario tenga dinero y queden usuarios)
 *
 * FIN
 *
 */


import Clases.Basicas.CartaImpl;
import Clases.Basicas.JugadorImpl;
import Clases.Basicas.MesaImpl;
import Clases.Gestoras.GestoraJugadorImpl;



import java.util.Random;
import java.util.Scanner;

public class ElBromasMain {

    public static void main (String[] args){

        Random random = new Random();
        Scanner teclado = new Scanner(System.in);
        GestoraJugadorImpl gesJugador = new GestoraJugadorImpl();

        String usuarioJugador;
        int dineroInicialJugador, turnoJugador, apuestaInicial = 0, totalApuestas = 0, cantidadJugadas = 0, apuestaJugador;
        JugadorImpl[] jugadores = new JugadorImpl[5];
        CartaImpl[] cartas = new CartaImpl[54];
        MesaImpl mesa = new MesaImpl();

        //leerUsuario
        usuarioJugador = gesJugador.leerUsuario();

        //leerYValidarDineroInicial
        dineroInicialJugador = gesJugador.leerYValidarDineroInicial();

        jugadores[0] = new JugadorImpl(usuarioJugador,dineroInicialJugador);

        //cargarBots
        gesJugador.cargarJugadores(jugadores);

        do {
           //generarIniciador
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
           }

        }while (jugadores[0].getDinero()>0);

        for ( JugadorImpl usuario : jugadores ) {
            System.out.println(usuario.toString());
        }

        System.out.println("En construccion");

    }

}
