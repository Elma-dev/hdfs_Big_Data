package dev.elma;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class SuccessMapper extends Mapper<LongWritable, Text,Text, IntWritable> {
    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context) throws IOException, InterruptedException {
        String row = value.toString();
        String[] info = row.split(" ");
        String ip = info[0].split(" -- ")[0];
        System.out.println("=> "+ info[8]);
        int state = Integer.parseInt(info[8])==200?1:0;
        context.write(new Text(ip),new IntWritable(state));
    }
}
