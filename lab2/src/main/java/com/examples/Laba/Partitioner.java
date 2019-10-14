package com.examples.Laba;

import org.apache.hadoop.io.Text;

public class Partitioner extends org.apache.hadoop.mapreduce.Partitioner {
    public int Partitioner(WritableComparable key, Text value, int NumberTask){
        return key.AiroportID % NumberTask;
    }

    @Override
    public int getPartition(Object o, Object o2, int i) {
        return return key.AiroportID % NumberTask;;
    }
}
