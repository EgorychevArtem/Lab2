package com.examples.Laba;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class Comparator extends WritableComparator {
    protected Comparator(){
        super(WritableComparable.class, true);
    }

    public int compare(WritableComparable first, WritableComparable second){
        com.examples.Laba.WritableComparable f =(com.examples.Laba.WritableComparable) first;
        com.examples.Laba.WritableComparable s =(com.examples.Laba.WritableComparable) second;
        return f.compareAiroport(s);
    }
}
