package dev.elma;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.Arrays;

public class VentMapper extends Mapper<IntWritable, Text,Text, DoubleWritable> {
    @Override
    protected void map(IntWritable key, Text value, Mapper<IntWritable, Text, Text, DoubleWritable>.Context context) throws IOException, InterruptedException {
        // date ville produit prix
        String[] row = value.toString().split(",");
        String city=row[1];
        Double price=Double.parseDouble(row[3]);
        context.write(new Text(city),new DoubleWritable(price));
    }
}
