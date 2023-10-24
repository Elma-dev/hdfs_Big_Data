package dev.elma;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Application {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        // Press Opt+Enter with your caret at the highlighted text to see how
        Configuration conf=new Configuration();
        // IntelliJ IDEA suggests fixing it.
        Job job=Job.getInstance(conf);
        //les classes Mapper et Reducer
        job.setMapperClass(VentMapper.class);
        job.setReducerClass(VentReduce.class);
        //les types de sortie de la fonction map
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(DoubleWritable.class);
        //les types de sotie du job
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(DoubleWritable.class);
        //le fomat input
        job.setInputFormatClass(TextInputFormat.class);
        //le path des fichiers input/output
        FileInputFormat.addInputPath(job,new Path(args[0]));
        FileOutputFormat.setOutputPath(job,new Path(args[1]));

        job.waitForCompletion(true);
    }
}