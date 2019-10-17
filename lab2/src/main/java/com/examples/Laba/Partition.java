package com.examples.Laba;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class Partition extends Partitioner<WritableComparabl,Text> {

    @Override
    public int getPartition(WritableComparabl key, Text value, int NumberTask) {
        return key.AiroportID % NumberTask;
    }
}
