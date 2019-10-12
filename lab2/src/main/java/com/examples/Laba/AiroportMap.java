package com.examples.Laba;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AiroportMap extends Mapper <LongWritable, Text,WritableComparable, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String str[] = value.toString().split("\", ");
        Text Airoport_title = new Text(str[0].replaceAll("\"", ""));
        int AiroportID = Integer.parseInt(str[0].replaceAll("\"", ""));

        WritableComparable Key = new WritableComparable(AiroportID, 0);
        context.write(Key,Airoport_title);
    }
}
