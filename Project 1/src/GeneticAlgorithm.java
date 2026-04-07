import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * Implements a genetic algorithm to solve a bin packing problem
 */

public class GeneticAlgorithm {

    /**
     * Reads item data from a file and returns a list of Item objects.
     * 
     * @param filename the name of the file to read
     * @return a list of Item objects
     * @throws FileNotFoundException if the file is not found
     */

    public static ArrayList<Item> readData(String filename) throws FileNotFoundException{
        ArrayList<Item> items = new ArrayList<>();
        File file = new File(filename);
        Scanner input = new Scanner(file);

        while(input.hasNextLine()){
            String line = input.nextLine();
            String[] parts = line.split(",");

            String name = parts[0].trim();
            double weight = Double.parseDouble(parts[1].trim());
            int value = Integer.parseInt(parts[2].trim());

            items.add(new Item(name, weight, value));
        }
        input.close();
        return items;
    }

    /**
     * Initializes a population of chromosomes using the given items.
     * 
     * @param items the list of items to use
     * @param populationSize the number of chromosomes to generate
     * @return the initialized population
     */

    public static ArrayList<Chromosome> initializePopulation(ArrayList<Item> items, int populationSize){
        ArrayList<Chromosome> population = new ArrayList<>();

        while(population.size() < populationSize){
            population.add(new Chromosome(items));
        }
        return population;
    }

    /**
     * Runs the genetic algorithm: reads item data, evolves the population, and displays results
     * 
     * @param args command-line arguments (unused)
     * @throws FileNotFoundException if the data file is not found
     */

    public static void main(String[] args) throws FileNotFoundException{
        ArrayList<Item> items = readData("items.txt");

        ArrayList<Chromosome> population = initializePopulation(items, 10);

        for(int generation = 0; generation < 20; generation++){
            ArrayList<Chromosome> nextGen = new ArrayList<>();

            nextGen.addAll(population);

            Random rng = new Random();
            while(nextGen.size() < 20){
                Chromosome parent1 = population.get(rng.nextInt(population.size()));
                Chromosome parent2 = population.get(rng.nextInt(population.size()));
                nextGen.add(parent1.crossover(parent2));
            }

            int mutations = nextGen.size() / 10;
            for(int i = 0; i < mutations; i++){
                int index = rng.nextInt(nextGen.size());
                nextGen.get(index).mutate();
            }
            Collections.sort(nextGen);

            population = new ArrayList<>(nextGen.subList(0, 10));
        }

        Collections.sort(population);
        System.out.println("Best Chromosome: ");
        System.out.println(population.get(0));
        System.out.println("\nLeast Fit Chromosome: ");
        System.out.println(population.get(population.size() - 1));
    }

}