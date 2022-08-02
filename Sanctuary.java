/**
 * Name: Kevin Yan
 * Email: kevinyan904@gmail.com
 * Sources used: tutor, java api for methods
 * 
 * Sanctuary class that creates a HashMap that has 
 * the name of an animal and the amount of it. 
 * File manipulates it using methods.
 */
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
/**
 * Class can rescue and release animals and return
 * information about the sanctuary.
 * Instance varibales: 
 * sanctuary hashmap storing the animals
 * maxAnimals, max amount of animals stored
 * maxSpecies, max amount of species stored
 */
public class Sanctuary {
    
    HashMap<String, Integer> sanctuary;
    int maxAnimals;
    int maxSpecies;
    /**
     * initializes the instance variables
     * @param maxAnimals max number of animals allowed
     * @param maxSpecies max number of species allowed
     */
    public Sanctuary(int maxAnimals, int maxSpecies) {
        if(maxAnimals < 0 || maxSpecies < 0){
            throw new IllegalArgumentException();
        }
        this.maxAnimals = maxAnimals;
        this.maxSpecies = maxSpecies;
        this.sanctuary = new HashMap<String, Integer>();
    }
    /**
     * gets the number of a specific species
     * @param species number of the species 
     * @return number of the species in the 
     * sanctuary 
     */
    public int getNum(String species) {
        if(species == null){
            throw new IllegalArgumentException();
        }
        //uses containsKey to check if species is in it
        if(sanctuary.containsKey(species)) {
            return sanctuary.get(species);
        }
        else {
            return 0;
        }
    }
    /**
     * gets the total num of animals 
     * @return total number of animals
     */
    public int getTotalAnimals() {
        int count = 0;
        //create a set of the animals in sanctuary
        Set<String> aniset = sanctuary.keySet();
        for(String animal : aniset) {
            //adds the number of animals to count
            count += sanctuary.get(animal);
        }
        return count;
    }
    /**
     * gets total num of species
     * @return total num of species
     */
    public int getTotalSpecies() {
        return sanctuary.size();
    }
    /**
     * adds a certain species to the sanctuary
     * @param species to be added
     * @param num of species to be added
     * @return number of animals not saved
     */
    public int rescue(String species, int num) {
        if(num <= 0){
            throw new IllegalArgumentException();
        }

        if(species == null){
            throw new IllegalArgumentException();
        }
        //checks if there is space to add animals
        if(getTotalAnimals() < maxAnimals) {
            //checks if the species is in the sanctuary
            if(sanctuary.containsKey(species) == false) {
                if(getTotalSpecies() + 1 <= maxSpecies) {
                    if(maxAnimals - getTotalAnimals() < num) {
                        //saves the num of animals not saved 
                        int notsaved = getTotalAnimals() + num - maxAnimals;
                        //puts the species in the sanctuary 
                        sanctuary.put(species, num - (maxAnimals - getTotalAnimals()));
                        return notsaved;
                    }
                    else{
                        sanctuary.put(species, num);
                        return 0;
                    }
                }
            }
            else {
                if(maxAnimals - getTotalAnimals() < num) {
                    //saves the num of animals not saved 
                    int notsaved = getTotalAnimals() + num - maxAnimals;
                    //puts the species in the sanctuary 
                    sanctuary.put(species, getNum(species) + (maxAnimals - getTotalAnimals()));
                    return notsaved;
                }
                else{
                    sanctuary.put(species, getNum(species) + num);
                    return 0;
                }      
            }
        }
        return num; 
    }
    /**
     * removes num of species from sanctuary
     * @param species to be removed
     * @param num of species to remove
     */
    public void release(String species, int num) {
        if(num <= 0){
            throw new IllegalArgumentException();
        }
        if(species == null) {
            throw new IllegalArgumentException();
        }
        if(sanctuary.containsKey(species)) {
            if(num > sanctuary.get(species)) {
                throw new IllegalArgumentException();
            }
        }
        if(sanctuary.containsKey(species) == false) {
            throw new IllegalArgumentException();
        }
        //replaces the num of species with the new amount
        sanctuary.replace(species, sanctuary.get(species) - num);
        if(sanctuary.get(species) == 0) {
            //removes the species if none is left
            sanctuary.remove(species);
        }
    }
}
