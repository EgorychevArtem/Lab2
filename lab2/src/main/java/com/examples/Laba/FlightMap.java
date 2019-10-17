package com.examples.Laba;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;


public class FlightMap extends Mapper<LongWritable, Text, WritableComparabl, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] str = value.toString().split(",");
        float delay = Float.parseFloat(String.valueOf(str));
        if(delay > 0.0f){
            int AiroportID = Integer.parseInt(str[14]);
            WritableComparabl Key = new WritableComparabl(AiroportID, 1);
            context.write(Key, new Text(str[18]));
        }
    }
}
