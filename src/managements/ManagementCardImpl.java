package managements;

import basicsClasses.CardImpl;
import basicsClasses.TableImpl;

import java.util.ArrayList;

public class ManagementCardImpl {

    
    /*
     * SIGNATURA: public int calculateValueTopCard(CartaImpl[] cards);
     * COMENTARIO: Calcular el valor de la carta mas alta del array de cartas pasado por parametro
     * PRECONDICIONES: - El array de cartas pasado por parametro no puede contener cartas por defecto
     * ENTRADA: - Un array de CartaImpl
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: Devuelve asociado al nombre un entero con la cantidad de puntos que tiene la carta mas alta del array pasado por parametro
     */

    /**
     * Calculate the highest card value in the array passed by parameter
     * @param cards CardImpl[] cards you want to value
     * @return returns the value of the highest card
     */

    public int calculateValueTopCard(CardImpl[] cards){
        CardImpl[] organizedCard = new CardImpl[cards.length];
        System.arraycopy(cards,0,organizedCard,0,cards.length);
        arrangeCards(organizedCard);
        int points = 0;
        if (organizedCard.length>1){
            points = organizedCard[organizedCard.length-1].getValueNumber();
        }
        return points;
    }

    /*
     * SIGNATURA: public int calculateValuePair(CartaImpl[] cards);
     * COMENTARIO: Calcular el valor de la pareja mas alta del array de cartas pasado por parametro
     * PRECONDICIONES: - El array de cartas pasado por parametro no puede contener cartas por defecto
     * ENTRADA: - Un array de CartaImpl
     * Salida: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con la cantidad de puntos que tiene la pareja mas alta del array pasado por parametro
     *                  - Si no hay ninguna pareja devuelve 0
     */

    /**
     * Calculate the highest value of the pair in the array passed by parameter
     * @param cards CardImpl[] cards you want to value
     * @return Returns 0 if not exist pair in array. Returns the value of pair if exist pair in array.
     */

    public int calculateValuePair(CardImpl[] cards){
        CardImpl[] organizedCard = new CardImpl[cards.length];
        System.arraycopy(cards,0,organizedCard,0,cards.length);
        arrangeCards(organizedCard);
        int points = 0;
        if (organizedCard.length>1){
            for (int i = 0; i < organizedCard.length-1; i++){
                if (i == 0 && organizedCard.length == 2){
                    if (organizedCard[i].getValueNumber() == organizedCard[i+1].getValueNumber()){
                        points = 13 + organizedCard[i].getValueNumber();
                    }
                }else{
                    if (i == 0){
                        if (organizedCard[i].getValueNumber() == organizedCard[i+1].getValueNumber()
                            && organizedCard[i].getValueNumber() != organizedCard[i+2].getValueNumber()){
                            points = 13 + organizedCard[i].getValueNumber();
                        }
                    }else{
                        if (i < organizedCard.length - 3){
                            if (organizedCard[i].getValueNumber() != organizedCard[i-1].getValueNumber()
                                && organizedCard[i].getValueNumber() == organizedCard[i+1].getValueNumber()
                                && organizedCard[i].getValueNumber() != organizedCard[i+2].getValueNumber()){
                                points = 13 + organizedCard[i].getValueNumber();
                            }
                        }else{
                            if (i == organizedCard.length - 2){
                                if (organizedCard[i].getValueNumber() != organizedCard[i-1].getValueNumber()
                                    && organizedCard[i].getValueNumber() == organizedCard[i+1].getValueNumber()){
                                    points = 13 + organizedCard[i].getValueNumber();
                                }
                            }
                        }
                    }
                }
            }
        }
        return points;
    }

    /*
     * SIGNATURA: public int calculateValueDoublePair(CartaImpl[] cards);
     * COMENTARIO: Calcular el valor de la doble pareja mas alta que haya en el array pasado por parametro
     * PRECONDICIONES: - El array de cartas pasado por parametro no puede contener cartas por defecto
     * ENTRADA: - Un array de CartaImpl
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con el valor de la doble pareja mas alta que haya
     *                  - Si no hay doble pareja devuelve 0
     */

    /**
     * Calculate the highest value of the pair in the array passed by parameter
     * @param cards CartaImpl[] cards you want to value
     * @return Returns 0 if not exist double pair in array. Returns the value of double pair if exist double pair in array.
     */

    public int calculateValueDoublePair(CardImpl[] cards){
        int points = 0;
        CardImpl[] organizedCard = new CardImpl[cards.length];
        System.arraycopy(cards,0,organizedCard,0,cards.length);
        arrangeCards(organizedCard);
        ArrayList<Integer> pairs = new ArrayList<>();
        int [][] possibilities = new int[78][2];
        //Se crean todas las possibilities que hay de doble pareja
        for (int i = 0, partialCounter = 1, totalCounter = 2;i<possibilities.length;i++,partialCounter++){
            if (partialCounter == 14){
                totalCounter++;
                partialCounter = 1;
            }
            if (totalCounter == partialCounter){
                totalCounter++;
                partialCounter = 1;
            }
            possibilities[i][1] = totalCounter;
            possibilities[i][0] = partialCounter;
        }

        //Si no hay minimo 4 cards no se puede calcular la doble pareja
        if (organizedCard.length>3){
            //Recorremos el array en busca de las doble pareja
            for (int i = 0;i<organizedCard.length-1;i++){
                //Se ejecuta cuando el indice esta al principio de la baraja
                if (i == 0){
                    //Comprueba que el valor de la siguiente carta a las cards de la pareja sea distinta
                    if (organizedCard[i].getValueNumber() == organizedCard[i+1].getValueNumber()
                        && organizedCard[i].getValueNumber() != organizedCard[i+2].getValueNumber()) {
                        pairs.add(organizedCard[i].getValueNumber());
                    }
                }else{
                    //Se ejecuta cuando el indice esta en medio de la baraja
                    if (i < organizedCard.length-2){
                        //Comprueba que el valor de la siguiente carta y la anterior a las cards de la pareja sea distinta
                        if (organizedCard[i].getValueNumber() != organizedCard[i-1].getValueNumber()
                            && organizedCard[i].getValueNumber() == organizedCard[i+1].getValueNumber()
                            && organizedCard[i].getValueNumber() != organizedCard[i+2].getValueNumber()) {
                            pairs.add(organizedCard[i].getValueNumber());
                        }
                    }else{
                        //Se ejecuta cuando el indice esta al final de la baraja
                        if (i == organizedCard.length-2){
                            //Comprueba que el valor de la anterior a las cards de la pareja sea distinta
                            if (organizedCard[i].getValueNumber() != organizedCard[i-1].getValueNumber()
                                && organizedCard[i].getValueNumber() == organizedCard[i+1].getValueNumber()) {
                                pairs.add(organizedCard[i].getValueNumber());
                            }
                        }
                    }
                }
            }

            //En el caso de que haya mas de 1 pareja buscamos el valor de la carta
            if (pairs.size()>1){
                //Recorre el array buscando la combinacion
                for (int j = 0; j<possibilities.length; j++){
                    //Utilizamos .size()-X porque asi cogemos las dos ultimas pairs que son las de mayor valor
                    if (possibilities[j][0] == pairs.get(pairs.size()-2)
                        && possibilities[j][1] == pairs.get(pairs.size()-1)){
                        points = 26 + (j+1);
                    }
                }
            }
        }
        return points;
    }

    /*
     * SIGNATURA: public int calculateValueTrio(CartaImpl[] cards);
     * COMENTARIO: Calcular el valor del trio mas alta del array de cartas pasado por parametro
     * PRECONDICIONES: - El array de cartas pasado por parametro no puede contener cartas por defecto
     * ENTRADA: - Un array de CartaImpl
     * Salida: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con la cantidad de puntos que corresponde al trio mas alto del array pasado por parametro
     *                  - Si no hay ningun trio devuelve 0
     */

    /**
     * Calculate the highest value of the trio in the array passed by parameter
     * @param cards CardImpl[] cards you want to value
     * @return Returns 0 if not exists trio in array passed by parameter. Return the value of the trio if exists trio in array passed by parameter
     */

    public int calculateValueTrio(CardImpl[] cards){
        int points = 0;
        CardImpl[] organizedCard = new CardImpl[cards.length];
        System.arraycopy(cards,0,organizedCard,0,cards.length);
        arrangeCards(organizedCard);
        if (organizedCard.length>2) {
            //Recorremos el array para buscar trios
            for (int i = 0; i < organizedCard.length - 2; i++) {
                //Comprobar si hay trio cuando el indice esta al principio del array
                if (i == 0 && organizedCard.length > 3) {
                    //Comprueba que haya trio y que la siguiente carta al trio sea distinta
                    if (organizedCard[i].getValueNumber() == organizedCard[i + 1].getValueNumber()
                        && organizedCard[i].getValueNumber() == organizedCard[i + 2].getValueNumber()
                        && organizedCard[i].getValueNumber() != organizedCard[i + 3].getValueNumber()) {

                        points = 104 + organizedCard[i].getValueNumber();

                    }
                } else {
                    //No hace falta comprobar que es menor que 4 porque arriba esta comprobado > 3 y si entra aqui es porque no se ha cumplido
                    if (i == 0) {
                        //Comprueba que haya trio
                        if (organizedCard[i].getValueNumber() == organizedCard[i + 1].getValueNumber()
                                && organizedCard[i].getValueNumber() == organizedCard[i + 2].getValueNumber()) {

                            points = 104 + organizedCard[i].getValueNumber();

                        }
                    } else {
                        //No hace falta que compruebe i != 0 porque esta comprobado en los casos anteriores
                        //Comprueba cuando el indice esta en medio
                        if (i < organizedCard.length - 4) {
                            //Comprueba que la carta anterior y posterior a las cards que forman el trio sean de distinto valor a la del trio
                            if (organizedCard[i].getValueNumber() != organizedCard[i - 1].getValueNumber()
                                    && organizedCard[i].getValueNumber() == organizedCard[i + 1].getValueNumber()
                                    && organizedCard[i].getValueNumber() == organizedCard[i + 2].getValueNumber()
                                    && organizedCard[i].getValueNumber() != organizedCard[i + 3].getValueNumber()) {

                                points = 104 + organizedCard[i].getValueNumber();

                            }
                        } else {
                            //Comprueba cuando el indice ya es el ultimo posible a evaluar
                            if (i == organizedCard.length - 3) {
                                //Comprueba que la carta posterior a las cards que forman el trio sean de distinto valor a la del trio
                                if (organizedCard[i].getValueNumber() != organizedCard[i - 1].getValueNumber()
                                        && organizedCard[i].getValueNumber() == organizedCard[i + 1].getValueNumber()
                                        && organizedCard[i].getValueNumber() == organizedCard[i + 2].getValueNumber()) {

                                    points = 104 + organizedCard[i].getValueNumber();

                                }
                            }
                        }
                    }
                }
            }
        }
        return points;
    }

    /*
     * SIGNATURA: public int calculateValueStairs(CartaImpl[] cards);
     * COMENTARIO: Calcular el valor de la escalera mas alta del array de cartas pasado por parametro
     * PRECONDICIONES: - El array de cartas pasado por parametro no puede contener cartas por defecto
     * ENTRADA: - Un array de CartaImpl
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con la cantidad de puntos que corresponde a la escalera mas alta del array pasado por parametro
     *                  - Si no hay ninguna escalera devuelve 0
     */

    /**
     * Calculate the highest value of the stair in the array passed by parameter
     * @param cards CardImpl[] cards you want to value
     * @return Return 0 if there is no stair. Return the value of stair if exist in array.
     */

    public int calculateValueStairs(CardImpl[] cards){
        int points = 0;
        ArrayList<CardImpl> unrepeatedCards = new ArrayList<>();
        boolean exist = false;
        if (cards.length>4){

            //Array para guardar las cards sin que esten repetidas
            unrepeatedCards.add(cards[0]);

            //Recorremos las cards para guardar en el ArrayList unrepeatedCards las cards sin repetir
            for (CardImpl card: cards){

                //Recorre el array comprobando que esa card no este añadida ya
                for (int j = 0; j<unrepeatedCards.size() && !exist;j++){
                    if (card.getValueNumber()==unrepeatedCards.get(j).getValueNumber()){
                        exist = true;
                    }
                }

                //Si no exist la añade
                if (!exist){
                    unrepeatedCards.add(card);
                }
                exist = false;
            }

            //Orderna el array para porder evaluarlo
            unrepeatedCards.sort(CardImpl::compareTo);

            //Comprueba si la escalera de color puede ser que sea A,2,3,4,5
            //Como la carta A es la se mayor valor no se coloca delante en el array entonces hay que comprobarla estando detras
            if (unrepeatedCards.get(0).getValueNumber() == 1 && unrepeatedCards.get(unrepeatedCards.size() - 1).getValueNumber() == 13) {

                //Como sabemos que la primera carta sera el 2 y la ultima sera la A podemos usar posiciones absolutas para comprobar si hay escalera tipo A,2,3,4,5
                if ((unrepeatedCards.get(1).getValueNumber() == ((unrepeatedCards.get(0).getValueNumber()) + 1))
                        && (unrepeatedCards.get(2).getValueNumber() == ((unrepeatedCards.get(1).getValueNumber()) + 1))
                        && (unrepeatedCards.get(3).getValueNumber() == ((unrepeatedCards.get(2).getValueNumber()) + 1))) {

                    //En el caso de que pueda ser A,2,3,4,5,6 o incluso A,2,3,4,5,6,7 se realizara este bucle for para coger la escalera mas alta.
                    if (unrepeatedCards.get(4).getValueNumber() == unrepeatedCards.get(3).getValueNumber()) {
                        for (int i = 3, j = 0; unrepeatedCards.get(i + 1).getValueNumber() == unrepeatedCards.get(i).getValueNumber(); i++, j++) {
                            points = 117 + unrepeatedCards.get(j).getValueNumber();
                        }
                    } else {
                        //En el cado de que no haya una escalera mas grande se coloca la escalera del A,2,3,4,5
                        points = 117 + unrepeatedCards.get(0).getValueNumber();
                    }
                }

            }

            for (int i = 0; i < unrepeatedCards.size() - 4; i++) {

                //Comprueba si hay ecalera ya que las cards estan en orden
                if ((unrepeatedCards.get(i+1).getValueNumber() == ((unrepeatedCards.get(i).getValueNumber()) + 1))
                        && (unrepeatedCards.get(i+2).getValueNumber() == ((unrepeatedCards.get(i+1).getValueNumber()) + 1))
                        && (unrepeatedCards.get(i+3).getValueNumber() == ((unrepeatedCards.get(i+2).getValueNumber()) + 1))
                        && (unrepeatedCards.get(i+4).getValueNumber() == ((unrepeatedCards.get(i+3).getValueNumber()) + 1))) {

                    //Se le suma 1 a la cantidad total porque el valor 131 se deja guardado para la escalera A,2,3,4,5
                    //Si no se le sumara 1 la escalera 2,3,4,5,6 tendria el mismo valor que la escalera A,2,3,4,5 por el echo de como se ordenan las cards de mayor a menor
                    points = 117 + (unrepeatedCards.get(i).getValueNumber()+1);

                }

            }

        }
        return points;
    }

    /*
     * SIGNATURA: public int calculateValueColor(CartaImpl[] cards);
     * COMENTARIO: Calcula el valor de la carta mas alta cuando hay color
     * PRECONDICIONES: - El array de cartas pasado por parametro no puede contener cartas por defecto
     * ENTRADA: - Un array de CartaImpl
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con la cantidad de puntos que corresponde al color mas alto del array pasado por parametro
     *                  - Si no hay color devuelve 0
     */

    /**
     * Calculate the highest value of the color in the array passed by parameter
     * @param cards CartaImpl[] cards you want to value
     * @return Returns 0 if there is no color. Returns the value of color if exist color in array.
     */

    public int calculateValueColor(CardImpl[] cards){
        int points = 0;
        char suitColor;
        CardImpl topCardColor;

        //Calcula si hay 5 cards del mismo color en el array pasado por parametro
        //Si no hay devolvera N lo cual no se ejecutara
        suitColor = calculateTypeColor(cards);

        if (suitColor != 'N'){

            //Carta por defecto con el valor minimo
            topCardColor = new CardImpl(suitColor,"2");

            //Este for se utiliza para sacar la carta mas alta del color
            for (CardImpl card: cards){
                if (card.getSuit() == suitColor){
                    if (card.getValueNumber()>topCardColor.getValueNumber()){
                        topCardColor = card;
                    }
                }
            }
            //El valor del color depende de la carta mas alta del color.
            points = 127 + topCardColor.getValueNumber();
        }
        return points;
    }

    /*
     * SIGNATURA: public int calculateValueFull(CartaImpl[] cards);
     * COMENTARIO: Calcula el valor del full del array de CartasImpl pasado por parametro
     * PRECONDICIONES: - El array de cartas pasado por parametro no puede contener cartas por defecto
     * ENTRADA: - Un array de CartaImpl
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con la cantidad de puntos que corresponden al full mas alto del array pasado por parametro
     *                  - Si no hay full devuelve 0
     */

    /**
     * Calculate the value of the "Full" in deck of cards.
     * @param cards CardImpl[] cards you want to value
     * @return int with value of the "Full" in poker. If not exist "Full" in the deck of cards, returns 0
     */

    public int calculateValueFull(CardImpl[] cards){
        CardImpl[] organizedCard = new CardImpl[cards.length];
        System.arraycopy(cards,0,organizedCard,0,cards.length);
        arrangeCards(organizedCard);
        int points = 0;
        int quantityTrio = 0, quantityCouples = 0;
        int valueTrio = 0, valueCouple = 0;
        int [][] possibilities = new int[156][2];
        //For para colocar todas las possibilities de full
        for (int i = 0, partialCounter = 1, totalCounter = 1;i<possibilities.length;i++,partialCounter++){
            if (partialCounter == 14){
                totalCounter++;
                partialCounter = 1;
            }
            if (totalCounter == partialCounter){
                partialCounter++;
            }
            possibilities[i][0] = totalCounter;
            possibilities[i][1] = partialCounter;
        }

        if (organizedCard.length>=5){
            //Recorre el array contando cuantos trios existen el la baraja y obteniendo su valor
            for (int i = 0;i<organizedCard.length-2;i++){
                //Con estos ifs se controla que no haya poker
                //Comprueba si hay trio al principio del array
                if (i == 0){
                    //Comprueba que el valor de la siguente carta a las tres del trio sea distinto, ya que si no habria poker
                    if (organizedCard[i].getNumber().equals(organizedCard[i+1].getNumber())
                        && organizedCard[i].getNumber().equals(organizedCard[i+2].getNumber())
                        && !(organizedCard[i].getNumber().equals(organizedCard[i+3].getNumber()))){
                        valueTrio = organizedCard[i].getValueNumber();
                        quantityTrio++;
                    }
                }else{
                    //Comprueba si hay trio en medio del array
                    if (i <= organizedCard.length-4){
                        //Comprueba que el valor de la siguiente carta y la anterior a las tres del trio sea distinto, ya que si no habria poker
                        if (!(organizedCard[i].getNumber().equals(organizedCard[i-1].getNumber()))
                            && organizedCard[i].getNumber().equals(organizedCard[i+1].getNumber())
                            && organizedCard[i].getNumber().equals(organizedCard[i+2].getNumber())
                            && !(organizedCard[i].getNumber().equals(organizedCard[i+3].getNumber()))){
                            valueTrio = organizedCard[i].getValueNumber();
                            quantityTrio++;
                        }
                    }else{
                        //Comprueba si hay trio al final del array
                        if (i == organizedCard.length-3){
                            //Comprueba que el valor de la anterior carta a las tres del trio sea distinto, ya que si no habria poker
                            if (!(organizedCard[i].getNumber().equals(organizedCard[i-1].getNumber()))
                                && organizedCard[i].getNumber().equals(organizedCard[i+1].getNumber())
                                && organizedCard[i].getNumber().equals(organizedCard[i+2].getNumber())){
                                valueTrio = organizedCard[i].getValueNumber();
                                quantityTrio++;
                            }
                        }
                    }
                }
            }

            //Si hay un trio comprueba si hay parejas
            if (quantityTrio > 0){
                for (int i = 0; i < organizedCard.length-1; i++) {
                    //En el caso de que el valor de la carta sea igual que la del trio no se evalua
                    if (organizedCard[i].getValueNumber() != valueTrio){
                        //No hace falta comprobar que i se pase de rango por arriba porque ya esta controlado en un if de arriba
                        //Comprueba si hay pareja al principio del array
                        if (i == 0){
                            //Comprueba que el valor de la siguiente carta a las dos de la pareja sea distinto, ya que si no habria trio
                            if (organizedCard[i].getValueNumber() == organizedCard[i + 1].getValueNumber()
                                && organizedCard[i].getValueNumber() != organizedCard[i + 2].getValueNumber()) {
                                valueCouple = organizedCard[i].getValueNumber();
                                quantityCouples++;
                            }
                        }else{
                            //Comprueba si hay pareja en medio del array
                            if (i <= organizedCard.length-3){
                                //Comprueba que el valor de la siguiente carta y la anterior a las dos de la pareja sea distinto, ya que si no habria trio
                                if (organizedCard[i].getValueNumber() == organizedCard[i + 1].getValueNumber()
                                    && organizedCard[i].getValueNumber() != organizedCard[i + 2].getValueNumber()
                                    && organizedCard[i].getValueNumber() != organizedCard[i - 1].getValueNumber()) {
                                    valueCouple = organizedCard[i].getValueNumber();
                                    quantityCouples++;
                                }
                            }else{
                                //Comprueba si hay pareja al final del array
                                if (i == organizedCard.length-2){
                                    //Comprueba que el valor de la anterior carta a las dos de la pareja sea distinto, ya que si no habria trio
                                    if (organizedCard[i].getValueNumber() == organizedCard[i + 1].getValueNumber()
                                        && !(organizedCard[i].getValueNumber() == organizedCard[i - 1].getValueNumber())) {
                                        valueCouple = organizedCard[i].getValueNumber();
                                        quantityCouples++;
                                    }
                                }
                            }
                        }
                    }
                }

                //En el caso de no haber una pareja y haber 2 trios o mas se podra usar el 2 trio mas alto como pareja
                if (quantityCouples == 0 && quantityTrio > 1){
                    //Recorre el array contando cuantos trios existen el la baraja
                    for (int i = 0;i<organizedCard.length-2;i++){
                        //Este if se usa para que no se evalue el trio elegido arriba (asi se coge el segundo trio mas valorado y no se coge el primero por lo cual no se repite)
                        if (organizedCard[i].getValueNumber() != valueTrio) {
                            //Comprueba si hay trio al principio del array
                            if (i == 0){
                                //Comprueba que el valor de la siguente carta a las tres del trio sea distinto, ya que si no habria full
                                if (organizedCard[i].getNumber().equals(organizedCard[i+1].getNumber())
                                    && organizedCard[i].getNumber().equals(organizedCard[i+2].getNumber())
                                    && !organizedCard[i].getNumber().equals(organizedCard[i+3].getNumber())){
                                    //Se guarda en la variable de pareja porque se usa el segundo trio mas alto como pareja al no haber pareja y si mas de 1 trio
                                    valueCouple = organizedCard[i].getValueNumber();
                                    quantityCouples++;
                                }
                            }else{
                                //Comprueba si hay trio en medio del array
                                if (i <= organizedCard.length-4){
                                    //Comprueba que el valor de la siguiente carta y la anterior a las tres del trio sea distinto, ya que si no habria full
                                    if (!organizedCard[i].getNumber().equals(organizedCard[i-1].getNumber())
                                        && organizedCard[i].getNumber().equals(organizedCard[i+1].getNumber())
                                        && organizedCard[i].getNumber().equals(organizedCard[i+2].getNumber())
                                        && !organizedCard[i].getNumber().equals(organizedCard[i+3].getNumber())){
                                        //Se guarda en la variable de pareja porque se usa el segundo trio mas alto como pareja al no haber pareja y si mas de 1 trio
                                        valueCouple = organizedCard[i].getValueNumber();
                                        quantityCouples++;
                                    }
                                }else{
                                    //Comprueba si hay trio al final del array
                                    if (i == organizedCard.length-3){
                                        //Comprueba que el valor de la anterior carta a las tres del trio sea distinto, ya que si no habria full
                                        if (!organizedCard[i].getNumber().equals(organizedCard[i-1].getNumber())
                                            && organizedCard[i].getNumber().equals(organizedCard[i+1].getNumber())
                                            && organizedCard[i].getNumber().equals(organizedCard[i+2].getNumber())){
                                            //Se guarda en la variable de pareja porque se usa el segundo trio mas alto como pareja al no haber pareja y si mas de 1 trio
                                            valueCouple = organizedCard[i].getValueNumber();
                                            quantityCouples++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            //No hace falta comprobar que la cantidad de trios sea superior a 0 porque si la cantidad de parejas es superior a 0 significa que se ha entrado en la condifion del if (quantityTrio > 0)
            //Se comprueba antes que la cantidad de trios sea superior a 0 porque asi nos evitamos buscar parejas si no hay minimo 1 trio
            if (quantityCouples > 0){
                //Recorre el array buscando cual es el valor del full
                for (int i = 0; i<possibilities.length && points==0; i++){
                    if (possibilities[i][0] == valueTrio && possibilities[i][1] == valueCouple){
                        //Se le suma 1 a i ya que el array empieza por 0 y entonces la muestra un punto menos en todas las combinaciones posibles
                        points = 140 + (i+1);
                    }
                }
            }
        }
        return points;
    }

    /*
     * SIGNATURA: public int calculateValuePoker(CartaImpl[] cards);
     * COMENTARIO: Calcula el valor del poker del array de CartasImpl pasado por parametro
     * PRECONDICIONES: - El array de cartas pasado por parametro no puede contener cartas por defecto
     * ENTRADA: - Un array de CartaImpl
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con la cantidad de puntos que corresponde al poker mas alto del array pasado por parametro
     *                  - Si no hay poker devuelve 0
     */

    /**
     * Calculate the highest value of the poker in the array passed by parameter
     * @param cards CardImpl[] cards you want to value
     * @return int Return 0 if not exist poker. Returns the value of poker if exist poker.
     */

    public int calculateValuePoker(CardImpl[] cards){
        CardImpl[] organizedCard = new CardImpl[cards.length];
        System.arraycopy(cards,0,organizedCard,0,cards.length);
        arrangeCards(organizedCard);
        int puntos = 0;
        if (organizedCard.length>3){
            //Como el array esta ordenado las 4 cartas estaran juntas en el caso de haber poker por lo cual se comprueba de esta manera
            //Recorre el array buscando si hay poker.
            for (int i = 0;i<organizedCard.length-3;i++){
                if ( (organizedCard[i].getNumber().equals(organizedCard[i+1].getNumber()))
                        && (organizedCard[i].getNumber().equals(organizedCard[i+2].getNumber()))
                        && (organizedCard[i].getNumber().equals(organizedCard[i+3].getNumber()))){

                    puntos = 296+organizedCard[i].getValueNumber();

                }
            }
        }
        return puntos;
    }

    /*
     * SIGNATURA: public int calculateValueColorStair(CartaImpl[] cards);
     * COMENTARIO: Calcula el valor de la escalera de color del array de CartasImpl pasado por parametro
     * PRECONDICIONES: - El array de cartas pasado por parametro no puede contener cartas por defecto
     * ENTRADA: - Un array de CartaImpl
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con la puntuacion que corresponde a la escalera de color mas alta del array pasado por parametro
     *                  - Si no hay escalera de color devuelve 0
     */

    /**
     * Calculate the highest value of the color stair in the array passed by parameter
     * @param cards CardImpl[] cards you want to value
     * @return Returns 0 if there is no color stair. Returns value of stair of color if exists
     */

    public int calculateValueColorStair(CardImpl[] cards){
        int points = 0;
        char color;
        int quantityCards = 0;
        CardImpl[] colorCards;
        boolean stairType1 = false;

        //Calcula si hay color. N si no hay o el caracter del color que exista
        color = calculateTypeColor(cards);

        //if (cards.length > 4 && color != 'N') {      cards.length sobra porque si hay color significa que hay 5 cards o mas
        if (color != 'N') {

            //Calcula la cantidad de cards que hay del color que se ha calculado el cual hay color
            for (CardImpl carta : cards){
                if (carta.getSuit() == color) {
                    quantityCards++;
                }
            }

            //Array para meter las cards del mismo color
            colorCards = new CardImpl[quantityCards];

            //Anhade todas las cards del color obtenido en el array creado
            for (int i = 0, j = 0; i < cards.length; i++) {
                if (cards[i].getSuit() == color) {
                    colorCards[j] = cards[i];
                    j++;
                }
            }

            arrangeCards(colorCards);

            //Comprueba si la escalera de color puede ser que sea A,2,3,4,5
            //Como la carta A es la se mayor valor no se coloca delante en el array entonces hay que comprobarla estando detras
            if (colorCards[0].getValueNumber() == 1 && colorCards[colorCards.length - 1].getValueNumber() == 13) {

                //Esta controlado que no haya numeros repetidos ya que no puede haber numeros repetidos en un palo

                //Como sabemos que la primera carta sera el 2 y la ultima sera la A podemos usar posiciones absolutas para comprobar si hay escalera de color tipo A,2,3,4,5
                if ((colorCards[1].getValueNumber() == ((colorCards[0].getValueNumber()) + 1))
                     && (colorCards[2].getValueNumber() == ((colorCards[1].getValueNumber()) + 1))
                     && (colorCards[3].getValueNumber() == ((colorCards[2].getValueNumber()) + 1))) {

                    //If para comprobar si la carta siguiente 4 es un numero mayor a la carta 3 lo cual significaria que habra escalera mas alta que A,2,3,4,5
                    if (colorCards[4].getValueNumber() == colorCards[3].getValueNumber() + 1) {
                        //En el caso de que pueda ser A,2,3,4,5,6 o incluso A,2,3,4,5,6,7 se realizara este bucle for para coger la escalera de color mas alta.
                        for (int i = 3, j = 0; colorCards[i + 1].getValueNumber() == colorCards[i].getValueNumber() + 1 && i<colorCards.length-2; i++, j++) {
                            points = 309 + colorCards[j].getValueNumber();
                        }
                    } else {
                        //En el cado de que no haya una escalera mas grande se coloca la escalera de color del A,2,3,4,5
                        points = 309 + colorCards[0].getValueNumber();
                        stairType1 = true;
                    }
                }
            }

            //En el caso de que haya escalera tipo A,2,3,4,5 o algo mayor no se ejecutara
            if (!stairType1){
                //Recorre el array para comprobar si hay escalera de color
                for (int i = 0; i < colorCards.length - 4; i++) {

                    if ((colorCards[i+1].getValueNumber() == ((colorCards[i].getValueNumber()) + 1))
                         && (colorCards[i+2].getValueNumber() == ((colorCards[i+1].getValueNumber()) + 1))
                         && (colorCards[i+3].getValueNumber() == ((colorCards[i+2].getValueNumber()) + 1))
                         && (colorCards[i+4].getValueNumber() == ((colorCards[i+3].getValueNumber()) + 1))) {

                        points = 309 + (colorCards[i].getValueNumber()+1);

                    }

                }
            }

        }
        return points;
    }

    /*
     * SIGNATURA: public int evaluateCardsFromPlayer(int player, MesaImpl table);
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
     * @param player player of which we want to evaluate the cards
     * @param table table where the player plays
     * @return int with the value of the player's cards passed by parameter on a table
     */

    public int evaluateCardsFromPlayer(int player, TableImpl table){

        int finalPoints, calculatedPoints;
        CardImpl[] cardsToEvaluate;

        //Obtener cartas que se quieren evaluar.
        cardsToEvaluate = getCardsToEvaluate(player,table);

        //Ordenar las cartas obtenidas
        arrangeCards(cardsToEvaluate);

        //Va comprobando todos los valores de las distintas posibilidades que tiene el player y se queda con la posibilidad mas alta.
        finalPoints = calculateValueTopCard(cardsToEvaluate);

        calculatedPoints = calculateValuePair(cardsToEvaluate);
        if (calculatedPoints>finalPoints){
            finalPoints = calculatedPoints;
        }

        calculatedPoints = calculateValueDoublePair(cardsToEvaluate);
        if (calculatedPoints>finalPoints){
            finalPoints = calculatedPoints;
        }

        calculatedPoints = calculateValueTrio(cardsToEvaluate);
        if (calculatedPoints>finalPoints){
            finalPoints = calculatedPoints;
        }

        calculatedPoints = calculateValueStairs(cardsToEvaluate);
        if (calculatedPoints>finalPoints){
            finalPoints = calculatedPoints;
        }

        calculatedPoints = calculateValueColor(cardsToEvaluate);
        if (calculatedPoints>finalPoints){
            finalPoints = calculatedPoints;
        }

        calculatedPoints = calculateValuePoker(cardsToEvaluate);
        if (calculatedPoints>finalPoints){
            finalPoints = calculatedPoints;
        }

        calculatedPoints = calculateValueFull(cardsToEvaluate);
        if (calculatedPoints>finalPoints){
            finalPoints = calculatedPoints;
        }

        calculatedPoints = calculateValueColorStair(cardsToEvaluate);
        if (calculatedPoints>finalPoints){
            finalPoints = calculatedPoints;
        }
        return finalPoints;
    }

    /*
     * SIGNATURA: public CartaImpl[] getCardsToEvaluate(int player, MesaImpl table);
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
     * @param player player of which we want to evaluate the cards
     * @param table table where the player plays
     * @return CardImpl[] array of CardImpl with the player's cards passed by parameter
     */

    public CardImpl[] getCardsToEvaluate(int player, TableImpl table){
        CardImpl[] totalCards;

        int quantityCards = 0;
        CardImpl[] cardsTable = table.getCardsOfTable();
        CardImpl[] cardsPlayer = table.setCardsPlayer(player);

        //Obtiene la cantidad de cartas que hay en la table con valor distinto al de defecto
        for (int i = 0; i<cardsTable.length&&(cardsTable[i].getSuit()!='D'); i++){
            quantityCards++;
        }

        //Obtiene la cantidad de cartas que posee el player pasado por parametro con valor distinto al de defecto
        for (int i = 0; i<cardsPlayer.length&&(cardsPlayer[i].getSuit()!='D'); i++){
            quantityCards++;
        }

        totalCards = new CardImpl[quantityCards];

        //Inicializar el array para no tener errores de null
        for (int i = 0; i<totalCards.length;i++){
            totalCards[i] = new CardImpl();
        }

        //Anhade al array de cartas totales todas las cartas distintas al valor por defecto que hay en la table
        for (int i = 0; i<cardsTable.length&&(cardsTable[i].getSuit()!='D'); i++){
            totalCards[i] = cardsTable[i].clone();
        }

        //Anhade al array de cartas totales todas las cartas distintas al valor por defecto que posee el player
        for (int i = 0,j = 0;i<totalCards.length;i++){
            if (totalCards[i].getSuit()=='D'){
                totalCards[i] = cardsPlayer[j];
                j++;
            }
        }
        return totalCards;
    }

    /*
     * SIGNATURA: public void arrangeCards(CartaImpl[] cards);
     * COMENTARIO: Ordena las cartas de un array de cartas.
     * PRECONDICIONES: - El array debe tener como minimo 2 cartas
     *                 - El array de cartas pasado por parametro no puede contener cartas por defecto
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Un array de CartaImpl
     * POSTCONDICIONES: - Modifica el array pasado por parametro ordenado las cartas que contiene de mayor a menor valor.
     */

    /**
     * This method sort the array passed by parameter
     * @param cards Array of CartaImpl[] you want to order
     */

    public void arrangeCards(CardImpl[] cards){
        CardImpl auxCard;
        //Para ordenar utiliza el metodo de compareTo de la clase CartaImpl
        for(int i = 0; i < cards.length - 1; i++){
            for(int j = 0; j < cards.length - 1; j++){
                if (cards[j].compareTo(cards[j + 1]) == 1){
                    auxCard = cards[j+1];
                    cards[j+1] = cards[j];
                    cards[j] = auxCard;
                }
            }
        }
    }

    /*
     * SIGNATURA: public char calculateTypeColor(CartaImpl[] cards);
     * COMENTARIO: Metodo para calcular si hay color en el array de cartas
     * PRECONDICIONES: - El array de cartas pasado por parametro no puede contener cartas por defecto
     * ENTRADA: - Un array de CartaImpl
     * SALIDA: - Un caracter
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un caracter con el tipo de color que hay en el array (T,P,C,R)
     *                  - Si no hay color se devolvera N
     */

    /**
     * Method to calculate if there is color in the card array
     * @param cards Array of cards you want to check
     * @return char with the color that exist in array of cards. Return N if not exist color.
     */

    public char calculateTypeColor(CardImpl[] cards){
        char color = 'N';
        int spadeCounter = 0, heartCounter = 0, clubsCounter = 0, diamondCounter = 0;

        //Se calcula cuantas cards hay de cada palo
        for (CardImpl carta : cards) {
            if (carta.getSuit() == 'P') {
                spadeCounter++;
            } else {
                if (carta.getSuit() == 'C') {
                    heartCounter++;
                } else {
                    if (carta.getSuit() == 'T') {
                        clubsCounter++;
                    } else {
                        if (carta.getSuit() == 'R') {
                            diamondCounter++;
                        }
                    }
                }
            }
        }

        //Con este if se comprueba de que palo es el color que hay en la baraja si hay algun color
        if (spadeCounter>4 || heartCounter>4 ||clubsCounter>4 || diamondCounter>4){
            if (spadeCounter>4){
                color = 'P';
            }else{
                if (heartCounter>4){
                    color = 'C';
                }else{
                    if (clubsCounter>4){
                        color = 'T';
                    }else{
                        color = 'R';
                    }
                }
            }
        }

        return color;
    }

    /*
     * SIGNATURA: public boolean oneToStair(CartaImpl[] cards);
     * COMENTARIO: Metodo para calcular si queda una carta para que haya escalera
     * PRECONDICIONES: - El array de cartas pasado por parametro no puede contener cartas por defecto
     * ENTRADA: - Un array de CartaImpl
     * SALIDA: - Un boolean
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre true si falta una carta para escalera
     *                  - Devuelve asociado al nombre false si no falta una carta para escalera
     */

    /**
     * @param cards
     * @return
     */

    //TODO Mejorar este metodo

    public boolean oneToStair(CardImpl[] cards){
        boolean oneToStair = false;
        CardImpl[] cardsToEvalue = new CardImpl[cards.length];
        System.arraycopy(cards,0,cardsToEvalue,0,cards.length);
        arrangeCards(cardsToEvalue);

        if (cards[0].getValueNumber()+1 != cards[1].getValueNumber()
            && cards[1].getValueNumber()+1 == cards[2].getValueNumber()
            && cards[2].getValueNumber()+1 == cards[3].getValueNumber()
            && cards[3].getValueNumber()+1 == cards[4].getValueNumber()){
                oneToStair = true;
        }else{
            if (cards[0].getValueNumber()+1 != cards[1].getValueNumber()
                && cards[1].getValueNumber()+1 != cards[2].getValueNumber()
                && cards[2].getValueNumber()+1 == cards[3].getValueNumber()
                && cards[3].getValueNumber()+1 == cards[4].getValueNumber()){
                    oneToStair = true;
            }else{
                if (cards[0].getValueNumber()+1 == cards[1].getValueNumber()
                    && cards[1].getValueNumber()+1 != cards[2].getValueNumber()
                    && cards[2].getValueNumber()+1 != cards[3].getValueNumber()
                    && cards[3].getValueNumber()+1 == cards[4].getValueNumber()){
                        oneToStair = true;
                }else{
                    if (cards[0].getValueNumber()+1 == cards[1].getValueNumber()
                        && cards[1].getValueNumber()+1 == cards[2].getValueNumber()
                        && cards[2].getValueNumber()+1 != cards[3].getValueNumber()
                        && cards[3].getValueNumber()+1 != cards[4].getValueNumber()){
                            oneToStair = true;
                    }else{
                        if (cards[0].getValueNumber()+1 == cards[1].getValueNumber()
                            && cards[1].getValueNumber()+1 == cards[2].getValueNumber()
                            && cards[2].getValueNumber()+1 == cards[3].getValueNumber()
                            && cards[3].getValueNumber()+1 != cards[4].getValueNumber()){
                                oneToStair = true;
                        }
                    }
                }
            }
        }

        return oneToStair;
    }

}
