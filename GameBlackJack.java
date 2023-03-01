import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class GameBlackjack {
    public static void main(String[] args) {
        int playerhand;
        int numoftimesplayed = 1;
        int dealerwins = 0;
        int numofties = 0;
        int playerwins = 0;
        int selection;
       // numoftimesplayed++;
        P1Random rng = new P1Random();
        Scanner input = new Scanner(System.in);
        newGame:
        while (true) {
            System.out.println("START GAME #" + numoftimesplayed);
            numoftimesplayed++;

            System.out.println();
            int newcard = rng.nextInt(13) + 1;
            //playerhand = newcard;
            if (newcard == 1) {
                System.out.println("Your card is a ACE!");
                System.out.println("Your hand is: " + newcard);
                System.out.println();
            } else if (newcard == 2 || newcard == 3 || newcard == 4 || newcard == 5 || newcard == 6 || newcard == 7 || newcard == 8) {
                System.out.println("Your card is a " + newcard + "!");
                System.out.println("Your hand is: " + newcard);
                System.out.println();
            } else if (newcard == 11) {
                System.out.println("Your card is a JACK!");
                //numoftimesplayed += 1;//
                newcard = 10;
                System.out.println("Your hand is: " + newcard);
                System.out.println();
            } else if (newcard == 12) {
                System.out.println("Your card is a QUEEN!");
                newcard = 10;
                //numoftimesplayed += 1;//
                System.out.println("Your hand is: " + newcard);
                System.out.println();
            } else if (newcard == 13) {
                System.out.println("Your card is a KING!");
                //numoftimesplayed += 1;
                newcard = 10;
                System.out.println("Your hand is: " + newcard);
                System.out.println();
            }
            playerhand = newcard;

            //after dealer/player has won it has to go to the beginning, break out of this while but go to the one above//
            Second:
            while (true) {
                System.out.println("1. Get another card");
                System.out.println("2. Hold hand");
                System.out.println("3. Print statistics");
                System.out.println("4. Exit");
                System.out.println();
                System.out.print("Choose an option: ");

               // Scanner input = new Scanner(System.in);
                selection = input.nextInt();
                switch (selection) {
                    case 1: {
                        //System.out.println(numofsel1);
                        //System.out.println("case1 "+playerhand);
                        newcard = rng.nextInt(13) + 1;
                        /*if (newcard>10){
                             if (newcard == 11) {
                                System.out.println("Your card is a JACK!");
                                //numoftimesplayed += 1;//
                                newcard = 10;

                            } else if (newcard == 12) {
                                System.out.println("Your card is a QUEEN!");
                                newcard = 10;
                                //numoftimesplayed += 1;

                            } else if (newcard == 13) {
                                System.out.println("Your card is a KING!");
                                newcard = 10; */

                        //System.out.println("case1="+ newcard);
                        //System.out.println("case11="+playerhand);
                        //playerhand += newcard;
                        //System.out.println(playerhand + "!!!!");
                        if (newcard == 1) {
                            System.out.println("Your card is a ACE!");
                            //numoftimesplayed += 1;

                        } else if (newcard == 2 || newcard == 3 || newcard == 4 || newcard == 5 || newcard == 6 || newcard == 7 || newcard == 8) {
                            System.out.println("Your card is a " + newcard + "!");
                        } else if (newcard > 10) {
                            if (newcard == 11) {
                                System.out.println("Your card is a JACK!");
                                //numoftimesplayed += 1;//
                                newcard = 10;

                            } else if (newcard == 12) {
                                System.out.println("Your card is a QUEEN!");
                                newcard = 10;
                                //numoftimesplayed += 1;

                            } else if (newcard == 13) {
                                System.out.println("Your card is a KING!");
                                newcard = 10;
                            }
                        }
                        //numoftimesplayed += 1;
                        /*else if (newcard == 11) {
                            System.out.println("Your card is a JACK!");
                            //numoftimesplayed += 1;//
                            newcard += 10;

                        } else if (newcard == 12) {
                            System.out.println("Your card is a QUEEN!");
                            newcard = 10;
                            //numoftimesplayed += 1;

                        } else if (newcard == 13) {
                            System.out.println("Your card is a KING!");
                            newcard = 10;
                        } */
                        /*playerhand += newcard;
                        System.out.println(playerhand); */
                        /*System.out.println(newcard);
                        System.out.println(playerhand); */
                        playerhand += newcard;
                        System.out.println("Your hand is: " + playerhand);
                        /*System.out.println(newcard);
                        System.out.println(playerhand); */
                        System.out.println();
                        if (playerhand == 21) {
                            System.out.println("BLACKJACK! You win!");
                            playerwins += 1;
                            System.out.println();
                            break Second;
                        } else if (playerhand > 21) {
                            System.out.println("You exceeded 21! You lose.");
                            dealerwins ++;
                            System.out.println();
                            break Second;
                        }
                        break;
                    }

                    case 2: {
                        int dfirstcard = rng.nextInt(11) + 16;
                        System.out.println("Dealer's hand: " + dfirstcard);
                        System.out.println("Your hand is: " + playerhand);
                        System.out.println();
                        if (playerhand == dfirstcard) {
                            System.out.println("It's a tie! No one wins!");
                            System.out.println();
                            numofties += 1;
                            break Second;
                        } else if (playerhand > dfirstcard || dfirstcard > 21) {
                            System.out.println("You win!");
                            playerwins += 1;
                            System.out.println();
                            break Second;
                        } else if (dfirstcard > playerhand && dfirstcard < 22) {
                            System.out.println("Dealer wins!");
                            System.out.println();
                            dealerwins ++;
                            break Second;
                        }
                        break;
                    }
                    case 3: {
                        System.out.println("Number of Player wins: " + playerwins);
                        System.out.println("Number of Dealer wins: " + dealerwins);
                        System.out.println("Number of tie games: " + numofties);
                        int avnumtp = numoftimesplayed-2;
                        System.out.println("Total # of games played is: " + avnumtp);
                        double stats = Math.round(((double) playerwins / (avnumtp))*100.0);
                        /*double percentage = (stats * 100.0); */
                        //DecimalFormat oneplace = new DecimalFormat("#.#");
                        System.out.println("Percentage of Player wins: " + stats + "%");
                        System.out.println();
                        break;
                    }
                    case 4: {
                        return;
                    }
                    default: {
                        System.out.println("Invalid input! Please enter an integer value between 1 and 4.");
                        System.out.println();
                    }
                }
            }
        }
    }
}

/*if (selection <0 || selection > 4){
        break;
        }*/

 /*if (newcard == 1) {
                        System.out.println("Your card is a ACE!");
                        numoftimesplayed += 1;
                        System.out.println("Your hand is: " + newcard);
                        System.out.println();
                    } else if (newcard == 2 || newcard == 3 || newcard == 4 || newcard == 5 || newcard == 6 || newcard == 7 || newcard == 8) {
                        System.out.println("Your card is a " + newcard +"!");
                        numoftimesplayed += 1;
                        System.out.println("Your hand is: " + newcard);
                        System.out.println();
                    } else if (newcard == 11) {
                        System.out.println("Your card is a JACK!");
                        numoftimesplayed += 1;
                        newcard = 10;
                        System.out.println("Your hand is: " + newcard);
                        System.out.println();
                    } else if (newcard == 12) {
                        System.out.println("Your card is a QUEEN!");
                        newcard = 10;
                        numoftimesplayed += 1;
                        System.out.println("Your hand is: " + newcard);
                        System.out.println();
                    } else if (newcard == 13) {
                        System.out.println("Your card is a KING!");
                        numoftimesplayed += 1;
                        newcard = 10;
                        System.out.println("Your hand is: " + newcard);
                        System.out.println();
                    }
                    /*System.out.println("Your card is a " + secondcard +"!");
                    System.out.println("Your hand is: " + (newcard + secondcard)); */
