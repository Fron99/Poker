package Clases.Gestoras;

import Clases.Basicas.CartaImpl;
import Clases.Basicas.JugadorImpl;
import Clases.Basicas.MesaImpl;

import java.util.Random;
import java.util.Scanner;

public class GestoraJugadorImpl {

    /*
     * SIGNATURA: public int leerYValidarSaldoInicial();
     * COMENTARIO: Lee y valida el dinero inicial del jugador
     * PRECONDICIONES: - Ninguna
     * ENTRADA: - Nada
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con la cantidad de dinero con el que el jugador va a iniciar el juego
     *
     */

    /**
     * Read and validate the player's initial money
     * @return int This method returns the amount of money validated with which the player wants to play
     */

    public int leerYValidarSaldoInicial(){
        int dinero;
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.println("La cantidad minima para iniciar es 2000€ y la maxima 10000€");
            System.out.print("Introduce dinero con el que iniciar: ");
            dinero = teclado.nextInt();
        }while (dinero < 2000 || dinero > 10000);
        return dinero;
    }

    /*
     * SIGNATURA: public String leerUsuario();
     * COMENTARIO: Lee el usuario con el que quiere jugar el jugador
     * PRECONDICIONES: - Ninguna
     * ENTRADA: - Nada
     * SALIDA: - Un String
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un String con el usuario con el que quiere jugar el jugador
     *
     */

    /**
     * @return
     */

    public String leerUsuario(){
        String usuario;
        Scanner teclado = new Scanner(System.in);
            System.out.print("Introduce usuario con el que quiere jugar: ");
            usuario = teclado.nextLine();
        return usuario;
    }


    /*
     * SIGNATURA:
     * COMENTARIO: Lee y valida la cantidad de dinero que puede apostar el jugador
     * PRECONDICIONES: Ninguna
     * ENTRADA: - Un jugador
     *          - Apuesta minima
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con la cantidad de dinero que apuesta el jugador
     *
     */

    /**
     * @param jugador
     * @param apuestaMinima
     * @param mesa
     * @param apuestaMaxima
     * @return
     */

    public int leerYValidarApuesta(int jugador, int apuestaMinima, int apuestaMaxima, MesaImpl mesa){
        Scanner teclado = new Scanner(System.in);
        int cantidadApuesta;
        boolean allIn = false;
        do {
            System.out.println("Dispone de "+mesa.getSaldoJugador(jugador)+" de saldo");
            System.out.println("La apuesa minima es: "+(apuestaMinima-mesa.getApuestaJugador(jugador,mesa.getRonda())) + " y la apuesta maxima es: "+apuestaMaxima);
            System.out.print("Introduce cuanto quiere apostar: ");
            cantidadApuesta = teclado.nextInt();
            if (cantidadApuesta < apuestaMinima-mesa.getApuestaJugador(jugador,mesa.getRonda())){
                if (cantidadApuesta == mesa.getSaldoJugador(jugador)){
                    allIn = true;
                }
            }
        }while (cantidadApuesta < apuestaMinima
                || cantidadApuesta > apuestaMaxima
                || (cantidadApuesta < apuestaMinima && !allIn && cantidadApuesta != 0)
                || cantidadApuesta > mesa.getSaldoJugador(jugador));

        return cantidadApuesta;
    }


    /*
     * SIGNATURA: public int calcularApostarBot(int apuestaMinima, MesaImpl mesa, int jugador, int ronda)
     * COMENTARIO: Metodo para calcular cuanto debe apostar el bot pasado por parametro
     * PRECONDICIONES: - Nada
     * ENTRADA: - Un objeto MesaImpl
     *          - Un entero con la apuesta minima
     *          - Un entero con el numero del jugador
     *          - Un entero con el numero de la ronda
     * SALIDA: - Un entero con la cantidad a apostar
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con la cantidad de saldo a apostar
     */

    /**
     * @param jugador
     * @param apuestaMinima
     * @param apuestaMaxima
     * @param mesa
     * @return
     */

    public int calcularApostarBot(int jugador, int apuestaMinima, int apuestaMaxima, MesaImpl mesa){
        int totalApostar, valorCartas, valorFarolRonda, puntosPosibilidad;
        double porcenApostar;
        GestoraCartaImpl gesCarta = new GestoraCartaImpl();

        //Obtener puntos de las cartas
        valorCartas = gesCarta.evaluarCartas(jugador,mesa);

        //Obtener puntos de farol
        valorFarolRonda = calcularPuntosFarolRonda(mesa.getRonda());

        //Obtener puntos por posibilidad
        puntosPosibilidad = calcularPuntosPosibilidad(gesCarta.obtenerCartasAEvaluar(jugador,mesa));

        //Porcentaje apostar
        porcenApostar = ((double)((valorFarolRonda+valorCartas+puntosPosibilidad)*100) / 319)*0.01;

        //Total calculado que va a apostar
        totalApostar = (int)(mesa.getSaldoJugador(jugador) * porcenApostar);

        //Comprueba si la apuesta es mayor o igual.
        if (apuestaMinima >= totalApostar){
            //En el caso de que la apuesta minima sea mayor calculamos si con un incremento del 30% al total apostar si quiere subir e igualar a la apuesta minima
            if ((int)(totalApostar*1.30) >= apuestaMinima){
                totalApostar = apuestaMinima - mesa.getApuestaJugador(jugador,mesa.getRonda());
            }else{//TODO aqui iria otro if que seria el de seguir la apuesta en el caso de que fuera muy alta la apuesta
                //En el caso de que decidiera no subir la apuesta e igualarla se "tiraria"
                totalApostar = 0;
            }
        }else{
            //Calcula si debe bajar la apuesta con un decremento del 30%. Si aun asi sigue siendo mayor que la apuesta minima seguira apostando lo que pensaba apostar
            if ((int)(totalApostar*0.70) < apuestaMinima){
                totalApostar = apuestaMinima - mesa.getApuestaJugador(jugador,mesa.getRonda());
            }
        }

        //No apostar mas de lo que los demas jugadores puedan apostar
        if (totalApostar > apuestaMaxima){
            totalApostar = apuestaMaxima;
        }

        return totalApostar;
    }


    /*
     * SIGNATURA: public int calcularPuntosFarol(int ronda);
     * COMENTARIO: Calcular cantidad de puntos que debe incrementar la apuesta el bot
     * PRECONDICIONES: - Nada
     * ENTRADA: - Un entero
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre la cantidad de puntos que debe incrementar en un farol el bot dependiendo de la ronda en la que se encuentre
     */

    /**
     * @param ronda
     * @return
     */

    private int calcularPuntosFarolRonda(int ronda){
        int puntosFarol = 0,porcentaje;
        Random r = new Random();

        switch (ronda){
            case 0:
                //PROBABILIDAD PRIMERA MANO
                porcentaje = r.nextInt(99)+1;
                if (porcentaje > 0 && porcentaje < 6){
                    puntosFarol = 10;
                }
                break;
            case 1:
                //PROBABILIDAD SEGUNDA MANO
                porcentaje = r.nextInt(99)+1;
                if (porcentaje > 0 && porcentaje < 11){
                    puntosFarol = 15;
                }
                break;
            case 2:
                //PROBABILIDAD TERCERA MANO
                porcentaje = r.nextInt(99)+1;
                if (porcentaje > 0 && porcentaje < 16){
                    puntosFarol = 25;
                }
                break;
            case 3:
                //PROBABILIDAD CUARTA MANO
                porcentaje = r.nextInt(99)+1;
                if (porcentaje > 0 && porcentaje < 21){
                    puntosFarol = 50;
                }
                break;
            case 4:
                //PROBABILIDAD CUARTA MANO
                porcentaje = r.nextInt(99)+1;
                if (porcentaje > 0 && porcentaje < 5){
                    puntosFarol = 100;
                }
                break;
        }
        return puntosFarol;
    }

    /*
     * SIGNATURA: private int calcularPuntosPosibilidad()
     * COMENTARIO: Calcula la posibilidad que tienen las cartas del jugador a tener algo de valor
     * PRECONDICIONES: - El array no debe tener cartas por defecto.
     * ENTRADA: - Un array de CartaImpl
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre el valor en puntos de la posibilidad de tener cartas de valor en la partida.
     */

    //TODO

    /**
     * @param cartasAEvaluar
     * @return
     */

    private int calcularPuntosPosibilidad(CartaImpl[] cartasAEvaluar){
        int puntosPosibilidad = 0;

        switch (cartasAEvaluar.length){
            //Si el array contiene 2 cartas significa que esta en la primera ronda
            case 2:

                for (int con = 0; con < 2; con++){
                    if (cartasAEvaluar[con].getValorNumero() == 13 || cartasAEvaluar[con].getValorNumero() == 12 || cartasAEvaluar[con].getValorNumero() == 11 || cartasAEvaluar[con].getValorNumero() == 10){
                        puntosPosibilidad = 20;
                    }
                }

                if (cartasAEvaluar[0].getValorNumero() == 13 || cartasAEvaluar[0].getValorNumero() == 12 || cartasAEvaluar[0].getValorNumero() == 11 || cartasAEvaluar[0].getValorNumero() == 10
                    && cartasAEvaluar[1].getValorNumero() == 13 || cartasAEvaluar[1].getValorNumero() == 12 || cartasAEvaluar[1].getValorNumero() == 11 || cartasAEvaluar[1].getValorNumero() == 10){
                    puntosPosibilidad = 30;
                }

                if (cartasAEvaluar[0].getPalo() == cartasAEvaluar[1].getPalo()){
                    puntosPosibilidad = 50;
                }

                if (cartasAEvaluar[0].getNumero().equals(cartasAEvaluar[1].getNumero())){
                    puntosPosibilidad = 50;
                }

                break;
            //Si el array contiene 5 cartas significa que esta en la segunda ronda
            case 5:

                for (int con = 0; con < 6; con++){
                    if (cartasAEvaluar[con].getValorNumero() == 13 || cartasAEvaluar[con].getValorNumero() == 12 || cartasAEvaluar[con].getValorNumero() == 11 || cartasAEvaluar[con].getValorNumero() == 10){
                        puntosPosibilidad = 10;
                    }
                }



                break;
            //Si el array contiene 6 cartas significa que esta en la tercera ronda
            case 6:

                for (int con = 0; con < 7; con++){
                    if (cartasAEvaluar[con].getValorNumero() == 13 || cartasAEvaluar[con].getValorNumero() == 12 || cartasAEvaluar[con].getValorNumero() == 11 || cartasAEvaluar[con].getValorNumero() == 10){
                        puntosPosibilidad = 10;
                    }
                }

                break;
            //En la cuarta ronda no hay incremento por posibilidad
        }
        return puntosPosibilidad;
    }


    /*
     * SIGNATURA: public JugadorImpl leerYValidarJugador();
     * COMENTARIO:
     * PRECONDICIONES: - Nada
     * ENTRADA: - Nada
     * SALIDA: - Un objeto JugadorImpl
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: -
     */

    /**
     * @return
     */

    public JugadorImpl leerYValidarJugador(){
        JugadorImpl nuevoJugador;
            String usuario = leerUsuario();
            int saldo = leerYValidarSaldoInicial();
            nuevoJugador = new JugadorImpl(usuario,saldo);
        return nuevoJugador;
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

    /**
     * @param jugadores
     * @return
     */

    public int jugadoresConSaldo(JugadorImpl[] jugadores){
        int cantidad = 0;
        if (jugadores.length == 5){
            for (int i = 1; i < jugadores.length; i++){
                if (jugadores[i].getSaldo() > 0){
                    cantidad++;
                }
            }
        }
        return cantidad;
    }

}
