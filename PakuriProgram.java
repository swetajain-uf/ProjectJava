//Sweta Jain
//Project 3
//Professor Rodriguez

import java.util.Scanner;

public class PakuriProgram {
    public static void main(String[] args) {
        boolean stayIn = true;
        String maxCapacity = " ";
        Pakudex insert = new Pakudex();
        int count = 0;
        int getNum = 0;
        int menuNum = 0;
        Scanner userInput = new Scanner(System.in);
        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");
        //initially always goes in, but if the maxCapacity is not an in, loops back in "starts over"
        while (stayIn == true) {
            System.out.print("Enter max capacity of the Pakudex: ");
            try {
                //Integer.parseInt makes String into Int
                maxCapacity = userInput.next();
                getNum = Integer.parseInt(maxCapacity);
                //positive number/realistic
                if (getNum>0) {
                    insert = new Pakudex(getNum);
                    System.out.println("The Pakudex can hold " + getNum + " species of Pakuri.");
                    stayIn = false;
                }
                //if negative number
                else{
                    stayIn = true;
                    System.out.println("Please enter a valid size.");
                    continue;
                }
            }
            //if not an integer, if string
            catch (NumberFormatException e) {
                //this is for the exception - if it is a NumberFormatException
                System.out.println("Please enter a valid size.");
                //to go back to beginning of while loop
                 continue;
            }
        }
            while (stayIn == false) {
                System.out.println();
                System.out.println("Pakudex Main Menu");
                System.out.println("-----------------");
                System.out.println("1. List Pakuri");
                System.out.println("2. Show Pakuri");
                System.out.println("3. Add Pakuri");
                System.out.println("4. Evolve Pakuri");
                System.out.println("5. Sort Pakuri");
                System.out.println("6. Exit");
                System.out.println();
                System.out.print("What would you like to do? ");
                //input is integer - do inside try
                try {
                    String menuOption = userInput.next();
                    menuNum = Integer.parseInt(menuOption);
                }
                //catch if not an integer (catch is for exceptions) - String
                catch (NumberFormatException e){
                    System.out.println("Unrecognized menu selection!");
                    continue;
                    //go back to menu options
                }
                switch (menuNum) {
                    case 1:
                        //is Pakuri empty? No then -
                        if (count >= 1) {
                            System.out.println("Pakuri In Pakudex:");
                            //getSpecies returns Pakuri array
                            String[] nosey = insert.getSpeciesArray();
                            for (int i = 0; i < nosey.length; i++) {
                                if (nosey != null) {
                                    //print the all Pakuri in a list format
                                    System.out.println((i + 1) + ". " + nosey[i]);
                                }
                                else {
                                    System.out.println("No Pakuri in Pakudex yet");
                                }
                            }
                            break;

                        }
                        //if Pakuri is empty
                        else {
                            System.out.println("No Pakuri in Pakudex yet!");
                            break;
                        }
                    case 2: {
                        //if Pakudex is not empty
                        System.out.print("Enter the name of the species to display: ");
                        String showInfo = userInput.next();
                        // method checks to see if Pakuri array contains showInfo
                        int[] answer = insert.getStats(showInfo);
                        //if it does then -
                        if (answer != null) {
                            System.out.println();
                            System.out.println("Species: " + showInfo);
                            System.out.println("Attack: " + answer[0]);
                            System.out.println("Defense: " + answer[1]);
                            System.out.println("Speed: " + answer[2]);
                            break;
                        }
                        //showInfo isnt in Pakuri array
                        else {
                            System.out.println("Error: No such Pakuri!");
                            break;
                        }
                    }
                    case 3: {
                        //if the Pakuri array is not full
                        //getNum is capacity input
                        //count is how many Pakuri's are added/in array
                        if (count < getNum) {
                            System.out.print("Enter the name of the species to add: ");
                            String name = userInput.next();
                            boolean wonder = insert.addPakuri(name);
                            if (wonder == true) {
                                System.out.println("Pakuri species " + name + " successfully added!");
                            }
                            //addPakuri returns false if species (inputed) is already in array
                            if (wonder == false) {
                                System.out.println("Error: Pakudex already contains this species!");
                            }
                            count++;
                            break;
                        }
                        //count >= getNum -
                        else {
                            System.out.println("Error: Pakudex is full!");
                            break;
                        }
                    }
                    case 4: {
                        //if pakudex is empty -
                        if (insert.getSpeciesArray() == null){
                            System.out.println("Error: No such Pakuri!");
                            break;
                        }
                        else {
                            System.out.print("Enter the name of the species to evolve: ");
                            String evolveNam = userInput.next();
                            boolean returnEvolve = insert.evolveSpecies(evolveNam);
                                if (returnEvolve == true) {
                                    System.out.println(evolveNam + " has evolved!");
                                    break;
                                }
                                //evolveNam is not in Pakuri array, cannot evolve -
                                else if (returnEvolve == false) {
                                    System.out.println("Error: No such Pakuri!");
                                    break;
                                }
                            }
                        }
                    case 5: {
                        insert.sortPakuri();
                        System.out.println("Pakuri have been sorted!");
                        break;
                    }
                    case 6: {
                        System.out.println("Thanks for using Pakudex! Bye!");
                        //so it doesnt loop back into menu while loop
                        stayIn = true;
                        break;
                    }
                    default:
                        System.out.println("Unrecognized menu selection!");
                        //loops back into menu while loop
                        stayIn = false;
                        break;
                }
            }
        }
    }
