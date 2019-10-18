package com.examples.Laba;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class Reduce extends Reducer<WritableComparabl, Text,Text, Text> {
    protected void reduce(WritableComparabl key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        Iterator<Text> iter = values.iterator();
        Text AiroportTitle = new Text("Title: " + iter.next().toString());
        if (iter.hasNext()) {
            float current, min = 0.0f, max = 0.0f, sum = 0.0f;
            while (iter.hasNext()) {
                current = Float.parseFloat(iter.next().toString());
                if (current < min) {
                    min = current;
                } else if (current > max) {
                    max = current;
                }
                sum += current;
            }
            Text Result = new Text("min: " + Float.toString(min) + "max: " + Float.toString(max) + "sum: " + Float.toString(sum));
            context.write(AiroportTitle, Result);
        }
    }
}