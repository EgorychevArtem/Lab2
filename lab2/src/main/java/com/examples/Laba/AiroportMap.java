package com.examples.Laba;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AiroportMap extends Mapper <LongWritable, Text,WritableComparabl, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] str = value.toString().split("\",");
        if (key.get() > 0) {
            Text AiroportTitle = new Text(str[1].replaceAll("\"",""));
            int AiroportID = Integer.parseInt(str[0].replaceAll("\"",""));

            WritableComparabl Key = new WritableComparabl(AiroportID, 0);
            context.write(Key, AiroportTitle);
        }
    }
}
