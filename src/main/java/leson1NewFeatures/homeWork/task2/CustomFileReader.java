package leson1NewFeatures.homeWork.task2;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomFileReader {

    public static void readWithInputStream(String fileName){

        try (Scanner scanner = new Scanner(
                new FileInputStream(fileName),
                StandardCharsets.UTF_8.name())) {
            long startTime = System.currentTimeMillis();
            int maxLength = 0;
            String line;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if (maxLength < line.length()){
                    maxLength = line.length();
                }
            }
            System.out.println("Максимальная длина строки в текстовом файле "
                    + fileName + " = " + maxLength);
            long endTime = System.currentTimeMillis();
            System.out.println("Время выполнения считывания файла = " +
                    (endTime - startTime) + " ms");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void readWithFileReader(String fileName) throws IOException {

        long startTime = System.currentTimeMillis();
        try(FileReader reader = new FileReader(fileName)){
            List<Character> listChar = new ArrayList<>();
            int count;
            while((count = reader.read()) != -1){
                listChar.add((char) count);
            }

            count = 0;
            int maxLength = 0;
            for (Character character : listChar)
                if (!character.equals('\n')) {
                    count++;
                } else {
                    if (maxLength < count) {
                        maxLength = count;
                    }
                    count = 0;
                }
            System.out.println("Максимальная длина строки в текстовом файле "
                    + fileName + " = " + maxLength);
            long endTime = System.currentTimeMillis();
            System.out.println("Время выполнения считывания файла = " +
                    (endTime - startTime) + " ms");

        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }


}
