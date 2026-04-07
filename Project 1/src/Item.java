/**
 * Represents an item that can be packed into a bin (backpack).
 * Each item has a name, weight, value, and a flag indicating if it is included or not.
 */

public class Item {
    
    private final String name;
    private final double weight;
    private final int value;

    private boolean included;

    /**
     * Constructs an Item with the given parameters.
     * 
     * @param name the name of the item
     * @param weight the weight of the item in pounds
     * @param value the dollar value of the item
     */

    public Item(String name, double weight, int value){
        this.name = name;
        this.weight = weight;
        this.value = value;
        this.included = false;
    }

    /**
     * Copy constructor for creating a new Item based on another.
     * 
     * @param other the Item to copy
     */

    public Item(Item other){
        this.name = other.name;
        this.weight = other.weight;
        this.value = other.value;
        this.included = false;   
    }

    /**
     * Returns the weight of the item
     * 
     * @return the item's weight
     */

    public double getWeight(){
        return weight;
    }

    /**
     * Returns the value of the item
     * 
     * @return the item's value
     */

    public int getValue(){
        return value;
    }

    /**
     * Returns wether the item is included in the current chromosome
     * 
     * @return true if included, false otherwise
     */

    public boolean isIncluded(){
        return included;
    }

    /**
     * Sets wether the item is included in the current chromosome.
     * 
     * @param included included true to include the item, false to exclude it
     */

    public void setIncluded(boolean included){
        this.included = included;

    }

    /**
     * Returns a string representation of the item
     * 
     * @return a string in the format: anme (weight lbs., &value)
     */

    @Override
    public String toString(){
        return name + " (" + weight + " lbs., $" + value + ") ";
    }
}