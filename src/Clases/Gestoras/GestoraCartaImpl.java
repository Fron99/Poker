package Clases.Gestoras;

import Clases.Basicas.CartaImpl;
import Clases.Basicas.MesaImpl;

import java.util.ArrayList;

public class GestoraCartaImpl {

    /*
     * SIGNATURA: public int evaluarCartas(int jugador, MesaImpl mesa);
     * COMENTARIO: Calcular el valor que tienen las cartas segun la puntuacion establecida.
     * PRECONDICIONES: - El entero del jugador debe ser entre 0 y 4
     *                 - Las cartas del array de la mesa deben estar correlativas y todas las cartas por defecto deben estar detras de las que tienen valor definido.
     *                 - Las cartas del array de cartas del jugador deben estar correlativas y todas las cartas por defecto deben estar detras de las que tienen valor definido.
     * ENTRADA: - Un objeto MesaImpl
     *          - Un entero para el jugador del cual se quiere evaluar los puntos
     * SALIDA: - Un entero con la puntuacion del jugador
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con la puntuacion que tienen las cartas en ese momento del jugador pasado por parametro
     */

    /**
     * This method calculates the value of the cards of player passed by parameter in one table
     * @param jugador player of which we want to evaluate the cards
     * @param mesa table where the player plays
     * @return int with the value of the player's cards passed by parameter on a table
     */

    public int evaluarCartas(int jugador, MesaImpl mesa){

        int puntosFinales, puntosCalculados;
        CartaImpl[] cartasAEvaluar;
        GestoraCartaImpl gesCarta = new GestoraCartaImpl();

        //Obtener cartas que se quieren evaluar.
        cartasAEvaluar = obtenerCartasAEvaluar(jugador,mesa);

        //Ordenar las cartas obtenidas
        gesCarta.ordenarCartas(cartasAEvaluar);

        //Va comprobando todos los valores de las distintas posibilidades que tiene el jugador y se queda con la posibilidad mas alta.
        puntosFinales = calcularValorCartaAlta(cartasAEvaluar);

        puntosCalculados = calcularValorPareja(cartasAEvaluar);
        if (puntosCalculados>puntosFinales){
            puntosFinales = puntosCalculados;
        }

        puntosCalculados = calcularValorDoblePareja(cartasAEvaluar);
        if (puntosCalculados>puntosFinales){
            puntosFinales = puntosCalculados;
        }

        puntosCalculados = calcularValorTrio(cartasAEvaluar);
        if (puntosCalculados>puntosFinales){
            puntosFinales = puntosCalculados;
        }

        puntosCalculados = calcularValorEscalera(cartasAEvaluar);
        if (puntosCalculados>puntosFinales){
            puntosFinales = puntosCalculados;
        }

        puntosCalculados = calcularValorColor(cartasAEvaluar);
        if (puntosCalculados>puntosFinales){
            puntosFinales = puntosCalculados;
        }

        puntosCalculados = calcularValorPoker(cartasAEvaluar);
        if (puntosCalculados>puntosFinales){
            puntosFinales = puntosCalculados;
        }

        puntosCalculados = calcularValorFull(cartasAEvaluar);
        if (puntosCalculados>puntosFinales){
            puntosFinales = puntosCalculados;
        }

        puntosCalculados = calcularValorEscaleraColor(cartasAEvaluar);
        if (puntosCalculados>puntosFinales){
            puntosFinales = puntosCalculados;
        }
        return puntosFinales;
    }


    /*
     * SIGNATURA: public CartaImpl[] obtenerCartasAEvaluar(int jugador, MesaImpl mesa);
     * COMENTARIO: Este metodo obtiene el total de cartas que tiene el jugador junto a las disponibles en la mesa para evaluarlas.
     * PRECONDICIONES: - Nada
     * ENTRADA: - Un objeto MesaImpl
     *          - Un entero para el jugador del cual se quiere evaluar los puntos
     * SALIDA: - Un array de CartaImpl
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un array de CartaImpl con las cartas de las que dispone el jugador para evaluar
     */

    /**
     * This method get the player's cards to evaluate
     * @param jugador player of which we want to evaluate the cards
     * @param mesa table where the player plays
     * @return CartaImpl[] array of CartaImpl with the player's cards passed by parameter
     */


    private CartaImpl[] obtenerCartasAEvaluar(int jugador, MesaImpl mesa){
        CartaImpl[] cartasTotales;

        int cantidadCartas = 0;
        CartaImpl[] cartasMesa = mesa.getCartasMesa();
        CartaImpl[] cartasJugador = mesa.getJugadores()[jugador].getCartas();

        //Obtiene la cantidad de cartas que hay en la mesa con valor distinto al de defecto
        for (int i = 0;i<cartasMesa.length&&(cartasMesa[i].getPalo()!='D');i++){
            cantidadCartas++;
        }

        //Obtiene la cantidad de cartas que posee el jugador pasado por parametro con valor distinto al de defecto
        for (int i = 0;i<cartasJugador.length&&(cartasJugador[i].getPalo()!='D');i++){
            cantidadCartas++;
        }

        cartasTotales = new CartaImpl[cantidadCartas];

        //Inicializar el array para no tener errores de null
        for (int i = 0; i<cartasTotales.length;i++){
            cartasTotales[i] = new CartaImpl();
        }

        //Anhade al array de cartas totales todas las cartas distintas al valor por defecto que hay en la mesa
        for (int i = 0;i<cartasMesa.length&&(cartasMesa[i].getPalo()!='D');i++){
            cartasTotales[i] = cartasMesa[i];
        }

        //Anhade al array de cartas totales todas las cartas distintas al valor por defecto que posee el jugador
        for (int i = 0,j = 0;i<cartasTotales.length;i++){
            if (cartasTotales[i].getPalo()=='D'){
                cartasTotales[i] = cartasJugador[j];
                j++;
            }
        }
        return cartasTotales;
    }


    /*
     * SIGNATURA: public void ordenarCartas(CartaImpl[] cartas);
     * COMENTARIO: Ordena las cartas de un array de cartas.
     * PRECONDICIONES: - El array debe tener como minimo 2 cartas
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Un array de CartaImpl
     * POSTCONDICIONES: - Modifica el array pasado por parametro ordenado las cartas que contiene de mayor a menor valor.
     */

    /**
     * This method sort the array passed by parameter
     * @param cartas Array of CartaImpl[] you want to order
     */

    public void ordenarCartas(CartaImpl[] cartas){
        CartaImpl cartaAux;
        //Para ordenar utiliza el metodo de compareTo de la clase CartaImpl
        for(int i = 0; i < cartas.length - 1; i++){
            for(int j = 0; j < cartas.length - 1; j++){
                if (cartas[j].compareTo(cartas[j + 1]) == 1){
                    cartaAux = cartas[j+1];
                    cartas[j+1] = cartas[j];
                    cartas[j] = cartaAux;
                }
            }
        }
    }


    /*
     * SIGNATURA: public int calcularValorCartaAlta(CartaImpl[] cartas);
     * COMENTARIO: Calcular el valor de la carta mas alta del array de cartas pasado por parametro
     * PRECONDICIONES: - El array debe estar ordenado de menor a mayor
     * ENTRADA: - Un array de CartaImpl
     * Salida: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: Devuelve asociado al nombre un entero con la cantidad de puntos que tiene la carta mas alta del array pasado por parametro
     */

    /**
     * Calculate the highest card value in the array passed by parameter
     * @param cartas CartaImpl[] cards you want to value
     * @return returns the value of the highest card
     */

    public int calcularValorCartaAlta(CartaImpl[] cartas){
        int puntos = 0;
        if (cartas.length>1){
            puntos = cartas[cartas.length-1].getValorNumero();
        }
        return puntos;
    }


    /*
     * SIGNATURA: public int calcularValorPareja(CartaImpl[] cartas);
     * COMENTARIO: Calcular el valor de la pareja mas alta del array de cartas pasado por parametro
     * PRECONDICIONES: - El array debe estar ordenado de menor a mayor
     * ENTRADA: - Un array de CartaImpl
     * Salida: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con la cantidad de puntos que tiene la pareja mas alta del array pasado por parametro
     *                  - Si no hay ninguna pareja devuelve 0
     */

    /**
     * Calculate the highest value of the pair in the array passed by parameter
     * Returns 0 if there is no partner
     * @param cartas CartaImpl[] cards you want to value
     */

    public int calcularValorPareja(CartaImpl[] cartas){
        int puntos = 0;
        boolean trio = false;
        if (cartas.length>1){
            for (int i = 0; i < cartas.length-1 && !trio; i++){
                if (cartas[i].getValorNumero() == cartas[i+1].getValorNumero()){
                    if (i <= cartas.length-3){
                        if (cartas[i].getValorNumero() == cartas[i+2].getValorNumero()){
                            trio = true;
                        }else{
                            puntos = 13 + cartas[i].getValorNumero();
                        }
                    }else{
                        puntos = 13 + cartas[i].getValorNumero();
                    }
                }
            }
        }
        return puntos;
    }


    /*
     * SIGNATURA: public int calcularValorDoblePareja(CartaImpl[] cartas);
     * COMENTARIO: Calcular el valor de la doble pareja mas alta que haya en el array pasado por parametro
     * PRECONDICIONES: - El array debe estar ordenado de menor a mayor
     * ENTRADA: - Un array de CartaImpl
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con el valor de la doble pareja mas alta que haya
     *                  - Si no hay doble pareja devuelve 0
     */

    /**
     * Calculate the highest value of the pair in the array passed by parameter
     * Returns 0 if there is no pair
     * @param cartas CartaImpl[] cards you want to value
     */

    public int calcularValorDoblePareja(CartaImpl[] cartas){
        int puntos = 0, cantidadParejas = 0;
        int [] valorParejas = new int[3];
        boolean trio = false;
        int [][] posibilidades = {{0,0},{1,2},{1,3},{2,3},{1,4},{2,4},{3,4},{1,5},{2,5},{3,5},{4,5},{1,6},{2,6},{3,6},{4,6},{5,6},{1,7},{2,7},{3,7},{4,7},{5,7},{6,7},{1,8},{2,8},{3,8},{4,8},{5,8},{6,8},{7,8},{1,9},{2,9},{3,9},{4,9},{5,9},{6,9},{7,9},{8,9},{1,10},{2,10},{3,10},{4,10},{5,10},{6,10},{7,10},{8,10},{9,10},{1,11},{2,11},{3,11},{4,11},{5,11},{6,11},{7,11},{8,11},{9,11},{10,11},{1,12},{2,12},{3,12},{4,12},{5,12},{6,12},{7,12},{8,12},{9,12},{10,12},{11,12},{1,13},{2,13},{3,13},{4,13},{5,13},{6,13},{7,13},{8,13},{9,13},{10,13},{11,13},{12,13}};

        if (cartas.length>3){
            for (int i = 0, j = 0;i<cartas.length-1 && !trio && cantidadParejas < 3;i++){
                if (cartas[i].getNumero().equals(cartas[i+1].getNumero())){
                    //Este if se utiliza para controlar excepciones de ArrayIndexOutOfBoundsException
                    //Si i == cartas.length-3 significa que solo quedaran 2 cartas por lo cual no hay que comoprobar la tercera para ver si hay trio
                    if(i <= cartas.length-3){
                        //Esto comprueba que no haya un trio en el array. En el caso de que exista un trio devolvera 0
                        if (cartas[i].getNumero().equals(cartas[i+1].getNumero()) && cartas[i].getNumero().equals(cartas[i+2].getNumero())){
                            trio = true;
                        }else {
                            cantidadParejas++;
                            valorParejas[j] = cartas[i].getValorNumero();
                            j++;
                        }
                    }else {
                        cantidadParejas++;
                        valorParejas[j] = cartas[i].getValorNumero();
                        j++;
                    }

                }
            }
            //Solo se ejecutara cuando haya dos dobles parejas que sean diferentes y no haya trio
            if(cantidadParejas > 1 && !trio){
                //En el caso de que haya doble pareja busca el valor de la pareja mas alta
                for(int i = 0; i<valorParejas.length-1;i++){
                    for (int j = 0; j<posibilidades.length; j++){
                        if (posibilidades[j][0] == valorParejas[i]
                                && posibilidades[j][1] == valorParejas[i+1]){
                            puntos = 26 + j;
                        }
                    }
                }
            }
        }
        return puntos;
    }


    /*
     * SIGNATURA: public int calcularValorTrio(CartaImpl[] cartas);
     * COMENTARIO: Calcular el valor del trio mas alta del array de cartas pasado por parametro
     * PRECONDICIONES: - El array debe estar ordenado de menor a mayor
     * ENTRADA: - Un array de CartaImpl
     * Salida: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con la cantidad de puntos que corresponde al trio mas alto del array pasado por parametro
     *                  - Si no hay ningun trio devuelve 0
     */

    /**
     * Calculate the highest value of the trio in the array passed by parameter
     * Returns 0 if there is no trio
     * @param cartas CartaImpl[] cards you want to value
     */

    public int calcularValorTrio(CartaImpl[] cartas){
        int puntos = 0;
        boolean poker = false;
        if (cartas.length>2){
            for (int i = 0;i<cartas.length-2;i++){
                //Comprueba si hay poker
                if ( i<cartas.length-3
                        &&  (cartas[i].getNumero().equals(cartas[i+1].getNumero()))
                        && (cartas[i].getNumero().equals(cartas[i+2].getNumero()))
                        && (cartas[i].getNumero().equals(cartas[i+3].getNumero()))){

                    poker = true;

                }else{
                    //En el caso de no haber poker comprueba si hay trio
                    if ( (cartas[i].getNumero().equals(cartas[i+1].getNumero()))
                            && (cartas[i].getNumero().equals(cartas[i+2].getNumero())) ){

                        puntos = 104+cartas[i].getValorNumero();

                    }
                }
            }
            if (poker){
                puntos = 0;
            }
        }
        return puntos;
    }

    /*
     * SIGNATURA: public int calcularValorEscalera(CartaImpl[] cartas);
     * COMENTARIO: Calcular el valor de la escalera mas alta del array de cartas pasado por parametro
     * PRECONDICIONES: - Nada
     * ENTRADA: - Un array de CartaImpl
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con la cantidad de puntos que corresponde a la escalera mas alta del array pasado por parametro
     *                  - Si no hay ninguna escalera devuelve 0
     */

    /**
     * Calculate the highest value of the stair in the array passed by parameter
     * Returns 0 if there is no stair
     * @param cartas CartaImpl[] cards you want to value
     */

    public int calcularValorEscalera(CartaImpl[] cartas){
        int puntos = 0;
        ArrayList<CartaImpl> cartasNoRepetidas = new ArrayList<>();
        boolean existe = false;
        //TODO Testear con valores repetidos en medio de la baraja y testear muy a fondo
        if (cartas.length>4){
            cartasNoRepetidas.add(cartas[0]);
            for (CartaImpl carta: cartas){
                for (int j = 0; j<cartasNoRepetidas.size() && !existe;j++){
                    if (carta.getValorNumero()==cartasNoRepetidas.get(j).getValorNumero()){
                        existe = true;
                    }
                }
                if (!existe){
                    cartasNoRepetidas.add(carta);
                }
                existe = false;
            }

            cartasNoRepetidas.sort(CartaImpl::compareTo);

            //Comprueba si la escalera de color puede ser que sea A,2,3,4,5
            //Como la carta A es la se mayor valor no se coloca delante en el array entonces hay que comprobarla estando detras
            if (cartasNoRepetidas.get(0).getValorNumero() == 1 && cartasNoRepetidas.get(cartasNoRepetidas.size() - 1).getValorNumero() == 13) {

                //Como sabemos que la primera carta sera el 2 y la ultima sera la A podemos usar posiciones absolutas para comprobar si hay escalera tipo A,2,3,4,5
                if ((cartasNoRepetidas.get(1).getValorNumero() == ((cartasNoRepetidas.get(0).getValorNumero()) + 1))
                        && (cartasNoRepetidas.get(2).getValorNumero() == ((cartasNoRepetidas.get(1).getValorNumero()) + 1))
                        && (cartasNoRepetidas.get(3).getValorNumero() == ((cartasNoRepetidas.get(2).getValorNumero()) + 1))) {

                    //En el caso de que pueda ser A,2,3,4,5,6 o incluso A,2,3,4,5,6,7 se realizara este bucle for para coger la escalera mas alta.
                    if (cartasNoRepetidas.get(4).getValorNumero() == cartasNoRepetidas.get(3).getValorNumero()) {
                        for (int i = 3, j = 0; cartasNoRepetidas.get(i + 1).getValorNumero() == cartasNoRepetidas.get(i).getValorNumero(); i++, j++) {
                            puntos = 117 + cartasNoRepetidas.get(j).getValorNumero();
                        }
                    } else {
                        //En el cado de que no haya una escalera mas grande se coloca la escalera del A,2,3,4,5
                        puntos = 117 + cartasNoRepetidas.get(0).getValorNumero();
                    }
                }

            }

            for (int i = 0; i < cartasNoRepetidas.size() - 4; i++) {

                //Comprueba si hay ecalera ya que las cartas estan en orden
                if ((cartasNoRepetidas.get(i+1).getValorNumero() == ((cartasNoRepetidas.get(i).getValorNumero()) + 1))
                        && (cartasNoRepetidas.get(i+2).getValorNumero() == ((cartasNoRepetidas.get(i+1).getValorNumero()) + 1))
                        && (cartasNoRepetidas.get(i+3).getValorNumero() == ((cartasNoRepetidas.get(i+2).getValorNumero()) + 1))
                        && (cartasNoRepetidas.get(i+4).getValorNumero() == ((cartasNoRepetidas.get(i+3).getValorNumero()) + 1))) {

                    //Se le suma 1 a la cantidad total porque el valor 131 se deja guardado para la escalera A,2,3,4,5
                    //Si no se le sumara 1 la escalera 2,3,4,5,6 tendria el mismo valor que la escalera A,2,3,4,5 por el echo de como se ordenan las cartas de mayor a menor
                    puntos = 117 + (cartasNoRepetidas.get(i).getValorNumero()+1);

                }

            }

        }
        return puntos;
    }

    /*
     * SIGNATURA: public int calcularValorColor(CartaImpl[] cartas);
     * COMENTARIO: Calcula el valor de la carta mas alta cuando hay color
     * PRECONDICIONES: - Nada
     * ENTRADA: - Un array de CartaImpl
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con la cantidad de puntos que corresponde al color mas alto del array pasado por parametro
     *                  - Si no hay color devuelve 0
     */

    /**
     * Calculate the highest value of the color in the array passed by parameter
     * Returns 0 if there is no color
     * @param cartas CartaImpl[] cards you want to value
     */

    public int calcularValorColor(CartaImpl[] cartas){
        int puntos = 0;
        char paloColor;
        CartaImpl cartaAltaColor;

        //Calcula si hay algun 5 cartas del mismo color en el array pasado por parametro
        //Si no hay devolvera N lo cual no se ejecutara
        paloColor = calcularColor(cartas);

        if (paloColor != 'N'){

            //Carta por defecto con el valor minimo
            cartaAltaColor = new CartaImpl(paloColor,"2");

            //Este for se utiliza para sacar la carta mas alta del color
            for (CartaImpl carta: cartas){

                if (carta.getPalo() == paloColor){

                    if (carta.getValorNumero()>cartaAltaColor.getValorNumero()){
                        cartaAltaColor = carta;
                    }

                }

            }

            puntos = 127 + cartaAltaColor.getValorNumero();

        }
        return puntos;
    }


    /*
     * SIGNATURA: public int calcularValorFull(CartaImpl[] cartas);
     * COMENTARIO: Calcula el valor del full del array de CartasImpl pasado por parametro
     * PRECONDICIONES: - El array debe estar ordenado de menor a mayor
     *                 - El array de cartas pasado por parametro no puede contener cartas por defecto
     * ENTRADA: - Un array de CartaImpl
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con la cantidad de puntos que corresponden al full mas alto del array pasado por parametro
     *                  - Si no hay full devuelve 0
     */


    /**
     * Calculate the value of the "Full" in deck of cards.
     * @param cartas CartaImpl[] cards you want to value
     * @return int with value of the "Full" in poker. If not exist "Full" in the deck of cards, returns 0
     */


    public int calcularValorFull(CartaImpl[] cartas){
        int puntos = 0;
        int cantidadTrios = 0, cantidadParejas = 0;
        int valorTrio = 0, valorPareja = 0;
        boolean trio = false;
        int [][] posibilidades = {{1,2},{1,3},{1,4},{1,5},{1,6},{1,7},{1,8},{1,9},{1,10},{1,11},{1,12},{1,13},{2,1},{2,3},{2,4},{2,5},{2,6},{2,7},{2,8},{2,9},{2,10},{2,11},{2,12},{2,13},{3,1},{3,2},{3,4},{3,5},{3,6},{3,7},{3,8},{3,9},{3,10},{3,11},{3,12},{3,13},{4,1},{4,2},{4,3},{4,5},{4,6},{4,7},{4,8},{4,9},{4,10},{4,11},{4,12},{4,13},{5,1},{5,2},{5,3},{5,4},{5,6},{5,7},{5,8},{5,9},{5,10},{5,11},{5,12},{5,13}   ,{6,1},{6,2},{6,3},{6,4},{6,5},{6,7},{6,8},{6,9},{6,10},{6,11},{6,12},{6,13}   ,{7,1},{7,2},{7,3},{7,4},{7,5},{7,6},{7,8},{7,9},{7,10},{7,11},{7,12},{7,13}   ,{8,1},{8,2},{8,3},{8,4},{8,5},{8,6},{8,7},{8,9},{8,10},{8,11},{8,12},{8,13}    ,{9,1},{9,2},{9,3},{9,4},{9,5},{9,6},{9,7},{9,8},{9,10},{9,11},{9,12},{9,13}    ,{10,1},{10,2},{10,3},{10,4},{10,5},{10,6},{10,7},{10,8},{10,9},{10,11},{10,12},{10,13}    ,{11,1},{11,2},{11,3},{11,4},{11,5},{11,6},{11,7},{11,8},{11,9},{11,10},{11,12},{11,13}    ,{12,1},{12,2},{12,3},{12,4},{12,5},{12,6},{12,7},{12,8},{12,9},{12,10},{12,11},{12,13}    ,{13,1},{13,2},{13,3},{13,4},{13,5},{13,6},{13,7},{13,8},{13,9},{13,10},{13,11},{13,12}};
        //TODO HACER MAS PRUEBAS
        //TODO INVESTIGAR QUE UN TRIO DE 3 Y PAREJA DE 2 NO VALGA LO MISMO QUE UN TRIO DE 2 Y UNA PAREJA DE 3
        //TODO Creo que habiendo dos trios no lo hace bien. Tiene que coger el trio mas alto y la pareja mas alta


        if (cartas.length>=5){
            //Recorre el array contando cuantos trios existen el la baraja
            for (int i = 0;i<cartas.length-2;i++){
                //Con estos ifs se controla que no haya poker
                if (i == 0){
                    if (cartas[i].getNumero().equals(cartas[i+1].getNumero()) && cartas[i].getNumero().equals(cartas[i+2].getNumero()) && !cartas[i].getNumero().equals(cartas[i+3].getNumero())){
                        valorTrio = cartas[i].getValorNumero();
                        cantidadTrios++;
                        trio = true;
                    }
                }else{
                    if (i <= cartas.length-4){
                        if (!cartas[i].getNumero().equals(cartas[i-1].getNumero()) && cartas[i].getNumero().equals(cartas[i+1].getNumero()) && cartas[i].getNumero().equals(cartas[i+2].getNumero()) && !cartas[i].getNumero().equals(cartas[i+3].getNumero())){
                            valorTrio = cartas[i].getValorNumero();
                            cantidadTrios++;
                            trio = true;
                        }
                    }else{
                        if (i == cartas.length-3){
                            if (!cartas[i].getNumero().equals(cartas[i-1].getNumero()) && cartas[i].getNumero().equals(cartas[i+1].getNumero()) && cartas[i].getNumero().equals(cartas[i+2].getNumero())){
                                valorTrio = cartas[i].getValorNumero();
                                cantidadTrios++;
                                trio = true;
                            }
                        }
                    }
                }
            }

            //Si hay un trio comprueba si hay parejas
            if (trio){
                for (int i = 0; i < cartas.length-1; i++) {
                    //En el caso de que el valor de la carta sea igual que la del trio no se evalua
                    if (cartas[i].getValorNumero() != valorTrio){
                        //No hace falta comprobar que i se pase de rango por arriba porque ya esta controlado en un if de arriba
                        if (i == 0){
                            if (cartas[i].getValorNumero() == cartas[i + 1].getValorNumero() && cartas[i].getValorNumero() != cartas[i + 2].getValorNumero()) {
                                valorPareja = cartas[i].getValorNumero();
                                cantidadParejas++;
                            }
                        }else{
                            if (i <= cartas.length-3){
                                if (cartas[i].getValorNumero() == cartas[i + 1].getValorNumero() && cartas[i].getValorNumero() != cartas[i + 2].getValorNumero() && cartas[i].getValorNumero() != cartas[i - 1].getValorNumero()) {
                                    valorPareja = cartas[i].getValorNumero();
                                    cantidadParejas++;
                                }
                            }else{
                                if (i == cartas.length-2){
                                    if (cartas[i].getValorNumero() == cartas[i + 1].getValorNumero()) {
                                        valorPareja = cartas[i].getValorNumero();
                                        cantidadParejas++;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (cantidadParejas > 0 && cantidadTrios > 0){
                //Recorre el array buscando cual es el valor del full
                for (int i = 0; i<posibilidades.length && puntos==0; i++){
                    if (posibilidades[i][0] == valorTrio && posibilidades[i][1] == valorPareja){
                        //Se le suma 1 a i ya que el array empieza por 0 y entonces la muestra un punto menos en todas las combinaciones posibles
                        puntos = 140 + (i+1);
                    }
                }
            }
        }
        return puntos;
    }


    /*
     * SIGNATURA: public int calcularValorPoker(CartaImpl[] cartas);
     * COMENTARIO: Calcula el valor del poker del array de CartasImpl pasado por parametro
     * PRECONDICIONES: - El array debe estar ordenado de menor a mayor
     * ENTRADA: - Un array de CartaImpl
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con la cantidad de puntos que corresponde al poker mas alto del array pasado por parametro
     *                  - Si no hay poker devuelve 0
     */

    /**
     * Calculate the highest value of the poker in the array passed by parameter
     * @param cartas CartaImpl[] cards you want to value
     * @return int Returns 0 if not exist poker. Returns the value of poker if exist poker.
     */

    public int calcularValorPoker(CartaImpl[] cartas){
        int puntos = 0;
        if (cartas.length>3){
            //Como el array esta ordenado las 4 cartas estaran juntas en el caso de haber poker por lo cual se comprueba de esta manera
            //Recorre el array buscando si hay poker.
            for (int i = 0;i<cartas.length-3;i++){
                if ( (cartas[i].getNumero().equals(cartas[i+1].getNumero()))
                        && (cartas[i].getNumero().equals(cartas[i+2].getNumero()))
                        && (cartas[i].getNumero().equals(cartas[i+3].getNumero()))){

                    puntos = 296+cartas[i].getValorNumero();

                }
            }
        }
        return puntos;
    }


    /*
     * SIGNATURA: public int calcularValorEscaleraColor(CartaImpl[] cartas);
     * COMENTARIO: Calcula el valor de la escalera de color del array de CartasImpl pasado por parametro
     * PRECONDICIONES: - El array debe estar ordenado de menor a mayor
     * ENTRADA: - Un array de CartaImpl
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con la puntuacion que corresponde a la escalera de color mas alta del array pasado por parametro
     *                  - Si no hay escalera de color devuelve 0
     */

    /**
     * Calculate the highest value of the color stair in the array passed by parameter
     * @param cartas CartaImpl[] cards you want to value
     * @return Returns 0 if there is no color stair. Returns value of stair of color if exists
     */

    public int calcularValorEscaleraColor(CartaImpl[] cartas){

        int puntos = 0;
        char color;
        int cantidadCartas = 0;
        CartaImpl[] cartasColor;

        //Calcula si hay color. N si no hay o el caracter del color que exista
        color = calcularColor(cartas);

        //if (cartas.length > 4 && color != 'N') {      cartas.length sobra porque si hay color significa que hay 5 cartas o mas
        if (color != 'N') {

            //Calcula la cantidad de cartas que hay del color que se ha calculado el cual hay color
            for (CartaImpl carta : cartas){
                if (carta.getPalo() == color) {
                    cantidadCartas++;
                }
            }

            //Array para meter las cartas del mismo color
            cartasColor = new CartaImpl[cantidadCartas];

            //Anhade todas las cartas del color obtenido en el array creado
            for (int i = 0, j = 0; i < cartas.length; i++) {
                if (cartas[i].getPalo() == color) {
                    cartasColor[j] = cartas[i];
                    j++;
                }
            }

            ordenarCartas(cartasColor);

            //Comprueba si la escalera de color puede ser que sea A,2,3,4,5
            //Como la carta A es la se mayor valor no se coloca delante en el array entonces hay que comprobarla estando detras
            if (cartasColor[0].getValorNumero() == 1 && cartas[cartas.length - 1].getValorNumero() == 13) {

                //Esta controlado que no haya numeros repetidos ya que no puede haber numeros repetidos en un palo

                //Como sabemos que la primera carta sera el 2 y la ultima sera la A podemos usar posiciones absolutas para comprobar si hay escalera de color tipo A,2,3,4,5
                if ((cartasColor[1].getValorNumero() == ((cartasColor[0].getValorNumero()) + 1))
                        && (cartasColor[2].getValorNumero() == ((cartasColor[1].getValorNumero()) + 1))
                        && (cartasColor[3].getValorNumero() == ((cartasColor[2].getValorNumero()) + 1))) {

                    //En el caso de que pueda ser A,2,3,4,5,6 o incluso A,2,3,4,5,6,7 se realizara este bucle for para coger la escalera de color mas alta.
                    //TODO Comprobar que hace este if y documentarlo
                    if (cartasColor[4].getValorNumero() == cartasColor[3].getValorNumero()) {
                        for (int i = 3, j = 0; cartasColor[i + 1].getValorNumero() == cartasColor[i].getValorNumero(); i++, j++) {
                            puntos = 309 + cartasColor[j].getValorNumero();
                        }
                    } else {
                        //En el cado de que no haya una escalera mas grande se coloca la escalera de color del A,2,3,4,5
                        puntos = 309 + cartasColor[0].getValorNumero();
                    }
                }
            }

            //Recorre el array para comprobar si hay escalera de color
            for (int i = 0; i < cartasColor.length - 4; i++) {

                if ((cartasColor[i+1].getValorNumero() == ((cartasColor[i].getValorNumero()) + 1))
                        && (cartasColor[i+2].getValorNumero() == ((cartasColor[i+1].getValorNumero()) + 1))
                        && (cartasColor[i+3].getValorNumero() == ((cartasColor[i+2].getValorNumero()) + 1))
                        && (cartasColor[i+4].getValorNumero() == ((cartasColor[i+3].getValorNumero()) + 1))) {

                    puntos = 309 + (cartasColor[i].getValorNumero()+1);

                }

            }

        }
        return puntos;
    }


    /*
     * SIGNATURA: public char calcularColor(CartaImpl[] cartas);
     * COMENTARIO: Metodo para calcular si hay color en el array de cartas
     * PRECONDICIONES: - Nada
     * ENTRADA: - Un array de CartaImpl
     * SALIDA: - Un caracter
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un caracter con el tipo de color que hay en el array (T,P,C,R)
     *                  - Si no hay color se devolvera N
     */

    /**
     * Method to calculate if there is color in the card array
     * @param cartas Array of cards you want to check
     * @return char with the color that exist in array of cards. Return N if not exist color.
     */

    private char calcularColor(CartaImpl[] cartas){
        char color = 'N';
        int contadorPica = 0, contadorCorazon = 0, contadorTrevol = 0, contadorRombo = 0;

        //Se calcula cuantas cartas hay de cada palo
        for (CartaImpl carta : cartas) {
            if (carta.getPalo() == 'P') {
                contadorPica++;
            } else {
                if (carta.getPalo() == 'C') {
                    contadorCorazon++;
                } else {
                    if (carta.getPalo() == 'T') {
                        contadorTrevol++;
                    } else {
                        if (carta.getPalo() == 'R') {
                            contadorRombo++;
                        }
                    }
                }
            }
        }

        //Con este if se comprueba de que palo es el color que hay en la baraja si hay algun color
        if (contadorPica>4 || contadorCorazon>4 ||contadorTrevol>4 || contadorRombo>4){
            if (contadorPica>4){
                color = 'P';
            }else{
                if (contadorCorazon>4){
                    color = 'C';
                }else{
                    if (contadorTrevol>4){
                        color = 'T';
                    }else{
                        color = 'R';
                    }
                }
            }
        }

        return color;
    }

}
