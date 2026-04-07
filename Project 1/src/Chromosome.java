import java.util.ArrayList;
import java.util.Random;

/**
 * A Chromosome represents a potential solution to the bin packing problem.
 * It consists of a list of items with randomly selected included values.
 */

public class Chromosome extends ArrayList<Item> implements Comparable<Chromosome>{
    private static Random rng = new Random();
    private static final int MUTATE_PERCENT = 10;
    private static double WEIGHT_LIMIT = 10.0;

    /**
     * Default constructor. Creates an empty Chromosome
     */

    public Chromosome(){

    }

    /**
     * Constructs a Chromosome by making copies of given items and randomly setting their included status.
     * 
     * @param items the list of items to copy and randomize
     */

    public Chromosome(ArrayList<Item> items){
        for(Item item : items){
            Item copy = new Item(item);
            copy.setIncluded(rng.nextBoolean());
            this.add(copy);
        }
    }

    /**
     * Performs crossover between this chromosome and another.
     * 
     * @param other the other parent chromosome
     * @return a new child chromosome resulting from crossover
     */

    public Chromosome crossover(Chromosome other){
        Chromosome child = new Chromosome();

        for(int i = 0; i < this.size(); i++){
            int rand = rng.nextInt(10) + 1;

            Item selected;

                if(rand <= 5){
                    selected = new Item(this.get(i));
                    selected.setIncluded(this.get(i).isIncluded());
                } else  {
                    selected = new Item(other.get(i));
                    selected.setIncluded(other.get(i).isIncluded());
                }

                child.add(selected);
        }
        return child;

    }

    /**
     * Randomly mutates items in the chromosome with a probability defined by MUTATE_PERCENT.
     */

    public void mutate(){
        for(int i = 0; i < this.size(); i++){
            int rand = rng.nextInt(100);
            if(rand < MUTATE_PERCENT){
                Item item = this.get(i);
                item.setIncluded(!item.isIncluded());
            }
        }
    }

    /**
     * Calculates the fitness of the chromosome.
     * If total weight > WEIGHT_LIMIT, fitness is 0. Otherwise, it's the total value of included items
     * 
     * @return the fitness value
     */

    public int getFitness(){
        double totalWeight = 0;
        int totalValue = 0;

        for(Item item : this){
            if(item.isIncluded()){
                totalWeight += item.getWeight();
                totalValue += item.getValue();
            }
        }

        if(totalWeight > WEIGHT_LIMIT){
            return 0;
        } else {
            return totalValue;
        }

    }

    /**
     * Compares this chromosome to another based on fitness, in descending order.
     * 
     * @param other the chromosome to compare to
     * @return -1 if this is fitter, 1 if less fit, 0 if equal
     */

    @Override
    public int compareTo(Chromosome other){
        int thisFitness = this.getFitness();
        int otherFitness = other.getFitness();
            if(thisFitness > otherFitness){
                return -1;
            } else if(thisFitness < otherFitness){
                return 1;
            } else {
                return 0;
            }

    }

    /**
     * Returns a string of all included items and the chromosome's fitness.
     * 
     * @return the formatted string
     */

    @Override
    public String toString(){
        String outStr = "Take these items: \n" + "-------------\n";
        for(Item i : this){
            if(i.isIncluded()){
                outStr += i.toString() + "\n";
            }
        }
        outStr += "-------------\n" + "Total Value: $" + this.getFitness();
        return outStr;
    }

}