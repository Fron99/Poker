package enums;

import java.util.Scanner;

public enum Genders {

    Male, Female, Other;


    /**
     * @return
     */

    public static Genders readAndValidateGender(){
        Scanner SC = new Scanner(System.in);
        String gender;
        int lengthGender = Genders.values().length;
        boolean exist = false;
        do {
            System.out.print("Insert gender: ");
            gender = SC.nextLine();
            for (int i = 0;i < lengthGender ;i++){
                if (Genders.values()[i].toString().equals(gender)){
                    exist = true;
                }
            }
        }while (!exist);

        return Genders.valueOf(gender);
    }

    public static Genders readAndShowGender(){
        Scanner SC = new Scanner(System.in);
        int indexGender;
        int lengthGender = Genders.values().length;
        for (int i = 0; i < lengthGender; i++){
            System.out.println(i+".-"+Genders.values()[i].toString());
        }
        do {
            System.out.print("Insert position gender: ");
            indexGender = SC.nextInt();
        }while (indexGender < 0 || indexGender >= lengthGender);

        return Genders.values()[indexGender];
    }

}
