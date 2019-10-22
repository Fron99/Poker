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
 *  mientras(usuario tenga dinero)
 *
 * FIN
 *
 */


import Clases.Basicas.CartaImpl;
import Clases.Basicas.JugadorImpl;
import Clases.Basicas.ManoImpl;
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
        ManoImpl mesa = new ManoImpl();

        cartas[0]= new CartaImpl('P',"A");
        cartas[1]= new CartaImpl('P',"2");
        cartas[2]= new CartaImpl('P',"3");
        cartas[3]= new CartaImpl('P',"4");
        cartas[4]= new CartaImpl('P',"5");
        cartas[5]= new CartaImpl('P',"6");
        cartas[6]= new CartaImpl('P',"7");
        cartas[7]= new CartaImpl('P',"8");
        cartas[8]= new CartaImpl('P',"9");
        cartas[9]= new CartaImpl('P',"10");
        cartas[10]= new CartaImpl('P',"J");
        cartas[11]= new CartaImpl('P',"Q");
        cartas[12]= new CartaImpl('P',"K");

        cartas[13]= new CartaImpl('C',"A");
        cartas[14]= new CartaImpl('C',"2");
        cartas[15]= new CartaImpl('C',"3");
        cartas[16]= new CartaImpl('C',"4");
        cartas[17]= new CartaImpl('C',"5");
        cartas[18]= new CartaImpl('C',"6");
        cartas[19]= new CartaImpl('C',"7");
        cartas[20]= new CartaImpl('C',"8");
        cartas[21]= new CartaImpl('C',"9");
        cartas[22]= new CartaImpl('C',"10");
        cartas[23]= new CartaImpl('C',"J");
        cartas[24]= new CartaImpl('C',"Q");
        cartas[25]= new CartaImpl('C',"K");

        cartas[26]= new CartaImpl('R',"A");
        cartas[27]= new CartaImpl('R',"2");
        cartas[28]= new CartaImpl('R',"3");
        cartas[29]= new CartaImpl('R',"4");
        cartas[30]= new CartaImpl('R',"5");
        cartas[31]= new CartaImpl('R',"6");
        cartas[32]= new CartaImpl('R',"7");
        cartas[33]= new CartaImpl('R',"8");
        cartas[34]= new CartaImpl('R',"9");
        cartas[35]= new CartaImpl('R',"10");
        cartas[36]= new CartaImpl('R',"J");
        cartas[37]= new CartaImpl('R',"Q");
        cartas[38]= new CartaImpl('R',"K");

        cartas[39]= new CartaImpl('T',"A");
        cartas[40]= new CartaImpl('T',"2");
        cartas[41]= new CartaImpl('T',"3");
        cartas[42]= new CartaImpl('T',"4");
        cartas[43]= new CartaImpl('T',"5");
        cartas[44]= new CartaImpl('T',"6");
        cartas[45]= new CartaImpl('T',"7");
        cartas[46]= new CartaImpl('T',"8");
        cartas[47]= new CartaImpl('T',"9");
        cartas[48]= new CartaImpl('T',"10");
        cartas[49]= new CartaImpl('T',"J");
        cartas[50]= new CartaImpl('T',"Q");
        cartas[51]= new CartaImpl('T',"K");

        cartas[52]= new CartaImpl('J',"0");
        cartas[53]= new CartaImpl('J',"0");


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
