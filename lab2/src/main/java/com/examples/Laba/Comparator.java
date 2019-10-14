package com.examples.Laba;

//import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class Comparator extends WritableComparator {
    protected Comparator(){
        super((Class<? extends org.apache.hadoop.io.WritableComparable>) WritableComparable.class, true);
    }

    public int compare(WritableComparable first, WritableComparable second){
        return first.compareAiroport(second);
    }
}
