package Clases.Resguardos;

import Clases.Basicas.CartaImpl;
import Clases.Basicas.MesaImpl;

public class ResguardosMesaImpl {

    /*
     * SIGNATURA: public void generarCarta(CartaImpl[] baraja, CartaImpl[] cartas);
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

    public void generarCarta(CartaImpl[] baraja, CartaImpl[] cartas){
        System.out.println("Metodo en resguardo");
    }

    /*
     * SIGNATURA: public void realizarJugadas(int iniciador, MesaImpl mesa);
     * COMENTARIO: Realiza el proceso de apuestas de cada ronda segun el orden pasado.
     * PRECONDICIONES: - El iniciador no puede ser mayor a 4 ni menor que 0
     * ENTRADA: - Un entero para el iniciador
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Un objeto mesa con el que se este jugando
     * POSTCONDICIONES: - Modifica la apuesta total de la mesa pasada por parametro incrementando su valor conforme los jugadores apuesten
     *
     */

    /*
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
     */

    public void realizarJugadas(int iniciador, MesaImpl mesa){
        System.out.println("Metodo en resguardo");
    }


    /*
     * SIGNATURA: public int calcularGanador(MesaImpl mesa);
     * COMENTARIO: Calcula cual es el jugador que ha ganado en la mano actual.
     * PRECONDICIONES: - El array de cartas que contiene el objeto MesaImpl debe tener las 5 cartas.
     * ENTRADA: - Un objeto de MesaImpl
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un int con el numero del usuario ganador
     *
     */

    public int calcularGanador(MesaImpl mesa){
        System.out.println("Metodo en resguardo");
        return 0;
    }


    /*
     * SIGNATURA: public void ingresarDineroGanador(int ganador, MesaImpl mesa);
     * COMENTARIO: Calcula cual es el jugador que ha ganado en la mano actual.
     * PRECONDICIONES: - El array de cartas que contiene el objeto MesaImpl debe tener las 5 cartas.
     * ENTRADA: - Un entero con el valor del ganador de la ronda
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Un objeto mesa
     * POSTCONDICIONES: - Modifica el objeto mesa incrementando el saldo del usuario ganador con el total de apuestas de la mano jugada.
     *
     */

    public void ingresarDineroGanador(int ganador, MesaImpl mesa){
        System.out.println("Metodo en resguardo");
    }


}
