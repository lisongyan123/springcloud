package com.example.java8.path;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWritter {
    public static void main(String[] args) {
        Path fpath=Paths.get("C:\\Users\\w\\Desktop\\create.txt");
        //创建文件
        if(!Files.exists(fpath)) {
            try {
                Files.createFile(fpath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //创建BufferedWriter
        try {
            BufferedWriter bfw=Files.newBufferedWriter(fpath);
            bfw.write("Files类的API:newBufferedWriter");
            bfw.flush();
            bfw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建BufferedReader
        try {
            BufferedReader bfr=Files.newBufferedReader(fpath);
            System.out.println(bfr.readLine());
            bfr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}