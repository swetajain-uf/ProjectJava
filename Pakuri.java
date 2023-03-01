//Sweta Jain
//Project 3

public class Pakuri {
    String species;
    //int attack, defense, speed;
    private int attack;
    private int defense;
    private int speed;

    //intially when menu selection is show
    public Pakuri(String species) {
        attack = (species.length() * 7) + 9;
        defense = (species.length() * 5) + 17;
        speed = (species.length() * 6) + 13;
        this.species = species;
    }
    //turns object species in Pakuri array to Strings
    //so we can compare input to species inside the object array
    public String getSpecies(){
        return this.species;
    }
    //these methods allow for the private int to be accessible in other classes
    public int getAttack(){
        return attack;
    }
    public int getDefense(){
        return defense;
    }
    public int getSpeed(){
        return speed;
    }
    public void setAttack(int newAttack){
        attack = newAttack;
    }
    //need to evolve more - (not when menu selection is show)
    public void evolve(){
        attack = attack*2;
        defense = defense *4;
        speed = speed*3;
    }
}
