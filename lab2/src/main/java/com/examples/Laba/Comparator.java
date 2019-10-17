package com.examples.Laba;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class Comparator extends WritableComparator {
    protected Comparator(){
        super(WritableComparable.class, true);
    }

    public int compare(WritableComparable first, WritableComparable second){
        WritableComparabl f =(WritableComparabl) first;
        WritableComparable s =(WritableComparabl) second;
        return f.compareAiroport((WritableComparabl) s);
    }
}
