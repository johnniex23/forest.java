package Project2;

import java.io.Serializable;
import java.util.ArrayList;

public class Forest implements Serializable {
    public String forestName;
    public int index;
    public ArrayList <Tree> treesArray = new ArrayList<Tree>();



    // Forest constructor
    public Forest(ArrayList <String> array,String forestName) {
        this.forestName = forestName;

        for (int i=0; i < array.size(); i++) {

            String[] parts = splitInfo(array.get(i));
            String name = parts[0];
            int year = Integer.parseInt(parts[1]);
            double height = Double.parseDouble(parts[2]);
            double growth = Double.parseDouble(parts[3]);
            Tree tree = new Tree(name,year,height,growth);

            treesArray.add(tree);

        } // end of for loop

    } // end of Forest constructor



    // addTree method
    public void addTree() {
        Tree tree = new Tree();
        treesArray.add(tree);

    } // end of addTree method


    // grow method
    public void grow(){
        for (int i =0 ; i< treesArray.size();i++)
            treesArray.get(i).height = (treesArray.get(i).height * (treesArray.get(i).growthRate/100)) + treesArray.get(i).height;

    } // end of grow method


    // reap method
    public void reap(double height){

        for (int i =0 ; i< treesArray.size();i++){

            if (treesArray.get(i).height >= height){
                System.out.printf("%-22s %-7s %-6d %6.2f' %5.1f%%\n", "Reaping the tall tree", treesArray.get(i).speciesType, treesArray.get(i).yearPlanted, treesArray.get(i).height, treesArray.get(i).growthRate);
                Tree tree= new Tree();
                treesArray.set(i,tree);
                System.out.printf("%-22s %-7s %-6d %6.2f' %5.1f%%\n","Replaced with new tree",treesArray.get(i).speciesType, treesArray.get(i).yearPlanted, treesArray.get(i).height, treesArray.get(i).growthRate);

            } // end of if

        }  // end of for loop

    } // end of reap method



    // splitInfo method
    public static String[] splitInfo(String input) {

        String[] parts = input.split(",");

        for (int i=0; i < parts.length; i++) {
            parts[i]= parts[i].trim();

        } // end of for loop

        return parts;

    } // end of SplitInfo method


} // end of MontaneForest class


