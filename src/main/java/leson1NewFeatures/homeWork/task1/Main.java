package leson1NewFeatures.homeWork.task1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Main {
    //Задание 1
    //Реализовать паттерн Strategy для компрессии входящего OutputStream.    //
    //На выходе должен быть сжатый OutputStream в зависимости от
    // выбранного алгоритма zip/gzip.    //
    //Использовать лямбда-конструкции, как определяется источник данных,
    // выбор алгоритма (интерактив с консоли, запуск с параметрами, конфиг,..)
    // на свое усмотрение

    public static void main(String[] args) {

        FileInputStream file;
        Properties property = new Properties();

        try {
            file = new FileInputStream("config.properties.txt");
            property.load(file);

            Path inFile = Paths.get(property.getProperty("cv.inFile"));
            File outFile = new File(property.getProperty("cv.outFile"));
            String type = property.getProperty("cv.compressionType");

            if (type.equalsIgnoreCase("zip")) {
                Compressor compressor = new Compressor(new ZipCompression(
                        property.getProperty("cv.inFile")));
                compressor.compress(inFile,outFile);
            }
            if (type.equalsIgnoreCase("gzip")){
                Compressor compressor = new Compressor(new GzipCompression());
                compressor.compress(inFile,outFile);
            }
            else
                System.out.print("Wrong compression type");


        } catch (IOException e) {
        }
    }
}
