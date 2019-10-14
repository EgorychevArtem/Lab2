package com.examples.Laba;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class Partition extends Partitioner<WritableComparable,Text> {

    @Override
    public int getPartition(WritableComparable key, Text value, int NumberTask) {
        return key.AiroportID % NumberTask;
    }
}
