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
 *      limpiarCartasMesa*
 *      restaurarBaraja*
 *      generarCartasJugadores*
 *      mostrarMesa*
 *      realizarApuestas*
 *      generarTresCartasMesa*
 *      mostrarMesa*
 *      realizarApuestas*
 *      para(contador = 0; contador < 2; contador++)
 *          generarCartaMesa*
 *          mostrarMesa*
 *          realizarApuestas*
 *      finPara
 *      mostrarMesaCompleta*
 *      calcularGanador*
 *      ingresarBoteGanador*
 *      si(turno jugador == 4)
 *          turno jugador = 0
 *      sino
 *          //incrementar turno jugador
 *      finSi
 *  mientras(saldo usuario > 0 && queden bots con saldo)
 *  mostrarResultadoJugador*
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

public class PokerMain {

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
        dineroInicialJugador = gesJugador.leerYValidarSaldoInicial();

        //El usuario que juega se colocara siempre en la posicion 0
        mesa.anhadirJugador(0,new JugadorImpl(usuarioJugador,dineroInicialJugador));

        //cargarBots
        gesJugador.cargarBots(mesa.getJugadores());  //Coloca en el array de jugadores jugadores con valores generados


        //generarIniciador
        turnoJugador = random.nextInt(5);   //Genera un numero del 0 al 4 que es la cantidad de jugadores que hay
                                                    //para saber quien empieza a aposta

        do {
            //restaurarBaraja
            mesa.restaurarBaraja();

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

        }while (mesa.getJugadores()[0].getSaldo()>0);

    }

}
