
import java.util.Scanner;
public class RleProgram {
    public static void main(String[] args) {
        int z = 0;
        byte[] imageData = null;
        Scanner input = new Scanner(System.in);
        byte[] loadFile;
        System.out.println("Welcome to the RLE image encoder!");
        System.out.println();
        System.out.println("Displaying Spectrum Image: ");
        ConsoleGfx.displayImage(ConsoleGfx.testRainbow);
        System.out.println();
        System.out.println();
        //named the while, so that when case is 0 (exit), I can exit out of the while loop/whole menu doesnt repeat
        done:
        while (true) {
            //menu options, doesnt correspond with methods
            System.out.println("RLE Menu");
            System.out.println("--------");
            System.out.println("0. Exit");
            System.out.println("1. Load File");
            System.out.println("2. Load Test Image");
            System.out.println("3. Read RLE String");
            System.out.println("4. Read RLE Hex String");
            System.out.println("5. Read Data Hex String");
            System.out.println("6. Display Image");
            System.out.println("7. Display RLE String");
            System.out.println("8. Display Hex RLE Data");
            System.out.println("9. Display Hex Flat Data");
            System.out.println();
            System.out.print("Select a Menu Option: ");
            int option = input.nextInt();
            String filename = "";
            switch (option) {
                case 0:
                    break done;
                    //explained above but I found a way for me to break out of the while loop, not display menu after I exit
                case 1: {
                    System.out.print("Enter name of file to load: ");
                    if (input.hasNextLine()) {
                        filename = input.next();
                    }
                    //based on the other files in this Folder
                    imageData = ConsoleGfx.loadFile(filename);
                    System.out.println();
                    break;
                    //create method to calll these arrays
                    //store return bytes array/store return value into image data array
                }
                case 2: {
                    //if you dont input 2, none of the methods will work/ the no data
                    imageData = (ConsoleGfx.testImage);
                    System.out.println("Test image data loaded.");
                    System.out.println();
                    break;
                }
                case 3: {
                    System.out.print("Enter an RLE string to be decoded: ");
                    String dataRLE = input.next();
                    imageData = decodeRle(stringToRle(dataRLE));
                    //byte[] rledata = stringtoRLE(dataRLE);
                    // int decodedData = getDecodedLength(dataRLE);
                    break;
                }
                case 4: {
                    System.out.print("Enter the hex string holding RLE data: ");
                    String holdingData = input.next();
                    //toHexString(holdingData);
                    imageData = decodeRle(stringToData(holdingData));
                   // System.out.println(Arrays.toString(stringToData(holdingData)));
                    //System.out.println(Arrays.toString(imageData));
                    break;
                }
                case 5: {
                    System.out.print("Enter the hex string holding flat data: ");
                    String enterhexString = input.next();
                    imageData = stringToData(enterhexString);
                    System.out.println();
                    break;
                }
                //in case 6 - 9 need the imageData == null to say if 2 is not inputted no data to go through the methods with
                case 6: {
                    //10 then 6 there is an error
                    System.out.println("Displaying image...");
                    System.out.println();
                    if (imageData == null) {
                        System.out.println("(no data)");
                        break;
                    }
                    ConsoleGfx.displayImage(imageData);
                    break;
                }
                case 7: {
                    //not printing
                    System.out.print("RLE representation: ");
                    if (imageData == null) {
                        System.out.println("(no data)");
                        System.out.println();
                        break;
                    }
                    System.out.println((toRleString(encodeRle(imageData))));
                    break;
                }

                case 8: {
                    System.out.print("RLE hex values: ");
                    if (imageData == null) {
                        System.out.println("(no data)");
                        System.out.println();
                        break;
                    }
                    //System.out.println((encodeRle(imageData)));
                    System.out.println(toHexString(encodeRle(imageData)));
                    break;
                }
                case 9: {
                    System.out.print("Flat hex values: ");
                    if (imageData == null) {
                        System.out.println("(no data)");
                        System.out.println();
                        break;
                    }
                    System.out.println(toHexString(imageData));
                    break;
                }
                default:
                    //if choose a number no 0-9
                    System.out.println("Error! Invalid input.");
                    System.out.println();
                    break;

            }
        }
    }

    //method 1:
    public static String toHexString(byte[] data) {
        //turn numbers 10 and above into letters
        String hexaDecimal = "";
        byte[] hexString = data;
        for (int i = 0; i < hexString.length; i++) {
            if (hexString[i] > 9) {
                hexaDecimal += Integer.toHexString(hexString[i]);
            } else {
                hexaDecimal += String.valueOf(hexString[i]);
            }
        }
        return hexaDecimal;
    }

    //method 2:
    public static int countRuns(byte[] flatData) {
        //counts the number of times it runs through
        int count = 1;
        int group = 1;
        byte[] numRuns = flatData;
        for (int i = 0; i < numRuns.length - 1; i++) {
            if (group > 15) {
                group = 0;
                count++;
                continue;
                // count = 1;
            }
            if (numRuns[i] == numRuns[i + 1]) {
                group++;
                continue;
            } else {
                count++;
            }


        }
        return count;
    }

    //method 3:
    public static byte[] encodeRle(byte[] flatData) {
        //System.out.println(flatData);
        int group = flatData.length - 1;
        int index = 0;
        byte[] newByte = new byte[countRuns(flatData) * 2];
        // byte[] condense = flatData;
        int countofNum = 1;
        for (int i = 0; i < flatData.length - 1; i++) {
            if (i == flatData.length - 2) {
                //countofNum++;
                newByte[index] = (byte) countofNum;
                newByte[index + 1] = flatData[i];
                //break;
            }
            if (flatData[i] == flatData[i + 1]) {
                newByte[index + 1] = flatData[i];
                //countofNum++;
                if (countofNum == 15) {
                    newByte[index] = (byte) countofNum;
                    newByte[index + 1] = flatData[i];
                    index += 2;
                    //group = 1;
                    countofNum = 1;
                    // continue;
                } else {
                    countofNum++;
                }

                /*if (countofNum > 15) {
                    group++;
                    countofNum = 0; */

                //  String returning = countofNum + "" + condense[i];
            } else {
                newByte[index] = (byte) countofNum;
                newByte[index + 1] = flatData[i];
                index += 2;
                countofNum = 1;
                //group++;
            }

        }
        newByte[index] = (byte) countofNum;
        newByte[index + 1] = flatData[group];
        return newByte;
    }

    //method 4:
    public static int getDecodedLength(byte[] rleData) {
        byte[] integerEven = rleData;
        int getInt = 0;
        int generateflatdata = 0;
        for (int i = 0; i < integerEven.length; i++) {
            if (i % 2 == 0) {
                getInt += integerEven[i];
            }
            // generateflatdata += rleData[i];
        }
        return getInt;
    }

    //method 5:
    // turn {3, 15, 6 ,4 } into {15, 15, 15, 4, 4, 4, 4, 4, 4}
    // in main :
    /*byte[] rleData = {3, 15, 6 ,4 };
        rleData = decodeRle(rleData);
        System.out.println(Arrays.toString(rleData)); */

    public static byte[] decodeRle(byte[] rleData) {
        byte lengthOfN = (byte) getDecodedLength(rleData);

        int numOf = 0, k = 0;
        byte baseNum = 0;
        byte[] decompressed = rleData;
        byte[] newData = new byte[lengthOfN];
        for (int i = 0; i < decompressed.length; i++) {
            if (i % 2 == 0) {
                numOf = decompressed[i];
            }
            if (i % 2 != 0) {
                baseNum = decompressed[i];

                for (int j = 0; j < numOf; j++) {
                    newData[k] = baseNum;
                    k++;
                }
            }
        }
        return newData;
    }

    //method 6:
    public static byte[] stringToData(String dataString) {
        //dataString = "3f64";
        int numofIndex = dataString.length();
        byte[] whatReturn = new byte[numofIndex];
        int giveTo = 0;
        for (int i = 0; i < dataString.length(); i++) {
            giveTo = Integer.parseInt(String.valueOf(dataString.charAt(i)), 16);
            //int decimaloutofHex = giveTo;
            //System.out.println(giveTo);
            whatReturn[i] = (byte) giveTo;
            //prints out the numbers in sequence, want to store them in array and return them
        }
        //System.out.println(Arrays.toString(whatReturn));
        return whatReturn;
    }

    //how to test whole program
    //method 7:
    public static String toRleString(byte[] rleData) {
        String hexaDecimal = "";
        //System.out.println(Arrays.toString(rleData));
        // char [] letter = {'a', 'b', 'c', 'd', 'e', 'f'};
        // byte[] hexString = data;
        for (int i = 0; i < rleData.length - 1; i+=2) {
            //if (rleData[i] == letter && rleData[i+1] == )
            hexaDecimal += rleData[i];
            hexaDecimal += Integer.toHexString(rleData[i + 1]);
            //this returns both integers and letters, (0-9) and (a-f for 10-15)
            if (i == rleData.length - 2) {
                break;
            } else {
                hexaDecimal += ":";
            }
        }
        //System.out.println(hexaDecimal);
        return hexaDecimal;
    }

    //method 8:
    public static byte[] stringToRle(String rleString) {
        int valueof = 0;
        int k = 0;
        int valueokay = 0;
      //  String rleString = "15f:64";
//for string have to use .split()
        String[] newrleString = rleString.split(":");
        int length = newrleString.length;
        byte[] returnbyte = new byte[length*2];
        //separates out each string and assigns it into the array
        for (int i = 0; i < length; i++) {
            String q = newrleString[i];
            int height = q.length();
            String array = q.substring(height-1);
            String array1 = q.substring(0 ,height - 1);
            valueof = Integer.parseInt(array1);
            returnbyte[k] = (byte) valueof;
            valueokay = Integer.parseInt(array, 16);
            returnbyte[k + 1] = (byte) (valueokay);
            k += 2;
        }
        // System.out.println(returnbyte);
        return returnbyte;
    }
}








