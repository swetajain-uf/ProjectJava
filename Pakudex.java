//Sweta Jain
//Project 3

public class Pakudex {
    private int input;
    private String nameOf;
    private int entered;
    Pakuri[] keepT;

    public Pakudex() {
        input = 20;
        keepT = new Pakuri[input];
        entered = 0;
    }
    //Default constructor; if called, the default size for the Pakudex should be 20

    //overloading the Pakudex - 2 constructors
    public Pakudex(int capacity) {
        this.input = capacity;
        keepT = new Pakuri[capacity];
        entered = 0;
    }
    //Initializes this object to contain exactly capacity objects when completely full

    public int getSize() {
        //entered into addPakuri - to add a Pakuri species - number in Pakuri array
        return this.entered;
    }

    public int getCapacity() {
        //return capacity or 20
        return input;
    }


    //return each species name in array form
    public String[] getSpeciesArray() {
        //no Pakuri's in Pakuri array - have not added Pakuri
        if (getSize() == 0) {
            return null;
        }
        else {
            String[] new1 = new String[entered];
            //keepT take the number of Pakuri added/have and sets them into the new array above
            for (int i = 0; i < new1.length; i++){
                new1[i] = keepT[i].getSpecies();
            }
            return new1;
        }
    }
    //search if species is there in Pakudex, check/compare object name is equivalent to species name
    public int[] getStats(String species) {
        //attack, defense and speed
        int[] info = new int[3];
        //not keepT.length because if the array is not full, it will give an error - use entered
        for (int i = 0; i < entered; i++) {
            // String array name and below String array [i]
            //see if species is in Pakuri array by comparing
            //needs to check all in Pakuri array
            if (keepT[i].getSpecies().compareTo(species) == 0) {
                int j = 0;
                info[j] = keepT[i].getAttack();
                j++;
                info[j] = keepT[i].getDefense();
                j++;
                info[j] = keepT[i].getSpeed();
                return info;
            }
            }
        //if species input is not in Pakuri array
        return null;
        }
    public void sortPakuri() {
        //java standard lexographically - nested for loops
        int swap = 0;
        //check at specific index
        for (int i = 0; i < keepT.length; i++) {
            //checks at next index
            for (int j = i + 1; j < keepT.length; j++) {
                //if we have reached the end of the Pakuri array that has species or end of array
                if (keepT[j] == null) {
                    break;
                }
                //which letters in species has bigger ASCII -  index or index +1
                // A/a is the lowest so if index+1 letter ASCII is higher than switch spots
                else {
                    swap = keepT[i].getSpecies().compareTo(keepT[j].getSpecies());
                    //returns 0 if the same, negative if index's letters are before index+1
                    //positive if index+1 ASCII is more - farther in the alphabet
                    if (swap > 0) {
                        Pakuri temp = keepT[i];
                        keepT[i] = keepT[j];
                        keepT[j] = temp;
                        //so we swap the positions
                    }
                }
            }
        }
    }
        //greater than 0 swap so that  b a

    //getSize and getCapacity should return to latest version - new value
    //generates a new Pakudex object and adds to Pakudex
    public boolean addPakuri(String species) {
        int repeat = 0;
        //have not added more than capacity
        if (entered < input) {
            //check is species is in Pakuri array - return false
            for (int i = 0; i < keepT.length; i++) {
                //in beginning all keepT[] is null
                //does array have species in it - no then -
                //we add it in
                if (keepT[i] == null){
                    keepT[entered] = new Pakuri(species);
                    entered++;
                    return true;
                }
                //if species is already in array then -
                else {
                    repeat = keepT[i].getSpecies().compareTo(species);
                    if (repeat == 0) {
                        break;
                    }
                }
            }
        }
        return false;
    }
    public boolean evolveSpecies(String species) {
        boolean toEvolve = false;
        for (int i = 0; i < keepT.length; i++) {
            //species isnt in array, cannot evolve -
            if (keepT[i] == null){
                break;
            }
            //if species IS in array then -
            else if (keepT[i].getSpecies().compareTo(species) == 0 ) {
                keepT[i].evolve();
                toEvolve = true;
                return toEvolve;
            }
        }
        return toEvolve;
        }
    }
