//Worked with Ilya//

import java.util.Scanner;

public class Hello {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Hello. What is your name? ");
        String name;
        String place;
        String age;
        name = s.next();
        System.out.print("It's nice to meet you, " + name + ". How old are you? ");
        age = s.next();
        System.out.println("I see that you are still quite young at only " + age + ".");
        System.out.print("Where do you live? ");

        place = s.next();
        System.out.print("Wow! I've always wanted to go to " + place + ". Thanks for chatting with me. Bye!");
    }
}
