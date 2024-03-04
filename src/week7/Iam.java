package week7;

import java.util.Scanner;

public class Iam {

    public static void main(String[] args) {

      Scanner readsentence= new Scanner(System.in);
        System.out.println("Please enter sentences, . to end.");

        StringBuilder qualities= new StringBuilder();
        String sentence;

        do {

            sentence= readsentence.nextLine();
            if (sentence.equals(".")){
                break;
            }
            String readIam = sentence.substring(0,4);

            if (readIam.equals("I am")) {

                qualities.append(sentence.substring(4));
            }



        } while (true);   // end of do while


        System.out.println("The qualities are" + qualities);

    } // end of main method

  } // end of Iam class

