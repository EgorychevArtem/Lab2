package com.examples.Laba;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class Reduce extends Reducer<Text, IntWritable,Text, LongWritable> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        Iterator<IntWritable> iter = values.iterator();
        float min = 0.0f, max = 0.0f, sum = 0.0f;
        while(iter.hasNext()){
            float current = Float.parseFloat(iter.next().toString());
            if (current < 0.0f){
                min = current;
            } else if(max > current){
                max = current;
            }
            sum += current;
        }
        Text Min, Max,
    }
}
