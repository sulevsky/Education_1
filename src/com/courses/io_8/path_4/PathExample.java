package com.courses.io_8.path_4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {
    public static void main(String[] args) {
        //1 pathExample
//        pathExample();
        //2 no try with resources
//        noTryWithResourcesExample();
        //3 try with resources
        tryWithResourcesExample();

    }

    public static void pathExample() {
        Path path = Paths.get("resourses\\.\\wap.txt");
        System.out.println(path.toFile().exists());
        System.out.println(path.getFileSystem());
        System.out.println(path.normalize());
        System.out.println(path.toAbsolutePath());
        for (Path el : path.toAbsolutePath().normalize()) {
            System.out.println("--" + el);
        }
        System.out.println(path.getRoot());
        System.out.println(path.toAbsolutePath().getRoot());

        System.out.println(path.toAbsolutePath().getName(1));
        System.out.println(path.toAbsolutePath().getNameCount());

    }

    private static void noTryWithResourcesExample() {
        File file = new File("resourses\\wap.txt");
        String line;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            line = reader.readLine();
            System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static void tryWithResourcesExample() {
        File file = new File("resourses\\wap.txt");
        String line;
        try (BufferedReader reader=new BufferedReader(new FileReader(file))){
            line = reader.readLine();
            System.out.println(line);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
