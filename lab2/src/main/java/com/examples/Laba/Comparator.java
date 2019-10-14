package com.examples.Laba;

public class Comparator extends WritableComparable{
    protected Comparator(){
        super(WritableComparable.class, true);
    }

    public int compare(WritableComparable first, WritableComparable second){
        return first.compareAiroport(second);
    }
}
