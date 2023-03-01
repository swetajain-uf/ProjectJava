
import java.util.Scanner;
import java.util.regex.Pattern;

public class NumericConversion {
    //method #1//
    public static long hexStringDecode(String hex) {
        // int hexadecimal = 0;

        int findnum = 0;
        long decimal = 0;
        int exponent = 0;
        //String hexstring = "0123456789ABCDEF";

        hex = hex.replaceFirst("0x", "");
        int length = hex.length();
        Pattern patternInt = Pattern.compile("\\d");
        // defines a matching pattern for integer value "\\d"
        Pattern patternAF = Pattern.compile("[a-f]", Pattern.CASE_INSENSITIVE);
        // defines a matching pattern for value a to f, doesnt matter the case
        for (int i = 0; i < hex.length(); i++) {
            String stri = hex.substring(i, i + 1);
            // goes through each of the characters inside String hex
            boolean hasInt = patternInt.matcher(stri).matches();
            // checks if it is an integer, boolean - true or false
            boolean hasAF = patternAF.matcher(stri).matches();
            // checks if it is between A and F/ Letters A-F - boolean
            if (hasInt == true) {
                findnum = Integer.parseInt(stri);  // convert to integer
                exponent = length - 1;
                decimal += findnum * (Math.pow(16, exponent));
                length--;
            } else if (hasAF == true) {
                // if stri has one or more letters - A and F, convert to integer 10 to 15
                if (stri.equalsIgnoreCase("A")) {
                    findnum = 10;
                } else if (stri.equalsIgnoreCase("B")) {
                    findnum = 11;
                } else if (stri.equalsIgnoreCase("C")) {
                    findnum = 12;
                } else if (stri.equalsIgnoreCase("D")) {
                    findnum = 13;
                } else if (stri.equalsIgnoreCase("E")) {
                    findnum = 14;
                } else if (stri.equalsIgnoreCase("F")) {
                    findnum = 15;
                }
                exponent = length - 1;
                decimal += findnum * (Math.pow(16, exponent));
                length--;
            }
        }
        return decimal;
    }

    public static short hexCharDecode(char hex) {
        String stri = Character.toString(hex);
        int findnum = 0;
        int decimal = 0;
        int exponent = 0;
//wanted to make this into one method, no copying and pasting but had a lot this week so didnt have time//
        Pattern patternInt = Pattern.compile("\\d");
        Pattern patternAF = Pattern.compile("[a-f]", Pattern.CASE_INSENSITIVE);
        boolean hasInt = patternInt.matcher(stri).matches();
        boolean hasAF = patternAF.matcher(stri).matches();
        if (hasInt == true) {
            findnum = Integer.parseInt(stri);  // convert to integer
        }
        else if (hasAF == true) { // if stri is between A and F, then convert to integer 10 to 15
            if (stri.equalsIgnoreCase("A")) {
                findnum = 10;
            }
            else if (stri.equalsIgnoreCase("B")) {
                findnum = 11;
            }
            else if (stri.equalsIgnoreCase("C")) {
                findnum = 12;
            }
            else if (stri.equalsIgnoreCase("D")) {
                findnum = 13;
            }
            else if (stri.equalsIgnoreCase("E")) {
                findnum = 14;
            }
            else if (stri.equalsIgnoreCase("F")) {
                findnum = 15;
            }
        }
        //ignore th case whether they put capital or lowercase//
        decimal = (int) (findnum * (Math.pow(16, exponent)));
        return (short) decimal;
    }





    public static short binaryStringDecode(String binary) {
        String fullBinary = "";
        int decimal = 0;

        int exponent = 0;
        int num;

       /* int rid0b = fullBinary.indexOf("0bx");
        //int num = 0;
        if (rid0b == -1) {
            fullBinary = binary;
        }*/
        binary =binary.replaceFirst("0b","");
        //int length = binary.length();
        int find=0;
        for (int i = binary.length(); i>0; i--) {
            exponent = i - 1;
            num = Character.getNumericValue(binary.charAt(find));
            find++;
            //System.out.println(binary.charAt(exponent));
            //int num = Character.getNumericValue(binary.charAt(length-1));
            decimal += (int) (num * (Math.pow(2, exponent)));

        }
        return (short) decimal;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String binary;
        int option;
        String number;
        while (true) {
            System.out.println("Decoding Menu");
            System.out.println("-------------");
            System.out.println("1. Decode hexadecimal");
            System.out.println("2. Decode binary");
            System.out.println("3. Convert binary to hexadecimal");
            System.out.println("4. Quit");

            System.out.print("Please enter an option: " );
            option = input.nextInt();

            /*System.out.print("Please enter the numeric string to convert: ");
            number = input.next();
            System.out.print("Result: ");
            */
            switch (option) {
                case 1: {
                    System.out.print("Please enter the numeric string to convert: ");
                    number = input.next();
                    System.out.print("Result: ");
                    int decimal = (int) hexStringDecode(number);
                    // hexStringDecode(number);
                    System.out.println(decimal);

                    break;
                }
                case 2: {
                    System.out.print("Please enter the numeric string to convert: ");
                    number = input.next();
                    System.out.print("Result: ");
                    int decimal = binaryStringDecode(number);
                    System.out.println(decimal);
                    break;
                }
                case 3: {
                    break;
                }
                case 4: {
                    System.out.println("Goodbye!");
                    return;
                }
            }
        }
    }

} /*



           /* int firstNum = binary.charAt(0);
            firstNum = (firstNum*Math.pow(2,binary.charAt(0));
            int secondNum = binary.charAt(1);
            secondNum = (secondNum*(Math.pow(2,binary.charAt(0)));
            int thirdNum = binary.charAt(2); */





//  import java.text.StringCharacterIterator;
/*import java.util.Scanner;
import java.util.regex.Pattern;

public class NumericConversion {


    public static long hexStringDecode(String hex) {
        // int hexadecimal = 0;
        int length = hex.length();
        int findnum = 0;
        int decimal = 0;
        int exponent = 0;
        //String hexstring = "0123456789ABCDEF";


        hex = hex.replaceFirst("0x", "");
        Pattern patternInt = Pattern.compile("\\d");  // defines a matching pattern for integer value
        Pattern patternAF = Pattern.compile("[a-f]", Pattern.CASE_INSENSITIVE);  // defines a matching pattern for value a to f
        for (int i = 0; i < hex.length(); i++) {
            String stri = hex.substring(i,i+1); // going through each character inside the string
            boolean hasInt = patternInt.matcher(stri).matches(); // checks if it is an integer
            boolean hasAF = patternAF.matcher(stri).matches(); // checks if it is between A and F
            if (hasInt==true){
                findnum = Integer.parseInt(stri);  // convert to integer
                exponent = length - 1;
                decimal += findnum * (Math.pow(16, exponent));
                length--;
            }
            else if(hasAF == true) { // if stri is between A and F, then convert to integer 10 to 15
                if (stri.equalsIgnoreCase("A")) {
                    findnum = 10;
                } else if (stri.equalsIgnoreCase("B")) {
                    findnum = 11;
                } else if (stri.equalsIgnoreCase("C")) {
                    findnum = 12;
                } else if (stri.equalsIgnoreCase("D")) {
                    findnum = 13;
                } else if (stri.equalsIgnoreCase("E")) {
                    findnum = 14;
                } else if (stri.equalsIgnoreCase("F")) {
                    findnum = 15;
                }
                exponent = length - 1;
                decimal += findnum * (Math.pow(16, exponent));
                length--;
            }

        }
        return decimal;
    }

    public static short hexCharDecode(char hex){
        String s = Character.toString(hex);
        //int length = hex.length();
        int findnum = 0;
        int decimal = 0;
        int exponent = 0;
        Pattern patternInt = null;
        boolean hasInt; // checks if it is an integer
        String soclose = Character.toString(hex);
        if (patternInt.matcher(s).matches()) {
            hasInt = true;
        }
        else hasInt = false;
        Pattern patternAF = null;
        boolean hasAF = patternAF.matcher(soclose).matches(); // checks if it is between A and F
        if (hasInt==true) {
            findnum = Integer.parseInt(s);  // convert to integer
            //exponent = length - 1;
            //decimal += findnum * (Math.pow(16, exponent));
            //length--;
        }
        else if(hasAF == true) { // if stri is between A and F, then convert to integer 10 to 15
            if (soclose.equalsIgnoreCase("A")) {
                findnum = 10;
            } else if (soclose.equalsIgnoreCase("B")) {
                findnum = 11;
            }
            if (soclose.equalsIgnoreCase("C")) {
                findnum = 12;
            }

            if (soclose.equalsIgnoreCase("D")) {
                findnum = 13;
            }
            if (soclose.equalsIgnoreCase("E")) {
                findnum = 14;
            }
            if (soclose.equalsIgnoreCase("F")) {

                findnum = 15;
            }
            int.toString(findnum);
            hexStringDecode(String.valueOf(findnum));
        }

    return (short) hex;}


    public static short binaryStringDecode(String binary) {
        String fullBinary = "";
        int decimal = 0;

        int exponent = 0;
        int num;

       /* int rid0b = fullBinary.indexOf("0bx");
        //int num = 0;
        if (rid0b == -1) {
            fullBinary = binary;
        }*/
     /*   binary =binary.replaceFirst("0bx","");
        //int length = binary.length();
        int find=0;
        for (int i = binary.length(); i>=0; i--) {
            exponent = i - 1;
            num = Character.getNumericValue(binary.charAt(find));
            find++;
            //System.out.println(binary.charAt(exponent));
            //int num = Character.getNumericValue(binary.charAt(length-1));
            decimal += (int) (num * (Math.pow(2, exponent)));

        }
        return (short) decimal;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String binary;
        int num1 = 0;
        int option;
        String number;

        while (num1 !=0){
        System.out.println("Decoding Menu");
        System.out.println("-------------");
        System.out.println("1. Decode hexadecimal");
        System.out.println("2. Decode binary");
        System.out.println("3. Convert binary to hexadecimal");
        System.out.println("4. Quit");

        System.out.print("Please enter an option: ");
        option = input.nextInt();

        System.out.print("Please enter numeric string to convert: ");
        System.out.println("Result: ");
        number = input.next();
        switch (option) {
            case 1: {
                int decimal = (int) hexStringDecode(number);
                // hexStringDecode(number);
                System.out.println(decimal);
                System.out.println(binaryStringDecode(number));
                break;
            }
            case 2: {
                int decimal = binaryStringDecode(number);
                System.out.println(decimal);
                System.out.println(binaryStringDecode(number));
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                System.out.println("Goodbye!");
                break;

            }

            // int decimal = binaryStringDecode((String).input);

            //System.out.println(binaryStringDecode(number));
        }

        }
    }}





/*import java.util.Scanner;
import java.util.regex.Pattern;

public class NumericConversion {
    /*public static long binaryStringDecode(String binary){
    //hexStringDecode (String hex){
        //String num = "001";
        String num ="";

        char please = num.charAt(num.length());
        System.out.println(please);
return please;
    } */


    /*public static void main(String[] args) {
        System.out.println(("001"));
        String num ="001";

        char please = num.charAt();
        System.out.println( please);
        System.out.println(num.length());
    }

    public static long hexStringDecode(String hex) {
        // int hexadecimal = 0;
        int length = hex.length();
        int findnum = 0;
        int decimal = 0;
        int exponent = 0;
        //String hexstring = "0123456789ABCDEF";

        hex = hex.replaceFirst("0x", "");
        Pattern patternInt = Pattern.compile("\\d");  // defines a matching pattern for integer value
        Pattern patternAF = Pattern.compile("[a-f]", Pattern.CASE_INSENSITIVE);  // defines a matching pattern for value a to f
        for (int i = 0; i < hex.length(); i++) {

            exponent = length - 1;
            decimal += findnum * (Math.pow(16, exponent));
            length--;
        } return decimal;
    }
          /*  if (stri.equalsIgnoreCase("A")) {
                findnum = 10;
            } else if (stri.equalsIgnoreCase("B")) {
                findnum = 11;
            } else if (stri.equalsIgnoreCase("C")) {
                findnum = 12;
            } else if (stri.equalsIgnoreCase("D")) {
                findnum = 13;
            } else if (stri.equalsIgnoreCase("E")) {
                findnum = 14;
            } else if (stri.equalsIgnoreCase("F")) {
                findnum = 15;
            } */
        
           /* String stri = hex.substring(i,i+1); // going through each character inside the string
            boolean hasInt = patternInt.matcher(stri).matches(); // checks if it is an integer
            boolean hasAF = patternAF.matcher(stri).matches(); // checks if it is between A and F
            if (hasInt==true){
                findnum = Integer.parseInt(stri);  // convert to integer
                exponent = length - 1;
                decimal += findnum * (Math.pow(16, exponent));
                length--;
            }
            else if(hasAF == true) { // if stri is between A and F, then convert to integer 10 to 15
                if (stri.equalsIgnoreCase("A")) {
                    findnum = 10;
                } else if (stri.equalsIgnoreCase("B")) {
                    findnum = 11;
                } else if (stri.equalsIgnoreCase("C")) {
                    findnum = 12;
                } else if (stri.equalsIgnoreCase("D")) {
                    findnum = 13;
                } else if (stri.equalsIgnoreCase("E")) {
                    findnum = 14;
                } else if (stri.equalsIgnoreCase("F")) {
                    findnum = 15;
                }
                exponent = length - 1;
                decimal += findnum * (Math.pow(16, exponent));
                length--;
            }
            else { // if stri is not hex, then return 0
                System.out.println("Incorrect character was input" + stri);
                return 0;



    public static short hexCharDecode(char hex){
        String s = String.valueOf(hex);
        //boolean letter = Character.isLetter(hex);
       if
        for (int i=0; i <8;i++ ){
            if (String.contains("a")); {
                String a = Integer.parseInt(a);

            }
        }
           if (hex.isLetter("a")) {
                int a = Integer.parseInt(String.valueOf(10));
            }
        if (hex.matches("[b]")) {
        int b = Integer.parseInt(String.valueOf(11));
        }
        if (hex.matches("[c]")) {
        int c = Integer.parseInt(String.valueOf(12));
        }
        if (hex.matches("[d]")) {
        int d = Integer.parseInt(String.valueOf(13));
        }
        if (hex.matches("[e]")) {
        int e = Integer.parseInt(String.valueOf(14));
        }
        if (hex.matches("[f]")) {
        int f = Integer.parseInt(String.valueOf(15));
        }
        }
        // String hex = "hex";
        //int aA = Integer.parseInt(hex,16);
        //System.out.println(aA);
        short df = 4321;

       /* if (hex == 0 || hex == 1 ||hex == 2 || hex == 3 || hex == 4 || hex == 5 || hex == 6 || hex == 7 || hex == 8||hex == 9 ) {
        }
        else if (hex.equals("a")) {
            int aA = Integer.parseInt(hex, 16);

        return df;
    }


    public static short binaryStringDecode(String binary) {
        String fullBinary = "";
        int decimal = 0;

        int exponent = 0;
        int num;

       /* int rid0b = fullBinary.indexOf("0bx");
        //int num = 0;
        if (rid0b == -1) {
            fullBinary = binary;
        }
        /*binary =binary.replaceFirst("0bx","");
        //int length = binary.length();
        int find=0;
        for (int i = binary.length(); i>=0; i--) {
            exponent = i - 1;
            num = Character.getNumericValue(binary.charAt(find));
            find++;
            //System.out.println(binary.charAt(exponent));
            //int num = Character.getNumericValue(binary.charAt(length-1));
            decimal += (int) (num * (Math.pow(2, exponent)));

        }
        return (short) decimal;
    } */
/*

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String binary;
        int option;
        String number;
        System.out.println("Decoding Menu");
        System.out.println("-------------");
        System.out.println("1. Decode hexadecimal");
        System.out.println("2. Decode binary");
        System.out.println("3. Convert binary to hexadecimal");
        System.out.println("4. Quit");

        System.out.print("Please enter option: ");
        option = input.nextInt();

        System.out.print("Please enter numeric string to convert: ");
        number = input.next();
        switch (option) {
            case 1: {
                int decimal = (int) hexStringDecode(number);
                // hexStringDecode(number);
                System.out.println(decimal);
                break;
            }
            case 2: {
                int decimal = binaryStringDecode(number);
                System.out.println(decimal);
                break;
            }
            case 3: {
            }
            case 4: {
            }

            // int decimal = binaryStringDecode((String).input);

            System.out.println(binaryStringDecode(number));

        }
    }}
 /*public stat  ic long binaryStringDecode(String binary){
    //hexStringDecode (String hex){
        //String num = "001";
        String num ="";

        char please = num.charAt(num.length());
        System.out.println(please);
return please;
    } */


    /*public static void main(String[] args) {
        System.out.println(("001"));
        String num ="001";

        char please = num.charAt();
        System.out.println( please);
        System.out.println(num.length());
    }*/







/*import java.util.Scanner;
import java.util.regex.Pattern;

public class NumericConversion {
    /*public static long binaryStringDecode(String binary){
    //hexStringDecode (String hex){
        //String num = "001";
        String num ="";

        char please = num.charAt(num.length());
        System.out.println(please);
return please;
    } */


    /*public static void main(String[] args) {
        System.out.println(("001"));
        String num ="001";

        char please = num.charAt();
        System.out.println( please);
        System.out.println(num.length());
    }*/

   /* public static long hexStringDecode(String hex) {
        // int hexadecimal = 0;
        int length = hex.length();
        int findnum = 0;
        int decimal = 0;
        int exponent = 0;
        String hexstring = "0123456789ABCDEF";

        hex = hex.replaceFirst("0x", "");
        //long.toHexString();

        //Pattern pattern = Pattern.compile("\\d");
        for (int i = 0; i < hex.length(); i++) {
           char hexi =  hex.charAt(i);
          // boolean hasInt = pattern.matcher(hexi).matches();
          // if (hasInt==true){
               // if (hexi.equals("0") || hexi.equals("1") || hexi.equals("2") || hexi.equals("3") || hexi.equals("4") || hexi.equals("5") || hexi.equals("6") || hexi.equals("7") || hexi.equals("8") || hexi.equals("9")) {
                findnum = Character.getNumericValue(hexi);
                exponent = length - 1;
                decimal += findnum * (Math.pow(16, exponent));
                length--;
            //want to make a,b,c,d,e,f equal to a value and then they just are input in for loop//getNumericValue wont work because letters dont have a numeric value//
            //this method will be for letters and then just input this in method above   
            }


        }
        return decimal;

        // else if ()) {

        //    int num = hexstring.indexOf()
    }




    public static short hexCharDecode(char hex){
       String hex = "hex";
       //want to make a,b,c,d,e,f equal to a value and then they just are input in for loop//getNumericValue wont work because letters dont have a numeric value//
        //this method will be for letters and then just input this in method above
       int aA = Integer.parseInt(hex,16);
        System.out.println(aA);
        short df = 4321;

       /* if (hex == 0 || hex == 1 ||hex == 2 || hex == 3 || hex == 4 || hex == 5 || hex == 6 || hex == 7 || hex == 8||hex == 9 ) {
        }
        else if (hex.equals("a")) {
            int aA = Integer.parseInt(hex, 16); */

       /* return df;
        }






    public static short binaryStringDecode(String binary) {
        String fullBinary = "";
        int decimal = 0;

        int exponent = 0;
        int num;

       /* int rid0b = fullBinary.indexOf("0bx");
        //int num = 0;
        if (rid0b == -1) {
            fullBinary = binary;
        }*/
    /*    binary =binary.replaceFirst("0bx","");
        //int length = binary.length();
        int find=0;
        for (int i = binary.length(); i>=0; i--) {
            exponent = i - 1;
             num = Character.getNumericValue(binary.charAt(find));
            find++;
            //System.out.println(binary.charAt(exponent));
            //int num = Character.getNumericValue(binary.charAt(length-1));
            decimal += (int) (num * (Math.pow(2, exponent)));

        }
        return (short) decimal;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String binary;
        int option;
        String number;
        System.out.println("Decoding Menu");
        System.out.println("-------------");
        System.out.println("1. Decode hexadecimal");
        System.out.println("2. Decode binary");
        System.out.println("3. Convert binary to hexadecimal");
        System.out.println("4. Quit");

        System.out.print("Please enter option: " );
        option = input.nextInt();

        System.out.print("Please enter numeric string to convert: ");
        number = input.next();
        switch (option) {
            case 1: {
                int decimal = (int) hexStringDecode(number);
                // hexStringDecode(number);
                System.out.println(decimal);
            }
            case 2: {
                int decimal = binaryStringDecode(number);
                System.out.println(decimal);
            }
            case 3: {
            }
            case 4: {
            }

            // int decimal = binaryStringDecode((String).input);

            System.out.println(binaryStringDecode(number));

        }*/ /*
    }
}



           /* int firstNum = binary.charAt(0);
            firstNum = (firstNum*Math.pow(2,binary.charAt(0));
            int secondNum = binary.charAt(1);
            secondNum = (secondNum*(Math.pow(2,binary.charAt(0)));
            int thirdNum = binary.charAt(2); */






