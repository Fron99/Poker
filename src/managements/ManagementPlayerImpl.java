package managements;

import basicsClasses.CardImpl;
import basicsClasses.PlayerImpl;
import basicsClasses.TableImpl;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.Scanner;

@SuppressWarnings("unused")
public class ManagementPlayerImpl {

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
     * @param mesa
     * @return
     */

    public int calculateBetBot(int jugador, int apuestaMinima, TableImpl mesa){
        int totalApostar, valorCartas, valorFarolRonda, puntosPosibilidad;
        double porcenApostar;
        ManagementCardImpl gesCarta = new ManagementCardImpl();

        //Obtener puntos de las cartas
        valorCartas = gesCarta.evaluateCardsFromPlayer(jugador,mesa);

        //Obtener puntos de farol
        valorFarolRonda = calculatePointBluffRound(mesa.getRound());

        //Obtener puntos por posibilidad
        puntosPosibilidad = gesCarta.calculatePointPosibility(gesCarta.getCardsToEvaluate(jugador,mesa));

        //Porcentaje apostar
        porcenApostar = ((double)((valorFarolRonda+valorCartas+puntosPosibilidad)*100) / 319)*0.01;

        //Total calculado que va a apostar
        totalApostar = (int)(mesa.getBalancePlayer(jugador) * porcenApostar);

        //Comprueba si la apuesta es mayor o igual.
        if (apuestaMinima >= totalApostar){
            //En el caso de que la apuesta minima sea mayor calculamos si con un incremento del 30% al total apostar si quiere subir e igualar a la apuesta minima
            if ((int)(totalApostar*1.30) >= apuestaMinima){
                totalApostar = apuestaMinima - mesa.getBetPlayer(jugador,mesa.getRound());
            }else{
                //En el caso de que la apuesta minima sea mucho mas alta que lo que pensaba apostar el jugador, valorar si tiene suficiente buenas cartas como para subir la apuesta
                //192 puntos concuerda con el 60% del total de puntos
                //Quizas se deberia poner con la personalidad del jugador
                if ((valorFarolRonda+valorCartas+puntosPosibilidad) >= 192){
                    totalApostar = apuestaMinima - mesa.getBetPlayer(jugador,mesa.getRound());
                }else{
                    //En el caso de que decidiera no subir la apuesta e igualarla se "tiraria"
                    totalApostar = 0;
                }
            }
        }else{
            //Calcula si debe bajar la apuesta con un decremento del 30%. Si aun asi sigue siendo mayor que la apuesta minima seguira apostando lo que pensaba apostar
            if ((int)(totalApostar*0.70) < apuestaMinima){
                    totalApostar = apuestaMinima - mesa.getBetPlayer(jugador,mesa.getRound());
            }
        }

        return totalApostar;
    }

    /*
     * SIGNATURA: public int calculatePointBluffRound(int ronda);
     * COMENTARIO: Calcular cantidad de puntos que debe incrementar la apuesta el bot
     * PRECONDICIONES: - Nada
     * ENTRADA: - Un entero
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre la cantidad de puntos que debe incrementar en un farol el bot dependiendo de la ronda en la que se encuentre
     */

    private int calculatePointBluffRound(int round){
        int puntosFarol = 0,porcentaje;
        Random r = new Random();

        switch (round){
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

}
