package leson1NewFeatures.homeWork.task2;

import java.io.IOException;

public class Main {
    //Задание 2
    //Найти максимальную длину строки в текстовом файле,
    // разделителем считаем '\n'.    //
    //Предложить два наиболее оптимальных решения и
    // добавить сравнительный benchmark.    //
    //При загрузке данных помнить что файлы бывают большими..

    public static void main(String[] args) {
        //Генерация большого файла
//        try {
//            AppendOperation.append("test.txt");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        CustomFileReader.readWithInputStream("test.txt");
        try {
            CustomFileReader.readWithFileReader("test.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
