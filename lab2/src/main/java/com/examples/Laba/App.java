package com.examples.Laba;

import org.apache.hadoop.io.RawComparator;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        if (args.length != 3) {
            System.err.println("Usage: SortApp <input path flight> <input path airport> <output path>");
            System.exit(-1);

            Job job = Job.getInstance();
            job.setJarByClass(App.class);
            job.setJobName("JoinJob sort");
            MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, FlightMap.class);
            MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, AiroportMap.class);
            FileOutputFormat.setOutputPath(job, new Path(args[2]));

            job.setReducerClass(Reduce.class);
            job.setPartitionerClass(Partitioner.class);
            job.setGroupingComparatorClass((Class<? extends RawComparator>) Comparator.class);

            job.setMapOutputKeyClass(WritableComparable.class);
            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(Text.class);
            
            job.setNumReduceTasks(2);
            System.exit(job.waitForCompletion(true) ? 0 : 1);
        }
    }
}
