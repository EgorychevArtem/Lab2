package com.examples.Laba;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.util.Optional;
import java.io.IOException;

public class FlightMapper extends Mapper<LongWritable, Text, WritableComparabl, Text> {
    private static int AIROPORT_CODE= 14;
    private static int AIROPORT_DELAY= 18;
    private static String COMMA = ",";

    private Optional<String> getOptionalDelayString(String str){
        if(str.isEmpty() || Float.parseFloat(str) < 0.0f) {
            return Optional.empty();
        } else {
            return Optional.of(str);
        }
    }

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] str = value.toString().split(COMMA);
        if (key.get() > 0) {
            int AiroportID = Integer.parseInt(str[AIROPORT_CODE]);
            Optional<String> delay = getOptionalDelayString(str[AIROPORT_DELAY]);
            if (delay.isPresent()) {
                WritableComparabl Key = new WritableComparabl(AiroportID, 1);
                context.write(Key, new Text(delay.get()));
            }
        }
    }
}
