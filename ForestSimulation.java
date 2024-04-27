package Project2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ForestSimulation {

    // main method
    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<String> treesInfo = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);
        Scanner montaneFileScanner = new Scanner(new File ("Montane.csv"));
        Scanner acadianFileScanner = new Scanner(new File ("Acadian.csv"));
        Forest montane= new Forest(treesInfo,"Montane");
        Forest acadian= new Forest(treesInfo,"Acadian");
        treesInfo = new ArrayList<>(); //erase data
        Forest currentForest= montane;


        // while loop to read file
        while (montaneFileScanner.hasNext()) {
            treesInfo.add(montaneFileScanner.next());

        } // end of while loop


        // while loop to read file
        while (acadianFileScanner.hasNext()) {
            treesInfo.add(acadianFileScanner.next());

        } // end of while loop


        // menu print
        String menu= "(P)rint, (A)dd, (C)ut, (G)row, (R)eap, (S)ave, (L)oad, (N)ext, e(X)it : ";

        System.out.println("Welcome to the Forestry Simulation\n" +
                "----------------------------------\n" +
                "Initializing from Montane\n");
        boolean run = true;

        // while loop
        while (run) {

            System.out.print(menu);
             char option = keyboard.next().charAt(0);
             option= Character.toUpperCase(option);

            switch (option) {

            case 'P':

                System.out.println("Forest name: "  + currentForest.forestName);
                for(int k=0 ;k<currentForest.treesArray.size(); k++){
                    System.out.printf("%-2d %-7s %-6d %6.2f' %5.1f%%\n", k, currentForest.treesArray.get(k).speciesType, currentForest.treesArray.get(k).yearPlanted, currentForest.treesArray.get(k).height, currentForest.treesArray.get(k).growthRate);
                }
                System.out.println("There are " + currentForest.treesArray.size() + " trees, with an average height of " + averageHeight(currentForest) + "\n" );

                break;

            case 'A':
                currentForest.addTree();

                break;

            case 'C':
                System.out.print("Tree number to cut down: ");
                int index;

                if (keyboard.hasNextInt()){
                    index=keyboard.nextInt();
                    if (index>=0 && index< currentForest.treesArray.size()) {
                        currentForest.treesArray.remove(index);
                    } // end of if
                    else {

                        System.out.println("Tree number " + index + " does not exist");

                    } // end of else
                }  // end of if
                else {
                    keyboard.nextLine();
                    keyboard.nextLine();
                    System.out.println("That is not an integer");

                } // end of if-else

                break;

            case 'G':
                currentForest.grow();
                break;

            case 'R':
                System.out.print("Height to reap from: ");
                double height;

                if (keyboard.hasNextDouble()) {
                    height=keyboard.nextDouble();
                    if (height>=0) {
                        currentForest.reap(height);
                    } // end of if

                    else {

                        System.out.println("Invalid height");

                    } // end of else
                } // end of if

                else {
                    keyboard.nextLine();
                    keyboard.nextLine();
                    System.out.println("That is not an integer");

                } // end of if-else

                break;


            case 'S':
                if (currentForest!= null) {
                    saveForestToFile(currentForest, currentForest.forestName + ".db");

                } // end of if

                break;


            case 'L':
                System.out.print("Enter forest name: ");
                String name= keyboard.next();
                Forest forestOriginal= currentForest;
                    currentForest=loadForestFromFile(name+".db", forestOriginal);
                break;

            case 'N':
                currentForest= acadian;
                System.out.println("Moving to the next forest\n" + "Initializing from " + acadian.forestName + "\n");
                break;

            case 'X':
                System.out.println("\nExiting the Forestry Simulation");
                run= false;
                break;

            default:
                System.out.println("Invalid menu option, try again");


        }// end of switch

        } // end of while loop


    } // end of main method



    // averageHeight method
    public static double averageHeight(Forest forest){
        double sum=0;

        for (int j=0 ;j<forest.treesArray.size();j++){
            sum += forest.treesArray.get(j).height;

        } // end of for loop

         return sum/forest.treesArray.size();

    } // end of averageHeight method


    // loadForestFromFile method
    public static Forest loadForestFromFile(String fileName, Forest originalForest) {

        Forest forest = null;

        try {

            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            forest = (Forest) objectIn.readObject();
            objectIn.close();
            fileIn.close();
            System.out.println("Forest loaded from " + fileName);

        } // end of try

        catch (FileNotFoundException ex) {

            System.out.println("Error: File '" + fileName + "' not found. Old forest retained.");
            forest= originalForest;
            System.out.println("Initializing from "+ forest.forestName);

        } // end of catch

        catch (IOException | ClassNotFoundException ex) {

            ex.printStackTrace();
            System.out.println("Error opening/reading " + fileName + ". Old forest retained");

        } // end of catch

        return forest;

    } // end of loadForestFromFile method


    // saveForestToFile method
    public static void saveForestToFile(Forest forest, String fileName) {

        try {

            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(forest);
            objectOut.close();
            fileOut.close();
            System.out.println("Forest serialized and saved to " + fileName);

        }  // end of try

        catch (IOException ex) {

            ex.printStackTrace();

        } // end of catch


    } // end of saveForestToFile method



} // end of ForestSimulation class

