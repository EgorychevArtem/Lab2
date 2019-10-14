package com.examples.Laba;

import org.apache.hadoop.io.Text;

public class Partitioner extends Partitioner<> {

    @Override
    public int getPartition(WritableComparable key, Text value, int NumberTask) {
        return return key.AiroportID % NumberTask;;
    }
}
