package dev.elma;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.HdfsConfiguration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        Configuration configuration=new Configuration();
        configuration.set("fs.defaultFS", "hdfs://localhost:8021");
        FileSystem fileSystem=FileSystem.get(configuration);
        Path path=new Path("SDIA/PYTHON/Cours/hello.txt");

        FSDataInputStream dataInputStream = fileSystem.open(path);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream, StandardCharsets.UTF_8));
        String row=null;

        while ((row=bufferedReader.readLine())!=null){
            System.out.println(row);
        }
        dataInputStream.close();
        fileSystem.close();

    }
}