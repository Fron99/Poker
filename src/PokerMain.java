/*
 * Programa: PokerMain.java
 * Comentario: Este programa trata sobre un juego de poker tradicional pero informatizado y de una manera en la que se puede jugar solo sin nadie mas.
 *              Este programa incluye una serie de funcionalidades que hace que los demas jugadores de la mesa en la que juegas "piensen" sus apuestas.
 *              Cada bot que hay en la mesa realiza las apuestas en funcion de las cartas que tienen y de las posibilidades que creen que tienen de ganar la partida.
 *
 * Entrada:
 *  - Un String con el usuario
 *  - Un int con la cantidad de saldo inicial
 *  - Un int para la cantidad que apuesta el jugador
 *
 * Salida:
 *  - Mensajes al usuario
 *  - Eco de los datos
 *  - Resultado de las acciones elegidas por el usuario
 *  - Ganadores
 *  - La informacion de la mesa
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
 *      //actualizarRonda
 *      restaurarMesa*
 *      para(i = 0, mientras i < 2, incrementar i)
 *          mostrarPanelJuego*
 *          realizarApuestas*
 *          //incrementaRonda
 *          si i == 0
 *              generarTresCartasMesa*
 *          finSi
 *      finPara
 *      para(contador = 0; contador < 2; contador++)
 *          generarCartaMesa*
 *          mostrarPanelJuego*
 *          realizarApuestas*
 *          //incrementaRonda
 *      finPara
 *      mostrarPanelJuego*
 *      ingresarSaldoGanadores*
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

public class PokerMain {

    public static void main (String[] args){

        GestoraJugadorImpl gesJugador = new GestoraJugadorImpl();

        String usuarioJugador;
        int saldoInicialJugador;
        MesaImpl mesa = new MesaImpl();

        //leerUsuario
        usuarioJugador = gesJugador.leerUsuario();

        //leerYValidarDineroInicial
        saldoInicialJugador = gesJugador.leerYValidarSaldoInicial();

        //añadirJugador
        //El usuario que juega se colocara siempre en la posicion 0
        mesa.anhadirJugador(0,new JugadorImpl(usuarioJugador,saldoInicialJugador));

        //cargarBots
        mesa.cargarBots();  //Coloca en el array de jugadores jugadores con valores generados aleatoriamente

        do {

            //restaurarMesa
            mesa.restaurarMesa();

            for (int i = 0; i<2;i++){
                //mostrarPanelJuego
                mesa.mostrarPanelJuego();

                //realizarApuestas
                mesa.realizarApuestas();     //Pide la cantidad de dinero que se quiere apostar a cada jugador en su orden correspondiente

                //Se utiliza este if para que solo se generen una vez las 3 cartas
                if (i == 0) {
                    //generarTresCartasMesa
                    mesa.generarTresCartasMesa();
                }

            }

            for (int contador = 0; contador < 2; contador++){

                //generarCartaMesa
                mesa.generarCartaMesa();

                //mostrarPanelJuego
                mesa.mostrarPanelJuego();

                //realizarApuestas
                mesa.realizarApuestas();     //Pide la cantidad de dinero que se quiere apostar a cada jugador en su orden correspondiente

            }

            //mostrarPanelJuego
            mesa.mostrarPanelJuego();

            //ingresarSaldoGanadores
            mesa.ingresarSaldoGanadores();

            mesa.incrementarTurno();

        }while (mesa.getJugadores()[0].getSaldo()>0);

        System.out.println("El jugador "+usuarioJugador+" empezo con "+saldoInicialJugador+" y acabo con "+(saldoInicialJugador-mesa.getJugadores()[0].getSaldo())+"");

    }

}
