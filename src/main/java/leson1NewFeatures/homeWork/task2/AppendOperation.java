package leson1NewFeatures.homeWork.task2;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppendOperation {

    public static void append(String fileName) throws IOException {


        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        FileWriter fr = new FileWriter(file, true);
        for (int i = 0; i < 100000; i++){
            String line = generateRandomString(i + 1) + "\n";
            fr.write(line);
            System.out.println("String was appended:\n" + line);
        }
        fr.close();
    }

    private static String generateRandomString(int n){
        String AlphaNumericString =
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = (int)(AlphaNumericString.length() * Math.random());
            // add Character one by one in end of sb
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }
}
