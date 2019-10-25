/*
 *
 * PG0
 * INICIO
 *
 *  leerUsuario*
 *  leerYValidarDineroInicial*
 *  //añadirJugador
 *  cargarBots*
 *  //generarTurnoJugador
 *  repetir
 *      restaurarBaraja*
 *      limpiarMesa*
 *      generarCartasJugadores*
 *      generar3Cartas*
 *      mostrarPanelJuego*
 *      realizarJugadas*
 *      generarCarta*
 *      mostrarPanelJuego*
 *      realizarJugadas*
 *      generarCarta*
 *      mostrarPanelJuego*
 *      realizarJugadas*
 *      mostrarPanelJuego*
 *      calcularGanador*
 *      ingresarDineroGanador*
 *      //incrementarTurnoJugador
 *  mientras(usuario tenga dinero y queden bots)
 *
 * FIN
 *
 * //realizarJugadas*
 *
 * PG1
 *
 */


import Clases.Basicas.CartaImpl;
import Clases.Basicas.JugadorImpl;
import Clases.Basicas.MesaImpl;
import Clases.Gestoras.GestoraJugadorImpl;
import Clases.Gestoras.GestoraMesaImpl;
import Clases.Resguardos.ResguardosMesaImpl;


import java.util.Random;

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
        gesJugador.cargarBots(mesa.getJugadores());  //Coloca en el array de jugadores jugadores con valores generados


        //generarIniciador
        turnoJugador = random.nextInt(5);   //Genera un numero del 0 al 4 que es la cantidad de jugadores que hay
                                                    //para saber quien empieza a aposta

        do {
            //restaurarBaraja
            gesMesa.inicializarBaraja(baraja);

            //limpiarMesa
            gesMesa.limpiarMesa(mesa);

            //generarCartasJugadores
            gesMesa.generarCartasJugadores(baraja,mesa);    //Asigna 2 cartas a cada jugador sin reeptir carta.

            //mostrarPanelJuego
            gesMesa.mostrarPanelJuego(mesa);

            //generar3Cartas
            gesMesa.generar3Cartas(baraja,mesa.getCartasMesa());  //Coloca 3 cartas aleatorias en el array de las cartas que hay en esta mesa

            //realizarJugadas
            gesMesa.realizarApuestas(turnoJugador,mesa);     //Pide la cantidad de dinero que se quiere apostar a cada jugador en su orden correspondiente

            //generarCarta
            gesMesa.generarCarta(baraja,mesa.getCartasMesa());

            //mostrarPanelJuego
            gesMesa.mostrarPanelJuego(mesa);

            //realizarJugadas
            gesMesa.realizarJugadas(turnoJugador,mesa);     //Pide la cantidad de dinero que se quiere apostar a cada jugador en su orden correspondiente

            //generarCarta
            gesMesa.generarCarta(baraja,mesa.getCartasMesa());

            //mostrarPanelJuego
            gesMesa.mostrarPanelJuego(mesa);

            //realizarJugadas
            gesMesa.realizarJugadas(turnoJugador,mesa);     //Pide la cantidad de dinero que se quiere apostar a cada jugador en su orden correspondiente

            //mostrarPanelJuego
            gesMesa.mostrarPanelJuego(mesa);

            //calcularGanador
            jugadorGanador = resMesa.calcularGanador(mesa);

            //ingresarDineroGanador
            gesMesa.ingresarDineroGanador(jugadorGanador,mesa);

            /*

            //incrementarTurnoJugador
            if (turnoJugador < 4){
                turnoJugador++;
            }else{
                turnoJugador = 0;
            }
            */

        }while (mesa.getJugadores()[0].getDinero()>0);

    }

}
