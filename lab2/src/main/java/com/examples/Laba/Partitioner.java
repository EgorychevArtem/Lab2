package com.examples.Laba;

import org.apache.hadoop.io.Text;

public class Partitioner {

    public int Partitioner(WritableComparable key, Text value, int NumberTask){
        return key.AiroportID % NumberTask;
    }
}
