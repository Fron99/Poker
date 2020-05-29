import validations.Validations;

public class Main {

    public static void main(String[] args){

        Validations VL = new Validations();
        Poker PK = new Poker();
        int optionGame;

        optionGame = VL.readAndValidateGame();

        do {

            switch (optionGame){
                case 1:
                    PK.playGame();
                    break;

                case 2:

                    break;
            }

            optionGame = VL.readAndValidateGame();

        }while (optionGame != 0);

        System.out.println("Goodbye");

    }

}
