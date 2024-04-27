package Project2;

import java.io.Serializable;
import java.util.Random;


public class Tree implements Serializable {
    public String speciesType;
    public int yearPlanted;
    public double height;
    public double growthRate;
    String[] species = {"BIRCH","FIR","MAPLE"};


    // constructor
    public Tree() {

        this.speciesType = randomSpeciesGenerator();
        this.yearPlanted = randomYearGenerator();
        this.height = randomHeightGenerator();
        this.growthRate = randomGrowthRateGenerator();


    } // end of Tree constructor


   // tree constructor with parameters
    public Tree(String speciesType, int yearPlanted, double height, double growthRate) {

        this.speciesType = speciesType;
        this.yearPlanted = yearPlanted;
        this.height = height;
        this.growthRate = growthRate;

    } // end of tree constructor with parameters



    // randomSpeciesGenerator method
    public String randomSpeciesGenerator() {

        Random random = new Random();
        int index = random.nextInt(species.length);
        return species[index];

    } // end of randomSpeciesGenerator method



    // randomHeightGenerator method between 10 and 20 feet
    private double randomHeightGenerator() {

        Random random = new Random();
        return new Random().nextDouble() * 11 + 10;

    } // end of randomHeightGenerator method


    // randomGrowthRateGenerator method between 10% and 20%
    private double randomGrowthRateGenerator() {

        Random random = new Random();
        return new Random().nextDouble() * 11 + 10;

    } // end of randomGrowthRateGenerator method


    // randomYearGenerator method
    private int randomYearGenerator() {
        Random random = new Random();
        return 2000 + random.nextInt(25);

    } // end of randomYearGenerator method





} // end of Tree class
