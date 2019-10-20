package com.examples.Laba;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AiroportMapper extends Mapper <LongWritable, Text,WritableComparabl, Text> {
    private static int AIROPORT_ID= 0;
    private static int AIROPORT_TITLE = 1;
    private static String QUOTE = "\"";
    private static String EMPTY = "";
    private static String DELIMETR = "\",";

    public static String remove_quote(String str){
        return str.replaceAll(QUOTE,EMPTY);
    }

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] str = value.toString().split(DELIMETR);
        if (key.get() > 0) {
            Text AiroportTitle = new Text(remove_quote(str[AIROPORT_TITLE]));
            int AiroportID = Integer.parseInt(remove_quote(str[AIROPORT_ID]));

            WritableComparabl Key = new WritableComparabl(AiroportID, 0);
            context.write(Key, AiroportTitle);
        }
    }
}
