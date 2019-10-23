/*
 *
 * PG0
 * INICIO
 *
 *  leerUsuario*
 *  leerYValidarDineroInicial*
 *  cargarBots*
 *  repetir
 *      restaurarBaraja*
 *      limpiarMesa*
 *      sacar3Cartas*
 *      mostrarJuegoPrimeraMano*
 *      //generarIniciador
 *      realizarJugadas*
 *      //incrementarIniciador
 *      generarCartas*
 *      mostrarCartas*
 *      realizarJugadas*
 *      //incrementarIniciador
 *      generarCartas*
 *      mostrarCartas*
 *      realizarJugadas*
 *      calcularGanador*
 *      ingresarDineroGanador*
 *  mientras(usuario tenga dinero y queden bots)
 *
 * FIN
 *
 *
 * //realizarJugadas*
 *
 * PG1
 * INICIO
 * si(iniciador == idUsuario)
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


import java.util.Random;
import java.util.Scanner;

public class ElBromasMain {

    public static void main (String[] args){

        Random random = new Random();
        Scanner teclado = new Scanner(System.in);
        GestoraJugadorImpl gesJugador = new GestoraJugadorImpl();
        GestoraMesaImpl gesMesa = new GestoraMesaImpl();

        String usuarioJugador = "DEFECTO";
        int dineroInicialJugador = 5000, turnoJugador, apuestaInicial = 0, totalApuestas = 0, cantidadJugadas = 0, apuestaJugador;
        MesaImpl mesa = new MesaImpl();
        CartaImpl[] baraja = new CartaImpl[54];

        //leerUsuario
        //usuarioJugador = gesJugador.leerUsuario();

        //leerYValidarDineroInicial
        //dineroInicialJugador = gesJugador.leerYValidarDineroInicial();

        //El usuario que juega se colocara siempre en la posicion 0
        mesa.anhadirJugador(0,new JugadorImpl(usuarioJugador,dineroInicialJugador));

        //cargarBots
        gesJugador.cargarJugadores(mesa.getJugadores());  //Coloca en el array de jugadores jugadores con valores generados


        //do {

            //restaurarCartas
            gesMesa.inicializarBaraja(baraja);

            //limpiarMesa
            gesMesa.limpiarMesa(mesa.getCartasMesa());

            //sacar3Cartas
            gesMesa.sacar3Cartas(baraja,mesa.getCartasMesa());  //Coloca 3 cartas aleatorias en el array de las cartas que hay en esta mesa

            gesMesa.mostrarJuegoPrimeraMano(mesa);












/*

 *      mostrarJuegoPrimeraMano*
 *      //generarIniciador
 *      realizarJugadas*
 *      //incrementarIniciador
 *      generarCartas*




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
        }*/

        System.out.println("En construccion");

    }

}
