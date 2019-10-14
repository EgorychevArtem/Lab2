package com.examples.Laba;

import org.apache.hadoop.mapreduce.Job;

public class App {
    public static void main(String[] args){
        if (args.length != 3) {
            System.err.println("Usage: SortApp <input path flight> <input path airport> <output path>");
            System.exit(-1);

            Job job = Job.getInstance();
            job.setJarByClass(JoinJob.class);
            job.setJobName("JoinJob sort");
            MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, CallsJoinMapper.class);
            MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, SystemsJoinMapper.class);
            FileOutputFormat.setOutputPath(job, new Path(args[2]));
            job.setPartitionerClass(TextPair.FirstPartitioner.class);
            job.setGroupingComparatorClass(TextPair.FirstComparator.class);
            job.setReducerClass(JoinReducer.class);
            job.setMapOutputKeyClass(TextPair.class);
            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(Text.class);
            job.setNumReduceTasks(2);
            System.exit(job.waitForCompletion(true) ? 0 : 1);
        }
    }
}
