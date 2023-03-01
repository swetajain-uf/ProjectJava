import java.util.Arrays;

public class TestPage {
    public static void main(String[] args) {
        int valueof =0;
        int k =0;
        int valueokay =0;
        String rleString = "15f:64";
        byte[] returnbyte = new byte[rleString.length()];
        String [] newrleString = rleString.split(":");
        System.out.println(newrleString.length);
        System.out.println(newrleString);
        System.out.println(rleString.length());
        for (int i = 0; i < newrleString.length - 1; i += 2) {
            String q = newrleString[i];
            String array = q.substring(i);
            String array1 = q.substring(0, q.length()-1);
            valueof = Integer.parseInt(array1);
            returnbyte[k] = (byte)valueof;
            valueokay = Integer.parseInt(array, 16);
            returnbyte[k+1] = (byte)(valueof);
            k += 2;
        }
        System.out.println(returnbyte);
    }
}
        /*String rleString = "1e:16:2d:3a:6d:2a:2d:1a:1f:10:7a:12:15a:1d:9a:30:1a:1d:3a:60:3a:3d:8a:5d"; //72
        String newrleString = "";
      // for (int i = 0; i < rleString.length() - 1; i=+2) {
        newrleString = rleString.replace(":", "");
        System.out.println(newrleString);
returnbyte[i] = Integer.parseInt(newrleString.substring(newrleString.length - 1));
        System.out.println(returnbyte);*/
       // }
      /*  byte[] hello = new byte[]{15, 15, 15, 4, 4, 4, 4, 4, 4};
        System.out.println(Arrays.toString(encodeRle(hello)));

    }

    /*String dataString = "3f64";
    byte [] newByte = new byte[dataString.length()];
    newByte = stringToData(dataString);
    System.out.println(Arrays.toString(newByte));
    public static int countRuns(byte[] flatData) {
        int count = 1;
        byte[] numRuns = flatData;
        for (int i = 0; i < numRuns.length - 1; i++) {
            if (numRuns[i] == numRuns[i + 1]) {
                continue;
            } else {
                count++;
            }

        }
        return count;
    }

    public static byte[] encodeRle(byte[] flatData) {
        int group = 1;
        int index = 0;
        byte[] newByte = new byte[countRuns(flatData) * 2];
        // byte[] condense = flatData;
        int countofNum = 1;
        for (int i = 0; i < flatData.length -1; i++) {
            if (i == flatData.length - 1) {
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
                    group = 1;
                    countofNum = 1;
                    // continue;
                } else {
                    countofNum++;
                }

                if (countofNum > 15) {
                    group++;
                    countofNum = 0;

                //  String returning = countofNum + "" + condense[i];
            } else {
               newByte[index] = (byte) countofNum;
                newByte[index + 1] = flatData[i];
                index += 2;
                countofNum = 1;
                group++;
            }
        }
        newByte[index] = (byte) countofNum;
        return newByte;
    }
}


    /*public static byte[] encodeRle(byte[] flatData) {
        int group = 1;
        byte[] newByte = new byte[countRuns(flatData) * 2];
        byte[] condense = flatData;
        int countofNum = 1;
        for (int i = 0; i < condense.length - 1; i++) {
            if (condense[i] == condense[i + 1]) {
                countofNum++;
                //  String returning = countofNum + "" + condense[i];
            } else {
                newByte[i-2] = (byte) countofNum;
                newByte[i-1] = condense[i];
                countofNum = 1;
                group++;
            }
            if (countofNum >= 15) {
                group++;
                countofNum = 1;
            }
        }
        return newByte;
    }
}

        /*byte[] rleData = {3, 15, 6 ,4 };
        rleData = decodeRle(rleData);
        System.out.println(Arrays.toString(rleData));
    }
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



   /* public static byte[] stringToData(String dataString) {
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
        return whatReturn; */


    /*public static byte[] decodeRle(byte[] rleData) {
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
}

      /* byte [] answer = stringToData("3f64");
        System.out.println(answer);
    }
    public static byte[] stringToData(String dataString) {
        //dataString = "3f64";
        int numofIndex = dataString.length();
        byte[] whatReturn = new byte[numofIndex + 1];
        int giveTo = 0;
        for (int i = 0; i < dataString.length(); i++) {
            giveTo = Integer.parseInt(String.valueOf(dataString.charAt(i)), 16);
            //int decimaloutofHex = giveTo;
            //System.out.println(giveTo);
            whatReturn[i] = (byte) giveTo;
           // System.out.println(whatReturn[i]); //prints out the numbers in sequence, want to store them in array and return them
        }
        return whatReturn;
    }
}


        /*String dataString = "3f64";
        int numofIndex = dataString.length();
        byte[] whatReturn = new byte[numofIndex+1];
        int giveTo = 0;
        for (int i = 0; i < dataString.length(); i++) {
            giveTo = Integer.parseInt(String.valueOf(dataString.charAt(i)), 16);
            //int decimaloutofHex = giveTo;
            //System.out.println(giveTo);
            whatReturn[i] = (byte) giveTo;
            System.out.println(whatReturn[i]);
        }

    }
}
    /*public static byte[] stringToData(String dataString) {
       // String dataString = "3f64";
        int numofIndex = dataString.length();
        byte[] whatReturn = new byte[numofIndex];
        byte giveTo = 0;
        for (int i = 0; i < dataString.length(); i++) {
            giveTo = Byte.parseByte(String.valueOf(dataString.charAt(i)), 16);
            whatReturn[i] = giveTo;
        }
        return whatReturn;
    }
}




        /*byte[] testing = {3, 15, 6, 4};
        int returnAns = getDecodedLength(testing);
        System.out.println(returnAns);
    }


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
}


        /*String returning = "";
        int group = 1;
        byte[] condense = {15, 15, 15, 4, 4, 4, 4, 4, 4};
        int countofNum = 1;
        for (int i = 0; i < condense.length -1; i++) {

            if (condense[i] == condense[i + 1]) {
                countofNum++;

            }
            else {
                //returning = countofNum + " " + condense[i];
                countofNum = 1;
            }

            if (countofNum >= 15) {
                group++;
                countofNum = 1;
            }
    }
    }
}
        /*byte [] flatData = {15, 15, 15, 4, 4, 4, 4, 4, 4};
        int count = 1;
        byte[] numRuns = flatData;
        for (int i =0;  i < numRuns.length; i++) {
            if (numRuns[i] == numRuns[i + 1]) {
                continue;
            } else {
                count++;
            }
            System.out.println(count);
        }
    }
}


        /*byte[] hexString = {3, 15, 6, 4};
        for (int i = 0; i < hexString.length; i++) {
            if (hexString[i] > 9) {
                System.out.println(Integer.toHexString(hexString[i]));
            }
            else {
                System.out.println(hexString[i]);
            }
        }
    }
}*/